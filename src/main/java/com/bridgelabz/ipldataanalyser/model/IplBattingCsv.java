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
    @CsvBindByName(column = "6s", required = true)
    public int highest6s;
    @CsvBindByName(column = "4s", required = true)
    public int highest4s;
    @CsvBindByName(column = "Inns", required = true)
    public int Inns;
    @CsvBindByName(column = "Runs", required = true)
    public int Runs;

    @Override
    public String toString() {
        return "IplBattingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                ", avg=" + avg +
                ", sr=" + sr +
                ", highest6s=" + highest6s +
                ", highest4s=" + highest4s +
                ", Inns=" + Inns +
                ", Runs=" + Runs +
                '}';
    }
}

