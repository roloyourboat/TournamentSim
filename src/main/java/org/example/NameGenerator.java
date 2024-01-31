package org.example;

import java.util.Random;

public class NameGenerator {

        // Generate a random warrior name
        public static String generateWarriorName() {
            String[] warriorNames = {"Aldric", "Siegfried", "Valeria", "Thrain"};

            // Implement random selection logic
            int randomIndex = new Random().nextInt(warriorNames.length);
            return warriorNames[randomIndex];
        }

}
