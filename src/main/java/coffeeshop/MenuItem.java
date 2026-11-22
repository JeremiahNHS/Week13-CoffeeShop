package coffeeshop;

// STEP 1 · MenuItem: one thing you can buy at the coffee shop.
//
// Open UML.md and find "Step 1 · MenuItem". Build everything in that table:
//   2 private fields:  name, price
//   1 constructor:     MenuItem(String name, double price)
//   4 methods:         getName(), getPrice(), isDrink(), toString()
//
// Then drag check/coffeeshop/MenuItemTest.java into src/test/java/coffeeshop/ and run it.
// Commit message when it is all green:  step 1: MenuItem

public class MenuItem {

    final private String name;
    final private double price;
    // constructor fo the MenuItem class which takes 2 parameters; name and price
    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }
    // returns the name of the menu item
    public String getName(){
        return name;
    }
    // returns the price
    public double getPrice(){
        return price;
    }
    // returns if the menu item is a drink or not
    public boolean isDrink(){
        return false;
    }
    // overwritten toString method returns the name and a formatted double all as a String
    @Override
    public String toString(){
        return name + " - $" + String.format("%.2f", getPrice());
    }

}
