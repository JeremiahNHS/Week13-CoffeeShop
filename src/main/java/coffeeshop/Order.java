package coffeeshop;

import java.util.ArrayList;

// STEP 4 · Order: one customer's order.
//
// Open UML.md and find "Step 4 · Order". This is the biggest class. Build it one method at a
// time, and run the test after each one.
//   2 constants:      COUPON_CODE, COUPON_PERCENT   (public static final)
//   1 static field:   nextOrderNumber, starts at 1
//   3 private fields: orderNumber, items, discountPercent
//   1 constructor:    Order()
//   10 methods:       getOrderNumber(), addItem(), removeItem(), getItemCount(), isEmpty(),
//                     getSubtotal(), applyCoupon(), getDiscount(), getTotal(), toString()
//
// Then drag check/coffeeshop/OrderTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 4: Order

public class Order {

    public final static String COUPON_CODE = "HORNET10";
    public final static int COUPON_PERCENT = 10;
    private static int nextOrderNumber = 1;
    private int orderNumber;
    private ArrayList<MenuItem> items;
    private int discountPercent;
    // creates an Order object that has a unique order number and an empty list of MenuItems
    public Order() {
        orderNumber = nextOrderNumber;
        nextOrderNumber++;
        items = new ArrayList<>();
        discountPercent = 0;
    }
    // returns the order's number
    public int getOrderNumber(){
        return orderNumber;
    }
    // adds a Menu item to the order
    public void addItem(MenuItem item){
        items.add(item);
    }
    // removes an item from the order and returns true if successful or false if the number is invalid
    public boolean removeItem(int number){
        if (number >= 1 && number <= items.size()) {
            MenuItem item = items.get(number - 1);
            items.remove(item);
            return true;
        }
        return false;
    }
    // returns how many items are in the order
    public int getItemCount(){
        return items.size();
    }
    // returns true if there are no items or false if it does
    public boolean isEmpty(){
        return getItemCount() == 0;
    }
    // returns the combined price of all items in the order
    public double getSubtotal(){
        double price = 0.0;
        for (MenuItem item : items){
            price += item.getPrice();
        }
        return price;
    }
    // checks if the coupon is valid and applies the discount if it is
    public boolean applyCoupon(String code){
        if (code.trim().equalsIgnoreCase(COUPON_CODE)){
            discountPercent = COUPON_PERCENT;
            System.out.printf("$%.2f discount\n", getDiscount());
            return true;
        }
        return false;
    }
    // returns the amount taken off the subtotal from the discount
    public double getDiscount(){
        return getSubtotal() * (discountPercent / 100.0);
    }
    // returns the final order price after applying the discount and tip
    public double getTotal(int tipPercent) {
        if (tipPercent > 0) {
            double tipAmount = (getSubtotal() - getDiscount()) * (tipPercent / 100.0);
            return (getSubtotal() - getDiscount()) + tipAmount;
        }
        return getSubtotal() - getDiscount();
    }
    // returns the order number, numbered items, and subtotal as a String
    @Override
    public String toString(){
        String str = "\nOrder #" + orderNumber + "\n" ;
        for (int i = 0; i < items.size(); i++){
            str += (i + 1) + ". " + items.get(i) + "\n";
        }
        return  str + "Subtotal: $" + String.format("%.2f",getSubtotal());
    }
}
