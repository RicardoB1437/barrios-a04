/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;

/*
 * all current methods/classes will be placed in their proper locations after psuedocode is done
 * they are all here simply for the moment so that i can visualize all code together
 */

public class Solution46
{
    public static void main(String[] args)
    {
        FileInfoReader read = new FileInfoReader();

        //take in the info
        read.takeInfoFromFile();

        //count the words
        read.countWords();

        //print out the info
        read.printInfoToFile();
    }
}
