import static org.junit.Assert.*;

import java.beans.Transient;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFileOne() throws IOException{
        String contentsTest = Files.readstring(path.of("test-file.md"));
        assertequals(list.of("https://something.com","some-page.html"),
            MarkdownParse.getLinks(contentsTest));
    }
}