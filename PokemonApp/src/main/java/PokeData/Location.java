package PokeData;

import java.util.ArrayList;
import java.util.List;

public class Location {

    //Name of locations in different languages
    //What region that location is in


    private ArrayList<String> locations;
    private String region;

    public ArrayList<String> getLocationName() {
        return locations;
    }

    public void setLocationName(ArrayList<String> locationName) {
        this.locations = locationName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString(){
        return ">> Location = {" + locations  +
                ",} \n " + " \t  Region = {" + region + '\'' +
                '}';
    }
}
