package org.Testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import tech.grasshopper.pdf.extent.RestAssuredExtentPDFCucumberReporter;

public class ReportManager {
//    private static ExtentReports extentReports;
//
//    public static ExtentReports getExtentReports() {
//        if (extentReports == null) {
//            extentReports = new ExtentReports();
//
//            // Generate dynamic date and time for report filenames
//            String dateTim = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
//
//            // Define the Spark report path
//            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/SparkReport/MMSREPORT_" + dateTim + ".html");
//            extentReports.attachReporter(sparkReporter);
//
//            // Define the PDF report path
//            RestAssuredExtentPDFCucumberReporter pdfReporter = new RestAssuredExtentPDFCucumberReporter("test-output/PdfReport/MMSPDFREPORT_" + dateTim + ".pdf");
//            extentReports.attachReporter(pdfReporter);
//        }
//        return extentReports;
//    }
//
//    public static void flushReports() {
//        if (extentReports != null) {
//            extentReports.flush();
//        }
//    }
	
    private static ExtentReports extentReports;

    public static ExtentReports getExtentReports() {
        if (extentReports == null) {
            extentReports = new ExtentReports();

            // Generate dynamic date and time for report filenames
            String dateTim = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

            // Define the Spark report path
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/SparkReport/MMSREPORT_" + dateTim + ".html");
            extentReports.attachReporter(sparkReporter);

            RestAssuredExtentPDFCucumberReporter pdfReporter = new RestAssuredExtentPDFCucumberReporter("test-output/PdfReport/MMSPDFREPORT_" + dateTim + ".pdf");
            extentReports.attachReporter(pdfReporter);
        }
        return extentReports;
    }

    public static void flushReports() {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

}
