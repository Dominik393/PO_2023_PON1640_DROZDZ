package agh.ics.oop.presenter;

import agh.ics.oop.model.WorldMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SimulationPresenter {
    private WorldMap worldMap;

    @FXML
    private Label infoLabel;

    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public void drawMap() {
        if (worldMap != null) {
            infoLabel.setText(this.worldMap.toString());
        }
    }
}
