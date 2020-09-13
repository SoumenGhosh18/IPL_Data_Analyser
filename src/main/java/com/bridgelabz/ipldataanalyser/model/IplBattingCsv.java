package com.bridgelabz.ipldataanalyser.model;
import com.opencsv.bean.CsvBindByName;
public class IplBattingCsv {
    @CsvBindByName(column = "POS", required = true)
    public int slNo;
    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;
    @CsvBindByName(column = "Avg", required = true)
    public double avg;
    @CsvBindByName(column = "SR", required = true)
    public double sr;

    @Override
    public String toString() {
        return "IplBattingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                ", avg=" + avg +
                ", sr=" + sr +
                '}';
    }
}

