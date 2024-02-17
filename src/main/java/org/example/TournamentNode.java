package org.example;

import org.example.combat.Battle;
import org.example.enums.TournamentLevel;

import java.util.ArrayList;
import java.util.List;

public class TournamentNode {

    Battle battle;
    TournamentLevel tournamentLevel;
    TournamentNode leftNode, rightNode;

    public  TournamentNode(TournamentLevel tournamentLevel){
        this.tournamentLevel = tournamentLevel;
        this.leftNode = null;
        this.rightNode = null;

    }

    public void addNodes(TournamentLevel tournamentLevel){
        this.leftNode = new TournamentNode(tournamentLevel);
        this.rightNode = new TournamentNode(tournamentLevel);
    }

    public void assignToBattle(){

    }


}
