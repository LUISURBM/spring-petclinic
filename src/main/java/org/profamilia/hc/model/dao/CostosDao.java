package org.profamilia.hc.model.dao;


import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Cpempresa;

import org.profamilia.hc.model.dto.Ctwsdetsolent;
import org.profamilia.hc.model.dto.Ctacumcosto;
import org.profamilia.hc.model.dto.FichaTecnicaCostosDTO;
import org.profamilia.hc.model.exceptions.ModelException;


public interface CostosDao {

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
