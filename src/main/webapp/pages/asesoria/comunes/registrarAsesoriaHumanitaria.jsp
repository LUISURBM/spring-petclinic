<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarOtraAsesoriaTab"
             styleClass="tabContainer">
  <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneDatosOtraAsesoria" styleClass="tabbedPane"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     selectedIndex="#{registrarAsesoriaHumanitariaBean.selectedIndex}"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosOtraAsesoria" label="Datos Usuario(a)"
                rendered="#{!registrarAsesoriaHumanitariaBean.renderSelecionarUsuario}">
      <a4j:commandLink action="#{registrarAsesoriaHumanitariaBean.resetDatos}"
                       reRender="panelGridRegistrarOtraAsesoriaTab" title="Registrar Nuevo Usuario(a)">
        <t:graphicImage alt="Registrar Nuevo Usuario(a)" title="Registrar Nuevo Usuario(a)" border="0"
                        url="/comun/imagenes/nuevo.jpg"/>
      </a4j:commandLink>
      
            <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionAsesoriaHumanitariaMsg" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgAsesoriaHumanitariaMsg" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
      
      <s:fieldset legend="Información asesoría" id="fieldSetInfoAsesoriaEncabezado" styleClass="fieldset">
        <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionInfoAsesoriaEncabezado" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Fecha asesoría" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Financiador" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <t:inputCalendar id="fechaAsesoriaHumanitaria" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                           title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                           renderAsPopup="true" disabled="false"
                           value="#{registrarAsesoriaHumanitariaBean.actividad.haedfechases}" popupTodayString="Hoy"
                           popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                           align="top">
            <f:validator validatorId="dateMenorActualValidator"/>
          </t:inputCalendar>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaAsesoriaHumanitaria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:selectOneMenu id="menuDonanteAsesoriaHumanitaria" onkeydown="return blockEnter(event);" required="false"
                           value="#{registrarAsesoriaHumanitariaBean.wfinanciador}">
            <f:selectItems value="#{registrarAsesoriaHumanitariaBean.lstDonantes}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="menuDonanteAsesoriaHumanitaria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Tipo de asesoría" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:outputText value=""/>
          <h:selectManyCheckbox required="false" style="border-style:none;" immediate="true" 
                            id="mnuTipoAsesoria"
                                value="#{registrarAsesoriaHumanitariaBean.lstTipoAsesoriaSelect}"
                                layout="pageDirection">
            <f:selectItems value="#{registrarAsesoriaHumanitariaBean.lstTipoAsesoria}"/>
          </h:selectManyCheckbox>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuTipoAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGrid>
      </s:fieldset>
      <s:fieldset legend="Asesoria Humanitaria " id="fieldSetInfoBasicaOtraAsesoria" styleClass="fieldset">
        <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionInfoOtraAsesoria" rowClasses="labelText,labelTextInfo">
          <h:outputText value="Tipo Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value=" Número Identificación" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Número Usuario" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:panelGroup>
            <h:outputText/>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:selectOneMenu id="tipoIdeOtraAsesoria"
                           value="#{registrarAsesoriaHumanitariaBean.asesoria.hahetipoiden}"
                           onkeydown="return blockEnter(event);">
            <f:selectItems value="#{registrarAsesoriaHumanitariaBean.listTipoIdentificacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="tipoIdeOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0">
       
                <h:inputText id="itNumeroIdentificacionOtraAsesoria" maxlength="15" 
                         binding="#{registrarAsesoriaHumanitariaBean.itNumeroIdentificacion}"
                         value="#{registrarAsesoriaHumanitariaBean.asesoria.hahanumeiden}"
                         valueChangeListener="#{registrarAsesoriaHumanitariaBean.setHahanumeiden}"
                         onkeydown="return blockEnter(event);">
                        <a4j:support id="supportIdentificacion" event="onchange" oncomplete="numeroJs()"
                            action="#{registrarAsesoriaHumanitariaBean.buscadorUsuario}"
                           reRender="panelGridRegistrarOtraAsesoriaTab">
                             <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                     </a4j:support>
                         
            </h:inputText>
           
          </h:panelGrid>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroIdentificacionOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="idtipoOtraAsesoria" maxlength="12" disabled="true"
                       value="#{registrarAsesoriaHumanitariaBean.asesoria.hahlnumusu}"
                       onkeydown="return blockEnter(event);"></h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="idtipoOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText/>
          <h:outputText/>
          <h:outputText value="Primer Nombre" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Segundo Nombre"/>
          <h:outputText value=""/>
          <h:outputText value="Primer Apellido" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Segundo Apellido"/>
          <h:outputText value=""/>
          <h:inputText id="primerNombreOtraAsesoria" onkeydown="return blockEnter(event);" 
                        maxlength="20" styleClass="textmayuscula" 
                        value="#{registrarAsesoriaHumanitariaBean.asesoria.hahcprimernomb}">
                         <f:converter converterId="util.ConverterMayuscula"/>
                        
                        </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="primerNombreOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoNombreOtraAsesoria" onkeydown="return blockEnter(event);" styleClass="textmayuscula" 
                       value="#{registrarAsesoriaHumanitariaBean.asesoria.hahcsegundnomb}" maxlength="20">
                        <f:converter converterId="util.ConverterMayuscula"/>
                       </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="segundoNombreOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="primerApellidoOtraAsesoria" onkeydown="return blockEnter(event);" 
                        maxlength="20" styleClass="textmayuscula" 
                        value="#{registrarAsesoriaHumanitariaBean.asesoria.hahcprimerapel}">
                         <f:converter converterId="util.ConverterMayuscula"/>
                        </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="primerApellidoOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:inputText id="segundoApellidoOtraAsesoria" onkeydown="return blockEnter(event);" maxlength="20"
                        styleClass="textmayuscula" 
                        value="#{registrarAsesoriaHumanitariaBean.asesoria.hahcsegundapel}">
                         <f:converter converterId="util.ConverterMayuscula"/>
                        </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="segundoApellidoOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText value="Fecha Nacimiento" />
          <h:outputText value=""/>
          <h:outputText value="Edad" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText value="Sexo" styleClass="labelTextOblig"/>
          <h:outputText value=""/>
          <h:outputText/>
          <h:outputText value=""/>
          <a4j:region renderRegionOnly="false">
            <t:inputCalendar id="fechaNacimientoOtraAsesoria"
                              monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader" title="Formato: dd/mm/yyyy"
                             currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy" renderAsPopup="true"
                              value="#{registrarAsesoriaHumanitariaBean.asesoria.hahdfechanacim}"
                             valueChangeListener="#{registrarAsesoriaHumanitariaBean.setFechaNacimiento}"
                             popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha" readonly="false"
                             maxlength="11" size="11" popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                             renderPopupButtonAsImage="true" align="top">
              <f:validator validatorId="dateMenorActualValidator"/>
              <a4j:support id="supportNacimiento" event="onchange" oncomplete="fechaJs()"
                action="#{registrarAsesoriaHumanitariaBean.changeEdad}"
                reRender="panelEdadOtraAsesoria">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </t:inputCalendar>
          </a4j:region>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaNacimientoOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:panelGroup id="panelEdadOtraAsesoria">
            <h:inputText id="inputEdadOtraAsesoria" 
                         onkeydown="return blockEnter(event);" maxlength="4" style="width:60px"
                         disabled="#{registrarAsesoriaHumanitariaBean.deshabilitarEdad}"
                         value="#{registrarAsesoriaHumanitariaBean.asesoria.hahnedad}"/>
            <a4j:outputPanel ajaxRendered="true">
              <t:message for="inputEdadOtraAsesoria" styleClass="errorMessage"/>
            </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value=""/>
          <h:selectOneMenu id="radioSexoOtraAsesoria" onkeydown="return blockEnter(event);" required="false"
                            value="#{registrarAsesoriaHumanitariaBean.asesoria.hahesexo}">
            <f:selectItems value="#{registrarAsesoriaHumanitariaBean.listSexos}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="radioSexoOtraAsesoria" styleClass="errorMessage"/>
          </a4j:outputPanel>
          <h:outputText/>
          <h:outputText/>
        </h:panelGrid>
      </s:fieldset>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonModificarOtraAsesoria" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                           action="#{registrarAsesoriaHumanitariaBean.guardarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>                                                                                                                                                                      
      
         <s:fieldset legend="Mis Asesorias Registradas" id="fieldAsesoriasRegistradas" styleClass="fieldset" 
               rendered="#{not empty registrarAsesoriaHumanitariaBean.lstAsesoriaHumanitaria}">
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" 
                    id="tableAsesoriaHumanitaria"
                          styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0"
                            binding="#{registrarAsesoriaHumanitariaBean.dtMisAsesorias}"
                             value="#{registrarAsesoriaHumanitariaBean.lstAsesoriaHumanitaria}"
                             styleClass="standard_table" rowClasses="standardTable_Row3,standardTable_Row4"
                             footerClass="paginacion" rows="20" id="idtMisAsesorias">
             
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Numero Doc"/>
                    </f:facet>
                    <h:outputText value="#{item.hahetipoiden} #{item.hahanumeiden}"/>
                  </h:column>
                  
                     <h:column>
                    <f:facet name="header">
                      <h:outputText value="Nombre"/>
                    </f:facet>
                    <h:outputText value="#{item.hahcprimernomb} #{item.hahcsegundnomb}  #{item.hahcprimerapel} #{item.hahcsegundapel}"/>
                  </h:column>
                  
                    <h:column>
                    <f:facet name="header">
                      <h:outputText value="Asesoria"/>
                    </f:facet>
                    <h:outputText value="#{item.wdesctipoase}"/>
                  </h:column>
                  
                    <h:column>
                    <f:facet name="header">
                      <h:outputText value="Financiador"/>
                    </f:facet>
                    <h:selectOneMenu id="menuFinanciador" onkeydown="return blockEnter(event);" 
                           required="false" disabled="true"
                           value="#{item.hahnfinanciado}">
                           <f:selectItems value="#{registrarAsesoriaHumanitariaBean.lstDonantes}"/>
                 </h:selectOneMenu>
                  </h:column>
                  
                   <h:column>
                    <f:facet name="header">
                      <h:outputText value="Estado"/>
                    </f:facet>
                    <h:outputText value="#{item.haheestado}"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                        <h:outputText value="Anular"/>
                    </f:facet>
                    <a4j:commandLink id="anular" action="#{registrarAsesoriaHumanitariaBean.anularAsesoria}" reRender="fieldAsesoriasRegistradas">
                        <t:graphicImage alt=""  border="0" url="/comun/imagenes/eliminar.gif"/>
                    </a4j:commandLink>
                </h:column>
                         
                </h:dataTable>
              </t:buffer>
              
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_proceso" for="idtMisAsesorias" fastStep="10" pageCountVar="pageCount"
                                  pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
                                  paginatorActiveColumnStyle="font-weight:bold;">
                    <f:facet name="first">
                      <t:graphicImage alt=""  url="/comun/imagenes/primero.gif" border="0"/>
                    </f:facet>
                    <f:facet name="last">
                      <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif" border="0"/>
                    </f:facet>
                    <f:facet name="previous">
                      <t:graphicImage alt=""  url="/comun/imagenes/anterior.gif" border="0"/>
                    </f:facet>
                    <f:facet name="next">
                      <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastforward">
                      <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif" border="0"/>
                    </f:facet>
                    <f:facet name="fastrewind">
                      <t:graphicImage alt=""  url="/comun/imagenes/atras.gif" border="0"/>
                    </f:facet>
                  </t:dataScroller>
                </h:panelGrid>
              </t:buffer>
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
    
    </t:panelTab>
    <t:panelTab id="panelTabSeleccionarUsuarioOtraAsesoria" label="Seleccionar Usuario"
                rendered="#{registrarAsesoriaHumanitariaBean.renderSelecionarUsuario}">
      <s:fieldset legend="Usuarios" id="fieldSetSeleccionarUsuarioOtraAsesoria" styleClass="fieldset_dataTable">
        <h:panelGrid columns="1" id="panelGridSeleccionarUsuarioOtraAsesoria"
                     rendered="#{empty registrarAsesoriaHumanitariaBean.lstUsuarios}">
          <h:outputText value="#{msg.msg_sin_consultar}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableContentSeleccionarUsuarioOtraAsesoria"
                     rendered="#{not empty registrarAsesoriaHumanitariaBean.lstUsuarios}" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         binding="#{registrarAsesoriaHumanitariaBean.dtConsultaUsuario}"
                         value="#{registrarAsesoriaHumanitariaBean.lstUsuarios}" rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                         id="dtSeleccionarOtraAsesoria">
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
                  <h:outputText value="Seleccione"/>
                </f:facet>
                <h:commandLink id="aceptar" action="#{registrarAsesoriaHumanitariaBean.agregarUsuario}">
                  <t:graphicImage alt="" border="0" url="/comun/imagenes/adicionar.gif"/>
                </h:commandLink>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_1" for="dtSeleccionarOtraAsesoria" fastStep="10" pageCountVar="pageCount"
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
      <s:fieldset legend="Usuario Seleccionado" id="fieldUsuarioSeleccOtraAsesoria" styleClass="fieldset">
        <h:outputText value="#{registrarAsesoriaHumanitariaBean.usuario.huscprimernomb} #{registrarAsesoriaHumanitariaBean.usuario.huscsegundnomb}  #{registrarAsesoriaHumanitariaBean.usuario.huscprimerapel}  #{registrarAsesoriaHumanitariaBean.usuario.huscsegundapel}"
                      escape="false"/>
      </s:fieldset>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                   id="panelBotonSeleccionarUsuarioOtraAsesoria" columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Seleccionar Usuario" styleClass="btn btn btn-success"
                           action="#{registrarAsesoriaHumanitariaBean.seleccionarUsuario}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
      
        <h:panelGroup>
            <a4j:outputPanel id="ajaxRegionAsesoriaHumanitariaMsg2" ajaxRendered="true">
              <t:htmlTag value="br"/>
              <t:messages id="msgAsesoriaHumanitariaMsg2" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"
                          warnClass="advertencia"/>
              <t:htmlTag value="br"/>
            </a4j:outputPanel>
          </h:panelGroup>
    </t:panelTab>
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[3].focus()
</script>
</h:panelGrid>