package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead
{
    public ArrayList<String> takeNamesFromFile() throws RuntimeException
    {
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
        return names;
    }

    public void printNamesToFile(ArrayList<String> names) throws RuntimeException
    {
        int size = names.size();
        String sizeString = String.valueOf(size);
        try
        {
            FileWriter writer = new FileWriter("data/exercise41_output.txt");
            //header
            writer.write("Total of ");
            writer.write(sizeString);
            writer.write(" names\n");
            writer.write("-----------------\n");
            //names
            for(String s: names)
            {
                writer.write(s);
                writer.write("\r\n");
            }
            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not created", e);
        }
    }
}