/**
 * The `Lollipop` class represents a type of sweet with additional attributes to describe its shape.
 */
package sweets;

public class Lollipop extends Sweet {
    private String lollipopShape;

    /**
     * Creates a new `Lollipop` object.
     *
     * @param name             The name of the lollipop.
     * @param weight           The weight of the lollipop in grams.
     * @param priceDollars     The price of the lollipop in dollars.
     * @param priceCents       The price of the lollipop in cents.
     * @param flavor           The flavor of the lollipop.
     * @param chocolateContent The chocolate content in the lollipop as a percentage.
     * @param lollipopShape    The shape of the lollipop.
     */
    public Lollipop(String name, double weight, int priceDollars, int priceCents, String flavor, double chocolateContent, String lollipopShape) {
        super(name, weight, priceDollars, priceCents, flavor, chocolateContent);
        this.lollipopShape = lollipopShape;
    }

    /**
     * Gets the shape of the lollipop.
     *
     * @return The shape of the lollipop.
     */
    public String getLollipopShape() {
        return lollipopShape;
    }

    /**
     * Generates a description of the lollipop, including its name, weight, price, flavor,
     * chocolate content, and shape.
     *
     * @return A string description of the lollipop.
     */
    @Override
    public String getDescription() {
        String description = super.getDescription();
        description += " - Lollipop Shape: " + lollipopShape;
        return description;
    }
}
