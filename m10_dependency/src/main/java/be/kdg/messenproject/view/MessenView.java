package be.kdg.messenproject.view;

import be.kdg.messenproject.model.Mes;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.time.LocalDate;

/**
 * Vincent Verboven
 * 21/12/2023
 */
public class MessenView extends BorderPane {

    private TableView<Mes> tableView;
    private TextField typeField;
    private DatePicker datePicker;
    private TextField lengthField;
    private Button saveButton;

    public MessenView(){
        initializeNodes();
        layoutNodes();
    }

    private void initializeNodes() {
        tableView = new TableView<>();

        TableColumn<Mes, String> typeColumn = new TableColumn<>("Mes type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        TableColumn<Mes, LocalDate> dateColumn = new TableColumn<>("Productie dag");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("productieDag"));
        TableColumn<Mes, Double> lengthColumn = new TableColumn<>("Lengte");
        lengthColumn.setCellValueFactory(new PropertyValueFactory<>("lengte"));

        tableView.getColumns().setAll(typeColumn, dateColumn, lengthColumn);

        typeField = new TextField();

        lengthField = new TextField();

        datePicker = new DatePicker();

        saveButton = new Button();
        saveButton.setText("Save mes");
    }

    private void layoutNodes() {

        HBox bottomBox = new HBox(typeField, datePicker, lengthField, saveButton);

        this.setCenter(tableView);
        this.setBottom(bottomBox);
    }

    protected TableView<Mes> getTableView(){
        return tableView;
    }

    protected TextField getTypeField(){
        return typeField;
    }

    protected DatePicker getDatePicker(){
        return datePicker;
    }

    protected TextField getLengthField(){
        return lengthField;
    }

    protected Button getSaveButton(){
        return saveButton;
    }

}
