package com.bridgelabz.ipldataanalyser;

import com.bridgelabz.ipldataanalyser.exception.IplAnalyserException;
import com.bridgelabz.ipldataanalyser.model.IplBattingCsv;
import com.bridgelabz.ipldataanalyser.service.IplAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class IplAnalyserTest {
    private final String IPL_BATTING_FILE_PATH = "E:\\IPL_Data_Analyser\\src\\test\\resources\\IplMostRuns.csv";
    private final String IPL_BOWLING_FILE_PATH = "E:\\IPL_Data_Analyser\\src\\test\\resources\\IplMostWicket.csv";

    @Test
    public void IplBattingDataShouldReturnCorrectRecords() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            int numOfEntries = iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            Assert.assertEquals(100, numOfEntries);
        } catch (IplAnalyserException e) {
            e.printStackTrace();

        }
    }
    @Test
    public void IplBowlingDataShouldReturnCorrectRecords() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            int numOfEntries = iplAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            Assert.assertEquals(99, numOfEntries);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplBestBattingAvgDataShouldReturnCorrectResult() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getBestBattingAvg();
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("MS Dhoni", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplBestBattingSRDataShouldReturnCorrectResult() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getBestBattingSR();
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Andre Russell", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIplHighest6sDataShouldReturnCorrectResult() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getHighest6s();
            String sortedCensusData1 = iplAnalyser.getHighest4s();
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            IplBattingCsv censusCsv1[] = new Gson().fromJson(sortedCensusData1, IplBattingCsv[].class);
            Assert.assertEquals("Andre Russell", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

}
