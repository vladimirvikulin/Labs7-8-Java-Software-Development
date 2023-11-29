package tests;

import org.junit.jupiter.api.Test;
import sweets.Sweet;
import static org.junit.jupiter.api.Assertions.*;

class SweetTest {
    @Test
    void isWithinChocolateContentRange() {
        Sweet sweet = new Sweet("Chocolate Bar", 200, 2, 50, "Chocolate", 70.0);

        assertTrue(sweet.isWithinChocolateContentRange(60.0, 80.0));
        assertFalse(sweet.isWithinChocolateContentRange(80.1, 90.0));
    }

    @Test
    void getDescription() {
        Sweet sweet = new Sweet("Candy", 50, 1, 25, "Sweet", 50.0);

        String expectedDescription = "Candy: Weight: 50.0g, Price: $1.25 - Flavor: Sweet - Chocolate Content: 50.0%";
        assertEquals(expectedDescription, sweet.getDescription());
    }
}