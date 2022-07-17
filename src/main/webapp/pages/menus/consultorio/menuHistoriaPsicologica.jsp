<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" id="tableToolsPsicologia"
             columnClasses="barraHizq,verticalaligntop" width="100%">
    <t:div id="sideBarTabPsicologia" styleClass="rollover">
        <a4j:commandLink id="sideBarTabClickPsicologia" immediate="true" onclick="slideSideBar(); return false"/>
    </t:div>
    <t:div id="sideBarContents">
        <!-- style="display:none;"> -->
         
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                     rowClasses="nivelUnoBarraH,fndBarraH,nivelUnoBarraH,fndBarraHerr" width="100%">
            <t:htmlTag value="h1">
                <h:outputText value=" "/>
            </t:htmlTag>
            <t:div id="toolBarInstrumentosPsicologia">
                <s:accordionPanel id="menuToolsAccordionPsicologia" layout="accordion"
                                  style="border-bottom:White !important;">
                    <t:panelTab label="Historia Psicologia" id="divToolsAccordionDirPsicologia">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaPsicologicaBean.irDatosPsicologia}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaPsicologicaBean.irCuestionarioCovidPsicologia}" immediate="true"
                                            rendered="#{menuHistoriaPsicologicaBean.renderCovid}"/>
                             <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaPsicologicaBean.irEscalaValoracionCaidasPsicologia}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaBean.renderEscalaCaidas}"/>               
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaPsicologicaBean.irMotivoPsicologia}" immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Psicologicos"
                                           action="#{menuHistoriaPsicologicaBean.irAntecedentesPsicologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderAntecedentesGenerales}"/>
                            <h:commandLink value="Encuesta Violencia"
                                           action="#{menuHistoriaPsicologicaBean.irEncuestaViolenciaPsicologica}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderAntecedentesGenerales}"/>
                            <h:commandLink value="Evaluación General"
                                           action="#{menuHistoriaPsicologicaBean.irEvaluacionGeneral}" immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderEvaluacionGeneral}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaPsicologicaBean.irImpDiagnosticaPsicologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderImpresionDiagnostica}"/>
                            <h:commandLink value="Plan de Tratamiento"
                                           action="#{menuHistoriaPsicologicaBean.irPlanTratamiento}" immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderPlanTratamiento}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaPsicologicaBean.irServiciosAdmisionPsicologica}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Violencia Sivigila"
                                           action="#{menuHistoriaPsicologicaBean.irViolenciaSivigilaPsicologia}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaPsicologicaBean.irInterConsultaPsicologia}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaPsicologicaBean.irRecomedacionPsicologia}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Psicologia"
                                           action="#{menuHistoriaPsicologicaBean.irCertMedicoPsicologia}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaPsicologicaBean.irCertAsistenciaPsicologia}"
                                           immediate="true" rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                             <h:commandLink value=">> Referencia "
                                           action="#{menuHistoriaPsicologicaBean.irReferenciaPsicologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaPsicologicaBean.irCerrarConsultaPsicologia}"
                                           immediate="true"
                                           rendered="#{menuHistoriaPsicologicaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaPsicologicaBean.irResumenHistoriaPsicologia}"
                                           immediate="true"/>
                                           
                            <h:commandLink value="Asesorias IVE"
                                           action="#{menuHistoriaPsicologicaBean.irCertificadosIlve}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaPsicologicaBean.irPausarConsultaPsicologica}"
                                   rendered="#{menuHistoriaPsicologicaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>