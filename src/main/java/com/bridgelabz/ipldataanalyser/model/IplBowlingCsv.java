package com.bridgelabz.ipldataanalyser.model;

import com.opencsv.bean.CsvBindByName;
//Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w,
public class IplBowlingCsv {
    @CsvBindByName(column = "POS", required = true)
    public int slNo;
    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

//    @CsvBindByName(column = "4w", required = true)
//    public String 4w;

    @CsvBindByName(column = "Avg", required = true)
    public double Avg;
    @CsvBindByName(column = "SR", required = true)
    public String SR;

    @CsvBindByName(column = "Econ", required = true)
    public String Econ;


    @CsvBindByName(column = "Wkts", required = true)
    public String Wkts;


    @Override
    public String toString() {
        return "IplBowlingCsv{" +
                "slNo=" + slNo +
                ", playerName='" + playerName + '\'' +
               ", Wkts='" + Wkts + '\'' +
                ", Avg='" + Avg + '\'' +
                ", SR='" + SR + '\'' +
                ", Econ='" + Econ + '\'' +
                '}';
    }
}
