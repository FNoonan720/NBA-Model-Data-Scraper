import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        new CTGScraper().run();
        new InjuryReportScraper().run();
        new NBADotComScraper().run();

    }

}
