package ua.lviv.iot.algo.part1.Lab1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GardenWriterTest{
    private GardenWriter writer = new GardenWriter();
    private static final String SORTED_RESULT_FILENAME = "sortedResult.csv";
    private static final String SORTED_EXPECTED_FILENAME = "sortedExpected.csv";
    private static final String NON_SORTED_RESULT_FILENAME = "nonSortedResult.csv";
    private static final String NON_SORTED_EXPECTED_FILENAME = "nonSortedExpected.csv";
    private final File resultFile = new File(NON_SORTED_RESULT_FILENAME);
    private List<Garden> gardens;

    @BeforeEach
    public void setUp() {
        writer = new GardenWriter();
        gardens = new ArrayList<>();
        gardens.addAll(List.of(
                new Farmstead(1,2,3),
                new Orchard(4,5,6),
                new UniversityGarden(7,8,9),
                new BotanicGarden(10,11,12,13),
                new Farmstead(14,15,16),
                new Orchard(17,18,19),
                new UniversityGarden(20,20,20),
                new BotanicGarden(21,22,23,24)
        ));
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(NON_SORTED_RESULT_FILENAME));
        Files.deleteIfExists(Path.of(SORTED_RESULT_FILENAME));
    }

    @Test
    public void testIsEmptyForNonSorted() {
        writer.writeNonSorted(null);
        Assertions.assertFalse(resultFile.exists());
    }

    @Test
    public void testWriteListOfAnimalsForNonSorted() throws IOException {
        writer.writeNonSorted(gardens);
        Path actual = new File(NON_SORTED_RESULT_FILENAME).toPath();
        Path expected = new File(NON_SORTED_EXPECTED_FILENAME).toPath();
        Assertions.assertEquals(-1L,Files.mismatch(expected,actual));
    }

    @Test
    public void isFileExpectedCSVCreatedForNonSorted() {
        writer.writeNonSorted(gardens);
        File expectedFile = new File(NON_SORTED_EXPECTED_FILENAME);
        Assertions.assertTrue(expectedFile.exists());
    }

    @Test
    public void testIsEmptyForSorted() {
        writer.writeSorted(null);
        Assertions.assertFalse(resultFile.exists());
    }

    @Test
    public void testWriteListOfAnimalsForSorted() throws IOException {
        writer.writeSorted(gardens);
        Path actual = new File(SORTED_RESULT_FILENAME).toPath();
        Path expected = new File(SORTED_EXPECTED_FILENAME).toPath();
        Assertions.assertEquals(-1L,Files.mismatch(expected,actual));
    }
    @Test
    public void isFileExpectedCSVCreatedForSorted() {
        writer.writeNonSorted(gardens);
        File expectedFile = new File(SORTED_EXPECTED_FILENAME);
        Assertions.assertTrue(expectedFile.exists());
    }
}