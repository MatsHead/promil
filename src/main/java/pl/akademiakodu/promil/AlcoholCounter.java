package pl.akademiakodu.promil;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AlcoholCounter {


    private static final float etchingFactorWoman = 0.6f;
    private static final float etchingFactorMan = 0.7f;
    private static final int burningAlcoholForMenPerHour = 11;
    private static final int burningAlcoholForWomenPerHour = 9;

    public float calculatePerMil(double quantity, double weight, boolean male, Alcohol alcohol) {
        float proMil = 0;
        if (male) {
            proMil = (float) ((float) quantity / etchingFactorMan / weight * alcohol.getPower());
        } else {
            proMil = (float) ((float) quantity / etchingFactorWoman / weight *  alcohol.getPower());
        }
        return proMil;
    }

    public float calculatePermilWithHours(double quantity, double weight, boolean male, double hours,  Alcohol alcohol) {
        float proMil = 0;
        if (male) {
            proMil = (float) ((float) ((quantity * alcohol.getPower()) -  burningAlcoholForMenPerHour* hours) / (etchingFactorMan * weight));
        } else {
            proMil = (float) ((float) ((quantity *  alcohol.getPower()) - burningAlcoholForWomenPerHour* hours) / (etchingFactorWoman * weight));
        }
        return proMil;
    }

}