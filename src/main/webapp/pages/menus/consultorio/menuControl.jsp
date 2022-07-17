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
                    <t:panelTab label=" Historia Control(Sin costo)" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlBean.irDatosControl}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlBean.irCuestionarioCovidControl}" immediate="true"
                                           rendered="#{menuControlBean.renderCovid}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlBean.irAntecedentesGeneralesControl}" immediate="true"
                                           rendered="#{menuControlBean.renderControl && menuControlBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlBean.irAntecedentesControl}" immediate="true"
                                           rendered="#{menuControlBean.renderControl && !menuControlBean.primeraConsulta}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuControlBean.irEscalaValoracionCaidasControl}" immediate="true"
                                           rendered="#{menuControlBean.renderEscalaCaidas}"/>
                            <h:commandLink value="ExamenFisico" action="#{menuControlBean.irExamenFisicoControl}"
                                           immediate="true" rendered="#{menuControlBean.renderControl}"/>
                            <h:commandLink value="Control" action="#{menuControlBean.irControlUsuario}" immediate="true"
                                           rendered="#{menuControlBean.renderControl}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuControlBean.irServiciosAdmisionControl}" immediate="true"
                                           rendered="#{menuControlBean.renderServiciosAdmision}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuControlBean.irOrdenLiquidosControl}"
                                           rendered="#{menuControlBean.renderConducta && menuControlBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuControlBean.irOrdenMedicamentosControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta && menuControlBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuControlBean.irRegistrarOtrasOrdenesControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta && menuControlBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlBean.irAnatPatologicaControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlBean.irAplicacionRetiro}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Control" action="#{menuControlBean.irControlSinCostoControl}"
                                           immediate="true" rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" action="#{menuControlBean.irFormulaMedicaControl}"
                                           immediate="true"
                                           rendered="#{menuControlBean.renderConducta && !menuControlBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlBean.irVademecumMedicoControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta && menuControlBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlBean.irRemHospitalizacionControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlBean.irIncapacidadControl}"
                                           immediate="true" rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlBean.irInterConsultaControl}"
                                           immediate="true" rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuControlBean.irOrdenCirugiaControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                               <h:commandLink value=" > Recomendaciones" action="#{menuControlBean.irRecomedacionControl}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuControlBean.irReferenciaControl}"
                                           immediate="true" rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlBean.irAutorizacionServicioControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlBean.irReservaSangreControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlBean.irCertMedicoControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlBean.irCertAsistenciaControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlBean.irExamElectrofisiologicoControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlBean.irExamImagenControl}"
                                           immediate="true" rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlBean.irExamLaboratorioControl}" immediate="true"
                                           rendered="#{menuControlBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuControlBean.irCerrarConsultaControl}" immediate="true"
                                           rendered="#{menuControlBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlBean.irResumenHistoriaControl}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta" action="#{menuControlBean.irPausarConsultaControl}"
                                           rendered="#{menuControlBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>