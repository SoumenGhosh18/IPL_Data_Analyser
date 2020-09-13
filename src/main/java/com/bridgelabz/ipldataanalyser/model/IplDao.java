package com.bridgelabz.ipldataanalyser.model;
//Mat,Inns,Ov,Runs,Wkts,BBI,Avg,Econ,SR,4w,5w,
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
        Avg = iplBowlingCsv.Avg;
        playerName = iplBowlingCsv.playerName;

        //  Econ = iplBowlingCsv.Econ;
       SR = iplBowlingCsv.SR;

    }
}
