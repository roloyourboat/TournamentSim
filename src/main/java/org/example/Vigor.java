package org.example;

import org.example.enums.Archetype;
import org.example.enums.Comparison;
import org.example.enums.Magnitude;
import org.example.enums.VigorState;

import java.util.HashMap;
import java.util.Map;

public class Vigor {
    private static final Map<Archetype, Map<VigorState, Magnitude>> DEFAULT_VIGOR_THRESHOLDS;
    private Map<VigorState, Magnitude> maxThresholds;

    private Magnitude currentThreshold;
    private VigorState currentVigorState;

    static {
        DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    }

    public Vigor() {
        maxThresholds = new HashMap<>();
        currentVigorState = VigorState.UNHARMED;
        for (VigorState state : VigorState.values()) {
            maxThresholds.put(state, Magnitude.MODERATE);
        }

    }

    public Vigor(Map<VigorState, Magnitude> customThresholds) {
        maxThresholds = new HashMap<>(customThresholds); // Use custom thresholds
        currentVigorState = VigorState.UNHARMED;
        currentThreshold = maxThresholds.get(currentVigorState);
    }

    public void resetVigor(){
        currentVigorState = VigorState.UNHARMED;
        currentThreshold = maxThresholds.get(currentVigorState);
    }


    public static Vigor getDefaultVigor(Archetype archetype) {
        Map<VigorState, Magnitude> thresholds = DEFAULT_VIGOR_THRESHOLDS.get(archetype);
        if (thresholds != null) {
            for (VigorState state : VigorState.values()) {
                thresholds.putIfAbsent(state, Magnitude.MODERATE);
            }
            return new Vigor(thresholds);
        } else {
            return new Vigor(); // Return a default Vigor if thresholds are not available
        }
    }

    private static Map<Archetype, Map<VigorState, Magnitude>> initialiseDefaultVigorThresholds() {
        try {
            Map<Archetype, Map<VigorState, Magnitude>> thresholdsToMap = new HashMap<>();
            for (Archetype archetype : Archetype.values()) {

                // Construct the class name for the archetype
                String className = "org.example.archetypes." + archetype.enumToClassName();

                // Load the archetype class using reflection
                Class<?> archetypeClass = Class.forName(className);

                // Access the DEFAULT_VIGOR_THRESHOLDS static field using reflection
                Map<VigorState, Magnitude> thresholds = (Map<VigorState, Magnitude>)
                        archetypeClass.getDeclaredField("DEFAULT_VIGOR_THRESHOLDS").get(null);

                System.out.println(className + " : " + thresholds);
                // Add the thresholds to the map
                thresholdsToMap.put(archetype, thresholds);


            }
            return thresholdsToMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public Vigor calculateImpactToVigor(Magnitude potentialImpact){

        Map<VigorState, Magnitude> vigorStatus = new HashMap<>();
        Comparison potentialImpactToCurrentVigorThreshold = potentialImpact.compare(currentThreshold);
//        System.out.println("Comparison: "+potentialImpactToCurrentVigorThreshold);

        switch (potentialImpactToCurrentVigorThreshold){
            case LESS_THAN:
                int magnitudeDifference = potentialImpact.getDifference(currentThreshold);
//                System.out.println("Mag Dif: "+magnitudeDifference);
                for(int ordinalReductionCounter=currentThreshold.ordinal(); ordinalReductionCounter>magnitudeDifference;ordinalReductionCounter--) {
//                    System.out.println("Counter: "+ordinalReductionCounter);
                    currentThreshold = Magnitude.reduceMagnitude(currentThreshold);
                }
                break;
            case EQUAL:
//                System.out.println("Equal");
                boolean chanceToChangeVigorState = getChanceToChangeVigorState(currentThreshold);
                if(chanceToChangeVigorState){
//                    System.out.println("Vig Before:"+currentVigorState);
                    currentVigorState = reduceVigorState(currentVigorState);
                    currentThreshold = updateThresholdToCurrentMax(currentVigorState);
//                    System.out.println("Vig After:"+currentVigorState);
                }else{
                    int currentMagnitudeOrdinal = potentialImpact.ordinal();
                    for(int ordinalReductionCounter=currentMagnitudeOrdinal; ordinalReductionCounter>=2; ordinalReductionCounter--) {
                        currentThreshold = Magnitude.reduceMagnitude(currentThreshold);
                    }
                }
                break;
            case GREATER_THAN:
//                System.out.println("Greater Than");
//                System.out.println("Vig Before:"+currentVigorState);
                currentVigorState = reduceVigorState(currentVigorState);
                currentThreshold = updateThresholdToCurrentMax(currentVigorState);
//                System.out.println("Vig After:"+currentVigorState);
                break;


        }

        //I want to return current State and current Threshold
        // TODO break up my damagedEvent class to be called form in here also

        vigorStatus.put(currentVigorState, currentThreshold);
        //return vigorStatus;
        return this;
    }

    private Magnitude updateThresholdToCurrentMax(VigorState currentVigorState) {
//        System.out.println("Updating threshold");
        return this.maxThresholds.get(currentVigorState);
    }
    private VigorState reduceVigorState(VigorState currentVigorState) {
//        System.out.println("Reducing Vigor");
        return currentVigorState.reduceVigorState();
    }

    private boolean getChanceToChangeVigorState(Magnitude currentThreshold) {
        double chanceModifier = 1 - currentThreshold.getUpperPercentageThreshold();
        double randomValue = Math.random();
//        System.out.println("Chance Modifier: "+chanceModifier);
//        System.out.println("Random Value: "+randomValue);
        if(randomValue < chanceModifier)
            return true;
        else
            return false;
    }

    public Map<VigorState, Magnitude> getMaxThresholds() {
        return maxThresholds;
    }

    public void setMaxThresholds(Map<VigorState, Magnitude> maxThresholds) {
        this.maxThresholds = maxThresholds;
    }

    public Magnitude getCurrentThreshold() {
        return currentThreshold;
    }

    public void setCurrentThreshold(Magnitude currentThreshold) {
        this.currentThreshold = currentThreshold;
    }

    public VigorState getCurrentVigorState() {
        return currentVigorState;
    }

    public void setCurrentVigorState(VigorState currentVigorState) {
        this.currentVigorState = currentVigorState;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Current Vigor State: ").append(currentVigorState).append("\n");
        sb.append("Current Threshold: ").append(currentThreshold).append("\n");
        sb.append("Max Thresholds:\n\t");
        for (Map.Entry<VigorState, Magnitude> entry : maxThresholds.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n\t");
        }
        return sb.toString();
    }


}
