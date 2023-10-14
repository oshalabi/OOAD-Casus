package han.nl.oose.ooad.dummydata;

import han.nl.oose.ooad.credit.Credit;

import java.util.ArrayList;
import java.util.List;

public class Credits implements ICredits{
    List<Credit> credits;
    public Credits(){}
    @Override
    public List<Credit> createPackages() {
        credits = new ArrayList<>();
        credits.add(createCreditPackage(1000, 1.00));
        credits.add(createCreditPackage(2250, 2.00));
        credits.add(createCreditPackage(2250, 2.00));
        credits.add(createCreditPackage(10000, 7.00));
        return credits;
    }

    private Credit createCreditPackage(int aantalCredits, double price) {
        Credit credit = new Credit();
        credit.setAantalCredits(aantalCredits);
        credit.setPrice(price);
        return credit;
    }

}
