package org.niezdecydowanyWedrowiec;

import java.util.ArrayList;

public class SimplifiedProbability {
    public static ArrayList<Double> calculatePlacesProbabilities(int n, int s) {
        int matrixWidth = 1 + n + s;
        double[][] matrix = new double[matrixWidth][matrixWidth];
        double[] matrixResult = new double[matrixWidth];
        matrixResult[0] = 1;

        for (int i = 0; i < matrixWidth; i++) {
            matrix[i][i] = 1;
            if (i - 1 >= 0 && i + 1 <= matrixWidth - 1) {
                matrix[i][i-1] = -0.5;
                matrix[i][i+1] = -0.5;
            }
        }




        ArrayList<Double> result = new ArrayList<>();
        for (double element : solve(matrix, matrixResult)) {
            result.add(element);
        }

        return result;
    }

    public static double[] solve(double[][] A, double[] b) {
        int N = A.length;

        // Eliminacja Gaussa
        for (int i = 0; i < N; i++) {
            // Szukamy największego elementu w kolumnie i-tej
            int maxRowIndex = i;
            for (int k = i + 1; k < N; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[maxRowIndex][i])) {
                    maxRowIndex = k;
                }
            }

            // Zamiana wierszy
            double[] temp = A[i];
            A[i] = A[maxRowIndex];
            A[maxRowIndex] = temp;
            double tempB = b[i];
            b[i] = b[maxRowIndex];
            b[maxRowIndex] = tempB;

            // Eliminacja
            for (int k = i + 1; k < N; k++) {
                double factor = A[k][i] / A[i][i];
                b[k] -= factor * b[i];
                for (int j = i; j < N; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }

        // Wyliczanie rozwiązania
        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            x[i] = b[i];
            for (int j = i + 1; j < N; j++) {
                x[i] -= A[i][j] * x[j];
            }
            x[i] /= A[i][i];
        }

        return x;
    }
}
