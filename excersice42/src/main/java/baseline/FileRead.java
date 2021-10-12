package baseline;
//implements challenge 1 in print function

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileRead
{
    public List<String> takeInfoFromFile() throws RuntimeException
    {
        //make a reader to file
        //read in each line and store in array list
        //return list
        ArrayList<String> names = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/exercise42_input.txt"));
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

    public List<Map<String, String>> separateInfo(List<String> info)
    {
        List<Map<String, String>> separated = new ArrayList<>();
        Map<String, String> mMap;
        //for loop through info.length
        for (String s : info)
        {
            //make a map and input the last name, first name, and salary into corresponding keys
            String[] arr = s.split(",");
            mMap = new HashMap<>();
            mMap.put("lName", arr[0]);
            mMap.put("fName", arr[1]);
            mMap.put("salary", arr[2]);
            separated.add(mMap);
        }
        return separated;
    }

    public void printInfoToFile(List<Map<String, String>> separated)
    {
        //make a writer to file
        //print the contents of the list to file
        FileRead file = new FileRead();
        int size = separated.size();

        //find amount of spaces between columns
        int longestFName = 0;
        int longestLName = 0;
        for(int i=0;i<size;i++)
        {
            //find num spaces for fname tab
            if(separated.get(i).get("fName").length() > longestFName)
                longestFName = separated.get(i).get("fName").length();
            //find num spaces for lname tab
            if(separated.get(i).get("lName").length() > longestLName)
                longestLName = separated.get(i).get("lName").length();
        }
        try
        {
            FileWriter writer = new FileWriter("data/exercise42_output.txt");

            //header
            writer.write("Last");
            for(int i=4;i<=longestLName;i++)
            {
                writer.write(" ");
            }
            writer.write("First");
            for(int i=5;i<=longestFName;i++)
            {
                writer.write(" ");
            }
            writer.write("Salary");
            writer.write("\r\n");
            //+8 accounts for 2 extra spaces and the string "salary"
            for(int i=0;i<longestFName+longestLName+8;i++)
            {
                writer.write("-");
            }
            writer.write("\r\n");

            //names
            for(int i=0;i<size;i++)
            {
                //last name tab
                writer.write(separated.get(i).get("lName"));
                for(int j=separated.get(i).get("lName").length();j<=longestLName;j++)
                {
                    writer.write(" ");
                }
                //first name tab
                writer.write(separated.get(i).get("fName"));
                for(int j=separated.get(i).get("fName").length();j<=longestFName;j++)
                {
                    writer.write(" ");
                }
                //salary tab
                writer.write(separated.get(i).get("salary"));
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
