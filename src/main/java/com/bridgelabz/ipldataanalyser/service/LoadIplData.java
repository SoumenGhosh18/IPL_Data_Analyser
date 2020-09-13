package com.bridgelabz.ipldataanalyser.service;

import com.bridgelabz.csvbuilder.exception.CSVBuilderException;
import com.bridgelabz.csvbuilder.service.CSVBuilderFactory;
import com.bridgelabz.csvbuilder.service.ICSVBuilder;
import com.bridgelabz.ipldataanalyser.exception.IplAnalyserException;
import com.bridgelabz.ipldataanalyser.model.IplBattingCsv;
import com.bridgelabz.ipldataanalyser.model.IplBowlingCsv;
import com.bridgelabz.ipldataanalyser.model.IplDao;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class LoadIplData {

    public <E> Map loadCsvData(String csvFilePath, Class<E> IplCensusCsvData) throws IplAnalyserException {
        Map<String, IplDao> censusMap = new HashMap<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<E> csvFileIterator = csvBuilder.getCSVFileIterator(reader, IplCensusCsvData);
            Iterable<E> CensusCsv = () -> csvFileIterator;
            String className = IplCensusCsvData.getSimpleName();
            if (className.equalsIgnoreCase("IplBattingCsv")) {
                StreamSupport.stream(CensusCsv.spliterator(), false)
                        .map(IplBattingCsv.class::cast)
                        .forEach(csvCensus -> censusMap.put(csvCensus.playerName, new IplDao(csvCensus)));
                return censusMap;
            } else if (className.equalsIgnoreCase("IplBowlingCsv")) {
                StreamSupport.stream(CensusCsv.spliterator(), false)
                        .map(IplBowlingCsv.class::cast)
                        .forEach(csvCensus1 -> censusMap.put(csvCensus1.playerName, new IplDao(csvCensus1)));
                return censusMap;
            }

        } catch (CSVBuilderException | IOException e) {
            throw new IplAnalyserException(e.getMessage(),
                    IplAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
        return null;
    }
}
