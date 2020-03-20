package FileHandling;

import PokeData.Location;
import PokeData.Pokemon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FileHandlerJSON {

    public FileHandlerJSON(){

    }

    public Pokemon readJsonPokemon(String pokemonData) throws ParseException {
        Pokemon pokemon1 = null;
        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(pokemonData);
        long id = (long) jsonObject.get("id");
        String name = (String) jsonObject.get("name");
        long height = (long) jsonObject.get("height");
        long weight = (long) jsonObject.get("weight");

        pokemon1 = new Pokemon();
        pokemon1.setHeight(height);
        pokemon1.setId(id);
        pokemon1.setName(name);
        pokemon1.setWeight(weight);

        return pokemon1;
    }

    public Location readJsonLocation (String locations) throws ParseException {
        Location location1 = null;

        ArrayList<String> jsonLocation = new ArrayList<>();
        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(locations);
        JSONObject locationRegion = (JSONObject) jsonObject.get("region");
        String region = (String) locationRegion.get("name");

        JSONArray locationInDifferentLanguages = (JSONArray) jsonObject.get("names");
        Iterator<String> iterator = locationInDifferentLanguages.iterator();
        while(iterator.hasNext()){
            Object slide = iterator.next();
            JSONObject jsonObject2 = (JSONObject) slide;
            String locationName = (String) jsonObject2.get("name");

            JSONObject language = (JSONObject) jsonObject2.get("language");
            String languageName = (String) language.get("name");

            jsonLocation.add(locationName + " - " + languageName);
        }

        location1 = new Location();
        location1.setLocationName(jsonLocation);
        location1.setRegion(region);

        return location1;

    }


}
