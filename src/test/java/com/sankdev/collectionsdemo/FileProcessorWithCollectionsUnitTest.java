package com.sankdev.collectionsdemo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FileProcessorWithCollectionsUnitTest {

  public static Path input = null;
  public static Class thisClass = null;

  @BeforeAll
  public static void setup() throws URISyntaxException {
    thisClass = FileProcessorWithCollectionsUnitTest.class;
    input = Paths.get(thisClass.getResource("test-file.txt").toURI());
  }

  @Test
  public void providedTextFile_whenReverseLines_thenOutputWithAllLinesInReverseOrder()
      throws URISyntaxException, IOException {

    Path test = Paths.get(thisClass.getResource("test-file-reverse.txt").toURI());
    Path output = Files.createTempFile(thisClass.getSimpleName() + "-test-file-01", ".txt");

    FileProcessorWithCollections.reverseAllLines(input, output);

    long mismatchIdx = Files.mismatch(test, output);

    output.toFile().deleteOnExit();

    Assertions.assertEquals(-1, mismatchIdx);
  }

  @Test
  public void providedTextFile_whenReverseEachFiftyLines_thenOutputWithEachFiftyLinesInReverseOrder()
      throws URISyntaxException, IOException {

    final int linesChunk = 50;

    Path test = Paths.get(thisClass.getResource("test-file-reverse-each-fifty.txt").toURI());
    Path output = Files.createTempFile(thisClass.getSimpleName() + "-test-file-02", ".txt");

    FileProcessorWithCollections.reverseEachNLines(input, output, linesChunk);

    long mismatchIdx = Files.mismatch(test, output);

    output.toFile().deleteOnExit();

    Assertions.assertEquals(-1, mismatchIdx);

  }

  @Test
  public void providedTextFile_whenReplaceBlankLinesWithPrior42ndLine_thenOutputWithBlankLinesReplaced()
      throws URISyntaxException, IOException {

    Path test = Paths.get(thisClass.getResource("test-file-replace-blank.txt").toURI());
    Path output = Files.createTempFile(thisClass.getSimpleName() + "-test-file-03", ".txt");

    FileProcessorWithCollections.replaceBlankLineWithPriorNthLine(input, output, 42);

    long mismatchIdx = Files.mismatch(test, output);

    output.toFile().deleteOnExit();

    Assertions.assertEquals(-1, mismatchIdx);
  }

}
