package com.example.databasjava;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MainApp extends Application {

    private SearchController searchController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main-layout.fxml"));
        Parent root = loader.load();
        searchController = loader.getController();
        primaryStage.setTitle("Movie Search");
        primaryStage.setScene(new Scene(root));

        Button searchButton = (Button) root.lookup("#searchButton");
        if (searchButton != null) {
            searchButton.setOnAction(this::handleSearchButton);
        } else {
            System.out.println("Search button not found!");
        }

        primaryStage.show();
    }


    public void handleSearchButton(ActionEvent event) {
        try {
            searchController.handleSearch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void handleExit(ActionEvent event) {
        Platform.exit();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
