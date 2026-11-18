package coffeeshop;

import java.util.ArrayList;

// STEP 3 · Menu: the 8 things the shop sells.
//
// Open UML.md and find "Step 3 · Menu". The table there lists the 8 items, in order.
//   1 private field: items   (an ArrayList<MenuItem>)
//   1 constructor:   Menu(). It makes the list and adds the 8 items.
//   3 methods:       size(), getItem(int number), toString()
//
// Then drag check/coffeeshop/MenuTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 3: Menu

public class Menu {

    private ArrayList<MenuItem> items;
    // creates a Menu object and adds 8 menu items to its list
    public Menu() {
        items = new ArrayList<>(8);
        items.add(new Drink("Coffee",2.00,'S'));
        items.add(new Drink("Latte",3.25,'S'));
        items.add(new Drink("Cappuccino",3.25,'S'));
        items.add(new Drink("Hot Chocolate",2.50,'S'));
        items.add(new Drink("Iced Tea",2.25,'S'));
        items.add(new Food("Bagel",2.75,false));
        items.add(new Food("Blueberry Muffin",2.50,false));
        items.add(new Food("Breakfast Sandwich",4.50,false));
    }
    // returns the number of items in the menu
    public int size(){
        return items.size();
    }
    // returns the menu item at the given number, or null if the number is invalid
    public MenuItem getItem(int number){
        if (number < 1 || number > size()) {
            return null;
        }
        return items.get(number - 1);
    }
    // returns all menu items as a numbered list in a String
    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i < size(); i++){
            result += (i + 1) + ". " + items.get(i)  + "\n";
        }
        return result;
    }
}

