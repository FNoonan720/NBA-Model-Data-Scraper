import java.util.ArrayList;

public class CTGTable {

    ArrayList<TeamReport> rows;
    String title, date;

    public CTGTable(ArrayList<TeamReport> rows, String title, String date) {
        this.rows = rows;
        this.title = title;
        this.date = date;
    }

    public String toCsv() {
        var strBuilder = new StringBuilder();
        strBuilder.append(title).append("\n");
        for(var row : rows) {
            strBuilder.append(row.toCsv());
        }
        strBuilder.append("\n");
        return strBuilder.toString();
    }

    public ArrayList<TeamReport> getRows() {
        return rows;
    }

    public void setRows(ArrayList<TeamReport> rows) {
        this.rows = rows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
