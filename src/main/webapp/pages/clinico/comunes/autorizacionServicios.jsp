<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>

<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAutorizacionTab"
             styleClass="tabContainer">
<jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneAutorizacion" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex="#{autorizacionServicioUsuarioBean.selectedIndex}"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabAutorizacion" label="Autorizaci�n de Servicios"
                disabled="#autorizacionServicioUsuarioBean.renderBuscador">
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridAutorizacion"
                   styleClass="tabContainer">
        <s:fieldset legend="Datos del Prestador (Solicitante)" id="fieldDatosPrestador" styleClass="fieldset">
          <h:panelGrid id="panelGridDatosPrestador" columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Nombre Solicitante"/>
            <h:outputText value="Nit"/>
            <h:outputText value="Telefono"/>
            <h:outputText value="Direccion"/>
            <h:outputText value="#{autorizacionServicioUsuarioBean.empresa.cemcnombre}"/>
            <h:outputText value="#{autorizacionServicioUsuarioBean.empresa.cemanit}"/>
            <h:outputText value="#{autorizacionServicioUsuarioBean.empresa.cemctelefo}"/>
            <h:outputText value="#{autorizacionServicioUsuarioBean.empresa.cemcdirecc}"/>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Entidad a la que se solicita (Pagador)" id="fieldDatosPagadorr" styleClass="fieldset">
          <a4j:region renderRegionOnly="false">
          <h:panelGrid id="panelGridDatosPagador" columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Nombre Entidad" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value="Cobertura en salud" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>

            <h:selectOneMenu id="menuEntidad" onkeydown="return blockEnter(event);" style="width:500px"
                         required="true" value="#{autorizacionServicioUsuarioBean.autoriserv.haucentidad}" 
                         valueChangeListener="#{autorizacionServicioUsuarioBean.setEntidadSelect}" immediate="true">
              <f:selectItems value="#{autorizacionServicioUsuarioBean.listEntidadAdm}"/>
               <a4j:support id="supEntidad" action="#{autorizacionServicioUsuarioBean.changeEntidad}"
                         reRender="panelGridDatosPagador" event="onchange" immediate="true">
                 <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuEntidad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuCoberturaS" onkeydown="return blockEnter(event);" style="width:350px"
                           value="#{autorizacionServicioUsuarioBean.autoriserv.hauecobersalud}" immediate="true"
                           rendered="#{autorizacionServicioUsuarioBean.renderEntidadS}">
                <f:selectItems value="#{autorizacionServicioUsuarioBean.lstCobertura}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{autorizacionServicioUsuarioBean.renderEntidadS}">
                <t:message for="menuCoberturaS" styleClass="errorMessage"/>
             </a4j:outputPanel>
            <h:selectOneMenu id="menuCoberturaC" onkeydown="return blockEnter(event);" style="width:350px"
                           value="#{autorizacionServicioUsuarioBean.autoriserv.hauecobersalud}" immediate="true"
                           rendered="#{autorizacionServicioUsuarioBean.renderEntidadC}">
                <f:selectItems value="#{autorizacionServicioUsuarioBean.lstCobertura}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{autorizacionServicioUsuarioBean.renderEntidadC}">
                <t:message for="menuCoberturaC" styleClass="errorMessage"/>
             </a4j:outputPanel>
            <h:selectOneMenu id="menuCoberturaO" onkeydown="return blockEnter(event);" style="width:350px"
                           value="#{autorizacionServicioUsuarioBean.autoriserv.hauecobersalud}" immediate="true"
                           rendered="#{autorizacionServicioUsuarioBean.renderEntidadO}">
                <f:selectItems value="#{autorizacionServicioUsuarioBean.lstCobertura}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true" rendered="#{autorizacionServicioUsuarioBean.renderEntidadO}">
                <t:message for="menuCoberturaO" styleClass="errorMessage"/>
             </a4j:outputPanel>
          </h:panelGrid>
        </a4j:region>        
        </s:fieldset>

        <s:fieldset legend="Informaci�n de la Atenci�n y Servicios Solicitados" id="fieldDatosInformacion"
                    styleClass="fieldset">
          <h:panelGrid id="panelDatosInformacion" columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Origen de la Atenci�n" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value="Tipo de servicios solicitados" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:selectOneMenu id="menuAtencion" onkeydown="return blockEnter(event);" 
                           value="#{autorizacionServicioUsuarioBean.autoriserv.haunorigenate}">
              <f:selectItems value="#{autorizacionServicioUsuarioBean.lstOriAtencion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuAtencion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuTipoSrv" onkeydown="return blockEnter(event);" 
                        value="#{autorizacionServicioUsuarioBean.autoriserv.hauctipsersoli}" 
                        style="width:400px">
              <f:selectItems value="#{autorizacionServicioUsuarioBean.lstTipoSrv}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="menuTipoSrv" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Prioridad de la atenci�n" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value="Ubicaci�n del Paciente al momento de la solicitud de autorizacion:" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:selectOneRadio id="mnuPrioridad" onkeydown="return blockEnter(event);" required="true" immediate="true"
                          value="#{autorizacionServicioUsuarioBean.autoriserv.haucprioriaten}" style="width:300px">
               <f:selectItems value="#{autorizacionServicioUsuarioBean.lstPrioridad}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuPrioridad" styleClass="errorMessage"/>
            </a4j:outputPanel>

            <h:selectOneRadio id="mnuUbicacion" required="true" onkeydown="return blockEnter(event);"  
                           value="#{autorizacionServicioUsuarioBean.autoriserv.haueubicapacie}"
                           valueChangeListener="#{autorizacionServicioUsuarioBean.setUbicacionSelect}" 
                           style="width:400px" immediate="true">
               <f:selectItems value="#{autorizacionServicioUsuarioBean.lstUbicacion}"/>
               <a4j:support id="supUbicacion" action="#{autorizacionServicioUsuarioBean.changeUbicacion}"
                         reRender="panelTextServicio,panelInputServicio,panelTextCama,panelInputCama" event="onchange" immediate="true">
                 <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
               </a4j:support>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="mnuUbicacion" styleClass="errorMessage"/>
            </a4j:outputPanel>

            <h:panelGroup id="panelTextServicio" >
                <h:outputText value="Servicio" styleClass="labelTextOblig" 
                      rendered="#{autorizacionServicioUsuarioBean.renderUbicacion}"/>
            </h:panelGroup>
            <h:panelGroup id="panelText1" >
                <h:outputText value=" "
                  rendered="#{autorizacionServicioUsuarioBean.renderUbicacion}"/>
            </h:panelGroup>
            <h:panelGroup id="panelTextCama">
                <h:outputText value="Cama" styleClass="labelTextOblig"
                      rendered="#{autorizacionServicioUsuarioBean.renderUbicacion}"/>
            </h:panelGroup>
            <h:panelGroup id="panelText2" >
                <h:outputText value=" "
                   rendered="#{autorizacionServicioUsuarioBean.renderUbicacion}"/>
            </h:panelGroup>
            <h:panelGroup id="panelInputServicio" >
                <h:inputText value="#{autorizacionServicioUsuarioBean.autoriserv.haucservhospi}"
                             style="width:600px" immediate="true" id="inputServicio"
                             rendered="#{autorizacionServicioUsuarioBean.renderUbicacion}"/>
            </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                   <t:message for="inputServicio" styleClass="errorMessage"/>
                </a4j:outputPanel>
            <h:panelGroup id="panelInputCama">
                <h:inputText value="#{autorizacionServicioUsuarioBean.autoriserv.hauncamahospi}"
                         style="width:100px" immediate="true" id="inputCama"
                         rendered="#{autorizacionServicioUsuarioBean.renderUbicacion}"/>
            </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                    <t:message for="inputCama" styleClass="errorMessage"/>
                </a4j:outputPanel>
          </h:panelGrid>
          <h:panelGrid columns="1" styleClass="tabContainer" border="0" cellpadding="0" cellspacing="0"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Manejo Integral Segun Gu�a"/>
            <h:inputTextarea value="#{autorizacionServicioUsuarioBean.autoriserv.haucmansegugui}"
                             style="width:600px;height:60px" immediate="true"/>
          </h:panelGrid>

        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelGridSolicitudServicio">
          <s:fieldset legend="Selecci�n de Servicios" id="fieldServicios" styleClass="fieldset">
            <a4j:region id="regionSolicitudServicio" renderRegionOnly="false">
              <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosSolicitudServicio" rowClasses="labelText,labelTextInfo">
                <h:outputText value="Descripci�n del Servicio" styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Codigo CUPS" styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:outputText value="Cantidad Servicio" styleClass="labelTextOblig"/>
                <h:outputText value=" "/>
                <h:panelGroup>
                  <a4j:region renderRegionOnly="false">
                    <h:commandLink action="#{autorizacionServicioUsuarioBean.renderServicios}" immediate="true">
                      <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                    </h:commandLink>
                    <h:inputTextarea id="itServicios" value="#{autorizacionServicioUsuarioBean.servicioss}"
                                     valueChangeListener="#{autorizacionServicioUsuarioBean.setServicios}"
                                     onkeydown="return blockEnter(event);"
                                     disabled="#{autorizacionServicioUsuarioBean.deshabilitarServicios}"
                                     binding="#{autorizacionServicioUsuarioBean.itServicios}" style="width:300px">
                      <f:validateLength maximum="4000"/>
                    </h:inputTextarea>
                  </a4j:region>
                </h:panelGroup>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itServicios" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="itCodigo" value="#{autorizacionServicioUsuarioBean.cupsCodigo}"
                             binding="#{autorizacionServicioUsuarioBean.itCodigo}" onkeydown="return blockEnter(event);"
                             disabled="#{autorizacionServicioUsuarioBean.deshabilitarCodigo}"/>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCodigo" styleClass="errorMessage"/>
                </a4j:outputPanel>
                <h:inputText id="itCantidad" onkeydown="return blockEnter(event);"
                             value="#{autorizacionServicioUsuarioBean.cantidad}" style="width:50px"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="itCantidad" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelBotonAgregarAutorizacion" columnClasses="columnaBotones">
                <h:panelGroup>
                  <t:htmlTag value="br"/>
                  <a4j:commandButton value="Agregar" styleClass="btn btn btn-success"
                                     action="#{autorizacionServicioUsuarioBean.agregarAutorizacion}"
                                     reRender="panelGridAutorizacionTab"/>
                </h:panelGroup>
              </h:panelGrid>
            </a4j:region>
          </s:fieldset>
          <a4j:region renderRegionOnly="false">
            <s:fieldset legend="Servicios Seleccionados" id="fieldMedicamentosLista" styleClass="fieldset"
                        rendered="#{not empty autorizacionServicioUsuarioBean.lstServicioss}">
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelFormulacionTable">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="0" cellpadding="0" cellspacing="1"
                               binding="#{autorizacionServicioUsuarioBean.dtServicio}"
                               value="#{autorizacionServicioUsuarioBean.lstServicioss}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtServicio">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Codigo CUPS"/>
                      </f:facet>
                      <h:outputText value="#{item.hsencodigocups}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Cantidad"/>
                      </f:facet>
                      <h:outputText value="#{item.hsencantiservi}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Descripci�n"/>
                      </f:facet>
                      <h:outputText value="#{item.hsecnombreserv}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Editar"/>
                      </f:facet>
                      <a4j:commandLink id="editar" immediate="true" reRender="panelGridAutorizacionTab"
                                       action="#{autorizacionServicioUsuarioBean.editarServicios}">
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/editar.gif"/>
                      </a4j:commandLink>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <h:commandLink id="eliminar" immediate="true"
                                     action="#{autorizacionServicioUsuarioBean.eliminarServicios}">
                        <t:graphicImage alt="" border="0" url="/comun/imagenes/Delete.png"/>
                      </h:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtServicio" fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                    paginatorMaxPages="9" paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionServicioMsg" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgServicioMsg" showSummary="false" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
        </h:panelGrid>

        <h:panelGrid columns="2" styleClass="tabContainer" border="0" cellpadding="0" cellspacing="0"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Justificaci�n Clinica" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:inputTextarea id="itJustifica" value="#{autorizacionServicioUsuarioBean.autoriserv.haucjustifclin}"
                            required="true" style="width:600px;height:60px" immediate="true"/>
            <a4j:outputPanel ajaxRendered="true">
               <t:message for="itJustifica" styleClass="errorMessage"/>
            </a4j:outputPanel>
        </h:panelGrid>
        <s:fieldset legend="Impresi�n Diagnostica" id="fieldDatosImpresion" styleClass="fieldset">
          <h:panelGrid columns="2" styleClass="tabContainer" border="0" cellpadding="0" cellspacing="0"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Diagnostico Principal" styleClass="labelTextOblig"/>
            <h:outputText value=""/>

            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink immediate="true" action="#{autorizacionServicioUsuarioBean.mostrarDiagnosticoPrincipal}"
                               reRender="panelGridAutorizacionTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagPrin" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                           value="#{autorizacionServicioUsuarioBean.autoriserv.haucdiagnprinc}"
                           disabled="#{autorizacionServicioUsuarioBean.desHabilitarDiagnosticoPrincipal}"
                           valueChangeListener="#{autorizacionServicioUsuarioBean.setHaucdiagnprinc}" 
                           style="width:50px"
                           maxlength="4" immediate="true"
                           binding="#{autorizacionServicioUsuarioBean.inputDiagnostico}">
                <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportitDiagPrin" immediate="true" event="onchange" ignoreDupResponses="true"
                             action="#{autorizacionServicioUsuarioBean.changeDiagnosticoPrincipal}"
                             reRender="panelDiagnosticoPrincipal">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoPrincipal">
                <h:outputText value=" #{autorizacionServicioUsuarioBean.descDiagnostico}" styleClass="buscador"/>
              </h:panelGrid>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagPrin" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>

            <h:outputText value=""/>
            <h:outputText value="Diagnostico Relacionado Uno (1)"/>
            <h:outputText value=""/>
            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink immediate="true" action="#{autorizacionServicioUsuarioBean.mostrarDiagnosticoRelacionado1}"
                               reRender="panelGridAutorizacionTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagnosticoRelacionado1" onkeydown="return blockEnter(event);"
                           styleClass="textmayuscula" value="#{autorizacionServicioUsuarioBean.autoriserv.haucdiagrelac1}"
                           valueChangeListener="#{autorizacionServicioUsuarioBean.setHaucdiagrelac1}" style="width:50px"
                           maxlength="4" immediate="true"
                           disabled="#{autorizacionServicioUsuarioBean.disableRel1}"
                           binding="#{autorizacionServicioUsuarioBean.inputDiagnostico1}">
                             <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado1" immediate="true" event="onchange"
                             action="#{autorizacionServicioUsuarioBean.changeDiagnosticoRelacionado1}"
                             reRender="panelDiagnosticoRelacionado1">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
                  <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado1" styleClass="errorMessage"/>
              </a4j:outputPanel>
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado1">
                <h:outputText value="#{autorizacionServicioUsuarioBean.descDiagnostico1}" styleClass="buscador"/>
              </h:panelGrid>
            </h:panelGrid>

            <h:outputText value=""/>
            <h:outputText value="Diagnostico Relacionado Dos (2)"/>
            <h:outputText value=""/>

            <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0">
              <a4j:commandLink immediate="true" action="#{autorizacionServicioUsuarioBean.mostrarDiagnosticoRelacionado2}"
                               reRender="panelGridAutorizacionTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
              </a4j:commandLink>
              <h:inputText id="itDiagnosticoRelacionado2" styleClass="textmayuscula"
                           value="#{autorizacionServicioUsuarioBean.autoriserv.haucdiagrelac2}"
                           onkeydown="return blockEnter(event);"
                           valueChangeListener="#{autorizacionServicioUsuarioBean.setHaucdiagrelac2}" style="width:50px"
                           maxlength="4" immediate="true"
                           disabled="#{autorizacionServicioUsuarioBean.disableRel2}"
                           binding="#{autorizacionServicioUsuarioBean.inputDiagnostico2}">
                             <f:converter converterId="cadena.stringUpperCaseConverter"/>
                <a4j:support id="supportDiagnosticoRelacionado2" immediate="true" event="onchange"
                             action="#{autorizacionServicioUsuarioBean.changeDiagnosticoRelacionado2}"
                             reRender="panelDiagnosticoRelacionado2">
                  <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                </a4j:support>
              </h:inputText>
              <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelDiagnosticoRelacionado2">
                <h:outputText value="  #{autorizacionServicioUsuarioBean.descDiagnostico2}"
                              styleClass="buscador"/>
              </h:panelGrid>
              <a4j:outputPanel ajaxRendered="true">
                <t:message for="itDiagnosticoRelacionado2" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGrid>
          </h:panelGrid>
        </s:fieldset>

        <s:fieldset legend="Informacion de la persona que solicita" id="fieldDatosSolicita" styleClass="fieldset">
          <h:panelGrid id="panelGridDatosSolicita" columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Tel�fono" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value="Extensi�n"/>
            <h:outputText value=" "/>
            <h:inputText value="#{autorizacionServicioUsuarioBean.autoriserv.hauctelinform}"
                        required="true" style="width:150px" immediate="true" id="textTelinform"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textTelinform" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText value="#{autorizacionServicioUsuarioBean.autoriserv.haucextinform}"
                             style="width:70px" immediate="true" id="textExtinform"/>
            <h:outputText value=" "/>
            <h:outputText value="Celular" styleClass="labelTextOblig"/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:outputText value=" "/>
            <h:inputText value="#{autorizacionServicioUsuarioBean.autoriserv.hauccelinform}"
                         required="true" style="width:150px" immediate="true" id="textCelinform"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="textCelinform" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGrid>
        </s:fieldset>

          <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionAutorizacionMsg" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgAutorizacionMsg" showSummary="false" errorClass="error" globalOnly="true"
                          layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>

         <a4j:commandLink id="mostrarAutorizacion" action="#{autorizacionServicioUsuarioBean.generarPDF}"
                           rendered="#{autorizacionServicioUsuarioBean.modo_consulta}"
                             reRender="panelGridAutorizacionTab" immediate="true"
                             title="Imprimir Autorizacion">
              <t:graphicImage alt="Imprimir Autorizacion" title="Imprimir Autorizacion" border="0"
                              url="/comun/imagenes/imprimir.jpg"/>
            </a4j:commandLink>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonBotonesControl"
                     columnClasses="panelGridBotones">
          <a4j:commandButton value="Generar Autorizacion" styleClass="btn btn btn-success"
                             reRender="panelGridAutorizacionTab"
                             action="#{autorizacionServicioUsuarioBean.generarAutorizacion}" disabled="#{autorizacionServicioUsuarioBean.deshabilitaBoton}"/>
        </h:panelGrid>
        </s:fieldset>
      </h:panelGrid>


      <f:subview id="generarAutorizacion" rendered="#{autorizacionServicioUsuarioBean.generoAutorizacion}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
        </f:verbatim>
      </f:subview>
    </t:panelTab>

      <t:panelTab id="panelBuscadorServicios" label="Buscar Servicios"
                  rendered="#{autorizacionServicioUsuarioBean.renderBuscador}">
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
          <h:panelGrid id="panelGridMedicamentosBotones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
               <a4j:region renderRegionOnly="false">
            <h:panelGroup id="panelGroupMedicamentosBotones1">
         
              <a4j:commandButton value="Aceptar" immediate="true"
                                styleClass="btn btn btn-success" reRender="panelGridAutorizacionTab"
                               action="#{autorizacionServicioUsuarioBean.aceptarServicio}">
                </a4j:commandButton>
                
            </h:panelGroup>
            </a4j:region>
          </h:panelGrid>
        </a4j:region>
      </t:panelTab>

      <t:panelTab id="panelBuscador" label="Buscar Diagnosticos"
                rendered="#{autorizacionServicioUsuarioBean.mostrarCie10}">
        <a4j:region id="regionCie10" renderRegionOnly="false">
          <a4j:status id="statusButton" for="regionCie10">
            <f:facet name="start">
              <t:div id="chargingCie10" styleClass="loading">
                <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                  <h:outputText value="Procesando..."/>
                  <h:outputText value="Por favor espere."/>
                </h:panelGrid>
              </t:div>
            </f:facet>
            <f:facet name="stop"/>
          </a4j:status>
          <jsp:include page="/pages/clinico/registro/buscadorCie10.jsp" flush="true"/>
          <h:panelGrid id="panelGridCie10Botones" width="100%" columnClasses="columnaBotonesCentrados" dir="RTL">
            <t:htmlTag value="br"/>
            <h:panelGroup id="panelGroupCie10Botones1">
              <a4j:commandButton value="Aceptar" styleClass="btn btn btn-success"
                                 action="#{autorizacionServicioUsuarioBean.aceptarDiagnostico}"
                               reRender="panelGridAutorizacionTab">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:commandButton>
            </h:panelGroup>
          </h:panelGrid>
        </a4j:region>
      </t:panelTab>


  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
       

</script>

</h:panelGrid>
