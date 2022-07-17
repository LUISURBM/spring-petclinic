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
                    <t:panelTab label="Evoluci�n M�dico" id="divToolsAccordionDir" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Evoluci�n M�dico" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irEvolucionMedicoUsuario}" immediate="true"/>
                            <h:commandLink value="Examen Fisico" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irExamenFisicoEvolucionMedico}" 
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                           <h:commandLink value="Impresi�n Diagnostica" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irImpDiagnosticaEvolucionMedico}" 
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:outputText value="Conducta (Consulta Externa)" styleClass="label_itemmenu" style="font-size:17px;"
                                          rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Salida del Paciente" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irRecomedacionEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irAnatPatologicaEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                                           
                            <h:commandLink value=" > Autorizacion de Servicios" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irAautorizacionServiciosEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Control" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irControlSinCostoEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irFormulaMedicaEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Remisi�n Hospitalizaci�n" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irRemHospitalizacionEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irIncapacidadEvolucionMedico}" immediate="true"
                                           rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irInterConsultaEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Cirug�as y procedimientos" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irOrdenCirugiaEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irReferenciaEvolucionMedico}" immediate="true"
                                           rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irReservaSangreEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu" style="font-size:17px;"
                                          rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irCertMedicoEvolucionMedico}" immediate="true"
                                           rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irCertAsistenciaEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:outputText value=" > Ex�menes para Clinicos" styleClass="label_itemmenu" style="font-size:17px;"
                                          rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Ex�men ElectroFisiologicos" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irExamElectrofisiologicoEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Ex�men Imagen" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irExamImagenEvolucionMedico}" immediate="true"
                                           rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Ex�men Laboratorio" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irExamLaboratorioEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:outputText value=" > Ordenes M�dicas (Cirugia)" styleClass="label_itemmenu" style="font-size:17px;"
                                          rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Formular L�quidos" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irFormularLiquidosEvolucionMedico}" immediate="true"
                                           rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Formular Medicamentos" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irFormularMedicamentosEvolucionMedico}" immediate="true"
                                           rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Otras Ordenes" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irRegistrarOtrasOrdenes}" immediate="true"
                                           rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                            <h:commandLink value="Cerrar Evoluci�n M�dico" style="font-size:17px;"
                                           action="#{menuEvolucionMedicoBean.irCerrarConsultaEvolucionMedico}"
                                           immediate="true" rendered="#{menuEvolucionMedicoBean.renderConducta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Cirug�a" id="divToolsAccordionResHisto" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1" columnClasses="nivelTresBarra">
                             <h:commandLink value="Consultar Resumen de Cirug�a" 
                             action="#{menuEvolucionMedicoBean.irConsultarFoliosUsuarioCirugiaMedico}"
                                           immediate="true" style="font-size:17px;"/>    
                                   <h:commandLink value="Consultar Historia Total" action="#{menuEvolucionMedicoBean.irResumenHistoriaEspecificaEvolucionMedico}"   
                                   immediate="true" style="font-size:17px;"/>              
                       
                      </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>