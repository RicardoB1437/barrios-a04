package baseline;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReadTest {

    @Test
    void takeInfoFromFile()
    {
        FileRead read = new FileRead();

        //take info from file
        read.takeInfoFromFile();

        //make test list
        List<String> testList = new ArrayList<>();
        testList.add("One should never utilize the word \"utilize\" in writing. Use \"use\" instead.");
        testList.add("For example, \"She uses an IDE to write her Java programs\" instead of \"She");
        testList.add("utilizes an IDE to write her Java programs\".");

        int expected = 3;
        int actual = 0;
        for(int i=0;i<testList.size();i++)
        {
            if(testList.get(i).equals(read.getInfo().get(i)));
            actual++;
        }

        assertEquals(expected, actual);
    }

    @Test
    void printInfoToFile()
    {
        //read in info from printed file
        List<String> fileInfo = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/exercise45_output.txt"));
            String line = "";
            while((line=reader.readLine())!=null)
            {
                fileInfo.add(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not found", e);
        }
        //check list of strings and see if it contains "utilize"
        int expected = 0;
        int actual = 0;
        for(int i=0;i<fileInfo.size();i++)
        {
            if(fileInfo.get(i).contains("utilize"))
                actual++;
        }
        //assert equals on 0
        assertEquals(expected, actual);
    }
}