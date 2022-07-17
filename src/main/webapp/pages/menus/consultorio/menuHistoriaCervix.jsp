<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
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
                    <t:panelTab label="Historia Cérvix" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaCervixBean.irDatosCervix}" immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuHistoriaCervixBean.irCuestionarioCovidCervix}" immediate="true"
                                            rendered="#{menuHistoriaCervixBean.renderCovid}"/>
                            <h:commandLink value="Cuestionario Cérvix"
                                           action="#{menuHistoriaCervixBean.irCuestionarioCervix}" immediate="true"
                                           rendered="#{menuHistoriaCervixBean.renderCuestionario}"/>
                            <h:commandLink value="Motivo de Consulta"
                                           action="#{menuHistoriaCervixBean.irMotivoCervix}" immediate="true"
                                           rendered="#{menuHistoriaCervixBean.renderMotivo}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaCervixBean.irAntecedentesGeneralesCervix}"
                                           immediate="true"
                                           rendered="#{menuHistoriaCervixBean.renderAntecedentesGenerales && menuHistoriaCervixBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaCervixBean.irAntecedentesCervix}"
                                           immediate="true"
                                           rendered="#{menuHistoriaCervixBean.renderAntecedentesGenerales && !menuHistoriaCervixBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Ginecologicos"
                                           action="#{menuHistoriaCervixBean.irAntecedentesGinecologicosCervix}"
                                           immediate="true"
                                           rendered="#{menuHistoriaCervixBean.renderAntecedentesGinecologicos}"/>
                            <h:commandLink value="Encuesta de Violencia"
                                           action="#{menuHistoriaCervixBean.irEncuestaViolenciaCervix}"
                                           immediate="true"
                                           rendered="#{menuHistoriaCervixBean.renderEncuestaViolencia}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuHistoriaCervixBean.irEscalaValoracionCaidasCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderEscalaCaidas}"/>                     
                            <h:commandLink value="Exámen Fisico"
                                           action="#{menuHistoriaCervixBean.irExamenFisicoCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderExamen}"/>
                            <h:commandLink value="Impresión Diagnostica"
                                           action="#{menuHistoriaCervixBean.irImpDiagnosticaCervix}"
                                           immediate="true"
                                           rendered="#{menuHistoriaCervixBean.renderImpresionDiagnostica}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaCervixBean.irServiciosAdmisionCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderServiciosAdmision}"/>			   
                                           
                 <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuHistoriaCervixBean.irAnatPatologicaCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuHistoriaCervixBean.irControlSinCostoCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                              <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaCervixBean.irFormulaMedicaCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta && !menuHistoriaCervixBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaCervixBean.irVademecumMedicoCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta && menuHistoriaCervixBean.renderVademecum}"/>
                                           
                        
                          
                          
                           <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuHistoriaCervixBean.irRemHospitalizacionCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad"
                                           action="#{menuHistoriaCervixBean.irIncapacidadCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta"
                                           action="#{menuHistoriaCervixBean.irInterConsultaCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaCervixBean.irOrdenCirugiaCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"  style="color:Green;"
                                           action="#{menuHistoriaCervixBean.irRecomedacionCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia"
                                           action="#{menuHistoriaCervixBean.irReferenciaCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaCervixBean.irAutorizacionServicioCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>  
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuHistoriaCervixBean.irReservaSangreCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaCervixBean.irCertMedicoCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaCervixBean.irCertAsistenciaCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaCervixBean.irExamElectrofisiologicoCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen"
                                           action="#{menuHistoriaCervixBean.irExamImagenCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaCervixBean.irExamLaboratorioCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderConducta}"/>
                              <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaCervixBean.irCerrarConsultaCervix}"
                                           immediate="true" rendered="#{menuHistoriaCervixBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                                                             
                                  <h:commandLink value="Historia Total"
                                           action="#{menuHistoriaCervixBean.irResumenHistoriaCervix}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuHistoriaCervixBean.irPausarConsultaCervix}"
                                           rendered="#{menuHistoriaCervixBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>