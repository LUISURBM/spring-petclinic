package org.profamilia.hc.model.dao;

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


public interface HistoriaDao {

    public void save(Chdatosadvacuna datosAdicionales) throws ModelException;
    public Chdatosadvacuna readDatosADVacunaByConsulta(Integer consulta) throws ModelException;
    public Chdatosadvacuna readDatosADVacunaByUsuario(Chusuario usuario) throws ModelException;
    public Chconsulta getConsultaAntecedentes(final Long numeroConsulta) throws ModelException ;
    public void saveAntecedentesGenerales(Chantox toxicos,Chantalerg alergicos,Chantfarma farmacologicos
    ,Chantit its,Chanttrans transfusionales, Chantfami familiares,Chantpatol patologicos,Chantquir quirurgicos,Chanttrauma traumacologicos) throws ModelException ;
    public List <Chconsulta> getConsultasHistoricoAntecedentes(final Long numeroUsuario,final boolean conEtapa) throws ModelException;
    public Chplanconsinfo getConsentimientoInformadoActivo(String codigo) throws ModelException ;
    public List<Crcup>getCupsXCriterios(Crcup crcups,String capitulo) throws ModelException;
    public List<String>getCapitulosCups() throws ModelException;
    public Crcup getCupByCodigo(String codigo) throws ModelException;
    public Cnregferti getRegistroFertilidad(Integer clinica, String tipoid, Long numeroid) throws ModelException;

}
