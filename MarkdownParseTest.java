import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class MarkdownParseTest {
    ArrayList<String> testFileExpected;

    @Before
    public void setUp() {
        testFileExpected = new ArrayList<String>(
            Arrays.asList("https://something.com", "some-thing.html"));

    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void TestFile1() throws IOException{
        Path testFilePath = Path.of("test-file.md");
        System.out.println(testFilePath);

        String testFileString = Files.readString(testFilePath);
        assertEquals("checking links from test-file", 
            testFileExpected, MarkdownParse.getLinks(testFileString));
    }
}