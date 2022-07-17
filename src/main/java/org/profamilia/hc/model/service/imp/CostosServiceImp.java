// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:36:16 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoServiceImp.java

package org.profamilia.hc.model.service.imp;

import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Cpempresa;

import org.profamilia.hc.model.dto.Ctwsdetsolent;

import org.profamilia.hc.model.dto.Ctacumcosto;

import org.profamilia.hc.model.dto.FichaTecnicaCostosDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.dao.CostosDao;
import org.profamilia.hc.model.service.CostosService;


public class CostosServiceImp implements CostosService {
    private CostosDao costosDAO;

    public void setCostosDAO(CostosDao costosDAO) {
        this.costosDAO = costosDAO;
    }

    public CostosDao getCostosDAO() {
        return costosDAO;
    }
    public Cpempresa getCpempresa() throws ModelException {
        return costosDAO.getCpempresa();
    }
    
   public List<FichaTecnicaCostosDTO> getServiciosByInsumo(String codigoServicio) throws ModelException {
        return costosDAO.getServiciosByInsumo(codigoServicio);
    }


    public List<String> geLstLotesByCodigo(String codigo) throws ModelException {
        return costosDAO.geLstLotesByCodigo(codigo);
    }
    
    public List<Ctwsdetsolent> geLstLotesByCodigoDto(String codigo) throws ModelException {
        return costosDAO.geLstLotesByCodigoDto(codigo);
    }
    
    public Date getFechaByLote(String codigo) throws ModelException{
        return costosDAO.getFechaByLote(codigo);
    }
    

    public Date getFechaByLote(String codigo, String codsap) throws ModelException{
        return costosDAO.getFechaByLote(codigo, codsap);
    }
    
    public void savelstCtacumcosto(List<Ctacumcosto> lstAcumuladores) throws ModelException{
        costosDAO.savelstCtacumcosto(lstAcumuladores);
    }
    
    public List<Chcontmedane> getMedicamentosAnestesiaInsumo(Long numeroCirugia, 
                                                       String tipoServicio) throws ModelException{
     return costosDAO.getMedicamentosAnestesiaInsumo(numeroCirugia,tipoServicio); 
     
    }
    public List<Chvademprof> getIniciaVademecumAnestesia() throws ModelException{
        return costosDAO.getIniciaVademecumAnestesia();
    }
}
