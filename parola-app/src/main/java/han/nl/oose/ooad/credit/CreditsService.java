package han.nl.oose.ooad.credit;

import han.nl.oose.ooad.dummydata.Credits;
import han.nl.oose.ooad.dummydata.ICredits;

import java.util.List;

public class CreditsService implements ICreditsService {
    private List<Credit> credits;
    private ICredits dummyCredits;

    public CreditsService() {
        dummyCredits = new Credits();
        this.credits = dummyCredits.createPackages();
    }

    @Override
    public String getCreditsPackages() {
        StringBuilder creditsInfo = new StringBuilder();

        for (Credit credit : this.credits) {
            creditsInfo.append("Aantal credits ")
                    .append(credit.getAantalCredits())
                    .append(" Prijs €")
                    .append(String.format("%.2f", credit.getPrice()))
                    .append("\n");
        }

        return creditsInfo.toString();
    }

    private Credit getCreditByPackage(int _package) {
        return credits.stream().filter(credit -> credit.getAantalCredits() ==_package).findFirst().orElse(null);
    }


    @Override
    public boolean purchase(int _package) {
        // TODO
        // implement payment method
        return this.getCreditByPackage(_package) != null;
    }

}
