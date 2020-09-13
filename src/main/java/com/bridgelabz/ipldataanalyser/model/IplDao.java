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
    public IplDao(IplBattingCsv iplBattingCsv) {
        slNO = iplBattingCsv.slNo;
        playerName = iplBattingCsv.playerName;
        avg = iplBattingCsv.avg;
        sr = iplBattingCsv.sr;
        highest6s = iplBattingCsv.highest6s;
        highest4s = iplBattingCsv.highest4s;
        Inns =iplBattingCsv.Inns;
        Runs =iplBattingCsv.Runs;
    }

    public IplDao(IplBowlingCsv iplBowlingCsv){
        slNO = iplBowlingCsv.slNo;
        playerName = iplBowlingCsv.playerName;
    }
}
