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
public class FIleProcessorWithCollections {

  /**
   * Read the input one line at a time and then write the lines out in reverse order, so that the
   * last input line is printed first, then the second last input line, and so on.
   *
   * @param input          path to the input file
   * @param outputFileName output file name
   * @return path to the output file
   * @throws IOException when IO operations fail
   */
  public Path reverseLines(Path input, String outputFileName) throws IOException {

    Deque<String> lineStack = new ArrayDeque<>();

    // 1. Read the input file line by line and push lines into the stack.
    try (BufferedReader br = Files.newBufferedReader(input)) {
      String line;
      while ((line = br.readLine()) != null) {
        lineStack.push(line);
      }
    }

    Path output = Files.createTempFile(outputFileName, ".txt");

    // 2. Pop from the stack and write to the output file.
    try (BufferedWriter bw = Files.newBufferedWriter(output)) {
      while (!lineStack.isEmpty()) {
        bw.write(lineStack.pop());
      }
    }

    return output;
  }

}
