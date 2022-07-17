<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridConfirmarServicioTab"
             styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneConfirmarServicio" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabConfirmarServicio" label="Confirmar Servicio">
            <s:fieldset legend="Datos Servicios" id="fieldSetInfoServicioIngreso" styleClass="fieldset">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionInfoServicio" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Servicio de Ingreso" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="Se presto el servicio?" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="#{confirmarServicioBean.confirmacion.descServicioIngreso}"/>
                    <h:outputText value=""/>
                    <h:selectOneRadio id="mnuConfirmacion" immediate="true" required="true"
                                      value="#{confirmarServicioBean.confirmacion.hcscrealiservi}">
                        <f:selectItems value="#{confirmarServicioBean.listaConfirmacion}"/>
                    </h:selectOneRadio>
                    <h:outputText value=""/>
                </h:panelGrid>
            </s:fieldset>
            <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
                    <t:htmlTag value="br"/>
                    <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true"
                                layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                                warnClass="advertencia"/>
                    <t:htmlTag value="br"/>
                </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                         columnClasses="panelGridBotones">
                <h:panelGroup>
                    <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                                     action="#{confirmarServicioBean.guardar}">
                        <a4j:support event="onclick" status="statusButton"/>
                    </h:commandButton>
                </h:panelGroup>
            </h:panelGrid>
        </t:panelTab>
    </t:panelTabbedPane>
    <f:verbatim>
        <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
    </f:verbatim>
</h:panelGrid>