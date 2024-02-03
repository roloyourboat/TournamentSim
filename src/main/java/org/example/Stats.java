package org.example;

import org.example.enums.Archetype;
import org.example.enums.Rank;
import org.example.enums.StatName;
import org.example.enums.VigorState;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

    public class Stats {
        private Map<StatName, Stat> stats;
        private static final Map<Archetype,Map<StatName, Stat>> DEFAULT_STATS;

        static{
            DEFAULT_STATS = initializeDefaultStats();
        }

        public Stats(Rank rank, Archetype archetype) {
            stats = new HashMap<>();

            // Use the reflection-based approach to retrieve default stats for the archetype
            Map<StatName, Stat> defaultStats = getDefaultStatsForArchetype(archetype);

            // Copy the default stats to the stats map
            stats.putAll(defaultStats);


            for (StatName statName : StatName.values()) {
                stats.putIfAbsent(statName, new Stat(statName, 10.0, Magnitude.MODERATE, Magnitude.MODERATE));

                //public Stat(StatName name, double baseValue, Magnitude proficiencyMagnitude, Magnitude varianceMagnitude)
            }

        }


        private Map<StatName, Stat> getDefaultStatsForArchetype(Archetype archetype) {
            return DEFAULT_STATS.getOrDefault(archetype, new HashMap<>());
        }
        public Stat getStat(StatName name) {
            return stats.get(name);
        }

        public void setStat(StatName name, Stat stat) {
            stats.put(name, stat);
        }

        private static Map<Archetype,Map<StatName, Stat>> initializeDefaultStats() {
            try {
                Map<Archetype,Map<StatName, Stat>> statsMapToReturn = new HashMap<>();
                for (Archetype archetype : Archetype.values()) {
                    // Construct the class name for the archetype
                    String className = "org.example.archetypes." + archetype.enumToClassName();

                    // Load the archetype class using reflection
                    Class<?> archetypeClass = Class.forName(className);

                    // Access the DEFAULT_STATS static field using reflection
                    Map<StatName, Stat> stats = (Map<StatName, Stat>)
                            archetypeClass.getDeclaredField("DEFAULT_STATS").get(null);

                    System.out.println(className + " : " + stats);
                    // Add the stats to the map
                    statsMapToReturn.put(archetype, stats);
                }
                return statsMapToReturn;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        // Override toString method to print the stats
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Stats:\n\t");

            for (Map.Entry<StatName, Stat> entry : stats.entrySet()) {
                StatName statName = entry.getKey();
                Stat stat = entry.getValue();

                sb.append(statName).append(": ").append(stat.getBaseValue());

                // Optionally, you can include additional information such as proficiencyMagnitude and varianceMagnitude here.

                sb.append("\n\t");
            }

            return sb.toString();
        }
    }