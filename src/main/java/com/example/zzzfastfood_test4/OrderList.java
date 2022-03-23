//***************************************************************
// Title:  Something POS
// Author:  Robert Botti
// Course Section: CMIS202-ONL (Seidel) Spring 2022
// File: FastFoodRestaurant
// Description:  Something Restaurant Point of Sale Application
//***************************************************************
package com.example.zzzfastfood_test4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OrderList {
    /** Array Lists to store the items ordered as well as the prices
     *
     */
    public ArrayList<String> orderList = new ArrayList<String>(); // String list for items ordered
    public ArrayList<Double> orderPrice = new ArrayList<Double>(); // Double list to store prices of items ordered




    /**Method to add items ordered to the shopping cart
     *
     * @param item
     */
    public void addOrderItem(String item) {
        orderList.add(item); //adds items to that array list.


        //Dialog d = new Alert(Alert.AlertType.INFORMATION, item);  //Can use to prompt check after check out
        //d.show();//Can use to prompt check after check out
    }

    /**method to add pricing for items ordered
     *
     * @param price
     */

    public void addOrderPrice(double price) {
        orderPrice.add(price);//assigns price to items in array list.

    }

    /** Prints list of items ordered along with total price of order
     *
     */
    public void printOrderList() throws FileNotFoundException {
        String receiptNumber = String.format("%.0f", Math.floor(Math.random() * (999 - 100 + 1) + 100));
        PrintWriter outputfile = new PrintWriter("Receipt.txt");
        outputfile.println("You have " + orderList.size() + " items in your shopping cart.");
        System.out.println("You have " + orderList.size() + " items in your shopping cart.");
        System.out.println("Your order number is: " + receiptNumber);
        outputfile.println("Your order number is: " + receiptNumber);
        for (int i = 0; i < orderList.size(); i++) {
            outputfile.println((i + 1) + ". " + orderList.get(i));
            System.out.println((i + 1) + ". " + orderList.get(i)); //retrieves the list of items in the array list.

        }
        outputfile.println("The total price of your order is:  $" + String.format("%.2f", totalPrice()*1.06));
        System.out.println("The total price of your order is:  $" + String.format("%.2f", totalPrice()*1.06));
        outputfile.close();
    }

    /** Calculates the total price of the items in the shopping cart
     *
     * @return
     */
    public double totalPrice() {
        double total = 0;
        for (int i = 0; i < orderPrice.size(); i++) //for loop to calculate the sum of the items in the array list (shopping cart).
            total += orderPrice.get(i);
        return total;
    }

//    public ObservableValue<? extends String> totalPriceToString() {
//        double total = 0;
//        for (int i = 0; i < orderPrice.size(); i++) //for loop to calculate the sum of the items in the array list (shopping cart).
//            total += orderPrice.get(i);
//        String totalString = String.valueOf(total);
//        return
//    }


    /** Method to remove items from shopping cart.  User will need to type the String of the item to be removed.
     *
     * @param item
     */

//    public void removeMenuItem(String item){
//        int position = findItem(item);
//        if(position >= 0){
//            removeMenuItem(position); //removes an item from array.
//        }
//    }

    /** Method to remove the item position from the array.
     *
     * @param position
     */
    private void removeMenuItem(int position) {
        orderList.remove(position); //removes position within array.

    }

    /** Method to search array of items ordered
     *
     * @param searchItem
     * @return
     */
    private int findItem(String searchItem) {
        return orderList.indexOf(searchItem); //returns index of item being searched.
    }


}
