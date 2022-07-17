
// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:38:45 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoDao.java

package org.profamilia.hc.model.dao;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Agendamiento;
import org.profamilia.hc.model.dto.Ccdetafact;
import org.profamilia.hc.model.dto.Ccfactserv;
import org.profamilia.hc.model.dto.Ccfactvent;
import org.profamilia.hc.model.dto.Cfadmision;
import org.profamilia.hc.model.dto.Cfdetaadmision;
import org.profamilia.hc.model.dto.Cfdetafactura;
//import org.profamilia.hc.model.dto.Cffactura;
import org.profamilia.hc.model.dto.Cfencuecovid;
import org.profamilia.hc.model.dto.Cfremiadmi;
import org.profamilia.hc.model.dto.Chactiveduca;
import org.profamilia.hc.model.dto.Chactividad;
import org.profamilia.hc.model.dto.Chanatopatol;
import org.profamilia.hc.model.dto.Chanestesia;
import org.profamilia.hc.model.dto.Chantecdetal;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantecemama;
import org.profamilia.hc.model.dto.Chanteceobst;
import org.profamilia.hc.model.dto.Chantecespec;
import org.profamilia.hc.model.dto.Chantecfamil;
import org.profamilia.hc.model.dto.Chantecfarma;
import org.profamilia.hc.model.dto.Chantecolpo;
import org.profamilia.hc.model.dto.Chantecpatol;
import org.profamilia.hc.model.dto.Chantecprena;
import org.profamilia.hc.model.dto.Chantecpsico;
import org.profamilia.hc.model.dto.Chantecvasec;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chanteginecopre;
import org.profamilia.hc.model.dto.Chanteobstpr;
import org.profamilia.hc.model.dto.Chaseavise;
import org.profamilia.hc.model.dto.Chasesohuman;
import org.profamilia.hc.model.dto.Chasesoria;
import org.profamilia.hc.model.dto.Chasesoriaive;
import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chautoriserv;
import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.Chcancecervi;
import org.profamilia.hc.model.dto.Chcauspaus;
import org.profamilia.hc.model.dto.Chcertmedico;
import org.profamilia.hc.model.dto.Chcervaaplic;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chcolposcopia;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconfiservi;
import org.profamilia.hc.model.dto.Chconinfxcon;
import org.profamilia.hc.model.dto.Chconsprogra;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chcontabor;
import org.profamilia.hc.model.dto.Chcontrmedic;
import org.profamilia.hc.model.dto.Chcontroladi;
import org.profamilia.hc.model.dto.Chcontrolcon;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chcontrolpre;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.Chcontrvasec;
import org.profamilia.hc.model.dto.Chcorrelec;
import org.profamilia.hc.model.dto.Chcorreo;
import org.profamilia.hc.model.dto.Chcuestester;
import org.profamilia.hc.model.dto.Chcuestplani;
import org.profamilia.hc.model.dto.Chdatosvph;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaentpatol;
import org.profamilia.hc.model.dto.Chdispoaplic;
import org.profamilia.hc.model.dto.Chentregacitol;
import org.profamilia.hc.model.dto.Chentregapatol;
import org.profamilia.hc.model.dto.Chentregavph;
import org.profamilia.hc.model.dto.Chescvalcai;
import org.profamilia.hc.model.dto.Chespervasec;
import org.profamilia.hc.model.dto.Chestadpsico;
import org.profamilia.hc.model.dto.Chestermascu;
import org.profamilia.hc.model.dto.Chevalugener;
import org.profamilia.hc.model.dto.Chevolucion;
import org.profamilia.hc.model.dto.Chevoluconsu;
import org.profamilia.hc.model.dto.Chexafisane;
import org.profamilia.hc.model.dto.Chexafismama;
import org.profamilia.hc.model.dto.Chexamediagn;
import org.profamilia.hc.model.dto.Chexameelect;
import org.profamilia.hc.model.dto.Chexameimage;
import org.profamilia.hc.model.dto.Chexamelabor;
import org.profamilia.hc.model.dto.Chexameparac;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chfertdato;
import org.profamilia.hc.model.dto.Chfertecog;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chformulamed;
import org.profamilia.hc.model.dto.Chfragesperma;
import org.profamilia.hc.model.dto.Chgeslabor;
import org.profamilia.hc.model.dto.Chgestacion;
import org.profamilia.hc.model.dto.Chhallahistero;
import org.profamilia.hc.model.dto.Chhisteroscopia;
import org.profamilia.hc.model.dto.Chidentiriesgo;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chinfomamogr;
import org.profamilia.hc.model.dto.Chinfopsico;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chingresomed;
import org.profamilia.hc.model.dto.Chlecttuber;
import org.profamilia.hc.model.dto.Chlibrocitol;
import org.profamilia.hc.model.dto.Chlibrovph;
import org.profamilia.hc.model.dto.Chlogimpresi;
import org.profamilia.hc.model.dto.Chmedicament;
import org.profamilia.hc.model.dto.Chmedidapoyo;
import org.profamilia.hc.model.dto.Chmetodoplan;
import org.profamilia.hc.model.dto.Chmonitoria;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.Chnotamedica;
import org.profamilia.hc.model.dto.Chnoticia;
import org.profamilia.hc.model.dto.Chordecirugi;
import org.profamilia.hc.model.dto.Chotraspatolog;
import org.profamilia.hc.model.dto.Chpapsicologico;
import org.profamilia.hc.model.dto.Chparacgener;
import org.profamilia.hc.model.dto.Chpediexamen;
import org.profamilia.hc.model.dto.Chpladetrat;
import org.profamilia.hc.model.dto.Chplanconsinfo;
import org.profamilia.hc.model.dto.Chplantilla;
import org.profamilia.hc.model.dto.Chposicanest;
import org.profamilia.hc.model.dto.Chproceconsu;
import org.profamilia.hc.model.dto.Chproflect;
import org.profamilia.hc.model.dto.Chprofpatol;
import org.profamilia.hc.model.dto.Chpruecovidanticu;
import org.profamilia.hc.model.dto.Chpruecovidantige;
import org.profamilia.hc.model.dto.Chpruerapi;
import org.profamilia.hc.model.dto.Chpsicoantec;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.Chreferencia;
import org.profamilia.hc.model.dto.Chregcomenf;
import org.profamilia.hc.model.dto.Chregicomp;
import org.profamilia.hc.model.dto.Chregiconpro;
import org.profamilia.hc.model.dto.Chreginsumo;
import org.profamilia.hc.model.dto.Chregisabort;
import org.profamilia.hc.model.dto.Chregisexame;
import org.profamilia.hc.model.dto.Chregitelf;
import org.profamilia.hc.model.dto.Chremihospit;
import org.profamilia.hc.model.dto.Chremisilve;
import org.profamilia.hc.model.dto.Chremision;
import org.profamilia.hc.model.dto.Chresersangr;
import org.profamilia.hc.model.dto.Chresulparac;
import org.profamilia.hc.model.dto.Chrevissiste;
import org.profamilia.hc.model.dto.Chriesgomama;
import org.profamilia.hc.model.dto.Chseguavis;
import org.profamilia.hc.model.dto.Chseguipsico;
import org.profamilia.hc.model.dto.Chsegutelefo;
import org.profamilia.hc.model.dto.Chserxtipo;
import org.profamilia.hc.model.dto.Chsolicanula;
import org.profamilia.hc.model.dto.Chtamizalapr;
import org.profamilia.hc.model.dto.Chtecnianest;
import org.profamilia.hc.model.dto.Chtiempaten;
import org.profamilia.hc.model.dto.Chtipoantece;
import org.profamilia.hc.model.dto.Chtipointerc;
import org.profamilia.hc.model.dto.Chtiposerv;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chusuarioabor;
import org.profamilia.hc.model.dto.Chvacunacion;
import org.profamilia.hc.model.dto.Chvademecum;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Chvalorabiopsi;
import org.profamilia.hc.model.dto.Chvalorprean;
import org.profamilia.hc.model.dto.Chventiaerea;
import org.profamilia.hc.model.dto.Chviolencia;
import org.profamilia.hc.model.dto.Chvphcitolect;
import org.profamilia.hc.model.dto.Chvphlect;
import org.profamilia.hc.model.dto.Chvphtoma;
import org.profamilia.hc.model.dto.Chvsolsivig;
import org.profamilia.hc.model.dto.Clcateippf;
import org.profamilia.hc.model.dto.Clcomserv;
import org.profamilia.hc.model.dto.Cncapaespe;
import org.profamilia.hc.model.dto.Cncitolect;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.dto.Cncitotoma;
import org.profamilia.hc.model.dto.Cncitovphlect;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cndesccito;
import org.profamilia.hc.model.dto.Cnespermog;
import org.profamilia.hc.model.dto.Cnprofxcon;
import org.profamilia.hc.model.dto.Cnregferti;
import org.profamilia.hc.model.dto.Cpclinica;
import org.profamilia.hc.model.dto.Cpcontrato;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpentidadadm;
import org.profamilia.hc.model.dto.Cpestadciv;
import org.profamilia.hc.model.dto.Cpinsumate;
import org.profamilia.hc.model.dto.Cpmunidane;
import org.profamilia.hc.model.dto.Cpocupacio;
import org.profamilia.hc.model.dto.Cppais;
import org.profamilia.hc.model.dto.Cpparentes;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservanex;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipconcl;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.Crarcproce;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.Crdgncie10;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.dto.Crmedicame;
import org.profamilia.hc.model.dto.Crripsserv;
import org.profamilia.hc.model.dto.Cvcontrato;
import org.profamilia.hc.model.dto.ReporteCervixDTO;
import org.profamilia.hc.model.dto.Sapermiso;
import org.profamilia.hc.model.dto.Sausuario;
import org.profamilia.hc.model.exceptions.DAOException;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.response.ResultadosLCResponse;



public interface ClinicoDao
{

    public  void changePassword(String s, String s1, String s2)
        throws DAOException;

    public  Cpclinica getClinica(Integer integer)
        throws ModelException;

    public  List getClinicasUsuario(String s)
        throws ModelException;

    public  Cpclinica getClinicaRouter(String s)
        throws ModelException;

    public  Sausuario getSausuario(String s)
        throws ModelException;

    public  Cpusuario getUsuarioPorId(String s)
        throws ModelException;

    public  List getPermisosUsuario(String s)
        throws ModelException;

    public  List getPermisosUsuarioRol(String s, String s1)
        throws ModelException;

    public  Sapermiso getPermisosForma(String s, String s1)
        throws ModelException;

    public  void saveUsuario(Chusuario chusuario, Cnconsclin cnconsclin, String s, Long codigoAgenda)
        throws ModelException;

    public  void saveUsuarioAsesoria(Chusuario chusuario, String s)
        throws ModelException;

    public  void saveUsuarioCitologia(Chusuario chusuario, Cnconsclin cnconsclin, Cncitologi cncitologi, String s, Long codigoAgenda)
        throws ModelException;
        
    public void saveUsuarioVph(final Chusuario usuario, 
                                     final Cnconsclin consulta, 
                                     final Chdatosvph citologia, 
                                     final String userName) throws ModelException;
    

    public  void updateUsuario(Chusuario chusuario)
        throws ModelException;

    public  void saveEncuestaViolencia(Chviolencia chviolencia)
        throws ModelException;

    public  void saveMotivoConsulta(Chmotivocon chmotivocon, Chrevissiste chrevissiste)
        throws ModelException;

    public  void saveAntecedente(Chantecegene chantecegene)
        throws ModelException;

    public  void saveAntecedenteGineco(Chantegineco chantegineco)
        throws ModelException;
    public  void saveAntecedenteGinecopre(Chanteginecopre chanteginecopre)
        throws ModelException;

    public  void saveConsulta(Chconsulta chconsulta)
        throws ModelException;

    public  void saveExamenFisico(Chexamfisico chexamfisico)
        throws ModelException;

    public  void saveExamenFisicoAnestesia(Chexafisane chexafisane)
        throws ModelException;

    public  void saveFormula(Chformulamed chformulamed)
        throws ModelException;

    public  void saveImpresion(Chimprdiag chimprdiag)
        throws ModelException;

    public  void saveIncapacidad(Chincapacida chincapacida)
        throws ModelException;

    public  void saveRemision(Chremision chremision)
        throws ModelException;

    public  void saveExamenApoyoDiagnostico(Chexamediagn chexamediagn)
        throws ModelException;

    public  List getConsultas(String s)
        throws ModelException;

    public  List getTipoIdentificacion()
        throws ModelException;

    public  List getMetodoPlanificacion()
        throws ModelException;

    public  List getOcupaciones()
        throws ModelException;
    
    public  List<Cpestadciv> getEstadosCiviles()
            throws ModelException;
    
    public  List<Cpparentes> getParentescos()
            throws ModelException;

    public  List getDepartamentos()
        throws ModelException;

    public  List getMunicipios(Integer integer)
        throws ModelException;

    public  List getEntidadAdm()
        throws ModelException;

    public  Cpempresa getEmpresa(Integer integer)
        throws ModelException;

    public  Cpentidadadm getAseguradoraPorCodigo(String s)
        throws ModelException;

    public  List getConsultasDia(Date date, Integer integer, BigDecimal bigdecimal)
        throws ModelException;

    public  List getMisConsultasDia(Date date, Integer integer, BigDecimal bigdecimal)
        throws ModelException;
        
    public List<Cnconsclin> getConsultasDiaLaboratorio(final Date dia, 
                                            final Integer codclinica, 
                                            final BigDecimal idMedico, String numeroIdentificacion) throws ModelException;

    public  List getConsultasDiaEnfermeria(Date date, Integer integer, BigDecimal bigdecimal, String wnumiden)
        throws ModelException;

    public  List getConsultasEnConsultorioDia(Date date, Integer integer)
        throws ModelException;

    public  List getConsultasVacunacionDia(Date date, Integer integer, BigDecimal bigdecimal)
        throws ModelException;

    public  List getConsultasProceso(Date date, Integer integer, BigDecimal bigdecimal, String s)
        throws ModelException;

    public  List getConsultasAusentes(Date date, Integer integer, BigDecimal bigdecimal, String s, Integer integer1)
        throws ModelException;

    public  List getCitologiasDia(Date date, Integer integer,String wnumiden)
        throws ModelException;

    public  List getVPHDia(Date date, Integer integer) throws ModelException;


    public  List getListServicio()
        throws ModelException;

    public  Chusuario getUsuario(Long long1)
        throws ModelException;

    public  List getCie10()
        throws ModelException;

    public  List getCriteriosCie10(Crdgncie10 crdgncie10)
        throws ModelException;

    public  List getCausaExterna(Integer integer)
        throws ModelException;

    public  List<Crcausaext> getCausaExternaVG(Integer integer)
        throws ModelException;

    public  Chmotivocon getMotivoConsulta(Cnconsclin cnconsclin)
        throws ModelException;

    public  void saveAntecedentes(List list, Long long1)
        throws ModelException;

    public  void saveParaclinicos(List list, Long long1)
        throws ModelException;

    public  List getAntecedentes(Long long1)
        throws ModelException;

    public  List getParaclinicosUsuario(Long long1)
        throws ModelException;

    public  List getExamenesLaboratorioAll()
        throws ModelException;

    public  List getParaclinicos(Long long1)
        throws ModelException;

    public  Chantegineco getAntecedentesGinecologicos(Cnconsclin cnconsclin)
        throws ModelException;

    public  Chanteginecopre getAntecedentesGinecologicospre(Cnconsclin cnconsclin)
        throws ModelException;
        
    public  List getAntecedentesUsuario(Long long1)
        throws ModelException;

    public List<Chantecegene> getAntecedentesUsuarioAnterioresXFecha(Long numeroUsuario, Date fechaRegistro) throws ModelException;
    
    public List<Chantecegene> getAntecedentesUsuarioActualConsulta(Long numeroConsulta) throws ModelException;

    public  Chviolencia getEncuestaViolencia(Cnconsclin cnconsclin)
        throws ModelException;

    public  Chexafisane getExamenFisicoAnestesia(Cnconsclin cnconsclin)
        throws ModelException;

    public  Chvalorprean getValoracionPreanestesia(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getFinalidadesConsulta(String s)
        throws ModelException;

    public  List getFinalidadesConsultaVG(String s)
        throws ModelException;

    public  List getActoQuirurgico()
        throws ModelException;

    public  void closeConsulta(Chusuario chusuario, Cnconsclin cnconsclin, Chimprdiag chimprdiag, Chmotivocon chmotivocon, String s,String surveypalLink)
        throws ModelException;

    public  void closeEspermograma(Chusuario chusuario, Cnconsclin cnconsclin, String s)
        throws ModelException;

    public  void closeEspermogramaFertilidad(Chusuario chusuario, Cnconsclin cnconsclin, String s)
        throws ModelException;

    public  void closeVacunacionCervix(Chusuario chusuario, Cnconsclin cnconsclin, String s, List<Chmedicament> listadoMedicamentos)
        throws ModelException;

    public  void closeProcedimiento(Cnconsclin cnconsclin, String s)
        throws ModelException;

    public  void closeTomaCitologia(Cncitotoma cncitotoma, Cnconsclin cnconsclin, String s, boolean flag)
        throws ModelException;
        
    public void closeTomaVph(final Chvphtoma toma, 
                                   final Cnconsclin consulta, 
                                   final String userName, 
                                   final boolean temporal) throws ModelException;

    public  void entregarCitologia(Cncitologi cncitologi, Chlibrocitol chlibrocitol)
        throws ModelException;

    public  void entregarVph(Chdatosvph chdatosvph, Chlibrovph chlibrovph)
        throws ModelException;

    public  void saveLibroCitologia(Chlibrocitol chlibrocitol)
        throws ModelException;

    public  void closeLecturaCitologia(Chconsulta chconsulta)
        throws ModelException;

    public  void closeLecturaVph(Chconsulta chconsulta)
        throws ModelException;

    public  boolean esPrimeraConsulta(Chusuario chusuario)
        throws ModelException;

    public  boolean esPrimeraConsultaCovid(Long consulta)
        throws ModelException;

    public  void saveAntecedenteTemporal(List list)
        throws ModelException;

    public  List getAntecedentesTemporal(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getCitologiasLectura(Long long1)
        throws ModelException;

    public  List getVphLectura(Long long1)
        throws ModelException;
        
    public  List getVphLecturaMod(Long long1)
        throws ModelException;

    public  Chexamediagn getExamenApoyoDiagnostico(Cnconsclin cnconsclin)
        throws ModelException;

    public  void saveConducta(Chconducta chconducta)
        throws ModelException;

    public  Chconducta getConducta(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getMetodosPlanificacion(String s)
        throws ModelException;

    public  void saveAantecedentesMama(Chantecemama chantecemama)
        throws ModelException;

    public  Chantecemama getAntecedentesMama(Cnconsclin cnconsclin)
        throws ModelException;

    public  void saveRiesgoMama(Chriesgomama chriesgomama)
        throws ModelException;

    public  Chriesgomama getRiesgoMama(Cnconsclin cnconsclin)
        throws ModelException;

    public  void saveExamenFisicoMama(Chexafismama chexafismama)
        throws ModelException;

    public  Chexafismama getExamenFisicoMama(Cnconsclin cnconsclin)
        throws ModelException;

    public  Crdgncie10 getCIE10PorCodigo(String s)
        throws ModelException;

    public  String getDescripcionCups(String s)
        throws ModelException;

    public  Cptipconcl getDescripcionTipoConsulta(Integer integer)
        throws ModelException;

    public  Cpentidadadm getDescripcionEntidad(Long long1)
        throws ModelException;

    public  String getDescripcionEntidadByCodigo(String s)
        throws ModelException;

    public  Cpservicio getServicioPorId(String s)
        throws ModelException;

    public  void saveProcedimientoConsultorio(Chproceconsu chproceconsu)
        throws ModelException;

    public  Chproceconsu getProcedimientoConsultorio(Cnconsclin cnconsclin)
        throws ModelException;

    public  Chincapacida getIncapcidad(Long long1)
        throws ModelException;

    public  void saveExamenParaclinico(Chexameparac chexameparac)
        throws ModelException;

    public  void saveListExamenParaclinicos(List list, Cnconsclin cnconsclin)
        throws ModelException;

    public  List getExamenesParaclinicos(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getRemisionConsulta(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getRemisionConsulta(Long numeroConsulta, String tipoConsulta)
        throws ModelException;

    public  void saveFormulaMedica(Chformulamed chformulamed)
        throws ModelException;

    public  void saveListFormulaMedica(List list, Long long1)
        throws ModelException;

    public  List getListPrescripciones(Long long1)
        throws ModelException;

    public  void saveControl(Chconsprogra chconsprogra)
        throws ModelException;

    public  Chconsprogra getControl(Cnconsclin cnconsclin)
        throws ModelException;

    public  List<Chconsprogra> getControlesConsulta(Cnconsclin cnconsclin)
        throws ModelException;

    public  void saveOrdenCirugia(Chordecirugi chordecirugi)
        throws ModelException;

    public  Chordecirugi getOrdenCirugia(Cnconsclin cnconsclin)
        throws ModelException;

    public  Cpmunidane getMunicipio(Integer integer, Integer integer1)
        throws ModelException;

    public  void saveReferencia(Chreferencia chreferencia)
        throws ModelException;

    public  Chreferencia getReferencia(Cnconsclin cnconsclin)
        throws ModelException;

    public  void saveAutorizacion(Chautoriserv chautoriserv, List list)
        throws ModelException;

    public  List getListServicioss(Long long1)
        throws ModelException;

    public  Chautoriserv getAutorizacion(Long long1)
        throws ModelException;

    public  Chreferencia getReferencia(Long long1, String s, Integer integer)
        throws ModelException;

    public  void saveAnatomiaPatologica(Chanatopatol chanatopatol)
        throws ModelException;

    public  void saveMedidaApoyo(Chmedidapoyo chmedidapoyo)
        throws ModelException;

    public  Chanatopatol getAnatomiaPatologica(Cnconsclin cnconsclin)
        throws ModelException;

    public List<Chanatopatol> getListAnatomiaPatologica(Long numConsulta)
        throws ModelException;

    public  Chanatopatol getAnatomiaPatologica(Long long1, String s, Integer integer)
        throws ModelException;

    public  void saveCertificado(Chcertmedico chcertmedico)
        throws ModelException;

    public  Chcertmedico getCertificado(Cnconsclin cnconsclin, String s)
        throws ModelException;

    public  List getTipoAntecedente(Integer integer)
        throws ModelException;

    public  List getTipoAntecedentePediatricos()
        throws ModelException;

    public  List getParametroEduca(String s)
        throws ModelException;

    public  Crcausaext getCausaExternaPorId(Integer integer)
        throws ModelException;

    public  Chrevissiste getRevisionSistemas(Long long1)
        throws ModelException;

    public  String getRevisionSistemasTexto(Long long1)
        throws ModelException;

    public  Crfinalcon getFinalidadPorId(Integer integer, String s)
        throws ModelException;

    public  List getUsuarios(String s, Long long1)
        throws ModelException;

    public  List getUsuariosClienteActivo(String s, Long long1)
        throws ModelException;

    public  List getUsuariosClienteInactivo(String s, Long long1)
        throws ModelException;

    public  List getUsuarios(Chusuario chusuario)
        throws ModelException;

    public  List getUsuariosCitologia(Chusuario chusuario)
        throws ModelException;

    public  List getUsuariosVph(Chusuario chusuario)
        throws ModelException;

    public  List getUsuariosProgramarCirugia(Chusuario chusuario)
        throws ModelException;

    public  Chcirugprogr getProgramarCirugia(Ccfactvent ccfactvent)
        throws ModelException;

    public  List getCirugiasPorUsuario(Chusuario chusuario)
        throws ModelException;

    public  List getCirugiasProgramadas(Chusuario chusuario)
        throws ModelException;

    public  List getFoliosUsuario(Long long1)
        throws ModelException;

    public  List getFoliosUsuarioNotaAclaratoria(Long long1, String s)
        throws ModelException;
        
    public List<Chconsulta> getFoliosUsuarioEvolucion(Long numeroUsuario) throws ModelException;

    public  List getFoliosUsuarioExamenesClinicos(Long long1)
        throws ModelException;

    public  List getFoliosUsuarioTipoHistoria(Long long1, Integer integer)
        throws ModelException;

    public  List getFoliosUsuarioTipoHistoria(Long long1, List list)
        throws ModelException;

    public  List getFoliosUsuarioPorFecha(Long long1, Date date, Date date1)
        throws ModelException;

    public  Chusuario getUsuarioPorPk(Long long1)
        throws ModelException;

    public  Chmotivocon getMotivoConsulta(Long long1)
        throws ModelException;

    public  List getAntecedentesGenerales(Long long1)
        throws ModelException;

    public  String getAntecedentesGeneralesTexto(Long long1)
        throws ModelException;

    public  Chantegineco getAntecedentesGinecologicos(Long long1)
        throws ModelException;
        
    public  Chanteginecopre getAntecedentesGinecologicospre(Long long1)
        throws ModelException;

    public  Chexamfisico getExamenFisico(Long long1, Integer integer)
        throws ModelException;

    public  Chviolencia getEncuestaViolencia(Long long1)
        throws ModelException;

    public  Chimprdiag getImresionDiagnostica(Long long1, Integer integer)
        throws ModelException;

    public  Chconsulta getConsultaActual(Long long1)
        throws ModelException;

    public  List getAntecedentesPorTipo(List list, Long long1)
        throws ModelException;

    public  List getConsultaPorId(Long long1)
        throws ModelException;

    public  List getConsultasDiaProfesional(Date date, BigDecimal bigdecimal, Integer integer)
        throws ModelException;

    public  List getConsultaClinica(Long long1)
        throws ModelException;

    public  void saveNotaMedica(Chnotamedica chnotamedica)
        throws ModelException;
        
    public void saveEvolucionConsulta(Chevoluconsu evolucion) throws ModelException ;

    public  void saveRegistrarExamenLaboratorio(Chregisexame chregisexame)
        throws ModelException;

    public  Integer getConsecutivoNotaMedica(Chconsulta chconsulta)
        throws ModelException;

    public  List getPlantillaAnticioncepcion()
        throws ModelException;

    public  Chconducta getConducta(Long long1)
        throws ModelException;

    public  List getExamenesParaclinicos(Long long1)
        throws ModelException;

    public  Chincapacida getIncapacidad(Long long1)
        throws ModelException;

    public  List getPrescripcionMedica(Long long1)
        throws ModelException;

    public  Chordecirugi getOrdenCirugia(Long long1)
        throws ModelException;

    public  Chreferencia getReferencia(Long long1)
        throws ModelException;

    public  Chanatopatol getAnatomiaPatologica(Long long1)
        throws ModelException;

    public  Chconsprogra getControl(Long long1)
        throws ModelException;

    public  void saveCuestionarioPlanificacion(Chcuestplani chcuestplani)
        throws ModelException;

    public  Chcuestplani getCuestionarioPlanificacion(Long long1)
        throws ModelException;

    public  void saveAntecedentesPrenatal(Chantecprena chantecprena)
        throws ModelException;
        
    public void saveAntecedentesFamiliar(Chantecfamil antecedente) throws ModelException ;

    public  Chantecprena getAntecedentesPrenatales(Cnconsclin cnconsclin)        throws ModelException;
    
    public Chantecfamil getAntecedentesFamiliares(Cnconsclin consclin) throws ModelException;

    public  void saveTamizajeLaboratoriosPrenatal(Chtamizalapr chtamizalapr)
        throws ModelException;

    public  Chtamizalapr getTamizajeLaboratorioPrenatal(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getTamizajesLaboratorioPrenatal(Long long1)
        throws ModelException;

    public  List getResumenHistoria(Date date, Date date1, Long long1)
        throws ModelException;

    public  Chconsulta getConsultaCompleta(Long long1, String s)
        throws ModelException;

    public  List getResumenEnfermeriaCirugiaActual(Long long1)
        throws ModelException;

    public  void saveExamenPediatria(Chpediexamen chpediexamen)
        throws ModelException;

    public  Chpediexamen getExamenPediatria(Cnconsclin cnconsclin)
        throws ModelException;

    public  String getDescripcionMetodo(String s)
        throws ModelException;

    public  Chantecemama getAntecedentesMama(Long long1)
        throws ModelException;

    public  Chriesgomama getRiesgoMama(Long long1)
        throws ModelException;

    public  Chexafismama getExamenFisicoMama(Long long1)
        throws ModelException;

    public  Chpediexamen getExamenPediatria(Long long1)
        throws ModelException;

    public  Chexamediagn getExamenApoyoDiagnostico(Long long1)
        throws ModelException;

    public  List getListNotasMedicas(Long long1)
        throws ModelException;

    public  List getActividad(Integer integer)
        throws ModelException;

    public  Chactividad getActividadPorId(Integer integer)
        throws ModelException;

    public  String getNombreUsuarioPorId(String s)
        throws ModelException;

    public  List getVerificacionCie10(Crdgncie10 crdgncie10, String s, String s1, Integer integer, String s2);

    public  List getTiposInterconsulta()
        throws ModelException;

    public  void saveListRemisionInterconsulta(List list, Long long1)
        throws ModelException;

    public  void saveListRemisionInterconsultaCirugia(List list, Chevolucion chevolucion)
        throws ModelException;

    public  void saveListRemisionInterconsultaCirugia(List list, Long long1, String s, Integer integer)
        throws ModelException;

    public  void saveControlConsulta(Chcontrolcon chcontrolcon)
        throws ModelException;

    public  void saveControlConsultaCompleta(Chcontrolcon chcontrolcon, Chimprdiag chimprdiag, Chmotivocon chmotivocon)
        throws ModelException;

    public  void saveControlIlveConsulta(Chcontrolcon chcontrolcon, Chmotivocon chmotivocon)
        throws ModelException;

    public  void saveImpresionIlveConsulta(Chimprdiag chimprdiag)
        throws ModelException;

    public  Chcontrolcon getControlConsulta(Cnconsclin cnconsclin)
        throws ModelException;

    public  Chcontrvasec getControlVasectomia(Long long1, Integer consecutivo)
        throws ModelException;

    public  void saveControlVasectomia(Chusuario usuario, Cnconsclin consulta, Chcontrvasec chcontrvasec, String usureg)
        throws ModelException;

    public  Chcontrolcon getControlConsulta(Long long1)
        throws ModelException;

    public  void saveAntecedenteObstetrico(Chanteceobst chanteceobst)
        throws ModelException;

    public  Chanteceobst getAntecedenteObstetrico(Long long1)
        throws ModelException;

    public  void saveGestacionActual(Chgestacion chgestacion)
        throws ModelException;

    public  Chgestacion getGestacionActual(Cnconsclin cnconsclin)
        throws ModelException;

    public  void saveControlPrenatal(Chcontrolpre chcontrolpre)
        throws ModelException;

    public  Chcontrolpre getControlPrenatal(Cnconsclin cnconsclin)
        throws ModelException;

    public  Chcontrolpre getControlPrenatal(Long long1)
        throws ModelException;

    public  Long getConsultaPrenatalPrincipal(Long long1)
        throws ModelException;

    public  Chgestacion getGestacionControlPrenatal(Long long1)
        throws ModelException;

    public  Date getFechaUltimoPeriodo(Long long1)
        throws ModelException;

    public  List getExamenFisicoControlPrenatal(Long long1)
        throws ModelException;

    public  List getExamenesLaboratorio(Cpservicio cpservicio)
        throws ModelException;

    public  List getExamenesImagenes(Cpservicio cpservicio)
        throws ModelException;

    public  List getExamenesElectrofisiologicos(Cpservicio cpservicio)
        throws ModelException;

    public  void saveExamenImagenes(Chexameimage chexameimage)
        throws ModelException;

    public  void saveListExamenesImagenes(List list, Long long1, String s)
        throws ModelException;

    public  void saveListExamenesImagenesCirugia(List list, Long long1, String s, Integer integer, String s1)
        throws ModelException;

    public  void saveExamenElectrofisiologicos(Chexameelect chexameelect)
        throws ModelException;

    public  void saveListExamenesElectrofisiologicos(List list, Long long1, String s)
        throws ModelException;

    public  void saveListExamenesElectrofisiologicosCirugia(List list, Long long1, String s, Integer integer, String s1)
        throws ModelException;

    public  void saveExamenLaboratorio(Chexamelabor chexamelabor)
        throws ModelException;

    public  void saveListExamenesLaboratorio(List list, Long long1, String s)
        throws ModelException;

    public  void saveListExamenesLaboratorioCirugia(List list, Long long1, String s, Integer integer, String s1)
        throws ModelException;

    public  List getExamenesImagenesConsulta(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getExamenesElectrofisiologicosConsulta(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getExamenesLaboratoriosConsulta(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getExamenesLaboratorioPorCriterios(Cpservicio cpservicio,Long admision)
        throws ModelException;

    public  List getCirugiasPorCriterios(Cpservicio cpservicio)
        throws ModelException;

    public  List getVademecumClinico(Crmedicame crmedicame)
        throws ModelException;

    public  List getVademecumHistorias(Chvademecum chvademecum)
        throws ModelException;
        
    public List getVademecum(Chvademecum chvademecum)
        throws ModelException;
        
    public List getVademProf(Chvademprof chvademecum)
        throws ModelException;    

    public  List getServicioSap(Cpservicio cpservicio)
        throws ModelException;

    public  Cpmunidane getMunicipiosSap(Integer integer, Integer integer1)
        throws ModelException;

    public  Cpservicio getDescripcionServicioSapXCodigo(Cpservicio cpservicio)
        throws ModelException;

    public  List getServicioSapCodigo(String s)
        throws ModelException;

    public  List getEntidadEps(Cpentidadadm cpentidadadm)
        throws ModelException;

    public  Cpservicio getDescripcionCupsCompleto(String s)
        throws ModelException;


    /**
     * @param codigo
     * @return
     * @throws ModelException
     */
    public String getNombreServicioXCodigo(String codigo) throws ModelException;
    
    
    public  List getOcupacion(Cpocupacio cpocupacio)
        throws ModelException;

    public  boolean verificarConsultaCerrada(Long long1)
        throws ModelException;

    public  Cncitologi getUsuarioCitologia(Cnconsclin cnconsclin)
        throws ModelException;
    
    public Chdatosvph getUsuarioVph(Cnconsclin consulta) throws ModelException;
    
    public  Cncitologi getEncabezadoCitologia(Integer integer)
        throws ModelException;
    
    public  Chdatosvph getEncabezadoVph(Integer integer)
        throws ModelException;

    public  List getCopiaCitologia(Long long1)
        throws ModelException;

    public  List getCopiaVph(Long long1)
        throws ModelException;

    public  List getEstadoCitologia(Long long1)
        throws ModelException;

    public  Cncitologi getUsuarioCitologia(Chconsulta chconsulta)
        throws ModelException;

    public  Chdatosvph getUsuarioVph(Chconsulta chconsulta)
        throws ModelException;

    public  List getListaDescripcionesCitologia(String s, String s1)
        throws ModelException;

    public  List getListaDescripcionesParametro(String s)
        throws ModelException;

    public  Cndesccito getDescripcionesCitologia(String s, String s1, String s2)
        throws ModelException;

    public  void saveLecturaCitologia(final Cncitolect cncitolect,final Cnconsclin consulta,final String userName,final Integer tipoLectura)
        throws ModelException;

    public  void saveLecturaVphCitologia(Cncitovphlect chvphcitolect)
        throws ModelException;

    public void saveLecturaVph(final Cncitovphlect lectura,final Cnconsclin consulta,final String userName, final String codigoProfesional)
        throws ModelException;

    public  Cncitolect getLecturaCitologia(Integer integer)
        throws ModelException;

    public  Chvphlect getLecturaVph(Integer integer)
        throws ModelException;

    public  Chvphcitolect getLecturaVphCitologia(Integer integer)
        throws ModelException;

    public  Chlibrocitol getLibroCitologia(Integer integer)
        throws ModelException;

    public  Chlibrovph getLibroVph(Integer integer)
        throws ModelException;

    public  void saveTomaCitologia(Cncitotoma cncitotoma)
        throws ModelException;

    public  Cncitotoma getTomaCitologia(Integer integer)
        throws ModelException;
        
    public Chvphtoma getTomaVph(Integer consecutivo) throws ModelException ;

    public  List getCitologiasParaEntregar(Cncitologi cncitologi)
        throws ModelException;

    public  List getVphsParaEntregar(Chdatosvph chdatosvph)
        throws ModelException;

    public  void saveAntecedentesColposcopia(Chantecolpo chantecolpo)
        throws ModelException;

    public  Chantecolpo getAntecedentesColposcopia(Long long1)
        throws ModelException;

    public  void saveReservaSangre(Chresersangr chresersangr)
        throws ModelException;

    public  Chresersangr getReservaSangre(Cnconsclin cnconsclin)
        throws ModelException;

    public  Cpprofesio getProfesionalPorUsuario(String s, Integer integer)
        throws ModelException;

    public  Cpprofesio getProfesionalPorCodigo(BigDecimal bigdecimal, Integer integer)
        throws ModelException;

    public  void saveInformeMamografia(Chinfomamogr chinfomamogr)
        throws ModelException;

    public  Chinfomamogr getInformeMamografia(Cnconsclin cnconsclin, String s)
        throws ModelException;

    public  List getListaProfesionalesClinica(Integer integer)
        throws ModelException;

    public  List getListaEspecialistasClinica(Integer integer)
        throws ModelException;

    public  List getListaAnestesiologoClinica(Integer integer)
        throws ModelException;
        
    public List<Cpprofesio> getListaMedicoXEspecialidad(Integer codclin, Integer codEspecialidad) throws ModelException ;

    public  Cpprofesio getEspecialistaXCodigo(String s, Integer integer)
        throws ModelException;

    public  Cpprofesio getProfesionalXCodigo(String s, Integer integer)
        throws ModelException;
    
    public List<Cpprofesio> getProfesionalXCodigoII(String codprof, 
                                            Integer codclin) throws ModelException;    

    public  Cnconsclin getConsultaClinicaPorId(String s)
        throws ModelException;
        
    public Integer getContratoXConsultaClinica(Long idConsulta) throws ModelException;

    public  void saveLstIngresoLiquidos(List list, Long long1)
        throws ModelException;

    public  void saveLstIngresoLiquidosCanalizacion(List list, Long long1, Chcanalivena chcanalivena)
        throws ModelException;

    public  void updateLiquidoAdministrado(Chcontroliqu chcontroliqu)
        throws ModelException;

    public  List getListaCirugiasProgramadas(Chusuario chusuario, Date date, Integer integer)
        throws ModelException;

    public  List getListaCirugiasRegistroMedico(Date date, Integer integer)
        throws ModelException;

    public  void saveIngresoEnfermeria(Chingresoenf chingresoenf, Chcirugprogr chcirugprogr)
        throws ModelException;

    public  void saveIngresoMedico(Chingresomed chingresomed)
        throws ModelException;

    public  Chingresoenf getIngresoEnfermeria(Long long1)
        throws ModelException;

    public  Chingresomed getIngresoMedico(Long long1)
        throws ModelException;

    public  Integer getConsecutivoLiquidos(Long long1)
        throws ModelException;

    public  void deleteLiquidos(Chcontroliqu chcontroliqu)
        throws ModelException;

    public  List getLstIngresoLiquidos(Long long1)
        throws ModelException;

    public  List getLstLiquidosAdministrados(Long long1)
        throws ModelException;

    public  List getLstLiquidosAdministradoParcial(Long long1)
        throws ModelException;

    public  List getLstLiquidosAdministradoEliminados(Long long1)
        throws ModelException;

    public  void saveCanalizacion(Chcanalivena chcanalivena)
        throws ModelException;

    public  Integer getConsecutivoCanalizacion(Long long1)
        throws ModelException;

    public  List getIngresoCanalizacion(Chnotaenferm chnotaenferm)
        throws ModelException;

    public  Integer getConsecutivoNotaEnfermeria(Long long1)
        throws ModelException;

    public  void saveNotaEnfermeria(Chnotaenferm chnotaenferm)
        throws ModelException;

    public  void saveRemisionHospitalizacion(Chremihospit chremihospit)
        throws ModelException;

    public  Chremihospit getRemisionHospitalizacion(Cnconsclin cnconsclin)
        throws ModelException;

    public  Chcirugprogr getProgramarCirugia(Long long1)
        throws ModelException;

    public  void saveLstRegistroLiquidos(List list, Long long1, List list1)
        throws ModelException;
        
    public  void saveLstRegistroOrden(List list, Long long1, Integer integer)
        throws ModelException;
        
    public  void saveLstRegistroLiquidosViaOral(List list, Long long1)
        throws ModelException;

    public  void saveLstRegistroLiquidosCanalizacion(List list, Long long1, Chcanalivena chcanalivena)
        throws ModelException;

    public  Ccfactserv getFacturaSevicio(Cnconsclin cnconsclin)
        throws ModelException;

    public  Ccdetafact getDetalleFacturaSevicio(Ccfactserv ccfactserv, Cpservicio cpservicio)
        throws ModelException;

    public  String getTipoContratoProfesional(Cpprofesio cpprofesio, Cnconsclin cnconsclin)
        throws ModelException;

    public  String getDescripcionOcupacion(Integer integer)
        throws ModelException;

    public  List getExamenesImagenesConsulta(Long long1)
        throws ModelException;

    public  List getExamenesElectrofisiologicosConsulta(Long long1)
        throws ModelException;

    public  List getExamenesLaboratoriosConsulta(Long long1)
        throws ModelException;

    public  Chcertmedico getCertificado(Long long1, String s)
        throws ModelException;

    public  Chremihospit getRemisionHospitalizacion(Long long1)
        throws ModelException;

    public  Chresersangr getReservaSangre(Long long1)
        throws ModelException;

    public  Cnprofxcon getHonorarioConsulta(Cnconsclin cnconsclin, Cpprofesio cpprofesio)
        throws ModelException;

    public  List getRemisionViolencia(String s)
        throws ModelException;

    public  String getTipoRemisionViolencia(String s)
        throws ModelException;

    public  String getDescripcionRemisionViolencia(String s)
        throws ModelException;

    public  Long getExisteConsulta(Integer integer)
        throws ModelException;

    public  void saveEvolucion(Chevolucion chevolucion)
        throws ModelException;
   
    public void saveOtraOrden(Chcontroorden otraOrden) throws ModelException;  

    public  List getEvolucion(Long long1, Integer integer)
        throws ModelException;

    public  Chevolucion getEvolucionSinCerrar(Long long1, String s)
        throws ModelException;

    public  void closeEvolucionMedica(Long long1, Integer integer)
        throws ModelException;

    public  void saveValoracionAnestesia(Chvalorprean chvalorprean)
        throws ModelException;

    public  List getPreguntasAnestesia()
        throws ModelException;

    public  void saveCuestionarioPreanestesia(List list, Long long1)
        throws ModelException;

    public  String getDescripcionCuestionarioAnestesia(Integer integer)
        throws ModelException;

    public  List getCuestionarioPreanestesia(Long long1)
        throws ModelException;

    public  void saveResultadosParaclinicos(Chresulparac chresulparac)
        throws ModelException;

    public  Chresulparac getResultadosParaclinicos(Long long1)
        throws ModelException;

    public  void saveControlMedicamento(Chformulahos chformulahos, Chcontrmedic chcontrmedic)
        throws ModelException;

    public  void saveControlMedicamentoNota(Chformulahos chformulahos, Chcontrmedic chcontrmedic, Chnotaenferm chnotaenferm)
        throws ModelException;

    public  String getEtapaActualNotaEnfermeria(Long long1)
        throws ModelException;

    public  Chordecirugi getOrdenCirugia(Long long1, String s, Integer integer)
        throws ModelException;
        
    public Chcontroorden getOtrasOrdenCirugia(Long numeroCirugia, 
                                      
                                        Integer consecutivo) throws ModelException;      

    public  List getListPrescripciones(Long long1, String s, Integer integer)
        throws ModelException;

    public  Chincapacida getIncapcidad(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getExamenesLaboratorios(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getExamenesImagenes(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getExamenesElectrofisiologicos(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getRemisionConsulta(Long long1, String s, Integer integer)
        throws ModelException;

    public  Chcertmedico getCertificado(Long long1, String s, Integer integer, String s1)
        throws ModelException;

    public  Chresersangr getReservaSangre(Long long1, String s, Integer integer)
        throws ModelException;

    public  Chremihospit getRemisionHospitalizacion(Long long1, String s, Integer integer)
        throws ModelException;

    public  Chconducta getConducta(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getLstFormulaLiquidos(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getLstFormulaHospitalizacion(Long long1, String s, Integer integer)
        throws ModelException;
        
    public List<Chcontroorden> getLstOtrasOrdenes(Long numeroCirugia, 
                                                           Integer consecutivo) throws ModelException;      

    public  Chmedidapoyo getMedidasApoyo(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getLstMedicamentosEspeciales(Long long1, String s, Integer integer)
        throws ModelException;

    public  List getCirugiaProgramadaEpicrisis(Chusuario chusuario)
        throws ModelException;

    public  void saveEncabezadoRegistroAnestesia(Chanestesia chanestesia)
        throws ModelException;

    public  Chanestesia getEncabezadoRegistroAnestesia(Long long1)
        throws ModelException;

    public  void saveMonitorAnestesia(Chmonitoria chmonitoria)
        throws ModelException;

    public  Chmonitoria getMonitoriaAnestesia(Long long1)
        throws ModelException;

    public  void saveTecnicaAnestesia(Chtecnianest chtecnianest)
        throws ModelException;

    public  Chtecnianest getTecnicaAnestesia(Long long1)
        throws ModelException;

    public  Chexamfisico getUltimoExamenFisicoUsuario(Long long1)
        throws ModelException;

    public  Chimprdiag getUltimoImpresionDiagnosticaUsuario(Long long1)
        throws ModelException;

    public  Chevolucion getUltimaEvolucionConsulta(Long long1)
        throws ModelException;

    public  Chconducta getUltimaConductaConsulta(Long long1)
        throws ModelException;

    public  Chconsulta getUltimaConsultaExternaUsuario(Long long1)
        throws ModelException;

    public  Chantegineco getUltimoAntecedentesGinecologicos(Long long1)
        throws ModelException;


    public  Chanteginecopre getUltimoAntecedentesGinecologicospre(Long long1)
        throws ModelException;

    public  void saveMedidaProfilactica(Chposicanest chposicanest)
        throws ModelException;

    public  Chposicanest getMedidaProfilactica(Long long1)
        throws ModelException;

    public  void saveControlViaAerea(Chventiaerea chventiaerea)
        throws ModelException;

    public  Chventiaerea getControlViaAerea(Long long1)
        throws ModelException;

    public  void saveMedicamentosAnestesia(List list, Long long1, String s)
        throws ModelException;

    public  List getMedicamentosAnestesia(Long long1, String s)
        throws ModelException;

    public  Crripsserv getParametrosRipsXClinica(Cnconsclin cnconsclin)
        throws ModelException;

    public  Crarcproce getRipsCitologia(Cnconsclin cnconsclin)
        throws ModelException;

    public  List getCuestionarioEsterilizacion(Long long1)
        throws ModelException;

    public  void saveCuestionarioEsterilizacion(Chcuestester chcuestester)
        throws ModelException;

    public  List getCitologiaLectura(Date date, Date date1, int i, String s, final List<Integer> listaTipoHistoria)
        throws ModelException;

    public  List getVphLectura(Date date, Date date1, int i, String s)
        throws ModelException;

    public  Cpprofesio getProfesionalesLectura(int i, BigDecimal bigdecimal)
        throws ModelException;

    public  BigDecimal saveListaEntregaCitologia(Chentregacitol chentregacitol)
        throws ModelException;

    public  Long saveListaEntregaVph(Chentregavph chentregavph)
        throws ModelException;

    public  List getListadoCitologias(Integer integer, String s)
        throws ModelException;

    public  void saveDetalleListaCitologias(List list)
        throws ModelException;

    public  List getCitologiaLecturaDos(Integer integer)
        throws ModelException;

    public  void saveEnvioCitologias(Chentregacitol chentregacitol)
        throws ModelException;

    public void saveAplicacionRetiroDispositivo(final Chdispoaplic dispositivo,final List<Cfdetafactura> listaServicios)
        throws ModelException;

    public  Chdispoaplic getAplicacionRetiroDispositivo(Long long1)
        throws ModelException;

    public  List getCitologiasEntregadas(Date date, Date date1, int i)
        throws ModelException;

    public  List getPatologosLecturas(Chproflect chproflect)
        throws ModelException;

    public  List getClinicas()
        throws ModelException;

    public  List getListaProfesionalesXClinica(Integer integer)
        throws ModelException;

    public  void saveProfesionalLectura(Chproflect chproflect)
        throws ModelException;

    public  List getSeguimientoCitologias(Date date, Date date1, Integer integer)
        throws ModelException;

//    public  List getSeguimientoVphs(Date date, Date date1, Integer integer)
//        throws ModelException;

    public  void savePlantillaUsuario(List list, String s)
        throws ModelException;

    public  List getPlantillaUsuario(String s)
        throws ModelException;

    public  List getPlantillaUsuarioCriterios(String s, Chplantilla chplantilla)
        throws ModelException;

    public  List getConsultasClinicasXDia(Date date, Integer integer, Integer integer1)
        throws ModelException;

    public  void saveOrUpdatePatologia(Chotraspatolog chotraspatolog)
        throws ModelException;

    public  Chotraspatolog getOtrasPatolog(Chotraspatolog chotraspatolog)
        throws ModelException;

    public  Object getInfoFactura(Integer integer, Integer integer1, Integer integer2)
        throws ModelException;

    public  List getDetalleFact(Integer integer, Integer integer1)
        throws ModelException;

    public  Cpservicio getServicioClinico(Cpservicio cpservicio)
        throws ModelException;

    public  List getPatologiasLectura(Date date, Date date1, int i, int j)
        throws ModelException;

    public  Cpprofesio getProfesionalesPatologia(int i, Integer integer)
        throws ModelException;

    public  BigDecimal saveListaEntregaPatologia(Chentregapatol chentregapatol)
        throws ModelException;

    public  List getSalasEspera(Integer integer, String s)
        throws ModelException;

    public  List getConsultasProfesional(Date date, Integer integer, Integer integer1, Integer integer2)
        throws ModelException;

    public  List getConsultasProfesionalBySala(Date date, BigDecimal bigdecimal, Integer integer, Integer integer1)
        throws ModelException;

    public  List getServiciosPorProfesional(Integer integer, Integer integer1, String s)
        throws ModelException;
        
    public List getServiciosPorProfesionalXContrato(Integer codclin, BigDecimal codmed, Cpservicio servicio,Integer codigocontrato) throws ModelException;

    public  void asignarPrioridad(Integer integer, Integer integer1, List list)
        throws ModelException;

    public  void saveProfesionalPrioridad(List list, Integer integer)
        throws ModelException;

    public  List getPrioridadProfesional(Integer integer)
        throws ModelException;

    public  Integer getSalaXservicioProfesional(Integer integer, String s)
        throws ModelException;

    public  void saveCuestionarioCervix(Chcancecervi chcancecervi)
        throws ModelException;

    public  Chcancecervi getCuestionarioCervix(Long long1, String s)
        throws ModelException;

    public  void saveAntecedentePsicologia(Chpsicoantec chantecpsico)
        throws ModelException;

    public  Chpsicoantec getAntecedentePsicologia(Long long1, String s)
        throws ModelException;

    public  void saveEvaluacionGeneral(Chevalugener chevalugener)
        throws ModelException;

    public  Chevalugener getEvaluacionGeneral(Long long1, String s)
        throws ModelException;

    public  void savePlanTratamiento(Chpladetrat chpladetrat)
        throws ModelException;

    public  Chpladetrat getPlanTratamiento(Long long1, String s)
        throws ModelException;

    public  void saveSeguimientoPsicologia(Chseguipsico chseguipsico)
        throws ModelException;

    public  Chseguipsico getSeguimientoPsicologia(Long long1, String s)
        throws ModelException;

    public  void saveAplicacionCervix(Chcervaaplic chcervaaplic)
        throws ModelException;

    public void saveAplicacionMedicamento(final List<Chmedicament> medicamento, final Long numeroConsulta, final String usuario) throws ModelException;

    public  Chcervaaplic getAplicacionCervix(Long long1, String s)
        throws ModelException;

    public   List<Chmedicament> getAdministracionMedicamento(Long long1, Integer integer)
        throws ModelException;

    public  Chcervaaplic getAplicacionCervixPrimera(Long long1)
        throws ModelException;

    public  Chcervaaplic getAplicacionCervixSegunda(Long long1)
        throws ModelException;

    public  void saveEsterilizacionMasculina(Chestermascu chestermascu)
        throws ModelException;

    public  Chestermascu getEsterilizacionMasculina(Long long1)
        throws ModelException;

    public  void updateClinicaUsuario(Integer integer, String s)
        throws ModelException;

    public  Integer getClinicaActiva(String s)
        throws ModelException;

    public  List getPatologosGeneral(Chprofpatol chprofpatol)
        throws ModelException;

    public  void saveProfesionalGeneral(Chprofpatol chprofpatol)
        throws ModelException;

    public  List getListadoPatologias(Chdetaentpatol chdetaentpatol)
        throws ModelException;

    public  void saveDetalleListaPatologias(List list)
        throws ModelException;

    public  List getListaEntregaPatol(Chentregapatol chentregapatol)
        throws ModelException;

    public  void saveCabeceraListaEnvio(Chentregapatol chentregapatol)
        throws ModelException;

    public  void liberarConsultaClinica(List list, String s)
        throws ModelException;

    public  List getConsultasCerradasProfesional(String s, Long long1, Date date)
        throws ModelException;

    public  void saveSolicitudAnulacion(Chsolicanula chsolicanula)
        throws Exception;

    public  List getSolicitudesAnulacionClinica(Integer integer)
        throws Exception;

    public  void updateSolicitudAnulacion(Chsolicanula chsolicanula)
        throws Exception;

    public  void saveLogImpresionHistorias(Chlogimpresi chlogimpresi)
        throws Exception;

    public  boolean verificarCitologia(Integer integer)
        throws Exception;

    public  List getCitologiasImpresionUsuario(String s, Integer integer, Date date)
        throws Exception;

    public  List getConsultasSinCerrar(String s, Integer integer, Date date)
        throws Exception;

    public  List getComboPatologos(Chprofpatol chprofpatol)
        throws ModelException;

    public  Chremisilve getRemisionIlve(Long long1, String s)
        throws ModelException;

    public  void saveRemisionIlve(Chremisilve chremisilve)
        throws ModelException;

    public  void saveEstadoPsicoemocional(Chestadpsico chestadpsico)
        throws ModelException;

    public  Chestadpsico getEstadoPsicoemocional(Long long1, String s)
        throws ModelException;

    public  List getConsultasSinCerrarClinica(Integer integer, Date date, Date date1)
        throws ModelException;

    public  List getAntecedentesGinecologicoValoracion(Date date, Date date1, Integer integer)
        throws ModelException;

    public  List getReporteActividadesEducativas(Date date, Date date1, Integer integer)
        throws ModelException;

    public  List getFoliosUsuarioIncompleto(Long long1)
        throws ModelException;

    public  String getDescripcionActoQuirurgico(Integer integer)
        throws ModelException;

    public  List getDatosRipsConsulta(Date date, Date date1, Integer integer, Integer integer1, String s)
        throws ModelException;

    public  List getTipoUsuarioClinico(Integer integer)
        throws ModelException;

    public  List getCvcontratoClinico(Integer integer)
        throws ModelException;

    public  String getCompromisosPsicologiaByUsuario(Long long1)
        throws ModelException;

    public  void saveColposcopia(Chcolposcopia chcolposcopia)
        throws ModelException;

    public  Chcolposcopia getColposcopia(Long long1)
        throws ModelException;

    public  List getServiciosAnexosControlSinCosto(String s)
        throws ModelException;

    public  List getOportunidadEntregaGeneral(Date date, Date date1, Integer integer)
        throws ModelException;

    public  List getReportePorcentajeManual(Date date, Date date1, Integer integer, BigDecimal bigdecimal, Integer integer1, String s)
        throws ModelException;
        
    public List<Object[]> getReporteRadicacionFacturas(Date fechaInicial, 
                                                     Date fechaFinal) throws ModelException;
                                                     
    public List<Object[]> getReporteFacturacionContrato(Date fechaInicial, 
                                                     Date fechaFinal, Integer contrato, Integer wclinica) throws ModelException;

    public  List getListaHistoriaIntervencionAsesoria(Integer integer)
        throws ModelException;

    public  String getDescripcionIntervencionAsesoriaXid(Integer integer)
        throws ModelException;

    public  void saveAsesoriaAvise(Chaseavise chaseavise)
        throws ModelException;

    public  void saveAsesoriaHunanitaria(Chasesohuman chasesohuman)
        throws ModelException;

    public  List getAsesoriaHumanitariaXUsuario(String s, Integer integer)
        throws ModelException;

    public  void saveOtraAsesoria(Chasesoria chasesoria)
        throws ModelException;

    public  void saveSeguimientoAvise(Chseguavis chseguavis)
        throws ModelException;

    public  Chaseavise getAsesoriaUsuario(Chusuario chusuario)
        throws ModelException;

    public  List getAsesoriaUsuario(Chusuario chusuario, Date date)
        throws ModelException;

    public  List getListAsesoriaUsuario(Chusuario chusuario)
        throws ModelException;

    public  List getBuscadorFacturas(Chusuario chusuario, Date date, Date date1)
        throws ModelException;

    public  boolean verificarAsesoriaDia(Chusuario chusuario, Date date)
        throws ModelException;

    public  boolean verificarAsesoriaDiaPosterior(Chusuario chusuario, Date date)
        throws ModelException;

    public  List getCirugiasProgramadasActivas(Integer integer, String s, String s1,Date fechaCirugia, BigDecimal wcodmed)
        throws ModelException;

    public  List getCirugiasProgramadasAnestesia(Integer integer, String s, String s1, Date fechaCirugia, BigDecimal wcodmed)
        throws ModelException;

    public  List getCirugiasProgramadasEpicrisis(Integer integer, Date fechaHoy)
        throws ModelException;

    public  List getCirugiasProgramadasIngresoEnfermeria(Integer integer, Date date)
        throws ModelException;

    public  List getCirugiasProgramadasIngresoMedico(Integer integer, Date date)
        throws ModelException;

    public  List getDonante()
        throws ModelException;

    public  List getLibroControlCitologia(Date date, Date date1, Integer integer)
        throws ModelException;

    public  String getDescripcionParametrosCitologia(String s, String s1, String s2)
        throws ModelException;

    public  String getDescripcionTipoProfesional(Integer integer)
        throws ModelException;

    public  String getDescripcionTipoEspecialidad(Integer integer)
        throws ModelException;

    public  List getListaDetalleCirugiasProgramadas(Long long1)
        throws ModelException;

    public  Chdetacirpro getCirugiaDetallada(Long long1, String s)
        throws ModelException;

    public  List getDetalleCirugiasProgramadas(Long long1)
        throws ModelException;

    public  List getDetalleCirugiasProgramadasBasico(Long long1,  boolean registro)
        throws ModelException;

    public  List getReporteAsesoraIlve(Integer integer, Date date, Date date1)
        throws ModelException;

    public  List getReporteMisAsesoraIlve(Integer integer, Date date, Date date1, String s)
        throws ModelException;

    public  List getReporteClinicAsesoraIlve(Integer integer, Date date, Date date1)
        throws ModelException;

    public  List getOtrasAsesoria(Chusuario chusuario)
        throws ModelException;

    public  List getListaOtrasAsesorias(Date date, Date date1, Integer integer)
        throws ModelException;

    public  void savelstCitologia(List list)
        throws ModelException;

    public  void saveUsuarioSap(Chusuario chusuario, String s, List list, Integer integer, String s1)
        throws ModelException;

    public  BigDecimal getDescuentoEmpleado(String s, String s1, BigDecimal bigdecimal)
        throws ModelException;

    public  List getValidarContrato(Integer integer, Integer integer1, String s)
        throws ModelException;

    public  Cpentidadadm getEntidadEpsxCodigo(String s)
        throws ModelException;

    public  Cpocupacio getOcupacionPorCodigo(Integer integer)
        throws ModelException;

    public  List getPrograma()
        throws ModelException;

    public  List getCie10Ilve(Integer integer)
        throws ModelException;

    public  List getCie10ControlIlve(Integer integer, Integer integer1)
        throws ModelException;

    public  void saveActividadEducativa(Chactiveduca chactiveduca)
        throws ModelException;

    public  List getCuestionarioEsterilizacionPorUsuaria(Long long1)
        throws ModelException;

    public  List getConsultasReferenciaPorConfirmar(Integer integer)
        throws Exception;

    public  List getReporteAutorizacionServicios(Integer integer, Date date, Date date1)
        throws ModelException;

    public  void saveTipoServicio(Chtiposerv chtiposerv)
        throws ModelException;

    public  List getLstTipoServicio()
        throws ModelException;

    public  List getServiciosSalud(Cpservicio cpservicio)
        throws ModelException;

    public  void saveServicioXTipo(Chserxtipo chserxtipo)
        throws ModelException;

    public  List getLstServicioXTipo(Integer integer)
        throws ModelException;

    public  void deleteServicioXTipo(Chserxtipo chserxtipo)
        throws ModelException;

    public  List getReporteIlve(Date date, Date date1, Integer integer)
        throws ModelException;
        
    public  List getReporteIlveNal(Date date, Date date1, Integer integer)
        throws ModelException;

    public  List getReporteResolucion256(Date date, Date date1, Integer integer)
        throws ModelException;

    public  void saveSalaCirugia(Chconsultori chconsultori)
        throws ModelException;

    public  List getSalasCirugia()
        throws ModelException;

    public  List getConsultasMedicamentoDia(Date date, Integer integer, BigDecimal bigdecimal, String numeroIden)
        throws ModelException;

    public  void saveLstRegistroLiquidosAnestesia(List list, Long long1)
        throws ModelException;

    public  List getLstLiquidosAdministradoParcialAnestesia(List list)
        throws ModelException;

    public  List getLstLiquidosAdministradoParcialAnestesiaIni(Long long1)
        throws ModelException;

    public  void saveLstRegistroLiquidosControlAnestesia(List list, Long long1)
        throws ModelException;

    public  List getLstLiquidosAdministradosAnestesia(Long long1)
        throws ModelException;

    public  void saveLstRegistroLiquidosAnestesiaEtapaIniciadoLiquido(List list, Long long1)
        throws ModelException;

    public  void saveAplicacionVacuna(Chvacunacion chvacunacion)
        throws ModelException;

    public  Chvacunacion getAdministracionVacuna(Long long1)
        throws ModelException;

    public  Cpservicio getServicioXNumeroConsulta(Long long1)
        throws ModelException;

    public  void saveViolenciaSivigila(Chvsolsivig chvsolsivig)
        throws ModelException;

    public  Chvsolsivig getViolenciaSivigila(Long long1)
        throws ModelException;

    public  boolean esPoliciaNacional(Integer integer)
        throws ModelException;
        
    public void saveAplicacionEspermograma(Chespervasec aplicacion, Cnconsclin consulta) throws ModelException;

    public void saveEspermogramaFertilidad(Cnespermog espermograma, Cncapaespe capacitacion) throws ModelException;
    
    public Chespervasec getAdministracionEspermograma(Long numeroConsulta) throws ModelException;

    public Cnespermog getEspermogramaFertilidad(Long numeroConsulta) throws ModelException;

    public Cncapaespe getCapacitacionFertilidad(Integer clinica, Integer numeroEspermograma) throws ModelException;
    
    public List<Cnconsclin> getConsultasEspermogramaDia(final Date dia, 
                                                           final Integer codclinica, 
                                                           final BigDecimal idMedico) throws ModelException;
                                                           
                                                           
    public List<Chvademprof> getVademecumHistorias(Chvademprof medicamento) throws ModelException;
    
    public List<Object[]> getReporteServiciosSinFactura(Date fechaInicial, 
                                                     Date fechaFinal) throws ModelException ;
       /**
     * 
     * @param fechaInicial
     * @param fechaFinal
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReporteServiciosIppf(Date fechaInicial, 
                                                     Date fechaFinal,Integer wivefarser) throws ModelException
                                                     ;
                                                     
    public BigDecimal getNumeroFactura(Long cconnumero) throws ModelException ;
        
    public void saveDatosFertilidad(Chfertdato fertdato) throws ModelException ;
    
    public void saveDatosEcografiaFertilidad(Chfertecog ecografia) throws ModelException ;
    
    public Chfertdato getDatosFertilidad(Long consclin) throws ModelException ;
    
    public Chfertecog getDatosEcografia(Long consclin) throws ModelException;
    
    /**
     * 
     * @param antecedente
     * @throws ModelException
     */
    public void saveAntecedentesVasectomia(Chantecvasec antecedente) throws ModelException;
    
    /**
     * 
     * @param idConsulta
     * @return
     * @throws ModelException
     */
    public Chantecvasec getAntecedenteVasectomia(Long idConsulta) throws ModelException;
    
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
                                      final String userName) throws ModelException;
                                    
                                    
    /**
     * 
     * @param clinica
     * @return
     * @throws ModelException
     */
     public List<Chregiconpro> getConsultaSinFacturaPorConfirmar(final Integer clinica) throws ModelException;
    
    /**
     * 
     * @param numero
     * @return
     * @throws ModelException
     */
    public Cnconsclin getConsinfacByNumero(Long numero) throws ModelException;


    /**
     * @param contrato
     * @return
     * @throws ModelException
     */
    public List<Cpcontrato> getContratoPorCriterios(Cpcontrato contrato) throws ModelException;
    
    public Cpcontrato getContratoPornumero(Integer contrato) throws ModelException;

    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chparacgener> getParaclinicosGeneral(Long numeroConsulta) throws ModelException;
    
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chcontroorden> getOtrasOrdenes(Long numeroConsulta) throws ModelException;
    
    /**
     * 
     * @param paraclinicos
     * @param numeroConsulta
     * @throws ModelException
     */
    public void saveParaclinicosGeneral(final List<Chparacgener> paraclinicos, 
                                        final Long numeroConsulta) throws ModelException ;
                                        
      /**
     * 
     * @param otrasOrdenes
     * @param numeroConsulta
     * @throws ModelException
     */
    public void saveOtrasOrdenes(final List<Chcontroorden> otrasOrdenes, 
                                 final Long numeroConsulta, final String usuario,final List<Chcontroorden> ordenesSuspender) throws ModelException;                                    
                                        
    /**
     * 
     * @param edad
     * @param genero
     * @return
     * @throws ModelException
     */
    public String getCodigoUIDIppf(BigDecimal edad, 
                                                    String genero) throws ModelException; 
                                                    
     /**
     * 
     * @param servicio
     * @return
     * @throws ModelException
     */
      public List<Clcomserv> getCodigoServiIppf(final String servicio) throws ModelException;
                                                    
                                                    
    public List<Object[]> getReporteInformacionAborto1(Date fechaInicial, Date fechaFinal, Integer wclinica) throws ModelException;
    
    public List<Object[]> getReporteInformacionAborto2(Date fechaInicial, Date fechaFinal, Integer wclinica) throws ModelException;
    
    public  Cpservanex getCpservanex(String servicioOri, String servicioCtl) throws ModelException;

    public  Integer getControlesPorServicio(Cnconsclin consclin, Chconsprogra control)
        throws ModelException;
        
    public List<Chcirugprogr> getCirugiasClinicasXFecha(final Date date, final Date fechaFinal, final Integer sala, final Integer codclin, final Long wusuario) throws ModelException;
    
    public List getListaCirugiasHonorarios(Date fechaInicial, Date fechafinal, Integer clinica) throws ModelException;

    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getFoliosEspermogramaVasectomia(final Long numeroUsuario) throws ModelException; 
    
    
   
    public Chidentiriesgo getIdentificacionRiesgos(Long numeroUsuario) throws ModelException;
    

    public Cvcontrato getCvcontratoClinica(Integer clinica, Integer contrato) throws ModelException; 
    
    public void saveIdentificaRiesgo(Chidentiriesgo identiriesgo) throws ModelException;
    
    public List<Crdgncie10> getCriteriosIveCie10(Crdgncie10 cie10, boolean bloquearZ) throws ModelException;

    public Crdgncie10 getCIE10IVEPorCodigo(String codigo, boolean bloquearW) throws ModelException ;

    /**
     * @param consulta
     * @return
     * @throws ModelException
     */
    public Chfertdato getFertilidadDatos(Long numeroConsulta) throws ModelException ;

    /**
     * @see ClinicoDaoImp#saveRegistroFertilidad(regferti)
     * Salvar Registro de Fertilidad
     */
    public void saveRegistroFertilidad(Cnregferti regferti) throws ModelException ;

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
                                                        Integer clinica) throws ModelException;

    /**
     * @param fechaInicial
     * @param fechaFinal
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getMedicamentoVacuna(Date fechaI, 
                                               Date fechaF, 
                                               Integer clinica) throws ModelException; 

    /**
     * Obtener Lista de Citologias enviadas para lectura. 
     */
    public List getEnvioCitologiaLectura(Integer numero) throws ModelException; 


    /**
     * @param dia
     * @param codclinica
     * @param idMedico
     * @return
     * @throws ModelException
     */
    public List<Agendamiento> getMisConsultasDiaAgenda(final Date dia, 
                                               final Integer codclinica, 
                                               final BigDecimal idMedico) throws ModelException;

    public Cnconsclin getConsultaFechaUsuario(Date fecha, Integer clinica, String servicio, Long numusuario) throws ModelException;
    
    public void saveConfirmacionServicio(final Chconfiservi confirmacion,Cnconsclin consulta,String userName,String codigoProfesional) throws ModelException;
    
    public Chconfiservi getConfirmacionServicio(Long numeroConsulta) throws ModelException;
    
    public Cfadmision getAdmision(Long numeroAdmision) throws ModelException;
    
    public List<Cfdetaadmision> getDetalleAdmision(Long numeroAdmision)throws ModelException;
    
    public List<Object[]> getInsumosByServicio(String codigoServicio)throws ModelException;
    
    public  List<Object[]> getRegistroInsumosBynumeroConsulta(Long numeroConsulta)throws ModelException;
    
    public void saveRegistroInsumos(List<Chreginsumo> chreginsumoList) throws ModelException;
    
    public List<Chcauspaus> getListaCausasPausarConsulta() throws ModelException;
    
    public void saveRegistroTiempoAtencion(Chtiempaten chtiempaten) throws ModelException;
    
    public List<Chtiempaten> validacionConsultasAbiertasDelDiaXMedico(Integer codigoMedico) throws ModelException;
    
    public Chtiempaten consultarTiempoAtencionAbiertaXConsulta(Long numConsulta)throws ModelException;
    
    public List<Chtiempaten> consultarTiempoAtencionVigentesXconsulta(Long numConsulta) throws ModelException;
    
    public Chtiempaten consultarTiempoAtencionVigenteXconsulta(Long numConsulta) throws ModelException;
    
    public List<Chregicomp> getRegistroComplementarioUsuario(final Chusuario usuario) throws ModelException;
       
    public List<Chregitelf> getRegistroTelefonicoUsuario(final Chusuario usuario) throws ModelException;
       
    public void saveRegistroComplementario(Chregicomp registroComplementario) throws ModelException;
       
    public void saveUsuarioRegistroComplementario(final Chusuario usuario,final String userName) throws ModelException;
       
    public void saveUsuarioRegistroTelefonico(final Chusuario usuario,final String userName) throws ModelException;

    public void saveRegistroTelefonico(Chregitelf registroTelefonico) throws ModelException;

    public List getControlesPorCriterios(Cpservicio cpservicio) throws ModelException;
    
    public List getServiciosPorTipoConsulta(Long tipoConsulta) throws ModelException;
    
    public List<Chcontroladi> getControlAdicional(Long numeroConsulta) throws ModelException;
    
    public List<Chcontroladi> getControlAdicional(Cnconsclin consclin) throws ModelException;
    
    public void saveControlAdicional(Chcontroladi controlAdi) throws ModelException;
    
    public List<Cpservicio> getServiciosByCodigos(final List<String> codigosServicio) throws ModelException;
    
    public List<Object[]> getListaServiciosFactura(Long admision) throws ModelException;
    
    public Cnconsclin generarConsultaClinica(final Cnconsclin consulta) throws ModelException ;
    
    public void saveDetalleFactura(final List<Cfdetafactura> cfdetafacturaList,final Long numeroAdmision) throws ModelException;
    
    public List<Cpprofesio> getProfesionalXClinica(final Long clinica) throws ModelException ;
    
    public Chgeslabor getLaboratorioXClinica(final Long clinica) throws ModelException ;
    
    public void saveLaboratorio(final Chgeslabor chgeslabor) throws ModelException;
    
    public List<Cnconsclin> getConsultasDiaXNumIden(final Integer codclinica, final BigDecimal idMedico,final String numIden) throws ModelException ;
    
    public void updateConsultaClinicaAgendamiento(final Agendamiento agendamiento) throws ModelException;
    
    public void saveNovedadAdmision(final Cfdetaadmision detaadmision,final Cfdetafactura detafactura,final Chconfiservi confirmacion) throws ModelException;
    
    public void updateCnconsclin(final Cnconsclin consclin) throws ModelException;
    
    public List<Cnconsclin> getMisConsultasDiaXNumIden(final Integer codclinica, final BigDecimal idMedico,final String numIden) throws ModelException ;


    public List<Cnconsclin> getCnconsclinLectura(final Long numeroUsuario, int codigoClinica, final String codigoEtapa, List<Integer> listaTipoHistoria) throws ModelException;
    
    public List<Cnconsclin> getCnconsclinLecturaMod(final Long numeroUsuario, int codigoClinica, final String codigoEtapa, List<Integer> listaTipoHistoria) throws ModelException;
    
    public List getCitologiaExtendedEntregableBetweenFechaClinica(Date fechaInicial, Date fechaFinal,
            int codigoClinica, final List<Integer> listaTipoHistoria) throws ModelException;
            
    public Cncitovphlect getLecturaCitologiaVph(Integer consecutivo) throws ModelException;
    
    public List<Cnconsclin> getConsultasDiaNotaEnfermeria(final Date dia, final Integer codclinica) throws ModelException ;
    
    public List<Cnconsclin> getConsultasDiaNotaEnfermeriaXNumIden(final Integer codclinica,final String numIden) throws ModelException ;
    
    public Chingresoenf getIngresoEnfermeriaProcedimiento(Long hielnumero) throws ModelException ;
    
    public void saveLecturaCitologiaVph(Cncitovphlect lectura) throws ModelException;
   
    /**
    *
    * @param fechaInicial
    * @param fechaFinal
    * @return
    * @throws ModelException
    */
    public List<Object[]> getReporteUsuariosIppf(Date fechaInicial,
                                                  Date fechaFinal, String periodo) throws ModelException;

    public  Clcateippf getClcateippf(Integer integer)
        throws ModelException;

    public List<Clcomserv> getClcomservAll() throws ModelException;

//    public  List getConsultasImprimirFolios() throws ModelException;

//    public Chconsulta getCirugiaUsuarioServicio(final Long usuario, final String servicio) throws ModelException; 
    
//    public Cpcontrato getCpcontrato(Integer clinica, Integer numero) throws ModelException; 

 
    public Chconsulta saveChconsulta(final Cnconsclin cnconsclin, final String estado, final String codigoFuncionario) throws ModelException;
    
    public List<Cnconsclin> getCnconsclinLecturaXAdmision(final Long numeroUsuario, final BigDecimal admision) throws ModelException ;
    
    public List<Object[]> getListaServiciosXAdmision(Long admision,String opcion) throws ModelException ;
    
    public List<Object[]> getListaServiciosDobleConUnaAtencion(Long admision,String servicio) throws ModelException ;
    
    public List<Object[]> getListaLaboratorioFacturados(Long admision) throws ModelException ;
    
    public List<Object[]> getRegistrosSegTelefonico(Long clinica,Date fechaInicial, Date fechafinal) throws ModelException ;
    
    public void saveOrdenCirugiaLiberacion( final List<Cnconsclin> listadeConsultasClinicas,
                                           final List<Cfdetafactura> cfdetafacturaList,
                                           final Long numeroAdmision,
                                           final Chordecirugi orden) throws ModelException ;
   
    public void saveListRemisionInterconsultaCirugiaLiberacion(final List<Chremision> lstRemision, 
                                                               final Long numeroConsulta, 
                                                               final String tipoServicio, 
                                                               final Integer consecutivo, 
                                                               final List<Cnconsclin> listadeConsultasClinicas, 
                                                               final List<Cfdetafactura> cfdetafacturaList, 
                                                               final Long numeroAdmision) throws ModelException ; 
                                                               
    public void saveListExamenesLaboratorioCirugiaLiberacion(final List<Chexamelabor> lstRemision, 
                                                   final Long numeroConsulta, 
                                                   final String tipoServicio, 
                                                   final Integer consecutivo, 
                                                   final String descripcionRemision,
                                                   final List<Cnconsclin> listadeConsultasClinicas, 
                                                   final List<Cfdetafactura> cfdetafacturaList, 
                                                   final Long numeroAdmision) throws ModelException ;   
                                                   
    public List<Cpservicio> getExamenesLaboratorioFertilidadPorCriterios(Cpservicio servicio) throws ModelException ;                                                
    
    public List<Cnconsclin> getConsultasLaboratorioXFactura(final Integer tipoDcoumento, final BigDecimal numeroDocumento) throws ModelException;
       
    public void closeLaboratorio(final List<Cnconsclin> lstconsulta, 
                                   final String userName) throws ModelException; 
    
    public Cncitologi getCitologiaByAdmisionAndTipoHistoria(Cnconsclin consulta,Integer tipoHistoria ) throws ModelException ;
    
    public List<Cfdetafactura> validacionTomaPaquete(Integer consultaClinica) throws ModelException ;   

    public List<Cfdetafactura> validacionTomaPaquete(Long numAdmision, String codServicio, Long numConsulta) throws ModelException ;   
    
    public List<Cfdetafactura> validacionPaqueteLectura(Integer consultaClinica) throws ModelException ;


    
//  public Cffactura getCffacturaByAdmision(Long numAdmision) throws ModelException; 

 public Agendamiento getPrimerAgendaUsuarioServicioFecha(final Date fecha, 
                                         final Integer clinica, 
                                         final Integer tipoagenda, 
                                         final Long numusuario) throws ModelException;

    /**
     * @param interconsulta
     * @return
     * @throws ModelException
     */
    public List<Chtipointerc> getInterconsultaPorCriterios(Chtipointerc interconsulta) throws ModelException;
    
    public Chtipointerc getInterconsultaPorCriterios(String interconsulta) throws ModelException;
    
    public List<Cnconsclin> getServiciosXFacturaMedicamentoDia(final Cnconsclin consulta) throws ModelException;

    
    public Cfdetafactura validacionServicioEntregaResultado(Integer consultaClinica) throws ModelException ;
    
    public void saveDetalleFactura(final Cfdetafactura detafactura) throws ModelException ;
    
    public List<Chtipoantece> getTipoAntecedentesIve(String tipoAntecedente) throws ModelException ;
    
    public void saveAntecedentesIve(final Long numeroConsulta,final Chantecdetal antecedentesDetallado) throws ModelException ;
                                 
    public Chantecdetal getAntecedentesDetallado(Long numeroConsulta) throws ModelException ;
    
    public List getCopiaVphXconsecutivo(Long numeroUsuario,Integer consecutivoCito) throws ModelException ;
    
    public List<Object[]> getTomaVphXclinicaAndFecha(Date fechaInicial,Date fechaFinal, Integer clinica) throws ModelException ;

    public void saveAntecedenteObstetricopr(Chanteobstpr chanteobstpr)
        throws ModelException;

    public  Chanteobstpr getAntecedenteObstetricopr(Long consulta)
        throws ModelException;
    
    public void saveValoracionBiopsicosocial(Chvalorabiopsi valoracion) throws ModelException ;
    
    public Chvalorabiopsi getValoracionBiopsicosocial(Long numeroConsulta) throws ModelException ;

    public Chasesoriaive getAsesoriaIve(Long consulta) throws ModelException ;
    
    public void saveAsesoriaIve(Chasesoriaive asesoria) throws ModelException ;
    
    public List<Chmetodoplan> getMetodosPlanificacionIve(String sexo) throws ModelException;
    
    public  List getConsultasTuberculinaDia(Date date, Integer integer, BigDecimal bigdecimal, String numeroIden)
        throws ModelException;
    
    public void saveLstRegistroOrdenCE(final List<Chcontroorden> orden) throws ModelException ;
    
    public List<Object[]> getListaServiciosValidacionRetiro(Long admision,String servicio) throws ModelException ;
    
    public Chantecespec getAntecedentesTuberculina(Long numeroConsulta) throws ModelException ;

    public void saveAntecedentesTuberculina(Chantecespec chantecespec)  throws ModelException;
    
    public Chantecpatol getAntecedentesPatologicosTuberculina(Long numeroConsulta) throws ModelException ;
    
    public void saveAntecedentesPatologicosTuberculina(Chantecpatol chantecpatol)  throws ModelException;
    
    public Chantecfarma getAntecedentesFarmacologicosTuberculina(Long numeroConsulta) throws ModelException ;
    
    public void saveAntecedentesFarmacologicosTuberculina(Chantecfarma chantecfarma)  throws ModelException;
    
    public List<Cnconsclin> getCnconsclinLecturaTuberculina(final Long numeroUsuario, int codigoClinica, final String codigoEtapa, List<Integer> listaTipoHistoria) throws ModelException;

    public Chlecttuber getLecturaTuberculina(Long numeroConsulta) throws ModelException ; 
    
    public void saveLecturaTuberculina(Chlecttuber chlecttuber) throws ModelException ; 

    public  Cpusuario getUsuarioPorOperador(String s) throws ModelException;

    
    public void saveLstRegistroLiquidosNota(final List<Chcontroliqu> liquidos, 
                                        final Long numero, 
                                        final List<Chformulaliq> lstFormulados,final List<Chnotaenferm> listaChnotaenferm) throws ModelException ;
                                        
    public List<Chconsulta> getFoliosUsuarioNotaComplementariaEnfemeria(final Long numeroUsuario, 
                                                            final String userName) throws ModelException ;
                                                            
    public void saveNotaComplementarioEnfermeria(final Chregcomenf nota, final Chrefepaci referenciaPaciente) throws ModelException ;
    
    public List<Chconsulta> getFoliosUsuarioInformePsicologico(final Long numeroUsuario, 
                                                            final String userName) throws ModelException ;
                                                            
    public void saveInformePsicologico(final Chinfopsico informe, final Chautoinfopsic autoriza) throws ModelException ;
    
    public List<Cpprofesio> getProfesionalXCedulaXNombre(BigDecimal cedulaprof,Integer codclin,String nombreProf) throws ModelException ;

    public List<Object[]> getReporteComplEnfer(Date fechaInicial, Date fechaFinal, 
                                     Integer codclin) throws ModelException;
    
    public void saveCuestionarioCovid(Cfencuecovid cuestionario) throws ModelException;

    public Cfencuecovid getEncuestaCovidXUsuario(final Long numeroUsuario, 
                           final Date fechaConsulta) throws ModelException;
                                     
    public  Chconsulta getConsultaActualHisteroscopia(Long long1)
        throws ModelException;
        
    public  Chhisteroscopia getConsultaRegistroHisteroscopia(Long numeroConsulta)
        throws ModelException;
   
    public  Chhallahistero getConsultaHallazgoHisteroscopia(Long numeroConsulta)
        throws ModelException;     
    
                                     
    public List<Object[]> getReporteReferencia(Integer codClinica, 
                                                          Date fechaInicial, 
                                                          Date fechaFinal) throws ModelException ;
    
    public void saveAntecedentesDetFertilidad(final Long numeroConsulta, 
                                    final Chantecdetal antecedentesDetallado) throws ModelException ;
    
    public List<Chantecdetal> getHistorialAntecedentesDetallado(Long numeroUsuario) throws ModelException ;
    
    public List<Object[]> getRegistrosLogImpresion(Long clinica,
                                                    Long numeroUsuario,
                                                    Date fechaInicial, 
                                                    Date fechafinal) throws ModelException ;
                                                    
    public List<Chconsulta> getFoliosUsuarioXnumConsulta(final Long numeroConsulta) throws ModelException ;
    
    public  List getCopiaTuberculina(Long long1)
        throws ModelException;
        
    public List<Chescvalcai> getEscalaValoracionCaidasXdia(Long numero) throws ModelException ;
    //PARA ADA IVE
    public Chregisabort findOneRegistroUsuarioAbort(final Long numeroUsuario)throws ModelException;
    public void saveSeguimientoUsuarioAbort(final Chcontabor chcontabor )throws ModelException;
    public void saveRegistroUsuarioAbort(final Chregisabort chregisabort)throws ModelException;
    public Chusuarioabor findOneUsuarioAbort(final Long numeId, final String tipoId)throws ModelException;
    //
    
    public void saveLecturaVphModificacion(final Cncitovphlect lectura) throws ModelException ;
    
    public List<Cnconsclin> getCnconsclinLecturaVPHMod(final Long numeroUsuario, int codigoClinica, final String codigoEtapa, List<Integer> listaTipoHistoria) throws ModelException;
    
    public List<Cnconsclin> getConsultasDiaPruebasRapidas(final Date dia, final Integer codclinica, final BigDecimal idMedico, final String numeroIdentificacion) throws ModelException;
    
    public List<Cnconsclin> getMisConsultasDiaPruebasRapidas(final Date dia, final Integer codclinica, final BigDecimal idMedico, final String numeroIdentificacion) throws ModelException;
    
    public List<Cnconsclin> getConsultasPruebasRapidasXFactura(final Integer tipoDcoumento, 
                                                            final BigDecimal numeroDocumento) throws ModelException ;

    public  List<Cnconsclin> getConsultaRegistroPAPsicologia(Long long1)
        throws ModelException;
        
    public  void savePAPsicologia(Chpapsicologico nota, Chusuario usuario,Cnconsclin consulta)
        throws ModelException;
        
    public  List getCopiaPapsicologico(Long long1)
        throws ModelException;
        
    public Chpapsicologico getPapsicologicosUser(Long numeroConsulta) throws ModelException ;
        
    public List<Cnconsclin> getMisConsultasCovidAnticuerpos(final Date dia, 
                                                       final Integer codclinica, 
                                                       final BigDecimal idMedico) throws ModelException;
                                                       
    public void saveAnticuerposCovid(Chpruecovidanticu covidAnticuerpo,final Chusuario usuario, final Cnconsclin consulta) throws ModelException;
    
    public Chpruecovidanticu getpruebaAnticuerpos(Long numeroConsulta) throws ModelException;
    
    public List<Cnconsclin> getMisConsultasCovidAntigenos(final Date dia, 
                                                       final Integer codclinica, 
                                                       final BigDecimal idMedico) throws ModelException;
                                                       
    public void saveAntigenosCovid(Chpruecovidantige covidAnticuerpo) throws ModelException;
    
    
    public Chpruecovidantige getpruebaAntigenos(Long numeroConsulta) throws ModelException;
    
    public List<Object[]> getRegistrosAnticuerposCovid(Long clinica,
                                                    Long numeroUsuario,
                                                    Date fechaInicial, 
                                                    Date fechafinal) throws ModelException ;
                                                    
                                                    
                                                    
    public List<Object[]> getRegistrosAntigenosCovid(Long clinica,
                                                    Long numeroUsuario,
                                                    Date fechaInicial, 
                                                    Date fechafinal) throws ModelException ;
    
    
public ResultadosLCResponse envioResultadosColposcopiaSaludTotal(Chusuario usuario, 
        Cnconsclin consulta,
        Chimprdiag impresion,String userName) throws ModelException ;
        
        
public ResultadosLCResponse envioResultadosVphSaludTotal(Chusuario usuario, 
        Cnconsclin consulta,
        Cncitovphlect lectura) throws ModelException ;  
        
public ResultadosLCResponse envioResultadosBaseLiquidSaludTotal(Chusuario usuario, 
        Cnconsclin consulta,
        Cncitolect lectura) throws ModelException;   
 public List<Chantegineco> getAntecedentesGinecologicosXUsuario(final Long usuario) throws ModelException;
    public void savePruebasRapidas(final Chpruerapi chpruerapi,final Chusuario usuario, final Cnconsclin consulta, 
                                   final String userName) throws ModelException; 
    
    public void closePruebasRapidas(final Chpruerapi chpruerapi,final Chusuario usuario, final Cnconsclin consulta, 
                                   final String userName) throws ModelException; 
                                   
                                   
    public void closeAnticuerposAntigenoCovid(final Cnconsclin consulta, 
                                   final String userName) throws ModelException;
                                   
    public List getCitologiaLecturaUsuario(String tipoId, Long numIde,int codCentro, String tipoLectura, 
                                       List<Integer> listaTipoHistoria) throws ModelException;
    public List<Object[]> getPruebasRapidas( final Long codigoUsuario) throws ModelException;
    
    public List<Object[]> getPruebasRapidasByConsulta( final Long consulta) throws ModelException;
    
    public List<Object[]> getRegistrosVPH(Long clinica, 
            Date fechaInicial, 
            Date fechafinal) throws ModelException ;     
            
    public List<Object[]> getReportePruebasRapidas(Integer codClinica, 
                                               Date fechaInicial, 
                                               Date fechaFinal, String tDoc, Long numIden) throws ModelException;

    public List<Object[]> getPruebasAnticuerposByConsulta( final Long consulta) throws ModelException;
    
    public List<Object[]> getPruebasAntigenosByConsulta( final Long consulta) throws ModelException;
    
    public ResultadosLCResponse envioResultadosPatologiaSaludTotal(Chusuario usuario, 
            Cnconsclin consulta,
            Chmotivocon motivo,String userName) throws ModelException ;
            
    public List<Cnconsclin> getServiciosXFacturaMedicamentoDiaxAdmision(final Cnconsclin consulta) throws ModelException ;
    
    public List<Cnconsclin> getMedicamentosByAdm(final BigDecimal admision) throws ModelException;
    
    public Chmedicament getMedicamentoByConsultaAsociada(final Long consulta) throws ModelException;

    public List<Chmedicament> getMedicamentoByConsulta(final Long consulta) throws ModelException;
    
    public void saveOrUpdateParamCorreo(Chcorreo correo)throws ModelException;
    
    public List<Chcorreo> readCorreo()throws ModelException;
    
    public List<Cpcontrato> getCriteriosContrato(Cpcontrato contrato,boolean exacto) throws ModelException;
    
    public List<Chcorreo> getCorreosByParam(Long numeroContrato) throws ModelException;
    
    public Object[] getNombreEntidad(String codigoEntidad) throws ModelException;
    
    public Chpruerapi getOnePruebasRapidasByConsulta( final Long consulta) throws ModelException;
    

       
    public List<Cnconsclin> getConsultasFragmentacionEspermaDia(final Date dia, 
                                                       final Integer codclinica, 
                                                       final BigDecimal idMedico, 
                                                       final String numeroIden) throws ModelException ;
    
    public List<Object[]> getRegistrosPruebasCovid(Long clinica, Long contrato, Date fechaInicial, Date fechafinal,String tipoPrueba) throws ModelException;
    
    public List<Cpcontrato> getCriteriosContratoByClinica(Cpcontrato contrato,boolean exacto,Integer numeroClinica) throws ModelException ;
    
    public boolean getConsultaClinicaIVEXUsuario(final Cnconsclin consulta, final boolean  accion) throws ModelException ;
    
    public Cfremiadmi getRemisionAdmision(Long numeroAdmision) throws ModelException ;
    
    public boolean  getDetalleAdmisionXTipoHistoria(Long numeroAdmision,Integer tipoHistoria) throws ModelException ;
    
    public List<Cnconsclin>  getConsultaAdmisionXTipoHistoria(Long numeroAdmision,Integer tipoHistoria) throws ModelException ;
    
    public void atenderConsultaClinica(final List<Cnconsclin> listaConsultas, final String userName) throws ModelException ;
    
    public boolean getConsultaAdmisionXTiposHistorias(Long numeroAdmision,List<Integer> listaTipoHistoria) throws ModelException ;
    
    public List<Cnconsclin>  getConsultaAdmisionXGrupoSubGrupoInterrupcion(Long numeroAdmision) throws ModelException ;
    
    public void saveFragmentacionEspermatica(final Chfragesperma fragesperma) throws ModelException ;
    
    public Chfragesperma getFragmentEsperma(Long numeroConsulta) throws ModelException ;
    
    public  List getCopiaTestFragE(Long long1) throws ModelException;
    
    public Chfragesperma getTestFargEConsulta(Long numeroConsulta) throws ModelException;
    
    public Cnprofxcon getProfesionalByConsulta(Long numeroConsulta)throws ModelException;
    
    public List<Chsegutelefo> getListVinisoUsuario(final Chusuario usuario) throws ModelException;
     
    public List<Chplanconsinfo> getConsentimientoInformado() throws ModelException ;
    
    public void saveConsentimientoInformado(final Chplanconsinfo consentimiento) throws ModelException ;
    
    public Chplanconsinfo getConsentimientoInformadoCodigo(Long codigo) throws ModelException ;
    
    public List<Chconinfxcon> getConsentimientoXConsulta(Long numConsulta) throws ModelException ;
    
    public void saveConsentimientoInformadoXconsulta(final List<Chconinfxcon> listConsentimientoXConsulta) throws ModelException ;
    
    public List<Chplanconsinfo> getConsentimientoInformadoXCliterios(Chplanconsinfo chplanconsinfo) throws ModelException ;
    
    public Chplanconsinfo getConsentimientoInformadoXCodigo(String codigo) throws ModelException ;
    
    public Chfertdato getDatosFertilidadUltimaPareja(Long numUsuario, String tipoIden) throws ModelException;    

    public List<Object[]> getPruebaDeEmbarazoDia( Long numeroUsuario, 
                                                       Date fecha, 
                                                          Date fechafinal) throws ModelException;
                                                          
    public List<Cnconsclin> getConsultasSaludTotal(final Date fechaIni,final Date fechaFin, 
                                            final Integer codclinica, 
                                            final Integer numDocPac,final Integer contrato1,
                                            final Integer contrato2,final String
                                            tipoReproceso) throws ModelException;
    
    public void saveOrUpdateChcorrelec(Chcorrelec correlec) throws ModelException;

    public Chcorrelec getChcorrelec(Long numConsulta) throws ModelException ;
    
    public void atenderConsultaClinicaIve(final List<Cnconsclin> listaConsultas, 
                                       final String userName, Cnconsclin consultaActual ) throws ModelException;

    public List<Cppais> getPaises() throws ModelException ;

}

