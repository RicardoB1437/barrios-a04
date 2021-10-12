package baseline;

import org.junit.jupiter.api.Test;

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
        //no need to test void function (just printing)
    }
}