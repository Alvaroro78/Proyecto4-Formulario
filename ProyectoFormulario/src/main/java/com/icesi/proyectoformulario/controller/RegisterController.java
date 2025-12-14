package com.icesi.proyectoformulario.controller;

import com.icesi.proyectoformulario.model.HorrorClub;
import com.icesi.proyectoformulario.model.SubGenre;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.LocalDate;

public class RegisterController {

    @FXML
    private TextField idField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField surnameField;

    @FXML
    private DatePicker birthField;

    @FXML
    private TextField emailField;

    @FXML
    private ChoiceBox<Integer> fanaticField;

    @FXML
    private TextField movieNameField;

    @FXML
    private DatePicker premiereField;

    @FXML
    private ChoiceBox<SubGenre> subgenreField;

    @FXML
    private TextField imageField;

    @FXML
    private ImageView imageView;

    private HorrorClub horrorClub;

    @FXML
    private void initialize(){

        imageField.setDisable(true);
        subgenreField.getItems().addAll(SubGenre.values());
        horrorClub = HorrorClub.getInstance();

    }

    @FXML
    private void BrowseImage(ActionEvent event) {
        //Filechooser=explorador de archivos
        FileChooser fileChooser = new FileChooser();
        //Abro el explorador y el archivo que coloque el usuario será el que se carga
        File fileSelected = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        if (fileSelected != null) {
            imageField.setText(fileSelected.getAbsolutePath());
            imageView.setImage(new Image(fileSelected.toURI().toString()));
        }
    }

    @FXML
    private void registerMember(ActionEvent event) {
        try{
            String id = idField.getText();
            String name = nameField.getText();
            String surname = surnameField.getText();
            String email = emailField.getText();
            int fanatic = fanaticField.getValue();
            String movieName = movieNameField.getText();
            LocalDate birthDate = birthField.getValue();
            LocalDate premiereDate = premiereField.getValue();
            SubGenre subGenre = subgenreField.getValue();

            validateInputs(id,name,surname,email,fanatic,movieName,birthDate,premiereDate,subGenre);

            String result = horrorClub.addMemberRegistration(id,name,surname,email,fanatic,movieName,birthDate,premiereDate,subGenre);

            clearControls();

            showRegisterConfirmation(result);
        } catch (){

        }
    }

    @FXML
    private void validateInputs(String id, String name, String surname, String email, int fanatic, String movieName,
                                LocalDate birthDate, LocalDate premiereDate, SubGenre subGenre) {

    }

    @FXML
    private void clearControls() {
        idField.clear();
        nameField.clear();
        surnameField.clear();
        emailField.clear();
        fanaticField.setValue(0);
        movieNameField.clear();
        birthField.setValue(null);
        premiereField.setValue(null);
        subgenreField.setValue(null);
        imageField.clear();
        imageView.setImage(null);
    }

    //---- aca debe ir la navegacion a la table view... ummm... como el señor ese tiene que hacer una evaluacion, supongo que la table view tiene dos tipos.
}

