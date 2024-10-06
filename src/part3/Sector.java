package part3;

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
}
