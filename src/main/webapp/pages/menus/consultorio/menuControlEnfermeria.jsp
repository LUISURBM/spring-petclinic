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
                    <t:panelTab label="Historia Control (Sin Costo)" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlEnfermeriaBean.irDatosControl}"
                                           immediate="true"/>
                                           <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlEnfermeriaBean.irCuestionarioCovidControlEnfermeria}" immediate="true"
                                            rendered="#{menuControlEnfermeriaBean.renderCovid}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlEnfermeriaBean.irAntecedentesGeneralesControl}"
                                           immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderControl && menuControlEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlEnfermeriaBean.irAntecedentesControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderControl && !menuControlEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="ExamenFisico"
                                           action="#{menuControlEnfermeriaBean.irExamenFisicoControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderControl}"/>
                            <h:commandLink value="Control" action="#{menuControlEnfermeriaBean.irControlUsuario}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderControl}"/>
							<h:commandLink value="Servicios AdmisiÃ³n"
                                           action="#{menuControlEnfermeriaBean.irServiciosAdmisionControlEnfermeria}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                          
                              <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlEnfermeriaBean.irFormulaMedicaControl}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderConducta && !menuControlEnfermeriaBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlEnfermeriaBean.irVademecumMedicoControl}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderConducta && menuControlEnfermeriaBean.renderVademecum}"/>
                          
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlEnfermeriaBean.irAplicacionRetiro}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones"
                                           action="#{menuControlEnfermeriaBean.irRecomedacionControl}"
                                            style="color:Green;" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                             <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlEnfermeriaBean.irAnatPatologicaControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Control" action="#{menuControlEnfermeriaBean.irControlSinCostoControl}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlEnfermeriaBean.irRemHospitalizacionControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlEnfermeriaBean.irIncapacidadControl}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlEnfermeriaBean.irInterConsultaControl}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuControlEnfermeriaBean.irOrdenCirugiaControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                               <h:commandLink value=" > Recomendaciones" action="#{menuControlEnfermeriaBean.irRecomedacionControl}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuControlEnfermeriaBean.irReferenciaControl}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlEnfermeriaBean.irAutorizacionServicioControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlEnfermeriaBean.irReservaSangreControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlEnfermeriaBean.irCertMedicoControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlEnfermeriaBean.irCertAsistenciaControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlEnfermeriaBean.irExamElectrofisiologicoControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlEnfermeriaBean.irExamImagenControl}"
                                           immediate="true" rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlEnfermeriaBean.irExamLaboratorioControl}" immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuControlEnfermeriaBean.irCerrarConsultaControl}"
                                           immediate="true"
                                           rendered="#{menuControlEnfermeriaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total"
                                           action="#{menuControlEnfermeriaBean.irResumenHistoriaControl}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuControlEnfermeriaBean.irPausarConsultaControlEnfermeria}"
                                   rendered="#{menuControlEnfermeriaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>