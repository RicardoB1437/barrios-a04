package baseline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileRead
{
    Scanner input = new Scanner(System.in);
    List<String> info = new ArrayList<>();
    String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getInfo() {
        return info;
    }
    public void setInfo(List<String> info) {
        this.info = info;
    }

    public void promptForFileName()
    {
        System.out.print("Where would you like to print output? ");
        setFileName(input.nextLine());
    }

    public void takeInfoFromFile() throws RuntimeException
    {
        //make a reader to file
        //read in each line and store in array list
        List<String> fileInfo = new ArrayList<>();
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("data/exercise45_input.txt"));
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
        setInfo(fileInfo);
    }

    private List<String> replace(List<String> fileInfo)
    {
        List<String> replaced = new ArrayList<>();
        //for loop through info.length
        //no longer need to break up each string into individual words
        //String.replace does the job
        for(int i=0;i<fileInfo.size();i++)
        {
            String str = fileInfo.get(i).replace("utilize", "use");
            replaced.add(str);
        }
        return replaced;
    }

    public void printInfoToFile() throws RuntimeException
    {
        //make a writer to file
        //call replace(getFileInfo);
        List<String> replaced = replace(getInfo());

        //print the contents of getReplaced() to file
        try
        {
            FileWriter writer = new FileWriter(getFileName());
            for(String s : replaced)
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
