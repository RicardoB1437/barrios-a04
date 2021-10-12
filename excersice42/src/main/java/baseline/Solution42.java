/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;
import java.util.*;

/*
 * all current methods/classes will be placed in their proper locations after psuedocode is done
 * they are all here simply for the moment so that i can visualize all code together
 */

public class Solution42
{
    public static void main(String[] args)
    {
        FileRead read = new FileRead();

        //take info from file
        List<String> info = read.takeInfoFromFile();

        //separate info
        List<Map<String, String>> infoMap = read.separateInfo(info);

        //print information to file
        read.printInfoToFile(infoMap);
    }
}
