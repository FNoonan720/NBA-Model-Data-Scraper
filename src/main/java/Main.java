import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {

        //new CTGScraper().run();
        //new InjuryReportScraper().run();

        for(int i = 113; i >= 0; i--) {
            new InjuryReportScraper(LocalDate.now().minusDays(i)).run();
        }

    }

}
