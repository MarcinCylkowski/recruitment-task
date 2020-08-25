package src;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class LocalWeather {

    public static void connectWithApi() throws IOException {

        URL apiEndpoint = new URL("https://api.worldweatheronline.com/premium/v1/weather.ashx?key=19c79615523c4c3f9ee143325202408%20&q=Starogard%20Gda%C5%84ski&format=json&num_of_days=1");
        InputStream inputStream = apiEndpoint.openStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        JSONObject jsonObject = new JSONObject(bufferedReader.readLine());
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray weather = data.getJSONArray("weather");
        JSONObject arrayObject = weather.getJSONObject(0);
        String date = arrayObject.get("date").toString();
        String maxtempC = arrayObject.get("maxtempC").toString();
        String mintempC = arrayObject.get("mintempC").toString();
        String avgtempC = arrayObject.get("avgtempC").toString();

        System.out.println("Dzień: " + date + "\n" + "Maksymalna Temperatura : " + maxtempC + "°C" + "\n" + "Minimalna Temperatura : " +
                mintempC + "°C" + "\n" + "Średnia Temperatura : " + avgtempC + "°C");


    }
}


