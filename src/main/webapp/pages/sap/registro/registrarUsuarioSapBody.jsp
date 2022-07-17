<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formDatosSAPUsuarios">
  <a4j:region id="regionDatosSapUsuarios" renderRegionOnly="false">
   <a4j:status id="statusButton" for="regionDatosSapUsuarios">
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
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneDatosSAPUsuario" styleClass="tabbedPane"
                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                       selectedIndex="#{registarUsuarioSapBean.selectedIndex}" inactiveSubStyleClass="inactiveSub"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabDatosSAPUsuario" label="Datos Usuario(a)"
                  rendered="#{!registarUsuarioSapBean.renderSelecionarUsuario}">
        <a4j:commandLink action="#{registarUsuarioSapBean.resetDatos}" reRender="formDatosSAPUsuarios"
                         title="Registrar Nuevo Usuario">
          <t:graphicImage alt="Registrar Nuevo Usuario" title="Registrar Nuevo Usuario" border="0"
                          url="/comun/imagenes/nuevo.jpg"/>
        </a4j:commandLink>
       
       
       
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" styleClass="tabcontainer"
                     id="panelGridServiciosSapTab">
          <s:fieldset legend="Consulta de Servicios" id="fieldSetInfoServicio" styleClass="fieldset">
            <h:panelGrid columns="1" id="panelGridConsultarFoliosMedico"
                         rendered="#{empty informacionServicioBean.ltsTarifaServicio}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" id="panelGridEmpresa"
                         rendered="#{not empty informacionServicioBean.ltsTarifaServicio}" width="100%"
                         style="text-align:center;">
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
                      <h:panelGrid columns="14" border="0" cellpadding="0" cellspacing="2" width="550"
                                   id="panelGridDias">
                        <h:panelGrid columns="1" width="78">
                          <h:outputLabel value="Tipo de Lista" style="font-weight:bold; font-size:7.0pt;"/>
                        </h:panelGrid>
                        <h:outputText value="Valor"/>
                        <h:outputText value="Valor Descuento"/>
                        <h:outputText value="Total"/>
                      </h:panelGrid>
                    </f:facet>
                    <h:panelGrid columns="10" border="0" cellpadding="2" cellspacing="2" width="620"
                                 id="panelGridProg12">
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
        </h:panelGrid>
      
  
        
        <s:fieldset legend="Datos Basicos Usuario" id="fieldSetInfoSAPBasica" styleClass="fieldset">
          <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelRegionInfoSAPConsulta" rowClasses="labelText,labelTextInfo">
            <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value=" Número Identificación" styleClass="labelTextOblig"/>
            <h:outputText value=""/>
            <h:outputText value="Número Usuario"/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:outputText value=""/>
            <h:selectOneMenu id="tipoIde"
                             disabled="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             value="#{registarUsuarioSapBean.usuario.husetipoiden}"
                             onkeydown="return blockEnter(event);">
              <f:selectItems value="#{registarUsuarioSapBean.listTipoIdentificacion}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="tipoIde" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
              
              <h:inputText id="itNumeroIdentificacion" maxlength="15"
                           disabled="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                           value="#{registarUsuarioSapBean.usuario.husanumeiden}" required="true"  onkeypress="searchByEnterAndReturn(event)" 
                           />
                           <a4j:commandButton value="Buscar" oncomplete="numeroJs()" id="BtnBuscar"
                                 disabled="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                                 action="#{registarUsuarioSapBean.buscadorUsuario}" reRender="formDatosSAPUsuarios" 
                                 image="/comun/imagenes/lupa.gif"/>
                                 
            </h:panelGrid>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itNumeroIdentificacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText id="idtipo" value="#{registarUsuarioSapBean.usuario.huslnumero}"></h:outputText>
            <h:outputText/>
            <h:outputText/>
            <h:outputText/>
            <h:outputText value="Primer Nombre" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Segundo Nombre"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Primer Apellido" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Segundo Apellido" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:inputText id="primerNombre" onkeydown="return blockEnter(event);" maxlength="20" styleClass="textmayuscula"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         disabled="#{registarUsuarioSapBean.renderUsuario}"
                         value="#{registarUsuarioSapBean.usuario.huscprimernomb}">
                    
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="primerNombre" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="segundoNombre" onkeydown="return blockEnter(event);" styleClass="textmayuscula"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         disabled="#{registarUsuarioSapBean.renderUsuario}"
                         value="#{registarUsuarioSapBean.usuario.huscsegundnomb}" maxlength="20">
                       
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="segundoNombre" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="primerApellido" onkeydown="return blockEnter(event);" maxlength="20" styleClass="textmayuscula" 
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         disabled="#{registarUsuarioSapBean.renderUsuario}"
                         value="#{registarUsuarioSapBean.usuario.huscprimerapel}">
                        
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="primerApellido" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="segundoApellido" onkeydown="return blockEnter(event);" maxlength="20" styleClass="textmayuscula"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         disabled="#{registarUsuarioSapBean.renderUsuario}"
                         value="#{registarUsuarioSapBean.usuario.huscsegundapel}">
                        
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="segundoApellido" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Fecha Nacimiento" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Edad" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Sexo" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Escolaridad" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <t:inputCalendar id="fechaNacimiento"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy"
                             currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                             disabled="false" value="#{registarUsuarioSapBean.usuario.husdfechanacim}"
                             popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top">
              <f:validator validatorId="dateMenorActualValidator"/>
              <a4j:support id="supportNacimiento" event="onchange" reRender="panelEdad">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </t:inputCalendar>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="fechaNacimiento" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="panelEdad">
              <h:inputText id="inputEdad" onkeydown="return blockEnter(event);" maxlength="4" disabled="true"
                           rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                           value="#{registarUsuarioSapBean.usuario.edad}"/>
            </h:panelGroup>
            <h:outputText value=""/>
            <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             value="#{registarUsuarioSapBean.usuario.husesexo}">
              <f:selectItems value="#{registarUsuarioSapBean.listSexos}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="radioSexo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="itNivelEducativo" value="#{registarUsuarioSapBean.usuario.husnniveledu}"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <f:selectItems value="#{registarUsuarioSapBean.lstNivelEducativo}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="itNivelEducativo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Estrato "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Estado Civil"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Correo Electrónico"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Etnia"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:selectOneRadio id="mnuEstrato" onkeydown="return blockEnter(event);"
                              rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                              value="#{registarUsuarioSapBean.usuario.husnestrato}">
              <f:selectItems value="#{registarUsuarioSapBean.listEstrato}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="mnuEstrato" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             value="#{registarUsuarioSapBean.usuario.huseestadcivil}">
              <f:selectItems value="#{registarUsuarioSapBean.listEstadoCivil}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="radioEstadoCivil" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="itCorreo" maxlength="30" onkeydown="return blockEnter(event);"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         value="#{registarUsuarioSapBean.usuario.husccorreoelec}"/>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="itCorreo" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="radioEtnia" onkeydown="return blockEnter(event);"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             value="#{registarUsuarioSapBean.usuario.huscetnia}">
              <f:selectItems value="#{registarUsuarioSapBean.lstEtnia}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="radioEtnia" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Dirección"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                          styleClass="labelTextOblig"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Barrio "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                          styleClass="labelTextOblig"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Teléfono"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                          styleClass="labelTextOblig"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Teléfono Movil" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:inputText id="Direccion" maxlength="20" onkeydown="return blockEnter(event);"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         value="#{registarUsuarioSapBean.usuario.huscdireccion}">
                        
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="Direccion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="itBarrio" onkeydown="return blockEnter(event);" maxlength="20"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         value="#{registarUsuarioSapBean.usuario.huscbarrio}">
                        
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="itBarrio" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="Telefono" maxlength="20" onkeydown="return blockEnter(event);"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         value="#{registarUsuarioSapBean.usuario.husctelefono}">
                       
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="Telefono" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:inputText id="TelefonoMovil" maxlength="20" onkeydown="return blockEnter(event);" 
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         value="#{registarUsuarioSapBean.usuario.husccelular}">
                        
                         </h:inputText>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="TelefonoMovil" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="País de residencia habitual" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Departamento" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Municipio" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=""
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Tipo de Afiliación" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>

            <h:selectOneMenu id="menuPais" onkeydown="return blockEnter(event);"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                          value="#{registarUsuarioSapBean.usuario.huscpaisresi}">
               <f:selectItems value="#{registarUsuarioSapBean.listPaises}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
                <t:message for="menuPais" styleClass="errorMessage"/>
          </a4j:outputPanel>

            <h:selectOneMenu id="menuDepartamentos" onkeydown="return blockEnter(event);"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             value="#{registarUsuarioSapBean.usuario.husndepartamen}"
                             valueChangeListener="#{registarUsuarioSapBean.setDepartamentoSelect}">
              <f:selectItems value="#{registarUsuarioSapBean.listDepartamentos}"/>
              <a4j:support id="support7" action="#{registarUsuarioSapBean.changeCiudad}"
                           reRender="panelRegionInfoSAPConsulta" event="onchange">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="menuDepartamentos" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuCiudad" onkeydown="return blockEnter(event);"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             value="#{registarUsuarioSapBean.usuario.husnciudad}">
              <f:selectItems value="#{registarUsuarioSapBean.listMunicipios}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="menuCiudad" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:selectOneMenu id="menuAfiliacion" onkeydown="return blockEnter(event);"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             value="#{registarUsuarioSapBean.usuario.husetipoafilia}"
                             immediate="true"
                             valueChangeListener="#{registarUsuarioSapBean.setHusetipoafilia}">
              <f:selectItems value="#{registarUsuarioSapBean.listTipoAfiliacion}"/>
              <a4j:support id="supportAfiliacion" event="onchange" immediate="true"
                               action="#{registarUsuarioSapBean.changeAfiliacion}"
                               reRender="panelInputEps,paneltextEps,paneltextAfili,panelInputAfili,paneltextVincula,panelRadioVincula">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="menuAfiliacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup id="paneltextEps">
            <h:outputText value="EPS" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.mostrarAfiliacion}"/>
            </h:panelGroup>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
                      <h:panelGroup id="paneltextAfili">
            <h:outputText value="Número de Afiliación" 
                         rendered="#{registarUsuarioSapBean.mostrarAfiliacion}"/>
                     </h:panelGroup>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
                          <h:panelGroup id="paneltextVincula">
            <h:outputText value="Tipo de Vinculación" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.mostrarAfiliacion}"/>
                        </h:panelGroup>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Como conoce de Profamilia" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:panelGroup id="panelInputEps" rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <a4j:region renderRegionOnly="false">
                <h:inputText id="itEps" value="#{registarUsuarioSapBean.usuario.huscentidadadm}"
                             valueChangeListener="#{registarUsuarioSapBean.setEps}" immediate="true"
                             binding="#{registarUsuarioSapBean.itEps}" style="width:100px" styleClass="textmayuscula"
                             rendered="#{registarUsuarioSapBean.mostrarAfiliacion}">
                  <f:validateLength maximum="40"/>
                   <a4j:support id="supportitDiagPrin" event="onchange"
                                     action="#{registarUsuarioSapBean.changeSeleccionEps}"
                                     reRender="panelEpsSeleccion" immediate="true">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                </h:inputText>
                <h:commandLink action="#{registarUsuarioSapBean.renderEps}" rendered="#{registarUsuarioSapBean.mostrarAfiliacion}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif" />
                </h:commandLink>
               
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelEpsSeleccion" rendered="#{registarUsuarioSapBean.mostrarAfiliacion}">
                  <h:outputText value=" #{registarUsuarioSapBean.seleccionEps}" styleClass="buscador"  />
                </h:panelGrid>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itEps" styleClass="errorMessage"/>
            </a4j:outputPanel>
                          <h:panelGroup id="panelInputAfili">
            <h:inputText id="itNumeroAfiliacion" onkeydown="return blockEnter(event);" maxlength="20"
                         rendered="#{registarUsuarioSapBean.mostrarAfiliacion}"
                         value="#{registarUsuarioSapBean.usuario.huscnumafiliac}" ></h:inputText>
           
             </h:panelGroup>
             <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="itNumeroAfiliacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
          
             <h:panelGroup id="panelRadioVincula">
            <h:selectOneRadio id="radioVinculacion" onkeydown="return blockEnter(event);"
                              rendered="#{registarUsuarioSapBean.mostrarAfiliacion}"
                              value="#{registarUsuarioSapBean.usuario.husetipvincula}">
              <f:selectItems value="#{registarUsuarioSapBean.lstTipoVinculacion}"/>
            </h:selectOneRadio>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="radioVinculacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
            <h:selectOneMenu id="menuConoceProfamilia" value="#{registarUsuarioSapBean.usuario.husnconoprofam}"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             onkeydown="return blockEnter(event);">
              <f:selectItems value="#{registarUsuarioSapBean.lstConoceProfamilia}"/>
            </h:selectOneMenu>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="menuConoceProfamilia" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:outputText value="Zona " styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Ocupación" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Tipo de Cliente" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:panelGroup id="paneltextOtroTipoCliente">
                <h:outputText value="Numero de Contrato" styleClass="labelTextOblig" rendered="#{registarUsuarioSapBean.mostrarContrato}"/>
              </h:panelGroup>
                          
            <h:outputText value=" "
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:selectOneRadio id="radioZona" onkeydown="return blockEnter(event);"
                              rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                              value="#{registarUsuarioSapBean.usuario.husezonareside}">
              <f:selectItems value="#{registarUsuarioSapBean.listzona}"/>
            </h:selectOneRadio>
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="radioZona" styleClass="errorMessage"/>
            </a4j:outputPanel>
            <h:panelGroup rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <a4j:region renderRegionOnly="false">
              
                <h:inputText id="itOcupacion" value="#{registarUsuarioSapBean.usuario.husnocupacion}"
                             valueChangeListener="#{registarUsuarioSapBean.setOcupacion}"
                             binding="#{registarUsuarioSapBean.itOcupacion}" immediate="true" 
                             style="width:100px">
                  <f:validateLength maximum="40"/>
                <a4j:support id="supportOcupa" event="onchange"
                                     action="#{registarUsuarioSapBean.changeSeleccionOcupacion}"
                                     reRender="panelOcupacionSeleccion" immediate="true">
                          <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                        </a4j:support>
                
                </h:inputText>
                  <h:commandLink action="#{registarUsuarioSapBean.renderOcupacion}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/lupa.gif"/>
                </h:commandLink>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="2" id="panelOcupacionSeleccion">
                  <h:outputText value=" #{registarUsuarioSapBean.seleccionOcupacion}" styleClass="buscador"/>
                </h:panelGrid>
              </a4j:region>
            </h:panelGroup>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="itOcupacion" styleClass="errorMessage"/>
            </a4j:outputPanel>
           
            <h:panelGroup>
                   <h:selectOneMenu id="menuCliente" value="#{registarUsuarioSapBean.usuario.husetipcliente}"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             onkeydown="return blockEnter(event);" immediate="true"
                             valueChangeListener="#{registarUsuarioSapBean.setHusetipcliente}">
              <f:selectItems value="#{registarUsuarioSapBean.listTipoCliente}"/>
              <a4j:support id="supportContratoCredito" event="onchange" immediate="true"
                               action="#{registarUsuarioSapBean.changeContrato}"
                               reRender="panelInputOtroTipoCliente,paneltextOtroTipoCliente">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:support>
            </h:selectOneMenu>
            </h:panelGroup>
              
    
            
            <a4j:outputPanel ajaxRendered="true"
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
              <t:message for="menuCliente" styleClass="errorMessage"/>
            </a4j:outputPanel>
            
              <h:panelGroup id="panelInputOtroTipoCliente">
                <h:inputText id="inputOtroTipoCliente" maxlength="50" onkeydown="return blockEnter(event);" 
                             required="false"
                            
                             rendered="#{registarUsuarioSapBean.mostrarContrato}"
                             value="#{registarUsuarioSapBean.usuario.husnnumecontr}"/>
                             
                              <a4j:outputPanel ajaxRendered="true">
                  <t:message for="inputOtroTipoCliente" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGroup>
          </h:panelGrid>
        </s:fieldset>
        <s:fieldset legend="Datos Acompañante" id="fieldSetInfoAcompaAsesoria" styleClass="fieldset"
                    rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
          <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoAcompa"
                       rowClasses="labelText,labelTextInfo">
            <h:outputText value="Acompañante" styleClass="labelTextOblig"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Teléfono Acompañante"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:outputText value="Parentesco Acompañante"
                          rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"/>
            <h:panelGroup>
              <h:inputText id="itAcom" maxlength="40" onkeydown="return blockEnter(event);" styleClass="labelTextOblig, textmayuscula"
                           rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                           
                           value="#{registarUsuarioSapBean.usuario.huscnomacompana}">
                           
                           </h:inputText>
              <a4j:outputPanel ajaxRendered="true"
                               rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}">
                <t:message for="itAcom" styleClass="errorMessage"/>
              </a4j:outputPanel>
            </h:panelGroup>
            <h:panelGroup>
            <h:inputText onkeydown="return blockEnter(event);" maxlength="20" id="telAcomp"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         value="#{registarUsuarioSapBean.usuario.husctelacompana}">
                        
                         </h:inputText>
                          <t:message for="telAcomp" styleClass="errorMessage"/>
                          </h:panelGroup>
                          <h:panelGroup>
            <h:inputText onkeydown="return blockEnter(event);" maxlength="20" id="resAcomp"
                         rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                         value="#{registarUsuarioSapBean.usuario.huscparresponsa}">
                         
                         </h:inputText>
                          <t:message for="resAcomp" styleClass="errorMessage"/>
                          </h:panelGroup>
            <h:outputText/>
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMensajesRegistrarUsuario" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInfRegistrarUsuario" showSummary="true" errorClass="error" globalOnly="true"
                            layout="table" infoClass="registrar"/>
              </a4j:outputPanel>
            </h:panelGroup>
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
                             rendered="#{registarUsuarioSapBean.renderUsuario || registarUsuarioSapBean.renderRegistrar}"
                             action="#{registarUsuarioSapBean.invokeCreaCLienteWS}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </t:panelTab>
      
      <t:panelTab id="panelTabSeleccionarUsuario" label="Seleccionar Usuario"
                  rendered="#{registarUsuarioSapBean.renderSelecionarUsuario}">
        <s:fieldset legend="Usuarios Activos" id="fieldSetSeleccionarUsuario" styleClass="fieldset_dataTable">
          <h:panelGrid columns="1" id="panelGridSeleccionarUsuario"
                       rendered="#{empty registarUsuarioSapBean.lstUsuariosActivos}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentSeleccionarUsuario" rendered="#{not empty registarUsuarioSapBean.lstUsuariosActivos}"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                           binding="#{registarUsuarioSapBean.dtConsultaUsuario}"
                           value="#{registarUsuarioSapBean.lstUsuariosActivos}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="dtSeleccionarUsuarios">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Numero Documento"/>
                  </f:facet>
                  <h:outputText value="#{item.husetipoiden} #{item.husanumeiden}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.huscprimernomb} #{item.huscsegundnomb} #{item.huscprimerapel} #{item.huscsegundapel}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Fecha de Nacimiento"/>
                  </f:facet>
                  <h:outputText value="#{item.husdfechanacim}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Numero de Usuario"/>
                  </f:facet>
                  <h:outputText value="#{item.huslnumero}"/>
                </h:column>
                 <h:column>
                  <f:facet name="header">
                    <h:outputText value="Estado Usuario"/>
                  </f:facet>
                  <h:outputText value="#{item.huseestado}"/>
                </h:column>                
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Seleccione"/>
                  </f:facet>
                  <h:commandLink id="aceptar" action="#{registarUsuarioSapBean.agregarUsuario}">
                    <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                  </h:commandLink>
                </h:column>
              </h:dataTable>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll_1" for="dtSeleccionarUsuarios" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" paginatorMaxPages="9"
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
        
        
          <s:fieldset legend="Usuarios Inactivos" id="fieldSetSeleccionarUsuarioInactivo" styleClass="fieldset_dataTable">
          <h:panelGrid columns="1" id="panelGridSeleccionarUsuarioInactivo"
                       rendered="#{empty registarUsuarioSapBean.lstUsuariosInactivos}">
            <h:outputText value="#{msg.msg_sin_consultar}"/>
          </h:panelGrid>
          
          <h:outputText value="Si el usuario que va a seleccionar esta en la siguiente lista por favor comunicarse con la administración del centro" style="color:red;font-size:14px" />
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableContentSeleccionarUsuarioInactivo" rendered="#{not empty registarUsuarioSapBean.lstUsuariosInactivos}"
                       styleClass="tabContainer">
            <t:buffer into="#{table}">
              <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                       
                           value="#{registarUsuarioSapBean.lstUsuariosInactivos}" rows="10" styleClass="standard_table"
                           rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                           id="dtSeleccionarUsuariosInactivos">
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Numero Documento"/>
                  </f:facet>
                  <h:outputText value="#{item.husetipoiden} #{item.husanumeiden}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Nombre"/>
                  </f:facet>
                  <h:outputText value="#{item.huscprimernomb} #{item.huscsegundnomb} #{item.huscprimerapel} #{item.huscsegundapel}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Fecha de Nacimiento"/>
                  </f:facet>
                  <h:outputText value="#{item.husdfechanacim}"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Numero de Usuario"/>
                  </f:facet>
                  <h:outputText value="#{item.huslnumero}"/>
                </h:column>
                 <h:column>
                  <f:facet name="header">
                    <h:outputText value="Estado Usuario"/>
                  </f:facet>
                  <h:outputText value="#{item.huseestado}"/>
                </h:column>                
              
              </h:dataTable>
            </t:buffer>
      
          
            <h:outputText value="#{table}" escape="false"/>
          
          </h:panelGrid>
        </s:fieldset>
        
        
        
        
        
        <s:fieldset legend="Usuario Seleccionado" id="fieldUsuarioSelecc" styleClass="fieldset">
          <h:outputText value="#{registarUsuarioSapBean.usuario.huscprimernomb} #{registarUsuarioSapBean.usuario.huscsegundnomb}  #{registarUsuarioSapBean.usuario.huscprimerapel}  #{registarUsuarioSapBean.usuario.huscsegundapel}"
                        escape="false"/>
        </s:fieldset>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelBotonSeleccionarUsuario" columnClasses="panelGridBotones">
          <h:panelGroup>
            <h:commandButton value="Seleccionar Usuario" styleClass="boton_fieldset"
                             action="#{registarUsuarioSapBean.seleccionarUsuario}">
              <a4j:support event="onclick" status="statusButton"/>
            </h:commandButton>
          </h:panelGroup>
        </h:panelGrid>
      </t:panelTab>
   
      <h:commandLink action="#{registarUsuarioSapBean.volver}" immediate="true">
        <t:graphicImage id="imageVolver" alt="volver" border="0" url="/comun/imagenes/volver.gif"/>
      </h:commandLink>
      <t:panelTab id="panelBuscadorMedicamentos" label="Buscar Entidad Administradora"
                  rendered="#{registarUsuarioSapBean.renderBuscador}">
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
            <jsp:include page="/pages/clinico/comunes/buscador/buscadorEPS.jsp" flush="true"/>
          </a4j:region>
        
        </a4j:region>
      </t:panelTab>
      <t:panelTab id="panelBuscadorMedicamentos1" label="Buscar Ocupación"
                  rendered="#{registarUsuarioSapBean.renderBuscadorOcupacion}">
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
            <jsp:include page="/pages/clinico/comunes/buscador/buscadorOcupacion.jsp" flush="true"/>
          </a4j:region>
   
        </a4j:region>
      </t:panelTab>
    </t:panelTabbedPane>
  </a4j:region>
    <script language="javascript" type="text/javascript">
        document.forms[1].elements[5].focus()
</script>
</a4j:form>
