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
                <s:accordionPanel id="menuToolsAccordion" layout="accordion" style="border-bottom:White !important;"   colspan="2">
                    <t:panelTab label="Historia Espermograma Fertilidad" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario" 
                                action="#{menuEspermogramaFertilidadBean.irDatosEspermogramaFertilidad}"
                                           immediate="true"/>
                            <h:commandLink value="Resultado Espermograma Fertilidad" 
                             action="#{menuEspermogramaFertilidadBean.irEspermogramaFertilidad}" immediate="true"
                                           rendered="#{menuEspermogramaFertilidadBean.renderControl}"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuEspermogramaFertilidadBean.irServiciosAdmisionEspermogramaFertilidad}"
                                           immediate="true" rendered="#{menuEspermogramaFertilidadBean.renderServiciosAdmision}"/>			   
                            <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuEspermogramaFertilidadBean.renderConducta}"/>
                            <h:commandLink value=" > Recomendaciones" action="#{menuVasectomiaBean.irRecomedacionVasectomia}"
                                           style="color:Green;" immediate="true"
                                           rendered="#{menuVasectomiaBean.renderConducta}"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Resumen Historia" id="divToolsAccordionResHis">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Historia Total" action="#{menuVasectomiaBean.irResumenHistoriaControl}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                     <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuEspermogramaFertilidadBean.irPausarConsultaEspermogramaFertilidad}"
                                   rendered="#{menuEspermogramaFertilidadBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>