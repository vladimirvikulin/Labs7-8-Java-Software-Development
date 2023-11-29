/**
 * The `Candy` class represents a type of sweet with additional attributes to indicate
 * if it has a filling.
 */
package sweets;

public class Candy extends Sweet {
    private boolean hasFilling;

    /**
     * Creates a new `Candy` object.
     *
     * @param name           The name of the candy.
     * @param weight         The weight of the candy in grams.
     * @param priceDollars   The price of the candy in dollars.
     * @param priceCents     The price of the candy in cents.
     * @param flavor         The flavor of the candy.
     * @param chocolateContent The chocolate content in the candy as a percentage.
     * @param hasFilling     Indicates if the candy has a filling.
     */
    public Candy(String name, double weight, int priceDollars, int priceCents, String flavor, double chocolateContent, boolean hasFilling) {
        super(name, weight, priceDollars, priceCents, flavor, chocolateContent);
        this.hasFilling = hasFilling;
    }

    /**
     * Checks if the candy has a filling.
     *
     * @return `true` if the candy has a filling; otherwise, `false`.
     */
    public boolean hasFilling() {
        return hasFilling;
    }

    /**
     * Generates a description of the candy, including its name, weight, price, flavor,
     * chocolate content, and whether it has a filling.
     *
     * @return A string description of the candy.
     */
    @Override
    public String getDescription() {
        String description = super.getDescription();
        if (hasFilling) {
            description += " - Has Filling";
        }
        return description;
    }
}
