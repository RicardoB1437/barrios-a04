/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;

/*
 * all previous methods/classes located here were placed in their correct locations
 */

public class Solution45
{
    public static void main(String[] args)
    {
        FileRead read = new FileRead();

        read.takeInfoFromFile();
        read.promptForFileName();
        read.printInfoToFile();
    }
}
