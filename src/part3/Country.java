package part3;

import java.util.List;
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
            double totalEmision = emission.getValue().sumEmissions();

            if(totalEmision > highestTotalEmission ){
                highestTotalEmission = totalEmision;
                yearItOccures = emission.getKey();
            }

        }

        return yearItOccures;
    }

// Country with highest methane in year n
    public static Country countryWithHighestCH4InYear(List<Country> countries, int year){

        double highestCH4 = Double.NEGATIVE_INFINITY;
        Country countryItOccurs = null;

        for(Country country: countries){
            Emission emission = country.getEmissions().get(year);
            double CH4Concentration = emission.getCH4();

            if(CH4Concentration > highestCH4){
                highestCH4 = CH4Concentration;
                countryItOccurs = country;
            }

        }


        return countryItOccurs;
    }


    // Country with highest change in Emission
    public static Country countryWithHighestChangeInEmissions(List<Country> countries, int
            startYear, int endYear){


        double highestChangeEmission = Double.NEGATIVE_INFINITY;
        Country countryItOccurs = null;

        for(Country country: countries){
            // For every country I will check the difference in the change in emission on end year and start year. Since change relate the difference;
             double startYearTotalEmission = country.getEmissions().get(startYear).sumEmissions();
             double endYearTotalEmission = country.getEmissions().get(endYear).sumEmissions();

             double changeInEmission = endYearTotalEmission - startYearTotalEmission;

             if(changeInEmission > highestChangeEmission){
                  highestChangeEmission = changeInEmission;
                  countryItOccurs = country;

        }

        }

        System.out.printf("The %s has the highest change in emission between %d and %d, which is %f",
                countryItOccurs.name, startYear, endYear, highestChangeEmission);


        return countryItOccurs;
    }



}
