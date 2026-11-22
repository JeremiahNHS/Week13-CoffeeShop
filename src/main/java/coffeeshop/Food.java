package coffeeshop;

// STEP 2 · Food: a MenuItem that can be heated up for 50 cents.
//
// Open UML.md and find "Step 2 · Food extends MenuItem".
// First change the class line below to:   public class Food extends MenuItem {
//
//   1 constant:      HEAT_FEE   (public static final double)
//   1 private field: heated
//   1 constructor:   Food(String name, double price, boolean heated). Its first line is super(name, price);
//   3 methods:       isHeated(), and the overrides getPrice(), toString()
//
// Then drag check/coffeeshop/FoodTest.java into src/test/java/coffeeshop/ and run it.
// Commit message (after Drink is green too):  step 2: Drink and Food

public class Food extends MenuItem {

    public static double HEAT_FEE = 0.50;
    private boolean heated;
    // creates a Food object with a name, price, and whether it is heated
    public Food(String name, double price, boolean heated) {
        super(name, price);
        this.heated = heated;
    }
    // returns whether the food item is heated or not
    public boolean isHeated(){
        return heated;

    }
    // returns the food's price, adding the 50-cent heating fee if it is heated
    @Override
    public double getPrice(){
        if (heated) {
            return super.getPrice() + HEAT_FEE;
        } else {
            return super.getPrice();
        }
    }
    // returns the food's name and price as a formatted String, including whether it is heated
    @Override
    public String toString(){
        if (heated) {
            return super.getName() + ", heated - $" + String.format("%.2f", getPrice());
        } else {
            return super.getName() + " - $" + String.format("%.2f", super.getPrice());

        }
    }
}
