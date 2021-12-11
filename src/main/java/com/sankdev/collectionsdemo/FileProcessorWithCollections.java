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
 * Solution to Exercise 1.1. in the book "Open Data Structures" by Pat Morin. The idea is to choose
 * the right data structure for the right problem. If implemented, the parts of this exercise should
 * be done by making use of an implementation of the relevant interface (Stack, Queue, Deque, USet,
 * or SSet) provided by the Java Collections Framework.
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

    // 1. Read the input file line by line and push lines into the stack.
    try (BufferedReader br = Files.newBufferedReader(input)) {
      String line;
      lineStack.push(br.readLine()); // the first line is pushed without the line separator.
      while ((line = br.readLine()) != null) {
        lineStack.push(line + "\n");
      }
    }

    // 2. Pop from the stack and write to the output file.
    try (BufferedWriter bw = Files.newBufferedWriter(output)) {

      while (!lineStack.isEmpty()) {
        bw.write(lineStack.pop());
      }
    }
  }
}
