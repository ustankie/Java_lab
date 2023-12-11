package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.presenter.SimulationPresenter;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulationApp extends Application {
    ExecutorService executorService= Executors.newFixedThreadPool(4);
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("simulation.fxml"));
        BorderPane viewRoot = loader.load();
        SimulationPresenter presenter = loader.getController();

        configureStage(primaryStage,viewRoot);

        GrassField grassField=new GrassField(10);
        grassField.subscribe(presenter);
        presenter.setWorldMap(grassField);
        presenter.setTemplateWorldMap(grassField);
        presenter.setExecutorService(executorService);
        presenter.subscribe(this);
        ConsoleMapDisplay consoleMapDisplay=new ConsoleMapDisplay();
        grassField.subscribe(consoleMapDisplay);
//        consoleMapDisplay.mapChanged(grassField,"");
        presenter.drawMap(grassField);




        primaryStage.show();
//        presenter.awaitSimulationsEnd();
    }

    private void configureStage(Stage primaryStage, BorderPane viewRoot) {
        var scene = new Scene(viewRoot);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simulation app");
        primaryStage.minWidthProperty().bind(viewRoot.minWidthProperty());
        primaryStage.minHeightProperty().bind(viewRoot.minHeightProperty());
    }

    public void createNewWindow(AbstractWorldMap worldMap) {
        {
            Stage newStage = new Stage();
            newStage.setTitle("New Simulation");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("NewWindow.fxml"));
                BorderPane viewRoot = loader.load();

                SimulationPresenter controller = loader.getController();
                controller.setWorldMap(worldMap);
                controller.setExecutorService(executorService);
                controller.setTemplateWorldMap(worldMap);
                worldMap.subscribe(controller);
                controller.subscribe(this);

                configureStage(newStage, viewRoot);
                controller.draw(worldMap.getCurrentBounds().lowerLeft(),worldMap.getCurrentBounds().upperRight());

            } catch (IOException e) {
                e.printStackTrace();
            }

            newStage.show();
        };
    }
}
