import static org.junit.jupiter.api.Assertions.assertEquals;
import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.nio.charset.StandardCharsets;

public class DifferTest {

    @Test
    public void testGenerateStylishFlat() throws Exception {
        String filePath1 = "src/test/resources/file1.json";  // Относительный от проекта (Gradle test dir = root)
        String filePath2 = "src/test/resources/file2.json";

        // Чтение expected из classpath (надёжно, без Paths.get)
        String expected = new String(
                getClass().getResourceAsStream("/expected_stylish_flat.txt").readAllBytes(),
                StandardCharsets.UTF_8
        ).trim();
        String actual = Differ.generate(filePath1, filePath2, "stylish");

        assertEquals(expected, actual, "Stylish flat diff is incorrect");
    }

    @Test
    public void testGeneratePlainFlat() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";

        String expected = new String(
                getClass().getResourceAsStream("/expected_plain_flat.txt").readAllBytes(),
                StandardCharsets.UTF_8
        ).trim();
        String actual = Differ.generate(filePath1, filePath2, "plain");

        assertEquals(expected, actual, "Plain flat diff is incorrect");
    }

    @Test
    public void testGenerateJsonFlat() throws Exception {
        String filePath1 = "src/test/resources/file1.json";
        String filePath2 = "src/test/resources/file2.json";

        String expected = new String(
                getClass().getResourceAsStream("/expected_json_flat.txt").readAllBytes(),
                StandardCharsets.UTF_8
        ).trim();
        String actual = Differ.generate(filePath1, filePath2, "json");

        assertEquals(expected, actual, "Json flat diff is incorrect");
    }

    @Test
    public void testGenerateStylishNested() throws Exception {
        String filePath1 = "src/test/resources/nested1.json";
        String filePath2 = "src/test/resources/nested2.json";

        String expected = new String(
                getClass().getResourceAsStream("/expected_stylish_nested.txt").readAllBytes(),
                StandardCharsets.UTF_8
        ).trim();
        String actual = Differ.generate(filePath1, filePath2, "stylish");

        assertEquals(expected, actual, "Stylish nested diff is incorrect");
    }

    @Test
    public void testGeneratePlainNested() throws Exception {
        String filePath1 = "src/test/resources/nested1.json";
        String filePath2 = "src/test/resources/nested2.json";

        String expected = new String(
                getClass().getResourceAsStream("/expected_plain_nested.txt").readAllBytes(),
                StandardCharsets.UTF_8
        ).trim();
        String actual = Differ.generate(filePath1, filePath2, "plain");

        assertEquals(expected, actual, "Plain nested diff is incorrect");
    }
}
