package com.conversor.monedas.ui;

import com.conversor.monedas.utils.Currency;
import com.conversor.monedas.utils.CurrencyConverter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final CurrencyConverter currencyConverter;

    // Lista de monedas comunes
    private final List<Currency> currencies = Arrays.asList(
            new Currency("USD", "United States Dollar", "United States"),
            new Currency("CAD", "Canadian Dollar", "Canada"),
            new Currency("MXN", "Mexican Peso", "Mexico"),
            new Currency("ARS", "Argentine Peso", "Argentina"),
            new Currency("BRL", "Brazilian Real", "Brazil"),
            new Currency("COP", "Colombian Peso", "Colombia"),
            new Currency("EUR", "Euro", "European Union"),
            new Currency("GBP", "Pound Sterling", "United Kingdom"),
            new Currency("JPY", "Japanese Yen", "Japan"),
            new Currency("AUD", "Australian Dollar", "Australia")
    );

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.currencyConverter = new CurrencyConverter();
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("**************************************************");
            System.out.println("Sea bienvenido al conversor de monedas");
            System.out.println("**************************************************");
            System.out.println("Elija una opción válida:");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real Brasileño");
            System.out.println("4) Real Brasileño => Dólar");
            System.out.println("5) Dólar => Peso Colombiano");
            System.out.println("6) Peso Colombiano => Dólar");
            System.out.println("7) Ingresa el código de tu moneda");
            System.out.println("8) Salir");
            System.out.println("*******************************************");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    convertCurrency("USD", "ARS");
                    break;
                case 2:
                    convertCurrency("ARS", "USD");
                    break;
                case 3:
                    convertCurrency("USD", "BRL");
                    break;
                case 4:
                    convertCurrency("BRL", "USD");
                    break;
                case 5:
                    convertCurrency("USD", "COP");
                    break;
                case 6:
                    convertCurrency("COP", "USD");
                    break;
                case 7:
                    displayCurrencyInputMenu();
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void displayCurrencyInputMenu() {
        // Menú para ingresar el código de la moneda
        System.out.println("***Ingresa el código de tu moneda***");
        System.out.println("1) Ingresa el código de tu moneda:");
        System.out.println("2) Checar todos los códigos disponibles");
        System.out.println("3) Regresar al menú anterior");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                enterCurrencyCode();
                break;
            case 2:
                displayAvailableCurrencyCodes();
                break;
            case 3:
                return; // Regresar al menú anterior
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
                displayCurrencyInputMenu(); // Mostrar el menú nuevamente
        }
    }

    private void enterCurrencyCode() {
        // Pedir el código de la moneda base y objetivo
        System.out.print("Ingrese el código de la moneda base (ej. USD): ");
        String baseCode = scanner.next();
        System.out.print("Ingrese el código de la moneda objetivo (ej. ARS): ");
        String targetCode = scanner.next();
        System.out.print("Ingrese el valor que desea convertir: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = currencyConverter.convert(baseCode, targetCode, amount);
            System.out.printf("El valor convertido es: %.2f %s%n", convertedAmount, targetCode);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al convertir: " + e.getMessage());
        }
    }

    private void displayAvailableCurrencyCodes() {
        System.out.println("**************************************************");
        System.out.println("Monedas disponibles:");
        for (Currency currency : currencies) {
            System.out.printf("%s - %s (%s)%n", currency.getCode(), currency.getName(), currency.getCountry());
        }
        System.out.println("**************************************************");
        System.out.println("Presiona Enter para regresar al menú anterior...");
        scanner.nextLine(); // Esperar a que el usuario presione una tecla
        scanner.nextLine(); // Para evitar problemas con el buffer de scanner
    }

    private void convertCurrency(String baseCode, String targetCode) {
        System.out.print("Ingrese el valor que desea convertir: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = currencyConverter.convert(baseCode, targetCode, amount);
            System.out.printf("El valor convertido es: %.2f %s%n", convertedAmount, targetCode);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al convertir: " + e.getMessage());
        }
    }
}
