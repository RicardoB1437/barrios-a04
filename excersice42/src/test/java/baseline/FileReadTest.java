package baseline;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileReadTest {

    @Test
    void takeInfoFromFile()
    {
        FileRead read = new FileRead();

        //take info from file
        List<String> info = read.takeInfoFromFile();

        //make test list
        ArrayList<String> test = new ArrayList<>();
        test.add("Ling,Mai,55900");
        test.add("Johnson,Jim,56500");
        test.add("Jones,Aaron,46000");
        test.add("Jones,Chris,34500");
        test.add("Swift,Geoffrey,14200");
        test.add("Xiong,Fong,65000");
        test.add("Zarnecki,Sabrina,51500");

        //test input and see if matches
        int expected = 7;
        int actual = 0;
        for(int i=0;i<info.size();i++)
        {
            if(info.get(i).equals(test.get(i)))
                actual++;
        }

        //assert equals on amount of matches between hard coded info and info taken from file
        assertEquals(expected, actual);
    }

    @Test
    void separateInfo()
    {
        FileRead read = new FileRead();

        List<String> test = new ArrayList<>();
        test.add("Ling,Mai,55900");

        String lName = "Ling";
        String fName = "Mai";
        String salary = "55900";

        List<Map<String, String>> infoMap = read.separateInfo(test);
        assertEquals(infoMap.get(0).get("lName"), lName);
        assertEquals(infoMap.get(0).get("fName"), fName);
        assertEquals(infoMap.get(0).get("salary"), salary);
    }

    @Test
    void printInfoToFile()
    {
        FileRead read = new FileRead();

        ArrayList<String> info = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/exercise42_output.txt"));
            String line = "";
            while((line=reader.readLine())!=null)
            {
                info.add(line);
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not found", e);
        }

        String expected = "Johnson  Jim      56500";
        String actual = info.get(3);

        String expected2 = "Swift    Geoffrey 14200";
        String actual2 = info.get(6);

        //testing random spots in the file, if they are right then we can assume the whole file printed right
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
    }
}