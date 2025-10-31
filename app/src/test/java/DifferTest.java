import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class DifferTest {

    @Test
    public void testGenerateStylishFlatJson() throws Exception {
        Path temp1 = createTempFile("/file1.json");
        Path temp2 = createTempFile("/file2.json");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_stylish_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString(), "stylish");

            assertEquals(expected, actual, "Stylish flat diff json is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    @Test
    public void testGeneratePlainFlatJson() throws Exception {
        Path temp1 = createTempFile("/file1.json");
        Path temp2 = createTempFile("/file2.json");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_plain_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString(), "plain");

            assertEquals(expected, actual, "Plain flat diff json is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    @Test
    public void testGenerateJsonFlatJson() throws Exception {
        Path temp1 = createTempFile("/file1.json");
        Path temp2 = createTempFile("/file2.json");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_json_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString(), "json");

            assertEquals(expected, actual, "Json flat diff json is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    @Test
    public void testGenerateDefaultFlatJson() throws Exception {
        Path temp1 = createTempFile("/file1.json");
        Path temp2 = createTempFile("/file2.json");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_stylish_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString());  // 2-arg

            assertEquals(expected, actual, "Default flat diff json is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    @Test
    public void testGenerateStylishFlatYml() throws Exception {
        Path temp1 = createTempFile("/file1.yml");
        Path temp2 = createTempFile("/file2.yml");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_stylish_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString(), "stylish");

            assertEquals(expected, actual, "Stylish flat diff yml is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    @Test
    public void testGeneratePlainFlatYml() throws Exception {
        Path temp1 = createTempFile("/file1.yml");
        Path temp2 = createTempFile("/file2.yml");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_plain_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString(), "plain");

            assertEquals(expected, actual, "Plain flat diff yml is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    @Test
    public void testGenerateJsonFlatYml() throws Exception {
        Path temp1 = createTempFile("/file1.yml");
        Path temp2 = createTempFile("/file2.yml");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_json_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString(), "json");

            assertEquals(expected, actual, "Json flat diff yml is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    @Test
    public void testGenerateDefaultFlatYml() throws Exception {
        Path temp1 = createTempFile("/file1.yml");
        Path temp2 = createTempFile("/file2.yml");

        try {
            String expected = new String(
                    getClass().getResourceAsStream("/expected_stylish_flat.txt").readAllBytes(),
                    StandardCharsets.UTF_8
            );
            String actual = Differ.generate(temp1.toString(), temp2.toString());

            assertEquals(expected, actual, "Default flat diff yml is incorrect");
        } finally {
            Files.deleteIfExists(temp1);
            Files.deleteIfExists(temp2);
        }
    }

    // Helper для temp файлов из classpath (надёжно в CI)
    private Path createTempFile(String resourcePath) throws IOException {
        Path tempFile = Files.createTempFile("test", getExtension(resourcePath));
        byte[] content = getClass().getResourceAsStream(resourcePath).readAllBytes();
        Files.write(tempFile, content);  // Убрал StandardCharsets.UTF_8 — для byte[] не нужен
        return tempFile;
    }

    private String getExtension(String resourcePath) {
        return resourcePath.substring(resourcePath.lastIndexOf("."));
    }
}
