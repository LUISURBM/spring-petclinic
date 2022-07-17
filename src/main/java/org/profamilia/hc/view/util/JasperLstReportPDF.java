package org.profamilia.hc.view.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chsignovital;


public class JasperLstReportPDF {

    /**
     * @param Lista String registros
     * @param Arreglo String csvColumnNames
     * @param Map reportParameters
     * @param String Nombre del reporte compilado
     * @return a byte array of the merged PDF
     */
     public static byte[] JasperLstReportPDF(List<String> registros, String[] csvColumnNames, Map reportParameters, String reportFileName) {
         byte[] result = null;
         char fieldDelimiter = '|';
         try {
            JRHtmlExporter exporter = new JRHtmlExporter();
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
            StringBuffer sbuffer = new StringBuffer();
            JasperPrint jasperPrint = new JasperPrint();

            String listString = "";
            for (String s : registros) {
                listString += s + "\t";
            }                 
            InputStream in = new ByteArrayInputStream(listString.getBytes());                   
            JRCsvDataSource dataSource = new JRCsvDataSource(in);
            dataSource.setFieldDelimiter(fieldDelimiter);


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            dataSource.setDateFormat(simpleDateFormat);

            if(csvColumnNames != null)
               dataSource.setColumnNames(csvColumnNames);

            URL url = FacesUtils.getFacesContext().getExternalContext().getResource(reportFileName);
            if (url != null) {
               JasperReport report = (JasperReport)JRLoader.loadObject(url);
               jasperPrint = JasperFillManager.fillReport(report, reportParameters, dataSource);

            }

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STRING_BUFFER, sbuffer);
         // exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, reportParameters());
            exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, 
                                       request.getContextPath() + 
                                       "/comun/imagenes?image=");
            exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
            exporter.setParameter(JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING, "ISO-8859-9");
            exporter.setParameter(JRHtmlExporterParameter.HTML_FOOTER, "");
            exporter.setParameter(JRHtmlExporterParameter.HTML_HEADER, "");

            result = JasperExportManager.exportReportToPdf(jasperPrint);
                     
         } catch(Exception e) {
            e.printStackTrace();
         }
      return result;
   }

    /**
     * @param Lista de Map registros
     * @param Arreglo String csvColumnNames
     * @param Map reportParameters
     * @param String Nombre del reporte compilado
     * @return a byte array of the merged PDF
     */
   
    public static byte[] JasperMapReportPDF(List<Map> registros, String[] csvColumnNames, Map reportParameters, String reportFileName) {
        byte[] result = null;
        List<String> registrosStr = new ArrayList<String>();
        String lineaStr;
        if (registros != null && !registros.isEmpty()) {
            Iterator it = registros.iterator();
            while (it.hasNext()) {
                Map<Integer,String> linea = (HashMap)it.next();
                lineaStr = "";
                for (int i = 1; i <= linea.size(); i++) {
                    lineaStr += linea.get(i);
                    lineaStr += "|";
                }
                registrosStr.add(lineaStr);
            }
        }
        result = JasperLstReportPDF(registrosStr, csvColumnNames, reportParameters, reportFileName);
        return result;
    }
}