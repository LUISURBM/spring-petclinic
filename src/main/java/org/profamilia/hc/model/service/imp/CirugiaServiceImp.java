package org.profamilia.hc.model.service.imp;

import java.math.BigDecimal;

import java.util.ArrayList;
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
import org.profamilia.hc.model.dto.Chcalibcatet;
import org.profamilia.hc.model.dto.Chcanalivena;
import org.profamilia.hc.model.dto.Chcierreanest;
import org.profamilia.hc.model.dto.Chcirdetdesc;
import org.profamilia.hc.model.dto.Chciruganula;
import org.profamilia.hc.model.dto.ChciruganulaPK;
import org.profamilia.hc.model.dto.Chcirugprogr;
import org.profamilia.hc.model.dto.Chconducta;
import org.profamilia.hc.model.dto.Chconocprofa;
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
import org.profamilia.hc.model.dto.Chsexo;
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
import org.profamilia.hc.model.dao.CirugiaDao;
import org.profamilia.hc.model.service.CirugiaService;


public class CirugiaServiceImp implements CirugiaService {

    //the usuarioDAO used
    private CirugiaDao cirugiaDAO;

    public CirugiaServiceImp() {
    }

    /**
     * @param cirugiaDAO
     */
    public void setCirugiaDAO(CirugiaDao cirugiaDAO) {
        this.cirugiaDAO = cirugiaDAO;
    }

    /**
     * @return
     */
    public CirugiaDao getCirugiaDAO() {
        return cirugiaDAO;
    }


    /**
     * @param tema
     * @throws ModelException
     */
    public void saveTema(Chpamectema tema) throws ModelException {
        cirugiaDAO.saveTema(tema);
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chpamectema> getListaTemasPamec() throws ModelException {
        return cirugiaDAO.getListaTemasPamec();
    }

    /**
     * @param tema
     * @throws ModelException
     */
    public void deleteTemaPamec(Chpamectema tema) throws ModelException {
        cirugiaDAO.deleteTemaPamec(tema);
    }


    /**
     * @param tema
     * @throws ModelException
     */
    public void updateTemaPamec(Chpamectema tema) throws ModelException {
        cirugiaDAO.updateTemaPamec(tema);
    }


    /**
     * @param indicador
     * @throws ModelException
     */
    public void saveIndicador(Chpamecindic indicador) throws ModelException {
        cirugiaDAO.saveIndicador(indicador);
    }

    /**
     * @param codigtema
     * @return
     * @throws ModelException
     */
    public List<Chpamecindic> getListaIndicadorPamec(Integer codigtema) throws ModelException {
        return cirugiaDAO.getListaIndicadorPamec(codigtema);
    }

    /**
     * @param indicador
     * @throws ModelException
     */
    public void deleteIndicadorPamec(Chpamecindic indicador) throws ModelException {
        cirugiaDAO.deleteIndicadorPamec(indicador);
    }

    /**
     * @param indicador
     * @throws ModelException
     */
    public void updateIndicadorPamec(Chpamecindic indicador) throws ModelException {
        cirugiaDAO.updateIndicadorPamec(indicador);
    }

    /**
     * @param pregunta
     * @throws ModelException
     */
    public void savePregunta(Chpamecpregu pregunta) throws ModelException {
        cirugiaDAO.savePregunta(pregunta);
    }

    /**
     * @param codigtema
     * @param codigindi
     * @return
     * @throws ModelException
     */
    public List<Chpamecpregu> getListaPreguntaPamec(Integer codigtema, 
                                                    Integer codigindi) throws ModelException {
        return cirugiaDAO.getListaPreguntaPamec(codigtema, codigindi);
    }

    /**
     * @param pregunta
     * @throws ModelException
     */
    public void deletePreguntaPamec(Chpamecpregu pregunta) throws ModelException {
        cirugiaDAO.deletePreguntaPamec(pregunta);
    }

    /**
     * @param pregunta
     * @throws ModelException
     */
    public void updatePreguntaPamec(Chpamecpregu pregunta) throws ModelException {
        cirugiaDAO.updatePreguntaPamec(pregunta);
    }


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
                                                       Integer wcodind) throws ModelException {
        return cirugiaDAO.getCuestionarioPreguntaPamec(wcodclin, wanno, 
                                                       wcodtema, wcodind);
    }


    /**
     * @param lstPregunta
     * @throws ModelException
     */
    public void saveCuestionario(List<Chcuestpamec> lstPregunta) throws ModelException {
        cirugiaDAO.saveCuestionario(lstPregunta);
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioTemasPamec(String wusuario, 
                                                    Integer wclinica) throws ModelException {
        return cirugiaDAO.getCuestionarioTemasPamec(wusuario, wclinica);
    }

    /**
     * @param codigtema
     * @return
     * @throws ModelException
     */
    public List<Object[]> getCuestionarioIndicadorPamec(Integer codigtema) throws ModelException {
        return cirugiaDAO.getCuestionarioIndicadorPamec(codigtema);
    }


    /**
     * @param wcoditema
     * @param wanno
     * @param wmes
     * @return
     * @throws ModelException
     */
    public boolean verificarTema(Integer wcoditema, Integer wanno, 
                                 Integer wmes, 
                                 Integer wcodclin) throws ModelException {
        return cirugiaDAO.verificarTema(wcoditema, wanno, wmes, wcodclin);
    }

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
                                      final Integer wcodclin) throws ModelException {
        return cirugiaDAO.verificarIndicador(wcoditema, wcodigindic, wanno, 
                                             wmes, wcodclin);
    }


    /**
     * @param wcodclin
     * @param wcodigoTema
     * @param wanno
     * @return
     * @throws ModelException
     */
    public List<Object[]> getReportePamec(Integer wcodclin, 
                                          Integer wcodigoTema, 
                                          Integer wanno) throws ModelException {
        return cirugiaDAO.getReportePamec(wcodclin, wcodigoTema, wanno);
    }

    /**
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaUsuariosPorClinica(Integer codClinica) throws ModelException {
        return cirugiaDAO.getListaUsuariosPorClinica(codClinica);
    }


    /**
     * @param tema
     * @throws ModelException
     */
    public void savePermisoTemaPamec(Chpermitema tema) throws ModelException {
        cirugiaDAO.savePermisoTemaPamec(tema);
    }


    /**
     * @param codigtema
     * @param codclinica
     * @param usuario
     * @return
     * @throws ModelException
     */
    public Chpermitema getPermisoTemaPamec(Integer codigtema, 
                                           Integer codclinica, 
                                           String usuario) throws ModelException {
        return cirugiaDAO.getPermisoTemaPamec(codigtema, codclinica, usuario);
    }

    /**
     * @param codigtema
     * @param codclinica
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaPermisoTemaPamec(Integer codigtema, 
                                                   Integer codclinica) throws ModelException {
        return cirugiaDAO.getListaPermisoTemaPamec(codigtema, codclinica);
    }


    /**
     * @param tema
     * @throws ModelException
     */
    public void deletePermisoTemaPamec(Chpermitema tema) throws ModelException {
        cirugiaDAO.deletePermisoTemaPamec(tema);
    }


    /**
     * @param programar
     * @throws ModelException
     */
    public void saveProgramarCirugia(Chcirugprogr programar, 
                                     List<Cnconsclin> lstConsclin, 
                                     String userName, 
                                     Chusuario usuario) throws ModelException {
        cirugiaDAO.saveProgramarCirugia(programar, lstConsclin, userName, 
                                        usuario);
    }


    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
    public List<Cpprofesio> getListaMedicosClinica(Integer codclin) throws ModelException {
        return cirugiaDAO.getListaMedicosClinica(codclin);
    }


    /**
     * @param tipoConsultorio
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Chconsultori> getConsultoriosXClinica(Integer tipoConsultorio, 
                                                      Integer clinica) throws ModelException {
        return cirugiaDAO.getConsultoriosXClinica(tipoConsultorio, clinica);
    }


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
                                               Long numeroCirugia) throws ModelException {
        return cirugiaDAO.verificarDisponibilidadSala(clinica, sala, fecha, 
                                                      duracion, numeroCirugia);

    }
    
    public boolean verificarProgramacionCirugia(Long numeroCirugia) throws ModelException{
        return cirugiaDAO.verificarProgramacionCirugia(numeroCirugia);
    }


    /**
     * @param idTipoDocumento
     * @param numeroDocumento
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getConsultasCirugia(final Integer idTipoDocumento, 
                                                final BigDecimal numeroDocumento, 
                                                final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getConsultasCirugia(idTipoDocumento, numeroDocumento, 
                                              usuario);
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasModificarProgramadas(final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getCirugiasModificarProgramadas(usuario);
    }


    /**
     * @param descripcion
     * @throws ModelException
     */
    public void saveDescripcionQuirurgica(Chdescrquiru descripcion, 
                                          Chdetaldescr detalleDescripcion, 
                                          List<Chdetacirpro> lstDetalleCirugias,
                                          List<Cpservicio> lstCirugias,
                                          String userName,
                                          String etapaCirugia,Long numeroConsulta) throws ModelException {
        cirugiaDAO.saveDescripcionQuirurgica(descripcion, detalleDescripcion, 
                                             lstDetalleCirugias, lstCirugias, userName,etapaCirugia, numeroConsulta);
    }


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chdescrquiru getDescripcionQuirurgica(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getDescripcionQuirurgica(numeroConsulta);
    }


    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
     public List<Chcirugprogr> getCirugiasProgramadasDescripcionQuirurgica(final Integer codclin, 
                                                                           final Date fechaHoy, 
                                                                           boolean registro, final BigDecimal wcodmed,final String wetapa) throws ModelException {
        return cirugiaDAO.getCirugiasProgramadasDescripcionQuirurgica(codclin, fechaHoy, registro, wcodmed,wetapa);
    }
    
    
    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasProgramadasDescripcionQuirurgicaAnteriores(final Integer codclin, final Date fechaHoy, final boolean registro) throws ModelException {
        return cirugiaDAO.getCirugiasProgramadasDescripcionQuirurgicaAnteriores(codclin, fechaHoy, registro);
    }


    /**
     * @param codclin
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasProgramadasInstrumentador(final Integer codclin) throws ModelException {
        return cirugiaDAO.getCirugiasProgramadasInstrumentador(codclin);
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chingresoenf> getPacientesIngresados(final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getPacientesIngresados(usuario);
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chingresoenf> getPacientesIngresadosMedico(final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getPacientesIngresadosMedico(usuario);
    }


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
                                              Date fechaSalida, List lstCirugias) throws ModelException {
        cirugiaDAO.saveConductaDarAltaEnfermeria(numeroCirugia, codClinica, 
                                                 userName, conducta, 
                                                 fechaSalida,lstCirugias);
    }


    /**
     * @param numeroCirugia
     * @param codClinica
     * @throws ModelException
     */
    public void closeAnestesia(final Long numeroCirugia, 
                                              final Integer codClinica, final Chcierreanest cierreanestesia) throws ModelException{
              cirugiaDAO.closeAnestesia(numeroCirugia, codClinica, cierreanestesia);                                    
         }


    /**
     * @param numeroCirugia
     * @param codClinica
     * @param userName
     * @param conducta
     * @throws ModelException
     */
    public void saveConductaDarAltaMedico(Long numeroCirugia, 
                                          Integer codClinica, String userName, 
                                          Chconducta conducta, 
                                          Date fechaSalida) throws ModelException {
        cirugiaDAO.saveConductaDarAltaMedico(numeroCirugia, codClinica, 
                                             userName, conducta, fechaSalida);
    }


    /**
     * @param lstFormula
     * @param numeroCirugia
     * @param tipoServicio
     * @throws ModelException
     */
    public void saveListFormulaMedicaEspecial(List<Chformulaesp> lstFormula, 
                                              Long numeroCirugia, 
                                              String tipoServicio) throws ModelException {
        cirugiaDAO.saveListFormulaMedicaEspecial(lstFormula, numeroCirugia, 
                                                 tipoServicio);
    }


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
                                             Integer consecutivo) throws ModelException {
        cirugiaDAO.saveListFormulaMedicaCirugia(lstFormula, numeroCirugia, 
                                                tipoServicio, consecutivo);
    }


    /**
     * @param lstFormula
     * @param evolucion
     * @throws ModelException
     */
    public void saveListFormulaMedicaCirugia(List<Chformulamed> lstFormula, 
                                             Chevolucion evolucion) throws ModelException {
        cirugiaDAO.saveListFormulaMedicaCirugia(lstFormula, evolucion);
    }


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaMedicamentoEspecial(Chformulaesp formula) throws ModelException {
        cirugiaDAO.saveFormulaMedicamentoEspecial(formula);
    }


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
                                                          Integer consecutivo) throws ModelException {
        cirugiaDAO.saveListFormulaMedicamentoEspecialCirugia(lstFormula, 
                                                             numeroCirugia, 
                                                             tipoServicio, 
                                                             consecutivo);
    }


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
                                               List<Chformulaliq> lstFormulaSuspender) throws ModelException {

        cirugiaDAO.saveListFormulaLiquidosCirugia(lstFormula, numeroCirugia, 
                                                  tipoServicio, consecutivo, 
                                                  lstFormulaSuspender);
    }


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
                                                   List<Chformulahos> lstFormulaSuspender) throws ModelException {

        cirugiaDAO.saveListFormulaMedicamentosCirugia(lstFormula, 
                                                      numeroCirugia, 
                                                      tipoServicio, 
                                                      consecutivo, 
                                                      lstFormulaSuspender);
    }


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaMedicamentosCirugia(Chformulahos formula) throws ModelException {
        cirugiaDAO.saveFormulaMedicamentosCirugia(formula);
    }


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosCirugia(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException {
        return cirugiaDAO.getFormulaMedicamentosCirugia(numeroConsulta, 
                                                        consecutivo);
    }
    
    /*public String getUnidmedi(Long consecutivo) throws ModelException{
        return cirugiaDAO.getUnidmedi(consecutivo);
    }*/

    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chcontrmedic> getFormulaMedicamentosCirugiaSuministrados(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getFormulaMedicamentosCirugiaSuministrados(numeroConsulta);
    }

    /**
     * @param numeroUsuario
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosConsultaExterna(Long numeroUsuario, 
                                                                    Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getFormulaMedicamentosConsultaExterna(numeroUsuario, 
                                                                numeroConsulta);
    }


    /**
     * @param formula
     * @throws ModelException
     */
    public void saveFormulaLiquidos(Chformulaliq formula) throws ModelException {
        cirugiaDAO.saveFormulaLiquidos(formula);
    }

    /**
     * @param factura
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Ccfactvent factura) throws ModelException {
        return cirugiaDAO.getCirugiasPorFactura(factura);
    }


    /**
     * @param cconnumdoc
     * @param ccontipdoc
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Integer cconnumdoc, 
                                                  final Integer ccontipdoc) throws ModelException {
        return cirugiaDAO.getCirugiasPorFactura(cconnumdoc, ccontipdoc);
    }


    /**
     * @param cirugia
     * @return
     * @throws ModelException
     */
    public List<Cnconsclin> getCirugiasPorFactura(final Chcirugprogr cirugia) throws ModelException {
        return cirugiaDAO.getCirugiasPorFactura(cirugia);
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Ccfactvent> getFacturasCirugia(Chusuario usuario) throws ModelException {
        return cirugiaDAO.getFacturasCirugia(usuario);
    }

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chusuario> getUsuarioCirugia(Chusuario usuario) throws ModelException {
        return cirugiaDAO.getUsuarioCirugia(usuario);
    }


    /**
     * @param programar
     * @param lstCirugias
     * @throws ModelException
     */
    public void updateProgramarCirugia(final Chcirugprogr programar, 
                                       final List<Chdetacirpro> lstCirugias) throws ModelException {
        cirugiaDAO.updateProgramarCirugia(programar, lstCirugias);
    }

     public void updateChcirugprogr(final Chcirugprogr programar, final Chregicirpro regicipro, final Chciruganula ciruanula)throws ModelException {
        cirugiaDAO.updateChcirugprogr(programar,regicipro, ciruanula);
    }


    
    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaDescripcionQuirurgicaByUsuario(Long usuario) throws ModelException {
        return cirugiaDAO.getListaDescripcionQuirurgicaByUsuario(usuario);
    }
    
    
    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
 /*    public List<Chdetacirpro> getListaDescripcionQuirurgicaByUsuarioo(Long usuario) throws ModelException {
        return cirugiaDAO.getListaDescripcionQuirurgicaByUsuario(usuario);
    }*/


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Object[]> getListaDescripcionQuirurgicaByAclaracion(Long usuario) throws ModelException {
        return cirugiaDAO.getListaDescripcionQuirurgicaByAclaracion(usuario);
    }


    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionDescripcion(final Chautordescr autoriza) throws ModelException {
        cirugiaDAO.saveAutorizacionDescripcion(autoriza);
    }


    /**
     * @param autorizacion
     * @return
     * @throws ModelException
     */
    public Chautordescr getAutorizacionDescripcion(final Chautordescr autorizacion) throws ModelException {
        return cirugiaDAO.getAutorizacionDescripcion(autorizacion);
    }


    /**
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Chautordescr> getSolicitudesPorAprobar(Integer codClinica) throws ModelException {
        return cirugiaDAO.getSolicitudesPorAprobar(codClinica);
    }


    /**
     * @param autoriza
     * @throws ModelException
     */
    public void aprobarAutorizacionDescripcion(final Chautordescr autoriza, 
                                               final String userName) throws ModelException {
        cirugiaDAO.aprobarAutorizacionDescripcion(autoriza, userName);
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chepicrisi> getLstEpicrisisByUser(Long usuario) throws ModelException {
        return cirugiaDAO.getLstEpicrisisByUser(usuario);
    }

    /**
     * @param epicrisis
     * @throws ModelException
     */
    public void saveEpicrisis(Chepicrisi epicrisis) throws ModelException {
        cirugiaDAO.saveEpicrisis(epicrisis);
    }


    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chepicrisi> getListaEpicrisisByAclaracion(Long usuario) throws ModelException {
        return cirugiaDAO.getListaEpicrisisByAclaracion(usuario);
    }


    /**
     * @param autorizacion
     * @return
     * @throws ModelException
     */
    public Chautorepicr getAutorizacionEpicrisis(final Chautorepicr autorizacion) throws ModelException {
        return cirugiaDAO.getAutorizacionEpicrisis(autorizacion);
    }


    /**
     * @param autoriza
     * @throws ModelException
     */
    public void saveAutorizacionEpicrisis(final Chautorepicr autoriza) throws ModelException {
        cirugiaDAO.saveAutorizacionEpicrisis(autoriza);
    }

    /**
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Chautorepicr> getEpicrisisPorAprobar(Integer codClinica) throws ModelException {
        return cirugiaDAO.getEpicrisisPorAprobar(codClinica);
    }


    /**
     * @param autoriza
     * @param userName
     * @throws ModelException
     */
    public void aprobarAutorizacionEpicrisis(final Chautorepicr autoriza, 
                                             final String userName) throws ModelException {
        cirugiaDAO.aprobarAutorizacionEpicrisis(autoriza, userName);
    }

    /**
     * @param signos
     * @throws ModelException
     */
    public void saveSignosVitales(Chsignovital signos) throws ModelException {
        cirugiaDAO.saveSignosVitales(signos);
    }
    

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chsignovital getSignosVitales(Long numero) throws ModelException {
        return cirugiaDAO.getSignosVitales(numero);
    }
    
    
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
     public List<Chsignovital> getSignosVitalesTomados(Long numero) throws ModelException {
         return cirugiaDAO.getSignosVitalesTomados(numero);
     }
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chsignovital> getSignosVitalesAnestesia(Long numero) throws ModelException {
        return cirugiaDAO.getSignosVitalesAnestesia(numero);
    }

    /**
     * @param nota
     * @param signo
     * @throws ModelException
     */
    public void saveSignosNotaEnfermeria(Chnotaenferm nota, 
                                         Chsignovital signo) throws ModelException {
        cirugiaDAO.saveSignosNotaEnfermeria(nota, signo);
    }

    /**
     * @param nota
     * @param signo
     * @param lstCanalizacion
     * @param lstCanalizacionSuspender
     * @throws ModelException
     */
    public void saveSignosNotaCanalizacionEnfermeria(Chnotaenferm nota, 
                                                     Chsignovital signo, 
                                                     List<Chcanalivena> lstCanalizacion, 
                                                     List<Chcanalivena> lstCanalizacionSuspender,
                                                     Chrefepaci referenciaPaciente) throws ModelException {
        cirugiaDAO.saveSignosNotaCanalizacionEnfermeria(nota, signo, 
                                                        lstCanalizacion, 
                                                        lstCanalizacionSuspender,
                                                        referenciaPaciente);
    }

    /**
     * @param nota
     * @param signo
     * @param programacion
     * @param fechaSalida
     * @throws ModelException
     */
    public void saveDarAltaEnfermeria(Chnotaenferm nota, Chsignovital signo, 
                                      Chcirugprogr programacion, 
                                      Date fechaSalida, List lstCirugias) throws ModelException {
        cirugiaDAO.saveDarAltaEnfermeria(nota, signo, programacion, 
                                         fechaSalida,lstCirugias);
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chnotaenferm getNotaEnfermeriaIngreso(Long numero) throws ModelException {
        return cirugiaDAO.getNotaEnfermeriaIngreso(numero);
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chnotaenferm> getNotasEnfermeriaIngreso(Long numero) throws ModelException {
        return cirugiaDAO.getNotasEnfermeriaIngreso(numero);
    }

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Integer getCamaUsuario(Long numeroCirugia) throws ModelException {
        return cirugiaDAO.getCamaUsuario(numeroCirugia);
    }

    /**
     * @param numero
     * @param userName
     * @param fechaIngreso
     * @throws ModelException
     */
     public void closeIngresoEnfermeria(final Long numero,
                                        final String userName, 
                                        final Date fechaIngreso, final Integer sala) throws ModelException {

        cirugiaDAO.closeIngresoEnfermeria(numero, userName, fechaIngreso,sala);
    }

    /**
     * @param numeroCirugia
     * @param userName
     * @param fechaIngreso
     * @throws ModelException
     */
    public void closeIngresoMedico(Long numeroCirugia, String userName, 
                                   Date fechaIngreso) throws ModelException {
        cirugiaDAO.closeIngresoMedico(numeroCirugia, userName, fechaIngreso);
    }


    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public List<Chconsulta> getFoliosUsuarioCirugia(final Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getFoliosUsuarioCirugia(numeroUsuario);
    }


    /**
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getFolioCirugiaCompleto(final Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getFolioCirugiaCompleto(numeroConsulta);
    }


    /**
     * @param numero
     * @param consecutivo
     * @return
     * @throws ModelException
     */
    public List<Chcirdetdesc> getCirugiasDescripcion(Long numero, 
                                                     Integer consecutivo) throws ModelException {
        return cirugiaDAO.getCirugiasDescripcion(numero, consecutivo);
    }


    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormulados(Long numeroCirugia, 
                                                       String tipoServicio, 
                                                      Integer wllave , Integer consecutivo) throws ModelException {
        return cirugiaDAO.getLstLiquidosFormulados(numeroCirugia, tipoServicio, 
                                                   wllave,consecutivo);
    }

    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosReporte(Long numeroCirugia, 
                                                       String tipoServicio, 
                                                      Integer wllave) throws ModelException {
        return cirugiaDAO.getLstLiquidosFormuladosReporte(numeroCirugia, tipoServicio, 
                                                   wllave);
    }
    
    /**
     * @param numeroUsuario
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosConsultaExterna(Long numeroUsuario,
                                                                      Long numeroCirugia) throws ModelException {

        return cirugiaDAO.getLstLiquidosFormuladosConsultaExterna(numeroUsuario,
                                                                  numeroCirugia);
    }
    
    
    
    
    /**
     * 
     * @param numeroCirugia
     * 
     * @return
     * @throws ModelException
     */
    public List<Chcontroliqu> getLstLiquidosFormuladosAnestesia(Long numeroCirugia) throws ModelException{
                                                           return cirugiaDAO.getLstLiquidosFormuladosAnestesia(numeroCirugia);
                                                       }
    


    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcanalivena> getLstCanalizacion(Long numero, 
                                                 String tipoServicio, 
                                                 Integer consecutivo) throws ModelException {
        return cirugiaDAO.getLstCanalizacion(numero, tipoServicio, 
                                             consecutivo);
    }

    /**
     * @param aldrete
     * @throws ModelException
     */
    public void saveAldrete(final Chaldrete aldrete) throws ModelException {
        cirugiaDAO.saveAldrete(aldrete);
    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public String getEtapaNotaEnfermeria(Long numeroCirugia) throws ModelException {
        return cirugiaDAO.getEtapaNotaEnfermeria(numeroCirugia);
    }


    /**
     * @param material
     * @throws ModelException
     */
    public void saveMaterialInstrumental(final Chmaterinstr material) throws ModelException {
        cirugiaDAO.saveMaterialInstrumental(material);
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chmaterinstr> getListaMaterialInstrumental() throws ModelException {
        return cirugiaDAO.getListaMaterialInstrumental();
    }


    /**
     * @param material
     * @throws ModelException
     */
    public void updateMaterialInstrumental(Chmaterinstr material) throws ModelException {
        cirugiaDAO.updateMaterialInstrumental(material);
    }


    /**
     * @param material
     * @throws ModelException
     */
    public void deleteMaterialInstrumental(Chmaterinstr material) throws ModelException {
        cirugiaDAO.deleteMaterialInstrumental(material);
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chpaqueester> getListaPaqueteInstrumental() throws ModelException {
        return cirugiaDAO.getListaPaqueteInstrumental();
    }


    /**
     * @param paquete
     * @throws ModelException
     */
    public void updatePaqueteInstrumental(Chpaqueester paquete) throws ModelException {
        cirugiaDAO.updatePaqueteInstrumental(paquete);
    }


    /**
     * @param paquete
     * @throws ModelException
     */
    public void deletePaqueteInstrumental(Chpaqueester paquete) throws ModelException {
        cirugiaDAO.deletePaqueteInstrumental(paquete);
    }


    /**
     * @param paquete
     * @throws ModelException
     */
    public void savePaqueteInstrumental(final Chpaqueester paquete) throws ModelException {
        cirugiaDAO.savePaqueteInstrumental(paquete);
    }
    
    
    /**
     * @param estado
     * @return
     * @throws ModelException
     */
    public List<Chpaqueester> getListaPaqueteInstrumentalByEstado(String estado) throws ModelException{
        return cirugiaDAO.getListaPaqueteInstrumentalByEstado(estado);
    }
        
    

    /**
     * @param estado
     * @return
     * @throws ModelException
     */
    public List<Chmaterinstr> getListaMaterialInstrumentalByEstado(String estado) throws ModelException{
        return cirugiaDAO.getListaMaterialInstrumentalByEstado(estado);
    }


    /**
     * @param instrumental
     * @param lstItemMaterial
     * @param lstItemPaquete
     * @throws ModelException
     */
    public void saveInstrumental(final Chinstrument instrumental, final List<Chitemmater> lstItemMaterial, final List<Chitempaque> lstItemPaquete) throws ModelException{
        cirugiaDAO.saveInstrumental(instrumental,lstItemMaterial,lstItemPaquete);
    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Chinstrument getInstrumentalByCirugia(Long numeroCirugia) throws ModelException{
        return cirugiaDAO.getInstrumentalByCirugia(numeroCirugia);
    }


    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitemmater> getListaItemMaterialInstrumentalByCirugia(Long numeroCirugia) throws ModelException{
        return cirugiaDAO.getListaItemMaterialInstrumentalByCirugia(numeroCirugia);
    }

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitempaque> getListaItemPaqueteInstrumentalByCirugia(Long numeroCirugia) throws ModelException{
        return cirugiaDAO.getListaItemPaqueteInstrumentalByCirugia(numeroCirugia);
    }

    /**
     * @param esAnestesia
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecum(String  esAnestesia) throws ModelException{
            return cirugiaDAO.getVademecum(esAnestesia);
    }
    
    public List<Chvademprof> getVademProf(String  esAnestesia) throws ModelException{
            return cirugiaDAO.getVademProf(esAnestesia);
    }
    
    
    public List<Chvademecum> getVademecumCodigo(Integer codigo) throws ModelException{
            return cirugiaDAO.getVademecumCodigo(codigo);
    }
    


    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getIniciaVademecumAnestesia() throws ModelException{
        return cirugiaDAO.getIniciaVademecumAnestesia();
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademecum> getVademecumAnestesia() throws ModelException{
        return cirugiaDAO.getVademecumAnestesia(); 
    }
    
    
    public List<Chvademecum> getVademecumAnestesiaTotal() throws ModelException{
        return cirugiaDAO.getVademecumAnestesiaTotal();
    }
    
    
    public List<Chvademecum> getVademecumTotal() throws ModelException{
        return cirugiaDAO.getVademecumTotal();
    }
    
    
    /**
     * @return
     * @throws ModelException
     */
    public List<Chcalibcatet> getListaCalibreCateter() throws ModelException {
        List<Chcalibcatet> lstCalibreCateter;
        lstCalibreCateter = new ArrayList<Chcalibcatet>();

        Chcalibcatet calibreObject = new Chcalibcatet();
        calibreObject.setCccecodigo(14);
        calibreObject.setCccccalibre("14");
        lstCalibreCateter.add(calibreObject);

        calibreObject = new Chcalibcatet();
        calibreObject.setCccecodigo(16);
        calibreObject.setCccccalibre("16");
        lstCalibreCateter.add(calibreObject);

        calibreObject = new Chcalibcatet();
        calibreObject.setCccecodigo(18);
        calibreObject.setCccccalibre("18");
        lstCalibreCateter.add(calibreObject);
        
        
        calibreObject = new Chcalibcatet();
        calibreObject.setCccecodigo(20);
        calibreObject.setCccccalibre("20");
        lstCalibreCateter.add(calibreObject);
        
        
        calibreObject = new Chcalibcatet();
        calibreObject.setCccecodigo(22);
        calibreObject.setCccccalibre("22");
        lstCalibreCateter.add(calibreObject);
        
        calibreObject = new Chcalibcatet();
        calibreObject.setCccecodigo(24);
        calibreObject.setCccccalibre("24");
        lstCalibreCateter.add(calibreObject);
        
        calibreObject = new Chcalibcatet();
        calibreObject.setCccecodigo(26);
        calibreObject.setCccccalibre("26");
        lstCalibreCateter.add(calibreObject);
        
       


        return lstCalibreCateter;
    }
    
    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chcontmedane> getControlMedicamentosAnestesia(Long numero) throws ModelException{
        return cirugiaDAO.getControlMedicamentosAnestesia(numero);
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chaldrete> getAldrete(Long numero) throws ModelException{
        return cirugiaDAO.getAldrete(numero);
    }
    
    /**
     * @param segtelefo
     * @throws ModelException
     */
    public Chsegutelefo saveSeguimientoTelefonico(Chsegutelefo segtelefo) throws ModelException {
        return cirugiaDAO.saveSeguimientoTelefonico(segtelefo);
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chsegutelefo> getSeguimientoTelefonico(Long numero) throws ModelException {
        return cirugiaDAO.getSeguimientoTelefonico(numero);
    }


    /**
     * @param numeroUsuario
     * @param userName
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getFoliosUsuarioSeguimientoTelefonico(final Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getFoliosUsuarioSeguimientoTelefonico(numeroUsuario);
    }

    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcanalivena> getLstVenaCanalizada(Long numero, 
                                                 String tipoServicio) throws ModelException {
        return cirugiaDAO.getLstVenaCanalizada(numero, tipoServicio);
    }

    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcontroliqu> getLstLiquidosPorAdministrar(Long numero, 
                                                 String tipoServicio) throws ModelException {
        return cirugiaDAO.getLstLiquidosPorAdministrar(numero, tipoServicio);
    }

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
      public List<Chregiconpro> getConsultasCirugiaSinFactura(final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getConsultasCirugiaSinFactura(usuario);
    }

    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chregicirpro> getCirugiasSinFactura(final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getCirugiasSinFactura(usuario);
    }
    
    public List<Chregiconpro> getConsultasSinFactura(final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getConsultasSinFactura(usuario);
    }

    /**
     * @param regcirpro
     * @throws ModelException
     */
    public void saveCirugiaSinFactura(Chregicirpro regcirpro, Chusuario usuario, Cpservicio servicio,
                                     Cptipodocu tipodocu, String userName) throws ModelException {
        cirugiaDAO.saveCirugiaSinFactura(regcirpro, usuario, servicio, tipodocu, userName);
    }

    /**
     * @param codigo
     * @return
     * @throws ModelException
     */
    public Cptipodocu getTipoDocuPorId(Integer codigo) throws ModelException {
        return cirugiaDAO.getTipoDocuPorId(codigo);
    }

    /**
     * @param regcirpro
     * @throws ModelException
     */
    public void confirmarCirugiaSinFactura(Chregicirpro regcirpro) throws ModelException {
        cirugiaDAO.confirmarCirugiaSinFactura(regcirpro);
    }

    public void confirmarConsultaSinFactura(final Chregiconpro regcirpro) throws ModelException{
        cirugiaDAO.confirmarConsultaSinFactura(regcirpro);
    }

    /**
     * @param clinica
     * @param tipoDocumento
     * @param numeroDocumento
     * @param servicio
     * @return
     * @throws ModelException
     */
    public Integer getNumeroConsultaClinicaPorDocumento(Integer clinica, Integer tipoDocumento, 
                                     BigDecimal numeroDocumento, String servicio) throws ModelException {
        return cirugiaDAO.getNumeroConsultaClinicaPorDocumento(clinica, tipoDocumento, 
                                     numeroDocumento, servicio);
    }
    
    public Cnconsclin getNumeroConsultaClinicaIVEPorDocumento(Integer clinica, 
                                                        Integer tipoDocumento, 
                                                        BigDecimal numeroDocumento, 
                                                        String servicio) throws ModelException {
                                                            return cirugiaDAO.getNumeroConsultaClinicaIVEPorDocumento(clinica, tipoDocumento, 
                                                                                         numeroDocumento, servicio);                               
                                                        }

    /**
     * @param parametro
     * @throws ModelException
     */
    public void saveParametroVerificacionQuirofano(final Chparavrqui parametro) throws ModelException {
        cirugiaDAO.saveParametroVerificacionQuirofano(parametro);
    }


    /**
     * @return
     * @throws ModelException
     */
    public List<Chparavrqui> getListaParametroVerificacionQuirofano() throws ModelException {
        return cirugiaDAO.getListaParametroVerificacionQuirofano();
    }

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public Chverquirofa getChverquirofa(Long numeroCirugia) throws ModelException {
        return cirugiaDAO.getChverquirofa(numeroCirugia);
    }

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitemvrquir> getItemVerificadosQuirofano(Long numeroCirugia) throws ModelException {
        return cirugiaDAO.getItemVerificadosQuirofano(numeroCirugia);
    }

    /**
     * @param numeroCirugia
     * @return
     * @throws ModelException
     */
    public List<Chitemvrquir> getItemPorVerificarQuirofano(Long numeroCirugia, String registra, 
                           String tipoAnestesia, String etapa, String usuario) throws ModelException {
        return cirugiaDAO.getItemPorVerificarQuirofano(numeroCirugia, registra, tipoAnestesia, etapa, usuario);
    }

    /**
     * @param verquirofa
     * @param lstItemvrquir
     * @throws ModelException
     */
    public void saveVerificacionQuirofano(Chverquirofa verquirofa, 
                                     List<Chitemvrquir> lstItemvrquir) throws ModelException {
        cirugiaDAO.saveVerificacionQuirofano(verquirofa, lstItemvrquir);
    }

    /**
     * @param numero
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chformulaliq> getLstLiquidosFormuladosPorAdministrar(Long numero, 
                                                 String tipoServicio) throws ModelException {
        return cirugiaDAO.getLstLiquidosFormuladosPorAdministrar(numero, tipoServicio);
    }

    /**
     * @param codclin
     * @param especialidad
     * @return
     * @throws ModelException
     */
    public List<Cpprofesio> getListaProfesionalPorEspecialidad(Integer codclin, Integer especialidad) throws ModelException {
        return cirugiaDAO.getListaProfesionalPorEspecialidad(codclin, especialidad);
    }

    /**
     * @param clinica
     * @return
     * @throws ModelException
     */
    public List<Chregicirpro> getCirugiasSinFacturaPorConfirmar(final Integer clinica) throws ModelException {
        return cirugiaDAO.getCirugiasSinFacturaPorConfirmar(clinica);
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregicirpro getCirsinfacByNumero(Long numero) throws ModelException{
        return cirugiaDAO.getCirsinfacByNumero(numero);
    }

    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregiconpro getConsultasinfacByNumero(Long numero) throws ModelException {
        return cirugiaDAO.getConsultasinfacByNumero(numero);
    }
    
    /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
     public Object[] getUltimaValoracionPreUsuario(Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getUltimaValoracionPreUsuario(numeroUsuario);
    }
    
    /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreAnesUsuario(Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getUltimaValoracionPreAnesUsuario(numeroUsuario);
    
    }
    /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreExamAnesUsuario(Long numeroUsuario) throws ModelException{
        return cirugiaDAO.getUltimaValoracionPreExamAnesUsuario(numeroUsuario);
    }
    
    
    
    /**
     * 
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
     public Object[] getUltimaValoracionPreUsuarioMotivo(Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getUltimaValoracionPreUsuarioMotivo(numeroUsuario);
    }
    
    
    /**
     * 
     * @param numero
     * @return
     * @throws ModelException
     */
    public List<Chdetacirpro> getCirugiaDetalle(Long numero) throws ModelException{
        return cirugiaDAO.getCirugiaDetalle(numero);
    
    }
    
    
    
    /**
     * @param numeroUsuario
     * @return
     * @throws ModelException
     */
    public Object[] getUltimaValoracionPreExamUsuario(Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getUltimaValoracionPreExamUsuario(numeroUsuario);
    }
    
    
    
    /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public BigDecimal getMedicoProgramacion (Long numeroConsulta) throws ModelException{
        return cirugiaDAO.getMedicoProgramacion(numeroConsulta);
    }
    
   /**
     * 
     * @param username
     * @return
     * @throws ModelException
     */
     public Cpusuario getAnestesiologosAnestesia(final String username
                                                            ) throws ModelException {
        return cirugiaDAO.getAnestesiologosAnestesia(username);
                                                 }
                                                 
     
     
     /**
     * 
     * @param numeroConsulta
     * @return
     * @throws ModelException
     */
    public Chdetacirpro getServicioDetalle(final Long numeroConsulta
                                                           ) throws ModelException {
                                                           return cirugiaDAO.getServicioDetalle(numeroConsulta);
                                                           }
                                                           
    /**
    * 
    * @param numeroConsulta
    * @return
    * @throws ModelException
    */
    public List<Chcontroorden> getOtrasOrdenesPendientes(final Long numeroConsulta
                                                          ) throws ModelException {
                                                          return cirugiaDAO.getOtrasOrdenesPendientes(numeroConsulta);
                                                          }     
                                                          
    /**
    * 
    * @param numeroConsulta
    * @return
    * @throws ModelException
    */
    public List<Chcontroorden> getOtrasOrdenesPendientesRealizadas(final Long numeroConsulta
                                                          ) throws ModelException {
                                                          return cirugiaDAO.getOtrasOrdenesPendientesRealizadas(numeroConsulta);
                                                          }   
                                                          
                                                          
    /**
     * 
     * @param numeroConsulta
     * @param numeroEvolucion
     * @return
     * @throws ModelException
     */                                                           
    public List<Chcontroorden> getOtrasOrdenesPorEvolucion(final Long numeroConsulta, final Long evolucion
                                                            ) throws ModelException{
                                                            return cirugiaDAO.getOtrasOrdenesPorEvolucion(numeroConsulta, evolucion);
                                                            }                                                            
                                                       
    /**
    * 
    * @param numeroConsulta
    * @return
    * @throws ModelException
    */
    public List<Chdetacirpro> getServicioDetalleLista(final Long numeroConsulta
                                                          ) throws ModelException {
                                                          return cirugiaDAO.getServicioDetalleLista(numeroConsulta);
                                                          }                                                       
                                                           
   
   /**
     * 
     * @param codigo
     * @return
     * @throws ModelException
     */
    public List<Cpservicio> getServicioPorId(String codigo) throws ModelException {
                                                            return cirugiaDAO.getServicioPorId(codigo);
    }
                                                                
   
   
   
                                                 
    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crcausaext> getCausaExterna() throws ModelException {
        return cirugiaDAO.getCausaExterna();
    }

    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crcausaext> getCausaExternaVG() throws ModelException {
        return cirugiaDAO.getCausaExternaVG();
    }
    
    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crfinalcon> getFinalidad() throws ModelException {
        return cirugiaDAO.getFinalidad();
    }
    
    /**
    * 
    * @return
    * @throws ModelException
    */
    public List<Crfinalcon> getFinalidadVG() throws ModelException {
        return cirugiaDAO.getFinalidadVG();
    }

    
    /**
     * @param numero
     * @return
     * @throws ModelException
     */
    public Chregicirpro getCirsinfacNumero(Long numero) throws ModelException{
        return cirugiaDAO.getCirsinfacNumero(numero);
    }
    
    
    /**
     * 
     * @param sala
     * @param fecha
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getOrdenAtencion (final Integer sala, final Date fecha) throws ModelException {
        return cirugiaDAO.getOrdenAtencion(sala,fecha);
    }
    
    
    /**
     * 
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoCirugia(final Long numero) throws ModelException {
        cirugiaDAO.updateIngresoCirugia(numero);    
    }
    
    
    /**
     * 
     * @param numero
     * @throws ModelException
     */
    public void updateIngresoQuirofano(final Long numero) throws ModelException {
        cirugiaDAO.updateIngresoQuirofano(numero);    
    }
    
    
    
    
    public void updateIngresoRecuperacion(final Long numero) throws ModelException {
        cirugiaDAO.updateIngresoRecuperacion(numero);
    }


    /**
     * @param fechaInicial
     * @param fechaFinal
     * @param codClinica
     * @return
     * @throws ModelException
     */
    public List<Chciruganula> getCirugiasCanceladas(Date fechaInicial, Date fechaFinal, Integer codClinica) throws ModelException{
        return cirugiaDAO.getCirugiasCanceladas(fechaInicial,fechaFinal,codClinica);    
    }

    /**
     * @param codcir
     * @return
     * @throws ModelException
     */
    public Chcirugprogr getCirugiaPorId(final Long codcir) throws ModelException{
        return cirugiaDAO.getCirugiaPorId(codcir); 
    }
    
    
    /**
     * 
     * @param numero
     * @throws ModelException
     */
    public Chnotaenferm getNotaEnfermeriaUltima(final Long numero) throws ModelException{
        return cirugiaDAO.getNotaEnfermeriaUltima(numero);
    }
    
    
    /**
     * @param consclin
     * @return
     * @throws ModelException
     */
    public Chconducta getConducta(Cnconsclin consclin) throws ModelException {
        return cirugiaDAO.getConducta(consclin);
    }
    
    
    /**
     * 
     */
    public Chdetaldescr getDetalleDescripcion(final Long numeroCirugia) throws ModelException {
        return cirugiaDAO.getDetalleDescripcion(numeroCirugia);
    }
    /**
     * 
     * @param tipoConsultorio
     * @return
     * @throws ModelException
     */
    public Chconsultori getConsultoriosXId(Integer tipoConsultorio 
                                                      ) throws ModelException {
        return cirugiaDAO.getConsultoriosXId(tipoConsultorio);                                              
                                                      
                                                      
                                                      }
                                                      
                                                      
    public String getNombreContrato(String numeroContrato) throws ModelException {
    
    return cirugiaDAO.getNombreContrato(numeroContrato);
    }
    
    
    
    
        /**
         * @param wcodmed
         * @param wcodcli
         * @param wsala
         * @return
         * @throws ModelException
         */
        public Chsalaxprofe getSalaXProfesional(BigDecimal wcodmed, Integer wcodcli, Integer wsala) throws ModelException {
            return cirugiaDAO.getSalaXProfesional(wcodmed,wcodcli,wsala);
        }
        
    public String  getNombreSalaXCodigo(Integer wcodcli, Integer wsala) throws ModelException{
        return cirugiaDAO.getNombreSalaXCodigo(wcodcli,wsala);
    }

        /**
         * @param wcodmed
         * @param wcodcli
         * @return
         * @throws ModelException
         */
        public List<Chsalaxprofe> getListaSalasXProfesional(BigDecimal wcodmed, Integer wcodcli) throws ModelException{
            return cirugiaDAO.getListaSalasXProfesional(wcodmed,wcodcli);
        }

        /**
         * @param sala
         * @throws ModelException
         */
        public void deleteSalaXProfesional(Chsalaxprofe sala) throws ModelException{
            cirugiaDAO.deleteSalaXProfesional(sala);
        }

        /**
         * @param sala
         * @throws ModelException
         */
        public void saveSalaXProfesional(Chsalaxprofe sala) throws ModelException{
            cirugiaDAO.saveSalaXProfesional(sala);
        }
        
    /**
     * @param usuario
     * @return
     * @throws ModelException
     */
    public List<Chcirugprogr> getCirugiasPendientes(final Chusuario usuario) throws ModelException {
        return cirugiaDAO.getCirugiasPendientes(usuario);
    }
    
    /**
     * @param numeroConsulta
     * @param consecutivoEvolucion
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getFormulaMedicamentosEvolucion(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException {
        return cirugiaDAO.getFormulaMedicamentosEvolucion(numeroConsulta, consecutivo);
    }

    /**
     * @param numeroConsulta
     * @param consecutivoEvolucion
     * @return
     * @throws ModelException
     */
    public List<Chformulahos> getSuspendeMedicamentosEvolucion(Long numeroConsulta, 
                                                            Integer consecutivo) throws ModelException {
        return cirugiaDAO.getSuspendeMedicamentosEvolucion(numeroConsulta, consecutivo);
    }
    
    public List<Chnotaenferm> getNotasEnfermeriaIngresoProcedimientos(Long numero) throws ModelException {
        return cirugiaDAO.getNotasEnfermeriaIngresoProcedimientos(numero);
    }
    
    public List<Chcontroorden> getOxigenoSuministrados(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getNotasEnfermeriaOxigenoSuministrado(numeroConsulta);
    }
          
          
    public List<Chconsulta> getSolicitudFoliosNotaAclaratoria(final Long numeroUsuario, 
                                                            final String userName) throws ModelException{
        return cirugiaDAO.getSolicitudFoliosNotaAclaratoria(numeroUsuario,userName);                                                    

    }
    
    public void saveAutorizacionNotaAclaratoria(final Chautornota autoriza) throws ModelException{
        cirugiaDAO.saveAutorizacionNotaAclaratoria(autoriza);
    }
    
    public Chautornota getAutorizacionNotaAclaratoria(final Chautornota autorizacion) throws ModelException{
        return cirugiaDAO.getAutorizacionNotaAclaratoria(autorizacion);
    }
    
    public List<Chautornota> getSolicitudesNotaAclaratoriaPorAprobar() throws ModelException{
        return cirugiaDAO.getSolicitudesNotaAclaratoriaPorAprobar();
    }
    
    public void aprobarAutorizacionNotaAclratoria(final Chautornota autoriza,  final String userName) throws ModelException {
         cirugiaDAO.aprobarAutorizacionNotaAclratoria(autoriza,userName);
    }
    
    public void actualizarMinutosSignosVitales(final Long numeroCirugia, final long numeroMinutos) throws ModelException{
        cirugiaDAO.actualizarMinutosSignosVitales(numeroCirugia,numeroMinutos);
    }
    
    
    public void saveOtrasOrdenesCE(final List<Chotraorden> otrasOrdenes, 
                                 final Long numeroConsulta, 
                                 final String usuario, 
                                 final List<Chotraorden> ordenesSuspender) throws ModelException{
             cirugiaDAO.saveOtrasOrdenesCE(otrasOrdenes,numeroConsulta,usuario,ordenesSuspender);                        
         }
                                                                 
                                                                 
    public List<Chotraorden> getOtrasOrdenesCE(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getOtrasOrdenesCE(numeroConsulta);
    }
    
    public List<Chescvalcai> getEscalaValoracionCaidas(Long numero) throws ModelException {
            return cirugiaDAO.getEscalaValoracionCaidas(numero);
    }
    
    public void saveEscalaValoracionCaidas(final List<Chescvalcai> escala) throws ModelException {
         cirugiaDAO.saveEscalaValoracionCaidas(escala);
    
    }

    public List<Chcontroorden> getLstOtrasOrdenesConsultaExterna(Long numeroUsuario,Long numeroCirugia) throws ModelException {
        return cirugiaDAO.getLstOtrasOrdenesConsultaExterna(numeroUsuario,numeroCirugia);
    }
    
    public List<Chcontroorden> getOtrasOrdenesPendientesCE(final Long numeroConsulta,final Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getOtrasOrdenesPendientesCE(numeroConsulta,numeroUsuario);
    }
    
    public List<Chcontroorden> getOtrasOrdenesPendientesRealizadasCE(final Long numeroConsulta,final Long numeroUsuario) throws ModelException {
        return cirugiaDAO.getOtrasOrdenesPendientesRealizadasCE(numeroConsulta,numeroUsuario);
    }
    
    public void saveAutorizacionInformePsicologico(final Chautoinfopsic autoriza) throws ModelException {
             cirugiaDAO.saveAutorizacionInformePsicologico(autoriza);
    }
    
    public Chautornota getAutorizacionInformePsicologico(final Chautoinfopsic autorizacion) throws ModelException {
        return cirugiaDAO.getAutorizacionInformePsicologico(autorizacion);
    }
    public List<Chconsulta> getSolicitudFoliosInformePsicologico(final Long numeroUsuario,final String userName) throws ModelException {
        return cirugiaDAO.getSolicitudFoliosInformePsicologico(numeroUsuario,userName);
    }
    
    public List<Chautoinfopsic> getSolicitudesInformePsicologicoPorAprobar() throws ModelException {
        return cirugiaDAO.getSolicitudesInformePsicologicoPorAprobar();
    }
    
    public void aprobarAutorizacionInformePsicologico(final Chautoinfopsic autoriza) throws ModelException {
               cirugiaDAO.aprobarAutorizacionInformePsicologico(autoriza);
    }
    
    public Chautoinfopsic getSolicitudInformePsicologicoByNumero(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getSolicitudInformePsicologicoByNumero(numeroConsulta);
    }


    public void saveDescripcionQuirurgicaHisteroscopia(final Chhisteroscopia histeroscopia) throws ModelException {
         cirugiaDAO.getSaveHisteroscopia(histeroscopia);
    }
    
    public void saveDescripcionQuirurgicaHallazgoHistero(final Chhallahistero hallazgoHis) throws ModelException {
         cirugiaDAO.getSaveHallazgoHisteroscopia(hallazgoHis);
    }
    
    public List<Chrefepaci> getReferenciaPaciente(Long numero) throws ModelException {
        return cirugiaDAO.getReferenciaPaciente(numero);
    }

    public boolean getAplicaTipoHistoria(String codigoServicio) throws ModelException {
        return cirugiaDAO.getAplicaTipoHistoria(codigoServicio);
    }

    public Chmotivocon getMotivoConsultaEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getMotivoConsultaEpicrisis(numeroConsulta);
    }

    public Chantegineco getAntecedentesGinecoEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getAntecedentesGinecoEpicrisis(numeroConsulta);
    }

    public String getAntecedentesGeneralesEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getAntecedentesGeneralesEpicrisis(numeroConsulta);
    }

    public String getRevisionSistemasEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getRevisionSistemasEpicrisis(numeroConsulta);
    }

    public Chconducta getConductaEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getConductaEpicrisis(numeroConsulta);
    }

    public Chimprdiag getDiagnosticosIngEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getDiagnosticosIngEpicrisis(numeroConsulta);
    }

    public Chevolucion getEvolucionEpicrisis(Long numeroConsuta) throws ModelException {
        return cirugiaDAO.getEvolucionEpicrisis(numeroConsuta);
    }

    public Chdetaldescr getDiagnosticosEgrEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getDiagnosticosEgrEpicrisis(numeroConsulta);
    }

    public Chincapacida getIncapacidadEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getIncapacidadEpicrisis(numeroConsulta);
    }

    public Chdetaldescr getMasDescripcionQuirByUsuario(Long numeroUsuario, 
                                                  Date fechaDescripcion) throws ModelException {
        return cirugiaDAO.getMasDescripcionQuirByUsuario(numeroUsuario,fechaDescripcion);
    }

    public boolean existeEpicrisis(Long numeroCirugia) throws ModelException {
        return cirugiaDAO.existeEpicrisis(numeroCirugia);
    }

    public Chexamfisico getExamenFisicoEpicrisis(Long numeroConsulta) throws ModelException {
        return cirugiaDAO.getExamenFisicoEpicrisis(numeroConsulta);
    }
    public List<Object[]> getRegistroSegTelefonico(Long numConsulta, Integer consecutivo ) throws ModelException{
        return cirugiaDAO.getRegistroSegTelefonico(numConsulta,consecutivo);
    }
    public List<Chsegutelefo> getOneRegistroSegTelefonico(final Long numConsulta,final Integer consec) throws ModelException {
        return cirugiaDAO.getOneRegistroSegTelefonico(numConsulta,consec);
    }

}
