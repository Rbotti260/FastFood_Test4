module com.example.zzzfastfood_test4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zzzfastfood_test4 to javafx.fxml;
    exports com.example.zzzfastfood_test4;
}