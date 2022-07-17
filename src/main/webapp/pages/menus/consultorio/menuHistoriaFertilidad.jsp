<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="tableTools"
             columnClasses="barraHizq,verticalaligntop" width="100%">
    <t:div id="sideBarTab" styleClass="rollover">
        <a4j:commandLink id="sideBarTabClick" immediate="true" onclick="slideSideBar(); return false"/>
    </t:div>
    <t:div id="sideBarContents">
        <!-- style="display:none;"> -->
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     rowClasses="nivelUnoBarraH,fndBarraH,nivelUnoBarraH,fndBarraHerr" width="100%">
            <t:htmlTag value="h1">
                <h:outputText value=" "/>
            </t:htmlTag>
            <t:div id="toolBarInstrumentos">
                <s:accordionPanel id="menuToolsAccordion" layout="accordion" style="border-bottom:White !important;">
                    <t:panelTab label="Procesos de Fertilidad " id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuFertilidadBean.irUsuarioFertilidad}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuFertilidadBean.irCuestionarioCovidFertilidad}" immediate="true"
                                            rendered="#{menuFertilidadBean.renderCovid}"/>
                             <h:commandLink value="Datos de Fertilidad"
                                           action="#{menuFertilidadBean.irDatosPareja}" immediate="true"
                                            rendered="#{menuFertilidadBean.renderDatosPareja}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuFertilidadBean.irMotivoFertilidad}" immediate="true"
                                           rendered="#{menuFertilidadBean.renderMotivo}"/>
                            <h:commandLink  value="Paraclinicos"
                                           action="#{menuFertilidadBean.irParaclinicosFertilidad}"
                                           immediate="true"
                                            rendered="#{menuFertilidadBean.renderParaclinicos}"/>
                                           
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuFertilidadBean.irAntecedentesGeneralesFertilidad}"
                                           immediate="true"
                                           rendered="#{menuFertilidadBean.renderAntecedentesGenerales && menuFertilidadBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuFertilidadBean.irAntecedentesFertilidad}"
                                           immediate="true"
                                           rendered="#{menuFertilidadBean.renderAntecedentesGenerales && !menuFertilidadBean.primeraConsulta}"/>
                               <h:commandLink value="Antecedentes Detallados"
                                           action="#{menuFertilidadBean.irAntecedentesDetalladosFertilidad}"
                                           immediate="true"
                                           rendered="#{menuFertilidadBean.renderAntecedentesDetallados}" />
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuFertilidadBean.irAntecedentesGinecologicosFertilidad}"
                                           immediate="true"
                                           rendered="#{menuFertilidadBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuFertilidadBean.irEncuestaViolenciaFertilidad}"
                                           immediate="true"
                                           rendered="#{menuFertilidadBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuFertilidadBean.irEscalaValoracionCaidasFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderEscalaCaidas}"/>               
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuFertilidadBean.irExamenFisicoFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderExamen}"/>
                           <h:commandLink value="Ecografia Fertilidad"
                                           action="#{menuFertilidadBean.irEcografiaFertilidad}" 
                                            rendered="#{menuFertilidadBean.renderDatosEcografia}"
                                           immediate="true"/>
                                           
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuFertilidadBean.irImpDiagnosticaFertilidad}"
                                           immediate="true"
                                           rendered="#{menuFertilidadBean.renderImpresionDiagnostica}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuFertilidadBean.irServiciosAdmisionFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuFertilidadBean.irAnatPatologicaFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuFertilidadBean.irControlSinCostoFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                               <h:commandLink value=" > Formula Medica"
                                           action="#{menuFertilidadBean.irFormulaMedicaFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta && !menuFertilidadBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuFertilidadBean.irVademecumMedicoFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta && menuFertilidadBean.renderVademecum}"/>
                                           
                        
                           
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuFertilidadBean.irRemHospitalizacionFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuFertilidadBean.irIncapacidadFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuFertilidadBean.irInterConsultaFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuFertilidadBean.irOrdenCirugiaFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuFertilidadBean.irRecomedacionFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuFertilidadBean.irReferenciaFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuFertilidadBean.irAutorizacionServicioFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>                   
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuFertilidadBean.irReservaSangreFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuFertilidadBean.irCertMedicoFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuFertilidadBean.irCertAsistenciaFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuFertilidadBean.irExamElectrofisiologicoFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuFertilidadBean.irExamImagenFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuFertilidadBean.irExamLaboratorioFertilidad}"
                                           immediate="true" rendered="#{menuFertilidadBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuFertilidadBean.irCerrarConsultaFertilidad}"
                                           immediate="true"
                                           rendered="#{menuFertilidadBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuFertilidadBean.irResumenHistoriaFertilidad}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuFertilidadBean.irPausarConsultaFertilidad}"
                                   rendered="#{menuFertilidadBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>