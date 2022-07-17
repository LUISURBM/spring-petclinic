<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridMotivoConsultaTab"
             styleClass="tabContainer">
  <jsp:include page="/pages/clinico/comunes/encabezadoDatosUsuario.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneMotivoConsulta" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabConfirmarServiciosAdmision" label="Confirmar Servicios Admisión">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabsServicios"
                   styleClass="tabContainer">
                   
       <s:fieldset legend="Servicio Realizado" id="fieldSetInfoServicioIngreso" styleClass="fieldset">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelRegionInfoServicio" rowClasses="labelText,labelTextInfo">
                    <h:outputText value="Servicio de Ingreso" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                   <h:outputText value="Servicio Realizado" styleClass="labelTextOblig"/>
                    <h:outputText value=""/>
                    <h:outputText value="#{confirmarServicioBean.confirmacion.descServicioIngreso}"/>
                    <h:outputText value=""/>
                    <h:selectOneMenu id="mnuConfirmacion" immediate="true" required="true" style="width:100%;" disabled="#{confirmarServiciosAdmisionBean.validacionNovedad}"
                                      value="#{confirmarServicioBean.confirmacion.hcscserviegres}">
                        <f:selectItems value="#{confirmarServicioBean.listServiciosProfesional}"/>
                    </h:selectOneMenu>
                    <h:outputText value=""/>
                </h:panelGrid>
            </s:fieldset>            
                   
        <s:fieldset legend="Servicios " id="fieldServicios" styleClass="fieldset">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs"
                       rendered="#{not empty confirmarServiciosAdmisionBean.cfdetafacturaList}">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="0" cellpadding="0" cellspacing="4"
                           binding="#{confirmarServiciosAdmisionBean.tableServiciosAdmision}"
                           value="#{confirmarServiciosAdmisionBean.cfdetafacturaList}" rows="30" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="tdatosInsumos">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Codigo Servicio"/>
                  </f:facet>
                  <h:outputText value="#{item.cdfcservicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre Servicio"/>
                  </f:facet>
                  <h:outputText value="#{item.nombreServicio}"></h:outputText>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Solicitar Servicio"/>
                  </f:facet>
                  <h:selectBooleanCheckbox id="booleanServicio" value="#{item.validacionConsultaClinica}" disabled="#{item.validacionConsultaClinica}"/>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="tdatosInsumos" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" paginatorMaxPages="9"
                                paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;"></t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>

        </s:fieldset>
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                     columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Guardar" styleClass="boton_fieldset" action="#{confirmarServiciosAdmisionBean.guardarConfirmacionServiciosAdmision}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </h:panelGrid>
      <h:panelGrid>
        <h:panelGroup>
          <a4j:outputPanel id="ajaxRegionMessagesatributo1" ajaxRendered="true">
            <t:htmlTag value="br"/>
            <t:messages id="msgInformationAndErrors1" showSummary="true" errorClass="error" globalOnly="true"
                        layout="table" infoClass="informacion"/>
          </a4j:outputPanel>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
  </t:panelTabbedPane>
</h:panelGrid>