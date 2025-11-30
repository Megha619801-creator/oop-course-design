package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import model.Note;
import model.Notebook;

public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private ListView<Note> noteList;

    private Notebook notebook;

    private ObservableList<Note> observableNotes;

    @FXML
    public void initialize() {
        notebook = new Notebook();
        observableNotes = FXCollections.observableArrayList();
        noteList.setItems(observableNotes);

        // Display selected note in the fields
        noteList.getSelectionModel().selectedItemProperty().addListener((obs, oldNote, newNote) -> {
            if (newNote != null) {
                titleField.setText(newNote.getTitle());
                contentArea.setText(newNote.getContent());
            }
        });
    }

    @FXML
    private void addNote() {
        String title = titleField.getText().trim();
        String content = contentArea.getText().trim();
        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);
            refreshList();
            clearFields();
        }
    }

    @FXML
    private void updateNote() {
        Note selected = noteList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setTitle(titleField.getText());
            selected.setContent(contentArea.getText());
            refreshList();
        }
    }

    @FXML
    private void deleteNote() {
        Note selected = noteList.getSelectionModel().getSelectedItem();
        if (selected != null) {
            notebook.getNotes().remove(selected);
            refreshList();
            clearFields();
        }
    }

    private void refreshList() {
        observableNotes.setAll(notebook.getNotes());
    }

    private void clearFields() {
        titleField.clear();
        contentArea.clear();
        noteList.getSelectionModel().clearSelection();
    }
}









//package controller;
//
//import javafx.fxml.FXML;
//import javafx.scene.control.*;
//import model.Note;
//import model.Notebook;
//
//public class NoteController {
//
//    private Notebook notebook = new Notebook();
//
//    @FXML private TextField titleField;
//    @FXML private TextArea contentArea;
//    @FXML private ListView<Note> noteList;
//
//    @FXML
//    public void addNote() {
//        String title = titleField.getText();
//        String content = contentArea.getText();
//
//        if (title.isEmpty() || content.isEmpty()) {
//            showAlert();
//            return;
//        }
//
//        Note note = new Note(title, content);
//        notebook.addNote(note);
//        noteList.getItems().add(note);
//
//        titleField.clear();
//        contentArea.clear();
//    }
//
//    private void showAlert() {
//        Alert alert = new Alert(Alert.AlertType.WARNING);
//        alert.setTitle("Input Error");
//        alert.setHeaderText("Empty Note");
//        alert.setContentText("Please enter both title and content.");
//        alert.show();
//    }
//}
