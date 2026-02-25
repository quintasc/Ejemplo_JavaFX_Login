module com.quintas.carmen.login_register {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.quintas.carmen.login_register to javafx.fxml;
    opens com.quintas.carmen.login_register.controller to javafx.fxml;
    exports com.quintas.carmen.login_register;
}
