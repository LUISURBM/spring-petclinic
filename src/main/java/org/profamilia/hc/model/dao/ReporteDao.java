package org.profamilia.hc.model.dao;

import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.ReporteCervixDTO;
import org.profamilia.hc.model.exceptions.ModelException;


public interface ReporteDao {
    public List<ReporteCervixDTO>reporteSaludTotal(final Long numeroClinica,final Date fechaInicial,final Date fechaFinal,
    final Long numeroContrato) throws ModelException;
    
    public List<Object[]> getReporteEnvioEmail(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteDiscapacidad(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteIdentidadGenero(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteITS(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteVBG(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteVBGDiagnosticos(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReportePrep(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteVPHHC(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteConflictoArmado(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteColposcopia(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteCitologia(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteEntregaVPH(Date fechaInicial, Date fechaFinal) throws ModelException;
    
    public List<Object[]> getReporteExtranjeros(Date fechaInicial, Date fechaFinal) throws ModelException;
}
