<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>

<a4j:form id="infoClinicaForm">
  <a4j:region id="bodyRegionCU">
    <a4j:status id="statusButton" for="bodyRegionCU">
      <f:facet name="start">
        <t:div id="chargindDiv2" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMensajesInformacionUsuario" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInfInformacionUsuario" showSummary="true" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    
     <t:div id="infoBasica" style="display:none">
    <h:panelGrid columns="1" id="tableInformacionUsuario" border="0" cellpadding="0" cellspacing="0" width="100%"
                 styleClass="td_ubicador">
      <h:outputText value="Informacion Servicio " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentInfoUsuario"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario y Centro" id="fieldSetInfoUsuario" styleClass="fieldset">
        <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoUsuario"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Nombre del Usuario"/>
          <h:outputText value="Nombre de la Clinica"/>
          <h:outputText value="Dirección"/>
          <h:outputText value="#{informacionUsuarioBean.usuario.curcnombre}"/>
          <h:outputText id="cltscdescripcion" value="#{informacionUsuarioBean.infoClinica.cclcnombre}"/>
          <h:outputText id="cltscdireccion" value="#{informacionUsuarioBean.infoClinica.cclcdirect}"/>
        </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
   
     </t:div>
      <h:panelGrid columns="1" cellpadding="2" cellspacing="2" border="0" width="100%" style="vertical-align:sub;">
      <a4j:commandLink onclick="ToggleText('infoBasica'); return false" title="+/- Datos Básicos">
        <t:graphicImage alt="+/- Datos Básicos" title="+/- Datos Básicos" align="center" height="16" width="30" border="0" url="/comun/imagenes/ico_masymenos.jpg"/>
      </a4j:commandLink>
       </h:panelGrid>
       
       
       
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabcontainer"
                 id="panelGridServiciosTab">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneFormulaMedica" styleClass="tabbedPane"
                         selectedIndex="#{informacionServicioBean.selectedIndex}" activeTabStyleClass="activeTab"
                         inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab"
                         activeSubStyleClass="activeSub" inactiveSubStyleClass="inactiveSub"
                         tabContentStyleClass="tabContent">
        <t:panelTab id="panelTabPrescripcionMedica" label="Consulta de Servicios"
                    disabled="#{informacionServicioBean.renderBuscador}">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridFormulaMedica">
            <s:fieldset legend="Consulta de Servicios" id="fieldFormulaMedica" styleClass="fieldset">
              <a4j:region id="regionFormulaMedica" renderRegionOnly="false">
                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                             id="panelDatosFormulaMedica" rowClasses="labelText,labelTextInfo">
                  <h:outputText value="Nombre y codigo del Servicio" styleClass="labelTextOblig"/>
                  <h:outputText value=" "/>
                  <h:outputText value=""/>
                  <h:outputText value=" "/>
                  <h:panelGroup>
                    <a4j:region renderRegionOnly="false">
                      <a4j:commandLink action="#{informacionServicioBean.renderServicios}" immediate="true"
                                       reRender="panelGridServiciosTab">
                        <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                      </a4j:commandLink>
                      <h:inputText id="itServicio" value="#{informacionServicioBean.servicio.csvccodigo}"
                                   valueChangeListener="#{informacionServicioBean.setServicio}"
                                   binding="#{informacionServicioBean.itServicio}"
                                   required="true" styleClass="textmayuscula"
                                   onkeydown="return blockEnter(event);" immediate="true" style="width:80px">
                        <f:validateLength maximum="10"/>
                        
                        <a4j:support id="supportitDiagPrin" event="onchange"
                                     action="#{informacionServicioBean.changeServicioSeleccion}"
                                     reRender="panelServicioSeleccion" immediate="true">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:inputText>
                      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelServicioSeleccion">
                        <h:outputText value=" #{informacionServicioBean.servicioSeleccion}" styleClass="buscador"/>
                      </h:panelGrid>
                    </a4j:region>
                  </h:panelGroup>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="itServicio" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                               id="panelRegionInfoServi" rowClasses="labelText,labelTextInfo">
                    <h:outputLabel value="Lugar Servicio" for="presservi" styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:outputLabel value="Cantidad" for="cantiservi" styleClass="labelTextOblig"/>
                    <h:outputText value=" "/>
                    <h:panelGroup id="panelGroupRadio">
                      <h:selectOneRadio id="presservi" layout="pageDirection" binding="#{informacionServicioBean.selectPresservi}"
                                        value="#{informacionServicioBean.spservicio.lugarservi}" immediate="true"
                                        valueChangeListener="#{informacionServicioBean.spservicio.setLugarservi}">
                        <f:selectItem itemLabel="Intramural" itemValue="I"/>
                        <f:selectItem itemLabel="Extramural" itemValue="E"/>
                        <a4j:support id="supportS" event="onclick" immediate="true">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                      </h:selectOneRadio>
                    </h:panelGroup>
                    <t:message for="presservi" styleClass="errorMessage"/>
                    <h:inputText id="cantiservi" immediate="true"
                                 value="#{informacionServicioBean.spservicio.cantservi}"></h:inputText>
                    <t:message for="cantiservi" styleClass="errorMessage"/>
                  </h:panelGrid>
                  <h:panelGrid id="panelGridMedicamentosBotones1" width="100%" columnClasses="columnaBotonesCentrados"
                               dir="RTL">
                    <t:htmlTag value="br"/>
                    <h:panelGroup>
                      <t:htmlTag value="br"/>
                      <a4j:commandButton value="Consultar" styleClass="btn btn btn-success" oncomplete="numeroJs()"
                                         action="#{informacionServicioBean.consultaServiciosSap}"
                                         reRender="panelGridServiciosSapTab"/>
                    </h:panelGroup>
                  </h:panelGrid>
                </h:panelGrid>
              </a4j:region>
            </s:fieldset>
          </h:panelGrid>
        </t:panelTab>
        <t:panelTab id="panelBuscadorMedicamentos" label="Buscar Servicios"
                    rendered="#{informacionServicioBean.renderBuscador}">
          <a4j:region id="regionMedicamento" renderRegionOnly="false">
            <a4j:status id="statusButton" for="regionMedicamento">
              <f:facet name="start">
                <t:div id="chargingMedicamento" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <a4j:region renderRegionOnly="false">
              <jsp:include page="/pages/clinico/comunes/buscador/buscadorServicios.jsp" flush="true"/>
            </a4j:region>
            <h:panelGrid id="panelGridMedicamentosBotones" width="100%" columnClasses="columnaBotonesCentrados"
                         dir="RTL">
              <t:htmlTag value="br"/>
              <h:panelGroup id="panelGroupMedicamentosBotones1">
                <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                   action="#{informacionServicioBean.aceptarServicio}" reRender="panelGridServiciosTab"></a4j:commandButton>
              </h:panelGroup>
            </h:panelGrid>
          </a4j:region>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabcontainer"
                 id="panelGridServiciosSapTab">
      <s:fieldset legend="Consulta de Servicios" id="fieldSetInfoServicio" styleClass="fieldset">
        <h:panelGrid columns="1" id="panelGridConsultarFoliosMedico"
                     rendered="#{empty informacionServicioBean.ltsTarifaServicio}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" id="panelGridEmpresa" rendered="#{not empty informacionServicioBean.ltsTarifaServicio}"
                     width="100%" style="text-align:center;">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{informacionServicioBean.ltsTarifaServicio}"
                         binding="#{informacionServicioBean.dtServicio}" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" rows="10"
                         id="idDtProgHorario">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Codigo"/>
                </f:facet>
                <h:outputText value="#{item.material}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Servicio"/>
                </f:facet>
                <h:outputText value="#{item.nombreMaterial}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Lugar"/>
                </f:facet>
                <h:outputText value="#{item.lugarServicio}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Cantidad"/>
                </f:facet>
                <h:outputText value="#{item.cantidadMaterial}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:panelGrid columns="14" border="0" cellpadding="0" cellspacing="2" width="550" id="panelGridDias">
                    <h:panelGrid columns="1" width="78">
                      <h:outputLabel value="Tipo de Lista" style="font-weight:bold; font-size:7.0pt;"/>
                    </h:panelGrid>
                    <h:outputText value="Valor"/>
                    <h:outputText value="Valor Descuento"/>
                    <h:outputText value="Total"/>
                  </h:panelGrid>
                </f:facet>
                <h:panelGrid columns="10" border="0" cellpadding="2" cellspacing="2" width="620" id="panelGridProg12">
                  <h:panelGrid columns="0" width="78">
                    <h:outputText value="Particular" style="font-weight: bold; font-size:7.0pt;"/>
                    <h:outputText value="Joven" style="font-weight: bold; font-size:7.0pt;"/>
                    <h:outputText value="Adulto Joven" style="font-weight: bold; font-size:7.0pt;"/>
                    <h:outputText value="Adulto" style="font-weight: bold; font-size:7.0pt;"/>
                    <h:outputText value="Empleado" style="font-weight: bold; font-size:7.0pt;"/>
                  </h:panelGrid>
                  <h:panelGrid columns="0" width="78">
                    <h:outputText value="#{item.importeParticular}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.importeJoven}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.importeJovenAdulto}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.importeAdulto}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.importeEmpleado}" style="weight: font-size:8.0pt;"/>
                  </h:panelGrid>
                  <h:panelGrid columns="0" width="78">
                    <h:outputText value="#{item.descuentoParticular}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.descuentoJoven}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.descuentoJovenAdulto}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.descuentoAdulto}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.descuentoEmpleado}" style="weight: font-size:8.0pt;"/>
                  </h:panelGrid>
                  <h:panelGrid columns="0" width="78">
                    <h:outputText value="#{item.totalParticular}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.totalJoven}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.totalJovenAdulto}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.totalAdulto}" style="weight: font-size:8.0pt;"/>
                    <h:outputText value="#{item.totalEmpleado}" style="weight: font-size:8.0pt;"/>
                  </h:panelGrid>
                </h:panelGrid>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Eliminar"/>
                </f:facet>
                <h:commandLink id="eliminar" immediate="true" action="#{informacionServicioBean.eliminarServicio}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/Delete.png"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="idDtProgHorario" fastStep="10" pageCountVar="pageCount"
                              pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                              renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
                              paginatorActiveColumnStyle="font-weight:bold;">
                <f:facet name="first">
                  <t:graphicImage url="/comun/imagenes/primero.gif" border="0"/>
                </f:facet>
                <f:facet name="last">
                  <t:graphicImage url="/comun/imagenes/ultimo.gif" border="0"/>
                </f:facet>
                <f:facet name="previous">
                  <t:graphicImage url="/comun/imagenes/anterior.gif" border="0"/>
                </f:facet>
                <f:facet name="next">
                  <t:graphicImage url="/comun/imagenes/siguiente.gif" border="0"/>
                </f:facet>
                <f:facet name="fastforward">
                  <t:graphicImage url="/comun/imagenes/adelante.gif" border="0"/>
                </f:facet>
                <f:facet name="fastrewind">
                  <t:graphicImage url="/comun/imagenes/atras.gif" border="0"/>
                </f:facet>
              </t:dataScroller>
              <t:dataScroller id="scroll_2" for="idDtProgHorario" rowsCountVar="rowsCount"
                              displayedRowsCountVar="displayedRowsCountVar" firstRowIndexVar="firstRowIndex"
                              lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
                <h:outputFormat value="#{msg.msg_datos_tablas}" styleClass="standard">
                  <f:param value="#{rowsCount}"/>
                  <f:param value="#{displayedRowsCountVar}"/>
                  <f:param value="#{firstRowIndex}"/>
                  <f:param value="#{lastRowIndex}"/>
                  <f:param value="#{pageIndex}"/>
                  <f:param value="#{pageCount}"/>
                </h:outputFormat>
              </t:dataScroller>
            </h:panelGrid>
          </t:buffer>
          <h:outputText value="#{tableScroller}" escape="false"/>
          <h:outputText value="#{table}" escape="false"/>
          <h:outputText value="#{tableScroller}" escape="false"/>
        </h:panelGrid>
      </s:fieldset>
        <h:panelGroup>
        <t:htmlTag value="br"/>
         <h:commandButton value="Continuar" styleClass="btn btn btn-success" 
                         action="#{informacionServicioBean.registrarUsuario}" rendered="#{not empty informacionServicioBean.ltsTarifaServicio}"/>
      </h:panelGroup>
    </h:panelGrid>
   
  </a4j:region>
  
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[4].focus()
</script>
</a4j:form>