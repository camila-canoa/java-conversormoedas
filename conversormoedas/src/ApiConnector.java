package conversordemoedas;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnector {

    public static String getExchangeRates() {
        String apiKey = "1b29b1c7a25f08cff1f5fd80";
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return response.toString();

        } catch (Exception e) {
            System.out.println("Erro ao conectar com a API: " + e.getMessage());
            return null;
        }
    }
}
