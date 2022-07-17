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
                    <t:panelTab label="Historia Control Urología" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlUrologiaBean.irDatosControlUrologia}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlUrologiaBean.irCuestionarioCovidControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderCovid}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlUrologiaBean.irAntecedentesGeneralesControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderControlUrologia && menuControlUrologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlUrologiaBean.irAntecedentesControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderControlUrologia && !menuControlUrologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuControlUrologiaBean.irEscalaValoracionCaidasControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderEscalaCaidas}"/>
                            <h:commandLink value="Examen Fisico" action="#{menuControlUrologiaBean.irExamenFisicoControlUrologia}"
                                           immediate="true" rendered="#{menuControlUrologiaBean.renderControlUrologia}"/>
                            <h:commandLink value="Control Urologia" action="#{menuControlUrologiaBean.irControlUrologiaUsuario}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderControlUrologia}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuControlUrologiaBean.irServiciosAdmisionControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderServiciosAdmision}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuControlUrologiaBean.irOrdenLiquidosControlUrologia}"
                                           rendered="#{menuControlUrologiaBean.renderConducta && menuControlUrologiaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuControlUrologiaBean.irOrdenMedicamentosControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta && menuControlUrologiaBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuControlUrologiaBean.irRegistrarOtrasOrdenesControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta && menuControlUrologiaBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlUrologiaBean.irAnatPatologicaControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlUrologiaBean.irAplicacionRetiro}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > ControlUrologia" action="#{menuControlUrologiaBean.irControlSinCostoControlUrologia}"
                                           immediate="true" rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" action="#{menuControlUrologiaBean.irFormulaMedicaControlUrologia}"
                                           immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta && !menuControlUrologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlUrologiaBean.irVademecumMedicoControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta && menuControlUrologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlUrologiaBean.irRemHospitalizacionControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlUrologiaBean.irIncapacidadControlUrologia}"
                                           immediate="true" rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlUrologiaBean.irInterConsultaControlUrologia}"
                                           immediate="true" rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuControlUrologiaBean.irOrdenCirugiaControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                               <h:commandLink value=" > Recomendaciones" action="#{menuControlUrologiaBean.irRecomedacionControlUrologia}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuControlUrologiaBean.irReferenciaControlUrologia}"
                                           immediate="true" rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlUrologiaBean.irAutorizacionServicioControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlUrologiaBean.irReservaSangreControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlUrologiaBean.irCertMedicoControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlUrologiaBean.irCertAsistenciaControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlUrologiaBean.irExamElectrofisiologicoControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlUrologiaBean.irExamImagenControlUrologia}"
                                           immediate="true" rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlUrologiaBean.irExamLaboratorioControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderConducta}"/>
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuControlUrologiaBean.irCerrarConsultaControlUrologia}" immediate="true"
                                           rendered="#{menuControlUrologiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlUrologiaBean.irResumenHistoriaControlUrologia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta" action="#{menuControlUrologiaBean.irPausarConsultaControlUrologia}"
                                           rendered="#{menuControlUrologiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>