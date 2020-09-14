package com.bridgelabz.ipldataanalyser;

import com.bridgelabz.ipldataanalyser.exception.IplAnalyserException;
import com.bridgelabz.ipldataanalyser.model.IplBattingCsv;
import com.bridgelabz.ipldataanalyser.model.IplBowlingCsv;
import com.bridgelabz.ipldataanalyser.service.IplAnalyser;
import com.bridgelabz.ipldataanalyser.utility.EnumSorting;
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
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.TOP_BAT_AVG);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("MS Dhoni", censusCsv[0].playerName);
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
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.MAX_6s_4s);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Andre Russell", censusCsv[0].playerName);
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
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.TOP_BAT_SR);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Ishant Sharma", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIplBestBattingSRDataWith6sAnd4s() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.MAX_6s_4s_With_SR);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Ishant Sharma", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenIPLMostAvg_WhoHad_GreatAverageWithBestStrikeRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.TOP_BAT_AVG_WITH_BEST_SR);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Andre Russell", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostRuns_ShouldReturnCricketerWhoHad_GreatAverageWithBestStrikeRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.TOP_RUNS_OF_PLAYER);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("David Warner", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLMostWicketsCSVFile_ShouldReturn_BestBowlingAverage() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.BEST_BOWL_AVG);
            IplBowlingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
            Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLData_Should_Return_Top_StrikeRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.BEST_BOWL_SR);
            IplBowlingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
            Assert.assertEquals("Prasidh Krishna", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLData_Should_Return_Top_EconRate() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.BEST_BOWL_ECON);
            IplBowlingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
            Assert.assertEquals("Mayank Markande", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLData_Should_Return_Top_StrikeRateAndTopAvg() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.BEST_BOWL_AVG_AND_BEST_SR);
            IplBowlingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
            Assert.assertEquals("Prasidh Krishna", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLData_Should_Return_Top_Wicket_AndTopAvg() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.HIGHEST_WICKETS);
            IplBowlingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
            Assert.assertEquals("Umesh Yadav", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLData_Should_Return_The_Batsman_Who_Has_Max100() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBattingData(IPL_BATTING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.MAX100);
            IplBattingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBattingCsv[].class);
            Assert.assertEquals("Sanju Samson", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPLData_Should_Return_best_4W_5W_And_Avg() {
        try {
            IplAnalyser iplAnalyser = new IplAnalyser();
            iplAnalyser.LoadIplBowlingData(IPL_BOWLING_FILE_PATH);
            String sortedCensusData = iplAnalyser.getIplSortingDataInDescending(EnumSorting.BEST_BOWL_4W_5W_And_Avg);
            IplBowlingCsv censusCsv[] = new Gson().fromJson(sortedCensusData, IplBowlingCsv[].class);
            Assert.assertEquals("Krishnappa Gowtham", censusCsv[0].playerName);
            System.out.println(censusCsv[0]);
        } catch (IplAnalyserException e) {
            e.printStackTrace();
        }
    }
}

