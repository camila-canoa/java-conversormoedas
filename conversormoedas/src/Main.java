package conversordemoedas;

import java.util.Scanner;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gson gson = new Gson();

        String json = ApiConnector.getExchangeRates();
        ExchangeRates rates = gson.fromJson(json, ExchangeRates.class);

        System.out.println("Conversor de Moedas");
        System.out.println("Base: " + rates.getBaseCode());
        System.out.println("Digite o valor em USD:");
        double valorUSD = scanner.nextDouble();

        System.out.println("Escolha a moeda para converter:");
        System.out.println("1 - EUR");
        System.out.println("2 - BRL");
        System.out.println("3 - ARS");
        System.out.println("4 - GBP");
        System.out.println("5 - JPY");
        System.out.println("6 - CAD");
        int opcao = scanner.nextInt();

        String moeda = switch (opcao) {
            case 1 -> "EUR";
            case 2 -> "BRL";
            case 3 -> "ARS";
            case 4 -> "GBP";
            case 5 -> "JPY";
            case 6 -> "CAD";
            default -> "EUR";
        };

        double taxa = rates.getConversionRates().get(moeda);
        double convertido = valorUSD * taxa;

        System.out.println("Valor convertido em " + moeda + ": " + convertido);
    }
}
