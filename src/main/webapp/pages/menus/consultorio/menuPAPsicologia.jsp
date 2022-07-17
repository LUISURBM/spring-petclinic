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
                    <t:panelTab label="Primero Auxilios Psicologia" id="divToolsAccordionDir">
                        <h:panelGrid width="100%" cellpadding="0" cellspacing="0" border="0" columns="1"
                                     columnClasses="nivelTresBarra">
                            <h:commandLink value="Primeros Auxilios" action="#{menuPAPsicologiaBean.irDatosNotaAclaratoria}"
                                           immediate="true"/>
                            <h:commandLink value="Consultar Folios" action="#{menuPAPsicologiaBean.irResumenHistoriaNotaAclaratoria}" rendered="#{menuPAPsicologiaBean.renderConsultaFolios}"
                                           immediate="true"/>
                            <h:commandButton value="Salir" action="#{menuPAPsicologiaBean.irSalir}" rendered="#{menuPAPsicologiaBean.renderSalir}"
                                           immediate="true"  onclick="if (!confirm(\'¿Realmente desea Salir de Primeros Auxilios Psicologia\')) return false"/>                
                             <h:outputText value="Conducta" styleClass="label_itemmenu"
                                          rendered="#{menuPAPsicologiaBean.renderConducta}"/>
                                                             
                        </h:panelGrid>
                    </t:panelTab>
                </s:accordionPanel>
            </t:div>
        </h:panelGrid>
    </t:div>
</h:panelGrid>