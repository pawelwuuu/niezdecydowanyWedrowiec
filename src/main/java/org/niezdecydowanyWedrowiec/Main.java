package org.niezdecydowanyWedrowiec;

public class Main {
    public static void main(String[] args) {



//        System.out.println(SimplifiedProbability.calculatePlacesProbabilities(3,4));
//        System.out.println(MonteCarloSimulation.simulate(4,3,100)); // to jest dobrze ;)

        SparseMatrix sparseMatrix = new SparseMatrix(3);

        sparseMatrix.setValue(0,0, 3.5);
        sparseMatrix.setValue(1,2,10.5);


        System.out.println(sparseMatrix.getValue(0,2));
    }
}
