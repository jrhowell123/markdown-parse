import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


//javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
//java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
public class MarkdownParseTest {
    @Test
    public void addition() throws IOException {
        // assertEquals(2, 1 + 1);

        String contentsTest = Files.readString(Path.of("test-file.md"));
        String contentsTest1 = Files.readString(Path.of("test-file2.md"));
        String contentsTest2 = Files.readString(Path.of("test-file3.md"));
        String contentsTestSnippet1 = Files.readString(Path.of("test-fileSnippet1.md"));
        String contentsTestSnippet2 = Files.readString(Path.of("test-fileSnippet2.md"));
        String contentsTestSnippet3 = Files.readString(Path.of("test-fileSnippet3.md"));

        assertEquals(List.of("https://something.com", "some-page.html"), 
            MarkdownParse.getLinks(contentsTest));
        assertEquals(List.of("https://anything.com"), 
            MarkdownParse.getLinks(contentsTest1));
        assertEquals(List.of("weird-page.html"), 
            MarkdownParse.getLinks(contentsTest2));
        assertEquals(List.of("url.com","`google.com","google.com","ucsd.edu"), 
            MarkdownParse.getLinks(contentsTestSnippet1));
        assertEquals(List.of("b.com","a.com(())","example.com"), 
            MarkdownParse.getLinks(contentsTestSnippet2));
        assertEquals(List.of("https://www.twitter.com","https://ucsd-cse15l-w22.github.io/","https://cse.ucsd.edu/"), 
            MarkdownParse.getLinks(contentsTestSnippet3));
    }
}