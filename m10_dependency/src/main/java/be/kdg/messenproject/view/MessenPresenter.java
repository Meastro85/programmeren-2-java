package be.kdg.messenproject.view;

import be.kdg.messenproject.exceptions.MessenException;
import be.kdg.messenproject.model.Mes;
import be.kdg.messenproject.service.MessenService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.List;

/**
 * Vincent Verboven
 * 21/12/2023
 */
public class MessenPresenter {

    private MessenView view;
    private MessenService messenService;

    public MessenPresenter(MessenView view, MessenService messenService) {
        this.view = view;
        this.messenService = messenService;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        try {
            Button saveButton = view.getSaveButton();
            saveButton.setOnAction(actionEvent -> {
                messenService.addMes(createMes());
                updateView();
            });
        } catch (MessenException e) {
            showAlert(e.toString());
        }
    }

    private Mes createMes() {
        String type = view.getTypeField().getText();
        LocalDate productieDag = view.getDatePicker().getValue();
        double length = Double.parseDouble(view.getLengthField().getText());
        return new Mes(type, productieDag, length);
    }

    private void updateView() {
        try {
            TableView<Mes> table = view.getTableView();
            List<Mes> messen = messenService.getAllMessen();
            ObservableList<Mes> oMessen = FXCollections.observableList(messen);
            table.setItems(oMessen);
            table.refresh();
        } catch (MessenException e) {
            showAlert(e.toString());
        }

    }

    private void showAlert(String e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(e);
        alert.show();
    }

}
