package pl.akademiakodu.promil;

import java.util.List;

public enum Alcohol {
    BEER(0.05),
    VODKA(0.4),
    WINE(0.112),
    HOOCH(0.56d);

    private double power;
    Alcohol(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

}
