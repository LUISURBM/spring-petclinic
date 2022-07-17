package org.profamilia.hc.view.backing.cirugia.registro;

import java.io.ByteArrayOutputStream;


import java.math.BigDecimal;

import java.net.URL;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.backing.comun.buscador.BuscadorUsuariosBean;
import org.profamilia.hc.view.util.CsvServletUtils;
import org.profamilia.hc.view.util.FacesUtils;

public class ReporteLogImpresionBean extends BaseBean implements JRDataSource {


    private List<Object[]> listaRegistros;

    private Date fechaInicial;

    private Date fechaFinal;

    private Integer clinicaSelect;

    private List listaClinicas;

    private int index = -1;

    private boolean existeInformacion;

    private boolean generoReporte;

    private boolean disableClinicas;
    
    private int selectedIndex;

    private boolean renderBuscador;
    
    private  int ACTIVAR_BUSCADOR = 1;
    
    private  int ACTIVAR_BEAN = 0;
    
    private Chusuario usuario;
    
    private Long numeroUsuario;
    
    BuscadorUsuariosBean buscador;
    
    private String nombreUsuario;
    
    private UIInput itNumeroUsuario;


    public ReporteLogImpresionBean() {
    }


    public void init() {
        listaRegistros = new ArrayList();
        listaClinicas = new ArrayList();
        generoReporte = false;
        existeInformacion = false;
        clinicaSelect = getUsuarioSystem().getCurnclinic();
        numeroUsuario = null;

    }

    public void consultarRegistros() {
        try {
            generoReporte = false;
            if (clinicaSelect != 0) {
                listaRegistros = 
                        this.serviceLocator.getClinicoService().getRegistrosLogImpresion(Long.parseLong(clinicaSelect.toString()),
                                                                                          numeroUsuario,
                                                                                          fechaInicial, 
                                                                                          fechaFinal);
            } else {
                listaRegistros = 
                        this.serviceLocator.getClinicoService().getRegistrosLogImpresion(0L,numeroUsuario, 
                                                                                          fechaInicial, 
                                                                                          fechaFinal);
            }

            if (listaRegistros != null && !listaRegistros.isEmpty()) {
                existeInformacion = true;
            } else {
                FacesUtils.addErrorMessage("No existen datos");
                existeInformacion = false;
            }
        } catch (ModelException de) {
            FacesUtils.addErrorMessage(null, de.getMessage());
            existeInformacion = false;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(null, e.getMessage(), MSG_NO_CONSULTA);
            existeInformacion = false;
        }

    }

    public Object getFieldValue(JRField jrField) {

        Object value = null;
        String fieldName = jrField.getName();
        Object[] b = new Object[listaRegistros.size()];
        b = listaRegistros.get(index);

        if (fieldName.equals("FECHA")) {
            value = b[0].toString();
            return value;
        }else if (fieldName.equals("CLINICA")) {
            value = b[1].toString();
            return value;
        }else if (fieldName.equals("TIPO_DOCUMENTO")) {
            value = b[2].toString();
            return value;
        }else if (fieldName.equals("NUMERO_DOCUMENTO")) {
            value = b[3].toString();
            return value;
        } else if (fieldName.equals("NOMBRE_PACIENTE")) {
            value = 
                    b[4].toString() + " " + ((b[5] == null) ? "" : b[5].toString()) + 
                    " " + b[6].toString() + " " + 
                    ((b[7] == null) ? "" : b[7].toString());
            return value;
        } else if (fieldName.equals("CODIGO_SERVICIO")) {
            value = (String)b[8];
            return value;
        } else if (fieldName.equals("NOMBRE_SERVICIO")) {
            value = (String)b[9];
            return value;
        } else if (fieldName.equals("MOTIVO_IMPRESION")) {
            value = motivoNombre((String)b[10]);
            return value;
        } else if (fieldName.equals("CUAL_MOTIVO")) {
            if(b[11] != null && !"".equals(b[11].toString())){
                value = b[11].toString();
            }else if(b[12] != null && !"".equals(b[12].toString())){
                value =  b[12].toString();
            }
            return value;
        } else if (fieldName.equals("CODIGO_USUARIO_IMPRESION")) {
            value = (String)b[13];
            return value;
        } else if (fieldName.equals("NOMBRE_USUARIO_IMPRESION")) {
            value = (String)b[14];
            return value;
        } 
        return value;
    }


    public void generarArchivoCsv() {
        index = -1;
        if (listaRegistros == null || listaRegistros.isEmpty()) {
            FacesUtils.addInfoMessage(MSG_NO_RESULTADO_CONSULTA);
        } else {
            try {
                String nombreArchivo = "RegistrosLogImpresion";
                URL url = 
                    FacesUtils.getFacesContext().getExternalContext().getResource("/reports/reporteLogImpresion.jasper");

                if (url != null) {
                    Map parameters = new HashMap();
                    JasperReport report = 
                        (JasperReport)JRLoader.loadObject(url);

                    JasperPrint jasperPrint = 
                        JasperFillManager.fillReport(report, parameters, 
                                                     (JRDataSource)this);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    JRCsvExporter exporter = new JRCsvExporter();
                    exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, 
                                          jasperPrint);
                    exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, 
                                          baos);
                    exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, 
                                          ",");
                    exporter.exportReport();
                    CsvServletUtils.showCsvDocument(baos.toByteArray(), 
                                                    nombreArchivo + ".csv", 
                                                    false);

                    generoReporte = true;

                }
            } catch (Exception e) {
                generoReporte = false;
                e.printStackTrace();
                FacesUtils.addErrorMessage("No se genero el archivo " + 
                                           e.getMessage());
            }
        }
    }

    /**
     * @return
     */
    public boolean next() {
        index++;
        return (index < listaRegistros.size());
    }
    
    public void mostrarBuscadorUsuarios() {
        FacesUtils.resetManagedBean("buscadorUsuariosBean");
        FacesUtils.resetManagedBean("mostrarBuscadorUsuarios");
        selectedIndex = ACTIVAR_BUSCADOR;
        renderBuscador = true;
        generoReporte = false;
    }
    
    /**
     * @return
     */
    public void aceptarUsuario() {
        selectedIndex = ACTIVAR_BEAN;
        usuario = new Chusuario();
        nombreUsuario = "";
        generoReporte = false;

        buscador = 
                (BuscadorUsuariosBean)FacesUtils.getManagedBean("buscadorUsuariosBean");
        usuario = buscador.getUsuarioSelect();
        if (usuario != null) {
            numeroUsuario = usuario.getHuslnumero();
            if (usuario.getHuscprimernomb() != null) {
                nombreUsuario = usuario.getHuscprimernomb() + " ";
            }
            if (usuario.getHuscsegundnomb() != null && 
                !usuario.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscsegundnomb() + " ";
            }
            if (usuario.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuario.getHuscprimerapel() + " ";
            }
            if (usuario.getHuscsegundapel() != null && 
                !usuario.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuario.getHuscsegundapel();
            }
            itNumeroUsuario.setValue(usuario.getHuslnumero());
        }
        renderBuscador = false;
    }

    public String motivoNombre(String motivo) {
        String nombreMotivo = "";
        if ("SFA".equals(motivo)) {
            nombreMotivo = "Para soporte de la factura al asegurador";
        } else if ("SP".equals(motivo)) {
            nombreMotivo = "Por solicitud del paciente";
        } else if ("TOE".equals(motivo)) {
            nombreMotivo = "Para trascripci�n de �rdenes en EPS";
        } else if ("EHI".equals(motivo)) {
            nombreMotivo = "Para enviar la historia a otra IPS";
        } else if ("SE".equals(motivo)) {
            nombreMotivo = "Por solicitud de la EPS";
        } else if ("RAA".equals(motivo)) {
            nombreMotivo = "Revisi�n administrativa o auditor�a";
        } else if ("OR".equals(motivo)) {
            nombreMotivo = "Otra raz�n";
        }
        return nombreMotivo;
    }
    
    public void changeUsuario() {
        Chusuario usuarioAux = null;
        generoReporte = false;
        
        nombreUsuario = "";
        usuario = new Chusuario();
        if (numeroUsuario != null)
            try {
                usuarioAux = 
                        this.serviceLocator.getClinicoService().getUsuario(numeroUsuario);
            } catch (ModelException e) {
                e.printStackTrace();
            }

        if (usuarioAux != null) {
            if (usuarioAux.getHuscprimernomb() != null) {
                nombreUsuario = usuarioAux.getHuscprimernomb() + " ";
            }
            if (usuarioAux.getHuscsegundnomb() != null && 
                !usuarioAux.getHuscsegundnomb().equals("_")) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscsegundnomb() + " ";
            }
            if (usuarioAux.getHuscprimerapel() != null) {
                nombreUsuario = 
                        nombreUsuario + usuarioAux.getHuscprimerapel() + " ";
            }
            if (usuarioAux.getHuscsegundapel() != null && 
                !usuarioAux.getHuscsegundapel().equals("_")) {
                nombreUsuario = nombreUsuario + usuarioAux.getHuscsegundapel();
            }
            usuario = usuarioAux;
        }
    }
    
    /**
     * @param valueChangeEvent
     */
    public void setNumeroUsuario(ValueChangeEvent valueChangeEvent) {
        setNumeroUsuario((Long)valueChangeEvent.getNewValue());
        ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
    }

    public void setListaRegistros(List<Object[]> listaRegistros) {
        this.listaRegistros = listaRegistros;
    }

    public List<Object[]> getListaRegistros() {
        return listaRegistros;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setListaClinicas(List listaClinicas) {
        this.listaClinicas = listaClinicas;
    }

    public List getListaClinicas() {
        if (listaClinicas == null || listaClinicas.isEmpty()) {
            listaClinicas = new ArrayList();
            ArrayList<Cpclinica> lstClinicaAux = null;
            try {
                lstClinicaAux = 
                        (ArrayList<Cpclinica>)this.serviceLocator.getClinicoService().getClinicas();
            } catch (ModelException e) {
                e.printStackTrace();
            }

            if (!lstClinicaAux.isEmpty()) {
                listaClinicas.add(new SelectItem(0,"TODOS"));
                Iterator it = lstClinicaAux.iterator();
                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    listaClinicas.add(new SelectItem(lstClinicaAux.get(i).getCclncodigo(), 
                                                     lstClinicaAux.get(i).getCclcnombre()));
                    i++;
                }
            }
        }

        return listaClinicas;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setGeneroReporte(boolean generoReporte) {
        this.generoReporte = generoReporte;
    }

    public boolean isGeneroReporte() {
        return generoReporte;
    }


    public void setClinicaSelect(Integer clinicaSelect) {
        this.clinicaSelect = clinicaSelect;
    }

    public Integer getClinicaSelect() {
        return clinicaSelect;
    }

    public void setExisteInformacion(boolean existeInformacion) {
        this.existeInformacion = existeInformacion;
    }

    public boolean isExisteInformacion() {
        return existeInformacion;
    }

    public void setDisableClinicas(boolean disableClinicas) {
        this.disableClinicas = disableClinicas;
    }

    public boolean isDisableClinicas() {
        return disableClinicas;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setRenderBuscador(boolean renderBuscador) {
        this.renderBuscador = renderBuscador;
    }

    public boolean isRenderBuscador() {
        return renderBuscador;
    }

    public void setUsuario(Chusuario usuario) {
        this.usuario = usuario;
    }

    public Chusuario getUsuario() {
        return usuario;
    }

    public void setNumeroUsuario(Long numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public Long getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setItNumeroUsuario(UIInput itNumeroUsuario) {
        this.itNumeroUsuario = itNumeroUsuario;
    }

    public UIInput getItNumeroUsuario() {
        return itNumeroUsuario;
    }
}
