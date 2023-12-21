package be.kdg.messenproject;

import be.kdg.messenproject.database.MesDao;
import be.kdg.messenproject.database.MesDbDao;
import be.kdg.messenproject.service.MessenService;
import be.kdg.messenproject.service.MessenServiceImpl;
import be.kdg.messenproject.view.MessenPresenter;
import be.kdg.messenproject.view.MessenView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Vincent Verboven
 * 21/12/2023
 */
public class Main extends Application {

    private static MesDao mesDao;
    private static MessenService messenService;
    private static MessenView messenView;
    private static MessenPresenter messenPresenter;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mesDao = MesDbDao.getInstance("db/messenDatabase");
        messenService = new MessenServiceImpl(mesDao);
        messenView = new MessenView();
        messenPresenter = new MessenPresenter(messenView, messenService);
        Scene scene = new Scene(messenView);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
