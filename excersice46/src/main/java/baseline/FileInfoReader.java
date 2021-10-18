package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileInfoReader
{
    List<String> fileInfo = new ArrayList<>();
    Map<String, Integer> wordCount = new HashMap<>();

    public List<String> getFileInfo() {
        return fileInfo;
    }
    private void setFileInfo(List<String> fileInfo) {
        this.fileInfo = fileInfo;
    }

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }
    private void setWordCount(Map<String, Integer> wordCount) {
        this.wordCount = wordCount;
    }

    public void takeInfoFromFile()
    {
            //make a reader to file
            //read in each line and store in array list
            List<String> file = new ArrayList<>();
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("data/exercise46_input.txt"));
                String line = "";
                while((line=reader.readLine())!=null)
                {
                    file.add(line);
                }
                reader.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("File not found", e);
            }
            setFileInfo(file);
    }

    public Map<String, Integer> countWords()
    {
        List<String> file = getFileInfo();

        //map to store word bank
        Map<String, Integer> words = new HashMap<>();

        //loop through every line in the file
        for(String s : file)
        {
            String arr[] = s.split(" ");
            words = new HashMap<>();
            //update the map every time word is found
            for(String str : arr)
            {
                if(words.containsKey(str))
                    words.put(str, 1 + words.get(str));
                else
                    words.put(str, 1);
            }
        }
        //this will set the map
        setWordCount(words);
        //return for testing purposes
        return words;
    }

    public void printInfoToFile() throws RuntimeException
    {
        //make a writer to file
        //print the contents to a file

        //find the longest word
        Map<String, Integer> words = getWordCount();
        try
        {
            FileWriter writer = new FileWriter("data/exercise46_output.txt");

            //find most used word
            for(int i=0;i<words.size();i++)
            {
                int maxValueInMap = (Collections.max(words.values()));

                //loop through map
                for(Map.Entry<String, Integer> entry : words.entrySet())
                {
                    if(entry.getValue() == maxValueInMap)
                    {
                        //print value
                        System.out.println(entry.getKey());
                        System.out.println(entry.getValue());
                        writer.write(entry.getKey() + " " + entry.getValue() + "\n");
                    }
                }
            }

            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not created", e);
        }
    }
}
