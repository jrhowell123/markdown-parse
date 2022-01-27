import static org.junit.Assert.*;
import java.beans.Transient;
import org.junit.*;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.io.IOException;


public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFileOne() throws IOException{
        String contentsTest = Files.readString(Path.of("test-file.md"));
        assertEquals(List.of("https://something.com","some-page.html"),
            MarkdownParse.getLinks(contentsTest));
    }
}