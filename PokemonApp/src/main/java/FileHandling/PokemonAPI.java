package FileHandling;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class PokemonAPI {


    public static String makeHTTPRequest(String type, String name) {
        String urlString = "https://pokeapi.co/api/v2/" + type + "/" + name;
        String response = null;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Scanner responseScanner = new Scanner(connection.getInputStream());
            while (responseScanner.hasNext()) {
                response = responseScanner.nextLine();
            }
        } catch (IOException e) {
            return null;
        }
        return response;
    }

/*import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PokemonAPI {
    public final static String APIURL = "http://pokeapi.co/api/v2/";
    public final static String POKEMONURL = "pokemon/";
    URL url;

    HttpURLConnection httpcon;
    InputStream iStream;
    Scanner scan;
    String data;

    public PokemonAPI(){

    }

    private String getData(String sURL) throws IOException {
        data= "";

        url = new URL(sURL.toLowerCase());
        HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
        httpcon.setRequestProperty("User-Agent", "Chrome");
        if(httpcon.getResponseCode() == 504 || httpcon.getResponseCode() == -1){
            System.out.println("Bad Response code");
            return data;
        }
        InputStream iStream = httpcon.getInputStream();
        Scanner scan = new Scanner(iStream);
        while(scan.hasNext()){
            data += scan.nextLine();
        }
        scan.close();
        return data;
    }

    public String getPokemonData(String id) throws IOException {
        return getData(APIURL + "pokemon/" + id);
    }

    public String getLocationData(String id) throws IOException {
        return getData(APIURL + "location/" + id);
    }
*/

}
