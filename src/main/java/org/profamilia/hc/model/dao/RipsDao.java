package org.profamilia.hc.model.dao;

import java.util.List;

import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cisaludtool;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crarcconsu;
import org.profamilia.hc.model.dto.RipsSaludtoolsDTO;
import org.profamilia.hc.model.exceptions.ModelException;


public interface RipsDao {
    public void savelstRipsSaludTools(final List<Cisaludtool> lstRips) throws ModelException ;
    public Integer getCodigoConsultaExterna(String descripcion)throws ModelException;
    public void updateLstRipsByTipNum()throws ModelException;
    public void updateLstRipsBySexo()throws ModelException;
    public void updateLstRipsNum()throws ModelException;
    public void updateLstRipsCausaE()throws ModelException;
    public void updateLstRipsServi()throws ModelException;
    public void updateLstRipsCIE10()throws ModelException;
    public void updateLstRipsSCIE10()throws ModelException;
    public void updateLstRipsByAdm()throws ModelException;
    public RipsSaludtoolsDTO updateLstRipsByAdminDatos(Cisaludtool rips,int valor,String fecha)throws ModelException;
    public List<Cisaludtool>getLstRips()throws ModelException;
    public Cnconsclin getConsultaClinica(Cisaludtool rip,int valor)throws ModelException;
    public Cfadmision getUsuarioAdmision(Cisaludtool rip)throws ModelException;
    public Cpservicio getCodigoCups(Cisaludtool rip)throws ModelException;
    public boolean validarRipsDuplicados(Cisaludtool rip)throws ModelException;
    public void savelstRipsCrarcconsu(final List<Crarcconsu> lstRips) throws ModelException ;
    public void deleteSaludtools()throws ModelException;
}
