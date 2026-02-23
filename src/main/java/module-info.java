module _4ain.battlestate {
    requires javafx.controls;
    requires javafx.fxml;


    opens _4ain.battlestate to javafx.fxml;
    exports _4ain.battlestate;
}