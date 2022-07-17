// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:36:16 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoServiceImp.java

package org.profamilia.hc.model.service.imp;

import java.math.BigDecimal;
import java.util.*;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.DAOException;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.dao.ClinicoDao;
import org.profamilia.hc.model.dao.ReporteDao;
import org.profamilia.hc.model.dao.RipsDao;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.model.service.ReporteService;
import org.profamilia.hc.model.service.RipsService;

public class ReporteServiceImp implements ReporteService{
    private ReporteDao reporteDAO;
       
        public ReporteServiceImp(){
            
        }


    public List<ReporteCervixDTO> reporteSaludTotal(Long numeroClinica, 
                                                    Date fechaInicial, 
                                                    Date fechaFinal, 
                                                    Long numeroContrato) throws ModelException {
        return reporteDAO.reporteSaludTotal(numeroClinica,fechaInicial,fechaFinal,numeroContrato);
    }

    public List<Object[]> getReporteEnvioEmail(Date fechaInicial, Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteEnvioEmail(fechaInicial, fechaFinal);
    }
    
    public void setReporteDAO(ReporteDao reporteDAO) {
        this.reporteDAO = reporteDAO;
    }

    public ReporteDao getReporteDAO() {
        return reporteDAO;
    }

    public List<Object[]> getReporteDiscapacidad(Date fechaInicial, 
                                                 Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteDiscapacidad(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteIdentidadGenero(Date fechaInicial, 
                                                    Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteIdentidadGenero(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteITS(Date fechaInicial, Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteITS(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteVBG(Date fechaInicial, Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteVBG(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteVBGDiagnosticos(Date fechaInicial, 
                                                    Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteVBGDiagnosticos(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReportePrep(Date fechaInicial, Date fechaFinal) throws ModelException {
        return reporteDAO.getReportePrep(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteVPHHC(Date fechaInicial, Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteVPHHC(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteConflictoArmado(Date fechaInicial, 
                                                    Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteConflictoArmado(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteColposcopia(Date fechaInicial, 
                                                Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteColposcopia(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteCitologia(Date fechaInicial, 
                                              Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteCitologia(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteEntregaVPH(Date fechaInicial, 
                                               Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteEntregaVPH(fechaInicial, fechaFinal);
    }

    public List<Object[]> getReporteExtranjeros(Date fechaInicial, 
                                                Date fechaFinal) throws ModelException {
        return reporteDAO.getReporteExtranjeros(fechaInicial, fechaFinal);
    }
    
    public List getReportes() throws ModelException{
        List reportes = new ArrayList();
        Chreportes chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(0));
        chreportes.setHrecdescripcion("Discapacidad");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(1));
        chreportes.setHrecdescripcion("Identidad");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(2));
        chreportes.setHrecdescripcion("ITS");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(3));
        chreportes.setHrecdescripcion("VBG");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(4));
        chreportes.setHrecdescripcion("VBG DX");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(5));
        chreportes.setHrecdescripcion("PREP");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(6));
        chreportes.setHrecdescripcion("VPH HC");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(7));
        chreportes.setHrecdescripcion("Conflicto armado");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(8));
        chreportes.setHrecdescripcion("Colposcopia");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(9));
        chreportes.setHrecdescripcion("Citologia");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(10));
        chreportes.setHrecdescripcion("Entrega VPH");
        reportes.add(chreportes);
        chreportes = new Chreportes();
        chreportes.setHrencodigo(Integer.valueOf(11));
        chreportes.setHrecdescripcion("Extranjeros");
        reportes.add(chreportes);
        return reportes; 
    }
}
