package com.bridgelabz.ipldataanalyser.model;

public class IplDao {
    public int slNO;
    public String playerName;
    public double avg;

    public IplDao(IplBattingCsv iplBattingCsv) {
        slNO = iplBattingCsv.slNo;
        playerName = iplBattingCsv.playerName;
        avg = iplBattingCsv.avg;
    }

    public IplDao(IplBowlingCsv iplBowlingCsv){
        slNO = iplBowlingCsv.slNo;
        playerName = iplBowlingCsv.playerName;
    }
}
