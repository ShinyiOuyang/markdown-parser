import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


public class MarkdownParseTest {

    @Before
    public void setUp() {

    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void TestFile1() throws IOException{
        ArrayList<String> testFileExpected = new ArrayList<String>(
                Arrays.asList("https://something.com", "some-thing.html"));

        Path testFilePath = Path.of("test-file.md");
        String testFile = Files.readString(testFilePath);
        assertEquals("checking links from test-file", 
            testFileExpected, MarkdownParse.getLinks(testFile));
    }

    @Test
    public void ImageTest() throws IOException {
        ArrayList<String> imageFileExpected = new ArrayList<String>(
            Arrays.asList(
                "https://canvas.ucsd.edu/courses/37651/modules", 
                "www.wikipedia.org"
            )
        );
        String imageFile = Files.readString(Path.of("image-test.md"));
        assertEquals("checking links from image-test",
                imageFileExpected, MarkdownParse.getLinks(imageFile));
    }

    @Test
    public void randomInputTest() throws IOException {
        // empty arrayList
        ArrayList<String> randomInputFileExpected = new ArrayList<String>(); 

        String randomInputFile = Files.readString(
            Path.of("random-input-test.md")
        );
        assertEquals("checking links from random-input-test",
                randomInputFileExpected, 
                MarkdownParse.getLinks(randomInputFile)
        );
    }

    @Test
    public void myTestFile2() throws IOException {
        ArrayList<String> myTestFile2Expected = new ArrayList<String>();

        String myTestFile2File = Files.readString(
                Path.of("my-test-file-2.md")
        );
        assertEquals("checking links from my-test-file-2",
                myTestFile2Expected,
                MarkdownParse.getLinks(myTestFile2File)
        );
    }

    @Test
    public void myTestFile1() throws IOException {
        ArrayList<String> myTestFileExpected = new ArrayList<String>();
        myTestFileExpected.add("https://canvas.ucsd.edu/courses/37651/modules");
        myTestFileExpected.add("www.wikipedia.org");

        String myTestFileFile = Files.readString(
                Path.of("my-test-file.md"));
        assertEquals("checking links from my-test-file",
                myTestFileExpected,
                MarkdownParse.getLinks(myTestFileFile));
    }
    
    @Test
    public void test7() throws IOException {
        ArrayList<String> test7FileExpected = new ArrayList<String>();

        String test7File = Files.readString(
                Path.of("test7.md"));
        assertEquals("checking links from test7",
                test7FileExpected,
                MarkdownParse.getLinks(test7File));
    }

    @Test
    public void test8() throws IOException {
        ArrayList<String> test8FileExpected = new ArrayList<String>();

        String test8File = Files.readString(
                Path.of("test8.md"));
        assertEquals("checking links from test8",
                test8FileExpected,
                MarkdownParse.getLinks(test8File));
    }
}