package com.sankdev.collectionsdemo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorWithCollectionsUnitTest {

    public static Path input = null;
    public static String[] testLines;
    public static Class thisClass = null;

    /**
     * Helper method to create a temp text file with name including the prefix and suffix, and write the lines to it.
     * Returns the path to the temp file. When writing it uses the {@code System.lineSeparator()}.
     *
     * @param lines  the lines to write to the temp file
     * @param prefix prefix to include in file name
     * @return path to the temp file containing the lines
     */
    private static Path writeLinesToTempTxtFile(String[] lines, String prefix) throws IOException {
        Path path = Files.createTempFile(thisClass.getSimpleName() + prefix, ".txt");

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (int i = 0; i < lines.length - 1; i++) {
                bw.write(lines[i] + System.lineSeparator());
            }
            bw.write(lines[lines.length - 1]);
        }

        return path;
    }

    @BeforeAll
    public static void setup() throws IOException {
        thisClass = FileProcessorWithCollectionsUnitTest.class;
        testLines = new String[]{
                "0. This is a longer test line",
                "1. This is a short test line",
                "2. This is a short test line",
                "2. This is a short test line",
                "",
                "4. The shortest line",
                "",
                "",
                "7. This is the longest test line",
                "7. This is the longest test line",
                "",
                "",
                "10. Wow. Just an average line"
        };
        // Write the test file.
        input = writeLinesToTempTxtFile(testLines, thisClass.getSimpleName() + "-test-file-");
    }

    @Test
    public void providedTextFile_whenReverseLines_thenOutputWithAllLinesInReverseOrder()
            throws IOException {

        String[] reversedLines = {
                "10. Wow. Just an average line",
                "",
                "",
                "7. This is the longest test line",
                "7. This is the longest test line",
                "",
                "",
                "4. The shortest line",
                "",
                "2. This is a short test line",
                "2. This is a short test line",
                "1. This is a short test line",
                "0. This is a longer test line"
        };

        Path expected = writeLinesToTempTxtFile(reversedLines, thisClass.getSimpleName() + "-expected-output-01-");
        Path output = Files.createTempFile(thisClass.getSimpleName() + "-output-01-", ".txt");

        FileProcessorWithCollections.reverseAllLines(input, output);

        long mismatchIdx = Files.mismatch(expected, output);

        expected.toFile().deleteOnExit();
        output.toFile().deleteOnExit();

        Assertions.assertEquals(-1, mismatchIdx);
    }

    @Test
    public void providedTextFile_whenReverseEachFiftyLines_thenOutputWithEachFiveLinesInReverseOrder()
            throws IOException {

        final int LINES_CHUNK = 5;
        String[] reversedLines = new String[]{
                "",
                "2. This is a short test line",
                "2. This is a short test line",
                "1. This is a short test line",
                "0. This is a longer test line",
                "7. This is the longest test line",
                "7. This is the longest test line",
                "",
                "",
                "4. The shortest line",
                "10. Wow. Just an average line",
                "",
                ""
        };

        Path expected = writeLinesToTempTxtFile(reversedLines, thisClass.getSimpleName() + "-expected-output-02");
        Path output = Files.createTempFile(thisClass.getSimpleName() + "-output-02", ".txt");

        FileProcessorWithCollections.reverseEachNLines(input, output, LINES_CHUNK);

        long mismatchIdx = Files.mismatch(expected, output);

        expected.toFile().deleteOnExit();
        output.toFile().deleteOnExit();

        Assertions.assertEquals(-1, mismatchIdx);
    }

    @Test
    public void providedTextFile_whenReplaceBlankLinesWithPrior42ndLine_thenOutputWithBlankLinesReplacedWIthStepFive()
            throws IOException {

        final int STEP = 5;
        testLines = new String[]{
                "0. This is a longer test line",
                "1. This is a short test line",
                "2. This is a short test line",
                "2. This is a short test line",
                "",
                "4. The shortest line",
                "1. This is a short test line",
                "2. This is a short test line",
                "7. This is the longest test line",
                "7. This is the longest test line",
                "4. The shortest line",
                "",
                "10. Wow. Just an average line"
        };

        Path expected = writeLinesToTempTxtFile(testLines, thisClass.getSimpleName() + "-expected-output-03");
        Path output = Files.createTempFile(thisClass.getSimpleName() + "-output-03", ".txt");

        FileProcessorWithCollections.replaceBlankLineWithPriorNthLine(input, output, STEP);

        long mismatchIdx = Files.mismatch(expected, output);

        expected.toFile().deleteOnExit();
        output.toFile().deleteOnExit();

        Assertions.assertEquals(-1, mismatchIdx);
    }

    @Test
    public void providedTextFile_whenOutputUniqueLinesOnly_thenOutputUniqueLinesOnly()
            throws IOException {

        testLines = new String[]{
                "0. This is a longer test line",
                "1. This is a short test line",
                "2. This is a short test line",
                "",
                "4. The shortest line",
                "7. This is the longest test line",
                "10. Wow. Just an average line"
        };

        Path expected = writeLinesToTempTxtFile(testLines, thisClass.getSimpleName() + "-expected-output-04");
        Path output = Files.createTempFile(thisClass.getSimpleName() + "-output-04", ".txt");

        FileProcessorWithCollections.outputUniqueLinesOnly(input, output);

        long mismatchIdx = Files.mismatch(expected, output);

        expected.toFile().deleteOnExit();
        output.toFile().deleteOnExit();

        Assertions.assertEquals(-1, mismatchIdx);
    }

    @Test
    public void providedTextFile_whenRemoveFirstOccurrences_thenFirstOccurrencesRemoved()
            throws IOException {

        testLines = new String[]{
                "2. This is a short test line",
                "",
                "",
                "7. This is the longest test line",
                "",
                ""
        };

        Path expected = writeLinesToTempTxtFile(testLines, thisClass.getSimpleName() + "-expected-output-05");
        Path output = Files.createTempFile(thisClass.getSimpleName() + "-output-05", ".txt");

        FileProcessorWithCollections.removeFirstOccurrences(input, output);

        long mismatchIdx = Files.mismatch(expected, output);

        expected.toFile().deleteOnExit();
        output.toFile().deleteOnExit();

        Assertions.assertEquals(-1, mismatchIdx);
    }

    // Do a cleanup
    @AfterAll
    public static void cleanup() {
        input.toFile().deleteOnExit();
    }
}
