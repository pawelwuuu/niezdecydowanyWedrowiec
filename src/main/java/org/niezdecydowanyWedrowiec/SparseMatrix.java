package org.niezdecydowanyWedrowiec;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Objects;

public class SparseMatrix {
    int matrixSize;

    public SparseMatrix(int matrixSize) {
        this.matrixSize = matrixSize;
    }

    private class Pair {
        int row;
        int column;
        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return row == pair.row &&
                    column == pair.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    private final LinkedHashMap<Pair, Double> sparseMatrix = new LinkedHashMap<>();

    boolean isSet(int row, int column) {
        Pair pair = new Pair(row, column);

        return sparseMatrix.containsKey(pair);
    }

    void setValue(int row, int column, double value) {
        if (row >= matrixSize || column >= matrixSize) {
            String errStr = String.format("Element at row: %d column: %d is out of matrix bound", row, column);
            throw new SparseException(errStr);
        }

        Pair pair = new Pair(row, column);

        sparseMatrix.put(pair, value);
    }

    double getValue(int row, int column) {
        if (row >= matrixSize || column >= matrixSize) {
            String errStr = String.format("Element at row: %d column: %d is out of matrix bound", row, column);
            throw new SparseException(errStr);
        }
        if (!isSet(row, column)) {
            String errStr = String.format("Element at row: %d column: %d not set", row, column);
            throw new SparseException(errStr);
        }

        return sparseMatrix.get(new Pair(row, column));
    }

    ArrayList<Double> getRow(int row) {
        ArrayList<Pair> rowValues = new ArrayList<>();

        for (Pair pair : sparseMatrix.keySet()) {
            if (pair.row == row) {
                rowValues.add(pair);
            }
        }

        ArrayList<Double> rowValuesWithZero = new ArrayList<>();
        for (int i = 0; i < matrixSize; i++) {
            double currentColumnValue = 0.0;
            for(Pair pair: rowValues) {
                if (pair.column == i) {
                    currentColumnValue = sparseMatrix.get(pair);
                }
            }
            rowValuesWithZero.add(currentColumnValue);
        }

        return rowValuesWithZero;
    }

    ArrayList<Double> getColumn(int column) {
        ArrayList<Pair> columnValues = new ArrayList<>();

        for (Pair pair : sparseMatrix.keySet()) {
            if (pair.column == column) {
                columnValues.add(pair);
            }
        }

        ArrayList<Double> columnValuesWithZero = new ArrayList<>();
        for (int i = 0; i < matrixSize; i++) {
            double currentRowValue = 0.0;
            for (Pair pair : columnValues) {
                if (pair.row == i) {
                    currentRowValue = sparseMatrix.get(pair);
                }
            }
            columnValuesWithZero.add(currentRowValue);
        }

        return columnValuesWithZero;
    }

    void printMatrix() {
        for (int i = 0; i < matrixSize; i++) {
            System.out.println(getRow(i));
        }
    }
}

