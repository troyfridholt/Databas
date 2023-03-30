package com.example.databasjava;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SearchController {

    @FXML
    private TextField searchField;

    @FXML
    private ListView<FilmModel> resultsList;

    private DatabaseManager dbManager;

    public SearchController() {
        dbManager = new DatabaseManager();
    }

    @FXML
    private void initialize() throws SQLException {
        dbManager.connect();
    }

    @FXML
    public void handleSearch() throws SQLException {
        String query = searchField.getText();
        ResultSet resultSet = dbManager.searchFilms(query);
        List<FilmModel> films = new ArrayList<>();
        while (resultSet.next()) {
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String genre = resultSet.getString("genre");
            int rating = resultSet.getInt("rating");
            FilmModel film = new FilmModel(title, description, genre, rating);
            films.add(film);
        }
        resultsList.getItems().setAll(films);
    }

    public void close() throws SQLException {
        dbManager.disconnect();
    }

}
