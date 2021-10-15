package baseline;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Locator
{
    Scanner input = new Scanner(System.in);

    private List<Product> products = new ArrayList<>();
    private String searchString;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts() {
        Parser parse = new Parser();
        this.products = parse.parseInfo();
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public boolean isValidProduct(String str)
    {
        //goes through list of products and checks if it contains str
        setProducts();
        for(Product finder : getProducts())
        {
            if(finder.getName().equals(str))
            {
                return true;
            }
        }
        return false;
    }

    private String takeSearchString()
    {
        //prompt for search string
        System.out.print("What is the product name? ");
        setSearchString(input.nextLine());
        return getSearchString();
    }

    public String takeValidString()
    {
        //loops through until valid product is entered
        String str = takeSearchString();
        while(!isValidProduct(str))
        {
            System.out.println("Sorry, that product was not found in our inventory.");
            str = takeSearchString();
        }
        return str;
    }

    public Product locate(String searchString)
    {
        //loop through list of products until search string is found and return it
        setProducts();
        Product found = null;
        for(Product finder : getProducts())
        {
            if(finder.getName().equals(searchString))
            {
                found = finder;
            }
        }
        return found;
    }

    public void printLocatedInfo(Product desiredProduct)
    {
        System.out.printf("Name: %s%n", desiredProduct.getName());
        System.out.printf("Price: %.2f%n", desiredProduct.getPrice());
        System.out.printf("Quantity: %d%n", desiredProduct.getQuantity());
    }
}
