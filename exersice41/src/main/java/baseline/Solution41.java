/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;
import java.io.IOException;
import java.util.*;
import java.util.Collections;

/*
 * all previous methods/classes located here were placed in their correct locations
 */

public class Solution41
{
    public static void main(String[] args) throws IOException {
        FileRead read = new FileRead();

        //take input from file
        ArrayList<String> names = read.takeNamesFromFile();

        //sort list
        Collections.sort(names);

        //print sorted list to file
        read.printNamesToFile(names);
    }
}

