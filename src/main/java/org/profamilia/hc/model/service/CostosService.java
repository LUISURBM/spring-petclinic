// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:34:44 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoService.java

package org.profamilia.hc.model.service;

import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Cpempresa;

import org.profamilia.hc.model.dto.Ctwsdetsolent;

import org.profamilia.hc.model.dto.Ctacumcosto;

import org.profamilia.hc.model.dto.FichaTecnicaCostosDTO;
import org.profamilia.hc.model.exceptions.ModelException;


public interface CostosService
{
   
    public Cpempresa getCpempresa() throws ModelException;
    public List<FichaTecnicaCostosDTO> getServiciosByInsumo(String codigoServicio) throws ModelException;
    public List<String> geLstLotesByCodigo(String codigo) throws ModelException ;
    public List<Ctwsdetsolent> geLstLotesByCodigoDto(String codigo) throws ModelException ;
    public Date getFechaByLote(String codigo) throws ModelException;

    public Date getFechaByLote(String codigo, String codsap) throws ModelException;

    public void savelstCtacumcosto(List<Ctacumcosto> lstAcumuladores) throws ModelException;

    public List<Chcontmedane> getMedicamentosAnestesiaInsumo(Long numeroCirugia, 
                                                       String tipoServicio) throws ModelException;
    public List<Chvademprof> getIniciaVademecumAnestesia() throws ModelException;  



}

