
package utility;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import model.dao.DataConnection;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class JasperReportGenerator {
private String designfilepath;    

    public JasperReportGenerator(String designfilepath) {
        this.designfilepath = designfilepath;
    }
    public void generateReport() {
        try {
            JasperDesign jasperDesign = JRXmlLoader.load(designfilepath);
            JasperReport jasperReport
                    = JasperCompileManager.compileReport(jasperDesign);
            Connection con = DataConnection.getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, con);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            System.out.println("Exception in generationg report, generateReport() of JasperReportGenerator: " + e);
        }

    }

}
