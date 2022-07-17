<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<!-- registrarcuestionarioPregunta.jsp -->
<a4j:form id="infocuestionarioPreguntaForm">
  <a4j:region id="bodyRegioncuestionarioPregunta">
    <a4j:status for="bodyRegioncuestionarioPregunta">
      <f:facet name="start">
        <t:div id="chargindcuestionarioPregunta" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneRegistrarcuestionarioPregunta" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabRegistrarcuestionarioPregunta" label="Registrar cuestionarioPregunta">
        <a4j:region renderRegionOnly="false">
          <s:fieldset legend="Registrar cuestionarioPregunta" id="fieldSetInfocuestionarioPregunta"
                      styleClass="fieldset">
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelRegioncuestionarioPregunta" rowClasses="labelText,labelTextInfo">
              <h:outputText value="Indicador" styleClass="labelTextOblig"/>
              <h:outputText/>
              <h:outputText id="mnuTema" value="#{cuestionarioPreguntaBean.indicadorObject.hpicdescripcio}"></h:outputText>
              <h:outputText/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Lista Preguntas" id="fieldListacuestionarioPregunta" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridListacuestionarioPregunta"
                         rendered="#{empty cuestionarioPreguntaBean.lstPregunta}">
              <h:outputText value="No existen Preguntas registradas"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                         id="panelcuestionarioPreguntaTable" styleClass="tabContainer"
                         rendered="#{not empty cuestionarioPreguntaBean.lstPregunta}">
              <t:buffer into="#{table}">
                <t:div style="height:105%;overflow:auto;width:1190px">
                  <h:dataTable var="item" border="0" cellpadding="0" binding="#{cuestionarioPreguntaBean.dtPregunta}"
                               cellspacing="0" value="#{cuestionarioPreguntaBean.lstPregunta}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtPregunta">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Pregunta"/>
                      </f:facet>
                      <t:div style="overflow:auto;width:250px;height:50px;">
                        <h:panelGrid>
                          <h:outputText value=" #{item.id.hcpncodigpregu} #{item.hcpcdescrpregu}"/>
                        </h:panelGrid>
                      </t:div>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Enero"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm01" value="#{item.hcpnmesenero}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 1}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                         <h:outputText value="#{item.hcpnmesenero}" rendered="#{cuestionarioPreguntaBean.mesActual != 1}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm01" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes02">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Febrero"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm02" value="#{item.hcpnmesfebre}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 2}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                    <h:outputText value="#{item.hcpnmesfebre}" rendered="#{cuestionarioPreguntaBean.mesActual != 2}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm02" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes03">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Marzo"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm03" value="#{item.hcpnmesmarzo}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 3}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                    <h:outputText value="#{item.hcpnmesmarzo}" rendered="#{cuestionarioPreguntaBean.mesActual != 3}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm03" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes04">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Abril"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm04" value="#{item.hcpnmesabril}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 4}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesabril}" rendered="#{cuestionarioPreguntaBean.mesActual != 4}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm04" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes05">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Mayo"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm05" value="#{item.hcpnmesmayo}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 5}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesmayo}" rendered="#{cuestionarioPreguntaBean.mesActual != 5}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm05" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes06">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Junio"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm06" value="#{item.hcpnmesjunio}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 6}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesjunio}" rendered="#{cuestionarioPreguntaBean.mesActual != 6}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm06" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes07">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Julio"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm07" value="#{item.hcpnmesjulio}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 7}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesjulio}" rendered="#{cuestionarioPreguntaBean.mesActual != 7}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm07" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes08">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Agosto"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm08" value="#{item.hcpnmesagost}" style="width:60px;color:red"  maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 8}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesagost}" rendered="#{cuestionarioPreguntaBean.mesActual != 8}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm08" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes09">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Septiem"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm09" value="#{item.hcpnmessepti}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 9}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmessepti}" rendered="#{cuestionarioPreguntaBean.mesActual != 9}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm09" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes10">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Octubre"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm10" value="#{item.hcpnmesoctub}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 10}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesoctub}" rendered="#{cuestionarioPreguntaBean.mesActual != 10}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm10" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes11">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Noviemb"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm11" value="#{item.hcpnmesnovie}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 11}"
                      required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesnovie}" rendered="#{cuestionarioPreguntaBean.mesActual != 11}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm11" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                    <h:column id="colmes12">
                      <f:facet name="header">
                        <h:panelGrid columns="1">
                          <h:outputText value="Diciemb"/>
                        </h:panelGrid>
                      </f:facet>
                      <h:inputText id="itm12" value="#{item.hcpnmesdicie}" style="width:60px" maxlength="9"
                      rendered="#{cuestionarioPreguntaBean.mesActual == 12}"
                       required="true"
                                   styleClass="styleInputValueDt"></h:inputText>
                                   <h:outputText value="#{item.hcpnmesdicie}" rendered="#{cuestionarioPreguntaBean.mesActual != 12}" />
                      <a4j:outputPanel ajaxRendered="true">
                        <t:message for="itm12" styleClass="errorMessage"/>
                      </a4j:outputPanel>
                    </h:column>
                  </h:dataTable>
                </t:div>
              </t:buffer>
              <t:htmlTag value="br"/>
              <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                <h:panelGroup>
                  <h:commandButton value="Registrar Modificaciones" styleClass="boton"
                                   action="#{cuestionarioPreguntaBean.actualizarPreguntas}">
                    <a4j:support event="onclick" status="statusButton"/>
                  </h:commandButton>
                </h:panelGroup>
              </h:panelGrid>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_cuestionarioPregunta" for="dtPregunta" fastStep="10"
                                  pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                                  paginator="true" immediate="true" paginatorMaxPages="9"
                                  paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
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
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
        </a4j:region>
        <h:panelGrid>
          <t:commandLink action="#{cuestionarioPreguntaBean.volverIndicadores}" immediate="true">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/volver.gif"/>
          </t:commandLink>
        </h:panelGrid>
      </t:panelTab>
    </t:panelTabbedPane>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajes" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInf" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
  </a4j:region>
</a4j:form>