# My Coffee Shop

This program is a coffee shop app that allows users to create an order, add or remove items, apply a coupon, and check out.

## HOW TO RUN IT

    1. Open CoffeeShopApp.java.
    2. Scroll down to the main method
    3. click the green arrow next to the main method to run it


## THE CLASSES

    1. MenuItem
        -Stores the name and price of the item and has a method that identifies if it is a drink or not.
    2. Food
        -Food is a MenuItem, it inherits all of its attributes and methods, and adds a $0.50 heating fee when the user chooses to heat the food.
    3. Drink
        -Drink is also a MenuItem, it inherits all of its attributes and methods, it stores the perfered size of the selected drink and adds an extra charge of $0.50 for medium or $1.00 for large.
    4. Menu
        -This holds 8 available MenuItems, it displays the full numbered menu, returns the number of items and retrieves an item by its number.
    5. Order
        -This is a costumers order, assigns each order a unique order number, it allows the costumer to add or remove an item from the menu to it, applies coupons,  and calculates the subtotal, discount, and total with a tip.
    6. CoffeeShop
        -Holds the shop's name and menu, stores all the completed orders, it tracks the total sales, completed orders, and the number of items sold.
    7. CoffeeShopApp
        -This is where all the classes are put together, it lets the user view the menu, manage an order, apply a coupon, check out, view today's sales, and close the shop.

## CHALLENGES

    One thing that was difficult for me was was understanding the requirments for each method because some parts of the UML and the README were unclear to me. But as I worked through each class I used the surrounding code and instructions as context clues to understand what each method needed to do.
    