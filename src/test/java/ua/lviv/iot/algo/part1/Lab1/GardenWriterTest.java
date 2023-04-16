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
                new BotanicGarden(1, 2, 3, 4),
                new Orchard(5, 6, 7),
                new Farmstead(8, 9, 10),
                new UniversityGarden(11, 12, 13)));
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
    public void isFileExpectedCSVCreated() {
        writer.writeNonSorted(gardens);
        File expectedFile = new File(NON_SORTED_EXPECTED_FILENAME);
        Assertions.assertTrue(expectedFile.exists());
    }
}