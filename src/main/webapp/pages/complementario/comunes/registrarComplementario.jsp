<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px"
        id="panelGridRegistrarUsuarioAsesoriaTab" styleClass="tabContainer">
        <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuarioRegistroComplementario.jsp" flush="true"/>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
            width="100%" id="panelTabbedPaneDatosUsuario" styleClass="tabbedPane"
            selectedIndex="#{registrarUsuarioComplementarioBean.selectedIndex}"
            activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
            disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
            inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabDatosUsuario" label="Registro Complementario">
            <a4j:outputPanel id="ajaxRegionMessage" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformation" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
                <t:htmlTag value="br"/>
            </a4j:outputPanel>
            
            <a4j:region renderRegionOnly="false">
                <s:fieldset id="idVerReporte" legend="Ver Reporte Registro Complementario" styleClass="fieldset" 
                        rendered="#{registrarUsuarioComplementarioBean.renderVerReporte}">
                    <a4j:commandLink action="#{registrarUsuarioComplementarioBean.generarReporte}"
                            reRender="panelTabDatosUsuario" immediate="true" title="Reporte Registro Complementario">
                        <t:graphicImage alt="Reporte Registro Complementario" title="Resumen Registro Complementario" border="0"
                                url="/comun/imagenes/pdfIcon.png"/>
                    </a4j:commandLink>
                </s:fieldset>
            </a4j:region>
            
            <s:fieldset legend="Anteriores Registros" id="fieldSetAnteriores" styleClass="fieldset">
                <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionAnteriores"
                             rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Fecha " styleClass="labelTextInfo"/>
                    <h:outputText/>
                    <h:outputText value="Registro " styleClass="labelTextInfo"/>
                    <a4j:region renderRegionOnly="false">
                        <h:selectOneMenu id="listaRegistrosAnteriores" immediate="true"
                                value="#{registrarUsuarioComplementarioBean.numeroRegiCompAnterior}"
                                valueChangeListener="#{registrarUsuarioComplementarioBean.setRegistroChange}"
                                onkeydown="return blockEnter(event);">
                            <f:selectItems value="#{registrarUsuarioComplementarioBean.lstRegiCompAnteriores}"/>
                            <a4j:support id="supportRegiCompAnterior" event="onchange"
                                    reRender="textAreaRegiCompAnterior">
                                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                            </a4j:support>
                        </h:selectOneMenu>
                    </a4j:region>
                    <h:outputText/>
                    <h:inputTextarea id="textAreaRegiCompAnterior" readonly="true"
                                     value="#{registrarUsuarioComplementarioBean.registroRegiCompAnterior}" 
                                     style="width:650px;height:70px">
                        <f:validateLength maximum="4000"/>
                    </h:inputTextarea>
                </h:panelGrid>
            </s:fieldset>
            
            <s:fieldset legend="Informaci�n Registro" id="fieldSetComplementario" styleClass="fieldset">
                <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionComplementario"
                             rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Informaci�n Registro" styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:inputTextarea id="textAreaComplementarios" required="true" immediate="true"
                                     value="#{registrarUsuarioComplementarioBean.registroComplementario.hrccregistro}" 
                                     style="width:650px;height:70px">
                        <f:validateLength maximum="4000"/>
                    </h:inputTextarea>
                    <a4j:outputPanel ajaxRendered="true">
                        <t:message for="textAreaComplementarios" styleClass="errorMessage"/>
                    </a4j:outputPanel>

                </h:panelGrid>
            </s:fieldset>
            
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
                <h:panelGroup>
                    <h:commandButton value="Guardar" styleClass="boton_fieldset"
                            action="#{registrarUsuarioComplementarioBean.guardarComplementario}">
                        <a4j:support event="onclick" status="statusButton"/>
                    </h:commandButton>
                </h:panelGroup>
            </h:panelGrid>
          
            <f:subview id="descargarReporteRegistro" rendered="#{registrarUsuarioComplementarioBean.generoReporte}">
                <a4j:region renderRegionOnly="false">
                    <f:verbatim>
                        <script type="text/javascript" language="JavaScript">
                            window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
                        </script>
                    </f:verbatim>
                </a4j:region>
            </f:subview>
            
        </t:panelTab>
        
    </t:panelTabbedPane>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
    </script>
</h:panelGrid> 
