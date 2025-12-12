module io.jfxdevelop.lab6_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.jfxdevelop.lab6_1 to javafx.fxml;
    exports io.jfxdevelop.lab6_1;
}