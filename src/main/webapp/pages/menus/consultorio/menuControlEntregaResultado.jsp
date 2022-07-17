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
                    <t:panelTab label="Historia Control Entrega Resultado" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlEntregaResultadoBean.irDatosControl}"
                                           immediate="true"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlEntregaResultadoBean.irAntecedentesGeneralesControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderControl && menuControlEntregaResultadoBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlEntregaResultadoBean.irAntecedentesControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderControl && !menuControlEntregaResultadoBean.primeraConsulta}"/>
                            <h:commandLink value="ExamenFisico" action="#{menuControlEntregaResultadoBean.irExamenFisicoControl}"
                                           immediate="true" rendered="#{menuControlEntregaResultadoBean.renderControl}"/>
                            <h:commandLink value="Control" action="#{menuControlEntregaResultadoBean.irControlUsuario}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderControl}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuControlEntregaResultadoBean.irOrdenLiquidosControl}"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta && menuControlEntregaResultadoBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuControlEntregaResultadoBean.irOrdenMedicamentosControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta && menuControlEntregaResultadoBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" > Control" action="#{menuControlEntregaResultadoBean.irControlSinCostoControl}"
                                           immediate="true" rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" action="#{menuControlEntregaResultadoBean.irFormulaMedicaControl}"
                                           immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta && !menuControlEntregaResultadoBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlEntregaResultadoBean.irVademecumMedicoControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta && menuControlEntregaResultadoBean.renderVademecum}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlEntregaResultadoBean.irIncapacidadControl}"
                                           immediate="true" rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlEntregaResultadoBean.irInterConsultaControl}"
                                           immediate="true" rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuControlEntregaResultadoBean.irOrdenCirugiaControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuControlEntregaResultadoBean.irReferenciaControl}"
                                           immediate="true" rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlEntregaResultadoBean.irAutorizacionServicioControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlEntregaResultadoBean.irCertMedicoControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlEntregaResultadoBean.irCertAsistenciaControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlEntregaResultadoBean.irExamElectrofisiologicoControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlEntregaResultadoBean.irExamImagenControl}"
                                           immediate="true" rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlEntregaResultadoBean.irExamLaboratorioControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" action="#{menuControlEntregaResultadoBean.irRecomedacionControl}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuControlEntregaResultadoBean.irCerrarConsultaControl}" immediate="true"
                                           rendered="#{menuControlEntregaResultadoBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlEntregaResultadoBean.irResumenHistoriaControl}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta" action="#{menuControlEntregaResultadoBean.irPausarConsultaControl}"
                                           rendered="#{menuControlEntregaResultadoBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>