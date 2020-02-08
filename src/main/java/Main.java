import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static final ArrayList<String> tableNames = new ArrayList<>(Arrays.asList(
            "Entire Season - home",
            "Entire Season - away",
            "Last 2 Weeks - home",
            "Last 2 Weeks - away"
    ));

    public static void main(String[] args) throws IOException {

        var tableList = getCTGTables(getCTGUrls(getCTGURLDetails(getDateMap())));

        for (var table : tableList) {
            System.out.println(table.getTitle());
            table.toCsv();
        }

        // TODO Write tables to csv file

    }

    public static Map<String, LocalDate> getDateMap() {
        var dateMap = new HashMap<String, LocalDate>();

        var today = LocalDate.now();

        dateMap.put("today", today);
        dateMap.put("2WksAgo", today.minusDays(15));

        return dateMap;
    }

    public static ArrayList<URLDetails> getCTGURLDetails(Map<String, LocalDate> dateMap) {

        var urlDetails = new ArrayList<URLDetails>();
        for(var title : tableNames) {
            if(title.split(" ")[0].equals("Entire")) {
                urlDetails.add(new URLDetails(title, title.split(" ")[title.split(" ").length-1],
                        Integer.toString(dateMap.get("today").getMonthValue()),
                        Integer.toString(dateMap.get("today").getDayOfMonth()),
                        Integer.toString(dateMap.get("today").getYear())));
            }
            else {
                urlDetails.add(new URLDetails(title, title.split(" ")[title.split(" ").length-1],
                        Integer.toString(dateMap.get("2WksAgo").getMonthValue()),
                        Integer.toString(dateMap.get("2WksAgo").getDayOfMonth()),
                        Integer.toString(dateMap.get("2WksAgo").getYear()),
                        Integer.toString(dateMap.get("today").getMonthValue()),
                        Integer.toString(dateMap.get("today").getDayOfMonth()),
                        Integer.toString(dateMap.get("today").getYear())));
            }
        }

        return urlDetails;
    }

    public static ArrayList<String> getCTGUrls(ArrayList<URLDetails> urlDetails) {
        var CTGUrls = new ArrayList<String>();
        for(var urlDetail : urlDetails) {
            CTGUrls.add("https://www.cleaningtheglass.com/stats/league/fourfactors?season=2019&seasontype=regseason" +
                    "&start=" + urlDetail.getStartMonth() +
                    "/" + urlDetail.getStartDayOfMonth() +
                    "/" + urlDetail.getStartYear() +
                    "&end=" + urlDetail.getEndMonth() +
                    "/" + urlDetail.getEndDayOfMonth() +
                    "/" + urlDetail.getEndYear() +
                    "&venue=" + urlDetail.getVenue());
        }

        return CTGUrls;
    }

    public static ArrayList<CTGTable> getCTGTables(ArrayList<String> urls) throws IOException {

        var tableList = new ArrayList<CTGTable>();
        for (int i = 0; i < urls.size(); i++) {
            var document = Jsoup.connect(urls.get(i)).get();
            var teamNames = document.getElementsByClass("team_name");
            var parsedStatValues = parseStatValues(document.getElementsByClass("stat value"));

            var rows = new ArrayList<TeamReport>();
            for(int j = 0; j < teamNames.size(); j++) {
                rows.add(new TeamReport(teamNames.get(j).text(),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size())).intValue(),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 1).intValue(),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 2),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 3),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 4),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 5),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 6),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 7),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 8),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 9),
                        parsedStatValues.get(j * (parsedStatValues.size() / teamNames.size()) + 10)));
            }
            rows.sort(Comparator.comparing(TeamReport::getTeamName));
            tableList.add(new CTGTable(rows,
                    tableNames.get(i),
                    tableNames.get(i).substring(tableNames.get(i).length()-4)));

        }

        return tableList;
    }

    public static ArrayList<Double> parseStatValues(Elements statValues) {

        var parsedStatValues = new ArrayList<Double>();
        for (var statValue : statValues) {
            if (statValue.text().charAt(statValue.text().length()-1) == '%') {
                parsedStatValues.add(Double.parseDouble(statValue.text().substring(0,statValue.text().length()-1)));
            }
            else if (statValue.text().charAt(0) == '+') {
                parsedStatValues.add(Double.parseDouble(statValue.text().substring(1)));
            }
            else {
                parsedStatValues.add(Double.parseDouble(statValue.text()));
            }
        }

        return parsedStatValues;
    }

}
