package com.rnf.core.reporting;

import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

public class MyJasperReportParam {
	private String jrxmlFile;
    private Map<String, Object> vars;
    private JRDataSource dataSource;

    public MyJasperReportParam(String jrxmlFile, Map<String, Object> vars, JRDataSource dataSource) {
        this.jrxmlFile = jrxmlFile;
        this.vars = vars;
        this.dataSource = dataSource;
    }

    public String getJrxmlFile() {
        return jrxmlFile;
    }

    public void setJrxmlFile(String jrxmlFile) {
        this.jrxmlFile = jrxmlFile;
    }

    public Map<String, Object> getVars() {
        return vars;
    }

    public void setVars(Map<String, Object> vars) {
        this.vars = vars;
    }

    public JRDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(JRDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
