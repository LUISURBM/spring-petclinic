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
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.response.ResultadosLCResponse;

public class ClinicoServiceImp   implements ClinicoService{

    public void changePassword(String username, String oldPassword, String newPassword)
        throws DAOException
    {
        clinicoDAO.changePassword(username, oldPassword, newPassword);
    }

    public Cpclinica getClinica(Integer cclncodigo)
        throws ModelException
    {
        return clinicoDAO.getClinica(cclncodigo);
    }

    public List getClinicasUsuario(String userName)
        throws ModelException
    {
        return clinicoDAO.getClinicasUsuario(userName);
    }

    public Cpclinica getClinicaRouter(String dirrouter)
        throws ModelException
    {
        return clinicoDAO.getClinicaRouter(dirrouter);
    }

    public Sausuario getSausuario(String login)
        throws ModelException
    {
        return clinicoDAO.getSausuario(login);
    }

    public Cpusuario getUsuarioPorId(String curcusuari)
        throws ModelException
    {
        return clinicoDAO.getUsuarioPorId(curcusuari);
    }

    public List getPermisosUsuario(String login)
        throws ModelException
    {
        return clinicoDAO.getPermisosUsuario(login);
    }

    public List getPermisosUsuarioRol(String login, String aplicacion)
        throws ModelException
    {
        return clinicoDAO.getPermisosUsuarioRol(login, aplicacion);
    }

    public Sapermiso getPermisosForma(String login, String programa)
        throws ModelException
    {
        return clinicoDAO.getPermisosForma(login, programa);
    }

    public void setClinicoDAO(ClinicoDao clinicoDAO)
    {
        this.clinicoDAO = clinicoDAO;
    }

    public ClinicoDao getClinicoDAO()
    {
        return clinicoDAO;
    }

    public void saveUsuario(Chusuario usuario, Cnconsclin consulta, String userName, Long codigoAgenda)
        throws ModelException
    {
        clinicoDAO.saveUsuario(usuario, consulta, userName,codigoAgenda);
    }

    public void saveUsuarioAsesoria(Chusuario usuario, String userName)
        throws ModelException
    {
        clinicoDAO.saveUsuarioAsesoria(usuario, userName);
    }


    public void saveUsuarioCitologia(Chusuario usuario, Cnconsclin consulta, Cncitologi citologia, String userName, Long codigoAgenda)
        throws ModelException
    {
        clinicoDAO.saveUsuarioCitologia(usuario, consulta, citologia, userName,codigoAgenda);
    }
    
    public void saveUsuarioVph(final Chusuario usuario, 
                                     final Cnconsclin consulta, 
                                     final Chdatosvph citologia, 
                                     final String userName) throws ModelException {
                clinicoDAO.saveUsuarioVph(usuario, consulta, citologia, userName);
    }
    

    public void updateUsuario(Chusuario usuario)
        throws ModelException
    {
        clinicoDAO.updateUsuario(usuario);
    }

    public void saveProcedimientoConsultorio(Chproceconsu procedimiento)
        throws ModelException
    {
        clinicoDAO.saveProcedimientoConsultorio(procedimiento);
    }

    public Chproceconsu getProcedimientoConsultorio(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getProcedimientoConsultorio(consclin);
    }

    public void saveEncuestaViolencia(Chviolencia encuesta)
        throws ModelException
    {
        clinicoDAO.saveEncuestaViolencia(encuesta);
    }

    public void saveMotivoConsulta(Chmotivocon motivo, Chrevissiste revision)
        throws ModelException
    {
        clinicoDAO.saveMotivoConsulta(motivo, revision);
    }

    public void saveAntecedente(Chantecegene antecedente)
        throws ModelException
    {
        clinicoDAO.saveAntecedente(antecedente);
    }

    public void saveAntecedenteGineco(Chantegineco antecedente)
        throws ModelException
    {
        clinicoDAO.saveAntecedenteGineco(antecedente);
    }

    public void saveConsulta(Chconsulta consulta)
        throws ModelException
    {
        clinicoDAO.saveConsulta(consulta);
    }

    public void saveExamenFisico(Chexamfisico examen)
        throws ModelException
    {
        clinicoDAO.saveExamenFisico(examen);
    }

    public void saveExamenFisicoAnestesia(Chexafisane examen)
        throws ModelException
    {
        clinicoDAO.saveExamenFisicoAnestesia(examen);
    }

    public void saveFormula(Chformulamed formula)
        throws ModelException
    {
        clinicoDAO.saveFormula(formula);
    }

    public void saveImpresion(Chimprdiag impresion)
        throws ModelException
    {
        clinicoDAO.saveImpresion(impresion);
    }

    public void saveIncapacidad(Chincapacida incapcacidad)
        throws ModelException
    {
        clinicoDAO.saveIncapacidad(incapcacidad);
    }

    public void saveRemision(Chremision remision)
        throws ModelException
    {
        clinicoDAO.saveRemision(remision);
    }

    public List getTipoafiliado()
        throws ModelException
    {
        List tipoAfiliado = new ArrayList();
        Chtipoafilia afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("C");
        afiliado.setCtacdescripcio("CONTRIBUTIVO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);
        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("E");
        afiliado.setCtacdescripcio("ESPECIAL");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);
        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("S");
        afiliado.setCtacdescripcio("SUBSIDIADO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);
        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("V");
        afiliado.setCtacdescripcio("VINCULADO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);
        afiliado = new Chtipoafilia();
        afiliado.setCtaecodigo("X");
        afiliado.setCtacdescripcio("NINGUNO");
        afiliado.setCtaeestado("VG");
        tipoAfiliado.add(afiliado);
        return tipoAfiliado;
    }

    public List getSexo()
    {
        List tipoSexo = new ArrayList();
        Chsexo sexo = new Chsexo();
        sexo.setCsxecodigo("F");
        sexo.setCsxcdescripcio("FEMENINO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        sexo = new Chsexo();
        sexo.setCsxecodigo("M");
        sexo.setCsxcdescripcio("MASCULINO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        sexo = new Chsexo();
        sexo.setCsxecodigo("A");
        sexo.setCsxcdescripcio("AMBIGUO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        sexo = new Chsexo();
        sexo.setCsxecodigo("T");
        sexo.setCsxcdescripcio("TRANSEXUAL");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        return tipoSexo;
    }

    public List getSexoSap()
    {
        List tipoSexo = new ArrayList();
        Chsexo sexo = new Chsexo();
        sexo.setCsxecodigo("F");
        sexo.setCsxcdescripcio("FEMENINO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        sexo = new Chsexo();
        sexo.setCsxecodigo("M");
        sexo.setCsxcdescripcio("MASCULINO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        sexo = new Chsexo();
        sexo.setCsxecodigo("I");
        sexo.setCsxcdescripcio("INDETERMINADO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        return tipoSexo;
    }
    
    public List getSexoNew()
    {
        List tipoSexo = new ArrayList();
        Chsexo sexo = new Chsexo();
        sexo.setCsxecodigo("F");
        sexo.setCsxcdescripcio("MUJER");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        sexo = new Chsexo();
        sexo.setCsxecodigo("M");
        sexo.setCsxcdescripcio("HOMBRE");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        sexo = new Chsexo();
        sexo.setCsxecodigo("I");
        sexo.setCsxcdescripcio("INDETERMINADO");
        sexo.setCsxeestado("VG");
        tipoSexo.add(sexo);
        return tipoSexo;
    }

    public List getEspacioCirugia()
    {
        List tipoEspacio = new ArrayList();
        Chespacio espacio = new Chespacio();
        espacio.setCespnodigo(Integer.valueOf(1));
        espacio.setCespdescripcio("CONSULTORIO");
        espacio.setCespestado("VG");
        tipoEspacio.add(espacio);
        espacio = new Chespacio();
        espacio.setCespnodigo(Integer.valueOf(2));
        espacio.setCespdescripcio("SALAS CIRUGIA");
        espacio.setCespestado("VG");
        tipoEspacio.add(espacio);
        espacio = new Chespacio();
        espacio.setCespnodigo(Integer.valueOf(3));
        espacio.setCespdescripcio("SALAS IVE");
        espacio.setCespestado("VG");
        tipoEspacio.add(espacio);
        return tipoEspacio;
    }

    public List getEstadoCivil()
    {
        List tipoEstadoCivil = new ArrayList();
        Chestadociv estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("C");
        estadoCivil.setCeccdescripcio("CASADO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("D");
        estadoCivil.setCeccdescripcio("DIVORCIADO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("S");
        estadoCivil.setCeccdescripcio("SOLTERO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("U");
        estadoCivil.setCeccdescripcio("UNION LIBRE");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("V");
        estadoCivil.setCeccdescripcio("VIUDO");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        return tipoEstadoCivil;
    }

    public List getEstadoCivilFemenino()
    {
        List tipoEstadoCivil = new ArrayList();
        Chestadociv estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("C");
        estadoCivil.setCeccdescripcio("CASADA");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("D");
        estadoCivil.setCeccdescripcio("DIVORCIADA");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("S");
        estadoCivil.setCeccdescripcio("SOLTERA");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("U");
        estadoCivil.setCeccdescripcio("UNION LIBRE");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        estadoCivil = new Chestadociv();
        estadoCivil.setCececodigo("V");
        estadoCivil.setCeccdescripcio("VIUDA");
        estadoCivil.setCeceestado("VG");
        tipoEstadoCivil.add(estadoCivil);
        return tipoEstadoCivil;
    }

    public String getDescripcionEstadoCivilFemenino(String estado)
    {
        String estadoCivil = null;
        if(estado.equals("C"))
            estadoCivil = "CASADA";
        if(estado.equals("D"))
            estadoCivil = "DIVORCIADA";
        if(estado.equals("S"))
            estadoCivil = "SOLTERA";
        if(estado.equals("U"))
            estadoCivil = "UNION LIBRE";
        if(estado.equals("V"))
            estadoCivil = "VIUDA";
        return estadoCivil;
    }

    public String getDescripcionEstadoCivil(String estado)
    {
        String estadoCivil = null;
        if(estado.equals("C"))
            estadoCivil = "CASADA";
        if(estado.equals("D"))
            estadoCivil = "DIVORCIADA";
        if(estado.equals("S"))
            estadoCivil = "SOLTERA";
        if(estado.equals("U"))
            estadoCivil = "UNION LIBRE";
        if(estado.equals("V"))
            estadoCivil = "VIUDA";
        return estadoCivil;
    }

    public Cpentidadadm getDescripcionEntidad(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getDescripcionEntidad(numeroUsuario);
    }

    public String getDescripcionEntidadByCodigo(String codigo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionEntidadByCodigo(codigo);
    }

    public List getTipoIdentificacion()
        throws ModelException
    {
        return clinicoDAO.getTipoIdentificacion();
    }

    public List getOcupaciones()
        throws ModelException
    {
        return clinicoDAO.getOcupaciones();
    }

    public List<Cpestadciv> getEstadosCiviles()
        throws ModelException
    {
        return clinicoDAO.getEstadosCiviles();
    }

    public List<Cpparentes> getParentescos()
        throws ModelException
    {
        return clinicoDAO.getParentescos();
    }
    

    public List getDepartamentos()
        throws ModelException
    {
        return clinicoDAO.getDepartamentos();
    }

    public List getEntidadAdm()
        throws ModelException
    {
        return clinicoDAO.getEntidadAdm();
    }

    public Cpempresa getEmpresa(Integer codigo)
        throws ModelException
    {
        return clinicoDAO.getEmpresa(codigo);
    }

    public Cpentidadadm getAseguradoraPorCodigo(String ceaccodigo)
        throws ModelException
    {
        return clinicoDAO.getAseguradoraPorCodigo(ceaccodigo);
    }

    public Cpocupacio getOcupacionPorCodigo(Integer cocncodigo)
        throws ModelException
    {
        return clinicoDAO.getOcupacionPorCodigo(cocncodigo);
    }

    public List getMunicipios(Integer idDepto)
        throws ModelException
    {
        return clinicoDAO.getMunicipios(idDepto);
    }

    public List getConsultasDia(Date dia, Integer codclinica, BigDecimal idMedico)
        throws ModelException
    {
        return clinicoDAO.getConsultasDia(dia, codclinica, idMedico);
    }

    public List getMisConsultasDia(Date dia, Integer codclinica, BigDecimal idMedico)
        throws ModelException
    {
        return clinicoDAO.getMisConsultasDia(dia, codclinica, idMedico);
    }
    
    public List<Cnconsclin> getConsultasDiaLaboratorio(final Date dia, 
                                            final Integer codclinica, 
                                            final BigDecimal idMedico, String numeroIdentificacion) throws ModelException{
                                                return clinicoDAO.getConsultasDiaLaboratorio(dia, codclinica, idMedico,numeroIdentificacion);                                        
                                            }

    public List getConsultasDiaEnfermeria(Date dia, Integer codclinica, BigDecimal idMedico, String numIden)
        throws ModelException
    {
        return clinicoDAO.getConsultasDiaEnfermeria(dia, codclinica, idMedico,numIden);
    }

    public List getConsultasEnConsultorioDia(Date dia, Integer codclinica)
        throws ModelException
    {
        return clinicoDAO.getConsultasEnConsultorioDia(dia, codclinica);
    }

    public List getConsultasVacunacionDia(Date dia, Integer codclinica, BigDecimal idMedico)
        throws ModelException
    {
        return clinicoDAO.getConsultasVacunacionDia(dia, codclinica, idMedico);
    }

    public List getConsultasProceso(Date dia, Integer codclinica, BigDecimal idMedico, String username)
        throws ModelException
    {
        return clinicoDAO.getConsultasProceso(dia, codclinica, idMedico, username);
    }

    public List getConsultasAusentes(Date dia, Integer codclinica, BigDecimal idMedico, String username, Integer numsala)
        throws ModelException
    {
        return clinicoDAO.getConsultasAusentes(dia, codclinica, idMedico, username, numsala);
    }

    public List getCitologiasDia(Date dia, Integer codclinica,String wnumiden)
        throws ModelException
    {
        return clinicoDAO.getCitologiasDia(dia, codclinica, wnumiden);
    }
    
    public  List getVPHDia(Date date, Integer codclinica) throws ModelException{
            return clinicoDAO.getVPHDia(date, codclinica);
        }


    public List getListServicio()
        throws ModelException
    {
        return clinicoDAO.getListServicio();
    }

    public List getTipoAntecedente(Integer tipoHistoria)
        throws ModelException
    {
        return clinicoDAO.getTipoAntecedente(tipoHistoria);
    }

    public List getPlantillaAnticioncepcion()
        throws ModelException
    {
        return clinicoDAO.getPlantillaAnticioncepcion();
    }

    public Chusuario getUsuario(Long huslnumero)
        throws ModelException
    {
        return clinicoDAO.getUsuario(huslnumero);
    }

    public List getCie10()
        throws ModelException
    {
        return clinicoDAO.getCie10();
    }

    public List getCriteriosCie10(Crdgncie10 cie10)
        throws ModelException
    {
        return clinicoDAO.getCriteriosCie10(cie10);
    }
    
    
    public List<Crdgncie10> getCriteriosIveCie10(Crdgncie10 cie10, boolean bloquearZ) throws ModelException{
        return clinicoDAO.getCriteriosIveCie10(cie10,bloquearZ);
    }

    public Crdgncie10 getCIE10IVEPorCodigo(String codigo, boolean bloquearW) throws ModelException {
        return clinicoDAO.getCIE10IVEPorCodigo(codigo,bloquearW);
    }
    

    public List getCausaExterna(Integer tipoHistoria)
        throws ModelException
    {
        return clinicoDAO.getCausaExterna(tipoHistoria);
    }

    public List<Crcausaext> getCausaExternaVG(Integer tipoHistoria)
        throws ModelException
    {
        return clinicoDAO.getCausaExternaVG(tipoHistoria);
    }

    public Chmotivocon getMotivoConsulta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getMotivoConsulta(consclin);
    }

    public void saveAntecedentes(List lstAntecedentes, Long numeroConsulta)
        throws ModelException
    {
        clinicoDAO.saveAntecedentes(lstAntecedentes, numeroConsulta);
    }

    public void saveParaclinicos(List lstParaclinicos, Long numeroConsulta)
        throws ModelException
    {
        clinicoDAO.saveParaclinicos(lstParaclinicos, numeroConsulta);
    }

    public List getAntecedentes(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAntecedentes(numeroConsulta);
    }

    public Chantegineco getAntecedentesGinecologicos(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesGinecologicos(consclin);
    }

    public List getAntecedentesUsuario(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesUsuario(numeroUsuario);
    }
    
    public List<Chantecegene> getAntecedentesUsuarioAnterioresXFecha(Long numeroUsuario, Date fechaRegistro) throws ModelException{
        return clinicoDAO.getAntecedentesUsuarioAnterioresXFecha(numeroUsuario,fechaRegistro );
    }
    
    public List<Chantecegene> getAntecedentesUsuarioActualConsulta(Long numeroConsulta) throws ModelException{
        return clinicoDAO.getAntecedentesUsuarioActualConsulta(numeroConsulta);
    }

    public List getParaclinicosUsuario(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getParaclinicosUsuario(numeroUsuario);
    }

    public List getParaclinicos(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getParaclinicos(numeroConsulta);
    }

    public Chviolencia getEncuestaViolencia(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getEncuestaViolencia(consclin);
    }

    public Chexafisane getExamenFisicoAnestesia(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenFisicoAnestesia(consclin);
    }

    public Chvalorprean getValoracionPreanestesia(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getValoracionPreanestesia(consclin);
    }

    public List getFinalidadesConsulta(String tipo)
        throws ModelException
    {
        return clinicoDAO.getFinalidadesConsulta(tipo);
    }

    public List getFinalidadesConsultaVG(String tipo)
        throws ModelException
    {
        return clinicoDAO.getFinalidadesConsultaVG(tipo);
    }

    public List getActoQuirurgico()
        throws ModelException
    {
        return clinicoDAO.getActoQuirurgico();
    }

    public List getTiposDiagnosticos()
        throws ModelException
    {
        List tipoDiagnostico = new ArrayList();
        Chtipodiagno diagnostico = new Chtipodiagno();
        diagnostico.setHtdccodigo(Integer.valueOf(1));
        diagnostico.setHtdcdescripcio("Impresi\363n Diagnostica");
        tipoDiagnostico.add(diagnostico);
        diagnostico = new Chtipodiagno();
        diagnostico.setHtdccodigo(Integer.valueOf(2));
        diagnostico.setHtdcdescripcio("Confirmado Nuevo");
        tipoDiagnostico.add(diagnostico);
        diagnostico = new Chtipodiagno();
        diagnostico.setHtdccodigo(Integer.valueOf(3));
        diagnostico.setHtdcdescripcio("Confirmado repetido");
        tipoDiagnostico.add(diagnostico);
        return tipoDiagnostico;
    }

    public void closeConsulta(Chusuario usuario, Cnconsclin consulta, Chimprdiag impresion, Chmotivocon motivo, String userName, String surveypalLink)
        throws ModelException
    {
        clinicoDAO.closeConsulta(usuario, consulta, impresion, motivo, userName,surveypalLink);
    }

    public void closeEspermograma(Chusuario usuario, Cnconsclin consulta, String userName)
        throws ModelException
    {
        clinicoDAO.closeEspermograma(usuario, consulta, userName);
    }

    public void closeEspermogramaFertilidad(Chusuario usuario, Cnconsclin consulta, String userName)
        throws ModelException
    {
        clinicoDAO.closeEspermogramaFertilidad(usuario, consulta, userName);
    }

    public void closeVacunacionCervix(Chusuario usuario, Cnconsclin consulta, String userName, List<Chmedicament> listadoMedicamentos)
        throws ModelException
    {
        clinicoDAO.closeVacunacionCervix(usuario, consulta, userName,listadoMedicamentos);
    }

    public void closeProcedimiento(Cnconsclin consulta, String userName)
        throws ModelException
    {
        clinicoDAO.closeProcedimiento(consulta, userName);
    }

    public void closeLecturaCitologia(Chconsulta consulta)
        throws ModelException
    {
        clinicoDAO.closeLecturaCitologia(consulta);
    }

    public void closeLecturaVph(Chconsulta consulta)
        throws ModelException
    {
        clinicoDAO.closeLecturaVph(consulta);
    }

    public void closeTomaCitologia(Cncitotoma toma, Cnconsclin consulta, String userName, boolean temporal)
        throws ModelException
    {
        clinicoDAO.closeTomaCitologia(toma, consulta, userName, temporal);
    }
    
    public void closeTomaVph(final Chvphtoma toma, 
                                   final Cnconsclin consulta, 
                                   final String userName, 
                                   final boolean temporal) throws ModelException{
                                       clinicoDAO.closeTomaVph(toma, consulta, userName, temporal);         
    }

    public void entregarCitologia(Cncitologi citologia, Chlibrocitol libro)
        throws ModelException
    {
        clinicoDAO.entregarCitologia(citologia, libro);
    }

    public void entregarVph(Chdatosvph chdatosvph, Chlibrovph libro)
        throws ModelException
    {
        clinicoDAO.entregarVph(chdatosvph, libro);
    }

    public void saveLibroCitologia(Chlibrocitol libro)
        throws ModelException
    {
        clinicoDAO.saveLibroCitologia(libro);
    }

    public boolean esPrimeraConsulta(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.esPrimeraConsulta(usuario);
    }
    
    public boolean esPrimeraConsultaCovid(Long consulta)
           throws ModelException
    {
       return clinicoDAO.esPrimeraConsultaCovid(consulta);
    }

    public void saveAntecedenteTemporal(List lstAntecedentes)
        throws ModelException
    {
        clinicoDAO.saveAntecedenteTemporal(lstAntecedentes);
    }

    public List getCitologiasLectura(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getCitologiasLectura(numeroUsuario);
    }

    public List getVphLectura(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getVphLectura(numeroUsuario);
    }
    
       public List getVphLecturaMod(Long numeroUsuario)
           throws ModelException
       {
           return clinicoDAO.getVphLecturaMod(numeroUsuario);
       }

    public List getAntecedentesTemporal(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesTemporal(consclin);
    }

    public void saveExamenApoyoDiagnostico(Chexamediagn diagnostico)
        throws ModelException
    {
        clinicoDAO.saveExamenApoyoDiagnostico(diagnostico);
    }

    public Chexamediagn getExamenApoyoDiagnostico(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenApoyoDiagnostico(consclin);
    }

    public void saveConducta(Chconducta conducta)
        throws ModelException
    {
        clinicoDAO.saveConducta(conducta);
    }

    public Chconducta getConducta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getConducta(consclin);
    }

    public List getTipoAntecedentePediatricos()
        throws ModelException
    {
        return clinicoDAO.getTipoAntecedentePediatricos();
    }

    public List getMetodosPlanificacion(String sexo)
        throws ModelException
    {
        return clinicoDAO.getMetodosPlanificacion(sexo);
    }

    public void saveAantecedentesMama(Chantecemama antecedente)
        throws ModelException
    {
        clinicoDAO.saveAantecedentesMama(antecedente);
    }

    public Chantecemama getAntecedentesMama(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesMama(consclin);
    }

    public void saveRiesgoMama(Chriesgomama riesgo)
        throws ModelException
    {
        clinicoDAO.saveRiesgoMama(riesgo);
    }

    public Chriesgomama getRiesgoMama(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getRiesgoMama(consclin);
    }

    public void saveExamenFisicoMama(Chexafismama examen)
        throws ModelException
    {
        clinicoDAO.saveExamenFisicoMama(examen);
    }

    public Chexafismama getExamenFisicoMama(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenFisicoMama(consclin);
    }

    public List getZona()
        throws ModelException
    {
        List zonas = new ArrayList();
        Chzona zona = new Chzona();
        zona.setId("R");
        zona.setDescripcion("RURAL");
        zonas.add(zona);
        zona = new Chzona();
        zona.setId("U");
        zona.setDescripcion("URBANA");
        zonas.add(zona);
        return zonas;
    }

    public Crdgncie10 getCIE10PorCodigo(String codigo)
        throws ModelException
    {
        return clinicoDAO.getCIE10PorCodigo(codigo);
    }

    public String getDescripcionCups(String codigo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionCups(codigo);
    }

    public Cptipconcl getDescripcionTipoConsulta(Integer codigo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionTipoConsulta(codigo);
    }

    public Chincapacida getIncapcidad(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getIncapcidad(numeroConsulta);
    }

    public void saveExamenParaclinico(Chexameparac examen)
        throws ModelException
    {
        clinicoDAO.saveExamenParaclinico(examen);
    }

    public void saveListExamenParaclinicos(List lstexamenes, Cnconsclin consulta)
        throws ModelException
    {
        clinicoDAO.saveListExamenParaclinicos(lstexamenes, consulta);
    }

    public List getExamenesParaclinicos(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenesParaclinicos(consclin);
    }

    public List getRemisionConsulta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getRemisionConsulta(consclin);
    }

    public void saveFormulaMedica(Chformulamed formula)
        throws ModelException
    {
        clinicoDAO.saveFormulaMedica(formula);
    }

    public void saveListFormulaMedica(List lstFormula, Long numeroConsulta)
        throws ModelException
    {
        clinicoDAO.saveListFormulaMedica(lstFormula, numeroConsulta);
    }

    public List getListPrescripciones(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getListPrescripciones(numeroConsulta);
    }

    public void saveControl(Chconsprogra control)
        throws ModelException
    {
        clinicoDAO.saveControl(control);
    }

    public Chconsprogra getControl(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getControl(consclin);
    }

    public List<Chconsprogra>  getControlesConsulta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getControlesConsulta(consclin);
    }

    public void saveOrdenCirugia(Chordecirugi orden)
        throws ModelException
    {
        clinicoDAO.saveOrdenCirugia(orden);
    }

    public Chordecirugi getOrdenCirugia(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getOrdenCirugia(consclin);
    }

    public Cpmunidane getMunicipio(Integer idMunicipio, Integer idDepartamento)
        throws ModelException
    {
        return clinicoDAO.getMunicipio(idMunicipio, idDepartamento);
    }

    public void saveReferencia(Chreferencia referencia)
        throws ModelException
    {
        clinicoDAO.saveReferencia(referencia);
    }

    public void saveAutorizacion(Chautoriserv autoriserv, List lstServicioss)
        throws ModelException
    {
        clinicoDAO.saveAutorizacion(autoriserv, lstServicioss);
    }

    public Chreferencia getReferencia(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getReferencia(consclin);
    }

    public List getListServicioss(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getListServicioss(numeroConsulta);
    }

    public Chautoriserv getAutorizacion(Long numeroCirugia)
        throws ModelException
    {
        return clinicoDAO.getAutorizacion(numeroCirugia);
    }

    public Chreferencia getReferencia(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getReferencia(numeroCirugia, tipoServicio, consecutivo);
    }

    public void saveAnatomiaPatologica(Chanatopatol anatomia)
        throws ModelException
    {
        clinicoDAO.saveAnatomiaPatologica(anatomia);
    }

    public void saveMedidaApoyo(Chmedidapoyo medida)
        throws ModelException
    {
        clinicoDAO.saveMedidaApoyo(medida);
    }

    public Chanatopatol getAnatomiaPatologica(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getAnatomiaPatologica(consclin);
    }

    public List<Chanatopatol> getListAnatomiaPatologica(Long numConsulta)
        throws ModelException
    {
        return clinicoDAO.getListAnatomiaPatologica(numConsulta);
    }

    public Chanatopatol getAnatomiaPatologica(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getAnatomiaPatologica(numeroCirugia, tipoServicio, consecutivo);
    }

    public void saveCertificado(Chcertmedico certificado)
        throws ModelException
    {
        clinicoDAO.saveCertificado(certificado);
    }

    public Chcertmedico getCertificado(Cnconsclin consclin, String tipo)
        throws ModelException
    {
        return clinicoDAO.getCertificado(consclin, tipo);
    }

    public List getParametroEduca(String nomColumna)
        throws ModelException
    {
        return clinicoDAO.getParametroEduca(nomColumna);
    }

    public Crcausaext getCausaExternaPorId(Integer codigo)
        throws ModelException
    {
        return clinicoDAO.getCausaExternaPorId(codigo);
    }

    public Chrevissiste getRevisionSistemas(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getRevisionSistemas(numeroConsulta);
    }

    public String getRevisionSistemasTexto(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getRevisionSistemasTexto(numeroConsulta);
    }

    public Crfinalcon getFinalidadPorId(Integer idFinalidad, String tipoFinalidad)
        throws ModelException
    {
        return clinicoDAO.getFinalidadPorId(idFinalidad, tipoFinalidad);
    }

    public List getUsuarios(String tipoIdentificacion, Long numeroIdentificacion)
        throws ModelException
    {
        return clinicoDAO.getUsuarios(tipoIdentificacion, numeroIdentificacion);
    }

    public List getUsuariosClienteActivo(String tipoIdentificacion, Long numeroIdentificacion)
        throws ModelException
    {
        return clinicoDAO.getUsuariosClienteActivo(tipoIdentificacion, numeroIdentificacion);
    }

    public List getUsuariosClienteInactivo(String tipoIdentificacion, Long numeroIdentificacion)
        throws ModelException
    {
        return clinicoDAO.getUsuariosClienteInactivo(tipoIdentificacion, numeroIdentificacion);
    }

    public List getUsuarios(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getUsuarios(usuario);
    }

    public List getUsuariosCitologia(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getUsuariosCitologia(usuario);
    }

    public List getUsuariosVph(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getUsuariosVph(usuario);
    }

    public List getUsuariosProgramarCirugia(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getUsuariosProgramarCirugia(usuario);
    }

    public Chcirugprogr getProgramarCirugia(Ccfactvent factura)
        throws ModelException
    {
        return clinicoDAO.getProgramarCirugia(factura);
    }

    public List getCirugiasPorUsuario(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getCirugiasPorUsuario(usuario);
    }

    public List getCirugiasProgramadas(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getCirugiasProgramadas(usuario);
    }

    public List getFoliosUsuario(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getFoliosUsuario(numeroUsuario);
    }

    public List getFoliosUsuarioNotaAclaratoria(Long numeroUsuario, String userName)
        throws ModelException
    {
        return clinicoDAO.getFoliosUsuarioNotaAclaratoria(numeroUsuario, userName);
    }
    
    public List<Chconsulta> getFoliosUsuarioEvolucion(Long numeroUsuario) throws ModelException{
        return clinicoDAO.getFoliosUsuarioEvolucion(numeroUsuario);
    }

    public List getFoliosUsuarioExamenesClinicos(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getFoliosUsuarioExamenesClinicos(numeroUsuario);
    }

    public List getFoliosUsuarioTipoHistoria(Long numeroUsuario, Integer tipoHistoria)
        throws ModelException
    {
        return clinicoDAO.getFoliosUsuarioTipoHistoria(numeroUsuario, tipoHistoria);
    }

    public List getFoliosUsuarioTipoHistoria(Long numeroUsuario, List tipoHistoria)
        throws ModelException
    {
        return clinicoDAO.getFoliosUsuarioTipoHistoria(numeroUsuario, tipoHistoria);
    }

    public List getFoliosUsuarioPorFecha(Long numeroUsuario, Date fechaInicial, Date fechaFinal)
        throws ModelException
    {
        return clinicoDAO.getFoliosUsuarioPorFecha(numeroUsuario, fechaInicial, fechaFinal);
    }

    public Chusuario getUsuarioPorPk(Long idUsuario)
        throws ModelException
    {
        return clinicoDAO.getUsuarioPorPk(idUsuario);
    }

    public Chmotivocon getMotivoConsulta(Long idConsulta)
        throws ModelException
    {
        return clinicoDAO.getMotivoConsulta(idConsulta);
    }

    public List getAntecedentesGenerales(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesGenerales(numeroConsulta);
    }

    public String getAntecedentesGeneralesTexto(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesGeneralesTexto(numeroConsulta);
    }

    public Chantegineco getAntecedentesGinecologicos(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesGinecologicos(numeroUsuario);
    }

    public Chexamfisico getExamenFisico(Long numeroConsulta, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getExamenFisico(numeroConsulta, consecutivo);
    }

    public Chviolencia getEncuestaViolencia(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getEncuestaViolencia(numeroConsulta);
    }

    public Chimprdiag getImresionDiagnostica(Long numeroConsulta, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getImresionDiagnostica(numeroConsulta, consecutivo);
    }

    public Chconsulta getConsultaActual(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getConsultaActual(numeroConsulta);
    }

    public List getAntecedentesPorTipo(List lstTiposAntecedentes, Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesPorTipo(lstTiposAntecedentes, numeroUsuario);
    }

    public List getConsultaPorId(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getConsultaPorId(numeroUsuario);
    }

    public List getConsultasDiaProfesional(Date dia, BigDecimal idMedico, Integer codclinica)
        throws ModelException
    {
        return clinicoDAO.getConsultasDiaProfesional(dia, idMedico, codclinica);
    }

    public List getConsultaClinica(Long numero)
        throws ModelException
    {
        return clinicoDAO.getConsultaClinica(numero);
    }

    public void saveNotaMedica(Chnotamedica nota)
        throws ModelException
    {
        clinicoDAO.saveNotaMedica(nota);
    }
    
    public void saveEvolucionConsulta(Chevoluconsu evolucion) throws ModelException {
        clinicoDAO.saveEvolucionConsulta(evolucion);
    }

    public void saveRegistrarExamenLaboratorio(Chregisexame examen)
        throws ModelException
    {
        clinicoDAO.saveRegistrarExamenLaboratorio(examen);
    }

    public Integer getConsecutivoNotaMedica(Chconsulta consulta)
        throws ModelException
    {
        return clinicoDAO.getConsecutivoNotaMedica(consulta);
    }

    public Chconducta getConducta(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getConducta(numeroConsulta);
    }

    public List getExamenesParaclinicos(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getExamenesParaclinicos(numeroConsulta);
    }

    public Chincapacida getIncapacidad(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getIncapacidad(numeroConsulta);
    }

    public List getPrescripcionMedica(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getPrescripcionMedica(numeroConsulta);
    }

    public Chordecirugi getOrdenCirugia(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getOrdenCirugia(numeroConsulta);
    }

    public Chreferencia getReferencia(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getReferencia(numeroConsulta);
    }

    public Chanatopatol getAnatomiaPatologica(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAnatomiaPatologica(numeroConsulta);
    }

    public Chconsprogra getControl(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getControl(numeroConsulta);
    }

    public void saveCuestionarioPlanificacion(Chcuestplani cuestionario)
        throws ModelException
    {
        clinicoDAO.saveCuestionarioPlanificacion(cuestionario);
    }

    public Chcuestplani getCuestionarioPlanificacion(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getCuestionarioPlanificacion(numeroConsulta);
    }

    public void saveAntecedentesPrenatal(Chantecprena antecedente)
        throws ModelException
    {
        clinicoDAO.saveAntecedentesPrenatal(antecedente);
    }
    
    public void saveAntecedentesFamiliar(Chantecfamil antecedente) throws ModelException {
        clinicoDAO.saveAntecedentesFamiliar(antecedente);
    }

    public Chantecprena getAntecedentesPrenatales(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesPrenatales(consclin);
    }
    
    public Chantecfamil getAntecedentesFamiliares(Cnconsclin consclin) throws ModelException{
        return clinicoDAO.getAntecedentesFamiliares(consclin);
    }

    public void saveTamizajeLaboratoriosPrenatal(Chtamizalapr tamizaje)
        throws ModelException
    {
        clinicoDAO.saveTamizajeLaboratoriosPrenatal(tamizaje);
    }

    public Chtamizalapr getTamizajeLaboratorioPrenatal(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getTamizajeLaboratorioPrenatal(consclin);
    }

    public List getResumenHistoria(Date fechaInicial, Date fechaFinal, Long usuario)
        throws ModelException
    {
        return clinicoDAO.getResumenHistoria(fechaInicial, fechaFinal, usuario);
    }

    public Chconsulta getConsultaCompleta(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getConsultaCompleta(numeroConsulta, tipoServicio);
    }

    public List getResumenEnfermeriaCirugiaActual(Long numeroCirugia)
        throws ModelException
    {
        return clinicoDAO.getResumenEnfermeriaCirugiaActual(numeroCirugia);
    }

    public void saveExamenPediatria(Chpediexamen examen)
        throws ModelException
    {
        clinicoDAO.saveExamenPediatria(examen);
    }

    public Chpediexamen getExamenPediatria(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenPediatria(consclin);
    }

    public String getDescripcionMetodo(String codMetodo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionMetodo(codMetodo);
    }

    public Chantecemama getAntecedentesMama(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesMama(numeroConsulta);
    }

    public Chriesgomama getRiesgoMama(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getRiesgoMama(numeroConsulta);
    }

    public Chexafismama getExamenFisicoMama(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getExamenFisicoMama(numeroConsulta);
    }

    public Chpediexamen getExamenPediatria(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getExamenPediatria(numeroConsulta);
    }

    public Chexamediagn getExamenApoyoDiagnostico(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getExamenApoyoDiagnostico(numeroConsulta);
    }

    public List getListNotasMedicas(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getListNotasMedicas(numeroConsulta);
    }

    public List getActividad(Integer tipoHistoria)
        throws ModelException
    {
        return clinicoDAO.getActividad(tipoHistoria);
    }

    public Chactividad getActividadPorId(Integer idActividad)
        throws ModelException
    {
        return clinicoDAO.getActividadPorId(idActividad);
    }

    public String getNombreUsuarioPorId(String curcusuari)
        throws ModelException
    {
        return clinicoDAO.getNombreUsuarioPorId(curcusuari);
    }

    public List getVerificacionCie10(Crdgncie10 cie10, String sexo, String unidadEdad, Integer edad, String esPrincipal)
    {
        return clinicoDAO.getVerificacionCie10(cie10, sexo, unidadEdad, edad, esPrincipal);
    }

    public List getTiposInterconsulta()
        throws ModelException
    {
        return clinicoDAO.getTiposInterconsulta();
    }

    public void saveListRemisionInterconsulta(List lstRemision, Long numeroConsulta)
        throws ModelException
    {
        clinicoDAO.saveListRemisionInterconsulta(lstRemision, numeroConsulta);
    }

    public void saveListRemisionInterconsultaCirugia(List lstRemision, Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        clinicoDAO.saveListRemisionInterconsultaCirugia(lstRemision, numeroCirugia, tipoServicio, consecutivo);
    }

    public void saveListRemisionInterconsultaCirugia(List lstRemision, Chevolucion evolucion)
        throws ModelException
    {
        clinicoDAO.saveListRemisionInterconsultaCirugia(lstRemision, evolucion);
    }

    public void saveControlConsulta(Chcontrolcon control)
        throws ModelException
    {
        clinicoDAO.saveControlConsulta(control);
    }

    public void saveControlConsultaCompleta(Chcontrolcon control, Chimprdiag impresion, Chmotivocon motivo)
        throws ModelException
    {
        clinicoDAO.saveControlConsultaCompleta(control, impresion, motivo);
    }

    public void saveControlIlveConsulta(Chcontrolcon control, Chmotivocon motivo)
        throws ModelException
    {
        clinicoDAO.saveControlIlveConsulta(control, motivo);
    }

    public void saveImpresionIlveConsulta(Chimprdiag impresion)
        throws ModelException
    {
        clinicoDAO.saveImpresionIlveConsulta(impresion);
    }

    public Chcontrolcon getControlConsulta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getControlConsulta(consclin);
    }

    public Chcontrvasec getControlVasectomia(Long numero, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getControlVasectomia(numero, consecutivo);
    }

    public void saveControlVasectomia(Chusuario usuario, Cnconsclin consulta, Chcontrvasec vasectomia, String usureg)
        throws ModelException
    {
        clinicoDAO.saveControlVasectomia(usuario, consulta, vasectomia, usureg);
    }

    public Chcontrolcon getControlConsulta(Long numero)
        throws ModelException
    {
        return clinicoDAO.getControlConsulta(numero);
    }

    public void saveAntecedenteObstetrico(Chanteceobst antecedente)
        throws ModelException
    {
        clinicoDAO.saveAntecedenteObstetrico(antecedente);
    }

    public Chanteceobst getAntecedenteObstetrico(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAntecedenteObstetrico(numeroConsulta);
    }

    public void saveGestacionActual(Chgestacion gestacion)
        throws ModelException
    {
        clinicoDAO.saveGestacionActual(gestacion);
    }

    public Chgestacion getGestacionActual(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getGestacionActual(consclin);
    }

    public void saveControlPrenatal(Chcontrolpre prenatal)
        throws ModelException
    {
        clinicoDAO.saveControlPrenatal(prenatal);
    }

    public Chcontrolpre getControlPrenatal(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getControlPrenatal(consclin);
    }

    public Chcontrolpre getControlPrenatal(Long numero)
        throws ModelException
    {
        return clinicoDAO.getControlPrenatal(numero);
    }

    public Long getConsultaPrenatalPrincipal(Long usuario)
        throws ModelException
    {
        return clinicoDAO.getConsultaPrenatalPrincipal(usuario);
    }

    public Chgestacion getGestacionControlPrenatal(Long usuario)
        throws ModelException
    {
        return clinicoDAO.getGestacionControlPrenatal(usuario);
    }

    public Date getFechaUltimoPeriodo(Long numeroHistoria)
        throws ModelException
    {
        return clinicoDAO.getFechaUltimoPeriodo(numeroHistoria);
    }

    public List getExamenFisicoControlPrenatal(Long numeroHistoria)
        throws ModelException
    {
        return clinicoDAO.getExamenFisicoControlPrenatal(numeroHistoria);
    }

    public List getTamizajesLaboratorioPrenatal(Long numeroHistoria)
        throws ModelException
    {
        return clinicoDAO.getTamizajesLaboratorioPrenatal(numeroHistoria);
    }

    public List getExamenesLaboratorio(Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getExamenesLaboratorio(servicio);
    }

    public List getExamenesImagenes(Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getExamenesImagenes(servicio);
    }

    public List getExamenesElectrofisiologicos(Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getExamenesElectrofisiologicos(servicio);
    }

    public void saveExamenImagenes(Chexameimage examen)
        throws ModelException
    {
        clinicoDAO.saveExamenImagenes(examen);
    }

    public void saveListExamenesImagenes(List lstexamenes, Long numeroConsulta, String observaciones)
        throws ModelException
    {
        clinicoDAO.saveListExamenesImagenes(lstexamenes, numeroConsulta, observaciones);
    }

    public void saveListExamenesImagenesCirugia(List lstexamenes, Long numeroCirugia, String tipoServicio, Integer consecutivo, String observaciones)
        throws ModelException
    {
        clinicoDAO.saveListExamenesImagenesCirugia(lstexamenes, numeroCirugia, tipoServicio, consecutivo, observaciones);
    }

    public void saveExamenElectrofisiologicos(Chexameelect examen)
        throws ModelException
    {
        clinicoDAO.saveExamenElectrofisiologicos(examen);
    }

    public void saveListExamenesElectrofisiologicos(List lstexamenes, Long numeroConsulta, String observaciones)
        throws ModelException
    {
        clinicoDAO.saveListExamenesElectrofisiologicos(lstexamenes, numeroConsulta, observaciones);
    }

    public void saveListExamenesElectrofisiologicosCirugia(List lstexamenes, Long numeroCirugia, String tipoServicio, Integer consecutivo, String observaciones)
        throws ModelException
    {
        clinicoDAO.saveListExamenesElectrofisiologicosCirugia(lstexamenes, numeroCirugia, tipoServicio, consecutivo, observaciones);
    }

    public void saveExamenLaboratorio(Chexamelabor examen)
        throws ModelException
    {
        clinicoDAO.saveExamenLaboratorio(examen);
    }

    public void saveListExamenesLaboratorio(List lstexamenes, Long numeroConsulta, String observaciones)
        throws ModelException
    {
        clinicoDAO.saveListExamenesLaboratorio(lstexamenes, numeroConsulta, observaciones);
    }

    public void saveListExamenesLaboratorioCirugia(List lstexamenes, Long numeroCirugia, String tipoServicio, Integer consecutivo, String observaciones)
        throws ModelException
    {
        clinicoDAO.saveListExamenesLaboratorioCirugia(lstexamenes, numeroCirugia, tipoServicio, consecutivo, observaciones);
    }

    public List getExamenesImagenesConsulta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenesImagenesConsulta(consclin);
    }

    public List getExamenesElectrofisiologicosConsulta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenesElectrofisiologicosConsulta(consclin);
    }

    public List getExamenesLaboratoriosConsulta(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getExamenesLaboratoriosConsulta(consclin);
    }

    public Cpservicio getServicioPorId(String codigo)
        throws ModelException
    {
        return clinicoDAO.getServicioPorId(codigo);
    }

    public List getExamenesLaboratorioPorCriterios(Cpservicio servicio,Long admision)
        throws ModelException
    {
        return clinicoDAO.getExamenesLaboratorioPorCriterios(servicio,admision);
    }

    public List getExamenesLaboratorioAll()
        throws ModelException
    {
        return clinicoDAO.getExamenesLaboratorioAll();
    }

    public List getMetodoPlanificacion()
        throws ModelException
    {
        return clinicoDAO.getMetodoPlanificacion();
    }

    public List getCirugiasPorCriterios(Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getCirugiasPorCriterios(servicio);
    }
    
    public List<Cpcontrato> getContratoPorCriterios(Cpcontrato contrato) throws ModelException{
        return clinicoDAO.getContratoPorCriterios(contrato);
    }
    
    public Cpcontrato getContratoPornumero(Integer contrato) throws ModelException{
        return clinicoDAO.getContratoPornumero(contrato);
    }

    public List getVademecumClinico(Crmedicame medicamento)
        throws ModelException
    {
        return clinicoDAO.getVademecumClinico(medicamento);
    }

    public List getVademecumHistorias(Chvademecum medicamento)
        throws ModelException
    {
        return clinicoDAO.getVademecumHistorias(medicamento);
    }
    
    public List getVademecum(Chvademecum medicamento)
        throws ModelException {
            return clinicoDAO.getVademecum(medicamento);
        }
        
    public List getVademProf(Chvademprof medicamento)
        throws ModelException {
            return clinicoDAO.getVademProf(medicamento);
        }

    public List getServicioSap(Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getServicioSap(servicio);
    }

    public Cpmunidane getMunicipiosSap(Integer departamento, Integer municipio)
        throws ModelException
    {
        return clinicoDAO.getMunicipiosSap(departamento, municipio);
    }

    public List getServicioSapCodigo(String codigo)
        throws ModelException
    {
        return clinicoDAO.getServicioSapCodigo(codigo);
    }

    public List getEntidadEps(Cpentidadadm eps)
        throws ModelException
    {
        return clinicoDAO.getEntidadEps(eps);
    }

    public List getOcupacion(Cpocupacio ocupacion)
        throws ModelException
    {
        return clinicoDAO.getOcupacion(ocupacion);
    }

    public boolean verificarConsultaCerrada(Long numeroconsulta)
        throws ModelException
    {
        return clinicoDAO.verificarConsultaCerrada(numeroconsulta);
    }

    public Cncitologi getUsuarioCitologia(Cnconsclin consulta)
        throws ModelException
    {
        return clinicoDAO.getUsuarioCitologia(consulta);
    }
    
    public Chdatosvph getUsuarioVph(Cnconsclin consulta) throws ModelException{
        return clinicoDAO.getUsuarioVph(consulta);
    }

    public Cncitologi getEncabezadoCitologia(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getEncabezadoCitologia(consecutivo);
    }

    public Chdatosvph getEncabezadoVph(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getEncabezadoVph(consecutivo);
    }

    public List getCopiaCitologia(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getCopiaCitologia(numeroUsuario);
    }

    public List getCopiaVph(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getCopiaVph(numeroUsuario);
    }

    public List getEstadoCitologia(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getEstadoCitologia(numeroUsuario);
    }

    public Cncitologi getUsuarioCitologia(Chconsulta consulta)
        throws ModelException
    {
        return clinicoDAO.getUsuarioCitologia(consulta);
    }

    public Chdatosvph getUsuarioVph(Chconsulta consulta)
        throws ModelException
    {
        return clinicoDAO.getUsuarioVph(consulta);
    }

    public List getListaDescripcionesCitologia(String cdictabla, String cdiccampo)
        throws ModelException
    {
        return clinicoDAO.getListaDescripcionesCitologia(cdictabla, cdiccampo);
    }

    public List getListaDescripcionesParametro(String cpccampo)
        throws ModelException
    {
        return clinicoDAO.getListaDescripcionesParametro(cpccampo);
    }

    public Cndesccito getDescripcionesCitologia(String cdictabla, String cdiccampo, String cdicvalor)
        throws ModelException
    {
        return clinicoDAO.getDescripcionesCitologia(cdictabla, cdiccampo, cdicvalor);
    }

    public void saveLecturaCitologia(final Cncitolect lectura,final Cnconsclin consulta,final String userName,final Integer tipoLectura)
        throws ModelException
    {
        clinicoDAO.saveLecturaCitologia(lectura,consulta,userName, tipoLectura);
    }

    public void saveLecturaVphCitologia(Cncitovphlect lectura)
        throws ModelException
    {
        clinicoDAO.saveLecturaVphCitologia(lectura);
    }

    public void saveLecturaVph(final Cncitovphlect lectura,final Cnconsclin consulta,final String userName, final String codigoProfesional)
        throws ModelException
    {
        clinicoDAO.saveLecturaVph(lectura,consulta,userName,codigoProfesional);
    }

    public Cncitolect getLecturaCitologia(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLecturaCitologia(consecutivo);
    }

    public Chvphlect getLecturaVph(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLecturaVph(consecutivo);
    }

    public Chvphcitolect getLecturaVphCitologia(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLecturaVphCitologia(consecutivo);
    }

    public Chlibrocitol getLibroCitologia(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLibroCitologia(consecutivo);
    }

    public Chlibrovph getLibroVph(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLibroVph(consecutivo);
    }

    public void saveTomaCitologia(Cncitotoma toma)
        throws ModelException
    {
        clinicoDAO.saveTomaCitologia(toma);
    }

    public Cncitotoma getTomaCitologia(Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getTomaCitologia(consecutivo);
    }
    
    public Chvphtoma getTomaVph(Integer consecutivo) throws ModelException {
        return clinicoDAO.getTomaVph(consecutivo);
    }

    public List getCitologiasParaEntregar(Cncitologi citologia)
        throws ModelException
    {
        return clinicoDAO.getCitologiasParaEntregar(citologia);
    }

    public List getVphsParaEntregar(Chdatosvph chdatosvph)
        throws ModelException
    {
        return clinicoDAO.getVphsParaEntregar(chdatosvph);
    }
    
    public void saveAntecedentesColposcopia(Chantecolpo antecedente)
        throws ModelException
    {
        clinicoDAO.saveAntecedentesColposcopia(antecedente);
    }

    public Chantecolpo getAntecedentesColposcopia(Long consclin)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesColposcopia(consclin);
    }

    public void saveReservaSangre(Chresersangr reserva)
        throws ModelException
    {
        clinicoDAO.saveReservaSangre(reserva);
    }

    public Chresersangr getReservaSangre(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getReservaSangre(consclin);
    }

    public Cpprofesio getProfesionalPorUsuario(String curcusuari, Integer cpfnclinic)
        throws ModelException
    {
        return clinicoDAO.getProfesionalPorUsuario(curcusuari, cpfnclinic);
    }

    public Cpprofesio getProfesionalPorCodigo(BigDecimal wcodmed, Integer wcodclin)
        throws ModelException
    {
        return clinicoDAO.getProfesionalPorCodigo(wcodmed, wcodclin);
    }

    public void saveInformeMamografia(Chinfomamogr informe)
        throws ModelException
    {
        clinicoDAO.saveInformeMamografia(informe);
    }

    public Chinfomamogr getInformeMamografia(Cnconsclin consclin, String tipoInforme)
        throws ModelException
    {
        return clinicoDAO.getInformeMamografia(consclin, tipoInforme);
    }

    public List getListaProfesionalesClinica(Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getListaProfesionalesClinica(codclin);
    }

    public List getListaEspecialistasClinica(Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getListaEspecialistasClinica(codclin);
    }

    public List getListaAnestesiologoClinica(Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getListaAnestesiologoClinica(codclin);
    }
    
    public List<Cpprofesio> getListaMedicoXEspecialidad(Integer codclin, Integer codEspecialidad) throws ModelException {
        return clinicoDAO.getListaMedicoXEspecialidad(codclin,codEspecialidad);
    }

    public Cpprofesio getEspecialistaXCodigo(String codprof, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getEspecialistaXCodigo(codprof, codclin);
    }

    public Cpprofesio getProfesionalXCodigo(String codprof, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getProfesionalXCodigo(codprof, codclin);
    }
    
    
    public List<Cpprofesio> getProfesionalXCodigoII(String codprof, 
                                            Integer codclin) throws ModelException {
                                            return clinicoDAO.getProfesionalXCodigoII(codprof,codclin);
                                            }
    
    

    public Cnconsclin getConsultaClinicaPorId(String idConsulta)
        throws ModelException
    {
        return clinicoDAO.getConsultaClinicaPorId(idConsulta);
    }
    
    public Integer getContratoXConsultaClinica(Long idConsulta) throws ModelException{
        return clinicoDAO.getContratoXConsultaClinica(idConsulta);
    }

    public void saveLstIngresoLiquidos(List liquidos, Long numero)
        throws ModelException
    {
        clinicoDAO.saveLstIngresoLiquidos(liquidos, numero);
    }

    public void saveLstIngresoLiquidosCanalizacion(List liquidos, Long numero, Chcanalivena canalizacion)
        throws ModelException
    {
        clinicoDAO.saveLstIngresoLiquidosCanalizacion(liquidos, numero, canalizacion);
    }

    public void updateLiquidoAdministrado(Chcontroliqu liquido)
        throws ModelException
    {
        clinicoDAO.updateLiquidoAdministrado(liquido);
    }

    public List getListaCirugiasProgramadas(Chusuario usuario, Date dia, Integer codclinica)
        throws ModelException
    {
        return clinicoDAO.getListaCirugiasProgramadas(usuario, dia, codclinica);
    }

    public List getListaCirugiasRegistroMedico(Date dia, Integer codclinica)
        throws ModelException
    {
        return clinicoDAO.getListaCirugiasRegistroMedico(dia, codclinica);
    }

    public void saveIngresoEnfermeria(Chingresoenf ingreso, Chcirugprogr cirugia)
        throws ModelException
    {
        clinicoDAO.saveIngresoEnfermeria(ingreso, cirugia);
    }

    public void saveIngresoMedico(Chingresomed ingreso)
        throws ModelException
    {
        clinicoDAO.saveIngresoMedico(ingreso);
    }

    public Chingresoenf getIngresoEnfermeria(Long hielnumero)
        throws ModelException
    {
        return clinicoDAO.getIngresoEnfermeria(hielnumero);
    }

    public Chingresomed getIngresoMedico(Long himlnumero)
        throws ModelException
    {
        return clinicoDAO.getIngresoMedico(himlnumero);
    }

    public Integer getConsecutivoLiquidos(Long numero)
        throws ModelException
    {
        return clinicoDAO.getConsecutivoLiquidos(numero);
    }

    public void deleteLiquidos(Chcontroliqu liquidos)
        throws ModelException
    {
        clinicoDAO.deleteLiquidos(liquidos);
    }

    public List getLstIngresoLiquidos(Long numero)
        throws ModelException
    {
        return clinicoDAO.getLstIngresoLiquidos(numero);
    }

    public List getLstLiquidosAdministrados(Long numero)
        throws ModelException
    {
        return clinicoDAO.getLstLiquidosAdministrados(numero);
    }

    public List getLstLiquidosAdministradoParcial(Long numero)
        throws ModelException
    {
        return clinicoDAO.getLstLiquidosAdministradoParcial(numero);
    }

    public List getLstLiquidosAdministradoEliminados(Long numero)
        throws ModelException
    {
        return clinicoDAO.getLstLiquidosAdministradoEliminados(numero);
    }

    public void saveCanalizacion(Chcanalivena canalizacion)
        throws ModelException
    {
        clinicoDAO.saveCanalizacion(canalizacion);
    }

    public Integer getConsecutivoCanalizacion(Long numero)
        throws ModelException
    {
        return clinicoDAO.getConsecutivoCanalizacion(numero);
    }

    public List getIngresoCanalizacion(Chnotaenferm nota)
        throws ModelException
    {
        return clinicoDAO.getIngresoCanalizacion(nota);
    }

    public Integer getConsecutivoNotaEnfermeria(Long numero)
        throws ModelException
    {
        return clinicoDAO.getConsecutivoNotaEnfermeria(numero);
    }

    public void saveNotaEnfermeria(Chnotaenferm nota)
        throws ModelException
    {
        clinicoDAO.saveNotaEnfermeria(nota);
    }

    public void saveRemisionHospitalizacion(Chremihospit remision)
        throws ModelException
    {
        clinicoDAO.saveRemisionHospitalizacion(remision);
    }

    public Chremihospit getRemisionHospitalizacion(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getRemisionHospitalizacion(consclin);
    }

    public Chcirugprogr getProgramarCirugia(Long numero)
        throws ModelException
    {
        return clinicoDAO.getProgramarCirugia(numero);
    }

    public void saveLstRegistroLiquidos(List orden, Long numero, List lstFormulados)
        throws ModelException
    {
        clinicoDAO.saveLstRegistroLiquidos(orden, numero, lstFormulados);
    }
    
    public void saveLstRegistroOrden(List orden, Long numero, Integer consecutivo)
        throws ModelException
    {
        clinicoDAO.saveLstRegistroOrden(orden, numero, consecutivo);
    }
    
    public void saveLstRegistroLiquidosViaOral(List liquidos, Long numero)
        throws ModelException
    {
        clinicoDAO.saveLstRegistroLiquidosViaOral(liquidos, numero);
    }

    public void saveLstRegistroLiquidosCanalizacion(List liquidos, Long numero, Chcanalivena canalizacion)
        throws ModelException
    {
        clinicoDAO.saveLstRegistroLiquidosCanalizacion(liquidos, numero, canalizacion);
    }

    public Ccfactserv getFacturaSevicio(Cnconsclin consulta)
        throws ModelException
    {
        return clinicoDAO.getFacturaSevicio(consulta);
    }

    public Ccdetafact getDetalleFacturaSevicio(Ccfactserv factura, Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getDetalleFacturaSevicio(factura, servicio);
    }

    public String getTipoContratoProfesional(Cpprofesio profesional, Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getTipoContratoProfesional(profesional, consclin);
    }

    public String getDescripcionOcupacion(Integer cocncodigo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionOcupacion(cocncodigo);
    }

    public List getExamenesImagenesConsulta(Long numero)
        throws ModelException
    {
        return clinicoDAO.getExamenesImagenesConsulta(numero);
    }

    public List getExamenesElectrofisiologicosConsulta(Long numero)
        throws ModelException
    {
        return clinicoDAO.getExamenesElectrofisiologicosConsulta(numero);
    }

    public List getExamenesLaboratoriosConsulta(Long numero)
        throws ModelException
    {
        return clinicoDAO.getExamenesLaboratoriosConsulta(numero);
    }

    public List getRemisionConsulta(Long numero, String tipoConsulta)
        throws ModelException
    {
        return clinicoDAO.getRemisionConsulta(numero, tipoConsulta);
    }

    public Chcertmedico getCertificado(Long numero, String tipo)
        throws ModelException
    {
        return clinicoDAO.getCertificado(numero, tipo);
    }

    public Chremihospit getRemisionHospitalizacion(Long numero)
        throws ModelException
    {
        return clinicoDAO.getRemisionHospitalizacion(numero);
    }

    public Chresersangr getReservaSangre(Long numero)
        throws ModelException
    {
        return clinicoDAO.getReservaSangre(numero);
    }

    public Cnprofxcon getHonorarioConsulta(Cnconsclin consclin, Cpprofesio profesional)
        throws ModelException
    {
        return clinicoDAO.getHonorarioConsulta(consclin, profesional);
    }

    public List getRemisionViolencia(String hvrcinterno)
        throws ModelException
    {
        return clinicoDAO.getRemisionViolencia(hvrcinterno);
    }

    public String getTipoRemisionViolencia(String hvicremitidoa)
        throws ModelException
    {
        return clinicoDAO.getTipoRemisionViolencia(hvicremitidoa);
    }

    public String getDescripcionRemisionViolencia(String hvicremitidoa)
        throws ModelException
    {
        return clinicoDAO.getDescripcionRemisionViolencia(hvicremitidoa);
    }

    public Long getExisteConsulta(Integer numero)
        throws ModelException
    {
        return clinicoDAO.getExisteConsulta(numero);
    }

    public Cpservicio getDescripcionCupsCompleto(String codigo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionCupsCompleto(codigo);
    }
    
    public String getNombreServicioXCodigo(String codigo) throws ModelException{
        return clinicoDAO.getNombreServicioXCodigo(codigo);
    }

    public List getAmbitoProcedimiento()
        throws ModelException
    {
        List lstAmbito = new ArrayList();
        Chambitproce ambitoObject = new Chambitproce();
        ambitoObject.setHabccodigo(Integer.valueOf(1));
        ambitoObject.setHabcdescripcio("Ambulatorio");
        lstAmbito.add(ambitoObject);
        ambitoObject = new Chambitproce();
        ambitoObject.setHabccodigo(Integer.valueOf(2));
        ambitoObject.setHabcdescripcio("En urgencia");
        lstAmbito.add(ambitoObject);
        return lstAmbito;
    }

    public String getDescripcionAmbitoProcedimiento(Integer codAmbito)
        throws ModelException
    {
        String descAmbito = "";
        if(codAmbito != null)
        {
            if(codAmbito.equals(Integer.valueOf(1)))
                descAmbito = "Ambulatorio";
            if(codAmbito.equals(Integer.valueOf(2)))
                descAmbito = "En urgencia";
        }
        return descAmbito;
    }

    public List getTipoAnestesia()
        throws ModelException
    {
        List lstTipoAnestesia = new ArrayList();
        Chtipoaneste anestesiaObject = new Chtipoaneste();
        anestesiaObject.setHtaccodigo("2");
        anestesiaObject.setHtacdescripcio("General");
        lstTipoAnestesia.add(anestesiaObject);
        anestesiaObject = new Chtipoaneste();
        anestesiaObject.setHtaccodigo("4");
        anestesiaObject.setHtacdescripcio("Regional");
        lstTipoAnestesia.add(anestesiaObject);
        anestesiaObject = new Chtipoaneste();
        anestesiaObject.setHtaccodigo("5");
        anestesiaObject.setHtacdescripcio("Sedacion");
        lstTipoAnestesia.add(anestesiaObject);
        anestesiaObject = new Chtipoaneste();
        anestesiaObject.setHtaccodigo("6");
        anestesiaObject.setHtacdescripcio("Local ");
        lstTipoAnestesia.add(anestesiaObject);
        anestesiaObject = new Chtipoaneste();
        anestesiaObject.setHtaccodigo("7");
        anestesiaObject.setHtacdescripcio("Local Controlada");
        lstTipoAnestesia.add(anestesiaObject);
        anestesiaObject = new Chtipoaneste();
        anestesiaObject.setHtaccodigo("8");
        anestesiaObject.setHtacdescripcio("Sin Antestesia");
        lstTipoAnestesia.add(anestesiaObject);
        
        return lstTipoAnestesia;
    }

    public String getDescripcionTipoAnestesia(String codAnestesia)
        throws ModelException
    {
        String descripAnes = "";
        if(codAnestesia != null)
        {
            if(codAnestesia.equals("7"))
                descripAnes = "Local Controlada";
            if(codAnestesia.equals("6"))
                descripAnes = "Local";
            if(codAnestesia.equals("5"))
                descripAnes = "Sedacion";
            if(codAnestesia.equals("4"))
                descripAnes = "Regional";
            if(codAnestesia.equals("2"))
                descripAnes = "General";
        }
        return descripAnes;
    }

    public List getAspectosDiuresis()
        throws ModelException
    {
        List lstAspecto = new ArrayList();
        Chaspectodiu aspectoObject = new Chaspectodiu();
        aspectoObject.setHadccodigo("N");
        aspectoObject.setHadcdescripcio("Normal");
        lstAspecto.add(aspectoObject);
        aspectoObject = new Chaspectodiu();
        aspectoObject.setHadccodigo("H");
        aspectoObject.setHadcdescripcio("Hemat\372rica");
        lstAspecto.add(aspectoObject);
        return lstAspecto;
    }

    public String getDescripcionAspectosDiuresis(String codAspecto)
        throws ModelException
    {
        String descripAnes = "";
        if(codAspecto != null)
        {
            if(codAspecto.equals("N"))
                descripAnes = "Normal";
            if(codAspecto.equals("H"))
                descripAnes = "Hemat\372rica";
        }
        return descripAnes;
    }

    public List getGradoDiuresis()
        throws ModelException
    {
        List lstGrado = new ArrayList();
        Chgradodiure gradoObject = new Chgradodiure();
        gradoObject.setHgdccodigo("L");
        gradoObject.setHgdcdescripcio("Leve");
        lstGrado.add(gradoObject);
        gradoObject = new Chgradodiure();
        gradoObject.setHgdccodigo("M");
        gradoObject.setHgdcdescripcio("Moderada");
        lstGrado.add(gradoObject);
        gradoObject = new Chgradodiure();
        gradoObject.setHgdccodigo("S");
        gradoObject.setHgdcdescripcio("Severa");
        lstGrado.add(gradoObject);
        return lstGrado;
    }

    public String getDescripcionGradoDiuresis(String codGrado)
        throws ModelException
    {
        String desGrado = "";
        if(codGrado != null)
        {
            if(codGrado.equals("L"))
                desGrado = "Leve";
            if(codGrado.equals("M"))
                desGrado = "Moderada";
            if(codGrado.equals("S"))
                desGrado = "Severa";
        }
        return desGrado;
    }

    public void saveEvolucion(Chevolucion evolucion)
        throws ModelException
    {
        clinicoDAO.saveEvolucion(evolucion);
    }
    
    public void saveOtraOrden(Chcontroorden otraOrden) throws ModelException {
    clinicoDAO.saveOtraOrden(otraOrden);
    }
    public List getEvolucion(Long numeroConsulta, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getEvolucion(numeroConsulta, consecutivo);
    }

    public Chevolucion getEvolucionSinCerrar(Long numeroConsulta, String userName)
        throws ModelException
    {
        return clinicoDAO.getEvolucionSinCerrar(numeroConsulta, userName);
    }

    public void closeEvolucionMedica(Long numeroCirugia, Integer consecutivo)
        throws ModelException
    {
        clinicoDAO.closeEvolucionMedica(numeroCirugia, consecutivo);
    }

    public List getUnidadesDosis()
        throws ModelException
    {
        List lstUnidades = new ArrayList();
        Chunidades unidadesObject = new Chunidades();
        unidadesObject.setHunccodigo("g");
        unidadesObject.setHuncdescripcio("Gramos");
        lstUnidades.add(unidadesObject);
        unidadesObject = new Chunidades();
        unidadesObject.setHunccodigo("mg");
        unidadesObject.setHuncdescripcio("Miligramos");
        lstUnidades.add(unidadesObject);
        unidadesObject = new Chunidades();
        unidadesObject.setHunccodigo("\265g");
        unidadesObject.setHuncdescripcio("Microgramos");
        lstUnidades.add(unidadesObject);
        unidadesObject = new Chunidades();
        unidadesObject.setHunccodigo("ui");
        unidadesObject.setHuncdescripcio("Unidad Internacional");
        lstUnidades.add(unidadesObject);
       
        return lstUnidades;
    }

    public void saveValoracionAnestesia(Chvalorprean valoracion)
        throws ModelException
    {
        clinicoDAO.saveValoracionAnestesia(valoracion);
    }

    public List getPreguntasAnestesia()
        throws ModelException
    {
        return clinicoDAO.getPreguntasAnestesia();
    }

    public void saveCuestionarioPreanestesia(List cuestionario, Long numeroConsulta)
        throws ModelException
    {
        clinicoDAO.saveCuestionarioPreanestesia(cuestionario, numeroConsulta);
    }

    public String getDescripcionCuestionarioAnestesia(Integer hpancodigo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionCuestionarioAnestesia(hpancodigo);
    }

    public List getCuestionarioPreanestesia(Long idConsulta)
        throws ModelException
    {
        return clinicoDAO.getCuestionarioPreanestesia(idConsulta);
    }

    public void saveResultadosParaclinicos(Chresulparac resultados)
        throws ModelException
    {
        clinicoDAO.saveResultadosParaclinicos(resultados);
    }

    public Chresulparac getResultadosParaclinicos(Long idConsulta)
        throws ModelException
    {
        return clinicoDAO.getResultadosParaclinicos(idConsulta);
    }

    public void saveControlMedicamento(Chformulahos formula, Chcontrmedic control)
        throws ModelException
    {
        clinicoDAO.saveControlMedicamento(formula, control);
    }

    public void saveControlMedicamentoNota(Chformulahos formula, Chcontrmedic control, Chnotaenferm nota)
        throws ModelException
    {
        clinicoDAO.saveControlMedicamentoNota(formula, control, nota);
    }

    public String getEtapaActualNotaEnfermeria(Long numeroCirugia)
        throws ModelException
    {
        return clinicoDAO.getEtapaActualNotaEnfermeria(numeroCirugia);
    }

    public Chordecirugi getOrdenCirugia(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getOrdenCirugia(numeroCirugia, tipoServicio, consecutivo);
    }
    
    public Chcontroorden getOtrasOrdenCirugia(Long numeroCirugia, 
                                       
                                        Integer consecutivo) throws ModelException{
                                        
                                            return clinicoDAO.getOtrasOrdenCirugia(numeroCirugia,consecutivo);
                                            
                                        }

    public List getListPrescripciones(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getListPrescripciones(numeroCirugia, tipoServicio, consecutivo);
    }

    public Chincapacida getIncapcidad(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getIncapcidad(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getExamenesLaboratorios(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getExamenesLaboratorios(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getExamenesImagenes(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getExamenesImagenes(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getExamenesElectrofisiologicos(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getExamenesElectrofisiologicos(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getRemisionConsulta(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getRemisionConsulta(numeroCirugia, tipoServicio, consecutivo);
    }

    public Chcertmedico getCertificado(Long numeroCirugia, String tipoServicio, Integer consecutivo, String tipo)
        throws ModelException
    {
        return clinicoDAO.getCertificado(numeroCirugia, tipoServicio, consecutivo, tipo);
    }

    public Chresersangr getReservaSangre(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getReservaSangre(numeroCirugia, tipoServicio, consecutivo);
    }

    public Chremihospit getRemisionHospitalizacion(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getRemisionHospitalizacion(numeroCirugia, tipoServicio, consecutivo);
    }

    public Chconducta getConducta(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getConducta(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getLstFormulaLiquidos(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLstFormulaLiquidos(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getLstFormulaHospitalizacion(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLstFormulaHospitalizacion(numeroCirugia, tipoServicio, consecutivo);
    }
    
    public List<Chcontroorden> getLstOtrasOrdenes(Long numeroCirugia, 
                                                           Integer consecutivo) throws ModelException{
                                                               
                                                               return clinicoDAO.getLstOtrasOrdenes(numeroCirugia,consecutivo);
                                                           }
    

    public Chmedidapoyo getMedidasApoyo(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getMedidasApoyo(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getLstMedicamentosEspeciales(Long numeroCirugia, String tipoServicio, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getLstMedicamentosEspeciales(numeroCirugia, tipoServicio, consecutivo);
    }

    public List getCirugiaProgramadaEpicrisis(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getCirugiaProgramadaEpicrisis(usuario);
    }

    public List getTipoUsuario()
        throws ModelException
    {
        List lstTipoUsuario = new ArrayList();
        Chtipousuari tipoUsuarioObject = new Chtipousuari();
        tipoUsuarioObject.setHtuccodigo("P");
        tipoUsuarioObject.setHtucdescripcio("Particular");
        lstTipoUsuario.add(tipoUsuarioObject);
        tipoUsuarioObject = new Chtipousuari();
        tipoUsuarioObject.setHtuccodigo("I");
        tipoUsuarioObject.setHtucdescripcio("Institucional");
        lstTipoUsuario.add(tipoUsuarioObject);
        tipoUsuarioObject = new Chtipousuari();
        tipoUsuarioObject.setHtuccodigo("C");
        tipoUsuarioObject.setHtucdescripcio("Convenios");
        lstTipoUsuario.add(tipoUsuarioObject);
        return lstTipoUsuario;
    }

    public String getDescripcionTipoUsuario(String tipoUsuario)
        throws ModelException
    {
        String descrTipoUsuario = "";
        if(tipoUsuario != null)
        {
            if(tipoUsuario.equals("P"))
                descrTipoUsuario = "Particular";
            if(tipoUsuario.equals("I"))
                descrTipoUsuario = "Institucional";
            if(tipoUsuario.equals("C"))
                descrTipoUsuario = "Convenios";
        }
        return descrTipoUsuario;
    }

    public void saveEncabezadoRegistroAnestesia(Chanestesia anestesia)
        throws ModelException
    {
        clinicoDAO.saveEncabezadoRegistroAnestesia(anestesia);
    }

    public Chanestesia getEncabezadoRegistroAnestesia(Long hanlnumero)
        throws ModelException
    {
        return clinicoDAO.getEncabezadoRegistroAnestesia(hanlnumero);
    }

    public void saveMonitorAnestesia(Chmonitoria monitoria)
        throws ModelException
    {
        clinicoDAO.saveMonitorAnestesia(monitoria);
    }

    public Chmonitoria getMonitoriaAnestesia(Long hmolnumero)
        throws ModelException
    {
        return clinicoDAO.getMonitoriaAnestesia(hmolnumero);
    }

    public void saveTecnicaAnestesia(Chtecnianest tecnica)
        throws ModelException
    {
        clinicoDAO.saveTecnicaAnestesia(tecnica);
    }

    public Chtecnianest getTecnicaAnestesia(Long htalnumero)
        throws ModelException
    {
        return clinicoDAO.getTecnicaAnestesia(htalnumero);
    }

    public Chexamfisico getUltimoExamenFisicoUsuario(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getUltimoExamenFisicoUsuario(numeroUsuario);
    }

    public Chimprdiag getUltimoImpresionDiagnosticaUsuario(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getUltimoImpresionDiagnosticaUsuario(numeroUsuario);
    }

    public Chevolucion getUltimaEvolucionConsulta(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getUltimaEvolucionConsulta(numeroConsulta);
    }

    public Chconducta getUltimaConductaConsulta(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getUltimaConductaConsulta(numeroConsulta);
    }

    public Chconsulta getUltimaConsultaExternaUsuario(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getUltimaConsultaExternaUsuario(numeroUsuario);
    }

    public Chantegineco getUltimoAntecedentesGinecologicos(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getUltimoAntecedentesGinecologicos(numeroUsuario);
    }

    public void saveMedidaProfilactica(Chposicanest medida)
        throws ModelException
    {
        clinicoDAO.saveMedidaProfilactica(medida);
    }

    public Chposicanest getMedidaProfilactica(Long hpalnumero)
        throws ModelException
    {
        return clinicoDAO.getMedidaProfilactica(hpalnumero);
    }

    public void saveControlViaAerea(Chventiaerea viaaerea)
        throws ModelException
    {
        clinicoDAO.saveControlViaAerea(viaaerea);
    }

    public Chventiaerea getControlViaAerea(Long hvalnumero)
        throws ModelException
    {
        return clinicoDAO.getControlViaAerea(hvalnumero);
    }

    public List getLiquidoParenterales()
        throws ModelException
    {
        List lstParenterales = new ArrayList();
        Chliquiparen liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("01");
        liquidoObject.setHlpcdescripcio("Lactato de Ringer");
        lstParenterales.add(liquidoObject);
        liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("02");
        liquidoObject.setHlpcdescripcio("Haemacell");
        lstParenterales.add(liquidoObject);
        liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("03");
        liquidoObject.setHlpcdescripcio("Dextranes");
        lstParenterales.add(liquidoObject);
        liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("04");
        liquidoObject.setHlpcdescripcio("Globulos Rojos");
        lstParenterales.add(liquidoObject);
        liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("05");
        liquidoObject.setHlpcdescripcio("Sangre total");
        lstParenterales.add(liquidoObject);
        liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("06");
        liquidoObject.setHlpcdescripcio("Plasma");
        lstParenterales.add(liquidoObject);
        liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("07");
        liquidoObject.setHlpcdescripcio("Plaquetas");
        lstParenterales.add(liquidoObject);
        liquidoObject = new Chliquiparen();
        liquidoObject.setHlpccodigo("08");
        liquidoObject.setHlpcdescripcio("Soluci�n Salina");
        lstParenterales.add(liquidoObject);
        
        
        return lstParenterales;
    }

    public String getDescripcionLiquidoParenteral(String codigo)
        throws ModelException
    {
        String descripcion = "";
        if(codigo != null)
            if(codigo.equals("01"))
                descripcion = "Lactato de Ringer";
            else
            if(codigo.equals("02"))
                descripcion = "Haemacell";
            else
            if(codigo.equals("03"))
                descripcion = "Dextranes";
            else
            if(codigo.equals("04"))
                descripcion = "Globulos Rojos";
            else
            if(codigo.equals("05"))
                descripcion = "Sangre total";
            else
            if(codigo.equals("06"))
                descripcion = "Plasma";
            else
            if(codigo.equals("07"))
                descripcion = "Plaquetas";
            else
            if(codigo.equals("08"))
                descripcion = "Soluci�n Salina";
        return descripcion;
    }

    public void saveMedicamentosAnestesia(List lstMedicamento, Long numeroCirugia, String tipoServicio)
        throws ModelException
    {
        clinicoDAO.saveMedicamentosAnestesia(lstMedicamento, numeroCirugia, tipoServicio);
    }

    public List getMedicamentosAnestesia(Long numeroCirugia, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getMedicamentosAnestesia(numeroCirugia, tipoServicio);
    }

    public Crripsserv getParametrosRipsXClinica(Cnconsclin consclin)
        throws ModelException
    {
        return clinicoDAO.getParametrosRipsXClinica(consclin);
    }

    public Crarcproce getRipsCitologia(Cnconsclin consulta)
        throws ModelException
    {
        return clinicoDAO.getRipsCitologia(consulta);
    }

    public List getCuestionarioEsterilizacion(Long idConsulta)
        throws ModelException
    {
        return clinicoDAO.getCuestionarioEsterilizacion(idConsulta);
    }

    public void saveCuestionarioEsterilizacion(Chcuestester chcuestester)
        throws ModelException
    {
        clinicoDAO.saveCuestionarioEsterilizacion(chcuestester);
    }

    public List getCitologiaLectura(Date fechaInicial, Date fechafinal, int codCentro, String tipoLectura,final List<Integer> listaTipoHistoria )
        throws ModelException
    {
        return clinicoDAO.getCitologiaLectura(fechaInicial, fechafinal, codCentro, tipoLectura,listaTipoHistoria);
    }

    public List getVphLectura(Date fechaInicial, Date fechafinal, int codCentro, String tipoLectura)
        throws ModelException
    {
        return clinicoDAO.getVphLectura(fechaInicial, fechafinal, codCentro, tipoLectura);
    }

    public Cpprofesio getProfesionalesLectura(int codCentro, BigDecimal codProf)
        throws ModelException
    {
        return clinicoDAO.getProfesionalesLectura(codCentro, codProf);
    }

    public BigDecimal saveListaEntregaCitologia(Chentregacitol entregacitol)
        throws ModelException
    {
        return clinicoDAO.saveListaEntregaCitologia(entregacitol);
    }

    public Long saveListaEntregaVph(Chentregavph chentregavph)
        throws ModelException
    {
        return clinicoDAO.saveListaEntregaVph(chentregavph);
    }

    public List getListadoCitologias(Integer idListado, String tipoLectura)
        throws ModelException
    {
        return clinicoDAO.getListadoCitologias(idListado, tipoLectura);
    }

    public void saveDetalleListaCitologias(List detalleCitol)
        throws ModelException
    {
        clinicoDAO.saveDetalleListaCitologias(detalleCitol);
    }

    public List getCitologiaLecturaDos(Integer idListado)
        throws ModelException
    {
        return clinicoDAO.getCitologiaLecturaDos(idListado);
    }

    public void saveEnvioCitologias(Chentregacitol entregacitol)
        throws ModelException
    {
        clinicoDAO.saveEnvioCitologias(entregacitol);
    }

    public List getCitologiasEntregadas(Date fechaInicial, Date fechaFin, int codCentro)
        throws ModelException
    {
        return clinicoDAO.getCitologiasEntregadas(fechaInicial, fechaFin, codCentro);
    }

    public List getPatologosLecturas(Chproflect profesionalLectura)
        throws ModelException
    {
        return clinicoDAO.getPatologosLecturas(profesionalLectura);
    }

    public List getClinicas()
        throws ModelException
    {
        return clinicoDAO.getClinicas();
    }

    public List getListaProfesionalesXClinica(Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getListaProfesionalesXClinica(codclin);
    }

    public void saveProfesionalLectura(Chproflect profLectura)
        throws ModelException
    {
        clinicoDAO.saveProfesionalLectura(profLectura);
    }

    public void saveAplicacionRetiroDispositivo(final Chdispoaplic dispositivo,final List<Cfdetafactura> listaServicios)
        throws ModelException
    {
        clinicoDAO.saveAplicacionRetiroDispositivo(dispositivo,listaServicios);
    }

    public Chdispoaplic getAplicacionRetiroDispositivo(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAplicacionRetiroDispositivo(numeroConsulta);
    }

    public List getSeguimientoCitologias(Date fechaInicial, Date fechaFin, Integer codclinica)
        throws ModelException
    {
        return clinicoDAO.getSeguimientoCitologias(fechaInicial, fechaFin, codclinica);
    }

//    public List getSeguimientoVphs(Date fechaInicial, Date fechaFin, Integer codclinica)
//        throws ModelException
//    {
//        return clinicoDAO.getSeguimientoVphs(fechaInicial, fechaFin, codclinica);
//    }

    public void savePlantillaUsuario(List lstPlantillas, String username)
        throws ModelException
    {
        clinicoDAO.savePlantillaUsuario(lstPlantillas, username);
    }

    public List getPlantillaUsuario(String username)
        throws ModelException
    {
        return clinicoDAO.getPlantillaUsuario(username);
    }

    public List getPlantillaUsuarioCriterios(String username, Chplantilla plantilla)
        throws ModelException
    {
        return clinicoDAO.getPlantillaUsuarioCriterios(username, plantilla);
    }

    public List getConsultasClinicasXDia(Date date, Integer sala, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getConsultasClinicasXDia(date, sala, codclin);
    }

    public void saveOrUpdatePatologia(Chotraspatolog pat)
        throws ModelException
    {
        clinicoDAO.saveOrUpdatePatologia(pat);
    }

    public Chotraspatolog getOtrasPatolog(Chotraspatolog pat)
        throws ModelException
    {
        return clinicoDAO.getOtrasPatolog(pat);
    }

    public Object getInfoFactura(Integer clinica, Integer tipDoc, Integer numDoc)
        throws ModelException
    {
        return clinicoDAO.getInfoFactura(clinica, tipDoc, numDoc);
    }

    public List getDetalleFact(Integer tipDoc, Integer numConsecutivo)
        throws ModelException
    {
        return clinicoDAO.getDetalleFact(tipDoc, numConsecutivo);
    }

    public Cpservicio getServicioClinico(Cpservicio serv)
        throws ModelException
    {
        return clinicoDAO.getServicioClinico(serv);
    }

    public List getPatologiasLectura(Date fechaInicial, Date fechafinal, int codCentro, int patologo)
        throws ModelException
    {
        return clinicoDAO.getPatologiasLectura(fechaInicial, fechafinal, codCentro, patologo);
    }

    public Cpprofesio getProfesionalesPatologia(int codCentro, Integer codProf)
        throws ModelException
    {
        return clinicoDAO.getProfesionalesPatologia(codCentro, codProf);
    }

    public BigDecimal saveListaEntregaPatologia(Chentregapatol entregapatol)
        throws ModelException
    {
        return clinicoDAO.saveListaEntregaPatologia(entregapatol);
    }

    public List getSalasEspera(Integer codclin, String userName)
        throws ModelException
    {
        return clinicoDAO.getSalasEspera(codclin, userName);
    }

    public List getConsultasProfesional(Date dia, Integer idMedico, Integer codclinica, Integer numsala)
        throws ModelException
    {
        return clinicoDAO.getConsultasProfesional(dia, idMedico, codclinica, numsala);
    }

    public List getConsultasProfesionalBySala(Date dia, BigDecimal idMedico, Integer codclinica, Integer numsala)
        throws ModelException
    {
        return clinicoDAO.getConsultasProfesionalBySala(dia, idMedico, codclinica, numsala);
    }

    public List getServiciosPorProfesional(Integer codclin, Integer codmed, String wprio)
        throws ModelException
    {
        return clinicoDAO.getServiciosPorProfesional(codclin, codmed, wprio);
    }
    
    
    public List getServiciosPorProfesionalXContrato(Integer codclin, BigDecimal codmed, Cpservicio servicio,Integer codigocontrato) throws ModelException {
        return clinicoDAO.getServiciosPorProfesionalXContrato(codclin,codmed, servicio,codigocontrato);
    }

    public void asignarPrioridad(Integer wcodcli, Integer wcodmed, List lstServicios)
        throws ModelException
    {
        clinicoDAO.asignarPrioridad(wcodcli, wcodmed, lstServicios);
    }

    public void saveProfesionalPrioridad(List listaProfesionalPrioridad, Integer wcodclin)
        throws ModelException
    {
        clinicoDAO.saveProfesionalPrioridad(listaProfesionalPrioridad, wcodclin);
    }

    public List getPrioridadProfesional(Integer wcodclin)
        throws ModelException
    {
        return clinicoDAO.getPrioridadProfesional(wcodclin);
    }

    public Integer getSalaXservicioProfesional(Integer wclipro, String wcodpro)
        throws ModelException
    {
        return clinicoDAO.getSalaXservicioProfesional(wclipro, wcodpro);
    }

    public void saveCuestionarioCervix(Chcancecervi cervix)
        throws ModelException
    {
        clinicoDAO.saveCuestionarioCervix(cervix);
    }

    public Chcancecervi getCuestionarioCervix(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getCuestionarioCervix(numeroConsulta, tipoServicio);
    }

    public void saveAntecedentePsicologia(Chpsicoantec antecedente)
        throws ModelException
    {
        clinicoDAO.saveAntecedentePsicologia(antecedente);
    }

    public Chpsicoantec getAntecedentePsicologia(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getAntecedentePsicologia(numeroConsulta, tipoServicio);
    }

    public void saveEvaluacionGeneral(Chevalugener evaluacion)
        throws ModelException
    {
        clinicoDAO.saveEvaluacionGeneral(evaluacion);
    }

    public Chevalugener getEvaluacionGeneral(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getEvaluacionGeneral(numeroConsulta, tipoServicio);
    }

    public void savePlanTratamiento(Chpladetrat plan)
        throws ModelException
    {
        clinicoDAO.savePlanTratamiento(plan);
    }

    public Chpladetrat getPlanTratamiento(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getPlanTratamiento(numeroConsulta, tipoServicio);
    }

    public void saveSeguimientoPsicologia(Chseguipsico seguimiento)
        throws ModelException
    {
        clinicoDAO.saveSeguimientoPsicologia(seguimiento);
    }

    public Chseguipsico getSeguimientoPsicologia(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getSeguimientoPsicologia(numeroConsulta, tipoServicio);
    }

    public void saveAplicacionCervix(Chcervaaplic aplicacion)
        throws ModelException
    {
        clinicoDAO.saveAplicacionCervix(aplicacion);
    }

            public void saveAplicacionMedicamento(final List<Chmedicament> medicamento, final Long numeroConsulta, final String usuario) throws ModelException{
        clinicoDAO.saveAplicacionMedicamento(medicamento,numeroConsulta,usuario);
    }

    public Chcervaaplic getAplicacionCervix(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getAplicacionCervix(numeroConsulta, tipoServicio);
    }

    public  List<Chmedicament> getAdministracionMedicamento(Long numeroConsulta, Integer consecutivo)
        throws ModelException
    {
        return clinicoDAO.getAdministracionMedicamento(numeroConsulta, consecutivo);
    }

    public Chcervaaplic getAplicacionCervixPrimera(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getAplicacionCervixPrimera(numeroUsuario);
    }

    public Chcervaaplic getAplicacionCervixSegunda(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getAplicacionCervixSegunda(numeroUsuario);
    }

    public List getPatologosGeneral(Chprofpatol profesionalLectura)
        throws ModelException
    {
        return clinicoDAO.getPatologosGeneral(profesionalLectura);
    }

    public void saveProfesionalGeneral(Chprofpatol profPatologia)
        throws ModelException
    {
        clinicoDAO.saveProfesionalGeneral(profPatologia);
    }

    public List getListadoPatologias(Chdetaentpatol detaentpatol)
        throws ModelException
    {
        return clinicoDAO.getListadoPatologias(detaentpatol);
    }

    public void saveDetalleListaPatologias(List detallePatol)
        throws ModelException
    {
        clinicoDAO.saveDetalleListaPatologias(detallePatol);
    }

    public List getListaEntregaPatol(Chentregapatol entregapatol)
        throws ModelException
    {
        return clinicoDAO.getListaEntregaPatol(entregapatol);
    }

    public void saveCabeceraListaEnvio(Chentregapatol chentregapatol)
        throws ModelException
    {
        clinicoDAO.saveCabeceraListaEnvio(chentregapatol);
    }

    public void saveEsterilizacionMasculina(Chestermascu esterilizacion)
        throws ModelException
    {
        clinicoDAO.saveEsterilizacionMasculina(esterilizacion);
    }

    public Chestermascu getEsterilizacionMasculina(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getEsterilizacionMasculina(numeroUsuario);
    }

    public void updateClinicaUsuario(Integer clinica, String userName)
        throws ModelException
    {
        clinicoDAO.updateClinicaUsuario(clinica, userName);
    }

    public Integer getClinicaActiva(String userName)
        throws ModelException
    {
        return clinicoDAO.getClinicaActiva(userName);
    }

    public void liberarConsultaClinica(List lstUsuariosSeleccionados, String userName)
        throws ModelException
    {
        clinicoDAO.liberarConsultaClinica(lstUsuariosSeleccionados, userName);
    }

    public List getConsultasCerradasProfesional(String userName, Long numeroUsuario, Date fechaConsulta)
        throws ModelException
    {
        return clinicoDAO.getConsultasCerradasProfesional(userName, numeroUsuario, fechaConsulta);
    }

    public void saveSolicitudAnulacion(Chsolicanula solicitud)
        throws Exception
    {
        clinicoDAO.saveSolicitudAnulacion(solicitud);
    }

    public List getSolicitudesAnulacionClinica(Integer codclin)
        throws Exception
    {
        return clinicoDAO.getSolicitudesAnulacionClinica(codclin);
    }

    public void updateSolicitudAnulacion(Chsolicanula solicitud)
        throws Exception
    {
        clinicoDAO.updateSolicitudAnulacion(solicitud);
    }

    public void saveLogImpresionHistorias(Chlogimpresi logimpresion)
        throws Exception
    {
        clinicoDAO.saveLogImpresionHistorias(logimpresion);
    }

    public boolean verificarCitologia(Integer numeroCitologia)
        throws Exception
    {
        return clinicoDAO.verificarCitologia(numeroCitologia);
    }

    public List getCitologiasImpresionUsuario(String userName, Integer codclin, Date dia)
        throws Exception
    {
        return clinicoDAO.getCitologiasImpresionUsuario(userName, codclin, dia);
    }

    public List getConsultasSinCerrar(String userName, Integer codclin, Date dia)
        throws Exception
    {
        return clinicoDAO.getConsultasSinCerrar(userName, codclin, dia);
    }

    public List getComboPatologos(Chprofpatol profesionalLectura)
        throws ModelException
    {
        return clinicoDAO.getComboPatologos(profesionalLectura);
    }

    public List getAntecedentesGinecologicoValoracion(Date fechaInicial, Date fechaFinal, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getAntecedentesGinecologicoValoracion(fechaInicial, fechaFinal, codclin);
    }

    public List getReporteActividadesEducativas(Date fechaInicial, Date fechaFinal, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getReporteActividadesEducativas(fechaInicial, fechaFinal, codclin);
    }

    public String getCompromisosPsicologiaByUsuario(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getCompromisosPsicologiaByUsuario(numeroUsuario);
    }

    public List getConsultasSinCerrarClinica(Integer codclin, Date fechaInicial, Date fechaFinal)
        throws ModelException
    {
        return clinicoDAO.getConsultasSinCerrarClinica(codclin, fechaInicial, fechaFinal);
    }

    public String getDescripcionActoQuirurgico(Integer caqncodigo)
        throws ModelException
    {
        return clinicoDAO.getDescripcionActoQuirurgico(caqncodigo);
    }

    public List getFoliosUsuarioIncompleto(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getFoliosUsuarioIncompleto(numeroUsuario);
    }

    public List getTipoUsuarioClinico(Integer codigo)
        throws ModelException
    {
        return clinicoDAO.getTipoUsuarioClinico(codigo);
    }

    public List getCvcontratoClinico(Integer codigo)
        throws ModelException
    {
        return clinicoDAO.getCvcontratoClinico(codigo);
    }

    public List getDatosRipsConsulta(Date fechaInicial, Date fechaFinal, Integer codclin, Integer tipoUsuario, String codservicio)
        throws ModelException
    {
        return clinicoDAO.getDatosRipsConsulta(fechaInicial, fechaFinal, codclin, tipoUsuario, codservicio);
    }

    public Chremisilve getRemisionIlve(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getRemisionIlve(numeroConsulta, tipoServicio);
    }

    public void saveRemisionIlve(Chremisilve remision)
        throws ModelException
    {
        clinicoDAO.saveRemisionIlve(remision);
    }

    public Chestadpsico getEstadoPsicoemocional(Long numeroConsulta, String tipoServicio)
        throws ModelException
    {
        return clinicoDAO.getEstadoPsicoemocional(numeroConsulta, tipoServicio);
    }

    public void saveEstadoPsicoemocional(Chestadpsico evaluacion)
        throws ModelException
    {
        clinicoDAO.saveEstadoPsicoemocional(evaluacion);
    }

    public void saveColposcopia(Chcolposcopia colposcopia)
        throws ModelException
    {
        clinicoDAO.saveColposcopia(colposcopia);
    }

    public Chcolposcopia getColposcopia(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getColposcopia(numeroConsulta);
    }

    public List getServiciosAnexosControlSinCosto(String serorigen)
        throws ModelException
    {
        return clinicoDAO.getServiciosAnexosControlSinCosto(serorigen);
    }

    public List getMotivoRetiroImplante()
        throws ModelException
    {
        List tipoMotivoRetiro = new ArrayList();
        Chmotivretir motivoRetiro = new Chmotivretir();
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("ADM");
        motivoRetiro.setCmrcdescripcio("Actualizacion del metodo");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("APS");
        motivoRetiro.setCmrcdescripcio("Alteraciones del patr\363n de sangrado");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("ADE");
        motivoRetiro.setCmrcdescripcio("Alteraciones dermatol\363gicos");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("AME");
        motivoRetiro.setCmrcdescripcio("Alteraciones menstruales");
        motivoRetiro.setCmreestado("IN");
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("ALV");
        motivoRetiro.setCmrcdescripcio("Alteraciones Vasculares ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("ADP");
        motivoRetiro.setCmrcdescripcio("Aumento de peso");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("CMD");
        motivoRetiro.setCmrcdescripcio("Cambio a m\351todo definitivo");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("CMT");
        motivoRetiro.setCmrcdescripcio("Cambio a otro m\351todo temporal");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("CEF");
        motivoRetiro.setCmrcdescripcio("Cefalea");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("DEM");
        motivoRetiro.setCmrcdescripcio("Deseo embarazo");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("DME");
        motivoRetiro.setCmrcdescripcio("Dismenorrea ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("DPA");
        motivoRetiro.setCmrcdescripcio("Dispareunia ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("DSI");
        motivoRetiro.setCmrcdescripcio("Dolor en sitio de inserci\363n ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("DCS");
        motivoRetiro.setCmrcdescripcio("Dolor o congesti\363n en los senos");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("EPI");
        motivoRetiro.setCmrcdescripcio("E.P.I.");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("EMB");
        motivoRetiro.setCmrcdescripcio("Embarazo");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("EXP");
        motivoRetiro.setCmrcdescripcio("Expulsi\363n parcial ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("EXT");
        motivoRetiro.setCmrcdescripcio("Expulsi\363n total ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("IVU");
        motivoRetiro.setCmrcdescripcio("Infecci\363n V\355as Urinarias a repetici\363n ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("ICM");
        motivoRetiro.setCmrcdescripcio("Insatisfacci\363n con el m\351todo.");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("IEE");
        motivoRetiro.setCmrcdescripcio("Inserci\363n en embarazo ");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("NDP");
        motivoRetiro.setCmrcdescripcio("No desea planificar");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("PCM");
        motivoRetiro.setCmrcdescripcio("Pareja con m\351todo permanente");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("PDP");
        motivoRetiro.setCmrcdescripcio("P\351rdida de peso");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("PDE");
        motivoRetiro.setCmrcdescripcio("Problemas dermatol\363gicos");
        motivoRetiro.setCmreestado("IN");
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("QUI");
        motivoRetiro.setCmrcdescripcio("Quistes");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("RAC");
        motivoRetiro.setCmrcdescripcio("Resultados anormales de citologia vaginal");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("VAR");
        motivoRetiro.setCmrcdescripcio("Vaginosis a repetici\363n");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        motivoRetiro = new Chmotivretir();
        motivoRetiro.setCmrccodigo("VDM");
        motivoRetiro.setCmrcdescripcio("Vencimiento del Metodo");
        motivoRetiro.setCmreestado("VG");
        tipoMotivoRetiro.add(motivoRetiro);
        return tipoMotivoRetiro;
    }

    public String getDescripcionRetiroImplante(String codigo)
        throws ModelException
    {
        String descripcion = "";
        if(codigo != null)
            if(codigo.equals("ICM"))
                descripcion = "Insatisfacci\363n con el m\351todo";
            else
            if(codigo.equals("DEM"))
                descripcion = "Deseo embarazo ";
            else
            if(codigo.equals("CEF"))
                descripcion = "Cefalea ";
            else
            if(codigo.equals("DCS"))
                descripcion = "Dolor o congesti\363n en los senos";
            else
            if(codigo.equals("CMD"))
                descripcion = "Cambio a m\351todo definitivo";
            else
            if(codigo.equals("CMT"))
                descripcion = "Cambio a otro m\351todo temporal";
            else
            if(codigo.equals("QUI"))
                descripcion = "Quistes";
            else
            if(codigo.equals("APS"))
                descripcion = "Alteraciones del patr\363n de sangrado";
            else
            if(codigo.equals("ADP"))
                descripcion = "Aumento de peso";
            else
            if(codigo.equals("PDP"))
                descripcion = "P\351rdida de peso";
            else
            if(codigo.equals("ADE"))
                descripcion = "Alteraciones dermatol\363gicos";
            else
            if(codigo.equals("ADM"))
                descripcion = "Actualizaci\363n del m\351todo";
            else
            if(codigo.equals("EPI"))
                descripcion = "E.P.I.";
            else
            if(codigo.equals("VAR"))
                descripcion = "Vaginosis a repetici\363n";
            else
            if(codigo.equals("IEE"))
                descripcion = "Inserci\363n en embarazo";
            else
            if(codigo.equals("DSI"))
                descripcion = "Dolor en sitio de inserci\363n";
            else
            if(codigo.equals("EXP"))
                descripcion = "Expulsi\363n parcial";
            else
            if(codigo.equals("EXT"))
                descripcion = " Expulsi\363n total";
            else
            if(codigo.equals("ALV"))
                descripcion = "Alteraciones Vasculares ";
            else
            if(codigo.equals("DPA"))
                descripcion = "Disparencia";
            else
            if(codigo.equals("DME"))
                descripcion = "Dismenorrea";
            else
            if(codigo.equals("IVU"))
                descripcion = "Infecci\363n V\355as Urinarias a repetici\363n";
            else
            if(codigo.equals("IVU"))
                descripcion = "Resultados anormales de citologia vaginal";
            else
            if(codigo.equals("PDE"))
                descripcion = "Problemas dermatol\363gicos";
            else
            if(codigo.equals("AME"))
                descripcion = "Alteraciones menstruales";
            else
            if(codigo.equals("EMB"))
                descripcion = "Embarazo";
            else
            if(codigo.equals("NDP"))
                descripcion = "No desea planificar";
            else
            if(codigo.equals("PCM"))
                descripcion = "Pareja con m\351todo permanente";
            else
            if(codigo.equals("VDM"))
                descripcion = "Vencimiento del Metodo";
        return descripcion;
    }

    public List getOportunidadEntregaGeneral(Date fechaInicial, Date fechaFinal, Integer clinica)
        throws ModelException
    {
        return clinicoDAO.getOportunidadEntregaGeneral(fechaInicial, fechaFinal, clinica);
    }

    public List getReportePorcentajeManual(Date fechaInicial, Date fechaFinal, Integer clinica, BigDecimal codMedico, Integer numeroSala, String wservicio)
        throws ModelException
    {
        return clinicoDAO.getReportePorcentajeManual(fechaInicial, fechaFinal, clinica, codMedico, numeroSala, wservicio);
    }

    public List getListaHistoriaIntervencionAsesoria(Integer dependencia)
        throws ModelException
    {
        return clinicoDAO.getListaHistoriaIntervencionAsesoria(dependencia);
    }

    public String getDescripcionIntervencionAsesoriaXid(Integer ctinnumero)
        throws ModelException
    {
        return clinicoDAO.getDescripcionIntervencionAsesoriaXid(ctinnumero);
    }

    public List getListaConocimientoAvise()
        throws ModelException
    {
        List lstConocimiento = new ArrayList();
        Cnconocavise conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(1));
        conocimientoObject.setCcacdescripcio("Radio");
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(2));
        conocimientoObject.setCcacdescripcio("Televisi\363n");
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(3));
        conocimientoObject.setCcacdescripcio("Internet");
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(4));
        conocimientoObject.setCcacdescripcio("Revistas");
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(7));
        conocimientoObject.setCcacdescripcio("Informaci\363n Centro");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(8));
        conocimientoObject.setCcacdescripcio("Brigada m\363vil");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(5));
        conocimientoObject.setCcacdescripcio("Conocido");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(9));
        conocimientoObject.setCcacdescripcio("Consulta de Psicolog\355a");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(10));
        conocimientoObject.setCcacdescripcio("Consulta m\351dica");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(11));
        conocimientoObject.setCcacdescripcio("P. de embarazo institucional");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(12));
        conocimientoObject.setCcacdescripcio("L\355nea 018000");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(13));
        conocimientoObject.setCcacdescripcio("Redes sociales");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(14));
        conocimientoObject.setCcacdescripcio("Plegable institucional");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(15));
        conocimientoObject.setCcacdescripcio("Pagina web");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(16));
        conocimientoObject.setCcacdescripcio("Campa\361a IVE");
        lstConocimiento.add(conocimientoObject);
        conocimientoObject = new Cnconocavise();
        conocimientoObject.setCcancodigo(Integer.valueOf(6));
        conocimientoObject.setCcacdescripcio("Otro");
        lstConocimiento.add(conocimientoObject);
        return lstConocimiento;
    }

    public String getDescripcionConocimientoAvise(Integer codigo)
        throws ModelException
    {
        String descAvise = "";
        if(codigo != null)
            if(codigo.equals(Integer.valueOf(1)))
                descAvise = "Radio";
            else
            if(codigo.equals(Integer.valueOf(2)))
                descAvise = "Televisi\363n";
            else
            if(codigo.equals(Integer.valueOf(3)))
                descAvise = "Internet";
            else
            if(codigo.equals(Integer.valueOf(4)))
                descAvise = "Revistas";
            else
            if(codigo.equals(Integer.valueOf(5)))
                descAvise = "Conocido";
            else
            if(codigo.equals(Integer.valueOf(6)))
                descAvise = "Otro";
            else
            if(codigo.equals(Integer.valueOf(7)))
                descAvise = "Informaci\363n Centro";
            else
            if(codigo.equals(Integer.valueOf(8)))
                descAvise = "Brigada m\363vil";
            else
            if(codigo.equals(Integer.valueOf(9)))
                descAvise = "Consulta de Psicolog\355a";
            else
            if(codigo.equals(Integer.valueOf(10)))
                descAvise = "Consulta m\351dica";
            else
            if(codigo.equals(Integer.valueOf(11)))
                descAvise = "P. de embarazo institucional";
            else
            if(codigo.equals(Integer.valueOf(12)))
                descAvise = "L\355nea 018000";
            else
            if(codigo.equals(Integer.valueOf(13)))
                descAvise = "Redes sociales";
            else
            if(codigo.equals(Integer.valueOf(14)))
                descAvise = "Plegable institucional";
            else
            if(codigo.equals(Integer.valueOf(15)))
                descAvise = "Pagina web";
        return descAvise;
    }

    public List getListaLugarHechosAvise()
        throws ModelException
    {
        List lstLugar = new ArrayList();
        Cnlugarhecho lugarObject = new Cnlugarhecho();
        lugarObject.setClhncodigo(Integer.valueOf(1));
        lugarObject.setClhcdescripcio("Hogar");
        lstLugar.add(lugarObject);
        lugarObject = new Cnlugarhecho();
        lugarObject.setClhncodigo(Integer.valueOf(2));
        lugarObject.setClhcdescripcio("Via publica");
        lstLugar.add(lugarObject);
        lugarObject = new Cnlugarhecho();
        lugarObject.setClhncodigo(Integer.valueOf(3));
        lugarObject.setClhcdescripcio("Est. Publico");
        lstLugar.add(lugarObject);
        lugarObject = new Cnlugarhecho();
        lugarObject.setClhncodigo(Integer.valueOf(4));
        lugarObject.setClhcdescripcio("Trabajo");
        lstLugar.add(lugarObject);
        lugarObject = new Cnlugarhecho();
        lugarObject.setClhncodigo(Integer.valueOf(5));
        lugarObject.setClhcdescripcio("Estudio");
        lstLugar.add(lugarObject);
        lugarObject = new Cnlugarhecho();
        lugarObject.setClhncodigo(Integer.valueOf(6));
        lugarObject.setClhcdescripcio("Otro");
        lstLugar.add(lugarObject);
        return lstLugar;
    }

    public String getDescripcionLugarHechosAvise(Integer clhncodigo)
        throws ModelException
    {
        String descripcion = "";
        if(clhncodigo != null)
            if(clhncodigo.equals(Integer.valueOf(1)))
                descripcion = "Hogar";
            else
            if(clhncodigo.equals(Integer.valueOf(2)))
                descripcion = "Via publica";
            else
            if(clhncodigo.equals(Integer.valueOf(3)))
                descripcion = "Est. Publico";
            else
            if(clhncodigo.equals(Integer.valueOf(4)))
                descripcion = "Trabajo";
            else
            if(clhncodigo.equals(Integer.valueOf(5)))
                descripcion = "Estudio";
            else
            if(clhncodigo.equals(Integer.valueOf(6)))
                descripcion = "Otro";
        return descripcion;
    }

    public List getListaTiempoHechosAvise()
        throws ModelException
    {
        List lstTiempo = new ArrayList();
        Cntiempocurr tiempoObject = new Cntiempocurr();
        tiempoObject.setCtoncodigo(Integer.valueOf(7));
        tiempoObject.setCtocdescripcio("Menos de 24 horas ");
        lstTiempo.add(tiempoObject);
        tiempoObject = new Cntiempocurr();
        tiempoObject.setCtoncodigo(Integer.valueOf(4));
        tiempoObject.setCtocdescripcio("Menos de 5 dias");
        lstTiempo.add(tiempoObject);
        tiempoObject = new Cntiempocurr();
        tiempoObject.setCtoncodigo(Integer.valueOf(5));
        tiempoObject.setCtocdescripcio("De 6 a 29 dias");
        tiempoObject = new Cntiempocurr();
        tiempoObject.setCtoncodigo(Integer.valueOf(6));
        tiempoObject.setCtocdescripcio("De 30 o mas dias");
        tiempoObject = new Cntiempocurr();
        tiempoObject.setCtoncodigo(Integer.valueOf(8));
        tiempoObject.setCtocdescripcio("Otro");
        lstTiempo.add(tiempoObject);
        return lstTiempo;
    }

    public List getListaRelacionAvise()
        throws ModelException
    {
        List lstRelacionFamiliar = new ArrayList();
        Cnrelacavise relacionObject = new Cnrelacavise();
        relacionObject.setCrancodigo(Integer.valueOf(1));
        relacionObject.setCracdescripcio("Familiar");
        lstRelacionFamiliar.add(relacionObject);
        relacionObject = new Cnrelacavise();
        relacionObject.setCrancodigo(Integer.valueOf(2));
        relacionObject.setCracdescripcio("Amigo");
        lstRelacionFamiliar.add(relacionObject);
        relacionObject = new Cnrelacavise();
        relacionObject.setCrancodigo(Integer.valueOf(3));
        relacionObject.setCracdescripcio("Vecino");
        lstRelacionFamiliar.add(relacionObject);
        relacionObject = new Cnrelacavise();
        relacionObject.setCrancodigo(Integer.valueOf(4));
        relacionObject.setCracdescripcio("Compa\361ero Trabajo/Estudio");
        lstRelacionFamiliar.add(relacionObject);
        relacionObject = new Cnrelacavise();
        relacionObject.setCrancodigo(Integer.valueOf(5));
        relacionObject.setCracdescripcio("Conocido Ocasional");
        lstRelacionFamiliar.add(relacionObject);
        relacionObject = new Cnrelacavise();
        relacionObject.setCrancodigo(Integer.valueOf(6));
        relacionObject.setCracdescripcio("Otro");
        lstRelacionFamiliar.add(relacionObject);
        return lstRelacionFamiliar;
    }

    public String getDescripcionRelacionFamiliarAvise(Integer clhncodigo)
        throws ModelException
    {
        String descripcion = "";
        if(clhncodigo != null)
            if(clhncodigo.equals(Integer.valueOf(1)))
                descripcion = "Familiar";
            else
            if(clhncodigo.equals(Integer.valueOf(2)))
                descripcion = "Amigo";
            else
            if(clhncodigo.equals(Integer.valueOf(3)))
                descripcion = "Vecino";
            else
            if(clhncodigo.equals(Integer.valueOf(4)))
                descripcion = "Compa\361ero Trabajo/Estudio";
            else
            if(clhncodigo.equals(Integer.valueOf(5)))
                descripcion = "Conocido Ocasional";
            else
            if(clhncodigo.equals(Integer.valueOf(6)))
                descripcion = "Otro";
        return descripcion;
    }

    public List getListaParentescoFamiliarAvise()
        throws ModelException
    {
        List lstParentescoFamiliar = new ArrayList();
        Cnparenfamil parentescoObject = new Cnparenfamil();
        parentescoObject.setCpfncodigo(Integer.valueOf(1));
        parentescoObject.setCpfcdescripcio("Padrastro");
        lstParentescoFamiliar.add(parentescoObject);
        parentescoObject = new Cnparenfamil();
        parentescoObject.setCpfncodigo(Integer.valueOf(2));
        parentescoObject.setCpfcdescripcio("Padre");
        lstParentescoFamiliar.add(parentescoObject);
        parentescoObject = new Cnparenfamil();
        parentescoObject.setCpfncodigo(Integer.valueOf(3));
        parentescoObject.setCpfcdescripcio("Abuelo");
        lstParentescoFamiliar.add(parentescoObject);
        parentescoObject = new Cnparenfamil();
        parentescoObject.setCpfncodigo(Integer.valueOf(4));
        parentescoObject.setCpfcdescripcio("Tio");
        lstParentescoFamiliar.add(parentescoObject);
        parentescoObject = new Cnparenfamil();
        parentescoObject.setCpfncodigo(Integer.valueOf(5));
        parentescoObject.setCpfcdescripcio("Hermano/Hermanastro");
        lstParentescoFamiliar.add(parentescoObject);
        parentescoObject = new Cnparenfamil();
        parentescoObject.setCpfncodigo(Integer.valueOf(6));
        parentescoObject.setCpfcdescripcio("Primo");
        lstParentescoFamiliar.add(parentescoObject);
        parentescoObject = new Cnparenfamil();
        parentescoObject.setCpfncodigo(Integer.valueOf(7));
        parentescoObject.setCpfcdescripcio("Otro");
        lstParentescoFamiliar.add(parentescoObject);
        return lstParentescoFamiliar;
    }

    public String getDescripcionParentescoFamiliarAvise(Integer clhncodigo)
        throws ModelException
    {
        String descripcion = "";
        if(clhncodigo != null)
            if(clhncodigo.equals(Integer.valueOf(1)))
                descripcion = "Padrastro";
            else
            if(clhncodigo.equals(Integer.valueOf(2)))
                descripcion = "Padre";
            else
            if(clhncodigo.equals(Integer.valueOf(3)))
                descripcion = "Abuelo";
            else
            if(clhncodigo.equals(Integer.valueOf(4)))
                descripcion = "Tio";
            else
            if(clhncodigo.equals(Integer.valueOf(5)))
                descripcion = "Hermano/Hermanastro";
            else
            if(clhncodigo.equals(Integer.valueOf(6)))
                descripcion = "Primo";
            else
            if(clhncodigo.equals(Integer.valueOf(7)))
                descripcion = "Otro";
        return descripcion;
    }

    public String getDescripcionTiempoHechosAvise(Integer ctoncodigo)
        throws ModelException
    {
        String descripcion = "";
        if(ctoncodigo != null)
            if(ctoncodigo.equals(Integer.valueOf(4)))
                descripcion = "Menos de 5 dias";
            else
            if(ctoncodigo.equals(Integer.valueOf(5)))
                descripcion = "De 6 a 29 dias";
            else
            if(ctoncodigo.equals(Integer.valueOf(6)))
                descripcion = "De 30 o mas dias";
            else
            if(ctoncodigo.equals(Integer.valueOf(7)))
                descripcion = "Menos de 24 horas";
            else
            if(ctoncodigo.equals(Integer.valueOf(8)))
                descripcion = "Otro";
        return descripcion;
    }

    public void saveAsesoriaAvise(Chaseavise asesoria)
        throws ModelException
    {
        clinicoDAO.saveAsesoriaAvise(asesoria);
    }

    public void saveAsesoriaHunanitaria(Chasesohuman asesoria)
        throws ModelException
    {
        clinicoDAO.saveAsesoriaHunanitaria(asesoria);
    }

    public List getAsesoriaHumanitariaXUsuario(String hahcoperador, Integer hahnclinica)
        throws ModelException
    {
        return clinicoDAO.getAsesoriaHumanitariaXUsuario(hahcoperador, hahnclinica);
    }

    public void saveOtraAsesoria(Chasesoria asesoria)
        throws ModelException
    {
        clinicoDAO.saveOtraAsesoria(asesoria);
    }

    public List getListaTipoInstitucion()
        throws ModelException
    {
        List lstRemision = new ArrayList();
        Cnremisinsti remisionObject = new Cnremisinsti();
        remisionObject.setCrincodigo(Integer.valueOf(1));
        remisionObject.setCricdescripcio("EPS");
        lstRemision.add(remisionObject);
        remisionObject = new Cnremisinsti();
        remisionObject.setCrincodigo(Integer.valueOf(2));
        remisionObject.setCricdescripcio("Red p\372blica");
        lstRemision.add(remisionObject);
        remisionObject = new Cnremisinsti();
        remisionObject.setCrincodigo(Integer.valueOf(3));
        remisionObject.setCricdescripcio("Red privada");
        lstRemision.add(remisionObject);
        remisionObject = new Cnremisinsti();
        remisionObject.setCrincodigo(Integer.valueOf(4));
        remisionObject.setCricdescripcio("Otra");
        lstRemision.add(remisionObject);
        return lstRemision;
    }

    public String getDescripcionTipoInstitucion(Integer crincodigo)
        throws ModelException
    {
        String descripcion = "";
        if(crincodigo != null)
            if(crincodigo.equals(Integer.valueOf(1)))
                descripcion = "EPS";
            else
            if(crincodigo.equals(Integer.valueOf(2)))
                descripcion = "Red p\372blica";
            else
            if(crincodigo.equals(Integer.valueOf(3)))
                descripcion = "Red privada";
            else
            if(crincodigo.equals(Integer.valueOf(4)))
                descripcion = "Otra";
        return descripcion;
    }

    public void saveSeguimientoAvise(Chseguavis seguimiento)
        throws ModelException
    {
        clinicoDAO.saveSeguimientoAvise(seguimiento);
    }

    public Chaseavise getAsesoriaUsuario(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getAsesoriaUsuario(usuario);
    }

    public List getAsesoriaUsuario(Chusuario usuario, Date fechaAsesoria)
        throws ModelException
    {
        return clinicoDAO.getAsesoriaUsuario(usuario, fechaAsesoria);
    }

    public List getListaIngresoPor()
        throws ModelException
    {
        List lstIngreso = new ArrayList();
        Cningrilve ingresoObject = new Cningrilve();
        ingresoObject.setCiincodigo(Integer.valueOf(1));
        ingresoObject.setCiicdescripcio("Laboratorio");
        lstIngreso.add(ingresoObject);
        ingresoObject = new Cningrilve();
        ingresoObject.setCiincodigo(Integer.valueOf(2));
        ingresoObject.setCiicdescripcio("Informacion");
        lstIngreso.add(ingresoObject);
        ingresoObject = new Cningrilve();
        ingresoObject.setCiincodigo(Integer.valueOf(3));
        ingresoObject.setCiicdescripcio("Medicina General");
        lstIngreso.add(ingresoObject);
        ingresoObject = new Cningrilve();
        ingresoObject.setCiincodigo(Integer.valueOf(4));
        ingresoObject.setCiicdescripcio("Otro");
        lstIngreso.add(ingresoObject);
        return lstIngreso;
    }

    public List getTipoAsesoria()
        throws ModelException
    {
        List lstAsesoria = new ArrayList();
        Chtipoaseso asesoriaObject = new Chtipoaseso();
        asesoriaObject.setHtaecodigo("1");
        asesoriaObject.setHtacdescripcio("Actividades Educativas - Planificaci\363n Familiar");
        lstAsesoria.add(asesoriaObject);
        asesoriaObject = new Chtipoaseso();
        asesoriaObject.setHtaecodigo("2");
        asesoriaObject.setHtacdescripcio("Actividades educativas - Prevenci\363n C\341ncer");
        lstAsesoria.add(asesoriaObject);
        asesoriaObject = new Chtipoaseso();
        asesoriaObject.setHtaecodigo("3");
        asesoriaObject.setHtacdescripcio("Actividades Educativas- ITS - VIH/SIDA");
        lstAsesoria.add(asesoriaObject);
        asesoriaObject = new Chtipoaseso();
        asesoriaObject.setHtaecodigo("4");
        asesoriaObject.setHtacdescripcio("DSR - Violencia Intrafamiliar y Abuso Sexual");
        lstAsesoria.add(asesoriaObject);
        asesoriaObject = new Chtipoaseso();
        asesoriaObject.setHtaecodigo("5");
        asesoriaObject.setHtacdescripcio("Act. Educ. Salud B\341sica Familiar");
        lstAsesoria.add(asesoriaObject);
        asesoriaObject = new Chtipoaseso();
        asesoriaObject.setHtaecodigo("6");
        asesoriaObject.setHtacdescripcio("Asesor\355a Personalizada");
        lstAsesoria.add(asesoriaObject);
        return lstAsesoria;
    }

    public List getListAsesoriaUsuario(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getListAsesoriaUsuario(usuario);
    }

    public List getBuscadorFacturas(Chusuario usuario, Date fechaInicial, Date fechaFinal)
        throws ModelException
    {
        return clinicoDAO.getBuscadorFacturas(usuario, fechaInicial, fechaFinal);
    }

    public boolean verificarAsesoriaDia(Chusuario usuario, Date fechaAsesoria)
        throws ModelException
    {
        return clinicoDAO.verificarAsesoriaDia(usuario, fechaAsesoria);
    }

    public boolean verificarAsesoriaDiaPosterior(Chusuario usuario, Date fechaAsesoria)
        throws ModelException
    {
        return clinicoDAO.verificarAsesoriaDiaPosterior(usuario, fechaAsesoria);
    }

    public List getCirugiasProgramadasActivas(Integer codclin, String etapa, String etapa2,Date fechaCirugia,BigDecimal wcodmed)
        throws ModelException
    {
        return clinicoDAO.getCirugiasProgramadasActivas(codclin, etapa, etapa2,fechaCirugia,wcodmed);
    }

    public List getCirugiasProgramadasAnestesia(Integer codclin, String etapa, String etapa2,Date fechaCirugia, BigDecimal wcodmed)
        throws ModelException
    {
        return clinicoDAO.getCirugiasProgramadasAnestesia(codclin, etapa, etapa2,fechaCirugia, wcodmed);
    }

    public List getCirugiasProgramadasEpicrisis(Integer codclin, Date fechaHoy)
        throws ModelException
    {
        return clinicoDAO.getCirugiasProgramadasEpicrisis(codclin, fechaHoy);
    }

    public List getCirugiasProgramadasIngresoEnfermeria(Integer codclin, Date fechaActual)
        throws ModelException
    {
        return clinicoDAO.getCirugiasProgramadasIngresoEnfermeria(codclin, fechaActual);
    }

    public List getCirugiasProgramadasIngresoMedico(Integer codclin, Date fechaActual)
        throws ModelException
    {
        return clinicoDAO.getCirugiasProgramadasIngresoMedico(codclin, fechaActual);
    }

    public List getDonante()
        throws ModelException
    {
        return clinicoDAO.getDonante();
    }

    public List getLibroControlCitologia(Date fechaInicial, Date fechaFinal, Integer clinica)
        throws ModelException
    {
        return clinicoDAO.getLibroControlCitologia(fechaInicial, fechaFinal, clinica);
    }

    public String getDescripcionParametrosCitologia(String cdictabla, String cdiccampo, String cdicvalor)
        throws ModelException
    {
        return clinicoDAO.getDescripcionParametrosCitologia(cdictabla, cdiccampo, cdicvalor);
    }

    public String getDescripcionTipoProfesional(Integer codProfes)
        throws ModelException
    {
        return clinicoDAO.getDescripcionTipoProfesional(codProfes);
    }

    public String getDescripcionTipoEspecialidad(Integer codProfes)
        throws ModelException
    {
        return clinicoDAO.getDescripcionTipoEspecialidad(codProfes);
    }

    public List getListaDetalleCirugiasProgramadas(Long hdclconsuprinc)
        throws ModelException
    {
        return clinicoDAO.getListaDetalleCirugiasProgramadas(hdclconsuprinc);
    }

    public Chdetacirpro getCirugiaDetallada(Long codigoPrincipal, String servicio)
        throws ModelException
    {
        return clinicoDAO.getCirugiaDetallada(codigoPrincipal, servicio);
    }

    public List getDetalleCirugiasProgramadas(Long codigoPrincipal)
        throws ModelException
    {
        return clinicoDAO.getDetalleCirugiasProgramadas(codigoPrincipal);
    }

    public List getDetalleCirugiasProgramadasBasico(Long codigoPrincipal, boolean registro)
        throws ModelException
    {
        return clinicoDAO.getDetalleCirugiasProgramadasBasico(codigoPrincipal,registro);
    }

    public List getReporteAsesoraIlve(Integer codClinica, Date fechaInicial, Date fechaFinal)
        throws ModelException
    {
        return clinicoDAO.getReporteAsesoraIlve(codClinica, fechaInicial, fechaFinal);
    }

    public List getOtrasAsesoria(Chusuario usuario)
        throws ModelException
    {
        return clinicoDAO.getOtrasAsesoria(usuario);
    }

    public List getListaOtrasAsesorias(Date fechaInicial, Date fechaFinal, Integer codClinica)
        throws ModelException
    {
        return clinicoDAO.getListaOtrasAsesorias(fechaInicial, fechaFinal, codClinica);
    }

    public void savelstCitologia(List lstCitologia)
        throws ModelException
    {
        clinicoDAO.savelstCitologia(lstCitologia);
    }

    public List getListaConoceProfamilia()
        throws ModelException
    {
        List lstConocProfa = new ArrayList();
        Chconocprofa conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(1));
        conocimientoObject.setCcpcdescripcio("Radio");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(2));
        conocimientoObject.setCcpcdescripcio("TV");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(3));
        conocimientoObject.setCcpcdescripcio("Internet");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(4));
        conocimientoObject.setCcpcdescripcio("Revistas");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(5));
        conocimientoObject.setCcpcdescripcio("Conocido");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(6));
        conocimientoObject.setCcpcdescripcio("Otro");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(7));
        conocimientoObject.setCcpcdescripcio("Redes Sociales");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(8));
        conocimientoObject.setCcpcdescripcio("Linea 01-8000");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(9));
        conocimientoObject.setCcpcdescripcio("Plegables");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(10));
        conocimientoObject.setCcpcdescripcio("Remitido por Entidad");
        lstConocProfa.add(conocimientoObject);
        conocimientoObject = new Chconocprofa();
        conocimientoObject.setCcpecodigo(Integer.valueOf(11));
        conocimientoObject.setCcpcdescripcio("Campa\361a");
        lstConocProfa.add(conocimientoObject);
        return lstConocProfa;
    }

    public List getTipoVinculacion()
        throws ModelException
    {
        List lstTipoVinculacion = new ArrayList();
        Chtipovincu tipoVinculacionObject = new Chtipovincu();
        tipoVinculacionObject.setCtvecodigo("C");
        tipoVinculacionObject.setCtvcdescripcio("Cotizante");
        lstTipoVinculacion.add(tipoVinculacionObject);
        tipoVinculacionObject = new Chtipovincu();
        tipoVinculacionObject.setCtvecodigo("B");
        tipoVinculacionObject.setCtvcdescripcio("Beneficiario");
        lstTipoVinculacion.add(tipoVinculacionObject);
        return lstTipoVinculacion;
    }

    public List getTipoControlIlve()
        throws ModelException
    {
        List lstTipoControlIlve = new ArrayList();
        Chtipocontro tipoControlObject = new Chtipocontro();
        tipoControlObject.setCtcecodigo("IM");
        tipoControlObject.setCtccdescripcio("Control IVE Farmacol�gico");
        lstTipoControlIlve.add(tipoControlObject);
        tipoControlObject = new Chtipocontro();
        tipoControlObject.setCtcecodigo("QL");
        tipoControlObject.setCtccdescripcio("Control AMEU con bloqueo");
        lstTipoControlIlve.add(tipoControlObject);
        tipoControlObject = new Chtipocontro();
        tipoControlObject.setCtcecodigo("QG");
        tipoControlObject.setCtccdescripcio("Control AMEU BAG");
        lstTipoControlIlve.add(tipoControlObject);
        tipoControlObject = new Chtipocontro();
        tipoControlObject.setCtcecodigo("DE");
        tipoControlObject.setCtccdescripcio("Dilataci�n y Evacuaci�n");
        lstTipoControlIlve.add(tipoControlObject);
        tipoControlObject = new Chtipocontro();
        tipoControlObject.setCtcecodigo("IF");
        tipoControlObject.setCtccdescripcio("IMF");
        lstTipoControlIlve.add(tipoControlObject);
        tipoControlObject = new Chtipocontro();
        tipoControlObject.setCtcecodigo("CE");
        tipoControlObject.setCtccdescripcio("Confirmar Embarazo");
        lstTipoControlIlve.add(tipoControlObject);
        return lstTipoControlIlve;
    }

    public List getListaNivelEducativo()
        throws ModelException
    {
        List lstNivelEducativo = new ArrayList();
        Chniveleduca nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(1));
        nivelEducativoObject.setCnecdescripcio("No Definido");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(2));
        nivelEducativoObject.setCnecdescripcio("Preescolar");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(3));
        nivelEducativoObject.setCnecdescripcio("Basica Primaria");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(4));
        nivelEducativoObject.setCnecdescripcio("Basica Secundaria (Bachillerato Basico)");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(5));
        nivelEducativoObject.setCnecdescripcio("Media Academica o Clasica (Bachillerato Basico)");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(6));
        nivelEducativoObject.setCnecdescripcio("Media Tecnica (Bachillerato Tecnico)");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(7));
        nivelEducativoObject.setCnecdescripcio("Normalista");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(8));
        nivelEducativoObject.setCnecdescripcio("Tecnica Profesional");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(9));
        nivelEducativoObject.setCnecdescripcio("Tecnologica");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(10));
        nivelEducativoObject.setCnecdescripcio("Profesional");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(11));
        nivelEducativoObject.setCnecdescripcio("Especializacion");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(12));
        nivelEducativoObject.setCnecdescripcio("Maestria");
        lstNivelEducativo.add(nivelEducativoObject);
        nivelEducativoObject = new Chniveleduca();
        nivelEducativoObject.setCneecodigo(Integer.valueOf(13));
        nivelEducativoObject.setCnecdescripcio("Doctorado");
        lstNivelEducativo.add(nivelEducativoObject);
        return lstNivelEducativo;
    }

    public List getListaEtnia()
        throws ModelException
    {
        List lstEtnia = new ArrayList();
        Chetnia etniaObject = new Chetnia();
        etniaObject.setCetecodigo("01");
        etniaObject.setCetcdescripcio("Indigena");
        lstEtnia.add(etniaObject);
        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("02");
        etniaObject.setCetcdescripcio("ROM (gitano)");
        lstEtnia.add(etniaObject);
        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("03");
        etniaObject.setCetcdescripcio("Raizal (archipi\351lago de San Andr\351s y Providencia)");
        lstEtnia.add(etniaObject);
        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("04");
        etniaObject.setCetcdescripcio("Palanquero de San Basilio");
        lstEtnia.add(etniaObject);
        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("05");
        etniaObject.setCetcdescripcio("Negro(a)");
        lstEtnia.add(etniaObject);
        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("06");
        etniaObject.setCetcdescripcio("Afrocolombiano(a)");
        lstEtnia.add(etniaObject);
        etniaObject = new Chetnia();
        etniaObject.setCetecodigo("99");
        etniaObject.setCetcdescripcio("Ninguno de los anteriores");
        lstEtnia.add(etniaObject);
        return lstEtnia;
    }

    public void saveUsuarioSap(Chusuario usuario, String userName, List ltsTarifaServicio, Integer clinica, String tipoVenta)
        throws ModelException
    {
        clinicoDAO.saveUsuarioSap(usuario, userName, ltsTarifaServicio, clinica, tipoVenta);
    }

    public Cpservicio getDescripcionServicioSapXCodigo(Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getDescripcionServicioSapXCodigo(servicio);
    }

    public BigDecimal getDescuentoEmpleado(String servicio, String tipIdent, BigDecimal numIdent)
        throws ModelException
    {
        return clinicoDAO.getDescuentoEmpleado(servicio, tipIdent, numIdent);
    }

    public List getValidarContrato(Integer clinic, Integer contra, String servicio)
        throws ModelException
    {
        return clinicoDAO.getValidarContrato(clinic, contra, servicio);
    }

    public Cpentidadadm getEntidadEpsxCodigo(String codigo)
        throws ModelException
    {
        return clinicoDAO.getEntidadEpsxCodigo(codigo);
    }

    public List getPrograma()
        throws ModelException
    {
        return clinicoDAO.getPrograma();
    }

    public List getReporteMisAsesoraIlve(Integer codClinica, Date fechaInicial, Date fechaFinal, String userName)
        throws ModelException
    {
        return clinicoDAO.getReporteMisAsesoraIlve(codClinica, fechaInicial, fechaFinal, userName);
    }

    public List getReporteClinicAsesoraIlve(Integer codClinica, Date fechaInicial, Date fechaFinal)
        throws ModelException
    {
        return clinicoDAO.getReporteClinicAsesoraIlve(codClinica, fechaInicial, fechaFinal);
    }

    public List getCie10Ilve(Integer tipoDiagnostico)
        throws ModelException
    {
        return clinicoDAO.getCie10Ilve(tipoDiagnostico);
    }

    public List getCie10ControlIlve(Integer tipoDiagnostico, Integer tipoControl)
        throws ModelException
    {
        return clinicoDAO.getCie10ControlIlve(tipoDiagnostico, tipoControl);
    }

    public void saveActividadEducativa(Chactiveduca actividad)
        throws ModelException
    {
        clinicoDAO.saveActividadEducativa(actividad);
    }

    public List getCuestionarioEsterilizacionPorUsuaria(Long usuaria)
        throws ModelException
    {
        return clinicoDAO.getCuestionarioEsterilizacionPorUsuaria(usuaria);
    }

    public List getConsultasReferenciaPorConfirmar(Integer codclin)
        throws Exception
    {
        return clinicoDAO.getConsultasReferenciaPorConfirmar(codclin);
    }

    public List getReporteAutorizacionServicios(Integer codClinica, Date fechaInicial, Date fechaFinal)
        throws ModelException
    {
        return clinicoDAO.getReporteAutorizacionServicios(codClinica, fechaInicial, fechaFinal);
    }

    public void saveTipoServicio(Chtiposerv servicio)
        throws ModelException
    {
        clinicoDAO.saveTipoServicio(servicio);
    }

    public List getLstTipoServicio()
        throws ModelException
    {
        return clinicoDAO.getLstTipoServicio();
    }

    public List getServiciosSalud(Cpservicio servicio)
        throws ModelException
    {
        return clinicoDAO.getServiciosSalud(servicio);
    }

    public void saveServicioXTipo(Chserxtipo servicio)
        throws ModelException
    {
        clinicoDAO.saveServicioXTipo(servicio);
    }

    public List getLstServicioXTipo(Integer codigo)
        throws ModelException
    {
        return clinicoDAO.getLstServicioXTipo(codigo);
    }

    public void deleteServicioXTipo(Chserxtipo servicio)
        throws ModelException
    {
        clinicoDAO.deleteServicioXTipo(servicio);
    }

    public List getReporteIlve(Date fechaInicial, Date fechaFinal, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getReporteIlve(fechaInicial, fechaFinal, codclin);
    }
    
    public List getReporteIlveNal(Date fechaInicial, Date fechaFinal, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getReporteIlveNal(fechaInicial, fechaFinal, codclin);
    }
    
    public List getReporteResolucion256(Date fechaInicial, Date fechaFinal, Integer codclin)
        throws ModelException
    {
        return clinicoDAO.getReporteResolucion256(fechaInicial, fechaFinal, codclin);
    }

    public void saveSalaCirugia(Chconsultori consultorioObject)
        throws ModelException
    {
        clinicoDAO.saveSalaCirugia(consultorioObject);
    }

    public List getSalasCirugia()
        throws ModelException
    {
        return clinicoDAO.getSalasCirugia();
    }

    public void saveLstRegistroLiquidosAnestesia(List lstLiquidosSelect, Long numeroCirugia)
        throws ModelException
    {
        clinicoDAO.saveLstRegistroLiquidosAnestesia(lstLiquidosSelect, numeroCirugia);
    }

    public List getLstLiquidosAdministradoParcialAnestesia(List lstLiquidosSelectAdmin)
        throws ModelException
    {
        return clinicoDAO.getLstLiquidosAdministradoParcialAnestesia(lstLiquidosSelectAdmin);
    }

    public List getLstLiquidosAdministradoParcialAnestesiaIni(Long numero)
        throws ModelException
    {
        return clinicoDAO.getLstLiquidosAdministradoParcialAnestesiaIni(numero);
    }

    public void saveLstRegistroLiquidosControlAnestesia(List lstLiquidosSelectEnAdministracion, Long numeroCirugia)
        throws ModelException
    {
        clinicoDAO.saveLstRegistroLiquidosControlAnestesia(lstLiquidosSelectEnAdministracion, numeroCirugia);
    }

    public List getLstLiquidosAdministradosAnestesia(Long numero)
        throws ModelException
    {
        return clinicoDAO.getLstLiquidosAdministradosAnestesia(numero);
    }

    public void saveLstRegistroLiquidosAnestesiaEtapaIniciadoLiquido(List lstLiquidosSelect, Long numeroCirugia)
        throws ModelException
    {
        clinicoDAO.saveLstRegistroLiquidosAnestesiaEtapaIniciadoLiquido(lstLiquidosSelect, numeroCirugia);
    }

    public List getConsultasMedicamentoDia(Date dia, Integer codclinica, BigDecimal idMedico, String numeroIden)
        throws ModelException
    {
        return clinicoDAO.getConsultasMedicamentoDia(dia, codclinica, idMedico,numeroIden);
    }

    public void saveAplicacionVacuna(Chvacunacion aplicacion)
        throws ModelException
    {
        clinicoDAO.saveAplicacionVacuna(aplicacion);
    }

    public Chvacunacion getAdministracionVacuna(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getAdministracionVacuna(numeroConsulta);
    }

    public Cpservicio getServicioXNumeroConsulta(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getServicioXNumeroConsulta(numeroConsulta);
    }

    public void saveViolenciaSivigila(Chvsolsivig violencia)
        throws ModelException
    {
        clinicoDAO.saveViolenciaSivigila(violencia);
    }

    public Chvsolsivig getViolenciaSivigila(Long numeroConsulta)
        throws ModelException
    {
        return clinicoDAO.getViolenciaSivigila(numeroConsulta);
    }

    public boolean esPoliciaNacional(Integer cconnumero)
        throws ModelException
    {
        return clinicoDAO.esPoliciaNacional(cconnumero);
    }
    
    
       public void saveAplicacionEspermograma(Chespervasec aplicacion, Cnconsclin consulta) throws ModelException{
           clinicoDAO.saveAplicacionEspermograma(aplicacion, consulta);
       }

    public void saveEspermogramaFertilidad(Cnespermog espermograma, Cncapaespe capacitacion) throws ModelException{
        clinicoDAO.saveEspermogramaFertilidad(espermograma, capacitacion);
    }
    
    /**
        * @param numeroConsulta
        * @return
        * @throws ModelException
        */
       public Chespervasec getAdministracionEspermograma(Long numeroConsulta) throws ModelException{
           return clinicoDAO.getAdministracionEspermograma(numeroConsulta);
       }

    /**
        * @param numeroConsulta
        * @return
        * @throws ModelException
        */
       public Cnespermog getEspermogramaFertilidad(Long numeroConsulta) throws ModelException{
           return clinicoDAO.getEspermogramaFertilidad(numeroConsulta);
       }

    /**
        * @param clinica
        * @param numeroEspermograma
        * @return
        * @throws ModelException
        */
       public Cncapaespe getCapacitacionFertilidad(Integer clinica, Integer numeroEspermograma) throws ModelException{
           return clinicoDAO.getCapacitacionFertilidad(clinica, numeroEspermograma);
       }
       
    /**
        * @param dia
        * @param codclinica
        * @param idMedico
        * @return
        * @throws ModelException
        */
       public List<Cnconsclin> getConsultasEspermogramaDia(final Date dia, 
                                                             final Integer codclinica, 
                                                             final BigDecimal idMedico) throws ModelException {
           return clinicoDAO.getConsultasEspermogramaDia(dia, codclinica, idMedico);                                             
                                                             
       }


    /**
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReporteRadicacionFacturas(Date fechaInicial, 
                                                         Date fechaFinal) throws ModelException{
             return clinicoDAO.getReporteRadicacionFacturas(fechaInicial, fechaFinal);                                 
          }

    /**
     * @param fechaInicial
     * @param fechaFinal
     * @param contrato
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReporteFacturacionContrato(Date fechaInicial, 
                                                     Date fechaFinal, Integer contrato, Integer wclinica) throws ModelException{
                                                         return clinicoDAO.getReporteFacturacionContrato(fechaInicial, fechaFinal,contrato,wclinica);                                                                             
                                                     }


    /**
     * @param medicamento
     * @return
     * @throws ModelException
     */
    public List<Chvademprof> getVademecumHistorias(Chvademprof medicamento) throws ModelException{
            return clinicoDAO.getVademecumHistorias(medicamento);   
        }
        
        
    public List<Object[]> getReporteServiciosSinFactura(Date fechaInicial, 
                                                     Date fechaFinal) throws ModelException {
       return clinicoDAO.getReporteServiciosSinFactura(fechaInicial,fechaFinal);                                     
     }
     /**
     * 
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReporteServiciosIppf(Date fechaInicial, 
                                                     Date fechaFinal,Integer wivefarser) throws ModelException {
       return clinicoDAO.getReporteServiciosIppf(fechaInicial,fechaFinal, wivefarser)  ;                                            
                                                     }
    /**
     * @param cconnumero
     * @return
     * @throws ModelException
     */
    public BigDecimal getNumeroFactura(Long cconnumero) throws ModelException{
        return clinicoDAO.getNumeroFactura(cconnumero);     
    }


    /**
     * @param pareja
     * @throws ModelException
     */
     public void saveDatosFertilidad(Chfertdato fertdato) throws ModelException {
        clinicoDAO.saveDatosFertilidad(fertdato);
    }

    /**
     * @param ecografia
     * @throws ModelException
     */
    public void saveDatosEcografiaFertilidad(Chfertecog ecografia) throws ModelException{
        clinicoDAO.saveDatosEcografiaFertilidad(ecografia);
    }

    /**
     * @param consclin
     * @return
     * @throws ModelException
     */
    public Chfertdato getDatosFertilidad(Long consclin) throws ModelException{
        return clinicoDAO.getDatosFertilidad(consclin);     
    }


    /**
     * @param consclin
     * @return
     * @throws ModelException
     */
    public Chfertecog getDatosEcografia(Long consclin) throws ModelException{
        return clinicoDAO.getDatosEcografia(consclin);     
    }
    
    
    /**
     * 
     * @param antecedente
     * @throws ModelException
     */
    public void saveAntecedentesVasectomia(Chantecvasec antecedente) throws ModelException {
        clinicoDAO.saveAntecedentesVasectomia(antecedente);
    }
    
    
    /**
     * 
     * @param idConsulta
     * @return
     * @throws ModelException
     */
    public Chantecvasec getAntecedenteVasectomia(Long idConsulta) throws ModelException {
        return clinicoDAO.getAntecedenteVasectomia(idConsulta);
    }
    
    /**
     * 
     * @param regcirpro
     * @param usuario
     * @param servicio
     * @param tipodocu
     * @param userName
     * @throws ModelException
     */
    public void saveConsultaSinFactura(final Chregiconpro regcirpro, 
                                      final Chusuario usuario, 
                                      final Cpservicio servicio, 
                                      final Cptipodocu tipodocu, 
                                      final String userName) throws ModelException{
                                          clinicoDAO.saveConsultaSinFactura(regcirpro,usuario,servicio,tipodocu,userName);
                                      }
                                      
    /**
     * 
     * @param clinica
     * @return
     * @throws ModelException
     */
     public List<Chregiconpro> getConsultaSinFacturaPorConfirmar(final Integer clinica) throws ModelException{
        return clinicoDAO.getConsultaSinFacturaPorConfirmar(clinica);
    }
    
    
    /**
     * 
     * @param numero
     * @return
     * @throws ModelException
     */
    public Cnconsclin getConsinfacByNumero(Long numero) throws ModelException {
        return clinicoDAO.getConsinfacByNumero(numero);
    
    }
    
    
/**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chparacgener> getParaclinicosGeneral(Long numeroConsulta) throws ModelException {
            return clinicoDAO.getParaclinicosGeneral(numeroConsulta);
        }
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chcontroorden> getOtrasOrdenes(Long numeroConsulta) throws ModelException {
            return clinicoDAO.getOtrasOrdenes(numeroConsulta);
    }

    /**
     * 
     * @param paraclinicos
     * @param numeroConsulta
     * @throws ModelException
     */
    public void saveParaclinicosGeneral(final List<Chparacgener> paraclinicos, 
                                        final Long numeroConsulta) throws ModelException {

        clinicoDAO.saveParaclinicosGeneral(paraclinicos, numeroConsulta);

    }
    
    
    /**
     * 
     * @param otrasOrdenes
     * @param numeroConsulta
     * @throws ModelException
     */
    public void saveOtrasOrdenes(final List<Chcontroorden> otrasOrdenes, 
                                 final Long numeroConsulta, final String usuario,final List<Chcontroorden> ordenesSuspender) throws ModelException {
                                     clinicoDAO.saveOtrasOrdenes(otrasOrdenes, numeroConsulta,usuario,ordenesSuspender);
                                 }
    /**
     * 
     * @param edad
     * @param genero
     * @return
     * @throws ModelException
     */
    public String getCodigoUIDIppf(BigDecimal edad, 
                                                    String genero) throws ModelException {
        return clinicoDAO.getCodigoUIDIppf(edad,genero);                                            
                                                    
                                                    }
    /**
     * 
     * @param servicio
     * @return
     * @throws ModelException
     */
     public List<Clcomserv> getCodigoServiIppf(final String servicio) throws ModelException {
        return clinicoDAO.getCodigoServiIppf(servicio);
    
    }
    
    public List<Object[]> getReporteInformacionAborto1(Date fechaInicial, 
                                                     Date fechaFinal, Integer wclinica) throws ModelException{
                                                         return clinicoDAO.getReporteInformacionAborto1(fechaInicial, fechaFinal,wclinica);                                                                             
                                                     }
                                                     
    public List<Object[]> getReporteInformacionAborto2(Date fechaInicial, 
                                                     Date fechaFinal, Integer wclinica) throws ModelException{
                                                         return clinicoDAO.getReporteInformacionAborto2(fechaInicial, fechaFinal,wclinica);                                                                             
                                                     }


    public List<Chcirugprogr> getCirugiasClinicasXFecha(final Date date, final Date fechaFinal, final Integer sala, final Integer codclin, final Long wusuario) throws ModelException{
        return   clinicoDAO.getCirugiasClinicasXFecha(date,fechaFinal,sala,codclin,wusuario);
    }

    public Cpservanex getCpservanex(String servicioOri, String servicioCtl)
        throws ModelException {
        return clinicoDAO.getCpservanex(servicioOri, servicioCtl);
    }

    public Integer getControlesPorServicio(Cnconsclin consclin, Chconsprogra control)
        throws ModelException {
        return clinicoDAO.getControlesPorServicio(consclin, control);
    }
    
    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getFoliosEspermogramaVasectomia(final Long numeroUsuario) throws ModelException {
        return clinicoDAO.getFoliosEspermogramaVasectomia(numeroUsuario);
    }
    
    public List getListaCirugiasHonorarios(Date fechaInicial, Date fechafinal, Integer clinica) throws ModelException {
        return clinicoDAO.getListaCirugiasHonorarios(fechaInicial,fechafinal, clinica);
    }

    public Cvcontrato getCvcontratoClinica(Integer clinica, Integer contrato) throws ModelException {
        return clinicoDAO.getCvcontratoClinica(clinica, contrato);
    }
    
    
    public Chidentiriesgo getIdentificacionRiesgos(Long numeroUsuario) throws ModelException{
        return clinicoDAO.getIdentificacionRiesgos(numeroUsuario);
    }
    
    public void saveIdentificaRiesgo(Chidentiriesgo identiriesgo) throws ModelException{
        clinicoDAO.saveIdentificaRiesgo(identiriesgo);
    }
 
    /**
     * @param consulta
     * @return
     * @throws ModelException
     */
    public Chfertdato getFertilidadDatos(Long numeroConsulta) throws ModelException {
        return clinicoDAO.getFertilidadDatos(numeroConsulta);
    }

    /**
     * @see ClinicoDaoImp#saveRegistroFertilidad(regferti)
     * Salvar Registro de Fertilidad
     */
    public void saveRegistroFertilidad(Cnregferti regferti) throws ModelException {
        clinicoDAO.saveRegistroFertilidad(regferti);
    }
    
    /**
     * @param fechaInicial
     * @param fechaFinal
     * @param contrato
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getDiagnosticosSrvHabilitados(Date fechaInicial, 
                                                        Date fechaFinal, 
                                                        Integer contrato, 
                                                        Integer clinica) throws ModelException {
        return clinicoDAO.getDiagnosticosSrvHabilitados(fechaInicial, fechaFinal, contrato, clinica);
    }

    /**
     * @param fechaInicial
     * @param fechaFinal
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getMedicamentoVacuna(Date fechaI, 
                                               Date fechaF, 
                                               Integer clinica) throws ModelException {
       return clinicoDAO.getMedicamentoVacuna(fechaI, fechaF, clinica);
    }

    /**
     * Obtener Lista de Citologias enviadas para lectura. 
     */
    public List getEnvioCitologiaLectura(Integer numero) throws ModelException {
        return clinicoDAO.getEnvioCitologiaLectura(numero);
    }

    /**
     * @param dia
     * @param codclinica
     * @param idMedico
     * @return
     * @throws ModelException
     */
    public List<Agendamiento> getMisConsultasDiaAgenda(final Date dia, 
                                               final Integer codclinica, 
                                               final BigDecimal idMedico) throws ModelException {
        return clinicoDAO.getMisConsultasDiaAgenda(dia, codclinica, idMedico);
    }

    public Cnconsclin getConsultaFechaUsuario(final Date fecha, final Integer clinica, final String servicio,final Long numusuario) throws ModelException {
        return clinicoDAO.getConsultaFechaUsuario(fecha, clinica, servicio, numusuario);
    }
    
    public void saveConfirmacionServicio(final Chconfiservi confirmacion,Cnconsclin consulta,String userName,String codigoProfesional) throws ModelException{
        clinicoDAO.saveConfirmacionServicio(confirmacion,consulta,userName,codigoProfesional);
    }
    
    public Chconfiservi getConfirmacionServicio(Long numeroConsulta) throws ModelException{
        return clinicoDAO.getConfirmacionServicio(numeroConsulta);
    }

    public List getControlesPorCriterios(Cpservicio servicio) throws ModelException {
        return clinicoDAO.getControlesPorCriterios(servicio);
    }

    public List getServiciosPorTipoConsulta(Long tipoConsulta) throws ModelException {
        return clinicoDAO.getServiciosPorTipoConsulta(tipoConsulta);
    }

    public List<Chcontroladi> getControlAdicional(Long numeroConsulta) throws ModelException {
        return clinicoDAO.getControlAdicional(numeroConsulta);
    }

    public List<Chcontroladi> getControlAdicional(Cnconsclin consclin) throws ModelException {
        return clinicoDAO.getControlAdicional(consclin);
    }
    
    public void saveControlAdicional(final Chcontroladi controlAdi) throws ModelException {
        clinicoDAO.saveControlAdicional(controlAdi);
    }
    
    public List<Cpservicio> getServiciosByCodigos(final List<String> codigosServicio) throws ModelException {
        return clinicoDAO.getServiciosByCodigos(codigosServicio);
    }

    public ClinicoServiceImp()
    {
    }

    private ClinicoDao clinicoDAO;
    
    public Cfadmision getAdmision(Long numeroAdmision)throws ModelException{
        return clinicoDAO.getAdmision(numeroAdmision);
    }
   
    public List<Cfdetaadmision> getDetalleAdmision(Long numeroAdmision)throws ModelException{
    
        return clinicoDAO.getDetalleAdmision(numeroAdmision);
    }
    
    public List<Object[]> getInsumosByServicio(String codigoServicio)throws ModelException{
    
        return clinicoDAO.getInsumosByServicio(codigoServicio);
    }
    
    public  List<Object[]> getRegistroInsumosBynumeroConsulta(Long numeroConsulta)throws ModelException{
    
        return clinicoDAO.getRegistroInsumosBynumeroConsulta(numeroConsulta);
    }
    
    public void saveRegistroInsumos(List<Chreginsumo> chreginsumoList) throws ModelException{
        clinicoDAO.saveRegistroInsumos(chreginsumoList);
    }
    
    public List<Chcauspaus> getListaCausasPausarConsulta() throws ModelException{
        return clinicoDAO.getListaCausasPausarConsulta();
    }
    
    public void saveRegistroTiempoAtencion(Chtiempaten chtiempaten) throws ModelException{
        clinicoDAO.saveRegistroTiempoAtencion(chtiempaten);
    }
    
    public List<Chtiempaten> validacionConsultasAbiertasDelDiaXMedico(Integer codigoMedico) throws ModelException{
        return clinicoDAO.validacionConsultasAbiertasDelDiaXMedico(codigoMedico);
    }
    
    public Chtiempaten consultarTiempoAtencionAbiertaXConsulta(Long numConsulta)throws ModelException{
        return clinicoDAO.consultarTiempoAtencionAbiertaXConsulta(numConsulta);
    }
    
    public List<Chtiempaten> consultarTiempoAtencionVigentesXconsulta(Long numConsulta) throws ModelException{
        return clinicoDAO.consultarTiempoAtencionVigentesXconsulta(numConsulta);
    }
    
    public Chtiempaten consultarTiempoAtencionVigenteXconsulta(Long numConsulta) throws ModelException{
        return clinicoDAO.consultarTiempoAtencionVigenteXconsulta(numConsulta);
    }

    public List<Chregicomp> getRegistroComplementarioUsuario(final Chusuario usuario) throws ModelException {
        return clinicoDAO.getRegistroComplementarioUsuario(usuario);
    }

    public List<Chregitelf> getRegistroTelefonicoUsuario(final Chusuario usuario) throws ModelException {
        return clinicoDAO.getRegistroTelefonicoUsuario(usuario);
    }

    public void saveUsuarioRegistroComplementario(final Chusuario usuario, 
                                                  final String userName) throws ModelException {
        clinicoDAO.saveUsuarioRegistroComplementario(usuario, userName);
    }

    public void saveUsuarioRegistroTelefonico(final Chusuario usuario, 
                                              final String userName) throws ModelException {
        clinicoDAO.saveUsuarioRegistroTelefonico(usuario, userName);
    }

    public void saveRegistroComplementario(Chregicomp registroComplementario) throws ModelException {
        clinicoDAO.saveRegistroComplementario(registroComplementario);
    }

    public void saveRegistroTelefonico(Chregitelf registroTelefonico) throws ModelException {
        clinicoDAO.saveRegistroTelefonico(registroTelefonico);
    }
    
    public List<Object[]> getListaServiciosFactura(Long admision) throws ModelException{
        return clinicoDAO.getListaServiciosFactura(admision);
    }
    
    public Cnconsclin generarConsultaClinica(final Cnconsclin consulta) throws ModelException {
        return clinicoDAO.generarConsultaClinica(consulta);
    }
    
    public void saveDetalleFactura(final List<Cfdetafactura> cfdetafacturaList,final Long numeroAdmision) throws ModelException {
         clinicoDAO.saveDetalleFactura(cfdetafacturaList,numeroAdmision);
    }
    
    public List<Cpprofesio> getProfesionalXClinica(final Long clinica) throws ModelException {
        return clinicoDAO.getProfesionalXClinica(clinica);
    }
    
    public Chgeslabor getLaboratorioXClinica(final Long clinica) throws ModelException {
        return clinicoDAO.getLaboratorioXClinica(clinica);
    }
    
    public void saveLaboratorio(final Chgeslabor chgeslabor) throws ModelException {
        clinicoDAO.saveLaboratorio(chgeslabor);
    }
    
    public List<Cnconsclin> getConsultasDiaXNumIden(final Integer codclinica, final BigDecimal idMedico,final String numIden) throws ModelException {
        return clinicoDAO.getConsultasDiaXNumIden(codclinica, idMedico, numIden);
    }
    
    public void updateConsultaClinicaAgendamiento(final Agendamiento agendamiento) throws ModelException{
             clinicoDAO.updateConsultaClinicaAgendamiento(agendamiento);
    }
    
    public void saveNovedadAdmision(final Cfdetaadmision detaadmision,final Cfdetafactura detafactura,final Chconfiservi confirmacion) throws ModelException{
                     clinicoDAO.saveNovedadAdmision(detaadmision,detafactura,confirmacion);
    }
    
    public void updateCnconsclin(final Cnconsclin consclin) throws ModelException{
                clinicoDAO.updateCnconsclin(consclin);
    }
    
    public List<Cnconsclin> getMisConsultasDiaXNumIden(final Integer codclinica, final BigDecimal idMedico,final String numIden) throws ModelException {
        return clinicoDAO.getMisConsultasDiaXNumIden(codclinica, idMedico, numIden);
    }
    public List<Cnconsclin> getCnconsclinLectura(final Long numeroUsuario, int codigoClinica, final String codigoEtapa, List<Integer> listaTipoHistoria) throws ModelException {
        return clinicoDAO.getCnconsclinLectura(numeroUsuario, codigoClinica, codigoEtapa, listaTipoHistoria);
    }
    
       public List<Cnconsclin> getCnconsclinLecturaMod(final Long numeroUsuario, int codigoClinica, final String codigoEtapa, List<Integer> listaTipoHistoria) throws ModelException {
           return clinicoDAO.getCnconsclinLecturaMod(numeroUsuario, codigoClinica, codigoEtapa, listaTipoHistoria);
       }
    
    public List getCitologiaExtendedEntregableBetweenFechaClinica(Date fechaInicial, Date fechaFinal,
            int codigoClinica, final List<Integer> listaTipoHistoria) throws ModelException {
        return clinicoDAO.getCitologiaExtendedEntregableBetweenFechaClinica(fechaInicial, fechaFinal, codigoClinica, listaTipoHistoria);
    }
    
    public List<Cnconsclin> getConsultasDiaNotaEnfermeria(final Date dia, final Integer codclinica) throws ModelException {
        return clinicoDAO.getConsultasDiaNotaEnfermeria(dia, codclinica);
    }
    
    public List<Cnconsclin> getConsultasDiaNotaEnfermeriaXNumIden(final Integer codclinica,final String numIden) throws ModelException {
        return clinicoDAO.getConsultasDiaNotaEnfermeriaXNumIden(codclinica, numIden);
    }
    
    public Chingresoenf getIngresoEnfermeriaProcedimiento(Long hielnumero) throws ModelException {
        return clinicoDAO.getIngresoEnfermeriaProcedimiento(hielnumero);
    }                                                 

    public Cncitovphlect getLecturaCitologiaVph(Integer consecutivo) throws ModelException{
        return clinicoDAO.getLecturaCitologiaVph(consecutivo);
    }
    
    public void saveLecturaCitologiaVph(Cncitovphlect lectura) throws ModelException{
        clinicoDAO.saveLecturaCitologiaVph(lectura);
    }
    
    public Chconsulta saveChconsulta(final Cnconsclin cnconsclin, final String estado, final String codigoFuncionario) throws ModelException{
        return  clinicoDAO.saveChconsulta(cnconsclin,estado,codigoFuncionario);
    }
        
    /**
    * 
    * @param fechaInicial
    * @param fechaFinal
    * @return
    * @throws ModelException
    */
    public List<Object[]> getReporteUsuariosIppf(Date fechaInicial,
                                                    Date fechaFinal, String periodo) throws ModelException {
      return clinicoDAO.getReporteUsuariosIppf(fechaInicial,fechaFinal,periodo)  ;                                            
                                                    }
    public Clcateippf getClcateippf(Integer ccincodigo)
        throws ModelException
    {
        return clinicoDAO.getClcateippf(ccincodigo);
    }

    public List<Clcomserv> getClcomservAll() throws ModelException {
       return clinicoDAO.getClcomservAll();
    
    }
    public List<Cnconsclin> getCnconsclinLecturaXAdmision(final Long numeroUsuario, final BigDecimal admision) throws ModelException {
        return clinicoDAO.getCnconsclinLecturaXAdmision(numeroUsuario,admision);
    }
    
    public List<Object[]> getListaServiciosXAdmision(Long admision,String opcion) throws ModelException {
        return clinicoDAO.getListaServiciosXAdmision(admision,opcion);
    }
    public List<Object[]> getListaServiciosDobleConUnaAtencion(Long admision,String servicio) throws ModelException {
        return clinicoDAO.getListaServiciosDobleConUnaAtencion(admision,servicio);
    }
    
    public List<Object[]> getListaLaboratorioFacturados(Long admision) throws ModelException {
        return clinicoDAO.getListaLaboratorioFacturados(admision);    
    }
    
    public List<Object[]> getRegistrosSegTelefonico(Long clinica,Date fechaInicial, Date fechafinal) throws ModelException {
        return clinicoDAO.getRegistrosSegTelefonico(clinica,fechaInicial,fechafinal);
    }

    public void saveOrdenCirugiaLiberacion(final List<Cnconsclin> listadeConsultasClinicas, 
                                           final List<Cfdetafactura> cfdetafacturaList, 
                                           final Long numeroAdmision, 
                                           final Chordecirugi orden) throws ModelException {
        clinicoDAO.saveOrdenCirugiaLiberacion(listadeConsultasClinicas, 
                                              cfdetafacturaList, 
                                              numeroAdmision, orden);
    }
    
    public void saveListRemisionInterconsultaCirugiaLiberacion(final List<Chremision> lstRemision, 
                                                               final Long numeroConsulta, 
                                                               final String tipoServicio, 
                                                               final Integer consecutivo, 
                                                               final List<Cnconsclin> listadeConsultasClinicas, 
                                                               final List<Cfdetafactura> cfdetafacturaList, 
                                                               final Long numeroAdmision) throws ModelException {
       
       clinicoDAO.saveListRemisionInterconsultaCirugiaLiberacion(lstRemision, 
                                             numeroConsulta, 
                                             tipoServicio, consecutivo,
                                             listadeConsultasClinicas,
                                             cfdetafacturaList,
                                             numeroAdmision);
                                                      
   }

    public void saveListExamenesLaboratorioCirugiaLiberacion(final List<Chexamelabor> lstRemision, 
                                                             final Long numeroConsulta, 
                                                             final String tipoServicio, 
                                                             final Integer consecutivo, 
                                                             final String descripcionRemision, 
                                                             final List<Cnconsclin> listadeConsultasClinicas, 
                                                             final List<Cfdetafactura> cfdetafacturaList, 
                                                             final Long numeroAdmision) throws ModelException {

        clinicoDAO.saveListExamenesLaboratorioCirugiaLiberacion(lstRemision, 
                                                                  numeroConsulta, 
                                                                  tipoServicio, 
                                                                  consecutivo, 
                                                                  descripcionRemision, 
                                                                  listadeConsultasClinicas, 
                                                                  cfdetafacturaList, 
                                                                  numeroAdmision);

    }
    
    
    public List<Cpservicio> getExamenesLaboratorioFertilidadPorCriterios(Cpservicio servicio) throws ModelException {
        return clinicoDAO.getExamenesLaboratorioFertilidadPorCriterios(servicio);
    }
    
    public List<Cnconsclin> getConsultasLaboratorioXFactura(final Integer tipoDcoumento, final BigDecimal numeroDocumento) throws ModelException{
        return clinicoDAO.getConsultasLaboratorioXFactura(tipoDcoumento,numeroDocumento);
    }
    
    public void closeLaboratorio(final List<Cnconsclin> lstconsulta, 
                                   final String userName) throws ModelException{
                 clinicoDAO.closeLaboratorio(lstconsulta,userName);
                                   }
    
    public Cncitologi getCitologiaByAdmisionAndTipoHistoria(Cnconsclin consulta,Integer tipoHistoria ) throws ModelException {
        return clinicoDAO.getCitologiaByAdmisionAndTipoHistoria(consulta,tipoHistoria);
    }
    public List<Cfdetafactura> validacionTomaPaquete(Integer consultaClinica) throws ModelException {
        return clinicoDAO.validacionTomaPaquete(consultaClinica);
    }

    public List<Cfdetafactura> validacionTomaPaquete(Long numAdmision, String codServicio, Long numConsulta) throws ModelException {
        return clinicoDAO.validacionTomaPaquete(numAdmision, codServicio, numConsulta);
    }
    
    public List<Cfdetafactura> validacionPaqueteLectura(Integer consultaClinica) throws ModelException {
        return clinicoDAO.validacionPaqueteLectura(consultaClinica);
    }
    
    
    
//  public Cffactura getCffacturaByAdmision(Long numAdmision) throws ModelException {
//      return clinicoDAO.getCffacturaByAdmision(numAdmision);
//  }

   public Agendamiento getPrimerAgendaUsuarioServicioFecha(final Date fecha, 
                                         final Integer clinica, 
                                         final Integer tipoagenda, 
                                         final Long numusuario) throws ModelException {
      return clinicoDAO.getPrimerAgendaUsuarioServicioFecha(fecha, clinica, tipoagenda, numusuario);
      
                                         }                                     
                                             
    public List<Chtipointerc> getInterconsultaPorCriterios(Chtipointerc interconsulta) throws ModelException {
            return clinicoDAO.getInterconsultaPorCriterios(interconsulta);
    }
    
    public Chtipointerc getInterconsultaPorCriterios(String interconsulta) throws ModelException{
        return clinicoDAO.getInterconsultaPorCriterios(interconsulta);
    }
    
    
    public List<Cnconsclin> getServiciosXFacturaMedicamentoDia(final Cnconsclin consulta) throws ModelException{
        return clinicoDAO.getServiciosXFacturaMedicamentoDia(consulta);
    }

    public Cfdetafactura validacionServicioEntregaResultado(Integer consultaClinica) throws ModelException {
        return clinicoDAO.validacionServicioEntregaResultado(consultaClinica);
    }

    public void saveDetalleFactura(final Cfdetafactura detafactura) throws ModelException {
        clinicoDAO.saveDetalleFactura(detafactura);
    }
    
    public List<Chtipoantece> getTipoAntecedentesIve(String tipoAntecedente) throws ModelException {
        return clinicoDAO.getTipoAntecedentesIve(tipoAntecedente);
    }
    
    public void saveAntecedentesIve(final Long numeroConsulta,final Chantecdetal antecedentesDetallado) throws ModelException {
                                 
         clinicoDAO.saveAntecedentesIve(numeroConsulta,antecedentesDetallado);
                                 
    }
    public Chantecdetal getAntecedentesDetallado(Long numeroConsulta) throws ModelException {
        return clinicoDAO.getAntecedentesDetallado(numeroConsulta);
    }
    public List getCopiaVphXconsecutivo(Long numeroUsuario,Integer consecutivoCito) throws ModelException {
        return clinicoDAO.getCopiaVphXconsecutivo(numeroUsuario,consecutivoCito);
    }
    public List<Object[]> getTomaVphXclinicaAndFecha(Date fechaInicial,Date fechaFinal, Integer clinica) throws ModelException {
        return clinicoDAO.getTomaVphXclinicaAndFecha(fechaInicial,fechaFinal,clinica);
    }

    public void saveAntecedenteObstetricopr(Chanteobstpr chanteobstpr)
        throws ModelException {
            clinicoDAO.saveAntecedenteObstetricopr(chanteobstpr);
        }

    public  Chanteobstpr getAntecedenteObstetricopr(Long consulta)
        throws ModelException {
        return clinicoDAO.getAntecedenteObstetricopr(consulta);
        }
   
    public void saveAntecedenteGinecopre(Chanteginecopre chanteginecopre) throws ModelException {
        clinicoDAO.saveAntecedenteGinecopre(chanteginecopre);
    }

    public Chanteginecopre getAntecedentesGinecologicospre(Cnconsclin cnconsclin) throws ModelException {
        return clinicoDAO.getAntecedentesGinecologicospre(cnconsclin);
    }

    public Chanteginecopre getAntecedentesGinecologicospre(Long numeroUsuario) throws ModelException {
        return clinicoDAO.getAntecedentesGinecologicospre(numeroUsuario);
    }

    public Chanteginecopre getUltimoAntecedentesGinecologicospre(Long numeroUsuario) throws ModelException {
        return clinicoDAO.getUltimoAntecedentesGinecologicospre(numeroUsuario);
    }
    
    public void saveValoracionBiopsicosocial(Chvalorabiopsi valoracion) throws ModelException {
        clinicoDAO.saveValoracionBiopsicosocial(valoracion);
    }
   
   public Chvalorabiopsi getValoracionBiopsicosocial(Long numeroConsulta) throws ModelException {
       return clinicoDAO.getValoracionBiopsicosocial(numeroConsulta);
    }

    public Chasesoriaive getAsesoriaIve(Long consulta) throws ModelException {
        return clinicoDAO.getAsesoriaIve(consulta);
    }
    
    public void saveAsesoriaIve(Chasesoriaive asesoria) throws ModelException {
         clinicoDAO.saveAsesoriaIve(asesoria);
    }
    
    public List<Chmetodoplan> getMetodosPlanificacionIve(String sexo) throws ModelException{
        return clinicoDAO.getMetodosPlanificacionIve(sexo);
    }
    public  List getConsultasTuberculinaDia(Date dia, Integer codclinica, BigDecimal idMedico,String numeroIden) throws ModelException{
        return clinicoDAO.getConsultasTuberculinaDia(dia, codclinica, idMedico,numeroIden);
    }
    public void saveLstRegistroOrdenCE(final List<Chcontroorden> orden) throws ModelException {
         clinicoDAO.saveLstRegistroOrdenCE(orden);
    }
    
    public List<Object[]> getListaServiciosValidacionRetiro(Long admision,String servicio) throws ModelException {
        return clinicoDAO.getListaServiciosValidacionRetiro(admision,servicio);
    }

    public void saveLstRegistroLiquidosNota(final List<Chcontroliqu> liquidos, 
                                            final Long numero, 
                                            final List<Chformulaliq> lstFormulados, 
                                            final List<Chnotaenferm> listaChnotaenferm) throws ModelException {
        clinicoDAO.saveLstRegistroLiquidosNota(liquidos, numero, lstFormulados, 
                                               listaChnotaenferm);
    }
    
    public List<Chconsulta> getFoliosUsuarioNotaComplementariaEnfemeria(final Long numeroUsuario, 
                                                            final String userName) throws ModelException {
        return clinicoDAO.getFoliosUsuarioNotaComplementariaEnfemeria(numeroUsuario,userName);
                                                            
    }
    
    public void saveNotaComplementarioEnfermeria(final Chregcomenf nota, final Chrefepaci referenciaPaciente) throws ModelException {
        clinicoDAO.saveNotaComplementarioEnfermeria(nota,referenciaPaciente);
    }
    
    public Chantecespec getAntecedentesTuberculina(Long consulta) throws ModelException {
        return clinicoDAO.getAntecedentesTuberculina(consulta);
    }
    
    public void saveAntecedentesTuberculina(Chantecespec chantecespec) throws ModelException {
        clinicoDAO.saveAntecedentesTuberculina(chantecespec);
    }

    public Chantecpatol getAntecedentesPatologicosTuberculina(Long consulta) throws ModelException {
        return clinicoDAO.getAntecedentesPatologicosTuberculina(consulta);
    }
    public void saveAntecedentesPatologicosTuberculina(Chantecpatol chantecpatol) throws ModelException {
        clinicoDAO.saveAntecedentesPatologicosTuberculina(chantecpatol);
    }

    public Chantecfarma getAntecedentesFarmacologicosTuberculina(Long consulta) throws ModelException {
        return clinicoDAO.getAntecedentesFarmacologicosTuberculina(consulta);
    }
    public void saveAntecedentesFarmacologicosTuberculina(Chantecfarma chantecfarma) throws ModelException {
        clinicoDAO.saveAntecedentesFarmacologicosTuberculina(chantecfarma);
    }


    public List<Cnconsclin> getCnconsclinLecturaTuberculina(final Long numeroUsuario, int codigoClinica, final String codigoEtapa, List<Integer> listaTipoHistoria) throws ModelException {
        return clinicoDAO.getCnconsclinLecturaTuberculina(numeroUsuario, codigoClinica, codigoEtapa, listaTipoHistoria);
    }
    
    public Chlecttuber getLecturaTuberculina(Long consulta) throws ModelException {
        return clinicoDAO.getLecturaTuberculina(consulta);
    }
    
     
       public void saveLecturaTuberculina(Chlecttuber chlecttuber) throws ModelException {
           clinicoDAO.saveLecturaTuberculina(chlecttuber);
       }  

       public Cpusuario getUsuarioPorOperador(String curcusuari)
           throws ModelException
       {
           return clinicoDAO.getUsuarioPorOperador(curcusuari);
       }
       
       public List<Chconsulta> getFoliosUsuarioInformePsicologico(final Long numeroUsuario, 
                                                               final String userName) throws ModelException { 
                                                               
            return clinicoDAO.getFoliosUsuarioInformePsicologico(numeroUsuario,userName);
        }
        
       public void saveInformePsicologico(final Chinfopsico informe, final Chautoinfopsic autoriza) throws ModelException {
           clinicoDAO.saveInformePsicologico(informe,autoriza);
       }
       
       public List<Cpprofesio> getProfesionalXCedulaXNombre(BigDecimal cedulaprof,Integer codclin,String nombreProf) throws ModelException {
           return clinicoDAO.getProfesionalXCedulaXNombre(cedulaprof,codclin,nombreProf);
       }
       
       public List<Object[]> getReporteComplEnfer(Date fechaInicial, Date fechaFinal, Integer clinica) throws ModelException {
           return clinicoDAO.getReporteComplEnfer(fechaInicial, fechaFinal,clinica);
       }
      
       
       public Chconsulta getConsultaActualHisteroscopia(Long numeroConsulta)
           throws ModelException
       {
           return clinicoDAO.getConsultaActualHisteroscopia(numeroConsulta);
       }
       
       public Chhisteroscopia getConsultaRegistroHisteroscopia(Long numeroConsulta)
           throws ModelException
       {
           return clinicoDAO.getConsultaRegistroHisteroscopia(numeroConsulta);
       }
       
       public Chhallahistero getConsultaHallazgoHisteroscopia(Long numeroConsulta)
           throws ModelException
       {
           return clinicoDAO.getConsultaHallazgoHisteroscopia(numeroConsulta);
       }
       
       
       
       public void saveCuestionarioCovid(Cfencuecovid cuestionario) throws ModelException{
            clinicoDAO.saveCuestionarioCovid(cuestionario);
       }
       
       public Cfencuecovid getEncuestaCovidXUsuario(final Long numeroUsuario, 
                                                               final Date fechaConsulta) throws ModelException{
            return clinicoDAO.getEncuestaCovidXUsuario(numeroUsuario,fechaConsulta)  ;                                      
    }
       
       public List<Object[]> getReporteReferencia(Integer codClinica, 
                                                             Date fechaInicial, 
                                                             Date fechaFinal) throws ModelException {
       return clinicoDAO.getReporteReferencia(codClinica,fechaInicial,fechaFinal);
        }
       public void saveAntecedentesDetFertilidad(final Long numeroConsulta, final Chantecdetal antecedentesDetallado) throws ModelException {
            clinicoDAO.saveAntecedentesDetFertilidad(numeroConsulta,antecedentesDetallado);
        }
       
       public List<Chantecdetal> getHistorialAntecedentesDetallado(Long numeroUsuario) throws ModelException {
           return clinicoDAO.getHistorialAntecedentesDetallado(numeroUsuario);
       }

    public List<Object[]> getRegistrosLogImpresion(Long clinica, 
                                                   Long numeroUsuario, 
                                                   Date fechaInicial, 
                                                   Date fechafinal) throws ModelException {

        return clinicoDAO.getRegistrosLogImpresion(clinica,numeroUsuario,fechaInicial,fechafinal);

    }
    
       public List<Chconsulta> getFoliosUsuarioXnumConsulta(final Long numeroConsulta) throws ModelException {
           return clinicoDAO.getFoliosUsuarioXnumConsulta(numeroConsulta);
       }
       
       public List getCopiaTuberculina(Long numeroUsuario)
           throws ModelException
       {
           return clinicoDAO.getCopiaTuberculina(numeroUsuario);
       }
       
       public List<Chescvalcai> getEscalaValoracionCaidasXdia(Long numero) throws ModelException {
           return clinicoDAO.getEscalaValoracionCaidasXdia(numero);
       }
       
       public void saveLecturaVphModificacion(final Cncitovphlect lectura) throws ModelException {
            clinicoDAO.saveLecturaVphModificacion(lectura);
       }
       
       public List<Cnconsclin> getCnconsclinLecturaVPHMod(final Long numeroUsuario, 
               final int codigoClinica, 
               final String codigoEtapa, 
               List<Integer> listaTipoHistoria) throws ModelException{
                   return clinicoDAO.getCnconsclinLecturaVPHMod(numeroUsuario, codigoClinica, codigoEtapa, listaTipoHistoria);
       }
       
       public List<Cnconsclin> getConsultaRegistroPAPsicologia(Long numeroUsuario)
           throws ModelException
       {
           return clinicoDAO.getConsultaRegistroPAPsicologia(numeroUsuario);
       }
       
       public void savePAPsicologia(Chpapsicologico nota, Chusuario usuario,Cnconsclin consulta)
           throws ModelException
       {
           clinicoDAO.savePAPsicologia(nota, usuario,consulta);
       }
       
       public List getCopiaPapsicologico(Long numeroUsuario)
           throws ModelException
       {
           return clinicoDAO.getCopiaPapsicologico(numeroUsuario);
       }
       
       public Chpapsicologico getPapsicologicosUser(Long consulta) throws ModelException {
           return clinicoDAO.getPapsicologicosUser(consulta);
       }
       
       public List<Cnconsclin> getMisConsultasCovidAnticuerpos(final Date dia, 
                                                          final Integer codclinica, 
                                                          final BigDecimal idMedico) throws ModelException
       {
           return clinicoDAO.getMisConsultasCovidAnticuerpos(dia, codclinica, idMedico);
       }
       
       
    //para adaIve
    public Chregisabort findOneRegistroUsuarioAbort(Long numeroUsuario) throws ModelException {
        return clinicoDAO.findOneRegistroUsuarioAbort(numeroUsuario);
    }

    public void saveSeguimientoUsuarioAbort(Chcontabor chcontabor) throws ModelException {
        clinicoDAO.saveSeguimientoUsuarioAbort(chcontabor);
    }

    public void saveRegistroUsuarioAbort(Chregisabort chregisabort) throws ModelException {
        clinicoDAO.saveRegistroUsuarioAbort(chregisabort);
    }

    public Chusuarioabor findOneUsuarioAbort(Long numeId, String tipoId) throws ModelException {
        return clinicoDAO.findOneUsuarioAbort(numeId,tipoId);
    }
    
    
    public List<Cnconsclin> getConsultasDiaPruebasRapidas(final Date dia, final Integer codclinica, final BigDecimal idMedico, final String numeroIdentificacion) throws ModelException{
        return clinicoDAO.getConsultasDiaPruebasRapidas(dia,codclinica,idMedico,numeroIdentificacion);
    }
    
    public List<Cnconsclin> getConsultasPruebasRapidasXFactura(final Integer tipoDcoumento, 
                                                            final BigDecimal numeroDocumento) throws ModelException {
    
        return clinicoDAO.getConsultasPruebasRapidasXFactura(tipoDcoumento,numeroDocumento);                                                        
    }
  
    
    public void saveAnticuerposCovid(Chpruecovidanticu covidAnticuerpo,final Chusuario usuario, final Cnconsclin consulta) throws ModelException{
       clinicoDAO.saveAnticuerposCovid(covidAnticuerpo,usuario,consulta);
    
    }
    
    public Chpruecovidanticu getpruebaAnticuerpos(Long numeroConsulta) throws ModelException{
         return clinicoDAO.getpruebaAnticuerpos(numeroConsulta);
    }
    
    public List<Cnconsclin> getMisConsultasCovidAntigenos(final Date dia, 
                                                       final Integer codclinica, 
                                                       final BigDecimal idMedico) throws ModelException
    {
        return clinicoDAO.getMisConsultasCovidAntigenos(dia, codclinica, idMedico);
    }
    
    public void saveAntigenosCovid(Chpruecovidantige covidAnticuerpo) throws ModelException{
       clinicoDAO.saveAntigenosCovid(covidAnticuerpo);
    
    }
    
    public Chpruecovidantige getpruebaAntigenos(Long numeroConsulta) throws ModelException{
         return clinicoDAO.getpruebaAntigenos(numeroConsulta);
    }
    
    public List<Object[]> getRegistrosAnticuerposCovid(Long clinica,
                                                    Long numeroUsuario,
                                                    Date fechaInicial, 
                                                    Date fechafinal) throws ModelException {
         return clinicoDAO.getRegistrosAnticuerposCovid(clinica,numeroUsuario,fechaInicial,fechafinal);
       }
       
    public List<Object[]> getRegistrosAntigenosCovid(Long clinica,
                                                    Long numeroUsuario,
                                                    Date fechaInicial, 
                                                    Date fechafinal) throws ModelException {
         return clinicoDAO.getRegistrosAntigenosCovid(clinica,numeroUsuario,fechaInicial,fechafinal);
       }
    
    
    public ResultadosLCResponse envioResultadosColposcopiaSaludTotal(Chusuario usuario, 
                                                           Cnconsclin consulta,
                                                           Chimprdiag impresion,String userName) throws ModelException {
                                                           
        return clinicoDAO.envioResultadosColposcopiaSaludTotal(usuario,consulta,impresion,userName);                                                  
    }
    
    public ResultadosLCResponse envioResultadosVphSaludTotal(Chusuario usuario, 
                                                           Cnconsclin consulta,
                                                           Cncitovphlect lectura) throws ModelException {
        return clinicoDAO.envioResultadosVphSaludTotal(usuario,consulta,lectura);                                                                                                     
    }
    
    public ResultadosLCResponse envioResultadosBaseLiquidSaludTotal(Chusuario usuario, 
                                                           Cnconsclin consulta,
                                                           Cncitolect lectura) throws ModelException{
                                                           
        return clinicoDAO.envioResultadosBaseLiquidSaludTotal(usuario,consulta,lectura);                                                    
    }
    
    public List<Chantegineco> getAntecedentesGinecologicosXUsuario(final Long usuario) throws ModelException {
    
        return clinicoDAO.getAntecedentesGinecologicosXUsuario(usuario);
    
    }
    
    public void savePruebasRapidas(final Chpruerapi chpruerapi,final Chusuario usuario, final Cnconsclin consulta, 
                                   final String userName) throws ModelException{
                                       clinicoDAO.savePruebasRapidas(chpruerapi,usuario,consulta,userName);
                                   }
                                   
                                   
    public void closeAnticuerposAntigenoCovid(final Cnconsclin consulta, 
                                   final String userName) throws ModelException{
                                       clinicoDAO.closeAnticuerposAntigenoCovid(consulta,userName);  
                                   }                            
                                   
    public List getCitologiaLecturaUsuario(final String tipoId, final Long numIde,final int codCentro, final String tipoLectura, 
                                     final  List<Integer> listaTipoHistoria) throws ModelException{
           return clinicoDAO.getCitologiaLecturaUsuario(tipoId, numIde,codCentro, tipoLectura, listaTipoHistoria);             
         }

    public List<Object[]> getPruebasRapidas(Long codigoUsuario) throws ModelException {
        return clinicoDAO.getPruebasRapidas(codigoUsuario);
    }

    public List<Object[]> getPruebasRapidasByConsulta(Long consulta) throws ModelException {
        return clinicoDAO.getPruebasRapidasByConsulta(consulta);
    }
    
    public List<Object[]> getRegistrosVPH(Long clinica,Date fechaInicial,Date fechafinal) throws ModelException {
            
    	return clinicoDAO.getRegistrosVPH(clinica,fechaInicial,fechafinal);

    	}   
        
    public List<Object[]> getReportePruebasRapidas(Integer codClinica, 
                                               Date fechaInicial, 
                                               Date fechaFinal, String tDoc, Long numIden) throws ModelException{
                                                   return clinicoDAO.getReportePruebasRapidas(codClinica, fechaInicial, fechaFinal, tDoc, numIden);
                                               }                                       
    public List<Object[]> getPruebasAnticuerposByConsulta(Long consulta) throws ModelException {
        return clinicoDAO.getPruebasAnticuerposByConsulta(consulta);
    }
    
    public List<Object[]> getPruebasAntigenosByConsulta(Long consulta) throws ModelException {
        return clinicoDAO.getPruebasAntigenosByConsulta(consulta);
    }
    
    public ResultadosLCResponse envioResultadosPatologiaSaludTotal(Chusuario usuario, 
            Cnconsclin consulta,
            Chmotivocon motivo,String userName) throws ModelException {
            
    	return clinicoDAO.envioResultadosPatologiaSaludTotal(usuario, consulta, motivo, userName);                                                    
    }     
    
    public List<Cnconsclin> getServiciosXFacturaMedicamentoDiaxAdmision(final Cnconsclin consulta) throws ModelException {
    
        return clinicoDAO.getServiciosXFacturaMedicamentoDiaxAdmision(consulta);                                                    
    }
    
    public List<Cnconsclin> getMedicamentosByAdm(final BigDecimal admision) throws ModelException {
         return clinicoDAO.getMedicamentosByAdm(admision);
    }
    
    public Chmedicament getMedicamentoByConsultaAsociada(final Long consulta) throws ModelException{
        return clinicoDAO.getMedicamentoByConsultaAsociada(consulta);
    }

    public List<Chmedicament> getMedicamentoByConsulta(final Long consulta) throws ModelException{
        return clinicoDAO.getMedicamentoByConsulta(consulta);
    }

    public void saveOrUpdateParamCorreo(Chcorreo correo) throws ModelException {
        clinicoDAO.saveOrUpdateParamCorreo(correo);
    }

    public List<Chcorreo> readCorreo() throws ModelException {
        return clinicoDAO.readCorreo();
    }

    public List<Cpcontrato> getCriteriosContrato(Cpcontrato contrato,boolean exacto) throws ModelException {
        return clinicoDAO.getCriteriosContrato(contrato,exacto);
    }

    public List<Chcorreo> getCorreosByParam(Long numeroContrato) throws ModelException {
        return clinicoDAO.getCorreosByParam(numeroContrato);
    }

    public Object[] getNombreEntidad(String codigoEntidad) throws ModelException {
        return clinicoDAO.getNombreEntidad(codigoEntidad);
    }
    


    public List<Cnconsclin> getMisConsultasDiaPruebasRapidas(Date dia, 
                                                             Integer codclinica, 
                                                             BigDecimal idMedico, 
                                                             String numeroIdentificacion) throws ModelException {
        return clinicoDAO.getMisConsultasDiaPruebasRapidas(dia,codclinica,idMedico,numeroIdentificacion);
    }

    public Chpruerapi getOnePruebasRapidasByConsulta(Long consulta) throws ModelException {
        return clinicoDAO.getOnePruebasRapidasByConsulta(consulta);
    }

    public void closePruebasRapidas(Chpruerapi chpruerapi, Chusuario usuario, 
                                    Cnconsclin consulta, String userName) throws ModelException {
                                    clinicoDAO.closePruebasRapidas(chpruerapi,usuario,consulta,userName);
    }

    public List<Object[]> getRegistrosPruebasCovid(Long clinica, Long contrato, 
                                                   Date fechaInicial, 
                                                   Date fechafinal,String tipoPrueba) throws ModelException {
        return clinicoDAO.getRegistrosPruebasCovid(clinica,contrato,fechaInicial,fechafinal,tipoPrueba);
    }

    public List<Cpcontrato> getCriteriosContratoByClinica(Cpcontrato contrato, 
                                                          boolean exacto, 
                                                          Integer numeroClinica) throws ModelException {
        return clinicoDAO.getCriteriosContratoByClinica(contrato,exacto,numeroClinica);
    }
    
    public boolean getConsultaClinicaIVEXUsuario(final Cnconsclin consulta, final boolean  accion) throws ModelException {
        return clinicoDAO.getConsultaClinicaIVEXUsuario(consulta,accion);
    }
    
    public Cfremiadmi getRemisionAdmision(Long numeroAdmision) throws ModelException {
        return clinicoDAO.getRemisionAdmision(numeroAdmision);
    }
    
    public List<Cnconsclin> getConsultasFragmentacionEspermaDia(final Date dia, 
                                                       final Integer codclinica, 
                                                       final BigDecimal idMedico, 
                                                       final String numeroIden) throws ModelException {
        return clinicoDAO.getConsultasFragmentacionEspermaDia(dia,codclinica,idMedico,numeroIden);                                              
    }
    
    public boolean  getDetalleAdmisionXTipoHistoria(Long numeroAdmision,Integer tipoHistoria) throws ModelException {
        return clinicoDAO.getDetalleAdmisionXTipoHistoria(numeroAdmision,tipoHistoria);
    }
    
    public List<Cnconsclin>  getConsultaAdmisionXTipoHistoria(Long numeroAdmision,Integer tipoHistoria) throws ModelException {
        return clinicoDAO.getConsultaAdmisionXTipoHistoria(numeroAdmision,tipoHistoria);
    }
    
    public void atenderConsultaClinica(final List<Cnconsclin> listaConsultas, final String userName) throws ModelException {
         clinicoDAO.atenderConsultaClinica(listaConsultas,userName);
    }
    public boolean  getConsultaAdmisionXTiposHistorias(Long numeroAdmision,List<Integer> listaTipoHistoria) throws ModelException {
        return clinicoDAO.getConsultaAdmisionXTiposHistorias(numeroAdmision,listaTipoHistoria);
    }
    public List<Cnconsclin>  getConsultaAdmisionXGrupoSubGrupoInterrupcion(Long numeroAdmision) throws ModelException {
        return clinicoDAO.getConsultaAdmisionXGrupoSubGrupoInterrupcion(numeroAdmision);
    }
    
    public void saveFragmentacionEspermatica(final Chfragesperma fragesperma) throws ModelException {
        clinicoDAO.saveFragmentacionEspermatica(fragesperma);
    }

    public Chfragesperma getFragmentEsperma(Long numeroConsulta) throws ModelException {
       return clinicoDAO.getFragmentEsperma(numeroConsulta);

    }
    
    public List getCopiaTestFragE(Long numeroUsuario)
        throws ModelException
    {
        return clinicoDAO.getCopiaTestFragE(numeroUsuario);
    }
    
    public Chfragesperma getTestFargEConsulta(Long numeroConsulta) throws ModelException {
    
        return clinicoDAO.getTestFargEConsulta(numeroConsulta);
    }

    public Cnprofxcon getProfesionalByConsulta(Long numeroConsulta) throws ModelException {
        return clinicoDAO.getProfesionalByConsulta(numeroConsulta);
    }
    
    public List<Chsegutelefo> getListVinisoUsuario(final Chusuario usuario) throws ModelException{
        return clinicoDAO.getListVinisoUsuario(usuario);
    }
    
    public List<Chplanconsinfo> getConsentimientoInformado() throws ModelException {
        return clinicoDAO.getConsentimientoInformado();
    }
    
    public void saveConsentimientoInformado(final Chplanconsinfo consentimiento) throws ModelException {
        clinicoDAO.saveConsentimientoInformado(consentimiento);
    }
    
    public Chplanconsinfo getConsentimientoInformadoCodigo(Long codigo) throws ModelException {
        return clinicoDAO.getConsentimientoInformadoCodigo(codigo);
    }
    
    public List<Chconinfxcon> getConsentimientoXConsulta(Long numConsulta) throws ModelException {
        return clinicoDAO.getConsentimientoXConsulta(numConsulta);
    }
    
    public void saveConsentimientoInformadoXconsulta(final List<Chconinfxcon> listConsentimientoXConsulta) throws ModelException {
         clinicoDAO.saveConsentimientoInformadoXconsulta(listConsentimientoXConsulta);
    }
    
    public List<Chplanconsinfo> getConsentimientoInformadoXCliterios(Chplanconsinfo chplanconsinfo) throws ModelException {
        return clinicoDAO.getConsentimientoInformadoXCliterios(chplanconsinfo);
    }
    
    public Chplanconsinfo getConsentimientoInformadoXCodigo(String codigo) throws ModelException {
        return clinicoDAO.getConsentimientoInformadoXCodigo(codigo);
    }
    public Chfertdato getDatosFertilidadUltimaPareja(Long numUsuario, String tipoIden) throws ModelException {
        return clinicoDAO.getDatosFertilidadUltimaPareja(numUsuario,tipoIden);
    }

    public List<Object[]> getPruebaDeEmbarazoDia(Long numeroUsuario, 
                                                 Date fecha, Date fechafinal) throws ModelException {
        return clinicoDAO.getPruebaDeEmbarazoDia(numeroUsuario,fecha,fechafinal);
    }


    public List<Cnconsclin> getConsultasSaludTotal(final Date fechaIni,final Date fechaFin, 
                                            final Integer codclinica, 
                                            final Integer numDocPac,final Integer contrato1,
                                            final Integer contrato2,final String
                                            tipoReproceso) throws ModelException{
        return clinicoDAO.getConsultasSaludTotal(fechaIni,fechaFin,codclinica,numDocPac,contrato1,contrato2,tipoReproceso);                                           
    }

    
    public void saveOrUpdateChcorrelec(Chcorrelec correlec )throws ModelException {
        clinicoDAO.saveOrUpdateChcorrelec(correlec);
    }

    public Chcorrelec getChcorrelec(Long numConsulta) throws ModelException {
        return clinicoDAO.getChcorrelec(numConsulta);
        
    }
    
    public void atenderConsultaClinicaIve(final List<Cnconsclin> listaConsultas, 
                                       final String userName, Cnconsclin consultaActual ) throws ModelException{
                                           clinicoDAO.atenderConsultaClinicaIve(listaConsultas,userName,consultaActual);
                                       }

    public List<Cppais> getPaises() throws ModelException {
        return clinicoDAO.getPaises();
    }
}
