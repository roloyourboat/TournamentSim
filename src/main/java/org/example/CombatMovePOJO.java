package org.example;

import org.example.enums.Magnitude;
import org.example.enums.MoveType;
import org.example.enums.StatName;

import java.util.Arrays;

public class CombatMovePOJO {
    private String name;
    private MoveType moveType;
    private StatName mainStat;
    private StatName secondaryStat;
    private Magnitude fallibility;
    private Magnitude perfection;
    private Status[] gainStatus;
    private Status[] giveStatus;

    // Constructors
    public CombatMovePOJO() {
    }

    public CombatMovePOJO(String name, MoveType moveType, StatName mainStat, StatName secondaryStat,
                          Magnitude fallibility, Magnitude perfection, Status[] gainStatus, Status[] giveStatus) {
        this.name = name;
        this.moveType = moveType;
        this.mainStat = mainStat;
        this.secondaryStat = secondaryStat;
        this.fallibility = fallibility;
        this.perfection = perfection;
        this.gainStatus = gainStatus;
        this.giveStatus = giveStatus;
    }

    // Getters and setters for each field
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public StatName getMainStat() {
        return mainStat;
    }

    public void setMainStat(StatName mainStat) {
        this.mainStat = mainStat;
    }

    public StatName getSecondaryStat() {
        return secondaryStat;
    }

    public void setSecondaryStat(StatName secondaryStat) {
        this.secondaryStat = secondaryStat;
    }

    public Magnitude getFallibility() {
        return fallibility;
    }

    public void setFallibility(Magnitude fallibility) {
        this.fallibility = fallibility;
    }

    public Magnitude getPerfection() {
        return perfection;
    }

    public void setPerfection(Magnitude perfection) {
        this.perfection = perfection;
    }

    public Status[] getGainStatus() {
        return gainStatus;
    }

    public void setGainStatus(Status[] gainStatus) {
        this.gainStatus = gainStatus;
    }

    public Status[] getGiveStatus() {
        return giveStatus;
    }

    public void setGiveStatus(Status[] giveStatus) {
        this.giveStatus = giveStatus;
    }

    // toString method for debugging or printing
    @Override
    public String toString() {
        return "CombatMovePOJO{" +
                "name='" + name + '\'' +
                ", moveType=" + moveType +
                ", mainStat=" + mainStat +
                ", secondaryStat=" + secondaryStat +
                ", fallibility=" + fallibility +
                ", perfection=" + perfection +
                ", gainStatus=" + Arrays.toString(gainStatus) +
                ", giveStatus=" + Arrays.toString(giveStatus) +
                '}';
    }

    // Other methods as needed
}
