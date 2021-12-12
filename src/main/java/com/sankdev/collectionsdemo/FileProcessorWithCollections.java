package com.sankdev.collectionsdemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;

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
  public static void reverseLines(Path input, Path output) throws IOException {

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
          bw.write("\n");
        }
        bw.write(lineStack.pop());
      }
    }
  }

  /**
   * Read the first 50 lines of input and then write them out in reverse order. Read the next 50
   * lines and then write them out in reverse order. Do this until there are no more lines left to
   * read, at which point any remaining lines should be output in reverse order. In other words,
   * your output will start with the 50th line, then the 49th, then the 48th, and so on down to the
   * first line. This will be followed by the 100th line, followed by the 99th, and so on down to
   * the 51st line. And so on. Your code should never have to store more than 50 lines at any given
   * time.
   *
   * @param input  path to the input file
   * @param output path to the output file
   * @param n      chunk line count (i.e. step, number of lines to restart the reverse output)
   * @throws IOException if IO operations fail
   */
  public static void reverseEachNLines(Path input, Path output, int n) throws IOException {

    Deque<String> lineStack = new ArrayDeque<>();

    // Use stack to store each 50 lines of input.
    try (BufferedReader br = Files.newBufferedReader(input);
        BufferedWriter bw = Files.newBufferedWriter(output)) {

      String line;
      // Introduce this counter to manage line separators while writing.
      int firstLineCounter = 1;

      while ((line = br.readLine()) != null) {
        lineStack.push(line);
        n--;

        // If all n lines are read then write them from the stack AND reset counter n.
        if (n == 0) {
          while (!lineStack.isEmpty()) {
            if (firstLineCounter > 0) {
              firstLineCounter--;
            } else {
              bw.write("\n");
            }
            bw.write(lineStack.pop());
          }
          n = 50;
        }
      }

      // Write the rest of the lines.
      while (!lineStack.isEmpty()) {
        bw.write("\n");
        bw.write(lineStack.pop());
      }
    }
  }
}
