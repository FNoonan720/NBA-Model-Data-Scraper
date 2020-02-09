import java.util.ArrayList;

public class NBAPlayerReport {

    ArrayList<String> statStrings;

    public NBAPlayerReport(ArrayList<String> statStrings) {
        this.statStrings = statStrings;
    }

    public String toCsv() {
        var csv = new StringBuilder(statStrings.get(0));
        for (int i = 1; i < statStrings.size(); i++) {
            csv.append(", ").append(statStrings.get(i));
        }
        return csv.toString();
    }

}
