package controller;

import model.Currency;
import model.CurrencyModel;

public class CurrencyController {

    private CurrencyModel model;

    public CurrencyController() {
        model = new CurrencyModel();
    }

    public CurrencyModel getModel() {
        return model;
    }

    public double convert(double amount, Currency from, Currency to) {
        return model.convert(amount, from, to);
    }
}
