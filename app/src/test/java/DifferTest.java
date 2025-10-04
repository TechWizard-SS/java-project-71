import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static final String FIXTURES_DIR = "src/test/resources/fixtures/";

    @Test
    public void testGenerateStylishFlat() throws Exception {
        String filePath1 = FIXTURES_DIR + "file1.json";
        String filePath2 = FIXTURES_DIR + "file2.json";

        String expected = Files.readString(Paths.get(FIXTURES_DIR + "expected_stylish_flat.txt")).trim();
        String actual = Differ.generate(filePath1, filePath2, "stylish");

        assertEquals(expected, actual, "Stylish flat diff is incorrect");
    }

    @Test
    public void testGeneratePlainFlat() throws Exception {
        String filePath1 = FIXTURES_DIR + "file1.json";
        String filePath2 = FIXTURES_DIR + "file2.json";

        String expected = Files.readString(Paths.get(FIXTURES_DIR + "expected_plain_flat.txt")).trim();
        String actual = Differ.generate(filePath1, filePath2, "plain");

        assertEquals(expected, actual, "Plain flat diff is incorrect");
    }

    @Test
    public void testGenerateJsonFlat() throws Exception {
        String filePath1 = FIXTURES_DIR + "file1.json";
        String filePath2 = FIXTURES_DIR + "file2.json";

        String actual = Differ.generate(filePath1, filePath2, "json");

        // Просто проверим, что строка начинается с '[' — массив JSON
        assertEquals('[', actual.charAt(0), "Json format should start with [");
    }

    @Test
    public void testGenerateStylishNested() throws Exception {
        String filePath1 = FIXTURES_DIR + "nested1.json";
        String filePath2 = FIXTURES_DIR + "nested2.json";

        String expected = Files.readString(Paths.get(FIXTURES_DIR + "expected_stylish_nested.txt")).trim();
        String actual = Differ.generate(filePath1, filePath2, "stylish");

        assertEquals(expected, actual, "Stylish nested diff is incorrect");
    }

    @Test
    public void testGeneratePlainNested() throws Exception {
        String filePath1 = FIXTURES_DIR + "nested1.json";
        String filePath2 = FIXTURES_DIR + "nested2.json";

        String expected = Files.readString(Paths.get(FIXTURES_DIR + "expected_plain_nested.txt")).trim();
        String actual = Differ.generate(filePath1, filePath2, "plain");

        assertEquals(expected, actual, "Plain nested diff is incorrect");
    }
}
