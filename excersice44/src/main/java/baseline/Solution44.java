/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Ricardo Barrios
 */

package baseline;

/*
 * all previous methods/classes located here were placed in their correct locations
 */

public class Solution44
{
    public static void main(String[] args)
    {
        Locator locator = new Locator();

        String searchString = locator.takeValidString();
        Product desiredProduct = locator.locate(searchString);
        locator.printLocatedInfo(desiredProduct);
    }
}


