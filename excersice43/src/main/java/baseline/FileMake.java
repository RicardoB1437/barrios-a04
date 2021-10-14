package baseline;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
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
    public void makeFiles() throws RuntimeException
    {
        //make website folder (data/website/websiteName)
        File websiteFile = new File("data/website/" + getSite());
        if(!websiteFile.exists())
        {
            if (websiteFile.mkdirs())
                System.out.println("Created " + "data/website/" + getSite());
            else
                System.out.println("Directory not created");
        }

        //make index.html file (data/website/websiteName/index.html)
        try
        {
            FileWriter writer = new FileWriter("data/website/" + getSite() + "/index.html");
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<meta " + getAuthor() +  ">\n");
            writer.write("<title>" + getSite() + "</title>\n");
            writer.write("</head>\n");
            writer.write("</html>\r\n");
            System.out.println("Created " + "data/website/" + getSite() + "/data.html");
            writer.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not created", e);
        }

        //if(getJava) make js folder (data/website/websiteName/js/)
        if(getJava())
        {
            File jsFile = new File("data/website/" + getSite() + "/js/");
            if(!jsFile.exists())
            {
                if (jsFile.mkdirs())
                    System.out.println("Created " + "data/website/" + getSite() + "/js/");
                else
                    System.out.println("Directory not created");
            }
        }

        //if(getCss) make css folder (data/website/websiteName/css/)
        if(getCss())
        {
            File cssFile = new File("data/website/" + getSite() + "/css/");
            if(!cssFile.exists())
            {
                if (cssFile.mkdirs())
                    System.out.println("Created " + "data/website/" + getSite() + "/css/");
                else
                    System.out.println("Directory not created");
            }
        }
    }
}
