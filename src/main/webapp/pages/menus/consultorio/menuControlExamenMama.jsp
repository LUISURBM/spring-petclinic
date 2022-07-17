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
                    <t:panelTab label="Menu Control Examen Mama" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlExamenMamaBean.irDatosControlExamenMama}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlExamenMamaBean.irCuestionarioCovidControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderCovid}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlExamenMamaBean.irAntecedentesGeneralesControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderControlExamenMama && menuControlExamenMamaBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlExamenMamaBean.irAntecedentesControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderControlExamenMama && !menuControlExamenMamaBean.primeraConsulta}"/>
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuControlExamenMamaBean.irEscalaValoracionCaidasControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderEscalaCaidas}"/>
                            <h:commandLink value="ExamenFisico" action="#{menuControlExamenMamaBean.irExamenFisicoControlExamenMama}"
                                           immediate="true" rendered="#{menuControlExamenMamaBean.renderControlExamenMama}"/>
                            <h:commandLink value="Control Examen Mama" action="#{menuControlExamenMamaBean.irControlExamenMamaUsuario}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderControlExamenMama}"/>
                            <h:commandLink value="Servicios Admisión"
                                           action="#{menuControlExamenMamaBean.irServiciosAdmisionControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderServiciosAdmision}"/>
                            <h:commandLink value=" > Formular Liquidos"
                                           action="#{menuControlExamenMamaBean.irOrdenLiquidosControlExamenMama}"
                                           rendered="#{menuControlExamenMamaBean.renderConducta && menuControlExamenMamaBean.renderOrdenesMedicas}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formular Médicamentos"
                                           action="#{menuControlExamenMamaBean.irOrdenMedicamentosControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta && menuControlExamenMamaBean.renderOrdenesMedicas}"/>
                            <h:commandLink value=" > Otras Ordenes"
                                           action="#{menuControlExamenMamaBean.irRegistrarOtrasOrdenesControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta && menuControlExamenMamaBean.renderOrdenesMedicas}"/>
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlExamenMamaBean.irAnatPatologicaControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlExamenMamaBean.irAplicacionRetiro}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Control Examen Mama" action="#{menuControlExamenMamaBean.irControlExamenMamaSinCostoControlExamenMama}"
                                           immediate="true" rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" action="#{menuControlExamenMamaBean.irFormulaMedicaControlExamenMama}"
                                           immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta && !menuControlExamenMamaBean.renderVademecum}"/>
                            <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlExamenMamaBean.irVademecumMedicoControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta && menuControlExamenMamaBean.renderVademecum}"/>
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlExamenMamaBean.irRemHospitalizacionControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlExamenMamaBean.irIncapacidadControlExamenMama}"
                                           immediate="true" rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlExamenMamaBean.irInterConsultaControlExamenMama}"
                                           immediate="true" rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos"
                                           action="#{menuControlExamenMamaBean.irOrdenCirugiaControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                              <h:commandLink value=" > Recomendaciones" action="#{menuControlExamenMamaBean.irRecomedacionControlExamenMama}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" action="#{menuControlExamenMamaBean.irReferenciaControlExamenMama}"
                                           immediate="true" rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlExamenMamaBean.irAutorizacionServicioControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlExamenMamaBean.irReservaSangreControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlExamenMamaBean.irCertMedicoControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlExamenMamaBean.irCertAsistenciaControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlExamenMamaBean.irExamElectrofisiologicoControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlExamenMamaBean.irExamImagenControlExamenMama}"
                                           immediate="true" rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlExamenMamaBean.irExamLaboratorioControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderConducta}"/>
                          
                            <h:commandLink value="Pre - visualizar Consulta"
                                           action="#{menuControlExamenMamaBean.irCerrarConsultaControlExamenMama}" immediate="true"
                                           rendered="#{menuControlExamenMamaBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlExamenMamaBean.irResumenHistoriaControlExamenMama}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta" action="#{menuControlExamenMamaBean.irPausarConsultaControlExamenMama}"
                                           rendered="#{menuControlExamenMamaBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>