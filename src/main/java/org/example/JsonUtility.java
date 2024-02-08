package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.combat.CombatMoves;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class JsonUtility {
    private static final Gson gson = new Gson();

    // Serialize an object to JSON
    public static String serialize(Object obj) {
        return gson.toJson(obj);
    }

    // Deserialize JSON to an object of the specified class
    public static <T> T deserialize(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }

    public static CombatMoves getCombatMovesFromJSON(String jsonString) {
        InputStream inputStream = App.class.getResourceAsStream(jsonString);
        List<CombatMovePOJO> movesPOJO = gson.fromJson(new InputStreamReader(inputStream), new TypeToken<List<CombatMovePOJO>>() {}.getType());
        CombatMoves movesToReturn = new CombatMoves();
        for(CombatMovePOJO movePOJO:movesPOJO)
        {
            movesToReturn.addMove(CombatMoves.convertPOJOToMove(movePOJO));
        }
        return movesToReturn;
    }
}
