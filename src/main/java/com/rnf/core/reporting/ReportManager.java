package com.rnf.core.reporting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

/**
 * https://stackoverflow.com/questions/24117878/jasperreports-5-6-jrxlsexporter-setparameter-is-deprecated
 * https://stackoverflow.com/questions/33393400/jasper-reports-how-to-combine-two-report-streams-into-one-pdf-output
 * @author SADSB-Mitanjo
 *
 */
public class ReportManager {
	private List<MyJasperReportParam> myJasperReportParams;
	
	public ReportManager(List<MyJasperReportParam> myJasperReportParams) {
        this.myJasperReportParams = myJasperReportParams;
    }
	
	public void exportReportsToPdfStream(HttpServletResponse response) throws JRException, IOException {
		this.exportReportsToPdforExcel(response, "pdf");
	}
	
	private void exportReportsToPdforExcel(HttpServletResponse response, String exportType) throws JRException, IOException {
        List<JasperPrint> jasperReports = new ArrayList<>();
        
        for(MyJasperReportParam jParam : this.myJasperReportParams) {
            JasperReport report = JasperCompileManager.compileReport(jParam.getJrxmlFile());
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, jParam.getVars(), jParam.getDataSource());
            jasperReports.add(jasperPrint);
        }
        
        ServletOutputStream outputStream = response.getOutputStream(); 
        
        if(exportType.equals("pdf")) {
	        JRPdfExporter exporter = new JRPdfExporter();
	        
	        exporter.setExporterInput(SimpleExporterInput.getInstance(jasperReports));
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	        
	        exporter.exportReport();
	    } else if(exportType.equals("excel")) {
	    	JRXlsExporter exporter = new JRXlsExporter();
	    	
	    	exporter.setExporterInput(SimpleExporterInput.getInstance(jasperReports));
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
	    	
	    	SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
	    	configuration.setOnePagePerSheet(true);
	    	configuration.setDetectCellType(true);
	    	configuration.setCollapseRowSpan(false);
	    	exporter.setConfiguration(configuration);

	    	exporter.exportReport();
	    } else throw new JRException("ReportManager: export type must be excel or pdf");
    }
}
