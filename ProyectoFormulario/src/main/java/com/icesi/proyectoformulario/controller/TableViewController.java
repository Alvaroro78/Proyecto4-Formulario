package com.icesi.proyectoformulario.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TableViewController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
