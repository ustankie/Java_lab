package agh.ics.oop.presenter;

import agh.ics.oop.OptionParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    public GridPane mess;
    @FXML
    private GridPane mapGrid;
    @FXML
    private Button btn;
    @FXML
    private Label message;
    @FXML
    private TextField parametersTextField;
    private WorldMap worldMap;
    @FXML
    private Label infoLabel;

    private String[] args;
    private static final String EMPTY_CELL = " ";



    public void setWorldMap(WorldMap map) {
        this.worldMap = map;

    }

    public void drawMap(WorldMap worldMap){
        mess.setPadding(new Insets(0, 0, 20, 0));        btn.setStyle("-fx-background-color: MediumSeaGreen");
        clearGrid();
        Boundary boundary=worldMap.getCurrentBounds();

        draw(boundary.lowerLeft(),boundary.upperRight());
    }
    public void draw(Vector2D lowerLeft, Vector2D upperRight) {

        drawHeader(lowerLeft,upperRight);
        for (int i = 0; i < upperRight.getY()-lowerLeft.getY() +2; i++){
            mapGrid.getRowConstraints().add(new RowConstraints(30));
        }
        for (int j = 0; j < upperRight.getX()-lowerLeft.getX() + 2; j++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(30));

        }
        for (int i = 1; i < upperRight.getY()-lowerLeft.getY() +2; i++){
            for (int j = 1; j < upperRight.getX()-lowerLeft.getX() + 2; j++){
                Label label=new Label(drawObject(new Vector2D(j-1+lowerLeft.getX(),upperRight.getY()-i+1)));
                label.setFont(Font.font(18));
                if(label.getText().equals("*")){
                    label.setTextFill(Color.GREEN);
                }else{
                    label.setTextFill(Color.BLUE);
                }
                mapGrid.add(label,j,i);

            }
        }



        for (Node label : mapGrid.getChildren()){
            GridPane.setHalignment(label, HPos.CENTER);
            GridPane.setFillWidth(label,true);
        }

    }


    private void drawHeader(Vector2D lowerLeft, Vector2D upperRight) {
        mapGrid.add(new Label( " y\\x "),0,0);
        for (int j = 1; j < upperRight.getX()-lowerLeft.getX() + 2; j++) {
            Label label=new Label(String.format("%2d",j+lowerLeft.getX()-1));
            label.setFont(Font.font(18));
            mapGrid.add(label,j,0);
        }
        for (int i = 1; i < upperRight.getY()-lowerLeft.getY() +2; i++) {
            Label label=new Label(String.format("%2d",upperRight.getY() -i+1));
            label.setFont(Font.font(18));
            mapGrid.add(label,0,i);
        }

    }

    private String drawObject(Vector2D currentPosition) {
        if (this.worldMap.isOccupied(currentPosition)) {
            Object object = this.worldMap.objectAt(currentPosition);
            if (object != null) {
                return object.toString();
            }

        }
        return EMPTY_CELL;
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap(worldMap);
            this.message.setText(message);
        });
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }


    public void onSimulationStartClicked() {
        args=parametersTextField.getText().split(" ");
        List<MoveDirection> directions = OptionParser.parse(args);
        List<Vector2D> positions= List.of(new Vector2D(2,2),new Vector2D(3,4));
        Simulation simulation=new Simulation(directions,positions,worldMap);

//        mapChanged(worldMap,"");

        SimulationEngine simulationEngine=new SimulationEngine(List.of(simulation));
        simulationEngine.runAsync();
    }
}
