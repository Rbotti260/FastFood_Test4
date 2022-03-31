//***************************************************************
// Title:  Something POS
// Author:  Robert Botti
// Course Section: CMIS202-ONL (Seidel) Spring 2022
// File: FastFoodRestaurant
// Description:  Something Restaurant Point of Sale Application
//***************************************************************
package com.example.zzzfastfood_test4;


import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FastFoodController implements Initializable {
    private static OrderList menuList = new OrderList();
    public Button btnClose;


    @FXML
    protected TextField subTotal = new TextField();
    //DoubleProperty runningSubTotal = new SimpleDoubleProperty();
    DoubleProperty total = new SimpleDoubleProperty();


    @FXML
    protected TextArea receiptTextArea;
    @FXML
    protected TextArea aboutTextArea;


    @FXML
    protected ListView lvOrderList = new ListView();
    @FXML
    protected ListView lvOrderPrice = new ListView();


    //protected List<String> itemsOrdered = menuList.orderList;

    protected ListProperty<String> listProperty = new SimpleListProperty<>();

    protected ListProperty<Double> listPrice = new SimpleListProperty<>();
    //private static OrderList menuPrice = new OrderList();


    //boolean quit = false; //Boolean statement to quit application.
    //int selection = 0;  int variable to store users selection.


    public void btnHamburger(ActionEvent e) {
        menuList.addOrderItem("Hamburger");
        menuList.addOrderPrice(8.50);
        menuList.addComboNumber(1);
        System.out.println("Hamburger");
        listProperty.set(FXCollections.observableArrayList(menuList.orderList));
        listPrice.set(FXCollections.observableArrayList(menuList.orderPrice));
    }

    public void btnChickenTenders(ActionEvent e) {
        menuList.addOrderItem("Chicken Tenders");
        menuList.addOrderPrice(9.00);
        menuList.addComboNumber(2);
        System.out.println("Chicken Tenders");
        listProperty.set(FXCollections.observableArrayList(menuList.orderList));
        listPrice.set(FXCollections.observableArrayList(menuList.orderPrice));
    }

    public void btnHotDog(ActionEvent e) {
        menuList.addOrderItem("Hot Dog");
        menuList.addOrderPrice(6.00);
        menuList.addComboNumber(3);
        System.out.println("Hot Dog");
        listProperty.set(FXCollections.observableArrayList(menuList.orderList));
        listPrice.set(FXCollections.observableArrayList(menuList.orderPrice));
    }

    public void btnCheeseSteak(ActionEvent e) {
        menuList.addOrderItem("Cheese Steak");
        menuList.addOrderPrice(10.25);
        menuList.addComboNumber(4);
        System.out.println("Cheese Steak");
        listProperty.set(FXCollections.observableArrayList(menuList.orderList));
        listPrice.set(FXCollections.observableArrayList(menuList.orderPrice));
    }

    public void btnChickenCheeseSteak(ActionEvent e) {
        menuList.addOrderItem("Chicken Cheese Steak");
        menuList.addOrderPrice(10.50);
        menuList.addComboNumber(5);
        System.out.println("Chicken Cheese Steak");
        listProperty.set(FXCollections.observableArrayList(menuList.orderList));
        listPrice.set(FXCollections.observableArrayList(menuList.orderPrice));
    }


    public void btnVeggieBurger(ActionEvent e) {
        menuList.addOrderItem("Veggie Burger");
        menuList.addOrderPrice(8.50);
        menuList.addComboNumber(6);
        System.out.println("Veggie burger");
        listProperty.set(FXCollections.observableArrayList(menuList.orderList));
        listPrice.set(FXCollections.observableArrayList(menuList.orderPrice));
    }

    @FXML
    public void btnCheckOut(ActionEvent e) throws IOException {
        menuList.printOrderList();


        Parent root = FXMLLoader.load(getClass().getResource("receipt.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Receipt");
        stage.setScene(scene);
        stage.show();
    }


//
//    try {
//        // Create a buffered stream
//        Scanner input = new Scanner(new File("Receipt.txt"));
//
//        // Read a line and append the line to the text area
//        while (input.hasNext()) {
//            receiptTextArea.appendText(input.nextLine() + '\n');
//        }
//        input.close();
//    } catch (FileNotFoundException ex) {
//        System.out.println("File not found: " + "Receipt.txt");
//    } catch (Exception ex) {
//        System.out.println(ex.getMessage());
//    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        subTotal.setText(Double.toString(menuList.totalPrice()));

        //subTotal.textProperty().bind(menuList.totalPrice().textProperty());


        //subTotal.textProperty().bind(menuList.totalPriceToString());


        lvOrderList.itemsProperty().bind(listProperty);
        lvOrderPrice.itemsProperty().bind(listPrice);

    }



    @FXML
    public void btnWelcomeClose(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FastFood.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("OrderNow");
        stage.setScene(scene);
        stage.show();

    }

    public void btnClose(ActionEvent event) {
        Platform.exit();
    }







}




