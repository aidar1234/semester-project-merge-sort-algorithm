package benchmarking;

import sortAlgorithms.LinkedList;
import sortAlgorithms.MergeSort;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {
        testArray();
        testLinkedList();
    }

    static void testLinkedList() throws IOException {

        File file = new File("src/benchmarking/TimeLinkedList.txt");

        for (int i = 1000; i <= 100_000; i += 1000) {

            long mediumValue = 0;

            LinkedList linkedList;
            LinkedList temp = new LinkedList();

            for (int n = 0; n < 10; n++) {
                Scanner scanner = new Scanner(new File("src/benchmarking/data/"
                        + i + "_" + n + ".txt")
                );

                while (scanner.hasNextLine()) {
                    temp.add(Integer.parseInt(scanner.nextLine()));
                }

                long tempMediumValue = 0;

                for (int k = 0; k < 100; k++) {
                    linkedList = new LinkedList(temp);

                    long startTime = System.nanoTime();
                    linkedList.sort();
                    long endTime = System.nanoTime();

                    long duration = endTime - startTime;
                    tempMediumValue += duration / 100;
                }
                mediumValue += tempMediumValue / 10;
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write(mediumValue + "\n");
            writer.flush();
            writer.close();
        }
    }

    static void testArray() throws IOException {

        File file = new File("src/benchmarking/TimeArray.txt");

        for (int i = 1000; i <= 100_000; i += 1000) {

            long mediumValue = 0;

            int[] arr;
            int[] temp = new int[i];

            for (int n = 0; n < 10; n++) {
                Scanner scanner = new Scanner(new File("src/benchmarking/data/"
                        + i + "_" + n + ".txt")
                );

                int j = 0;
                while (scanner.hasNextLine()) {
                    temp[j] = Integer.parseInt(scanner.nextLine());
                    j++;
                }

                long tempMediumValue = 0;

                for (int k = 0; k < 100; k++) {
                    arr = Arrays.copyOf(temp, i);

                    long startTime = System.nanoTime();
                    MergeSort.sort(arr);
                    long endTime = System.nanoTime();

                    long duration = endTime - startTime;
                    tempMediumValue += duration / 100;
                }

                mediumValue += tempMediumValue / 10;
            }

            FileWriter writer = new FileWriter(file, true);
            writer.write(mediumValue + "\n");
            writer.flush();
            writer.close();
        }
    }
}
