<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty encabezadoCirugiaProgramadaBean.lstCirugias}"
             cellspacing="0" width="100%" id="tableCirugiasProgramadasGeneral" styleClass="tabContainer">
    <rich:dataGrid value="#{encabezadoCirugiaProgramadaBean.lstCirugias}" var="cirugia" columns="1" elements="1"
                   width="600px" border="0">
        <rich:panel>
            <h:panelGrid columns="1" styleClass="label label-warning" border="0">
                <h:outputText value="Cirugia"/>
                <h:outputText value="#{cirugia.nombreServicio}"/>
            </h:panelGrid>
        </rich:panel>
    </rich:dataGrid>
</h:panelGrid>