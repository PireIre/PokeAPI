import FileHandling.FileHandlerJSON;
import FileHandling.PokemonAPI;
import PokeData.Location;
import PokeData.Pokemon;
import org.json.simple.parser.ParseException;

import java.util.Scanner;

public class Display {

    private FileHandlerJSON fileHandler;
    private Scanner scan;
    private Print printer;

    public Display(){
        this.fileHandler = new FileHandlerJSON();
        this.scan = new Scanner(System.in);
        this.printer = new Print();

    }

    public void start() throws ParseException {
        printer.printWelcomeScreen();

        while (true) {
            printer.printOptions();
            switch (userInput()){
                case "1":
                    System.out.println("Enter the name of a Pokemon:");
                    searchPokemon(userInput());
                    break;
                case "2":
                    System.out.println("Enter the name of location:");
                    searchLocation(userInput());
                    break;
                case"3":
                    System.out.println("Function still in development \n");
                    break;
                case "4":
                    System.out.println("Thank you for using Pokemon App Wiki");
                    return;
                default:
                    System.out.println("You have not chosen an appropriate option");
            }
        }
    }

    public String userInput(){
        return scan.nextLine();
    }

    public void searchPokemon(String pokemon) throws ParseException {

        String name = pokemon.trim().replace(".","").replace(" ","-").toLowerCase();
        String response = PokemonAPI.makeHTTPRequest("pokemon", name);

        Pokemon pokemonfromAPI = fileHandler.readJsonPokemon(response);

        if(pokemonfromAPI != null){
            System.out.println(pokemonfromAPI.toString());
        }
        else{
            System.out.println("Pokemon not found :(");
        }
    }

    public void searchLocation(String location) throws ParseException {

        String loc = location.trim().replace(".","").replace(" ","-").toLowerCase();
        String response = PokemonAPI.makeHTTPRequest("location", loc);

        Location locationFromAPI = fileHandler.readJsonLocation(response);

        if(locationFromAPI != null){
            System.out.println(locationFromAPI.toString());
        }
        else{
            System.out.println("Location not found :(");
        }
    }
}
