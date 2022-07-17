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
                    <t:panelTab label="Menú Control Dermatología" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlDermatologiaBean.irDatosControlDermatologia}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlDermatologiaBean.irCuestionarioCovidControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderCovid}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlDermatologiaBean.irAntecedentesGeneralesControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderControlDermatologia && menuControlDermatologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlDermatologiaBean.irAntecedentesControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderControlDermatologia && !menuControlDermatologiaBean.primeraConsulta}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuControlDermatologiaBean.irEscalaValoracionCaidasControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderEscalaCaidas}"/>
                            <h:commandLink value="ExamenFisico" action="#{menuControlDermatologiaBean.irExamenFisicoControlDermatologia}"
                                           immediate="true" rendered="#{menuControlDermatologiaBean.renderControlDermatologia}"/>
                            <h:commandLink value="Control Dermatologia" action="#{menuControlDermatologiaBean.irControlDermatologiaUsuario}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderControlDermatologia}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuControlDermatologiaBean.irServiciosAdmisionControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderServiciosAdmision}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuControlDermatologiaBean.irOrdenLiquidosControlDermatologia}"
                                           rendered="#{menuControlDermatologiaBean.renderConducta && menuControlDermatologiaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuControlDermatologiaBean.irOrdenMedicamentosControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta && menuControlDermatologiaBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuControlDermatologiaBean.irRegistrarOtrasOrdenesControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta && menuControlDermatologiaBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlDermatologiaBean.irAnatPatologicaControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlDermatologiaBean.irAplicacionRetiro}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Control Dermatologia" action="#{menuControlDermatologiaBean.irControlDermatologiaSinCostoControlDermatologia}"
                                           immediate="true" rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" action="#{menuControlDermatologiaBean.irFormulaMedicaControlDermatologia}"
                                           immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta && !menuControlDermatologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlDermatologiaBean.irVademecumMedicoControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta && menuControlDermatologiaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlDermatologiaBean.irRemHospitalizacionControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlDermatologiaBean.irIncapacidadControlDermatologia}"
                                           immediate="true" rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlDermatologiaBean.irInterConsultaControlDermatologia}"
                                           immediate="true" rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuControlDermatologiaBean.irOrdenCirugiaControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                             <h:commandLink value=" > Recomendaciones" action="#{menuControlDermatologiaBean.irRecomedacionControlDermatologia}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuControlDermatologiaBean.irReferenciaControlDermatologia}"
                                           immediate="true" rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlDermatologiaBean.irAutorizacionServicioControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlDermatologiaBean.irReservaSangreControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlDermatologiaBean.irCertMedicoControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlDermatologiaBean.irCertAsistenciaControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlDermatologiaBean.irExamElectrofisiologicoControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlDermatologiaBean.irExamImagenControlDermatologia}"
                                           immediate="true" rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlDermatologiaBean.irExamLaboratorioControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderConducta}"/>
                           
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuControlDermatologiaBean.irCerrarConsultaControlDermatologia}" immediate="true"
                                           rendered="#{menuControlDermatologiaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlDermatologiaBean.irResumenHistoriaControlDermatologia}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta" action="#{menuControlDermatologiaBean.irPausarConsultaControlDermatologia}"
                                           rendered="#{menuControlDermatologiaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>