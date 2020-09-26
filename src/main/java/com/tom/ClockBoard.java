package com.tom;

import java.util.ArrayList;
import java.util.List;

public class ClockBoard {

    private List<List<Light>> board;

    public ClockBoard() {
        this.board = initializeClockBoard();
    }

    private List<List<Light>> initializeClockBoard() {
        List<List<Light>> clockBoard = new ArrayList<>();

        clockBoard.add(newLightRow(1));
        clockBoard.add(newLightRow(4));
        clockBoard.add(newLightRow(4));
        clockBoard.add(newLightRow(11));
        clockBoard.add(newLightRow(4));

        return clockBoard;
    }

    private List<Light> newLightRow(int numberOfLights) {
        List<Light> lightRow = new ArrayList<>();
        for (int i = 0; i < numberOfLights; i++) {
            lightRow.add(Light.OFF);
        }
        return lightRow;
    }

    public void setLight(Light light, int row, int lightPosition) {
        this.board.get(row).set(lightPosition, light);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (List<Light> row : board) {
            for (Light light : row) {
                sb.append(light.getSign());
            }
            sb.append(":");
        }

        return sb.toString().substring(0, sb.length() - 1);
    }
}
