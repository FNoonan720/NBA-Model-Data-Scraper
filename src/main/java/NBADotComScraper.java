import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class NBADotComScraper {

    LocalDate todaysDate;

    public NBADotComScraper() {
        this.todaysDate = LocalDate.now();
    }

    public void run() throws IOException {
        getMinPlayedTable(getMinPlayedURL());
    }

    public NBADotComTable getMinPlayedTable(String url) throws IOException {

        var doc = Jsoup.connect(url).get();
        System.out.println("doc.toString(): " + doc.toString());
        var tdElements = doc.getElementsByTag("td");

        //TODO Figure out how to scrape stats.nba.com

        var rows = new ArrayList<NBAPlayerReport>();
        for (var tdElement : tdElements) {
            System.out.println("tdElements.get(i).text(): " + tdElement.text());
        }

        return new NBADotComTable(new ArrayList<>(), "", "");
    }

    public String getMinPlayedURL() {
        return "https://stats.nba.com/players/traditional/?sort=PLAYER_NAME" +
                "&dir=-1" +
                "&Season=2019-20" +
                "&SeasonType=Regular%20Season" +
                "&PerMode=Totals" +
                "&DateFrom=" +
                todaysDate.minusDays(15).getMonthValue() + "%2F" +
                todaysDate.minusDays(15).getDayOfMonth() + "%2F" +
                todaysDate.minusDays(15).getYear();
    }

}
