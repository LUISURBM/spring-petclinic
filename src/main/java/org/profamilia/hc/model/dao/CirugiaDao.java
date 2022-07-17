package org.profamilia.hc.model.dao;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import org.profamilia.hc.model.dto.Ccfactvent;
import org.profamilia.hc.model.dto.Chaldrete;
import org.profamilia.hc.model.dto.Chantalerg;
import org.profamilia.hc.model.dto.Chantecegene;
import org.profamilia.hc.model.dto.Chantegineco;
import org.profamilia.hc.model.dto.Chantfami;
import org.profamilia.hc.model.dto.Chantfarma;
import org.profamilia.hc.model.dto.Chantit;
import org.profamilia.hc.model.dto.Chantox;
import org.profamilia.hc.model.dto.Chantpatol;
import org.profamilia.hc.model.dto.Chantquir;
import org.profamilia.hc.model.dto.Chanttrans;
import org.profamilia.hc.model.dto.Chanttrauma;
import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chautordescr;
import org.profamilia.hc.model.dto.Chautorepicr;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.Chcierreanest;
import org.profamilia.hc.model.dto.Chcirdetdesc;
import org.profamilia.hc.model.dto.Chciruganula;

import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconsulta;
import org.profamilia.hc.model.dto.Chconsultori;
import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chcontrmedic;
import org.profamilia.hc.model.dto.Chcontroliqu;
import org.profamilia.hc.model.dto.Chcontroorden;
import org.profamilia.hc.model.dto.Chcuestpamec;
import org.profamilia.hc.model.dto.Chdescrquiru;
import org.profamilia.hc.model.dto.Chdetacirpro;
import org.profamilia.hc.model.dto.Chdetaldescr;
import org.profamilia.hc.model.dto.Chepicrisi;
import org.profamilia.hc.model.dto.Chescvalcai;
import org.profamilia.hc.model.dto.Chevolucion;
import org.profamilia.hc.model.dto.Chexamfisico;
import org.profamilia.hc.model.dto.Chformulaesp;
import org.profamilia.hc.model.dto.Chformulahos;
import org.profamilia.hc.model.dto.Chformulaliq;
import org.profamilia.hc.model.dto.Chformulamed;

import org.profamilia.hc.model.dto.Chhallahistero;
import org.profamilia.hc.model.dto.Chhisteroscopia;
import org.profamilia.hc.model.dto.Chimprdiag;
import org.profamilia.hc.model.dto.Chincapacida;
import org.profamilia.hc.model.dto.Chingresoenf;
import org.profamilia.hc.model.dto.Chinstrument;
import org.profamilia.hc.model.dto.Chitemmater;
import org.profamilia.hc.model.dto.Chitempaque;
import org.profamilia.hc.model.dto.Chitemvrquir;
import org.profamilia.hc.model.dto.Chmaterinstr;
import org.profamilia.hc.model.dto.Chmotivocon;
import org.profamilia.hc.model.dto.Chnotaenferm;
import org.profamilia.hc.model.dto.Chotraorden;
import org.profamilia.hc.model.dto.Chpamecindic;
import org.profamilia.hc.model.dto.Chpamecpregu;
import org.profamilia.hc.model.dto.Chpamectema;
import org.profamilia.hc.model.dto.Chpaqueester;
import org.profamilia.hc.model.dto.Chparavrqui;
import org.profamilia.hc.model.dto.Chpermitema;
import org.profamilia.hc.model.dto.Chrefepaci;
import org.profamilia.hc.model.dto.Chregicirpro;
import org.profamilia.hc.model.dto.Chregiconpro;
import org.profamilia.hc.model.dto.Chrevissiste;
import org.profamilia.hc.model.dto.Chsalaxprofe;
import org.profamilia.hc.model.dto.Chsegutelefo;
import org.profamilia.hc.model.dto.Chsignovital;
import org.profamilia.hc.model.dto.Chusuario;
import org.profamilia.hc.model.dto.Chvademecum;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Chverquirofa;
import org.profamilia.hc.model.dto.Cnconsclin;
import org.profamilia.hc.model.dto.Cpprofesio;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Cptipodocu;
import org.profamilia.hc.model.dto.Cpusuario;
import org.profamilia.hc.model.dto.Crcausaext;
import org.profamilia.hc.model.dto.Crfinalcon;
import org.profamilia.hc.model.exceptions.ModelException;

 
public interface CirugiaDao {


    /**
     * @param tema
     * @throws ModelException
     */
    public void saveTema(Chpamectema tema) throws ModelException;

    /**
     * @param 
     * @return
     * @throws ModelException
     */
    public List<Chpamectema> getListaTemasPamec() throws ModelException;

    /**
     * @param tema
     * @throws ModelException
     */
    public void deleteTemaPamec(Chpamectema tema) throws ModelException;

    /**
     * @param tema
     * @throws ModelException
     */
    public void updateTemaPamec(Chpamectema tema) throws ModelException;


    /**
     * @param indicador
     * @throws ModelException
     */
    public void saveIndicador(Chpamecindic indicador) throws ModelException;

    /**
     * @param codigtema
     * @return
     * @throws ModelException
     */
    public List<Chpamecindic> getListaIndicadorPamec(Integer codigtema) throws ModelException;

    /**
     * @param indicador
     * @throws ModelException
     */
    public void deleteIndicadorPamec(Chpamecindic indicador) throws ModelException;

    /**
     * @param indicador
     * @throws ModelException
     */
    public void updateIndicadorPamec(Chpamecindic indicador) throws ModelException;


    /**
     * @param pregunta
     * @throws ModelException
     */
    public void savePregunta(Chpamecpregu pregunta) throws ModelException;

    /**
     * @param codigtema
     * @param codigindi
     * @return
     * @throws ModelException
     */
    public List<Chpamecpregu> getListaPreguntaPamec(Integer codigtema, 
                                                    Integer codigindi) throws ModelException;

    /**
     * @param pregunta
     * @throws ModelException
     */
    public void deletePreguntaPamec(Chpamecpregu pregunta) throws ModelException;

    /**
     * @param pregunta
     * @throws ModelException
     */
    public void updatePreguntaPamec(Chpamecpregu pregunta) throws ModelException;

    /**
     * @param wcodclin
     * @param wanno
     * @param wcodtema
     * @param wcodind
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioPreguntaPamec(Integer wcodclin, 
                                                       Integer wanno, 
                                                       Integer wcodtema, 
                                                       Integer wcodind) throws ModelException;

    /**
     * @param lstPregunta
     * @throws ModelException
     */
    public void saveCuestionario(List<Chcuestpamec> lstPregunta) throws ModelException;

    /**
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioTemasPamec(String wusuario, 
                                                    Integer wclinica) throws ModelException;

    /**
     * @param codigtema
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioIndicadorPamec(Integer codigtema) throws ModelException;

    /**
     * @param wcoditema
     * @param wanno
     * @param wmes
     * @param wcodclin
     * @return
     * @throws ModelException
     */
    public boolean verificarTema(Integer wcoditema, Integer wanno, 
                                 Integer wmes, 
                                 Integer wcodclin) throws ModelException;

    /**
     * @param wcoditema
     * @param wcodigindic
     * @param wanno
     * @param wmes
     * @param wcodclin
     * @return
     * @throws ModelException
     */
    public boolean verificarIndicador(final Integer wcoditema, 
                                      final Integer wcodigindic, 
                                      final Integer wanno, final Integer wmes, 
                                      final Integer wcodclin) throws ModelException;


    /**
     * @param wcodclin
     * @param wcodigoTema
     * @param wanno
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReportePamec(Integer wcodclin, 
                                          Integer wcodigoTema, 
                                          Integer wanno) throws ModelException;

    /**
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaUsuariosPorClinica(Integer codClinica) throws ModelException;

    /**
     * @param tema
     * @throws ModelException
     */
    public void savePermisoTemaPamec(Chpermitema tema) throws ModelException;

    /**
     * @param codigtema
     * @param codclinica
     * @param usuario
     * @return
     * @throws ModelException
     */
    public Chpermitema getPermisoTemaPamec(Integer codigtema, 
                                           Integer codclinica, 
                                           String usuario) throws ModelException;

    /**
     * @param codigtema
     * @param codclinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaPermisoTemaPamec(Integer codigtema, 
                                                   Integer codclinica) throws ModelException;

    /**
     * @param tema
     * @throws ModelException
     */
    public void deletePermisoTemaPamec(Chpermitema tema) throws ModelException;


    /**
     * @param idTipoDocumento
     * @param numeroDocumento
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getConsultasCirugia(final Integer idTipoDocumento, 
                                                final BigDecimal numeroDocumento, 
                                                final Chusuario usuario) throws ModelException;


    /**
     * @param tipoConsultorio
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Chconsultori> getConsultoriosXClinica(Integer tipoConsultorio, 
                                                      Integer clinica) throws ModelException;


    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
    public List<Cpprofesio> getListaMedicosClinica(Integer codclin) throws ModelException;


    /**
     * @param clinica
     * @param sala
     * @param fecha
     * @param duracion
     * @return
     * @throws ModelException
     */
    public boolean verificarDisponibilidadSala(Integer clinica, Integer sala, 
                                               Date fecha, Integer duracion, 
                                               Long numeroCirugia) throws ModelException;

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public boolean verificarProgramacionCirugia(Long numeroCirugia) throws ModelException;


    /**
     * @param programar
     * @throws ModelException
     */
    public void saveProgramarCirugia(Chcirugprogr programar, 
                                     List<Cnconsclin> lstConsclin, 
                                     String userName, 
                                     Chusuario usuario) throws ModelException;


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasModificarProgramadas(final Chusuario usuario) throws ModelException;


    /**
     * @param descripcion
     * @throws ModelException
     */
    public void saveDescripcionQuirurgica(Chdescrquiru descripcion, 
                                          Chdetaldescr detalleDescripcion, 
                                          List<Chdetacirpro> lstDetalleCirugias, 
                                          List<Cpservicio> lstCirugias,
                                          String userName,
                                          String etapaCirugia, Long numeroConsulta) throws ModelException;


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chdescrquiru getDescripcionQuirurgica(Long numeroConsulta) throws ModelException;


    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
     public List<Chcirugprogr> getCirugiasProgramadasDescripcionQuirurgica(final Integer codclin, 
                                                                           final Date fechaHoy, 
                                                                           boolean registro, final BigDecimal wcodmed, final String wetapa) throws ModelException ;
    
    
    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasProgramadasDescripcionQuirurgicaAnteriores(final Integer codclin, final Date fechaHoy, boolean registro) throws ModelException;

    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasProgramadasInstrumentador(final Integer codclin) throws ModelException;


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chingresoenf> getPacientesIngresados(final Chusuario usuario) throws ModelException;

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chingresoenf> getPacientesIngresadosMedico(final Chusuario usuario) throws ModelException;


    /**
     * @param numeroCirugia
     * @param codClinica
     * @param userName
     * @throws ModelException
     */
    public void saveConductaDarAltaEnfermeria(Long numeroCirugia, 
                                              Integer codClinica, 
                                              String userName, 
                                              Chconducta conducta, 
                                              Date fechaSalida, List lstCirugias) throws ModelException;


    /**
     * @param numeroCirugia
     * @param codClinica
     * @throws ModelException
     */
    public void closeAnestesia(final Long numeroCirugia, 
                                              final Integer codClinica, final Chcierreanest cierreanestesia) throws ModelException; 


    /**
     * @param numeroCirugia
     * @param codClinica
     * @param userName
     * @param conducta
     * @throws ModelException
     */
    public void saveConductaDarAltaMedico(final Long numeroCirugia, 
                                          final Integer codClinica, 
                                          final String userName, 
                                          final Chconducta conducta, 
                                          final Date fechaSalida) throws ModelException;


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @throws ModelException
     */
    public void saveListFormulaMedicaEspecial(List<Chformulaesp> lstFormula, 
                                              Long numeroCirugia, 
                                              String tipoServicio) throws ModelException;


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaMedicaCirugia(List<Chformulamed> lstFormula, 
                                             Long numeroCirugia, 
                                             String tipoServicio, 
                                             Integer consecutivo) throws ModelException;


    /**
     * @param lstFormula
     * @param evolucion
     * @throws ModelException
     */
    public void saveListFormulaMedicaCirugia(List<Chformulamed> lstFormula, 
                                             Chevolucion evolucion) throws ModelException;


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaMedicamentoEspecial(Chformulaesp formula) throws ModelException;


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaMedicamentoEspecialCirugia(List<Chformulaesp> lstFormula, 
                                                          Long numeroCirugia, 
                                                          String tipoServicio, 
                                                          Integer consecutivo) throws ModelException;


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaLiquidosCirugia(List<Chformulaliq> lstFormula, 
                                               Long numeroCirugia, 
                                               String tipoServicio, 
                                               Integer consecutivo, 
                                               List<Chformulaliq> lstFormulaSuspender) throws ModelException;


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @param consecutivo
     * @throws ModelException
     */
    public void saveListFormulaMedicamentosCirugia(List<Chformulahos> lstFormula, 
                                                   Long numeroCirugia, 
                                                   String tipoServicio, 
                                                   Integer consecutivo, 
                                                   List<Chformulahos> lstFormulaSuspender) throws ModelException;


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaMedicamentosCirugia(Chformulahos formula) throws ModelException;


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosCirugia(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException;
                                                            
    //public String getUnidmedi(Long consecutivo) throws ModelException;

    /**
     * @param numeroUsuario
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosConsultaExterna(Long numeroUsuario, 
                                                                    Long numeroConsulta) throws ModelException;

    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chcontrmedic> getFormulaMedicamentosCirugiaSuministrados(Long numeroConsulta) throws ModelException;


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaLiquidos(Chformulaliq formula) throws ModelException;

    /**
     * @param factura
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Ccfactvent factura) throws ModelException;

    /**
     * @param cconnumdoc
     * @param ccontipdoc
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Integer cconnumdoc, 
                                                  final Integer ccontipdoc) throws ModelException;


    /**
     * @param cirugia
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Chcirugprogr cirugia) throws ModelException;


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Ccfactvent> getFacturasCirugia(Chusuario usuario) throws ModelException;


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chusuario> getUsuarioCirugia(Chusuario usuario) throws ModelException;


    /**
     * @param programar
     * @param lstCirugias
     * @throws ModelException
     */
    public void updateProgramarCirugia(final Chcirugprogr programar, 
                                       final List<Chdetacirpro> lstCirugias) throws ModelException;

    /**
     * @param programar
     * @throws ModelException
     */
     public void updateChcirugprogr(final Chcirugprogr programar, final Chregicirpro regicipro, final Chciruganula ciruanula)throws ModelException;




    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaDescripcionQuirurgicaByUsuario(Long usuario) throws ModelException;
    
    
    /**
     * @param usuario
     * @return
     * @throws ModelException
     */    
 /*   public List<Chdetacirpro> getListaDescripcionQuirurgicaByUsuarioo(Long usuario) throws ModelException ;*/
    
    
    
    

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaDescripcionQuirurgicaByAclaracion(Long usuario) throws ModelException;


    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionDescripcion(final Chautordescr autoriza) throws ModelException;


    /**
     * @param autorizacion
     * @return
     * @throws ModelException
     */
    public Chautordescr getAutorizacionDescripcion(final Chautordescr autorizacion) throws ModelException;

    /**
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Chautordescr> getSolicitudesPorAprobar(Integer codClinica) throws ModelException;


    /**
     * @param autoriza
     * @throws ModelException
     */
    public void aprobarAutorizacionDescripcion(final Chautordescr autoriza, 
                                               final String userName) throws ModelException;


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chepicrisi> getLstEpicrisisByUser(Long usuario) throws ModelException;


    /**
     * @param epicrisis
     * @throws ModelException
     */
    public void saveEpicrisis(Chepicrisi epicrisis) throws ModelException;

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chepicrisi> getListaEpicrisisByAclaracion(Long usuario) throws ModelException;

    /**
     * @param autorizacion
     * @return
     * @throws ModelException
     */
    public Chautorepicr getAutorizacionEpicrisis(final Chautorepicr autorizacion) throws ModelException;

    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionEpicrisis(final Chautorepicr autoriza) throws ModelException;


    /**
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Chautorepicr> getEpicrisisPorAprobar(Integer codClinica) throws ModelException;


    /**
     * @param autoriza
     * @param userName
     * @throws ModelException
     */
    public void aprobarAutorizacionEpicrisis(final Chautorepicr autoriza, 
                                             final String userName) throws ModelException;


    /**
     * @param signos
     * @throws ModelException
     */
    public void saveSignosVitales(Chsignovital signos) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chsignovital getSignosVitales(Long numero) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chsignovital> getSignosVitalesAnestesia(Long numero) throws ModelException;


    /**
     * @param nota
     * @param signo
     * @throws ModelException
     */
    public void saveSignosNotaEnfermeria(final Chnotaenferm nota, 
                                         final Chsignovital signo) throws ModelException;
                                         
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
     public List<Chsignovital> getSignosVitalesTomados(Long numero) throws ModelException;
                                   
   

    /**
     * @param nota
     * @param signo
     * @param lstCanalizacion
     * @param lstCanalizacionSuspender
     * @throws ModelException
     */
    public void saveSignosNotaCanalizacionEnfermeria(final Chnotaenferm nota, 
                                                     final Chsignovital signo, 
                                                     final List<Chcanalivena> lstCanalizacion, 
                                                     final List<Chcanalivena> lstCanalizacionSuspender,
                                                     final Chrefepaci referenciaPaciente) throws ModelException;

    /**
     * @param nota
     * @param signo
     * @param programacion
     * @param fechaSalida
     * @throws ModelException
     */
    public void saveDarAltaEnfermeria(final Chnotaenferm nota, 
                                      final Chsignovital signo, 
                                      final Chcirugprogr programacion, 
                                      final Date fechaSalida, List lstCirugias) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chnotaenferm getNotaEnfermeriaIngreso(Long numero) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chnotaenferm> getNotasEnfermeriaIngreso(Long numero) throws ModelException;

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Integer getCamaUsuario(Long numeroCirugia) throws ModelException;

    /**
     * @param numero
     * @param userName
     * @param fechaIngreso
     */
     public void closeIngresoEnfermeria(final Long numero,
                                        final String userName, 
                                        final Date fechaIngreso, final Integer sala) throws ModelException;

    /**
     * @param numeroCirugia
     * @param userName
     * @param fechaIngreso
     * @throws ModelException
     */
    public void closeIngresoMedico(final Long numeroCirugia, 
                                   final String userName, 
                                   final Date fechaIngreso) throws ModelException;

    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public List<Chconsulta> getFoliosUsuarioCirugia(final Long numeroUsuario) throws ModelException;

    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getFolioCirugiaCompleto(final Long numeroConsulta) throws ModelException;


    /**
     * @param numero
     * @param consecutivo
     * @return
     * @throws ModelException
     */
    public List<Chcirdetdesc> getCirugiasDescripcion(Long numero, 
                                                     Integer consecutivo) throws ModelException;


    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormulados(Long numeroCirugia, 
                                                       String tipoServicio, 
                                                       Integer wllave , Integer consecutivo) throws ModelException;

    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosReporte(Long numeroCirugia, 
                                                       String tipoServicio, 
                                                       Integer wllave) throws ModelException;


    /**
     * 
     * @param numeroCirugia
     *
     * @return
     * @throws ModelException
     */
    public List<Chcontroliqu> getLstLiquidosFormuladosAnestesia(Long numeroCirugia
                                                     ) throws ModelException;



    /**
     * @param numeroUsuario
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosConsultaExterna(Long numeroUsuario, Long numeroCirugia) throws ModelException; 
    
    
    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcanalivena> getLstCanalizacion(Long numero, 
                                                 String tipoServicio, Integer consecutivo) throws ModelException;


    /**
     * @param aldrete
     * @throws ModelException
     */
    public void saveAldrete(final Chaldrete aldrete) throws ModelException;


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public String getEtapaNotaEnfermeria(Long numeroCirugia) throws ModelException;


    /**
     * @param material
     * @throws ModelException
     */
    public void saveMaterialInstrumental(final Chmaterinstr material) throws ModelException;


    /**
     * @return
     * @throws ModelException
     */
    public List<Chmaterinstr> getListaMaterialInstrumental() throws ModelException;


    /**
     * @param material
     * @throws ModelException
     */
    public void updateMaterialInstrumental(Chmaterinstr material) throws ModelException;


    /**
     * @param material
     * @throws ModelException
     */
    public void deleteMaterialInstrumental(Chmaterinstr material) throws ModelException;


    /**
     * @return
     * @throws ModelException
     */
    public List<Chpaqueester> getListaPaqueteInstrumental() throws ModelException;


    /**
     * @param paquete
     * @throws ModelException
     */
    public void updatePaqueteInstrumental(Chpaqueester paquete) throws ModelException;


    /**
     * @param paquete
     * @throws ModelException
     */
    public void deletePaqueteInstrumental(Chpaqueester paquete) throws ModelException;


    /**
     * @param paquete
     * @throws ModelException
     */
    public void savePaqueteInstrumental(final Chpaqueester paquete) throws ModelException;


    /**
     * @param estado
     * @return
     * @throws ModelException
     */
    public List<Chpaqueester> getListaPaqueteInstrumentalByEstado(String estado) throws ModelException;

    /**
     * @param estado
     * @return
     * @throws ModelException
     */
    public List<Chmaterinstr> getListaMaterialInstrumentalByEstado(String estado) throws ModelException;

    /**
     * @param instrumental
     * @param lstItemMaterial
     * @param lstItemPaquete
     * @throws ModelException
     */
    public void saveInstrumental(final Chinstrument instrumental, final List<Chitemmater> lstItemMaterial, final List<Chitempaque> lstItemPaquete) throws ModelException;

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Chinstrument getInstrumentalByCirugia(Long numeroCirugia) throws ModelException;


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitemmater> getListaItemMaterialInstrumentalByCirugia(Long numeroCirugia) throws ModelException;


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitempaque> getListaItemPaqueteInstrumentalByCirugia(Long numeroCirugia) throws ModelException;

    /**
     * @param esAnestesia
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecum(String  esAnestesia) throws ModelException;
    
    public List<Chvademprof> getVademProf(String  esAnestesia) throws ModelException;

    /**
     * 
     * @param codigo
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumCodigo(Integer codigo) throws ModelException;

    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getIniciaVademecumAnestesia() throws ModelException;

    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumAnestesia() throws ModelException;

    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumAnestesiaTotal() throws ModelException; 

   
   /**
     * 
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumTotal() throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
     public List<Chcontmedane> getControlMedicamentosAnestesia(Long numero) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
     public List<Chaldrete> getAldrete(Long numero) throws ModelException;

    /**
     * @param segtelefo
     * @throws ModelException
     */
    public Chsegutelefo saveSeguimientoTelefonico(Chsegutelefo segtelefo) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chsegutelefo> getSeguimientoTelefonico(Long numero) throws ModelException;

    /**
     * @param numeroUsuario
     * @param 
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getFoliosUsuarioSeguimientoTelefonico(final Long numeroUsuario) throws ModelException;
    
    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcanalivena> getLstVenaCanalizada(Long numero, 
                                                 String tipoServicio) throws ModelException;

    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcontroliqu> getLstLiquidosPorAdministrar(Long numero, 
                                                 String tipoServicio) throws ModelException;

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
   public List<Chregiconpro> getConsultasCirugiaSinFactura(final Chusuario usuario) throws ModelException;

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chregicirpro> getCirugiasSinFactura(final Chusuario usuario) throws ModelException;
    
    public List<Chregiconpro> getConsultasSinFactura(final Chusuario usuario) throws ModelException;

    /**
     * @param regcirpro
     * @throws ModelException
     */
    public void saveCirugiaSinFactura(Chregicirpro regcirpro, Chusuario usuario, Cpservicio servicio,
                                     Cptipodocu tipodocu, String userName) throws ModelException;

    /**
     * @param codigo
     * @return
     * @throws ModelException
     */
    public Cptipodocu getTipoDocuPorId(Integer codigo) throws ModelException;

    /**
     * @param regcirpro
     * @throws ModelException
     */
    public void confirmarCirugiaSinFactura(Chregicirpro regcirpro) throws ModelException;

    /**
     * @param regcirpro
     * @throws ModelException
     */
    public void confirmarConsultaSinFactura(final Chregiconpro regcirpro) throws ModelException;

    /**
     * @param clinica
     * @param tipoDocumento
     * @param numeroDocumento
     * @param servicio
     * @return
     * @throws ModelException
     */
    public Integer getNumeroConsultaClinicaPorDocumento(Integer clinica, Integer tipoDocumento,
                               BigDecimal numeroDocumento, String servicio) throws ModelException;

    /**
     * @param clinica
     * @param tipoDocumento
     * @param numeroDocumento
     * @param servicio
     * @return
     * @throws ModelException
     */
    public Cnconsclin getNumeroConsultaClinicaIVEPorDocumento(Integer clinica, 
                                                        Integer tipoDocumento, 
                                                        BigDecimal numeroDocumento, 
                                                        String servicio) throws ModelException ;

    /**
     * @param parametro
     * @throws ModelException
     */
    public void saveParametroVerificacionQuirofano(final Chparavrqui parametro) throws ModelException;


    /**
     * @return
     * @throws ModelException
     */
    public List<Chparavrqui> getListaParametroVerificacionQuirofano() throws ModelException;

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Chverquirofa getChverquirofa(Long numeroCirugia) throws ModelException;

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitemvrquir> getItemVerificadosQuirofano(Long numeroCirugia) throws ModelException;

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitemvrquir> getItemPorVerificarQuirofano(Long numeroCirugia, String registra, 
                             String tipoAnestesia, String etapa, String usuario) throws ModelException;

    /**
     * @param 
     * @throws ModelException
     */
    public void saveVerificacionQuirofano(Chverquirofa verquirofa, 
                                     List<Chitemvrquir> lstItemvrquir) throws ModelException;

    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosPorAdministrar(Long numero, 
                                                 String tipoServicio) throws ModelException;


    /**
     * @param codclin
     * @param especialidad
     * @return
     * @throws ModelException
     */
    public List<Cpprofesio> getListaProfesionalPorEspecialidad(Integer codclin, Integer especialidad) throws ModelException;

    /**
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Chregicirpro> getCirugiasSinFacturaPorConfirmar(final Integer clinica) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregicirpro getCirsinfacByNumero(Long numero) throws ModelException;

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregiconpro getConsultasinfacByNumero(Long numero) throws ModelException ;
    
    
    /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
     public Object[] getUltimaValoracionPreUsuario(Long numeroUsuario) throws ModelException  ;
     
     
     
     /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreExamAnesUsuario(Long numeroUsuario) throws ModelException;
     
     
     /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreAnesUsuario(Long numeroUsuario) throws ModelException;
     
     
     
    /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
     public Object[] getUltimaValoracionPreUsuarioMotivo(Long numeroUsuario) throws ModelException  ;
     
     
     
   /**
     * 
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chdetacirpro> getCirugiaDetalle(Long numero) throws ModelException;
     
     
     
     
    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreExamUsuario(Long numeroUsuario) throws ModelException ;
     
     
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public BigDecimal getMedicoProgramacion (Long numeroConsulta) throws ModelException ; 
    
    /**
     * 
     * @param username
     * @return
     * @throws ModelException
     */
     public Cpusuario getAnestesiologosAnestesia(final String username
                                                            ) throws ModelException ;
                                                            
                                                            
    
    
    
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chdetacirpro getServicioDetalle(final Long numeroConsulta
                                                           ) throws ModelException ;
    
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chcontroorden> getOtrasOrdenesPendientes(final Long numeroConsulta
                                                           ) throws ModelException ;
    
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chcontroorden> getOtrasOrdenesPendientesRealizadas(final Long numeroConsulta
                                                           ) throws ModelException ;
                                                           
    /**
     * 
     * @param numeroConsulta
     * @param numeroEvolucion
     * @return
     * @throws ModelException
     */                                                           
    public List<Chcontroorden> getOtrasOrdenesPorEvolucion(final Long numeroConsulta, final Long evolucion
                                                            ) throws ModelException;
                                                            
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chdetacirpro> getServicioDetalleLista(final Long numeroConsulta) throws ModelException;
    
    /**
     * 
     * @param codigo
     * @return
     * @throws ModelException
     */
    public List<Cpservicio> getServicioPorId(String codigo) throws ModelException;

    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crcausaext> getCausaExterna() throws ModelException ;

    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crcausaext> getCausaExternaVG() throws ModelException ;
    
    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crfinalcon> getFinalidad() throws ModelException ;

    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crfinalcon> getFinalidadVG() throws ModelException ;
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregicirpro getCirsinfacNumero(Long numero) throws ModelException;
    
    /**
     * 
     * @param sala
     * @param fecha
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getOrdenAtencion (final Integer sala, final Date fecha) throws ModelException ;
    
    
    /**
     * 
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoCirugia(final Long numero) throws ModelException ;
    

    /**
     * 
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoQuirofano(final Long numero) throws ModelException ;
    /**
     * 
     * @param numero
     * @throws ModelException
     */
    /**
     * 
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoRecuperacion(final Long numero) throws ModelException ;
    
    public List<Chciruganula> getCirugiasCanceladas(Date fechaInicial, Date fechaFinal, Integer codClinica) throws ModelException;
    
    
    
    /**
     * 
     * @param numero
     * @throws ModelException
     */
    public Chnotaenferm getNotaEnfermeriaUltima(final Long numero) throws ModelException; 
    
    
    /**
     * @param consclin
     * @return
     * @throws ModelException
     */
    public Chconducta getConducta(Cnconsclin consclin) throws ModelException;
    
    
    
    /**
     * 
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Chdetaldescr getDetalleDescripcion(final Long numeroCirugia) throws ModelException;
    
    /**
     * 
     * @param codcir
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getCirugiaPorId(final Long codcir) throws ModelException;
    
    
    /**
     * 
     * @param tipoConsultorio
     * @return
     * @throws ModelException
     */
    public Chconsultori getConsultoriosXId(Integer tipoConsultorio 
                                                      ) throws ModelException;
                                                      
    
    
    
    /**
     * 
     * @param numeroContrato
     * @return
     * @throws ModelException
     */
    public String getNombreContrato(String numeroContrato) throws ModelException;  
    
        
    
    
    
    


    /**
     * @param wcodmed
     * @param wcodcli
     * @param wsala
     * @return
     * @throws ModelException
     */
    public Chsalaxprofe getSalaXProfesional(BigDecimal wcodmed, Integer wcodcli, Integer wsala) throws ModelException ;

    /**
     * @param wcodcli
     * @param wsala
     * @return
     * @throws ModelException
     */
    public String  getNombreSalaXCodigo(Integer wcodcli, Integer wsala) throws ModelException ;

    /**
     * @param wcodmed
     * @param wcodcli
     * @return
     * @throws ModelException
     */
    public List<Chsalaxprofe> getListaSalasXProfesional(BigDecimal wcodmed, Integer wcodcli) throws ModelException;

    /**
     * @param sala
     * @throws ModelException
     */
    public void deleteSalaXProfesional(Chsalaxprofe sala) throws ModelException;

    /**
     * @param sala
     * @throws ModelException
     */
    public void saveSalaXProfesional(Chsalaxprofe sala) throws ModelException;
    
    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasPendientes(final Chusuario usuario) throws ModelException;
    
    /**
     * @param numeroConsulta
     * @param consecutivoEvolucion
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosEvolucion(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException;
    
    /**
     * @param numeroConsulta
     * @param consecutivoEvolucion
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getSuspendeMedicamentosEvolucion(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException;
                                                            
    public List<Chnotaenferm> getNotasEnfermeriaIngresoProcedimientos(Long numero) throws ModelException ;
    
    public List<Chcontroorden> getNotasEnfermeriaOxigenoSuministrado(Long numero) throws ModelException ;
    
    public List<Chconsulta> getSolicitudFoliosNotaAclaratoria(final Long numeroUsuario, 
                                                            final String userName) throws ModelException;
                                                            

        /**
         * @param autoriza
         * @throws ModelException
         */
        public void saveAutorizacionNotaAclaratoria(final Chautornota autoriza) throws ModelException;
        
    public Chautornota getAutorizacionNotaAclaratoria(final Chautornota autorizacion) throws ModelException;
    
    public List<Chautornota> getSolicitudesNotaAclaratoriaPorAprobar() throws ModelException;
    
    public void aprobarAutorizacionNotaAclratoria(final Chautornota autoriza,  final String userName) throws ModelException;

    /**
     * @param numeroCirugia
     * @param numeroMinutos
     * @throws ModelException
     */
    public void actualizarMinutosSignosVitales(final Long numeroCirugia, final long numeroMinutos) throws ModelException;
    
    public void saveOtrasOrdenesCE(final List<Chotraorden> otrasOrdenes, 
                                 final Long numeroConsulta, 
                                 final String usuario, 
                                 final List<Chotraorden> ordenesSuspender) throws ModelException;
                                                                 
                                                                 
  public List<Chotraorden> getOtrasOrdenesCE(Long numeroConsulta) throws ModelException ;
  
  public List<Chescvalcai> getEscalaValoracionCaidas(Long numero) throws ModelException ;

  public void saveEscalaValoracionCaidas(final List<Chescvalcai> escala) throws ModelException ;
  
  public List<Chcontroorden> getLstOtrasOrdenesConsultaExterna(Long numeroUsuario,Long numeroCirugia) throws ModelException ;
  
  public List<Chcontroorden> getOtrasOrdenesPendientesCE(final Long numeroConsulta,final Long numeroUsuario) throws ModelException ;
  
  public List<Chcontroorden> getOtrasOrdenesPendientesRealizadasCE(final Long numeroConsulta,final Long numeroUsuario) throws ModelException ;

  public void saveAutorizacionInformePsicologico(final Chautoinfopsic autoriza) throws ModelException ;
  
  public Chautornota getAutorizacionInformePsicologico(final Chautoinfopsic autorizacion) throws ModelException ;
  
  public List<Chconsulta> getSolicitudFoliosInformePsicologico(final Long numeroUsuario,final String userName) throws ModelException ;
  
  public List<Chautoinfopsic> getSolicitudesInformePsicologicoPorAprobar() throws ModelException ;
  
  public void aprobarAutorizacionInformePsicologico(final Chautoinfopsic autoriza) throws ModelException ;
  
  public Chautoinfopsic getSolicitudInformePsicologicoByNumero(Long numeroConsulta) throws ModelException ;

    public void getSaveHisteroscopia(Chhisteroscopia histeroscopia) throws ModelException ;
    
    public void getSaveHallazgoHisteroscopia(Chhallahistero hallazgoHis) throws ModelException ;
    
    public List<Chrefepaci> getReferenciaPaciente(Long numero) throws ModelException ;
    
    //EPICRISIS CJET
    public boolean getAplicaTipoHistoria(final String codigoServicio)throws ModelException;
    public Chmotivocon getMotivoConsultaEpicrisis(final Long numeroConsulta)throws ModelException;
    public Chantegineco getAntecedentesGinecoEpicrisis(final Long numeroConsulta)throws ModelException;
    public List<Chantecegene> getLstAntecedentesGeneralesEpicrisis(final Long numeroConsulta)throws ModelException;
    public String getAntecedentesGeneralesEpicrisis (final Long numeroConsulta)throws ModelException;
    public String getRevisionSistemasEpicrisis(final Long numeroConsulta)throws ModelException;
    public Chrevissiste getObjRevisionSistemasEpicrisis(final Long numeroConsulta)throws ModelException;
    public Chconducta getConductaEpicrisis(final Long numeroConsulta)throws ModelException;
    public Chimprdiag getDiagnosticosIngEpicrisis(final Long numeroConsulta)throws ModelException;
    public Chevolucion getEvolucionEpicrisis(final Long numeroConsuta)throws ModelException;
    public Chdetaldescr getDiagnosticosEgrEpicrisis(final Long numeroConsulta)throws ModelException;
    public Chincapacida getIncapacidadEpicrisis(final Long numeroConsulta)throws ModelException;
    public Chdetaldescr getMasDescripcionQuirByUsuario(final Long numeroUsuario,final Date fechaDescripcion)throws ModelException;
    public boolean existeEpicrisis (final Long numeroCirugia)throws ModelException;
    public Chexamfisico getExamenFisicoEpicrisis(final Long numeroConsuta)throws ModelException;
    public List<Object[]> getRegistroSegTelefonico(Long numConsulta, Integer consecutivo ) throws ModelException;
    public List<Chsegutelefo> getOneRegistroSegTelefonico(final Long numConsulta,final Integer consec) throws ModelException ;
    public Chconsulta getConsultaAntecedentesGeneralesEpicrisis(final Long numeroConsulta) throws ModelException;
   
}
