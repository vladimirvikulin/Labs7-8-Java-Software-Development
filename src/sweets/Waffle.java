/**
 * The `Waffle` class represents a type of sweet with additional attributes to describe its type.
 */
package sweets;

public class Waffle extends Sweet {
    private String waffleType;

    /**
     * Creates a new `Waffle` object.
     *
     * @param name             The name of the waffle.
     * @param weight           The weight of the waffle in grams.
     * @param priceDollars     The price of the waffle in dollars.
     * @param priceCents       The price of the waffle in cents.
     * @param flavor           The flavor of the waffle.
     * @param chocolateContent The chocolate content in the waffle as a percentage.
     * @param waffleType       The type of waffle.
     */
    public Waffle(String name, double weight, int priceDollars, int priceCents, String flavor, double chocolateContent, String waffleType) {
        super(name, weight, priceDollars, priceCents, flavor, chocolateContent);
        this.waffleType = waffleType;
    }

    /**
     * Gets the type of the waffle.
     *
     * @return The type of the waffle.
     */
    public String getWaffleType() {
        return waffleType;
    }

    /**
     * Generates a description of the waffle, including its name, weight, price, flavor,
     * chocolate content, and waffle type.
     *
     * @return A string description of the waffle.
     */
    @Override
    public String getDescription() {
        String description = super.getDescription();
        description += " - Waffle Type: " + waffleType;
        return getName() + description;
    }
}
