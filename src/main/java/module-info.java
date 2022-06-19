module gui.javafx_g048 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires AuthLib;
    requires commons.lang3;
    requires java.logging;
    requires java.desktop;


    opens gui.javafx_g048 to javafx.fxml;
    exports gui.javafx_g048;
}