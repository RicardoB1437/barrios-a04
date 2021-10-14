package baseline;
import java.util.*;
import java.util.Scanner;

public class FileMake
{
    Scanner input = new Scanner(System.in);

    //make class variables
    private String site;
    private String author;
    private String java;
    private String css;

    //prompt and set all information
    //no need to make this a separate class because then id have to make the class variables public
    public void promptForInfo()
    {
        System.out.print("Site name: ");
        this.site = input.nextLine();
        System.out.print("Author: ");
        this.author = input.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        this.java = input.nextLine();
        System.out.print("Do you want a folder for CSS? ");
        this.css = input.nextLine();
    }

    //functions to return information
    private String getSite()
    {
        return site;
    }
    private String getAuthor()
    {
        return author;
    }
    private boolean getJava()
    {
        return java.equals("y");
    }
    private boolean getCss()
    {
        return css.equals("y");
    }

    //makes the files
    public void makeFiles()
    {
        //make website folder (data/website/websiteName)

        //make index.html file (data/website/websiteName/index.html)

        //if(getJava) make js folder (data/website/websiteName/js/)

        //if(getCss) make css folder (data/website/websiteName/css/)
    }
}
