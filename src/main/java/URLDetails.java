public class URLDetails {

    String name, venue;
    String startMonth, startDayOfMonth, startYear;
    String endMonth, endDayOfMonth, endYear;

    public URLDetails(String name, String venue,
                      String startMonth, String startDayOfMonth, String startYear,
                      String endMonth, String endDayOfMonth, String endYear)
    {
        this.name = name;
        this.venue = venue;
        this.startMonth = startMonth;
        this.startDayOfMonth = startDayOfMonth;
        this.startYear = startYear;
        this.endMonth = endMonth;
        this.endDayOfMonth = endDayOfMonth;
        this.endYear = endYear;
    }

    public URLDetails(String name, String venue,
                      String endMonth, String endDayOfMonth, String endYear)
    {
        this.name = name;
        this.venue = venue;
        this.startMonth = "10";
        this.startDayOfMonth = "1";
        this.startYear = "2019";
        this.endMonth = endMonth;
        this.endDayOfMonth = endDayOfMonth;
        this.endYear = endYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getStartDayOfMonth() {
        return startDayOfMonth;
    }

    public void setStartDayOfMonth(String startDayOfMonth) {
        this.startDayOfMonth = startDayOfMonth;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }

    public String getEndDayOfMonth() {
        return endDayOfMonth;
    }

    public void setEndDayOfMonth(String endDayOfMonth) {
        this.endDayOfMonth = endDayOfMonth;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

}
