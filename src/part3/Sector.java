package part3;

import java.util.List;
import java.util.Map;

public class Sector {
    private String name;
    private Map<Integer, Double> emissions;

    public Sector(String name, Map<Integer, Double> emissions) {
        this.name = name;
        this.emissions = emissions;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Double> getEmissions() {
        return emissions;
    }

    public int getYearWithHighestEmissions (){

        double highestEmission = Double.NEGATIVE_INFINITY;
        int yearItOccures = 0;

        for(int key: this.emissions.keySet()){
            if(this.emissions.get(key) > highestEmission){
                yearItOccures = key;
                highestEmission = this.emissions.get(key);
            }
        }

        return yearItOccures;
    }

    public static Sector sectorWithBiggestChangeInEmissions(List<Sector> sectors, int
            startYear, int endYear){

        double highestAverage = Double.NEGATIVE_INFINITY;
        Sector sectorItOccurs = null;
        int yearDiff = endYear - startYear;

        for(Sector sector: sectors){

             double totalSumOfEmission = 0;
            // Looping through all start and end year to get total emissions

            for(int currYear = startYear; currYear <= endYear; currYear++){
                // sum of all emission at a particular year
                double currYearEmission = sector.getEmissions().get(currYear);
                totalSumOfEmission += currYearEmission;
            }

            // calculating average
            double avgEmission = totalSumOfEmission / yearDiff;

            if(avgEmission > highestAverage){
                highestAverage = avgEmission;
                sectorItOccurs = sector;
            }

        }

        System.out.printf("The %s section has the highest average emission from %d to %d, which is %f "
        , sectorItOccurs.name, startYear, endYear, highestAverage
        );
        return  sectorItOccurs;
    }
}
