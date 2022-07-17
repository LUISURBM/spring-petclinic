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
                    <t:panelTab label="Historia Control Fertilidad" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" action="#{menuControlFertilidadBean.irDatosControlFertilidad}"
                                           immediate="true"/>
                            <h:commandLink value="Cuestionario Covid"
                                           action="#{menuControlFertilidadBean.irCuestionarioCovidControlFertilidad}" immediate="true"
                                            rendered="#{menuControlFertilidadBean.renderCovid}"/>
                             <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlFertilidadBean.irAntecedentesGeneralesControlFertilidad}"
                                           immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderControl && menuControlFertilidadBean.primeraConsulta}"/>
                            <h:commandLink value="Antecedentes Generales"
                                           action="#{menuControlFertilidadBean.irAntecedentesControlFertilidad}"
                                           immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderControl && !menuControlFertilidadBean.primeraConsulta}"/>
                                           
                            <h:commandLink value="Ecografia"
                                           action="#{menuControlFertilidadBean.irEcografiaControlFertilidad}"
                                           immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderControl}"/>
                            
                            <h:commandLink value="Escala Valoración Caidas"
                                           action="#{menuControlFertilidadBean.irEscalaValoracionCaidasPediatria}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderControl}"/>               
                                           
                            <h:commandLink value="ExamenFisico" action="#{menuControlFertilidadBean.irExamenFisicoControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderControl}"/>
                            <h:commandLink value="Control" action="#{menuControlFertilidadBean.irControlUsuarioFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderControl}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuControlFertilidadBean.irServiciosAdmisionControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica"
                                           action="#{menuControlFertilidadBean.irAnatPatologicaControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Aplicacion Retiro P.F."
                                           action="#{menuControlFertilidadBean.irAplicacionRetiroFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Control"
                                           action="#{menuControlFertilidadBean.irControlSinCostoControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                               <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlFertilidadBean.irFormulaMedicaControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta && !menuControlFertilidadBean.renderVademecum}"/>
                                           
                             <h:commandLink value=" > Formula Medica"
                                           action="#{menuControlFertilidadBean.irVademecumMedicoControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta && menuControlFertilidadBean.renderVademecum}"/>
                                           
                        
                            <h:commandLink value=" > Remisión Hospitalización"
                                           action="#{menuControlFertilidadBean.irRemHospitalizacionControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" action="#{menuControlFertilidadBean.irIncapacidadControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" action="#{menuControlFertilidadBean.irInterConsultaControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Cirugías y procedimientos" action="#{menuControlFertilidadBean.irOrdenCirugiaControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta}"/>
                          
                            <h:commandLink value=" > Referencia" action="#{menuControlFertilidadBean.irReferenciaControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta}"/>
                                           
                              <h:commandLink value=" > Autorización Servicios"
                                           action="#{menuControlFertilidadBean.irAutorizacionServicioControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta}"/>         
                                           
                            <h:commandLink value=" > Reserva de Sangre"
                                           action="#{menuControlFertilidadBean.irReservaSangreControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico"
                                           action="#{menuControlFertilidadBean.irCertMedicoControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia"
                                           action="#{menuControlFertilidadBean.irCertAsistenciaControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:outputText value=" > Exámenes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen ElectroFisiologicos"
                                           action="#{menuControlFertilidadBean.irExamElectrofisiologicoControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Imagen" action="#{menuControlFertilidadBean.irExamImagenControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" >> Exámen Laboratorio"
                                           action="#{menuControlFertilidadBean.irExamLaboratorioControlFertilidad}" immediate="true"
                                           rendered="#{menuControlFertilidadBean.renderConducta}"/>
                                           
                              <h:commandLink value=" > Recomendaciones" action="#{menuControlFertilidadBean.irRecomedacionControlFertilidad}"  style="color:Green;"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderConducta}"/>
                                           
                            <h:commandLink value="Pre - visualizar Consulta" action="#{menuControlFertilidadBean.irCerrarConsultaControlFertilidad}"
                                           immediate="true" rendered="#{menuControlFertilidadBean.renderCerrarConsulta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuControlFertilidadBean.irResumenHistoriaControlFertilidad}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Pausar Consulta"
                                           action="#{menuControlFertilidadBean.irPausarConsultaControlFertilidad}"
                                           rendered="#{menuControlFertilidadBean.renderPausarConsulta}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>