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

public interface ReporteService
{
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
    
    public List getReportes() throws ModelException;
}

