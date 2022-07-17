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
                    <t:panelTab label="Historia Control (Sin Costo)" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlIlveBean.irDatosControlIlve}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlIlveBean.irCuestionarioCovidControlIlve}" immediate="true"
                                            rendered="#{menuControlIlveBean.renderCovid}"/>
                            <h:commandLink value="Control" action="#{menuControlIlveBean.irControlUsuarioIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderControl}"/>
                             <h:commandLink value="Antecedentes"
                                           action="#{menuControlIlveBean.irAntecedentesGeneralesControlIlve}"
                                           immediate="true"
                                           rendered="#{menuControlIlveBean.renderAntecedentes && menuControlIlveBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlIlveBean.irAntecedentesControlIlve}"
                                           immediate="true"
                                           rendered="#{menuControlIlveBean.renderAntecedentes || !menuControlIlveBean.primeraConsulta}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuControlIlveBean.irEscalaValoracionCaidasControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderEscalaCaidas}"/>              
                            <h:commandLink value="ExamenFisico" action="#{menuControlIlveBean.irExamenFisicoControlIlve}"
                                           immediate="true"
                                           rendered="#{menuControlIlveBean.renderExamenFisico}"/>
                            <h:commandLink value="Impresión Diagnóstica" action="#{menuControlIlveBean.irImpresionDiagnosticaControlIlve}"
                                            immediate="true"
                                            rendered="#{menuControlIlveBean.renderImpresion}"/>
                            <h:commandLink value="Identificación del Riesgo"
                                           action="#{menuControlIlveBean.irIdentificacionControlRiesgoInterrupcion}"
                                           immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value="Certificación Ive"
                                           action="#{menuControlIlveBean.irRemisionControlIlveInterrupcion}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>               
                           <h:commandLink value="Servicios Admisión"
                                           action="#{menuControlIlveBean.irServiciosAdmisionInterrupcionControl}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderServiciosAdmision}"/>				
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlIlveBean.irAnatPatologicaControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlIlveBean.irAplicacionRetiroIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuControlIlveBean.irControlSinCostoControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                          
                              <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlIlveBean.irFormulaMedicaControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta && !menuControlIlveBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlIlveBean.irVademecumMedicoControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta && menuControlIlveBean.renderVademecum}"/>
                                           
                        
                          
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlIlveBean.irRemHospitalizacionControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlIlveBean.irIncapacidadControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlIlveBean.irInterConsultaControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos" action="#{menuControlIlveBean.irOrdenCirugiaControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>
                          
                            <h:commandLink value=" > Referencia" action="#{menuControlIlveBean.irReferenciaControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlIlveBean.irAutorizacionServicioControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>     
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlIlveBean.irReservaSangreControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlIlveBean.irCertMedicoControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlIlveBean.irCertAsistenciaControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlIlveBean.irExamElectrofisiologicoControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlIlveBean.irExamImagenControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlIlveBean.irExamLaboratorioControlIlve}" immediate="true"
                                           rendered="#{menuControlIlveBean.renderConducta}"/>
                                           
                              <h:commandLink value=" > Recomendaciones" action="#{menuControlIlveBean.irRecomedacionControlIlve}"  style="color:Green;"
                                           immediate="true" rendered="#{menuControlIlveBean.renderConducta}"/>
                                           
                            <h:commandLink value="Pre - visualizar Consulta" action="#{menuControlIlveBean.irCerrarConsultaControlIlve}"
                                           immediate="true" rendered="#{menuControlIlveBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlIlveBean.irResumenHistoriaControlIlve}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuControlIlveBean.irPausarConsultaInterrupcionControl}"
                                   rendered="#{menuControlIlveBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>