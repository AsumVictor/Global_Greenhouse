package part1;

import java.util.Map;

public class Util {


    public static int getYearWithHighestEmissions(Sector sector){
        Map<Integer, Double> emissions = sector.getEmissions();

        double highestEmission = Double.NEGATIVE_INFINITY;
        int yearItOccures = 0;

        for(int key: emissions.keySet()){
             if(emissions.get(key) > highestEmission){
                 yearItOccures = key;
                 highestEmission = emissions.get(key);
             }
        }

        return yearItOccures;
    }

    public static int getYearWithHighestEmissions(Country country){
        return 2;
    }
}
