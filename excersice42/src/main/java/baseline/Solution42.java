/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;
import java.util.*;
import java.util.Scanner;

/*
 * all current methods/classes will be placed in their proper locations after psuedocode is done
 * they are all here simply for the moment so that i can visualize all code together
 */

public class Solution42
{
    public List<String> takeInfoFromFile()
    {
        //make a reader to file
        //read in each line and store in array list
        //return list
    }

    public List<Map<String, String>> separateInfo(List<String> info)
    {
        //for loop through info.length
        //String[] arr = info.get(i).split(",");
        //arr[0] = last name, arr[1] = first name, arr[2] = salary
        //make a map and input the last name, first name, and salary into corresponding keys
        //add map to new list and return list
    }

    public void printInfoToFile(List<Map<String, String>> separated)
    {
        //make a writer to file
        //print the contents of the list to file
    }

    public static void main(String[] args)
    {
        //FileReader read = new FileReader();

        //take info from file
        //ArrayList<String> info = read.takeInfoFromFile();

        //separate info
        //List<Map<String, String>> infoMap = read.separateInfo(info);

        //print information to file
        //read.printInfoToFile(infoMap);
    }
}
