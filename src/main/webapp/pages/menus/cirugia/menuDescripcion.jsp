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
                    <t:panelTab label="Descripción" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                          
                            <h:commandLink value=" > Descripción" 
                                           action="#{menuDescripcionBean.irdescripcionMedicoUsuario}" 
                                           immediate="true"/>
                          
                            <h:outputText value="Conducta (Consulta Externa)" style="font-size:15px;" styleClass="label_itemmenu"
                            rendered="#{menuDescripcionBean.renderDescripcion}"/>
                            

                            <h:commandLink value=" > Control" 
                                           action="#{menuDescripcionBean.irControlSinCostodescripcionMedico}"
                                           rendered="#{menuDescripcionBean.renderDescripcion}"
                                           immediate="true"/>
                            <h:commandLink value=" > Formula Medica" 
                                           action="#{menuDescripcionBean.irFormulaMedicadescripcionMedico}"
                                           rendered="#{menuDescripcionBean.renderDescripcion}"
                                           immediate="true" />
                         
                            <h:commandLink value=" > Incapacidad" 
                                          action="#{menuDescripcionBean.irIncapacidaddescripcionMedico}" 
                                          rendered="#{menuDescripcionBean.renderDescripcion}"
                                          immediate="true"/>
                                          
                           <h:outputText value=" > Ordenes Médicas (Cirugia)" styleClass="label_itemmenu" style="font-size:14px;" rendered="#{menuDescripcionBean.renderDescripcion}"/>
                            <h:commandLink value=" >> Formular Líquidos" 
                                           action="#{menuDescripcionBean.irFormularLiquidosDescripcionMedico}" immediate="true" rendered="#{menuDescripcionBean.renderDescripcion}"/>
                            <h:commandLink value=" >> Formular Medicamentos"
                                           action="#{menuDescripcionBean.irFormularMedicamentosDescripcionMedico}" immediate="true" rendered="#{menuDescripcionBean.renderDescripcion}"/>
                            <h:commandLink value=" >> Otras Ordenes"
                                           action="#{menuDescripcionBean.irRegistrarOtrasOrdenes}" immediate="true" rendered="#{menuDescripcionBean.renderDescripcion}"/>               
                            <h:commandLink value=" >> Volver a Listado Descripciones" rendered="#{menuDescripcionBean.renderDescripcion}"
                                           action="#{menuDescripcionBean.volverListadoDescricpion}" immediate="true"/>
                     
                        </h:panelGrid>
                    </t:panelTab>
                 <t:panelTab label="Resumen Cirugía" id="divToolsAccordionResHi" style="font-size:15px;">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1" columnClasses="nivelTresBarra">
                             <h:commandLink value="Resumen de Cirugía o Procedimiento" 
                             action="#{menuDescripcionBean.irConsultarFoliosUsuarioCirugia}"
                                           immediate="true" style="font-size:15px;"/>    
                             <h:commandLink value="Resumen Consulta Externa" style="font-size:15px;" 
                             action="#{menuDescripcionBean.irResumenHistoriaTotal}"   immediate="true" />    
                                           
                       
                      </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>