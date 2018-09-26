/**
 * CSCI 205 - Software Engineering and Design
 *
 * Lab 09 - Learning how to use JUnit.
 *
 * @author RIck Zaccone
 */
package lab09;

/**
 * A simple enum type to represent distinct denominations of money.
 *
 * Adapted from a CSCI 204 lab, originally designed by Rick Zaccone
 *
 * @author Rick Zaccone
 */
public enum Money {
    /**
     * Each type of currency initialized with its value and name/label
     */
    PENNY(0.01, "penny"), NICKEL(0.05, "nickel"), DIME(0.1, "dime"), QUARTER(
            0.25, "quarter"), HALF(0.5, "half"), DOLLAR(1.0, "dollar"), FIVE(
            5.0, "five"), TEN(10.0, "ten"), TWENTY(20.0, "twenty");

    /**
     * value of each type of currency
     */
    private double value;

    /**
     * name/label of each type of currency
     */
    private String name;

    /**
     * Constructs a new currency value.
     *
     * @param value the value of this currency
     */
    Money(double value, String name) {
        this.value = value;
        this.name = name;
    }

    /**
     * Gets the value of this currency.
     *
     * @return value of the currency
     */
    public double getValue() {
        return value;
    }

    /**
     * Gets the name of this currency.
     *
     * @return the name of the currency
     */
    public String getName() {
        return name;
    }
}
