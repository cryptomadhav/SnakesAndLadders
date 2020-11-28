package utils;

import java.util.Map;

public class MiscUtils {

    public static int generateBetween(int l, int h) {
        int randomValue = (int) (Math.random() * (h - l + 1));
        return randomValue + l;
    }

    public static int generateUnusedBetween(int l, int h, Map<Integer, Integer> usedValues) {
        while(true) {
            int randomValue = generateBetween(l, h);
            if(!usedValues.containsKey(randomValue)) {
                return randomValue;
            }
        }
    }

}
