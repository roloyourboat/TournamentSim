package org.example;

import java.util.ArrayList;
import java.util.List;

public class CombatMoves {
    private List<CombatMove> moves;

    public CombatMoves() {
        moves = new ArrayList<>();
        // Initialize the list of combat moves here
    }

    public void addCombatMove(CombatMove move) {
        moves.add(move);
    }

    public List<CombatMove> getMoves() {
        return moves;
    }

    public static CombatMove convertPOJOToMove(CombatMovePOJO movePOJO) {
        return new CombatMove(
                movePOJO.getName(),
                movePOJO.getMoveType(),
                movePOJO.getMainStat(),
                movePOJO.getSecondaryStat(),
                movePOJO.getFallibility(),
                movePOJO.getPerfection(),
                movePOJO.getGainStatus(), // You can set this based on your class structure
                movePOJO.getGiveStatus()  // You can set this based on your class structure
        );
    }

    public void addMove(CombatMove newMove) {
        moves.add(newMove);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CombatMoves: [\n");
        for (CombatMove move : moves) {
            sb.append("\t").append(move.toString()).append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
