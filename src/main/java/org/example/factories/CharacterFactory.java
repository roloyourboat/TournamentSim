package org.example.factories;

import org.example.archetypes.GameCharacter;
import org.example.enums.Archetype;
import org.example.enums.Rank;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

//public interface CharacterFactory {
//    Character createCharacter(Rank rank);
//}

public class CharacterFactory {
    public static GameCharacter createCharacter(Rank rank, Archetype archetype) {
        try {
            // Assuming all enemy classes are in the same package
            String packageName = GameCharacter.class.getPackage().getName();
            String className = archetype.enumToClassName();
            System.out.println("Char Package: "+packageName +"Class Name: "+ className);
            Class<?> charClass = Class.forName(packageName + "." + className);
            Constructor<?> constructor = charClass.getDeclaredConstructor(Rank.class);
            constructor.setAccessible(true);
            Object instance = constructor.newInstance(rank);
            return (GameCharacter) instance;

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Error creating Character instance for archetype: " + archetype, e);
        }
    }
}