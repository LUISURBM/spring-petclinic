<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridOtrasOrdenesTab" styleClass="tabContainer">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridOtrasOrdenes" styleClass="tabContainer">
    <!-- HISTORIAL -->
    <s:fieldset legend="Cirugia(s) Programada(s)" id="fieldCirugiasIngresoOtrasOrdenes" styleClass="fieldset">
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelCirugiasOtrasOrdenes" rowClasses="labelText,labelTextInfo">
        <h:outputText value="Intervenci�n(es)" styleClass="labelTextOblig"/>
        <h:outputText/>
      </h:panelGrid>
      <h:panelGrid columns="1" border="0" cellpadding="0" rendered="#{not empty otrasOrdenesPendientesBean.lstCirugias}" cellspacing="0" width="100%" id="tableCirugiasProgramadasOtrasOrdenes"
                   styleClass="tabContainer">
        <t:buffer into="#{table}">
          <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{otrasOrdenesPendientesBean.dtCirugias}" value="#{otrasOrdenesPendientesBean.lstCirugias}" rows="10" styleClass="standard_table"
                       rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtCirugiasProgramadasOtrasOrdenes">
            <h:column>
              <f:facet name="header">
                <h:outputText value="Codigo"/>
              </f:facet>
              <h:outputText value="#{item.csvccodigo}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Nombre"/>
              </f:facet>
              <h:outputText value="#{item.csvcnombre}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Estado"/>
              </f:facet>
              <h:outputText value="#{item.csvcestado}"/>
            </h:column>
          </h:dataTable>
        </t:buffer>
        <t:buffer into="#{tableScroller}">
          <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
            <t:dataScroller id="scroll_1" for="dtCirugiasProgramadasOtrasOrdenes" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                            immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
              <f:facet name="first">
                <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
              </f:facet>
              <f:facet name="last">
                <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
              </f:facet>
              <f:facet name="previous">
                <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
              </f:facet>
              <f:facet name="next">
                <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
              </f:facet>
              <f:facet name="fastforward">
                <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
              </f:facet>
              <f:facet name="fastrewind">
                <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
              </f:facet>
            </t:dataScroller>
          </h:panelGrid>
        </t:buffer>
        <h:outputText value="#{tableScroller}" escape="false"/>
        <h:outputText value="#{table}" escape="false"/>
        <h:outputText value="#{tableScroller}" escape="false"/>
      </h:panelGrid>
    </s:fieldset>
    <!-- LISTA REALIZADAS -->
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Otras Ordenes Realizadas" id="fieldOtrasOrdenesRealizadas" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablefieldOtrasOrdenesRealizadasNoDatos" rendered="#{empty otrasOrdenesPendientesBean.lstOtrasOrdenesRealizadas}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablefieldOtrasOrdenesRealizadas" rendered="#{not empty otrasOrdenesPendientesBean.lstOtrasOrdenesRealizadas}"
                     styleClass="tabContainer">
          <t:buffer into="#{table_OtrasOrdenesRealizadas}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{otrasOrdenesPendientesBean.dtOtrasOrdenesRealizadas}" value="#{otrasOrdenesPendientesBean.lstOtrasOrdenesRealizadas}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtOtrasOrdenesRealizadas">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item.nombreTipo}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Descripcion"/>
                </f:facet>
                <h:outputText value="#{item.hcocordenenvi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Observacion"/>
                </f:facet>
                <h:outputText value="#{item.hcocobserva}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora de Registro"/>
                </f:facet>
                <h:outputText value="#{item.hcodfechaadmi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcocoperaadmi}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller_OtrasOrdenesRealizadas}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_2" for="dtOtrasOrdenesRealizadas" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller_OtrasOrdenesRealizadas}" escape="false"/>
          <h:outputText value="#{table_OtrasOrdenesRealizadas}" escape="false"/>
          <h:outputText value="#{tableScroller_OtrasOrdenesRealizadas}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
    </a4j:region>
    
     <!-- LISTA REALIZADAS -->
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Otras Ordenes Realizadas Consulta Externa" id="fieldOtrasOrdenesRealizadasCE" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablefieldOtrasOrdenesRealizadasNoDatosCE" rendered="#{empty otrasOrdenesPendientesBean.lstOtrasOrdenesRealizadasCE}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablefieldOtrasOrdenesRealizadasCE" rendered="#{not empty otrasOrdenesPendientesBean.lstOtrasOrdenesRealizadasCE}"
                     styleClass="tabContainer">
          <t:buffer into="#{table_OtrasOrdenesRealizadasCE}">
            <h:dataTable var="item5" border="1" cellpadding="0" cellspacing="0" value="#{otrasOrdenesPendientesBean.lstOtrasOrdenesRealizadasCE}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtOtrasOrdenesRealizadasCE">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item5.nombreTipo}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Descripcion"/>
                </f:facet>
                <h:outputText value="#{item5.hcocordenenvi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Observacion"/>
                </f:facet>
                <h:outputText value="#{item5.hcocobserva}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Hora de Registro"/>
                </f:facet>
                <h:outputText value="#{item5.hcodfechaadmi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Usuario"/>
                </f:facet>
                <h:outputText value="#{item5.hcocoperaadmi}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller_OtrasOrdenesRealizadasCE}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_5" for="dtOtrasOrdenesRealizadasCE" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller_OtrasOrdenesRealizadasCE}" escape="false"/>
          <h:outputText value="#{table_OtrasOrdenesRealizadasCE}" escape="false"/>
          <h:outputText value="#{tableScroller_OtrasOrdenesRealizadasCE}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
    </a4j:region>
    
    <!-- LISTA PENDIENTES -->
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Otras Ordenes Pendientes" id="fieldOtrasOrdenesPendientes" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablefieldOtrasOrdenesPendientesNoDatos" rendered="#{empty otrasOrdenesPendientesBean.lstOtrasOrdenes}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablefieldOtrasOrdenesPendientes" rendered="#{not empty otrasOrdenesPendientesBean.lstOtrasOrdenes}"
                     styleClass="tabContainer">
          <t:buffer into="#{table_OtrasOrdenesPendientes}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" binding="#{otrasOrdenesPendientesBean.dtOtrasOrdenes}" value="#{otrasOrdenesPendientesBean.lstOtrasOrdenes}" rows="10"
                         styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtOtrasOrdenesPendientes">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item.nombreTipo}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Descripcion"/>
                </f:facet>
                <h:outputText value="#{item.hcocordenenvi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Observacion"/>
                </f:facet>
                <h:inputText value="#{item.hcocobserva}" styleClass="input-small"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Criterio Oxigeno"/>
                </f:facet>
                <h:panelGroup id="criterioOx">
                  <h:outputText value="Acaba de ser tomado? " rendered="#{item.renderOxigeno}"/>
                  <h:selectOneMenu id="mnuOxigenoNo" value="#{otrasOrdenesPendientesBean.noOxigeno}" rendered="#{item.renderOxigeno}" valueChangeListener="#{otrasOrdenesPendientesBean.setOxigeno}">
                    <f:selectItem itemLabel="Seleccione.." itemValue="L"/>
                    <f:selectItems value="#{otrasOrdenesPendientesBean.lstOpciones}"/>
                    <a4j:support id="supportTipoOrden" event="onchange" action="#{otrasOrdenesPendientesBean.changeNoOxigeno}"
                                 reRender="panelInputOxigeno,mnuOxigenoSuspender,itOxigenoSuspender,outInicioAdmin">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <h:panelGrid columns="2" id="panelInputOxigeno">
                    <h:selectOneRadio id="mnuOxigenoSuspender" rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}" value="#{otrasOrdenesPendientesBean.suspenderOxigeno}">
                      <f:selectItem itemLabel="Suspender?" itemValue="X"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuOxigenoSuspender" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:selectOneRadio>
                    <h:panelGroup>
                      <h:panelGrid columns="1">
                        <h:outputText id="outInicioAdmin" value="Hace cu�nto inicio administraci�n" rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}"/>
                        <h:panelGrid columns="2">
                          <h:inputText id="itOxigenoSuspender" required="true" style="width: 30px;" value="#{otrasOrdenesPendientesBean.minutosAdmOxigeno}"
                                       rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}"></h:inputText>
                          <h:outputText id="outAdminiOxiMinu" value="Minutos" rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}"/>
                        </h:panelGrid>
                      </h:panelGrid>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Confirmar"/>
                </f:facet>
                <h:commandLink id="administrarOtrasOrdenes" action="#{otrasOrdenesPendientesBean.administrarOrdenPendiente}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientMale.png"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller_OtrasOrdenesPendientes}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_3" for="dtOtrasOrdenesPendientes" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller_OtrasOrdenesPendientes}" escape="false"/>
          <h:outputText value="#{table_OtrasOrdenesPendientes}" escape="false"/>
          <h:outputText value="#{tableScroller_OtrasOrdenesPendientes}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
    </a4j:region>
     <!-- LISTA OTRAS ORDENES CONSULTA EXTERNA -->
    <a4j:region renderRegionOnly="false">
      <s:fieldset legend="Otras Ordenes Consulta Externa" id="fieldOtrasOrdenesCE" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tablefieldOtrasOrdenesCENoDatos" rendered="#{empty otrasOrdenesPendientesBean.lstOtrasOrdenesCE}"
                     styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tablefieldOtrasOrdenesCE"
                     rendered="#{not empty otrasOrdenesPendientesBean.lstOtrasOrdenesCE}" styleClass="tabContainer">
          <t:buffer into="#{table_OtrasOrdenesCE}">
            <h:dataTable var="item3" border="1" cellpadding="0" cellspacing="0"
                         value="#{otrasOrdenesPendientesBean.lstOtrasOrdenesCE}" binding="#{otrasOrdenesPendientesBean.dtOtrasOrdenesCE}" rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                         id="dtOtrasOrdenesCE">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre"/>
                </f:facet>
                <h:outputText value="#{item3.nombreTipo}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Descripcion"/>
                </f:facet>
                <h:outputText value="#{item3.hcocordenenvi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Observacion"/>
                </f:facet>
                <h:inputText value="#{item3.hcocobserva}" styleClass="input-small"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Criterio Oxigeno"/>
                </f:facet>
                <h:panelGroup id="criterioOxCE">
                  <h:outputText value="Acaba de ser tomado? " rendered="#{item3.renderOxigeno}"/>
                  <h:selectOneMenu id="mnuOxigenoNoCE" value="#{otrasOrdenesPendientesBean.noOxigeno}"
                                   rendered="#{item3.renderOxigeno}"
                                   valueChangeListener="#{otrasOrdenesPendientesBean.setOxigenoCE}">
                    <f:selectItem itemLabel="Seleccione.." itemValue="L"/>
                    <f:selectItems value="#{otrasOrdenesPendientesBean.lstOpciones}"/>
                    <a4j:support id="supportTipoOrdenCE" event="onchange"
                                 action="#{otrasOrdenesPendientesBean.changeNoOxigenoCE}"
                                 reRender="panelInputOxigenoCE,mnuOxigenoSuspenderCE,itOxigenoSuspenderCE,outInicioAdminCE">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneMenu>
                  <h:panelGrid columns="2" id="panelInputOxigenoCE">
                    <h:selectOneRadio id="mnuOxigenoSuspenderCE"
                                      rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}"
                                      value="#{otrasOrdenesPendientesBean.suspenderOxigeno}">
                      <f:selectItem itemLabel="Suspender?" itemValue="X"/>
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="mnuOxigenoSuspenderCE" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:selectOneRadio>
                    <h:panelGroup>
                      <h:panelGrid columns="1">
                        <h:outputText id="outInicioAdminCE" value="Hace cu�nto inicio administraci�n"
                                      rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}"/>
                        <h:panelGrid columns="2">
                          <h:inputText id="itOxigenoSuspenderCE" required="true" style="width: 30px;"
                                       value="#{otrasOrdenesPendientesBean.minutosAdmOxigeno}"
                                       rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}"></h:inputText>
                          <h:outputText id="outAdminiOxiMinuCE" value="Minutos"
                                        rendered="#{otrasOrdenesPendientesBean.rendereNodOxigeno}"/>
                        </h:panelGrid>
                      </h:panelGrid>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGroup>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Confirmar"/>
                </f:facet>
                <h:commandLink id="administrarOtrasOrdenesCE"
                               action="#{otrasOrdenesPendientesBean.administrarOrdenPendienteCE}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/PatientMale.png"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller_OtrasOrdenesCE}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_4" for="dtOtrasOrdenesCE" fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                              paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage alt="" url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage alt="" url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage alt="" url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage alt="" url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage alt="" url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage alt="" url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller_OtrasOrdenesCE}" escape="false"/>
          <h:outputText value="#{table_OtrasOrdenesCE}" escape="false"/>
          <h:outputText value="#{tableScroller_OtrasOrdenesCE}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
    </a4j:region>
  </h:panelGrid>
</h:panelGrid>