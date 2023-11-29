/**
 * The `Gift` class represents a collection of sweets and provides methods to manage and
 * perform operations on the sweets in the gift.
 */
package gift;

import sweets.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gift {
    private List<Sweet> sweets = new ArrayList<>();

    /**
     * Adds a sweet to the gift.
     *
     * @param sweet The sweet to add to the gift.
     */
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    /**
    * Converts the total weight of the gift to kilograms if it's more than 1000 grams.
    *
    * @return The total weight of the gift in kilograms if it's more than 1000 grams; otherwise, returns the weight in grams.
    */
    public String getTotalWeight() {
        double totalWeight = 0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.getWeight();
        }
        if (totalWeight >= 1000) {
            double weightInKilograms = totalWeight / 1000;
            return weightInKilograms + " kg";
        } else {
            return totalWeight + " g";
        }
    }

    /**
     * Sorts the sweets in the gift by their price in ascending order.
     */
    public void sortSweetsByPrice() {
        Collections.sort(sweets, (sweet1, sweet2) -> {
            int priceComparison = Integer.compare(sweet1.getPriceDollars(), sweet2.getPriceDollars());
            if (priceComparison == 0) {
                return Integer.compare(sweet1.getPriceCents(), sweet2.getPriceCents());
            }
            return priceComparison;
        });
    }

    /**
     * Finds and returns a list of sweets in the gift with chocolate content within a specified range.
     *
     * @param minChocolate The minimum chocolate content percentage.
     * @param maxChocolate The maximum chocolate content percentage.
     * @return A list of sweets with chocolate content within the specified range.
     */
    public List<Sweet> findSweetsByChocolateContentRange(double minChocolate, double maxChocolate) {
        List<Sweet> selectedSweets = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if (sweet.isWithinChocolateContentRange(minChocolate, maxChocolate)) {
                selectedSweets.add(sweet);
            }
        }
        return selectedSweets;
    }

    /**
     * Displays the descriptions of all sweets in the gift.
     */
    public void displaySweets() {
        for (Sweet sweet : sweets) {
            System.out.println(sweet.getDescription());
        }
    }
}