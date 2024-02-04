package org.example;

 import org.example.archetypes.Character;
 import org.example.enums.Archetype;
 import org.example.enums.Rank;
 import org.example.factories.CharacterFactory;  // Import your CharacterFactory interface

import java.lang.reflect.Constructor;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

public class CharacterGenerator {
        private Map<Archetype, CharacterFactory> factoryMap;

        public CharacterGenerator() {
            factoryMap = new HashMap<>();
            initializeFactories();
        }

        private void initializeFactories() {
            // Define the base package where your archetype and factory classes are located
            String archetypePackage = "org.example.archetypes"; // Replace with your actual package name
            String factoryPackage = "org.example.factories"; // Replace with your actual package name


            // Define the factory class suffix (e.g., WarriorFactory, MageFactory)
            String factorySuffix = "Factory"; // Adjust if needed

            // Iterate through the Archetype enum values
            for (Archetype archetype : Archetype.values()) {
                try {
                    // Construct the archetype class name using the naming convention
                    String archetypeClassName = archetypePackage + "." + archetype.enumToClassName();
                    // Construct the factory class name using the naming convention
                    String factoryClassName = factoryPackage + "." + archetype.enumToClassName() + factorySuffix;

                    // Load the archetype class
                    Class<?> archetypeClass = Class.forName(archetypeClassName);

                    // Load the factory class
                    Class<?> factoryClass = Class.forName(factoryClassName);

                    // Get the constructor of the factory class
                    Constructor<?> factoryConstructor = factoryClass.getDeclaredConstructor();

                    // Create an instance of the factory
                    CharacterFactory factory = (CharacterFactory) factoryConstructor.newInstance();

                    // Add the factory to the factory map
                    factoryMap.put(archetype, factory);
                } catch (Exception e) {
                    // Handle any exceptions (e.g., class not found, constructor not found, instantiation error)
                    e.printStackTrace();
                }
            }
        }

        // Rest of your CharacterGenerator class



    public List<? extends Character> generateRandomCharacters(int numberToGenerate, Rank rank) {
        // Implementation for generating random characters of same rank
        List<Character> characters = new ArrayList<>();


        // Generate random characters
        for (int i = 0; i < numberToGenerate; i++) {
            Archetype randomArchetype = Archetype.getRandomArchetype();


            // Create a character using the corresponding factory
            CharacterFactory factory = factoryMap.get(randomArchetype);
            if (factory != null) {
                characters.add(factory.createCharacter(rank));
            }
        }

        return characters;
    }

    public Character generateArchetype(Archetype archetype, Rank rank) {
        // Create a character of the specified archetype and rank
        CharacterFactory factory = factoryMap.get(archetype);
        if (factory != null) {
            return factory.createCharacter(rank);
        }

        return null; // Handle if the factory is not found
    }


}