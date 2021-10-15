package baseline;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Parser
{
    public List<Product> parseInfo()
    {
        File input = new File("data/exercise44_input.json");
        List<Product> products = new ArrayList<>();
        try
        {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            //process products
            JsonArray arrayOfProducts = fileObject.get("products").getAsJsonArray();
            for(JsonElement productElement : arrayOfProducts)
            {
                JsonObject productObject = productElement.getAsJsonObject();

                String name = productObject.get("name").getAsString();
                Double price = productObject.get("price").getAsDouble();
                Integer quantity = productObject.get("quantity").getAsInt();

                Product product = new Product(name, price, quantity);
                products.add(product);
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("File not created", e);
        }

        return products;
    }

}
