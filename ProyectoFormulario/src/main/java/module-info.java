module com.icesi.proyectoformulario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.icesi.proyectoformulario to javafx.fxml;
    exports com.icesi.proyectoformulario;
    exports com.icesi.proyectoformulario.controller;
    opens com.icesi.proyectoformulario.controller to javafx.fxml;
    exports com.icesi.proyectoformulario.model;
    opens com.icesi.proyectoformulario.model to javafx.fxml;
}