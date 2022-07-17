package org.profamilia.hc.view.backing.clinico.consultas;

import java.io.ByteArrayOutputStream;


import java.math.BigDecimal;

import java.net.URL;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.constantes.IConstantes;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.ModuleConfig;
import org.profamilia.hc.view.util.PDFMerger;
import org.profamilia.hc.view.util.PdfServletUtils;

public class ConsultaTomaTuberculinaBean extends BaseBean implements JRDataSource {


  

    public ConsultaTomaTuberculinaBean() {
    }


    public void init() {
      

    }


    public boolean next() {
        return false;
    }

    public Object getFieldValue(JRField jrField) {
        return null;
    }
}
