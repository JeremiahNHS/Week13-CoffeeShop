package coffeeshop;

import java.util.ArrayList;

// STEP 5 · CoffeeShop: the shop, its menu, and every order it finished today.
//
// Open UML.md and find "Step 5 · CoffeeShop".
//   4 private fields: name, menu, completedOrders, totalSales
//   1 constructor:    CoffeeShop(String name)
//   7 methods:        getName(), getMenu(), checkout(), getOrdersCompleted(),
//                     getTotalSales(), getItemsSold(), salesReport()
//
// Then drag check/coffeeshop/CoffeeShopTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 5: CoffeeShop

public class CoffeeShop {

    private String name;
    private Menu menu;
    private ArrayList<Order> completedOrders;
    private double totalSales;
    // creates a CoffeeShop object with a name, a menu and an empty list of completed orders
    public CoffeeShop(String name){
        this.name = name;
        menu = new Menu();
        completedOrders = new ArrayList<>();
    }
    // returns the Coffee Shop's name
    public String getName(){
        return name;
    }
    // returns the Coffee Shop's menu
    public Menu getMenu(){
        return menu;
    }
    // adds a non-empty order to completed orders, updates total sales, and returns the order's total
    public double checkout(Order order, int tipPercent){
        if (order.getItemCount() != 0){
            completedOrders.add(order);
            totalSales += order.getTotal(tipPercent);
            return order.getTotal(tipPercent);
        }
        return 0;
    }
    // returns the number of completed orders
    public int getOrdersCompleted(){
        return completedOrders.size();
    }
    // returns the total sales made by the Coffee Shop
    public double getTotalSales(){
        return totalSales;
    }
    // returns the total number of items sold across all completed orders
    public int getItemsSold(){
        int itemsSold = 0;
        for (Order i : completedOrders){
            itemsSold += i.getItemCount();
        }
        return itemsSold;
    }
    // returns a report of the orders completed, items sold and total sales as a String
    public String salesReport(){
        return "\nHornet Coffee - today's sales\n\tOrders: "
                + getOrdersCompleted() + "\n\tItems sold: "
                + getItemsSold() + "\n\tTotal: $" + String.format("%.2f",getTotalSales()) + "\n";
    }
}
