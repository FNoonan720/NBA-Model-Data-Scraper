import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {

        //new CTGScraper().run();
        //new InjuryReportScraper().run();

        var endDate = LocalDate.now();
        for(int i = 0; i < 3; i++) {
            var title = "Injury-Report-Output-from-" + endDate.minusDays(40).toString() +
                    "-to-" + endDate.toString() + ".txt";
            System.out.println("title: " + title);
            for (int j = 40; j > 0; j--) {
                try {
                    new InjuryReportScraper(endDate.minusDays(j), title).run();
                } catch (Exception e) {

                }
            }
            endDate = endDate.minusDays(40);
        }

    }

}
