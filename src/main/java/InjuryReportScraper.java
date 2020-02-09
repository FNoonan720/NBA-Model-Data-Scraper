import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class InjuryReportScraper {

    LocalDate todaysDate;
    double hourOfDay;

    public InjuryReportScraper() {
        this.todaysDate = LocalDate.now();
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
        var csvFile = new File(new File("").getAbsolutePath() + "\\Injury-Report-Output.txt");
        var fileWriter = new FileWriter(csvFile, true);

        fileWriter.write(text);
        fileWriter.close();
    }

    public String pdfAtURLToText(String urlString) throws IOException {

        URL url = new URL(urlString);
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(urlString.split("/")[urlString.split("/").length-1]), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            // Unreachable
        }

        return new PDFTextStripper().getText(PDDocument.load(new File(urlString.split("/")[urlString.split("/").length-1])));
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

}