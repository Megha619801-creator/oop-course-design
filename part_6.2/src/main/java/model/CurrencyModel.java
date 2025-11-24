package model;

import java.util.ArrayList;
import java.util.List;

public class CurrencyModel {

    private List<Currency> currencies;

    public CurrencyModel() {
        currencies = new ArrayList<>();

        // Hardcode example currencies
        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 1.07));
        currencies.add(new Currency("GBP", "British Pound", 1.24));
        currencies.add(new Currency("JPY", "Japanese Yen", 0.0066));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        // Convert FROM currency → USD → TO currency
        double inUSD = amount * from.getRateToUSD();
        return inUSD / to.getRateToUSD();
    }
}
