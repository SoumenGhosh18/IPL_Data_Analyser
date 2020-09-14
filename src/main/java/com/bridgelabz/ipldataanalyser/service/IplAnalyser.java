package com.bridgelabz.ipldataanalyser.service;

import com.bridgelabz.ipldataanalyser.exception.IplAnalyserException;
import com.bridgelabz.ipldataanalyser.model.IplBattingCsv;
import com.bridgelabz.ipldataanalyser.model.IplBowlingCsv;
import com.bridgelabz.ipldataanalyser.model.IplDao;
import com.bridgelabz.ipldataanalyser.utility.EnumSorting;
import com.google.gson.Gson;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IplAnalyser {
   public Map<String, IplDao> censusMap;

    public IplAnalyser() {
        this.censusMap = new HashMap<>();
    }


    public Integer LoadIplBattingData(String csvFilePath) throws IplAnalyserException {
        censusMap = new LoadIplData().loadCsvData(csvFilePath, IplBattingCsv.class);
        return censusMap.size();
    }

    public int LoadIplBowlingData(String csvFilePath) throws IplAnalyserException {
        censusMap = new LoadIplData().loadCsvData(csvFilePath, IplBowlingCsv.class);
        return censusMap.size();
    }
    public String getIplSortingDataInAscending(EnumSorting sortVariable) throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = sortVariable.sortData();
        List sortedResult = this.sort(censusComparator);
        return new Gson().toJson(sortedResult);
    }

    public String getIplSortingDataInDescending(EnumSorting sortVariable) throws IplAnalyserException {
        if (censusMap == null || censusMap.size() == 0) {
            throw new IplAnalyserException("NO Census Data", IplAnalyserException.ExceptionType.NO_CENSUS_DATA);
        }
        Comparator<IplDao> censusComparator = sortVariable.sortData();
        List sortedResult = this.sort(censusComparator.reversed());
        return new Gson().toJson(sortedResult);
    }




    private List sort(Comparator<IplDao> censusComparator) {
        List sortedResult = censusMap.values().stream().sorted(censusComparator).collect(Collectors.toList());
        return sortedResult;
    }
}

