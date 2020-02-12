import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;

public class InjuryReportScraper {

    LocalDate todaysDate;
    double hourOfDay;

//    public InjuryReportScraper() {
//        this.todaysDate = LocalDate.now();
//        this.hourOfDay = LocalTime.now().getHour() + LocalTime.now().getMinute() / 60.0;
//    }

    public InjuryReportScraper(LocalDate date) {
        this.todaysDate = date;
        this.hourOfDay = LocalTime.now().getHour() + LocalTime.now().getMinute() / 60.0;
    }

    public void run() throws IOException {
        if(getInjRepURL().equals("")) {
            System.out.println("\nError: There is no available injury report at this time.");
        }
        else {
            writeInjRepDataToFile(
                    pdfAtURLToText(
                            getInjRepURL()));
        }
    }

    public void writeInjRepDataToFile(String text) throws IOException {
        var csvFile = new File(new File("").getAbsolutePath() +
                "\\Injury-Report-Output.txt");
        var fileWriter = new FileWriter(csvFile, true);

        if(text.equals("")) {
            return;
        }

        fileWriter.write(text);
        fileWriter.write("\n\n");
        fileWriter.flush();
        fileWriter.close();
    }

    public String pdfAtURLToText(String urlString) throws IOException {
        var url = new URL(urlString);
        try (var in = url.openStream()) {
            Files.copy(in, Paths.get(urlString.split("/")[urlString.split("/").length-1]),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // Unreachable
        }
        var pdf = PDDocument.load(new File(urlString.split("/")[urlString.split("/").length-1]));
        var text = new PDFTextStripper().getText(pdf);
        pdf.close();

        var deleted = new File(urlString.split("/")[urlString.split("/").length-1]).delete();
        if(!deleted) {
            System.out.println("\nUnable to delete file '" +
                    urlString.split("/")[urlString.split("/").length-1] + "'.");
        }

        if (text.contains("Injury Report: " + formatDate(todaysDate))) {
            return "";
        }

        return text;
    }

    public String getInjRepURL() {
        var injRepTime = "";
        if (hourOfDay < 13.5) {
            return "";
        }
        else if (hourOfDay < 17.5) { injRepTime = "1"; }
        else if (hourOfDay < 20.5) { injRepTime = "5"; }
        else                       { injRepTime = "8"; }

        return "https://ak-static.cms.nba.com/referee/injury/Injury-Report_" +
                todaysDate.getYear() + "-" +
                String.format("%02d", todaysDate.getMonthValue()) + "-" +
                String.format("%02d", todaysDate.getDayOfMonth()) + "_0" +
                injRepTime + "PM.pdf";
    }

    public String formatDate(LocalDate date) {
        return String.format("%02d", date.getMonthValue()) + "/" +
                String.format("%02d", date.getDayOfMonth()) + "/" +
                date.getYear();
    }

}
