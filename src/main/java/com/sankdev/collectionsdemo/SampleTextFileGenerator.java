package com.sankdev.collectionsdemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class is used to generate a sample text files for testing purposes.
 */
public class SampleTextFileGenerator {

  /**
   * Generates a text file with fileName containing lineCount lines. Each 25th line is blank (i.e.
   * string of length 0). Each 15th and 101st line is duplicated, that means that blank lines will
   * be duplicated. Lines are numbered to review the result, except for the blank lines.
   *
   * @param fileName  - target file name
   * @param lineCount - number of lines to write to the file
   * @throws IOException when cannot write to file
   */
  public void createSampleTextFile(String fileName, int lineCount) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

    String prevStubLine = "";
    for (int i = 0; i < lineCount; i++) {
      String stubLine;

      if (i != 0 && i % 25 == 0) {
        stubLine = "\n";
      } else if (i != 0 && (i % 15 == 0 || i % 101 == 0)) {
        stubLine = prevStubLine;
      } else {
        stubLine = i + ". This is a test line for a test file. Makes no sense.\n";
      }

      writer.write(stubLine);

      prevStubLine = stubLine;
    }

    writer.close();
  }

  public static void main(String[] args) throws IOException {
    SampleTextFileGenerator generator = new SampleTextFileGenerator();
    generator.createSampleTextFile(
        System.getProperty("java.io.tmpdir") + "test-file.txt", 300);
  }
}
