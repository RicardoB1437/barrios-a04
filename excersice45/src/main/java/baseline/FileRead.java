package baseline;

import java.util.ArrayList;
import java.util.List;

public class FileRead
{
    List<String> info = new ArrayList<>();

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public void takeInfoFromFile()
    {
        //make a reader to file
        //read in each line and store in array list
        //List<String> fileInfo = new ArrayList<>();
        //setInfo(fileInfo);
    }

    private List<String> replace(List<String> info)
    {
        //List<String> replaced = new ArrayList<>();
        //for loop through info.length
        //break up the line into individual words
        //String[] arr = info.get(i).split(" ");
        //for(String s : info)
        //if(s.equals("utilize"))
        //s = "use";
        //combine the array of strings back into one string
        //String str = arr.join(" ", arr);
        //add str to list
        //return replaced;
    }

    public void printInfoToFile()
    {
        //make a writer to file
        //call replace(getFileInfo);
        //print the contents of getReplaced() to file
    }
}
