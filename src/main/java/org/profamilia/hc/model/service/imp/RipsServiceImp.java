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
import org.profamilia.hc.model.dao.RipsDao;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.model.service.ReporteService;
import org.profamilia.hc.model.service.RipsService;

public class RipsServiceImp implements RipsService{
       private RipsDao ripsDAO;
       
        public RipsServiceImp(){
            
        }
        

       public Integer getCodigoConsultaExterna(String descripcion)throws ModelException{
           return ripsDAO.getCodigoConsultaExterna(descripcion);
       }

    public void setRipsDAO(RipsDao ripsDAO) {
        this.ripsDAO = ripsDAO;
    }

    public RipsDao getRipsDAO() {
        return ripsDAO;
    }

    public void savelstRipsSaludTools(List<Cisaludtool> lstRips) throws ModelException {
        ripsDAO.savelstRipsSaludTools(lstRips);
    }

    public void updateLstRipsByTipNum() throws ModelException {
    ripsDAO.updateLstRipsByTipNum();
    }

    public void updateLstRipsNum() throws ModelException {
        ripsDAO.updateLstRipsNum();
    }

    public void updateLstRipsByAdm() throws ModelException {
        ripsDAO.updateLstRipsByAdm();
    }

    public RipsSaludtoolsDTO updateLstRipsByAdminDatos(Cisaludtool rips,int valor,String fecha) throws ModelException {
        return ripsDAO.updateLstRipsByAdminDatos(rips,valor,fecha);
    }

    public List<Cisaludtool> getLstRips() throws ModelException {
        return ripsDAO.getLstRips();
    }

    public Cnconsclin getConsultaClinica(Cisaludtool rip,int valor) throws ModelException {
        return ripsDAO.getConsultaClinica(rip,valor);
    }

    public void updateLstRipsCausaE() throws ModelException {
        ripsDAO.updateLstRipsCausaE();
    }

    public void updateLstRipsServi() throws ModelException {
        ripsDAO.updateLstRipsServi();
    }

    public void updateLstRipsCIE10() throws ModelException {
        ripsDAO.updateLstRipsCIE10();
    }

    public void updateLstRipsSCIE10() throws ModelException {
        ripsDAO.updateLstRipsSCIE10();
    }

    public Cfadmision getUsuarioAdmision(Cisaludtool rip) throws ModelException {
        return ripsDAO.getUsuarioAdmision(rip);
    }

    public Cpservicio getCodigoCups(Cisaludtool rip) throws ModelException {
        return ripsDAO.getCodigoCups(rip);
    }

    public boolean validarRipsDuplicados(Cisaludtool rip) throws ModelException {
        return ripsDAO.validarRipsDuplicados(rip);
    }

    public void savelstRipsCrarcconsu(List<Crarcconsu> lstRips) throws ModelException {
        ripsDAO.savelstRipsCrarcconsu(lstRips);
    }

    public void deleteSaludtools() throws ModelException {
        ripsDAO.deleteSaludtools();
    }

    public void updateLstRipsBySexo() throws ModelException {
      ripsDAO.updateLstRipsBySexo();
    }
}
