module tamagochigraphique {
    requires javafx.controls;
    requires javafx.fxml;

    opens tamagochigraphique to javafx.fxml;
    exports tamagochigraphique;
}
