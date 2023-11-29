/**
 * The `Sweet` class represents a basic type of sweet with attributes such as name, weight, price, flavor,
 * and chocolate content.
 */
package sweets;

public class Sweet {
    private String name;
    private double weight;
    private int priceDollars;
    private int priceCents;
    private String flavor;
    private double chocolateContent;

    /**
     * Creates a new `Sweet` object.
     *
     * @param name            The name of the sweet.
     * @param weight          The weight of the sweet in grams.
     * @param priceDollars    The price of the sweet in dollars.
     * @param priceCents      The price of the sweet in cents.
     * @param flavor          The flavor of the sweet.
     * @param chocolateContent The chocolate content in the sweet as a percentage.
     */
    public Sweet(String name, double weight, int priceDollars, int priceCents, String flavor, double chocolateContent) {
        this.name = name;
        this.weight = weight;
        this.priceDollars = priceDollars;
        this.priceCents = priceCents;
        this.flavor = flavor;
        this.chocolateContent = chocolateContent;
    }

    /**
     * Gets the flavor of the sweet.
     *
     * @return The flavor of the sweet.
     */
    public String getFlavor() {
        return flavor;
    }

    /**
     * Gets the chocolate content in the sweet.
     *
     * @return The chocolate content in the sweet as a percentage.
     */
    public double getChocolateContent() {
        return chocolateContent;
    }

    /**
     * Checks if the chocolate content is within a specified range.
     *
     * @param minChocolate The minimum chocolate content.
     * @param maxChocolate The maximum chocolate content.
     * @return `true` if the chocolate content is within the specified range; otherwise, `false`.
     */
    public boolean isWithinChocolateContentRange(double minChocolate, double maxChocolate) {
        double chocolateContent = getChocolateContent();
        return chocolateContent >= minChocolate && chocolateContent <= maxChocolate;
    }

    /**
     * Gets the name of the sweet.
     *
     * @return The name of the sweet.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the weight of the sweet.
     *
     * @return The weight of the sweet in grams.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Gets the dollars part of the sweet's price.
     *
     * @return The price of the sweet in dollars.
     */
    public int getPriceDollars() {
        return priceDollars;
    }

    /**
     * Gets the cents part of the sweet's price.
     *
     * @return The price of the sweet in cents.
     */
    public int getPriceCents() {
        return priceCents;
    }

    /**
     * Generates a description of the sweet, including its name, weight, price, flavor, and chocolate content.
     *
     * @return A string description of the sweet.
     */
    public String getDescription() {
        String description = "Weight: " + weight + "g, Price: $" + priceDollars + "." + priceCents + " - Flavor: " + flavor + " - Chocolate Content: " + chocolateContent + "%";
        return name + ": " + description;
    }
}
