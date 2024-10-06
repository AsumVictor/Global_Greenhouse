package part1;

import java.util.List;
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
        Map<Integer, Emission> emissions = country.getEmissions();

        double highestTotalEmission = Double.NEGATIVE_INFINITY;
        int yearItOccures = 0;

        for(Map.Entry<Integer, Emission> emission: emissions.entrySet()){
            double totalEmision = sumYearEmission(emission.getValue());

            if(totalEmision > highestTotalEmission ){
                highestTotalEmission = totalEmision;
                yearItOccures = emission.getKey();
            }

        }

         return yearItOccures;
    }

    private static double sumYearEmission(Emission emission){
        return emission.getCH4() + emission.getCO2() + emission.getN2O();
    }

}
