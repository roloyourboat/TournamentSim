package org.example;

import org.example.enums.Archetype;
import org.example.enums.VigorState;

import java.util.HashMap;
import java.util.Map;

public class Vigor {
    private static Map<Archetype, Map<VigorState, Magnitude>> DEFAULT_VIGOR_THRESHOLDS = new HashMap<>();
    private Map<VigorState, Magnitude> maxThresholds;
    private Magnitude currentThreshold;
    private VigorState currentVigorState;

    static {
        initialiseDefaultVigorThresholds();
    }

    public Vigor(){
        maxThresholds = new HashMap<>();
        currentVigorState = VigorState.UNHARMED;
        for (VigorState state : VigorState.values()) {
            maxThresholds.put(state, Magnitude.MODERATE);
        }

    }

    public Vigor(Map<VigorState, Magnitude> customThresholds) {
        maxThresholds = new HashMap<>(customThresholds); // Use custom thresholds
        currentVigorState = VigorState.UNHARMED;
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

    private static void initialiseDefaultVigorThresholds() {
        try {
            for (Archetype archetype : Archetype.values()) {
                // Construct the class name for the archetype
                String className = "org.example.archetypes." + archetype.enumToClassName();

                // Load the archetype class using reflection
                Class<?> archetypeClass = Class.forName(className);

                // Access the DEFAULT_VIGOR_THRESHOLDS static field using reflection
                Map<VigorState, Magnitude> thresholds = (Map<VigorState, Magnitude>)
                        archetypeClass.getDeclaredField("DEFAULT_VIGOR_THRESHOLDS").get(null);

                System.out.println(className+" : "+thresholds);
                // Add the thresholds to the map
                DEFAULT_VIGOR_THRESHOLDS.put(archetype, thresholds);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
