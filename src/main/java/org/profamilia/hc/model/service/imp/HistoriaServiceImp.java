// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:36:16 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoServiceImp.java

package org.profamilia.hc.model.service.imp;

import java.util.List;

import org.profamilia.hc.model.dto.Chantalerg;
import org.profamilia.hc.model.dto.Chantfami;
import org.profamilia.hc.model.dto.Chantfarma;
import org.profamilia.hc.model.dto.Chantit;
import org.profamilia.hc.model.dto.Chantox;
import org.profamilia.hc.model.dto.Chantpatol;
import org.profamilia.hc.model.dto.Chantquir;
import org.profamilia.hc.model.dto.Chanttrans;
import org.profamilia.hc.model.dto.Chanttrauma;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chdatosadvacuna;
import org.profamilia.hc.model.dto.Chplanconsinfo;
import org.profamilia.hc.model.dto.Chusuario;

import org.profamilia.hc.model.dto.Crcup;

import org.profamilia.hc.model.dto.Cnregferti;

import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.dao.HistoriaDao;
import org.profamilia.hc.model.service.HistoriaService;


public class HistoriaServiceImp implements HistoriaService{
       private HistoriaDao historiaDAO;

  
    public void save(Chdatosadvacuna datosAdicionales) throws ModelException {
        historiaDAO.save(datosAdicionales);
    }

    public Chdatosadvacuna readDatosADVacunaByConsulta(Integer consulta) throws ModelException {
        return historiaDAO.readDatosADVacunaByConsulta(consulta);
    }

    public void setHistoriaDAO(HistoriaDao historiaDAO) {
        this.historiaDAO = historiaDAO;
    }

    public HistoriaDao getHistoriaDAO() {
        return historiaDAO;
    }

    public Chdatosadvacuna readDatosADVacunaByUsuario(Chusuario usuario) throws ModelException {
        return historiaDAO.readDatosADVacunaByUsuario(usuario);
    }
    public Chconsulta getConsultaAntecedentes(final Long numeroConsulta) throws ModelException{
        return historiaDAO.getConsultaAntecedentes(numeroConsulta);
    }
    public void saveAntecedentesGenerales(Chantox toxicos,Chantalerg alergicos,Chantfarma farmacologicos
    ,Chantit its,Chanttrans transfusionales, Chantfami familiares,Chantpatol patologicos,Chantquir quirurgicos,Chanttrauma traumacologicos) throws ModelException {
        historiaDAO.saveAntecedentesGenerales(toxicos,alergicos,farmacologicos,its,transfusionales,familiares,patologicos,quirurgicos,traumacologicos);
    }
    public List <Chconsulta> getConsultasHistoricoAntecedentes(final Long numeroUsuario,final boolean conEtapa) throws ModelException{
        return historiaDAO.getConsultasHistoricoAntecedentes(numeroUsuario,conEtapa);
    }
    public Chplanconsinfo getConsentimientoInformadoActivo(String codigo) throws ModelException{
        return historiaDAO.getConsentimientoInformadoActivo(codigo);
    }

    public List<Crcup>getCupsXCriterios(Crcup crcups,String capitulo) throws ModelException{
        return historiaDAO.getCupsXCriterios(crcups,capitulo);
    }
    public List<String>getCapitulosCups() throws ModelException{
        return historiaDAO.getCapitulosCups();
    }

    public Crcup getCupByCodigo(String codigo) throws ModelException{
        return historiaDAO.getCupByCodigo(codigo);
    }
    
    public Cnregferti getRegistroFertilidad(Integer clinica, String tipoid, Long numeroid) throws ModelException {
        return historiaDAO.getRegistroFertilidad(clinica, tipoid, numeroid);
    }


}
