package tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import gift.Gift;
import sweets.Sweet;

class GiftTest {
    @Test
    void getTotalWeight() {
        Gift gift = new Gift();
        gift.addSweet(new Sweet("Chocolate Bar", 200, 2, 50, "Chocolate", 70.0));
        gift.addSweet(new Sweet("Candy", 50, 1, 25, "Sweet", 50.0));

        assertEquals("250.0 g", gift.getTotalWeight());

        gift.addSweet(new Sweet("Candy", 1000, 1, 25, "Sweet", 50.0));
        assertEquals("1.25 kg", gift.getTotalWeight());
    }

    @Test
    void sortSweetsByPrice() {
        Gift gift = new Gift();
        gift.addSweet(new Sweet("Chocolate Bar", 200, 2, 50, "Chocolate", 70.0));
        gift.addSweet(new Sweet("Candy", 50, 1, 25, "Sweet", 50.0));

        gift.sortSweetsByPrice();

        assertEquals("Candy: Weight: 50.0g, Price: $1.25 - Flavor: Sweet - Chocolate Content: 50.0%", gift.findSweetsByChocolateContentRange(0, 100).get(0).getDescription());
    }

    @Test
    void findSweetsByChocolateContentRange() {
        Gift gift = new Gift();
        gift.addSweet(new Sweet("Chocolate Bar", 200, 2, 50, "Chocolate", 70.0));
        gift.addSweet(new Sweet("Candy", 50, 1, 25, "Sweet", 50.0));

        assertEquals(1, gift.findSweetsByChocolateContentRange(60.0, 80.0).size());
    }
}