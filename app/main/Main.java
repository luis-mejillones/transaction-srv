package main;

public class Main {


    public static void main(String[] args) {
        System.out.println("Running Benchmark for Cassandra...");

        Benchamark benchamark = new Benchamark();

        long num = 10; // it's the number of transactions to created for testing.

        System.out.println("Start loading data: " + num);
        benchamark.loadData(num);

        System.out.println("Start running update: " + num);
        benchamark.measureTime(num);

        System.out.println("Cassandra benchmark finished. ");

        System.exit(0);
    }


}
