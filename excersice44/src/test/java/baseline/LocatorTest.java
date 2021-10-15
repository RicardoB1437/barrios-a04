package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocatorTest {

    @Test
    void isValidProduct()
    {
        Locator test = new Locator();

        String str = "Doodad";
        boolean expected = true;
        boolean actual = test.isValidProduct(str);

        assertEquals(expected, actual);
    }

    @Test
    void locate()
    {
        Locator test = new Locator();

        String str = "Doodad";
        Product expected = new Product("Doodad", 5.00, 10);
        Product actual = test.locate(str);

        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPrice(), actual.getPrice());
        assertEquals(expected.getQuantity(), actual.getQuantity());
    }
}