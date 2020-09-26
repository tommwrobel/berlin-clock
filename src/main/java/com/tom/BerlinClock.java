package com.tom;

public class BerlinClock {

    private ClockBoard clockBoard;

    public BerlinClock() {
        this.clockBoard = new ClockBoard();
    }

    private boolean validateTimeFormat(String time) {
        String pattern = "(?:[01]\\d|2[0-3]):(?:[0-5]\\d):(?:[0-5]\\d)";
        return time.matches(pattern);
    }

    private void setBerlinTime(final String time) {
        String[] splittedTime = time.split(":");
        int hours = Integer.parseInt(splittedTime[0]);
        int minutes = Integer.parseInt(splittedTime[1]);
        int seconds = Integer.parseInt(splittedTime[2]);

        if (seconds % 2 == 0) {
            clockBoard.setLight(Light.YELLOW, 0, 0);
        }

        for (int i = 0; i < hours / 5; i++) {
            clockBoard.setLight(Light.RED, 1, i);
        }

        for (int i = 0; i < hours % 5; i++) {
            clockBoard.setLight(Light.RED, 2, i);
        }

        for (int i = 0; i < minutes / 5; i++) {
            Light light = (i + 1) % 3 == 0 ? Light.RED : Light.YELLOW;
            clockBoard.setLight(light, 3, i);
        }

        for (int i = 0; i < minutes % 5; i++) {
            clockBoard.setLight(Light.YELLOW, 4, i);
        }
    }

    public String getBerlinTime(final String time) {
        if (!validateTimeFormat(time)) {
            throw new IllegalArgumentException("Invalid time format! Time format should be hh:mm:ss!");
        }
        setBerlinTime(time);
        return clockBoard.toString();
    }

}
