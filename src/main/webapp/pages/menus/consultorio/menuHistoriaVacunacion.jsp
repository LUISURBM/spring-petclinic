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
            <t:div id="toolBarMnuVacunacion">
                <s:accordionPanel id="menuToolsVacunacion" layout="accordion"
                                  style="border-bottom:White !important;">
                    <t:panelTab label="Vacunación" id="divToolsVacunacionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Datos Usuario"
                                           action="#{menuHistoriaVacunacionBean.irDatosVacunacion}"
                                           immediate="true"/>
                            <h:commandLink value="Vacunación"
                                           rendered="#{menuHistoriaVacunacionBean.renderAplicacion}"
                                           action="#{menuHistoriaVacunacionBean.irVacunacion}"
                                           immediate="true"/>
							<h:commandLink value="Servicios Admisión"
                                           action="#{menuHistoriaVacunacionBean.irServiciosAdmisionVacunacion}"
                                           immediate="true" rendered="#{menuHistoriaVacunacionBean.renderServiciosAdmision}"/>			   
                            <h:commandLink value="Pre - visualizar"
                                           rendered="#{menuHistoriaVacunacionBean.renderCerrarConsulta}"
                                           action="#{menuHistoriaVacunacionBean.irCerrarVacunacion}"
                                           immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                    <t:panelTab label="Pausar Consulta" id="divToolsAccordionPausarCon">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                             <h:commandLink value="Pausar Consulta"
                                   action="#{menuHistoriaVacunacionBean.irPausarConsultaVacunacion}"
                                   rendered="#{menuHistoriaVacunacionBean.renderPausarConsulta}" immediate="true"/>
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>