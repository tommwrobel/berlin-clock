package com.tom;

public enum Light {
    RED("R"),
    YELLOW("Y"),
    OFF("O");

    private String sign;

    Light(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
