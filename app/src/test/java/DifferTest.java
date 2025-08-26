import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String expectedStylish;

    @BeforeAll
    public static void beforeAll() throws Exception {
        expectedStylish = Files.readString(Paths.get("stylish.txt"));
    }

    @Test
    public void testGenerate() throws Exception {
        String filePath1 = "file1.json";
        String filePath2 = "file2.json";

        String actual = Differ.generate(filePath1, filePath2);
        assertEquals(expectedStylish.trim(), actual.trim());
    }

    @Test
    public void testGenerateWithAbsolutePaths() throws Exception {
        String filePath1 = Paths.get("file1.json").toAbsolutePath().toString();
        String filePath2 = Paths.get("file2.json").toAbsolutePath().toString();

        String actual = Differ.generate(filePath1, filePath2);
        assertEquals(expectedStylish.trim(), actual.trim());
    }
}
