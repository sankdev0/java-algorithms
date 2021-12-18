package com.sankdev.collectionsdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * This class shows use cases of Java Collections Framework for processing a text file line by line.
 * Basically, these are solutions to Exercise 1.1. in the book "Open Data Structures" by Pat Morin.
 * The idea is to choose the right data structure for the right problem. If implemented, the parts
 * of this exercise should be done by making use of an implementation of the relevant interface
 * (Stack, Queue, Deque, USet, or SSet) provided by the Java Collections Framework.
 */
public class FileProcessorWithCollections {

    /**
     * Read the input one line at a time and then write the lines out in reverse order, so that the
     * last input line is printed first, then the second last input line, and so on. Note: There is a
     * lib for that -> Apache Commons IO's ReversedLinesFileReader class which reads lines in a file
     * reversely, that way you can read file from the last line.
     *
     * @param input  path to the input file
     * @param output path to the output file
     * @throws IOException if IO operations fail
     */
    public static void reverseAllLines(Path input, Path output) throws IOException {

        Deque<String> lineStack = new ArrayDeque<>();

        // 1. Use Stack to store all lines of the input.
        try (BufferedReader br = Files.newBufferedReader(input)) {
            String line;
            while ((line = br.readLine()) != null) {
                lineStack.push(line);
            }
        }

        // Introduce this counter to manage line separators while writing.
        int firstLineCounter = 1;
        try (BufferedWriter bw = Files.newBufferedWriter(output)) {
            while (!lineStack.isEmpty()) {
                if (firstLineCounter > 0) {
                    firstLineCounter--;
                } else {
                    bw.write(System.lineSeparator());
                }
                bw.write(lineStack.pop());
            }
        }
    }

    /**
     * Read the first {@code n} lines of input and then write them out in reverse order. Read the next
     * {@code n} lines and then write them out in reverse order. Do this until there are no more lines
     * left to read, at which point any remaining lines should be output in reverse order. In other
     * words, your output will start with the nth line, then the (n - 1)th, then the (n - 2)th, and so
     * on down to the first line. This will be followed by the 2nth line, followed by the (2n - 1)th,
     * and so on down to the (n + 1)th line. And so on. Your code should never have to store more than
     * {@code n} lines at any given time.
     *
     * @param input  path to the input file
     * @param output path to the output file
     * @param N      chunk line count (i.e. step, number of lines to restart the reverse output)
     * @throws IOException if IO operations fail
     */
    public static void reverseEachNLines(Path input, Path output, final int N) throws IOException {

        int counter = N;

        if (counter < 0) {
            throw new IllegalArgumentException("Number of lines must not be less than zero");
        }

        Deque<String> lineStack = new ArrayDeque<>();

        // Use stack to store each 50 lines of input.
        try (BufferedReader br = Files.newBufferedReader(input);
             BufferedWriter bw = Files.newBufferedWriter(output)) {

            String line;
            // Introduce this counter to manage line separators while writing.
            int firstLineCounter = 1;

            while ((line = br.readLine()) != null) {
                lineStack.push(line);
                counter--;

                // If all n lines are read then write them from the stack AND reset counter n.
                if (counter == 0) {
                    while (!lineStack.isEmpty()) {
                        if (firstLineCounter > 0) {
                            firstLineCounter--;
                        } else {
                            bw.write(System.lineSeparator());
                        }
                        bw.write(lineStack.pop());
                    }
                    counter = N;
                }
            }

            // Write the rest of the lines.
            while (!lineStack.isEmpty()) {
                bw.write(System.lineSeparator());
                bw.write(lineStack.pop());
            }
        }
    }

    /**
     * Read the input one line at a time. At any point after reading the first {@code n} lines, if
     * some line is blank (i.e., a string of length 0), then output the line that occurred {@code n}
     * lines prior to that one. For example, if Line 242 is blank, then your program should output
     * line (242 - n). This program should be implemented so that it never stores more than {@code n}
     * lines of the input at any given time.
     *
     * @param input  path to the input file
     * @param output path to the output file
     * @param N      number of lines to skip
     * @throws IOException if IO operations fail
     */
    public static void replaceBlankLineWithPriorNthLine(Path input, Path output, final int N)
            throws IOException {

        if (N < 0) {
            throw new IllegalArgumentException("Number of lines must not be less than zero");
        }

        Deque<String> queue = new LinkedList<>();

        String line;

        try (BufferedReader br = Files.newBufferedReader(input);
             BufferedWriter bw = Files.newBufferedWriter(output)) {

            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                queue.addLast(line);
                if (queue.size() > N) {
                    if (line.isEmpty()) {
                        line = queue.peekFirst();
                    }
                    queue.removeFirst();
                }

                if (isFirstLine) {
                    isFirstLine = false;
                } else {
                    bw.write(System.lineSeparator());
                }
                bw.write(line);
            }
        }
    }

    /**
     * Read the input one line at a time and write each line to the output if it is not a duplicate of
     * some previous input line. Take special care so that a file with a lot of duplicate lines does
     * not use more memory than what is required for the number of unique lines.
     *
     * @param input  path to the input file
     * @param output path to the output file
     * @throws IOException if IO operations fail
     */
    public static void outputUniqueLinesOnly(Path input, Path output) throws IOException {

        Set<String> lineSet = new HashSet<>();

        String line;
        try (BufferedReader br = Files.newBufferedReader(input);
             BufferedWriter bw = Files.newBufferedWriter(output)) {

            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (lineSet.add(line)) {
                    if (isFirstLine) {
                        isFirstLine = false;
                    } else {
                        bw.write(System.lineSeparator());
                    }
                    bw.write(line);
                }
            }
        }
    }

}
