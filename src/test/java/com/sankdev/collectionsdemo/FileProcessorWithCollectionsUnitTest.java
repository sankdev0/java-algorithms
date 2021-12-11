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
  public void providedTextFile_whenReverseLines_thenReturnFileWithReverseLineOrder()
      throws URISyntaxException, IOException {

    Path test = Paths.get(thisClass.getResource("test-file-reverse.txt").toURI());
    Path output = Files.createTempFile(thisClass.getSimpleName() + "-test-file-01", ".txt");

    FileProcessorWithCollections.reverseLines(input, output);

    long mismatchIdx = Files.mismatch(test, output);

    output.toFile().deleteOnExit(); //cleanup

    Assertions.assertEquals(-1, mismatchIdx);
  }

}
