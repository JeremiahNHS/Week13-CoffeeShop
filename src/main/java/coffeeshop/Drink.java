package coffeeshop;

// STEP 2 · Drink: a MenuItem that comes in a size, S, M or L.
//
// Open UML.md and find "Step 2 · Drink extends MenuItem".
// First change the class line below to:   public class Drink extends MenuItem {
// (It does not say "extends" yet, so this file still compiles while you work on Step 1.)
//
//   2 constants:     MEDIUM_UPCHARGE, LARGE_UPCHARGE   (public static final double)
//   1 private field: size
//   1 constructor:   Drink(String name, double price, char size). Its first line is super(name, price);
//   4 methods:       getSize(), and the overrides getPrice(), isDrink(), toString()
//
// Then drag check/coffeeshop/DrinkTest.java into src/test/java/coffeeshop/ and run it.
// Commit message (after Food is green too):  step 2: Drink and Food

public class Drink extends MenuItem {

    public final static double MEDIUM_UPCHARGE = 0.50;
    public final static double LARGE_UPCHARGE = 1.00;
    private char size;
    // creates a Drink object with a name, price, and size
    public Drink(String name, double price, char size) {
        super(name, price);
        this.size = Character.toUpperCase(size);
    }
    // returns the drink's size as an uppercase letter, defaulting to S if the size is invalid
    public char getSize() {
        if (size == 'M' || size == 'L' || size == 'S'){
            return size;
        } else {
            return 'S';
        }
    }
    // returns the drink's price with an additional charge for medium or large sizes
    @Override
    public double getPrice(){
        if (getSize() == 'M') {
            return super.getPrice() + MEDIUM_UPCHARGE;
        } else if (getSize() == 'L'){
            return super.getPrice() + LARGE_UPCHARGE;
        } else {
            return super.getPrice();
        }
    }
    // returns true to identify this item as a drink
    @Override
    public boolean isDrink(){
        return true;
    }
    // returns the drink's name, size, and formatted price as a String
    @Override
    public String toString() {
        return super.getName() + " (" + getSize() + ") - $" + String.format("%.2f", getPrice());

    }
}

