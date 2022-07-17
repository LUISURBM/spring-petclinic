<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="tableToolsPsicologiaControl"
             columnClasses="barraHizq,verticalaligntop" width="100%">
    <t:div id="sideBarTabPsicologiaControl" styleClass="rollover">
        <a4j:commandLink id="sideBarTabClickPsicologiaControl" immediate="true" onclick="slideSideBar(); return false"/>
    </t:div>
    <t:div id="sideBarContentsControl">
        <!-- style="display:none;"> -->
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     rowClasses="nivelUnoBarraH,fndBarraH,nivelUnoBarraH,fndBarraHerr" width="100%">
            <t:htmlTag value="h1">
                <h:outputText value=" "/>
            </t:htmlTag>
            <t:div id="toolBarInstrumentosPsicologiaControl">
                <s:accordionPanel id="menuToolsAccordionPsicologiaControl" layout="accordion"
                                  style="border-bottom:White !important;">
                    <t:panelTab label="Historia Psicologia" id="divToolsAccordionDirPsicologiaControl">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaPsicologicaControlBean.irDatosPsicologiaControl}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaPsicologicaControlBean.irCuestionarioCovidPsicologiaControl}" immediate="true"
                                            rendered="#{menuHistoriaPsicologicaControlBean.renderCovid}"/>
                             <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaPsicologicaControlBean.irEscalaValoracionCaidasPsicologia}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaControlBean.renderEscalaCaidas}"/>   
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaPsicologicaControlBean.irMotivoPsicologiaControl}" immediate="true"
                                           rendered="#{menuHistoriaPsicologicaControlBean.renderMotivo}"/>
                            <h:commandLink value="Evaluación General"
                                           action="#{menuHistoriaPsicologicaControlBean.irEvaluacionGeneralControl}" immediate="true"
                                           rendered="#{menuHistoriaPsicologicaControlBean.renderEvaluacionGeneral}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaPsicologicaControlBean.irImpDiagnosticaPsicologiaControl}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPsicologicaControlBean.renderImpresionDiagnostica}"/>
                                           
                             <h:commandLink value="Seguimiento"
                                           action="#{menuHistoriaPsicologicaControlBean.irSeguimientoPsicologia}" immediate="true"
                                           rendered="#{menuHistoriaPsicologicaControlBean.renderSeguimiento}"/>               
                            
                            <h:commandLink value="Plan de Tratamiento"
                                           action="#{menuHistoriaPsicologicaControlBean.irPlanTratamientoControl}" immediate="true"
                                           rendered="#{menuHistoriaPsicologicaControlBean.renderPlanTratamiento}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaPsicologicaControlBean.irServiciosAdmisionPsicologicaControl}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaControlBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPsicologicaControlBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaPsicologicaControlBean.irInterConsultaPsicologiaControl}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaControlBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaPsicologicaControlBean.irRecomedacionPsicologiaControl}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaControlBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPsicologicaControlBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaPsicologicaControlBean.irCertMedicoPsicologiaControl}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaControlBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaPsicologicaControlBean.irCertAsistenciaPsicologiaControl}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaControlBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaPsicologicaControlBean.irCerrarConsultaPsicologiaControl}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPsicologicaControlBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHisControlPsico">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaPsicologicaControlBean.irResumenHistoriaPsicologiaControl}"
                                           immediate="true"/>
                                           
                            <h:commandLink value="Asesorias IVE"
                                           action="#{menuHistoriaPsicologicaControlBean.irCertificadosIlve}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuHistoriaPsicologicaControlBean.irPausarConsultaPsicologicaControl}"
                                           rendered="#{menuHistoriaPsicologicaControlBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>