import java.util.ArrayList;

public class CTGTable {

    ArrayList<CTGTeamReport> rows;
    String title, date;

    public CTGTable(ArrayList<CTGTeamReport> rows, String title, String date) {
        this.rows = rows;
        this.title = title;
        this.date = date;
    }

    public String toCsv() {
        var strBuilder = new StringBuilder();
        strBuilder.append(title).append("\n");
        for (var row : rows) {
            strBuilder.append(row.toCsv());
        }
        strBuilder.append("\n");
        return strBuilder.toString();
    }

}