package org.profamilia.hc.view.backing.comun.reporte;

import java.io.ByteArrayOutputStream;

import java.math.BigDecimal;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chreportes;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cvcontrato;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.profamilia.hc.view.util.XlsServletUtils;


public class ReporteVariosBean extends BaseBean implements JRDataSource {

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer wcodrep;

    private Integer codcontrato;

    private List lstContratos;

    private boolean generoReporte;

    private List<Object[]> lstReporte;

    private UIInput mnuCodclin;

    private int index;

    private List lstReportes;

    private List lstTipoUsuarios;

    BigDecimal CLINICA;
    Date FECHA_REGISTRO;
    String TIPO_IDENTIDAD;
    BigDecimal NUMERO_IDENTIDAD;
    Date FECHA_NACIMIENTO;
    BigDecimal EDAD;
    String SEXO;
    String CODIGO_SERVICIO;
    String SERVICIO;
    String CODIGO_DISCAPACIDAD;
    String DISCAPACIDAD;
    String NOMBRE_CLINICA;
    String COD_IDENTIDAD;
    String IDENTIDAD;
    String PAGADOR;
    BigDecimal USUARIO;
    String COD_DIAG_PRIN;
    String DIAG_PRINCIPAL;
    String COD_DIAG_RELA1;
    String COD_DIAG_RELA2;
    String COD_DIAG_RELA3;
    String DIAG_RELA1;
    String DIAG_RELA2;
    String DIAG_RELA3;
    String VIOLENCIA_FISICA;
    String TIEMPO_FISICA;
    String VIOLENCIA_PSICOLOGICA;
    String TIEMPO_PSICOLOGICA;
    String VIOLENCIA_SEXUAL;
    String TIEMPO_SEXUAL;
    String VIOLENCIA_REPRODUCTIVA;
    String TIEMPO_REPRODUCTIVA;
    String VIOLENCIA_ECONOMICA;
    String TIEMPO_ECONOMICA;
    String REMITIDO;
    String CUAL_REMISION;
    BigDecimal CONTRATO;
    BigDecimal CODIGO_HISTORIA;
    String HISTORIA;
    String ASEGURADORA;
    String VULNERABILIDAD;
    String ESQ_CITOLOGIA;
    String OTRO_ESQ_CITO;
    String PROCEDIMIENTO_NINGUNO;
    String CAUTERIZACION;
    Date FECHA_CAUTERIZACION;
    String HISTERECTOMIA;
    Date FECHA_HISTERECTOMIA;
    String CONIZACION;
    Date FECHA_CONIZACION;
    String RADIOTERAPIA;
    Date FECHA_RADIOTERAPIA;
    String BIOPSIA;
    Date FECHA_BIOPSIA;
    String CRIOTERAPIA;
    Date FECHA_CRIOTERAPIA;
    String ATA;
    Date FECHA_ATA;
    String OTRO_PROCEDIMIENTO;
    Date FECHA_OTRO_PROCEDIMIENTO;
    String DESCRIPCION_OTRO;
    String VAPORIZACION;
    Date FECHA_VAPORIZACION;
    String HORMONAL;
    Date FECHA_HORMONAL;
    String TIPIFICACION;
    Date FECHA_TIPIFICACION;
    String COLPOSCOPIA;
    Date FECHA_COLPOSCOPIA;
    String ESQUEMA_VPH;
    String OTRO_ESQ_VPH;
    Date FECHA_LECTURA;
    BigDecimal TARJETA_PROFESIONAL;
    String GENOTIPIFICACION_NEGATIVO;
    String GENOTIPIFICACION;
    String GENOTIPO_16;
    String GENOTIPO_18;
    String GENOTIPO_31;
    String GENOTIPO_45;
    String GENOTIPO_51;
    String GENOTIPO_52;
    String GENOTIPO_3858;
    String GENOTIPO_353968;
    String GENOTIPO_565966;
    String CONDUCTA;
    String INTERPRETACION;
    String COMPLETO_ESQUEMA_VPH;
    BigDecimal NUMERO_DOSIS;
    String ZONA_RESIDENCIAL;
    String NOMBRE_CONTRATO;
    String ENFERMEDAD;
    String MOTIVO;
    String CELULAS;
    String NOMBRE_CELULAS;
    String COD_ANOR_GLAN;
    String ANOR_GLAN;
    BigDecimal USUARIO_COLPOSCOPIA;
    BigDecimal CLINICA_COLPOSCOPIA;
    String NOMBRE_CLIN_COLPOSCOPIA;
    String SERVICIO_COLPOSCOPIA;
    String COD_SERV_COLPOSCOPIA;
    Date FECHA_ENTREGA;
    BigDecimal USUARIO_ENTREGA;
    BigDecimal CLINICA_ENTREGA;
    String NOMBRE_CLINICA_ENTREGA;
    String SERVICIO_ENTREGA;
    String NOMBRE_SERVICIO_ENTREGA;
    String NACIONALIDAD;
    BigDecimal NIT;
    String PAQUETE;
    BigDecimal CANTIDAD;
    Date FECHA_PATOLOGIA;
    BigDecimal USUARIO_PATOLOGIA;
    BigDecimal CLINICA_PATOLOGIA;
    String NOMBRE_CLINICA_PATO;
    String SERVICIO_PATO;
    String NOMBRE_SERVICIO_PATO;
    String TRAE_PATOLOGIA;
    String TIPO_PATOLOGIA;
    String RESULTADO_PATOLOGIA;
    String DESC_RESU_PATO;
    BigDecimal USUARIO_CONIZACION;
    BigDecimal CLINICA_CONIZACION;
    String NOMBRE_CLINICA_CONI;
    String SERVICIO_CONIZACION;
    String NOMBRE_SERVICIO_CONI;

    private String nombSalida;

    public ReporteVariosBean() {
    }

    public void init() {
        inicializarReporteFacturacionContrato();
    }

    public void inicializarReporteFacturacionContrato() {
        lstReportes = new ArrayList();
        lstTipoUsuarios = new ArrayList();

        setWcodrep(this.getClinica().getCclncodigo());
    }

    /**
     * @return
     */

    /**
     * @return
     */
    public boolean next() {
        index++;
        if (lstReporte != null)
            return index < lstReporte.size();
        else
            return false;
    }


    /**
     * @param jrField
     * @return
     */
    public Object getFieldValue(JRField jrField) {
        Object value = null;
        String fieldName = jrField.getName();
        obtenerDatosReporte(index);

        if (wcodrep == 0) {
            if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("TIPO_IDENTIDAD"))
                value = TIPO_IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("FECHA_NACIMIENTO"))
                value = FECHA_NACIMIENTO;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("SEXO"))
                value = SEXO;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("CODIGO_DISCAPACIDAD"))
                value = CODIGO_DISCAPACIDAD;
            else if (fieldName.equals("DISCAPACIDAD"))
                value = DISCAPACIDAD;
        } else if (wcodrep == 1) {
            if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("FECHA_NACIMIENTO"))
                value = FECHA_NACIMIENTO;
            else if (fieldName.equals("COD_IDENTIDAD"))
                value = COD_IDENTIDAD;
            else if (fieldName.equals("IDENTIDAD"))
                value = IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("PAGADOR"))
                value = PAGADOR;
        } else if (wcodrep == 2) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("USUARIO"))
                value = USUARIO;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("SEXO"))
                value = SEXO;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("COD_DIAG_PRIN"))
                value = COD_DIAG_PRIN;
            else if (fieldName.equals("DIAG_PRINCIPAL"))
                value = DIAG_PRINCIPAL;
            else if (fieldName.equals("COD_DIAG_RELA1"))
                value = COD_DIAG_RELA1;
            else if (fieldName.equals("DIAG_RELA1"))
                value = DIAG_RELA1;
            else if (fieldName.equals("COD_DIAG_RELA2"))
                value = COD_DIAG_RELA2;
            else if (fieldName.equals("DIAG_RELA2"))
                value = DIAG_RELA2;
            else if (fieldName.equals("COD_DIAG_RELA3"))
                value = COD_DIAG_RELA3;
            else if (fieldName.equals("DIAG_RELA3"))
                value = DIAG_RELA3;
        } else if (wcodrep == 3) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("USUARIO"))
                value = USUARIO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("VIOLENCIA_FISICA"))
                value = VIOLENCIA_FISICA;
            else if (fieldName.equals("TIEMPO_FISICA"))
                value = TIEMPO_FISICA;
            else if (fieldName.equals("VIOLENCIA_PSICOLOGICA"))
                value = VIOLENCIA_PSICOLOGICA;
            else if (fieldName.equals("TIEMPO_PSICOLOGICA"))
                value = TIEMPO_PSICOLOGICA;
            else if (fieldName.equals("VIOLENCIA_SEXUAL"))
                value = VIOLENCIA_SEXUAL;
            else if (fieldName.equals("TIEMPO_SEXUAL"))
                value = TIEMPO_SEXUAL;
            else if (fieldName.equals("VIOLENCIA_REPRODUCTIVA"))
                value = VIOLENCIA_REPRODUCTIVA;
            else if (fieldName.equals("TIEMPO_REPRODUCTIVA"))
                value = TIEMPO_REPRODUCTIVA;
            else if (fieldName.equals("VIOLENCIA_ECONOMICA"))
                value = VIOLENCIA_ECONOMICA;
            else if (fieldName.equals("TIEMPO_ECONOMICA"))
                value = TIEMPO_ECONOMICA;
            else if (fieldName.equals("REMITIDO"))
                value = REMITIDO;
            else if (fieldName.equals("CONTRATO"))
                value = CONTRATO;
            else if (fieldName.equals("SEXO"))
                value = SEXO;
            else if (fieldName.equals("FECHA_NACIMIENTO"))
                value = FECHA_NACIMIENTO;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
        } else if (wcodrep == 4) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("USUARIO"))
                value = USUARIO;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("SEXO"))
                value = SEXO;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("COD_DIAG_PRIN"))
                value = COD_DIAG_PRIN;
            else if (fieldName.equals("DIAG_PRINCIPAL"))
                value = DIAG_PRINCIPAL;
            else if (fieldName.equals("COD_DIAG_RELA1"))
                value = COD_DIAG_RELA1;
            else if (fieldName.equals("DIAG_RELA1"))
                value = DIAG_RELA1;
            else if (fieldName.equals("COD_DIAG_RELA2"))
                value = COD_DIAG_RELA2;
            else if (fieldName.equals("DIAG_RELA2"))
                value = DIAG_RELA2;
            else if (fieldName.equals("COD_DIAG_RELA3"))
                value = COD_DIAG_RELA3;
            else if (fieldName.equals("DIAG_RELA3"))
                value = DIAG_RELA3;
        } else if (wcodrep == 5) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("TIPO_IDENTIDAD"))
                value = TIPO_IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
        } else if (wcodrep == 6) {
            if (fieldName.equals("TIPO_IDENTIDAD"))
                value = TIPO_IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("CODIGO_HISTORIA"))
                value = CODIGO_HISTORIA;
            else if (fieldName.equals("HISTORIA"))
                value = HISTORIA;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("ASEGURADORA"))
                value = ASEGURADORA;
            else if (fieldName.equals("IDENTIDAD"))
                value = IDENTIDAD;
            else if (fieldName.equals("VULNERABILIDAD"))
                value = VULNERABILIDAD;
            else if (fieldName.equals("ESQ_CITOLOGIA"))
                value = ESQ_CITOLOGIA;
            else if (fieldName.equals("OTRO_ESQ_CITO"))
                value = OTRO_ESQ_CITO;
            else if (fieldName.equals("PROCEDIMIENTO_NINGUNO"))
                value = PROCEDIMIENTO_NINGUNO;
            else if (fieldName.equals("CAUTERIZACION"))
                value = CAUTERIZACION;
            else if (fieldName.equals("FECHA_CAUTERIZACION"))
                value = FECHA_CAUTERIZACION;
            else if (fieldName.equals("HISTERECTOMIA"))
                value = HISTERECTOMIA;
            else if (fieldName.equals("FECHA_HISTERECTOMIA"))
                value = FECHA_HISTERECTOMIA;
            else if (fieldName.equals("CONIZACION"))
                value = CONIZACION;
            else if (fieldName.equals("FECHA_CONIZACION"))
                value = FECHA_CONIZACION;
            else if (fieldName.equals("RADIOTERAPIA"))
                value = RADIOTERAPIA;
            else if (fieldName.equals("FECHA_RADIOTERAPIA"))
                value = FECHA_RADIOTERAPIA;
            else if (fieldName.equals("BIOPSIA"))
                value = BIOPSIA;
            else if (fieldName.equals("FECHA_BIOPSIA"))
                value = FECHA_BIOPSIA;
            else if (fieldName.equals("CRIOTERAPIA"))
                value = CRIOTERAPIA;
            else if (fieldName.equals("FECHA_CRIOTERAPIA"))
                value = FECHA_CRIOTERAPIA;
            else if (fieldName.equals("ATA"))
                value = ATA;
            else if (fieldName.equals("FECHA_ATA"))
                value = FECHA_ATA;
            else if (fieldName.equals("OTRO_PROCEDIMIENTO"))
                value = OTRO_PROCEDIMIENTO;
            else if (fieldName.equals("DESCRIPCION_OTRO"))
                value = DESCRIPCION_OTRO;
            else if (fieldName.equals("VAPORIZACION"))
                value = VAPORIZACION;
            else if (fieldName.equals("FECHA_VAPORIZACION"))
                value = FECHA_VAPORIZACION;
            else if (fieldName.equals("HORMONAL"))
                value = HORMONAL;
            else if (fieldName.equals("FECHA_HORMONAL"))
                value = FECHA_HORMONAL;
            else if (fieldName.equals("TIPIFICACION"))
                value = TIPIFICACION;
            else if (fieldName.equals("FECHA_TIPIFICACION"))
                value = FECHA_TIPIFICACION;
            else if (fieldName.equals("COLPOSCOPIA"))
                value = COLPOSCOPIA;
            else if (fieldName.equals("FECHA_COLPOSCOPIA"))
                value = FECHA_COLPOSCOPIA;
            else if (fieldName.equals("ESQUEMA_VPH"))
                value = ESQUEMA_VPH;
            else if (fieldName.equals("OTRO_ESQ_VPH"))
                value = OTRO_ESQ_VPH;
            else if (fieldName.equals("FECHA_LECTURA"))
                value = FECHA_LECTURA;
            else if (fieldName.equals("TARJETA_PROFESIONAL"))
                value = TARJETA_PROFESIONAL;
            else if (fieldName.equals("GENOTIPIFICACION_NEGATIVO"))
                value = GENOTIPIFICACION_NEGATIVO;
            else if (fieldName.equals("GENOTIPIFICACION"))
                value = GENOTIPIFICACION;
            else if (fieldName.equals("GENOTIPO_16"))
                value = GENOTIPO_16;
            else if (fieldName.equals("GENOTIPO_18"))
                value = GENOTIPO_18;
            else if (fieldName.equals("GENOTIPO_31"))
                value = GENOTIPO_31;
            else if (fieldName.equals("GENOTIPO_45"))
                value = GENOTIPO_45;
            else if (fieldName.equals("GENOTIPO_51"))
                value = GENOTIPO_51;
            else if (fieldName.equals("GENOTIPO_52"))
                value = GENOTIPO_52;
            else if (fieldName.equals("GENOTIPO_3858"))
                value = GENOTIPO_3858;
            else if (fieldName.equals("GENOTIPO_353968"))
                value = GENOTIPO_353968;
            else if (fieldName.equals("GENOTIPO_565966"))
                value = GENOTIPO_565966;
            else if (fieldName.equals("CONDUCTA"))
                value = CONDUCTA;
            else if (fieldName.equals("INTERPRETACION"))
                value = INTERPRETACION;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("COMPLETO_ESQUEMA_VPH"))
                value = COMPLETO_ESQUEMA_VPH;
            else if (fieldName.equals("NUMERO_DOSIS"))
                value = NUMERO_DOSIS;
            else if (fieldName.equals("ZONA_RESIDENCIAL"))
                value = ZONA_RESIDENCIAL;
            else if (fieldName.equals("CONTRATO"))
                value = CONTRATO;
            else if (fieldName.equals("NOMBRE_CONTRATO"))
                value = NOMBRE_CONTRATO;
        } else if (wcodrep == 7) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("USUARIO"))
                value = USUARIO;
            else if (fieldName.equals("TIPO_IDENTIDAD"))
                value = TIPO_IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("ENFERMEDAD"))
                value = ENFERMEDAD;
            else if (fieldName.equals("MOTIVO"))
                value = MOTIVO;
        } else if (wcodrep == 8) {
            if (fieldName.equals("FECHA_COLPOSCOPIA"))
                value = FECHA_COLPOSCOPIA;
            else if (fieldName.equals("USUARIO"))
                value = USUARIO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("FECHA_PATOLOGIA"))
                value = FECHA_PATOLOGIA;
            else if (fieldName.equals("USUARIO_PATOLOGIA"))
                value = USUARIO_PATOLOGIA;
            else if (fieldName.equals("CLINICA_PATOLOGIA"))
                value = CLINICA_PATOLOGIA;
            else if (fieldName.equals("NOMBRE_CLIENTE_PATO"))
                value = NOMBRE_CLINICA_PATO;
            else if (fieldName.equals("SERVICIO_PATO"))
                value = SERVICIO_PATO;
            else if (fieldName.equals("NOMBRE_SERVICIO_PATO"))
                value = NOMBRE_SERVICIO_PATO;
            else if (fieldName.equals("TRAE_PATOLOGIA"))
                value = TRAE_PATOLOGIA;
            else if (fieldName.equals("TIPO_PATOLOGIA"))
                value = TIPO_PATOLOGIA;
            else if (fieldName.equals("RESULTADO_PATOLOGIA"))
                value = RESULTADO_PATOLOGIA;
            else if (fieldName.equals("DESC_RESU_PATO"))
                value = DESC_RESU_PATO;
            else if (fieldName.equals("FECHA_CONIZACION"))
                value = FECHA_CONIZACION;
            else if (fieldName.equals("USUARIO_CONIZACION"))
                value = USUARIO_CONIZACION;
            else if (fieldName.equals("CLINICA_CONIZACION"))
                value = CLINICA_CONIZACION;
            else if (fieldName.equals("NOMBRE_CLINICA_CONI"))
                value = NOMBRE_CLINICA_CONI;
            else if (fieldName.equals("USUARIO_CONIZACION"))
                value = SERVICIO_CONIZACION;
            else if (fieldName.equals("NOMBRE_SERVICIO_CONI"))
                value = NOMBRE_SERVICIO_CONI;
        } else if (wcodrep == 9) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("CELULAS"))
                value = CELULAS;
            else if (fieldName.equals("NOMBRE_CELULAS"))
                value = NOMBRE_CELULAS;
            else if (fieldName.equals("COD_ANOR_GLAN"))
                value = COD_ANOR_GLAN;
            else if (fieldName.equals("ANOR_GLAN"))
                value = ANOR_GLAN;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("TIPO_IDENTIDAD"))
                value = TIPO_IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("USUARIO"))
                value = USUARIO;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("FECHA_COLPOSCOPIA"))
                value = FECHA_COLPOSCOPIA;
            else if (fieldName.equals("USUARIO_COLPOSCOPIA"))
                value = USUARIO_COLPOSCOPIA;
            else if (fieldName.equals("CLINICA_COLPOSCOPIA"))
                value = CLINICA_COLPOSCOPIA;
            else if (fieldName.equals("NOMBRE_CLIN_COLPOSCOPIA"))
                value = NOMBRE_CLIN_COLPOSCOPIA;
            else if (fieldName.equals("COD_SERV_COLPOSCOPIA"))
                value = COD_SERV_COLPOSCOPIA;
            else if (fieldName.equals("SERVICIO_COLPOSCOPIA"))
                value = SERVICIO_COLPOSCOPIA;
        } else if (wcodrep == 10) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("USUARIO"))
                value = USUARIO;
            else if (fieldName.equals("TIPO_IDENTIDAD"))
                value = TIPO_IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("FECHA_ENTREGA"))
                value = FECHA_ENTREGA;
            else if (fieldName.equals("USUARIO_ENTREGA"))
                value = USUARIO_ENTREGA;
            else if (fieldName.equals("CLINICA_ENTREGA"))
                value = CLINICA_ENTREGA;
            else if (fieldName.equals("NOMBRE_CLINICA_ENTREGA"))
                value = NOMBRE_CLINICA_ENTREGA;
            else if (fieldName.equals("SERVICIO_ENTREGA"))
                value = SERVICIO_ENTREGA;
            else if (fieldName.equals("NOMBRE_SERVICIO_ENTREGA"))
                value = NOMBRE_SERVICIO_ENTREGA;
        } else if (wcodrep == 11) {
            if (fieldName.equals("FECHA_REGISTRO"))
                value = FECHA_REGISTRO;
            else if (fieldName.equals("CLINICA"))
                value = CLINICA;
            else if (fieldName.equals("NOMBRE_CLINICA"))
                value = NOMBRE_CLINICA;
            else if (fieldName.equals("TIPO_IDENTIDAD"))
                value = TIPO_IDENTIDAD;
            else if (fieldName.equals("NUMERO_IDENTIDAD"))
                value = NUMERO_IDENTIDAD;
            else if (fieldName.equals("EDAD"))
                value = EDAD;
            else if (fieldName.equals("SEXO"))
                value = SEXO;
            else if (fieldName.equals("NACIONALIDAD"))
                value = NACIONALIDAD;
            else if (fieldName.equals("CONTRATO"))
                value = CONTRATO;
            else if (fieldName.equals("NOMBRE_CONTRATO"))
                value = NOMBRE_CONTRATO;
            else if (fieldName.equals("NIT"))
                value = NIT;
            else if (fieldName.equals("CODIGO_SERVICIO"))
                value = CODIGO_SERVICIO;
            else if (fieldName.equals("SERVICIO"))
                value = SERVICIO;
            else if (fieldName.equals("PAQUETE"))
                value = PAQUETE;
            else if (fieldName.equals("CANTIDAD"))
                value = CANTIDAD;
        }
        return value;
    }

    /**
     * @param fechaInicial
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    /**
     * @return
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaFinal
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    /**
     * @return
     */
    public Date getFechaFinal() {
        return fechaFinal;
    }

    /**
     * @param generoReporte
     */
    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    /**
     * @return
     */
    public boolean isGeneroReporte() {
        return generoReporte;
    }

    /**
     * @param lstReporte
     */
    public void setLstReporte(List<Object[]> lstReporte) {
        this.lstReporte = lstReporte;
    }

    /**
     * @return
     */
    public List<Object[]> getLstReporte() {
        return lstReporte;
    }

    public void setCodcontrato(Integer codcontrato) {
        this.codcontrato = codcontrato;
    }

    public Integer getCodcontrato() {
        return codcontrato;
    }

    public void setLstContratos(List lstContratos) {
        this.lstContratos = lstContratos;
    }

    public List getLstContratos() {
        return lstContratos;
    }

    public void obtenerDatosReporte(int indexAux) {

        CLINICA = null;
        FECHA_REGISTRO = null;
        TIPO_IDENTIDAD = null;
        NUMERO_IDENTIDAD = null;
        FECHA_NACIMIENTO = null;
        EDAD = null;
        SEXO = null;
        CODIGO_SERVICIO = null;
        SERVICIO = null;
        CODIGO_DISCAPACIDAD = null;
        DISCAPACIDAD = null;
        NOMBRE_CLINICA = null;
        COD_IDENTIDAD = null;
        IDENTIDAD = null;
        PAGADOR = null;
        USUARIO = null;
        COD_DIAG_PRIN = null;
        DIAG_PRINCIPAL = null;
        COD_DIAG_RELA1 = null;
        COD_DIAG_RELA2 = null;
        COD_DIAG_RELA3 = null;
        DIAG_RELA1 = null;
        DIAG_RELA2 = null;
        DIAG_RELA3 = null;
        VIOLENCIA_FISICA = null;
        TIEMPO_FISICA = null;
        VIOLENCIA_PSICOLOGICA = null;
        TIEMPO_PSICOLOGICA = null;
        VIOLENCIA_SEXUAL = null;
        TIEMPO_SEXUAL = null;
        VIOLENCIA_REPRODUCTIVA = null;
        TIEMPO_REPRODUCTIVA = null;
        VIOLENCIA_ECONOMICA = null;
        TIEMPO_ECONOMICA = null;
        REMITIDO = null;
        CUAL_REMISION = null;
        CONTRATO = null;
        CODIGO_HISTORIA = null;
        HISTORIA = null;
        ASEGURADORA = null;
        VULNERABILIDAD = null;
        ESQ_CITOLOGIA = null;
        OTRO_ESQ_CITO = null;
        PROCEDIMIENTO_NINGUNO = null;
        CAUTERIZACION = null;
        FECHA_CAUTERIZACION = null;
        HISTERECTOMIA = null;
        FECHA_HISTERECTOMIA = null;
        CONIZACION = null;
        FECHA_CONIZACION = null;
        RADIOTERAPIA = null;
        FECHA_RADIOTERAPIA = null;
        BIOPSIA = null;
        FECHA_BIOPSIA = null;
        CRIOTERAPIA = null;
        FECHA_CRIOTERAPIA = null;
        ATA = null;
        FECHA_ATA = null;
        OTRO_PROCEDIMIENTO = null;
        FECHA_OTRO_PROCEDIMIENTO = null;
        DESCRIPCION_OTRO = null;
        VAPORIZACION = null;
        FECHA_VAPORIZACION = null;
        HORMONAL = null;
        FECHA_HORMONAL = null;
        TIPIFICACION = null;
        FECHA_TIPIFICACION = null;
        COLPOSCOPIA = null;
        FECHA_COLPOSCOPIA = null;
        ESQUEMA_VPH = null;
        OTRO_ESQ_VPH = null;
        FECHA_LECTURA = null;
        TARJETA_PROFESIONAL = null;
        GENOTIPIFICACION_NEGATIVO = null;
        GENOTIPIFICACION = null;
        GENOTIPO_16 = null;
        GENOTIPO_18 = null;
        GENOTIPO_31 = null;
        GENOTIPO_45 = null;
        GENOTIPO_51 = null;
        GENOTIPO_52 = null;
        GENOTIPO_3858 = null;
        GENOTIPO_353968 = null;
        GENOTIPO_565966 = null;
        CONDUCTA = null;
        INTERPRETACION = null;
        COMPLETO_ESQUEMA_VPH = null;
        NUMERO_DOSIS = null;
        ZONA_RESIDENCIAL = null;
        NOMBRE_CONTRATO = null;
        ENFERMEDAD = null;
        MOTIVO = null;
        CELULAS = null;
        NOMBRE_CELULAS = null;
        COD_ANOR_GLAN = null;
        ANOR_GLAN = null;
        USUARIO_COLPOSCOPIA = null;
        CLINICA_COLPOSCOPIA = null;
        NOMBRE_CLIN_COLPOSCOPIA = null;
        SERVICIO_COLPOSCOPIA = null;
        COD_SERV_COLPOSCOPIA = null;
        FECHA_ENTREGA = null;
        USUARIO_ENTREGA = null;
        CLINICA_ENTREGA = null;
        NOMBRE_CLINICA_ENTREGA = null;
        SERVICIO_ENTREGA = null;
        NOMBRE_SERVICIO_ENTREGA = null;
        NACIONALIDAD = null;
        NIT = null;
        PAQUETE = null;
        CANTIDAD = null;
        FECHA_PATOLOGIA = null;
        USUARIO_PATOLOGIA = null;
        CLINICA_PATOLOGIA = null;
        NOMBRE_CLINICA_PATO = null;
        SERVICIO_PATO = null;
        NOMBRE_SERVICIO_PATO = null;
        TRAE_PATOLOGIA = null;
        TIPO_PATOLOGIA = null;
        RESULTADO_PATOLOGIA = null;
        DESC_RESU_PATO = null;
        USUARIO_CONIZACION = null;
        CLINICA_CONIZACION = null;
        NOMBRE_CLINICA_CONI = null;
        SERVICIO_CONIZACION = null;
        NOMBRE_SERVICIO_CONI = null;

        Object[] aux = lstReporte.get(indexAux);
        if (wcodrep == 0) {
            if (aux != null) {
                if (aux[0] != null) {
                    CLINICA = (BigDecimal)aux[0];
                }
                if (aux[1] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[1]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[2] != null) {
                    TIPO_IDENTIDAD = aux[2].toString();
                }
                if (aux[3] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[3];
                }
                if (aux[4] != null) {
                    FECHA_NACIMIENTO = (Date)aux[4];
                }
                if (aux[5] != null) {
                    EDAD = (BigDecimal)aux[5];
                }
                if (aux[6] != null) {
                    SEXO = aux[6].toString();
                }
                if (aux[7] != null) {
                    CODIGO_SERVICIO = aux[7].toString();
                }
                if (aux[8] != null) {
                    SERVICIO = aux[8].toString();
                }
                if (aux[9] != null) {
                    CODIGO_DISCAPACIDAD = aux[9].toString();
                }
                if (aux[10] != null) {
                    DISCAPACIDAD = aux[10].toString();
                }
            }
        } else if (wcodrep == 1) {
            if (aux != null) {
                if (aux[0] != null) {
                    CLINICA = (BigDecimal)aux[0];
                }
                if (aux[1] != null) {
                    NOMBRE_CLINICA = (String)aux[1];
                }
                if (aux[2] != null) {
                    FECHA_NACIMIENTO = (Date)aux[2];
                }
                if (aux[3] != null) {
                    COD_IDENTIDAD = (String)aux[3];
                }
                if (aux[4] != null) {
                    IDENTIDAD = (String)aux[4];
                }
                if (aux[5] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[5];
                }
                if (aux[6] != null) {
                    CODIGO_SERVICIO = aux[6].toString();
                }
                if (aux[7] != null) {
                    SERVICIO = aux[7].toString();
                }
                if (aux[8] != null) {
                    FECHA_REGISTRO = (Date)aux[8];
                }
                if (aux[9] != null) {
                    EDAD = (BigDecimal)aux[9];
                }
                if (aux[10] != null) {
                    PAGADOR = aux[10].toString();
                }
            }
        } else if (wcodrep == 2) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    CLINICA = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    NOMBRE_CLINICA = (String)aux[2];
                }
                if (aux[3] != null) {
                    USUARIO = (BigDecimal)aux[3];
                }
                if (aux[4] != null) {
                    EDAD = (BigDecimal)aux[4];
                }
                if (aux[5] != null) {
                    SEXO = (String)aux[5];
                }
                if (aux[6] != null) {
                    CODIGO_SERVICIO = aux[6].toString();
                }
                if (aux[7] != null) {
                    SERVICIO = aux[7].toString();
                }
                if (aux[8] != null) {
                    COD_DIAG_PRIN = (String)aux[8];
                }
                if (aux[9] != null) {
                    DIAG_PRINCIPAL = (String)aux[9];
                }
                if (aux[10] != null) {
                    COD_DIAG_RELA1 = aux[10].toString();
                }
                if (aux[11] != null) {
                    DIAG_RELA1 = aux[11].toString();
                }
                if (aux[12] != null) {
                    COD_DIAG_RELA2 = aux[12].toString();
                }
                if (aux[13] != null) {
                    DIAG_RELA2 = aux[13].toString();
                }
                if (aux[14] != null) {
                    COD_DIAG_RELA3 = aux[14].toString();
                }
                if (aux[15] != null) {
                    DIAG_RELA3 = aux[15].toString();
                }
            }
        } else if (wcodrep == 3) {
            if (aux != null) {
                if (aux[0] != null) {
                    FECHA_REGISTRO = (Date)aux[0];
                }
                if (aux[1] != null) {
                    CODIGO_SERVICIO = (String)aux[1];
                }
                if (aux[2] != null) {
                    SERVICIO = (String)aux[2];
                }
                if (aux[3] != null) {
                    USUARIO = (BigDecimal)aux[3];
                }
                if (aux[4] != null) {
                    CLINICA = (BigDecimal)aux[4];
                }
                if (aux[5] != null) {
                    NOMBRE_CLINICA = (String)aux[5];
                }
                if (aux[6] != null) {
                    VIOLENCIA_FISICA = aux[6].toString();
                }
                if (aux[7] != null) {
                    TIEMPO_FISICA = aux[7].toString();
                }
                if (aux[8] != null) {
                    VIOLENCIA_PSICOLOGICA = (String)aux[8];
                }
                if (aux[9] != null) {
                    TIEMPO_PSICOLOGICA = (String)aux[9];
                }
                if (aux[10] != null) {
                    VIOLENCIA_SEXUAL = aux[10].toString();
                }
                if (aux[11] != null) {
                    TIEMPO_SEXUAL = aux[11].toString();
                }
                if (aux[12] != null) {
                    VIOLENCIA_REPRODUCTIVA = aux[12].toString();
                }
                if (aux[13] != null) {
                    TIEMPO_REPRODUCTIVA = aux[13].toString();
                }
                if (aux[14] != null) {
                    VIOLENCIA_ECONOMICA = aux[14].toString();
                }
                if (aux[15] != null) {
                    TIEMPO_ECONOMICA = aux[15].toString();
                }
                if (aux[16] != null) {
                    REMITIDO = aux[16].toString();
                }
                if (aux[17] != null) {
                    CUAL_REMISION = aux[17].toString();
                }
                if (aux[18] != null) {
                    CONTRATO = (BigDecimal)aux[18];
                }
                if (aux[19] != null) {
                    SEXO = aux[19].toString();
                }
                if (aux[20] != null) {
                    FECHA_NACIMIENTO = (Date)aux[20];
                }
                if (aux[21] != null) {
                    EDAD = (BigDecimal)aux[21];
                }
            }
        } else if (wcodrep == 4) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    CLINICA = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    NOMBRE_CLINICA = (String)aux[2];
                }
                if (aux[3] != null) {
                    USUARIO = (BigDecimal)aux[3];
                }
                if (aux[4] != null) {
                    EDAD = (BigDecimal)aux[4];
                }
                if (aux[5] != null) {
                    SEXO = (String)aux[5];
                }
                if (aux[6] != null) {
                    CODIGO_SERVICIO = aux[6].toString();
                }
                if (aux[7] != null) {
                    SERVICIO = aux[7].toString();
                }
                if (aux[8] != null) {
                    COD_DIAG_PRIN = (String)aux[8];
                }
                if (aux[9] != null) {
                    DIAG_PRINCIPAL = (String)aux[9];
                }
                if (aux[10] != null) {
                    COD_DIAG_RELA1 = aux[10].toString();
                }
                if (aux[11] != null) {
                    DIAG_RELA1 = aux[11].toString();
                }
                if (aux[12] != null) {
                    COD_DIAG_RELA2 = aux[12].toString();
                }
                if (aux[13] != null) {
                    DIAG_RELA2 = aux[13].toString();
                }
                if (aux[14] != null) {
                    COD_DIAG_RELA3 = aux[14].toString();
                }
                if (aux[15] != null) {
                    DIAG_RELA3 = aux[15].toString();
                }
            }
        } else if (wcodrep == 5) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    CLINICA = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    NOMBRE_CLINICA = (String)aux[2];
                }
                if (aux[3] != null) {
                    CODIGO_SERVICIO = (String)aux[3];
                }
                if (aux[4] != null) {
                    SERVICIO = (String)aux[4];
                }
                if (aux[5] != null) {
                    TIPO_IDENTIDAD = (String)aux[5];
                }
                if (aux[6] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[6];
                }
                if (aux[7] != null) {
                    EDAD = (BigDecimal)aux[7];
                }
            }
        } else if (wcodrep == 6) {
            if (aux != null) {
                if (aux[0] != null) {
                    TIPO_IDENTIDAD = (String)aux[0];
                }
                if (aux[1] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    CODIGO_HISTORIA = (BigDecimal)aux[2];
                }
                if (aux[3] != null) {
                    HISTORIA = (String)aux[3];
                }
                if (aux[4] != null) {
                    CLINICA = (BigDecimal)aux[4];
                }
                if (aux[5] != null) {
                    NOMBRE_CLINICA = (String)aux[5];
                }
                if (aux[6] != null) {
                    FECHA_REGISTRO = (Date)aux[6];
                }
                if (aux[7] != null) {
                    EDAD = (BigDecimal)aux[7];
                }
                if (aux[8] != null) {
                    ASEGURADORA = (String)aux[8];
                }
                if (aux[9] != null) {
                    IDENTIDAD = (String)aux[9];
                }
                if (aux[10] != null) {
                    VULNERABILIDAD = (String)aux[10];
                }
                if (aux[11] != null) {
                    ESQ_CITOLOGIA = (String)aux[11];
                }
                if (aux[12] != null) {
                    OTRO_ESQ_CITO = (String)aux[12];
                }
                if (aux[13] != null) {
                    PROCEDIMIENTO_NINGUNO = (String)aux[13];
                }
                if (aux[14] != null) {
                    CAUTERIZACION = (String)aux[14];
                }
                if (aux[15] != null) {
                    FECHA_CAUTERIZACION = (Date)aux[15];
                }
                if (aux[16] != null) {
                    HISTERECTOMIA = (String)aux[16];
                }
                if (aux[17] != null) {
                    FECHA_HISTERECTOMIA = (Date)aux[17];
                }
                if (aux[18] != null) {
                    CONIZACION = (String)aux[18];
                }
                if (aux[19] != null) {
                    FECHA_CONIZACION = (Date)aux[19];
                }
                if (aux[20] != null) {
                    RADIOTERAPIA = (String)aux[20];
                }
                if (aux[21] != null) {
                    FECHA_RADIOTERAPIA = (Date)aux[21];
                }
                if (aux[22] != null) {
                    BIOPSIA = (String)aux[22];
                }
                if (aux[23] != null) {
                    FECHA_BIOPSIA = (Date)aux[23];
                }
                if (aux[24] != null) {
                    CRIOTERAPIA = (String)aux[24];
                }
                if (aux[25] != null) {
                    FECHA_CRIOTERAPIA = (Date)aux[25];
                }
                if (aux[26] != null) {
                    ATA = (String)aux[26];
                }
                if (aux[27] != null) {
                    FECHA_ATA = (Date)aux[27];
                }
                if (aux[28] != null) {
                    OTRO_PROCEDIMIENTO = (String)aux[28];
                }
                if (aux[29] != null) {
                    FECHA_OTRO_PROCEDIMIENTO = (Date)aux[29];
                }
                if (aux[30] != null) {
                    DESCRIPCION_OTRO = (String)aux[30];
                }
                if (aux[31] != null) {
                    VAPORIZACION = (String)aux[31];
                }
                if (aux[32] != null) {
                    FECHA_VAPORIZACION = (Date)aux[32];
                }
                if (aux[33] != null) {
                    HORMONAL = (String)aux[33];
                }
                if (aux[34] != null) {
                    FECHA_HORMONAL = (Date)aux[34];
                }
                if (aux[35] != null) {
                    TIPIFICACION = (String)aux[35];
                }
                if (aux[36] != null) {
                    FECHA_TIPIFICACION = (Date)aux[36];
                }
                if (aux[37] != null) {
                    COLPOSCOPIA = (String)aux[37];
                }
                if (aux[38] != null) {
                    FECHA_COLPOSCOPIA = (Date)aux[38];
                }
                if (aux[39] != null) {
                    ESQUEMA_VPH = (String)aux[39];
                }
                if (aux[40] != null) {
                    OTRO_ESQ_VPH = (String)aux[40];
                }
                if (aux[41] != null) {
                    FECHA_LECTURA = (Date)aux[41];
                }
                if (aux[42] != null) {
                    TARJETA_PROFESIONAL = (BigDecimal)aux[42];
                }
                if (aux[43] != null) {
                    GENOTIPIFICACION_NEGATIVO = (String)aux[43];
                }
                if (aux[44] != null) {
                    GENOTIPIFICACION = (String)aux[44];
                }
                if (aux[45] != null) {
                    GENOTIPO_16 = (String)aux[45];
                }
                if (aux[46] != null) {
                    GENOTIPO_18 = (String)aux[46];
                }
                if (aux[47] != null) {
                    GENOTIPO_31 = (String)aux[47];
                }
                if (aux[48] != null) {
                    GENOTIPO_45 = (String)aux[48];
                }
                if (aux[49] != null) {
                    GENOTIPO_51 = (String)aux[49];
                }
                if (aux[50] != null) {
                    GENOTIPO_52 = (String)aux[50];
                }
                if (aux[51] != null) {
                    GENOTIPO_3858 = (String)aux[51];
                }
                if (aux[52] != null) {
                    GENOTIPO_353968 = (String)aux[52];
                }
                if (aux[53] != null) {
                    GENOTIPO_565966 = (String)aux[53];
                }
                if (aux[54] != null) {
                    CONDUCTA = (String)aux[54];
                }
                if (aux[55] != null) {
                    INTERPRETACION = (String)aux[55];
                }
                if (aux[56] != null) {
                    SERVICIO = (String)aux[56];
                }
                if (aux[57] != null) {
                    COMPLETO_ESQUEMA_VPH = (String)aux[57];
                }
                if (aux[58] != null) {
                    NUMERO_DOSIS = (BigDecimal)aux[58];
                }
                if (aux[59] != null) {
                    ZONA_RESIDENCIAL = (String)aux[59];
                }
                if (aux[60] != null) {
                    CONTRATO = (BigDecimal)aux[60];
                }
                if (aux[61] != null) {
                    NOMBRE_CONTRATO = (String)aux[61];
                }
            }
        } else if (wcodrep == 7) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    USUARIO = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    TIPO_IDENTIDAD = (String)aux[2];
                }
                if (aux[3] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[3];
                }
                if (aux[4] != null) {
                    CODIGO_SERVICIO = (String)aux[4];
                }
                if (aux[5] != null) {
                    SERVICIO = (String)aux[5];
                }
                if (aux[6] != null) {
                    CLINICA = (BigDecimal)aux[6];
                }
                if (aux[7] != null) {
                    NOMBRE_CLINICA = (String)aux[7];
                }
                if (aux[7] != null) {
                    ENFERMEDAD = (String)aux[7];
                }
                if (aux[7] != null) {
                    MOTIVO = (String)aux[7];
                }
            }
        } else if (wcodrep == 8) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_COLPOSCOPIA = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    USUARIO = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    CLINICA = (BigDecimal)aux[2];
                }
                if (aux[3] != null) {
                    NOMBRE_CLINICA = (String)aux[3];
                }
                if (aux[4] != null) {
                    CODIGO_SERVICIO = (String)aux[4];
                }
                if (aux[5] != null) {
                    SERVICIO = (String)aux[5];
                }
                if (aux[6] != null) {
                    try {
                        FECHA_PATOLOGIA = new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[6]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[7] != null) {
                    USUARIO_PATOLOGIA = (BigDecimal)aux[7];
                }
                if (aux[8] != null) {
                    CLINICA_PATOLOGIA = (BigDecimal)aux[8];
                }
                if (aux[9] != null) {
                    NOMBRE_CLINICA_PATO = (String)aux[9];
                }
                if (aux[10] != null) {
                    SERVICIO_PATO = (String)aux[10];
                }
                if (aux[11] != null) {
                    NOMBRE_SERVICIO_PATO = (String)aux[11];
                }
                if (aux[12] != null) {
                    TRAE_PATOLOGIA = (String)aux[12];
                }
                if (aux[13] != null) {
                    TIPO_PATOLOGIA = (String)aux[13];
                }
                if (aux[14] != null) {
                    RESULTADO_PATOLOGIA = (String)aux[14];
                }
                if (aux[15] != null) {
                    DESC_RESU_PATO = (String)aux[15];
                }
                if (aux[16] != null) {
                    try {
                        FECHA_CONIZACION = new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[16]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[17] != null) {
                    USUARIO_CONIZACION = (BigDecimal)aux[17];
                }
                if (aux[18] != null) {
                    CLINICA_CONIZACION = (BigDecimal)aux[18];
                }
                if (aux[19] != null) {
                    NOMBRE_CLINICA_CONI = (String)aux[19];
                }
                if (aux[20] != null) {
                    SERVICIO_CONIZACION = (String)aux[20];
                }
                if (aux[21] != null) {
                    NOMBRE_SERVICIO_CONI = (String)aux[21];
                }
            }
        }else if (wcodrep == 9) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    CELULAS = (String)aux[1];
                }
                if (aux[2] != null) {
                    NOMBRE_CELULAS = (String)aux[2];
                }
                if (aux[3] != null) {
                    COD_ANOR_GLAN = (String)aux[3];
                }
                if (aux[4] != null) {
                    ANOR_GLAN = (String)aux[4];
                }
                if (aux[5] != null) {
                    CLINICA = (BigDecimal)aux[5];
                }
                if (aux[6] != null) {
                    NOMBRE_CLINICA = (String)aux[6];
                }
                if (aux[7] != null) {
                    TIPO_IDENTIDAD = (String)aux[7];
                }
                if (aux[8] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[8];
                }
                if (aux[9] != null) {
                    USUARIO = (BigDecimal)aux[9];
                }
                if (aux[10] != null) {
                    EDAD = (BigDecimal)aux[10];
                }
                if (aux[11] != null) {
                    try {
                        FECHA_COLPOSCOPIA = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[11]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[12] != null) {
                    USUARIO_COLPOSCOPIA = (BigDecimal)aux[12];
                }
                if (aux[13] != null) {
                    CLINICA_COLPOSCOPIA = (BigDecimal)aux[13];
                }
                if (aux[14] != null) {
                    NOMBRE_CLIN_COLPOSCOPIA = (String)aux[14];
                }
                if (aux[15] != null) {
                    COD_SERV_COLPOSCOPIA = (String)aux[15];
                }
                if (aux[16] != null) {
                    SERVICIO_COLPOSCOPIA = (String)aux[16];
                }
            }
        } else if (wcodrep == 10) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    CLINICA = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    NOMBRE_CLINICA = (String)aux[2];
                }
                if (aux[3] != null) {
                    USUARIO = (BigDecimal)aux[3];
                }
                if (aux[4] != null) {
                    TIPO_IDENTIDAD = (String)aux[4];
                }
                if (aux[5] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[5];
                }
                if (aux[6] != null) {
                    EDAD = (BigDecimal)aux[6];
                }
                if (aux[7] != null) {
                    CODIGO_SERVICIO = (String)aux[7];
                }
                if (aux[8] != null) {
                    SERVICIO = (String)aux[8];
                }
                if (aux[9] != null) {
                    try {
                        FECHA_ENTREGA = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[9]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[10] != null) {
                    USUARIO_ENTREGA = (BigDecimal)aux[10];
                }
                if (aux[11] != null) {
                    CLINICA_ENTREGA = (BigDecimal)aux[11];
                }
                if (aux[12] != null) {
                    NOMBRE_CLINICA_ENTREGA = (String)aux[12];
                }
                if (aux[13] != null) {
                    SERVICIO_ENTREGA = (String)aux[13];
                }
                if (aux[14] != null) {
                    NOMBRE_SERVICIO_ENTREGA = (String)aux[14];
                }
            }
        } else if (wcodrep == 11) {
            if (aux != null) {
                if (aux[0] != null) {
                    try {
                        FECHA_REGISTRO = 
                                new SimpleDateFormat("dd/MM/yyyy").parse((String)aux[0]);
                    } catch (ParseException e) {
                        // TODO
                    }
                }
                if (aux[1] != null) {
                    CLINICA = (BigDecimal)aux[1];
                }
                if (aux[2] != null) {
                    NOMBRE_CLINICA = (String)aux[2];
                }
                if (aux[3] != null) {
                    TIPO_IDENTIDAD = (String)aux[3];
                }
                if (aux[4] != null) {
                    NUMERO_IDENTIDAD = (BigDecimal)aux[4];
                }
                if (aux[5] != null) {
                    EDAD = (BigDecimal)aux[5];
                }
                if (aux[6] != null) {
                    SEXO = (String)aux[6];
                }
                if (aux[7] != null) {
                    NACIONALIDAD = (String)aux[7];
                }
                if (aux[8] != null) {
                    CONTRATO = (BigDecimal)aux[8];
                }
                if (aux[9] != null) {
                    NOMBRE_CONTRATO = (String)aux[9];
                }
                if (aux[10] != null) {
                    NIT = (BigDecimal)aux[10];
                }
                if (aux[11] != null) {
                    CODIGO_SERVICIO = (String)aux[11];
                }
                if (aux[12] != null) {
                    SERVICIO = (String)aux[12];
                }
                if (aux[13] != null) {
                    PAQUETE = (String)aux[13];
                }
                if (aux[14] != null) {
                    CANTIDAD = (BigDecimal)aux[14];
                }
            }
        }
    }


    /**
     * @param lstClinicas
     */
    public void setLstReportes(List lstClinicas) {
        this.lstReportes = lstClinicas;
    }

    /**
     * @return
     */
    public List getLstReportes() {
        if (lstReportes == null || lstReportes.isEmpty()) {
            lstReportes = new ArrayList();
            ArrayList<Chreportes> lstReportesAux = null;
            try {
                lstReportesAux = 
                        (ArrayList<Chreportes>)this.serviceLocator.getReporteService().getReportes();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstReportesAux.isEmpty()) {
                Iterator it = lstReportesAux.iterator();
                int i = 0;
                lstReportes.add(new SelectItem(0, "Todos los reportes"));
                while (it.hasNext()) {
                    it.next();
                    lstReportes.add(new SelectItem(lstReportesAux.get(i).getHrencodigo(), 
                                                   lstReportesAux.get(i).getHrecdescripcion()));
                    i++;
                }
            }
        }

        return lstReportes;
    }

    /**
     * @param valueChangeEvent
     */
    public void setWcodclin(ValueChangeEvent valueChangeEvent) {
        setWcodrep((Integer)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setWcodrep(Integer wcodrep) {
        this.wcodrep = wcodrep;
    }

    public Integer getWcodrep() {
        return wcodrep;
    }


    /**
     * @param param
     */
    public void setLstTipoUsuarios(List<SelectItem> param) {
        this.lstTipoUsuarios = param;
    }

    public void generarReporte() {
        index = -1;
        generoReporte = false;
        SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd_hhmmss");
        generoReporte = false;

        lstReporte = null;
        if (wcodrep == 0) {
            nombSalida = "Discapacidad";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteDiscapacidad(fechaInicial, 
                                                                                       fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 1) {
            nombSalida = "Identidad";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteIdentidadGenero(fechaInicial, 
                                                                                          fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 2) {
            nombSalida = "Its";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteITS(fechaInicial, 
                                                                              fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 3) {
            nombSalida = "Vbg";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteVBG(fechaInicial, 
                                                                              fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 4) {
            nombSalida = "VbgDx";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteVBGDiagnosticos(fechaInicial, 
                                                                                          fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 5) {
            nombSalida = "Prep";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReportePrep(fechaInicial, 
                                                                               fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 6) {
            nombSalida = "VphHc";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteVPHHC(fechaInicial, 
                                                                                fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 7) {
            nombSalida = "ConflictoArmado";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteConflictoArmado(fechaInicial, 
                                                                                          fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 8) {
            nombSalida = "ColposcopiaVarios";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteColposcopia(fechaInicial,  
                                                                                      fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 9) {
            nombSalida = "Citologia";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteCitologia(fechaInicial, 
                                                                                    fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 10) {
            nombSalida = "EntregaVPH";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteEntregaVPH(fechaInicial, 
                                                                                     fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        } else if (wcodrep == 11) {
            nombSalida = "Extranjeros";
            try {
                lstReporte = 
                        this.serviceLocator.getReporteService().getReporteExtranjeros(fechaInicial, 
                                                                                      fechaFinal);
            } catch (ModelException e) {
                e.printStackTrace();
            }
        }

        if (lstReporte != null && !lstReporte.isEmpty()) {

            try {
                java.net.URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporte" + 
                                                                                  nombSalida + 
                                                                                  ".jasper");

                if (url != null) {
                    Map parameters = new HashMap();
                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);
                    JasperPrint jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, 
                                                     (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRXlsExporter exporter = new JRXlsExporter();
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, 
                                          jasperPrint);
                    exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, 
                                          baos);
                    exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, 
                                          Boolean.FALSE);
                    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, 
                                          Boolean.TRUE);
                    exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, 
                                          Boolean.FALSE);

                    exporter.exportReport();
                    XlsServletUtils.showXlsDocument(baos.toByteArray(), 
                                                    nombSalida + 
                                                    Calendar.getInstance().getTimeInMillis() + 
                                                    ".xls", false);
                    generoReporte = true;

                    FacesUtils.addInfoMessage("Reporte generado exitosamente");
                }
            } catch (Exception e) {
                FacesUtils.addErrorMessage("No se genero el reporte " + 
                                           e.getMessage());
                e.printStackTrace();
            }
        } else {
            FacesUtils.addErrorMessage(MSG_NO_RESULTADOS);
        }
    }

    public void setMnuCodclin(UIInput mnuCodclin) {
        this.mnuCodclin = mnuCodclin;
    }

    public UIInput getMnuCodclin() {
        return mnuCodclin;
    }


}
