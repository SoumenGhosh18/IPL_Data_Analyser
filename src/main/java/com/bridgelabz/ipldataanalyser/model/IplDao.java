package com.bridgelabz.ipldataanalyser.model;

public class IplDao {
    public int slNO;
    public String playerName;
    public double avg;
    public double sr;
    public int highest6s;
    public int highest4s;
    public int Inns;
    public int Runs;
    public double Avg;
    public String Econ;
    public String SR;
    public String Wkts;
    public int max100;
    public int max50;
    public int highest4W;
    public int highest5W;

    public IplDao(IplBattingCsv iplBattingCsv) {
        slNO = iplBattingCsv.slNo;
        playerName = iplBattingCsv.playerName;
        avg = iplBattingCsv.avg;
        sr = iplBattingCsv.sr;
        highest6s = iplBattingCsv.highest6s;
        highest4s = iplBattingCsv.highest4s;
        Inns = iplBattingCsv.Inns;
        Runs = iplBattingCsv.Runs;
        max50 = iplBattingCsv.max50;
        max100 = iplBattingCsv.max100;
    }

    public IplDao(IplBowlingCsv iplBowlingCsv) {
        slNO = iplBowlingCsv.slNo;
        Avg = iplBowlingCsv.Avg;
        playerName = iplBowlingCsv.playerName;
        Econ = iplBowlingCsv.Econ;
        SR = iplBowlingCsv.SR;
        Wkts = iplBowlingCsv.Wkts;
        highest4W = iplBowlingCsv.highest4W;
        highest5W = iplBowlingCsv.highest5W;

    }
}
