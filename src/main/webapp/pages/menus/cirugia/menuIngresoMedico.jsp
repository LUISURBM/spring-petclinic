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
                    <t:panelTab label="Ingreso M�dico" id="divToolsAccordionDir" style="font-size:17px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Ingreso M�dico" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irIngresoMedicoUsuario}" immediate="true"/>
                            <h:commandLink value="Examen Fisico" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irExamenFisicoIngresoMedico}" 
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                           <h:commandLink value="Impresi�n Diagnostica" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irImpDiagnosticaIngresoMedico}" 
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:outputText value="Conducta (Consulta Externa)" styleClass="label_itemmenu"
                                          rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Salida del Paciente" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irRecomedacionIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Anatomia Patologica" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irAnatPatologicaIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Control" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irControlSinCostoIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Formula Medica" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irFormulaMedicaIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Remisi�n Hospitalizaci�n" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irRemHospitalizacionIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Incapacidad" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irIncapacidadIngresoMedico}" immediate="true"
                                           rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Inter Consulta" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irInterConsultaIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Cirug�as y procedimientos" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irOrdenCirugiaIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Referencia" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irReferenciaIngresoMedico}" immediate="true"
                                           rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" > Reserva de Sangre" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irReservaSangreIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:outputText value=" > Certificados" styleClass="label_itemmenu"
                                          rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado Medico" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irCertMedicoIngresoMedico}" immediate="true"
                                           rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Certificado de Asistencia" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irCertAsistenciaIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:outputText value=" > Ex�menes para Clinicos" styleClass="label_itemmenu"
                                          rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Ex�men ElectroFisiologicos" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irExamElectrofisiologicoIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Ex�men Imagen" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irExamImagenIngresoMedico}" immediate="true"
                                           rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Ex�men Laboratorio" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irExamLaboratorioIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:outputText value=" > Ordenes M�dicas" styleClass="label_itemmenu" style="font-size:17px;" 
                                          rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Formular L�quidos" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irFormularLiquidos}" immediate="true"
                                           rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Formular Medicamentos" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irFormularMedicamentos}" immediate="true"
                                           rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Medidas de Apoyo" style="font-size:17px;" action="#{menuIngresoMedicoBean.irMedidasApoyo}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value=" >> Formular Medicamentos Especiales" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irMedicamentosEspeciales}" immediate="true"
                                           rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                            <h:commandLink value="Cerrar Ingreso M�dico" style="font-size:17px;"
                                           action="#{menuIngresoMedicoBean.irCerrarConsultaIngresoMedico}"
                                           immediate="true" rendered="#{menuIngresoMedicoBean.renderConducta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                     
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>