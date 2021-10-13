/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;
import java.util.*;

/*
 * all previous methods/classes located here were placed in their correct locations
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
