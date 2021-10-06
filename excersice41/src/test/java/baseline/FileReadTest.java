package baseline;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileReadTest {

    @Test
    void takeNamesFromFile()
    {
        //take in input
        ArrayList<String> names = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/exercise41_input.txt"));
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

        //make test list
        ArrayList<String> test = new ArrayList<>();
        test.add("Ling, Mai");
        test.add("Johnson, Jim");
        test.add("Zarnecki, Sabrina");
        test.add("Jones, Chris");
        test.add("Jones, Aaron");
        test.add("Swift, Geoffrey");
        test.add("Xiong, Fong");

        //test input and see if matches
        int expected = 7;
        int actual = 0;
        for(int i=0;i<names.size();i++)
        {
            if(names.get(i).equals(test.get(i)))
            {
                actual++;
            }
        }

        //assert equals on amount of matches between hard coded names and names taken from file
        assertEquals(expected, actual);
    }
}