package part2;

import java.util.Map;

public class Country {
   private String name;
   private Map<Integer, Emission> emissions;

    public Country(String name, Map<Integer, Emission> emissions) {
        this.name = name;
        this.emissions = emissions;
    }


    public String getName() {
        return name;
    }

    public Map<Integer, Emission> getEmissions() {
        return emissions;
    }

    public int getYearWithHighestEmissions(){


        double highestTotalEmission = Double.NEGATIVE_INFINITY;
        int yearItOccures = 0;

        for(Map.Entry<Integer, Emission> emission: this.emissions.entrySet()){
            double totalEmision = sumYearEmission(emission.getValue());

            if(totalEmision > highestTotalEmission ){
                highestTotalEmission = totalEmision;
                yearItOccures = emission.getKey();
            }

        }

        return yearItOccures;
    }

    private double sumYearEmission(Emission emission){
        return emission.getCH4() + emission.getCO2() + emission.getN2O();
    }

}
