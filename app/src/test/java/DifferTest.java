import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class DifferTest {

    // --- FLAT JSON ---

    @Test
    public void testStylishFlatJson() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/file1.json")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/file2.json")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_stylish_flat.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFlatJson() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/file1.json")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/file2.json")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_plain_flat.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "plain");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonFlatJson() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/file1.json")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/file2.json")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_json_flat.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "json");

        assertEquals(expected, actual);
    }

    // --- FLAT YAML ---

    @Test
    public void testStylishFlatYaml() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/file1.yml")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/file2.yml")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_stylish_flat.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFlatYaml() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/file1.yml")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/file2.yml")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_plain_flat.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "plain");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonFlatYaml() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/file1.yml")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/file2.yml")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_json_flat.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "json");

        assertEquals(expected, actual);
    }

    // --- NESTED JSON ---

    @Test
    public void testStylishNestedJson() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.json")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.json")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_stylish_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testPlainNestedJson() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.json")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.json")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_plain_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "plain");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonNestedJson() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.json")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.json")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_json_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "json");

        assertEquals(expected, actual);
    }

    // --- NESTED YAML ---

    @Test
    public void testStylishNestedYaml() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.yml")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.yml")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_stylish_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "stylish");

        assertEquals(expected, actual);
    }

    @Test
    public void testPlainNestedYaml() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.yml")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.yml")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_plain_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "plain");

        assertEquals(expected, actual);
    }

    @Test
    public void testJsonNestedYaml() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.yml")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.yml")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_json_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString(), "json");

        assertEquals(expected, actual);
    }

    // --- DEFAULT ---

    @Test
    public void testDefaultJson() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.json")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.json")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_stylish_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString());

        assertEquals(expected, actual);
    }

    @Test
    public void testDefaultYaml() throws Exception {
        Path file1 = Path.of(Objects.requireNonNull(getClass().getResource("/nested1.yml")).toURI());
        Path file2 = Path.of(Objects.requireNonNull(getClass().getResource("/nested2.yml")).toURI());
        Path file3 = Path.of(Objects.requireNonNull(getClass().getResource("/expected_stylish_nested.txt")).toURI());

        String expected = Files.readString(file3);
        String actual = Differ.generate(file1.toString(), file2.toString());

        assertEquals(expected, actual);
    }
}
