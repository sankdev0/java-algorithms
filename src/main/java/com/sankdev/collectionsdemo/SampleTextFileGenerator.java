package com.sankdev.collectionsdemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class is used to generate a large text file for testing purposes.
 */
public class SampleTextFileGenerator {

  // number of lines in the target text file
  private final int LINES = 1_000_000;

  public void createSampleTextFile(String fileName) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

    for (int i = 0; i < LINES; i++) {
      String stubLine = " This is a test line for a test file. Makes no sense. \n";
      writer.write(i + stubLine);
    }

    writer.close();
  }

}
