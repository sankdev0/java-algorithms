package com.sankdev.collectionsdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

/**
 * Solution to Exercise 1.1. in the book "Open Data Structures" by Pat Morin. The idea is to choose
 * the right data structure for the right problem. If implemented, the parts of this exercise should
 * be done by making use of an implementation of the relevant interface (Stack, Queue, Deque, USet,
 * or SSet) provided by the Java Collections Framework.
 */
public class CollectionsUseCases {

  /**
   * Read the input one line at a time and then write the lines out in reverse order, so that the
   * last input line is printed first, then the second last input line, and so on.
   *
   * @param input
   * @param outputFileName
   * @return
   * @throws IOException
   */
  public Path reverseLines(Path input, String outputFileName) throws IOException {

    Stack<String> lineStack = new Stack<>();

    Path tmpPath = Paths.get(System.getProperty("java.io.tmpdir"));
    Path output = tmpPath.resolve(outputFileName);

    // Push into the stack.
    try(BufferedReader br = Files.newBufferedReader(input)) {
      String line;
      while ((line = br.readLine()) != null) {
        lineStack.push(line);
      }
    }

    // Pop from the stack.



    return output;
  }

}
