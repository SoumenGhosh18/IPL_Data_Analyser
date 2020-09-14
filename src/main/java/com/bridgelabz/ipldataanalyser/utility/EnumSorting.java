package com.bridgelabz.ipldataanalyser.utility;

import com.bridgelabz.ipldataanalyser.model.IplDao;

import java.util.Comparator;

public enum EnumSorting {

        TOP_BAT_AVG {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.avg);
                return IplCensusComparator;
            }
        },
        TOP_BAT_SR {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.sr);
                return IplCensusComparator;
            }
        },
        MAX_6s_4s {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> (census.highest4s+ census.highest6s));
                return IplCensusComparator;
            }
        },
        MAX_6s_4s_With_SR {
        @Override
        public Comparator<IplDao> sortData() {
            Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> (census.highest4s+ census.highest6s +census.sr));
            return IplCensusComparator;
        }
     },
        TOP_BAT_AVG_WITH_BEST_SR {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> (census.sr + census.avg));
                return IplCensusComparator;
            }
        },
        TOP_RUNS_OF_PLAYER {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.Runs);
                return IplCensusComparator;
            }
        },
        BEST_BOWL_AVG {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.Avg);
                return IplCensusComparator;
            }
        },
        BEST_BOWL_SR {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.SR);
                return IplCensusComparator;
            }
        },
        BEST_BOWL_ECON {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.Econ);
                return IplCensusComparator;
            }
        },
        BEST_BOWL_4W_5W_And_Avg {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.
                        comparing(census -> (census.highest5W + census.highest4W + census.Avg));
                return IplCensusComparator;
            }
        },
        BEST_BOWL_AVG_AND_BEST_SR {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.
                        comparing(census -> (census.SR + census.Avg));
                return IplCensusComparator;
            }
        },
    MAX100 {
        @Override
        public Comparator<IplDao> sortData() {
            Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.max100);
            return IplCensusComparator;
        }
    },
        HIGHEST_WICKETS {
            @Override
            public Comparator<IplDao> sortData() {
                Comparator<IplDao> IplCensusComparator = Comparator.comparing(census -> census.Wkts);
                return IplCensusComparator;
            }
        };

        public abstract Comparator<IplDao> sortData();
    }

