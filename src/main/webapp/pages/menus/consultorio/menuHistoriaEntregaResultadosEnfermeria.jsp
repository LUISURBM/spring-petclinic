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
                    <t:panelTab label="Procesos de Entrega de Resultados" id="divToolsAccordionDir">
                       <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irDatosEntregaResultados}"
                                           immediate="true"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irAntecedentesGeneralesEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderControl && menuHistoriaEntregaResultadosEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irAntecedentesEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderControl && !menuHistoriaEntregaResultadosEnfermeriaBean.primeraConsulta}"/>
                            <h:commandLink value="ExamenFisico" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irExamenFisicoEntregaResultados}"
                                           immediate="true" rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderControl}"/>
                            <h:commandLink value="Control" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irEntregaResultadosUsuario}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderControl}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irOrdenLiquidosEntregaResultados}"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta && menuHistoriaEntregaResultadosEnfermeriaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irOrdenMedicamentosEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta && menuHistoriaEntregaResultadosEnfermeriaBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Control" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irControlSinCostoEntregaResultados}"
                                           immediate="true" rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irFormulaMedicaEntregaResultados}"
                                           immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta && !menuHistoriaEntregaResultadosEnfermeriaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irVademecumMedicoEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta && menuHistoriaEntregaResultadosEnfermeriaBean.renderVademecum}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irIncapacidadEntregaResultados}"
                                           immediate="true" rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irInterConsultaEntregaResultados}"
                                           immediate="true" rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irOrdenCirugiaEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irReferenciaEntregaResultados}"
                                           immediate="true" rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irAutorizacionServicioEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irCertMedicoEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irCertAsistenciaEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irExamElectrofisiologicoEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irExamImagenEntregaResultados}"
                                           immediate="true" rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irExamLaboratorioEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irRecomedacionEntregaResultados}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irCerrarConsultaEntregaResultados}" immediate="true"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irResumenHistoriaEntregaResultados}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta" action="#{menuHistoriaEntregaResultadosEnfermeriaBean.irPausarConsultaEntregaResultados}"
                                           rendered="#{menuHistoriaEntregaResultadosEnfermeriaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                 </s:accordionPanel>            
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>