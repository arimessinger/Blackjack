module org.messingerarraylistlabblackjack {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.messingerarraylistlabblackjack to javafx.fxml;
    exports org.messingerarraylistlabblackjack;
}