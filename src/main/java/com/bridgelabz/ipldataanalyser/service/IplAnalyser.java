package com.bridgelabz.ipldataanalyser.service;

import com.bridgelabz.ipldataanalyser.exception.IplAnalyserException;
import com.bridgelabz.ipldataanalyser.model.IplBattingCsv;
import com.bridgelabz.ipldataanalyser.model.IplBowlingCsv;
import com.bridgelabz.ipldataanalyser.model.IplDao;
import com.google.gson.Gson;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IplAnalyser {
    Map<String, IplDao> censusMap;

    public IplAnalyser() {
        this.censusMap = new HashMap<>();
    }


    public int LoadIplBattingData(String csvFilePath) throws IplAnalyserException {
        censusMap =  new LoadIplData().loadCsvData(csvFilePath, IplBattingCsv.class);
        return censusMap.size();
    }

    public int LoadIplBowlingData(String csvFilePath) throws IplAnalyserException {
        censusMap =  new LoadIplData().loadCsvData(csvFilePath, IplBowlingCsv.class);
        return censusMap.size();
    }

    public String getBestBattingAvg() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> census.avg);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    public String getBestBattingSR() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> census.sr);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    public String getHighest6s() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> (census.highest4s + census.highest6s));
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    public String getHighest4s() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> census.highest4s );
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    public String getHighestStrikeRateWith6sAnd4s() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> census.highest6s + census.highest4s);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    public String getBestAvgWithGreatStrikeRate() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> census.sr + census.avg);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    public String getTopRunWithBestStrikeRate() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> census.Runs + census.sr);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }
    public String getTopBowlingAvg() throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = Comparator.comparing(census -> census.Avg);
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }

    private List sort(Comparator<IplDao> censusComparator) {
        List sortedResult = censusMap.values().stream().sorted(censusComparator).collect(Collectors.toList());
        return sortedResult;
    }
}

