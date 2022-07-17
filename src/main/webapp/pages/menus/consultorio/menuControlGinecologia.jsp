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
                    <t:panelTab label="Historia Control Ginecología" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlGinecologiaBean.irDatosControlGinecologia}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlGinecologiaBean.irCuestionarioCovidControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderCovid}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlGinecologiaBean.irAntecedentesGeneralesControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderControlGinecologia && menuControlGinecologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlGinecologiaBean.irAntecedentesControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderControlGinecologia && !menuControlGinecologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuControlGinecologiaBean.irEscalaValoracionCaidasControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderEscalaCaidas}"/>
                            <h:commandLink value="Examen Fisico" action="#{menuControlGinecologiaBean.irExamenFisicoControlGinecologia}"
                                           immediate="true" rendered="#{menuControlGinecologiaBean.renderControlGinecologia}"/>
                            <h:commandLink value="Control Ginecologia" action="#{menuControlGinecologiaBean.irControlGinecologiaUsuario}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderControlGinecologia}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuControlGinecologiaBean.irServiciosAdmisionControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderServiciosAdmision}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuControlGinecologiaBean.irOrdenLiquidosControlGinecologia}"
                                           rendered="#{menuControlGinecologiaBean.renderConducta && menuControlGinecologiaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuControlGinecologiaBean.irOrdenMedicamentosControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta && menuControlGinecologiaBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuControlGinecologiaBean.irRegistrarOtrasOrdenesControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta && menuControlGinecologiaBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlGinecologiaBean.irAnatPatologicaControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlGinecologiaBean.irAplicacionRetiro}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > ControlGinecologia" action="#{menuControlGinecologiaBean.irControlSinCostoControlGinecologia}"
                                           immediate="true" rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" action="#{menuControlGinecologiaBean.irFormulaMedicaControlGinecologia}"
                                           immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta && !menuControlGinecologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlGinecologiaBean.irVademecumMedicoControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta && menuControlGinecologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlGinecologiaBean.irRemHospitalizacionControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlGinecologiaBean.irIncapacidadControlGinecologia}"
                                           immediate="true" rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlGinecologiaBean.irInterConsultaControlGinecologia}"
                                           immediate="true" rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuControlGinecologiaBean.irOrdenCirugiaControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" action="#{menuControlGinecologiaBean.irRecomedacionControlGinecologia}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuControlGinecologiaBean.irReferenciaControlGinecologia}"
                                           immediate="true" rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlGinecologiaBean.irAutorizacionServicioControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlGinecologiaBean.irReservaSangreControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlGinecologiaBean.irCertMedicoControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlGinecologiaBean.irCertAsistenciaControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlGinecologiaBean.irExamElectrofisiologicoControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlGinecologiaBean.irExamImagenControlGinecologia}"
                                           immediate="true" rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlGinecologiaBean.irExamLaboratorioControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderConducta}"/>
                            
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuControlGinecologiaBean.irCerrarConsultaControlGinecologia}" immediate="true"
                                           rendered="#{menuControlGinecologiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlGinecologiaBean.irResumenHistoriaControlGinecologia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta" action="#{menuControlGinecologiaBean.irPausarConsultaControlGinecologia}"
                                           rendered="#{menuControlGinecologiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>