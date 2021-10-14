package baseline;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileMakeTest {

    @Test
    void makeFiles()
    {
        File websiteFile = new File("data/website/awesomeco/");
        boolean webExpected = true;
        boolean webActual = websiteFile.exists();
        assertEquals(webExpected, webActual);

        File cssFile = new File("data/website/awesomeco/css/");
        boolean cssExpected = true;
        boolean cssActual = cssFile.exists();
        assertEquals(cssExpected, cssActual);

        File jsFile = new File("data/website/awesomeco/js/");
        boolean jsExpected = true;
        boolean jsActual = jsFile.exists();
        assertEquals(jsExpected, jsActual);

        //test contents of html file
        List<String> names = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/website/awesomeco/index.html"));
            String line = "";
            while((line=reader.readLine())!=null)
            {
                names.add(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not found", e);
        }

        int actual = 0;
        int expected = 2;
        for(String s : names)
        {
            if(s.contains("Max Power"))
                actual++;
            if(s.contains("awesomeco"))
                actual++;
        }
        assertEquals(expected, actual);
    }
}