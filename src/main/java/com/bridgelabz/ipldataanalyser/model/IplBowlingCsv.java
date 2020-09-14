package com.bridgelabz.ipldataanalyser.model;

import com.opencsv.bean.CsvBindByName;

public class IplBowlingCsv {

    @CsvBindByName(column = "POS", required = true)
    public int slNo;

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double Avg;

    @CsvBindByName(column = "SR", required = true)
    public String SR;

    @CsvBindByName(column = "Econ", required = true)
    public String Econ;

    @CsvBindByName(column = "Wkts", required = true)
    public String Wkts;

    @CsvBindByName(column =  "4w", required = true)
    public int highest4W;
    @CsvBindByName(column =  "5w", required = true)
    public int highest5W;

    @Override
    public String toString() {
        return "IplBowlingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
                ", Avg=" + Avg +
                ", SR='" + SR + '\'' +
                ", Econ='" + Econ + '\'' +
                ", Wkts='" + Wkts + '\'' +
                ", highest4W=" + highest4W +
                ", highest5W=" + highest5W +
                '}';
    }
}
