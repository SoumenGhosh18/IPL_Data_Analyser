package com.bridgelabz.ipldataanalyser.model;
import com.opencsv.bean.CsvBindByName;
public class IplBattingCsv {
    @CsvBindByName(column = "POS", required = true)
    public int slNo;
    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;
    @CsvBindByName(column = "Avg", required = true)
    public double avg;

    @Override
    public String toString() {
        return "IplBattingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                ", avg='" + avg + '\'' +
                '}';
    }
}
