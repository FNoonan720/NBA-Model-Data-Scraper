import java.util.ArrayList;

public class CTGTable {

    ArrayList<TeamReport> rows;
    String title, venue;

    public CTGTable(ArrayList<TeamReport> rows, String title, String venue) {
        this.rows = rows;
        this.title = title;
        this.venue = venue;
    }

    public void toCsv() {
        for(var row : rows) {
            System.out.print(row.toCsv());
        }
        System.out.print("\n");
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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }
}
