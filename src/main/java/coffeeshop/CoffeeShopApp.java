package coffeeshop;

import java.util.Scanner;
// Built by: Jeremiah Faustin
// STEP 6 · CoffeeShopApp: the game you play. This is the class with main.
//
// It already runs. Click the green arrow next to main and try it.
//
// In Step 6 you finish it. Open UML.md ("Step 6") and the README ("Step 6") for the
// screens and the exact sentences. You add:
//   2 more private fields: shop and order
//   the game loop in run()
//   printBanner(), printMainMenu(), and one method for each menu choice
//
// Then drag check/coffeeshop/CoffeeShopAppTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 6: game loop

public class CoffeeShopApp {

    private Scanner input;
    private CoffeeShop shop;
    private Order order;
    // creates a CoffeeShopApp with a Scanner, a coffee shop, and a new order
    public CoffeeShopApp(Scanner input) {
        this.input = input;
        shop = new CoffeeShop("Hornet Coffee");
        order = new Order();
    }

    // The game loop. It keeps going until the user picks 0.
    public void run() {
        printBanner();
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readNumber("Pick a number: ");

            switch (choice){
                case 1:
                    System.out.println(shop.getMenu());
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    viewOrder();
                    break;
                case 5:
                    useCoupon();
                    break;
                case 6:
                    checkout();
                    break;
                case 7:
                    System.out.println(shop.salesReport());
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("That is not on the list. Pick 0 to 7.");
                    break;
            }
        }
        System.out.println("Shop closed. Goodbye!");
        // YOUR CODE (Step 6): replace the two lines above with the game loop.
    }
    // prints out the graphic at the top of the shop
    private void printBanner(){
        System.out.print("\t  ( (\n");
        System.out.print("\t   ) )\n");
        System.out.print("    ........\n");
        System.out.print("    |\t   |]\n");
        System.out.print("    \\\t   /\n");
        System.out.print("     `----'\n");
        System.out.print("  HORNET COFFEE\n");
        System.out.println();
    }
    // prints the main menu with the available options and current order information
    private void printMainMenu(){
        System.out.print("=====================================\n");
        System.out.print("   HORNET COFFEE  -  Order #" + order.getOrderNumber() + " (" + order.getItemCount() + " items)\n" );
        System.out.print("=====================================\n");
        System.out.print(" 1. See the menu\n");
        System.out.print(" 2. Add an item\n");
        System.out.print(" 3. Remove an item\n");
        System.out.print(" 4. View my order\n");
        System.out.print(" 5. Use a coupon\n");
        System.out.print(" 6. Check out\n");
        System.out.print(" 7. Today's sales\n");
        System.out.print(" 0. Close the shop\n");
        System.out.print("-------------------------------------\n");
    }
    // allows the user to select a menu item and add it to their order
    private void addItem(){
        System.out.print(shop.getMenu());
        int itemNumber = readNumber("Item number: ");
        MenuItem item = shop.getMenu().getItem(itemNumber);

        if (item == null){
            System.out.println("Invalid Selection");
            return;
        }

        if (item.isDrink()){
            String input = readText("Size (S, M, L): ");
            char size = 'S';
            if (!input.isEmpty()){
                size = input.charAt(0);
            }

            order.addItem(new Drink(item.getName(), item.getPrice(), size));

        } else {
            String heated = readText("Heat it up? (y/n): ");
            boolean isHeated = heated.equalsIgnoreCase("y");
            order.addItem(new Food(item.getName(), item.getPrice(), isHeated));
        }

        System.out.print("Added. Your order has " + order.getItemCount() + " items.\n");
        System.out.println();
    }
    // allows the user to remove an item from their order
    private void removeItem(){
        if (order.isEmpty()){
            System.out.println("Your order is empty.");
        } else {
            System.out.println(order);
            int item = readNumber("Item number: ");

            if (order.removeItem(item)){
                System.out.println("Item removed from order");
            } else {
                System.out.println("There is no such item");
            }
        }
    }
    // displays the user's current order or lets them know if it is empty
    private void viewOrder(){
        if (order.isEmpty()){
            System.out.println("Your order is empty.");
        } else {
            System.out.println(order);
        }
    }
    // asks the user for a coupon code and applies it if it is valid
    private void useCoupon(){
        String coupon = readText("Coupon code: ");

        if (order.applyCoupon(coupon)){
            System.out.println("Coupon applied.");
        } else {
            System.out.println("Invalid coupon.");
        }
    }
    // displays the order, collects a tip percentage, completes the purchase, and starts a new order
    private void checkout(){
        if (order.isEmpty()){
            System.out.println("Your order is empty.");
        } else {
            System.out.println(order);
            int tipPercent = readNumber("Tip percent (0, 10, 15, 20): ");
            System.out.printf("Total: $%.2f\n", shop.checkout(order,tipPercent));
            order = new Order();
        }
    }

    // GIVEN CODE. Do not change it. Use it for every number the user types.
    // It keeps asking until the user types a whole number, so letters can not crash your game.
    private int readNumber(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.nextLine();                    // throw away what they typed
            System.out.print("Please type a number: ");
        }
        int number = input.nextInt();
        input.nextLine();                        // throw away the Enter key
        return number;
    }

    // GIVEN CODE. Do not change it. Use it for every word the user types.
    // Reads one line of text, with the spaces at the ends cut off.
    private String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    // Start here. Click the green arrow next to this line to run the game.
    public static void main(String[] args) {

        CoffeeShopApp app = new CoffeeShopApp(new Scanner(System.in));
        app.run();
    }
}
