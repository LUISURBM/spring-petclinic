// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:34:44 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoService.java

package org.profamilia.hc.model.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.DAOException;
import org.profamilia.hc.model.exceptions.ModelException;

public interface RipsService
{
    public Integer getCodigoConsultaExterna(String descripcion)throws ModelException;
    public void savelstRipsSaludTools(final List<Cisaludtool> lstRips) throws ModelException;
    public void updateLstRipsByTipNum()throws ModelException;
    public void updateLstRipsNum()throws ModelException;
    public void updateLstRipsCausaE()throws ModelException;
    public void updateLstRipsServi()throws ModelException;
    public void updateLstRipsCIE10()throws ModelException;
    public void updateLstRipsSCIE10()throws ModelException;
    public void updateLstRipsByAdm()throws ModelException;
    public RipsSaludtoolsDTO updateLstRipsByAdminDatos(Cisaludtool rip,int valor,String fecha)throws ModelException;
    public List<Cisaludtool>getLstRips()throws ModelException;
    public Cnconsclin getConsultaClinica(Cisaludtool rip,int valor)throws ModelException;
    public Cfadmision getUsuarioAdmision(Cisaludtool rip)throws ModelException;
    public Cpservicio getCodigoCups(Cisaludtool rip)throws ModelException;
    public boolean validarRipsDuplicados(Cisaludtool rip)throws ModelException;
    public void savelstRipsCrarcconsu(final List<Crarcconsu> lstRips) throws ModelException ;
    public void deleteSaludtools() throws ModelException ;
    public void updateLstRipsBySexo()throws ModelException;

}

