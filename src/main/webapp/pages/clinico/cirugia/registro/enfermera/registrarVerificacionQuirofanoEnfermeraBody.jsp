<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="registrarVerificacionForm">
  <a4j:region id="bodyRegistrarVerificacion">
  
   <script>
       //Ejecuta una acci�n
  function execute(form,page_)
  {   
    (document.getElementById('body:registrarVerificacionForm')).pagina.value=page_;
    (document.getElementById('body:registrarVerificacionForm')).submit();

   } 
  
</script>            
       
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarVerificarTab"
                 styleClass="tabContainer" >
                 <jsp:include page="/pages/clinico/comunes/encabezadoDatosCirugia.jsp" flush="true"/>
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPaneRegistrarVerificar" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
        
       
        <t:panelTab id="panelTabRegistrarVerificar" label="Registrar Verificaci�n Quirofano ">
          <s:fieldset legend="Verificaciones Realizadas" id="fieldVerificacionRealizada" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0"
                         rendered="#{not empty registrarVerificacionQuirofanoEnfermeraBean.lstItemverificado}"
                         cellspacing="0" width="100%" id="tableVerificados" styleClass="tabContainer">
              <t:buffer into="#{table}">
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                             binding="#{registrarVerificacionQuirofanoEnfermeraBean.dtVerificado}"
                             value="#{registrarVerificacionQuirofanoEnfermeraBean.lstItemverificado}" rows="10"
                             styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                             footerClass="paginacion" id="dtVerificado">
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Descripci�n"/>
                    </f:facet>
                    <h:outputText value="#{item.hiqcdescri}" rendered="#{item.id.hiqnnumeral != \'0\'}"
                                  style="font-size: 13px"/>
                    <h:outputText value="#{item.hiqcdescri}" rendered="#{item.id.hiqnnumeral == \'0\'}"
                                  style="font-size: 15px; font-weight: bold"/>
                  </h:column>
                  <h:column>
                    <f:facet name="header">
                      <h:outputText value="Si/No/No Aplica"/>
                    </f:facet>
                    <h:panelGrid columns="2" rendered="#{item.id.hiqnnumeral != \'0\' and item.hiqcnoaplica == \'N\'}">
                      <h:selectOneRadio id="menuOpcion1" disabled="true" value="#{item.hiqcrespuesta}">
                        <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstOpciones}"/>
                      </h:selectOneRadio>
                    </h:panelGrid>
                    <h:panelGrid columns="2" rendered="#{item.id.hiqnnumeral != \'0\' and item.hiqcnoaplica == \'S\'}">
                      <h:selectOneRadio id="menuOpcion2" disabled="true" value="#{item.hiqcrespuesta}">
                        <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstOpcionesNoaplica}"/>
                      </h:selectOneRadio>
                    </h:panelGrid>
                  </h:column>
                </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_1" for="dtVerificado" fastStep="10" pageCountVar="pageCount"
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
              <h:outputText value="#{tableScroller}" escape="false"/>
              <h:outputText value="#{table}" escape="false"/>
              <h:outputText value="#{tableScroller}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Datos de la Verificaci�n" id="fieldEstadoPaciente" styleClass="fieldset">
            <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelEstadoPaciente"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Fecha"/>
              <h:outputText/>
              <h:outputText value="Tipo de Anestesia "/>
              <h:outputText/>
              <h:panelGrid columns="2">
                <t:inputCalendar id="fechaVerifica" monthYearRowClass="yearMonthHeader" title="Formato: dd/mm/yyyy"
                                 weekRowClass="weekHeader" currentDayCellClass="currentDayCell"
                                 popupDateFormat="dd/MM/yyyy" renderAsPopup="true" required="true" styleClass="input-small"
                                 disabled="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcimpreso == \'S\'}"
                                 value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqdfecverifi}"
                                 popupTodayString="Hoy" popupWeekString="Semana" popupButtonString="Fecha"
                                 readonly="false" maxlength="11" size="11"
                                 popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif"
                                 renderPopupButtonAsImage="true" align="top">
                  <f:validator validatorId="dateMayorIgualValidator"/>
                </t:inputCalendar>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="fechaVerifica" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
              <h:outputText/>
              <a4j:region renderRegionOnly="false">
                <h:panelGroup>
                  <h:selectOneRadio id="mnuAnestesia" immediate="true" onkeydown="return blockEnter(event);"
                                    binding="#{registrarVerificacionQuirofanoEnfermeraBean.mnuAnestesia}"
                                    required="true"
                                    disabled="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcimpreso == \'S\' or registrarVerificacionQuirofanoEnfermeraBean.usuarioRegistra != \'E\'}"
                                    value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqctipoaneste}"
                                    valueChangeListener="#{registrarVerificacionQuirofanoEnfermeraBean.setHvqctipoaneste}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstTipoAnestesia}"/>
                    <a4j:support id="supporAnestesia" event="onclick"
                                 action="#{registrarVerificacionQuirofanoEnfermeraBean.changeAnestesia}"
                                 reRender="fieldPorverificar,fieldOtrosdatos" immediate="true">
                      <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                    </a4j:support>
                  </h:selectOneRadio>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuAnestesia" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
              </a4j:region>
              <h:outputText/>
              <h:outputText value="Hora de Ingreso"/>
              <h:outputText/>
              <h:outputText value="Hora de Salida "/>
              <h:outputText/>
              <h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraIngreso" immediate="true" styleClass="input-small"
                                   disabled="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcimpreso == \'S\'}"
                                   value="#{registrarVerificacionQuirofanoEnfermeraBean.horaIngreso}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraIngreso" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value="Hora(s)"/>
                </h:panelGroup>
                <h:outputText value=" : "/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosIngreso" immediate="true" styleClass="input-small"
                                   disabled="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcimpreso == \'S\'}"
                                   value="#{registrarVerificacionQuirofanoEnfermeraBean.minutoIngreso}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosIngreso" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value="Minuto(s)"/>
                </h:panelGroup>
              </h:panelGroup>
              <h:outputText/>
              <h:panelGroup>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuHoraSalida" immediate="true" styleClass="input-small"
                                   disabled="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcimpreso == \'S\'}"
                                   value="#{registrarVerificacionQuirofanoEnfermeraBean.horaSalida}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.listHora}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuHoraSalida" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value="Hora(s)"/>
                </h:panelGroup>
                <h:outputText value=" : "/>
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMinutosSalida" immediate="true" styleClass="input-small"
                                   disabled="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcimpreso == \'S\'}"
                                   value="#{registrarVerificacionQuirofanoEnfermeraBean.minutoSalida}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstMinutos}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMinutosSalida" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                  <h:outputText value="Minuto(s)"/>
                </h:panelGroup>
              </h:panelGroup>
              <h:outputText/>
              <h:outputText value="Etapa del Registro"/>
              <h:outputText/>
              <h:outputText/>
              <h:outputText/>
              <h:outputText value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcetapa} - #{registrarVerificacionQuirofanoEnfermeraBean.etapa}"/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Verificaci�n" id="fieldPorverificar" styleClass="fieldset_dataTable">
          
            <a4j:region renderRegionOnly="false">
         <h:panelGrid columns="5">
            <h:outputText value="[ "/>
            <a4j:commandLink value=" Todos SI" immediate="true"
                             action="#{registrarVerificacionQuirofanoEnfermeraBean.changeTodosSi}"
                             reRender="panelGridRegistrarVerificarTab"/>
            <h:outputText value=" | "/>
            <a4j:commandLink value="Todos NO " immediate="true"
                             action="#{registrarVerificacionQuirofanoEnfermeraBean.changeTodosNo}"
                             reRender="panelGridRegistrarVerificarTab"/>
            <h:outputText value=" ]"/>
          </h:panelGrid>
          </a4j:region>
          <t:htmlTag value="br"/>
          
          
          
            <h:panelGrid columns="1" id="panelGridVerificacion"
                         rendered="#{empty registrarVerificacionQuirofanoEnfermeraBean.lstPorVerificar}">
              <h:outputText value="#{msg.msg_sin_consultar}"/>
            </h:panelGrid>
            <h:panelGrid columns="1" border="0" cellpadding="0" width="100%"
                         rendered="#{not empty registrarVerificacionQuirofanoEnfermeraBean.lstPorVerificar}"
                         cellspacing="0" id="tablePorverificar" styleClass="tabContainer">
              <t:buffer into="#{table1}">
              <h:dataTable var="item1" border="1" cellpadding="0" cellspacing="0"
                           binding="#{registrarVerificacionQuirofanoEnfermeraBean.dtPorverificar}"
                           value="#{registrarVerificacionQuirofanoEnfermeraBean.lstPorVerificar}" rows="50"
                           styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                           footerClass="paginacion" id="dtPorverificar">
              
              
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Descripci�n"/>
                  </f:facet>
                  <h:outputText value="#{item1.hiqcdescri}" rendered="#{item1.id.hiqnnumeral != \'0\'}"
                                style="font-size: 13px"/>
                  <h:outputText value="#{item1.hiqcdescri}" rendered="#{item1.id.hiqnnumeral == \'0\'}"
                                style="font-size: 15px; font-weight: bold"/>
                </h:column>
                <h:column>
                  <f:facet name="header">
                    <h:outputText value="Si/No/No Aplica"/>
                  </f:facet>
                  <h:panelGrid columns="2" rendered="#{item1.id.hiqnnumeral != \'0\' and item1.hiqcnoaplica == \'N\'}">
                    <h:selectOneRadio id="menuOpciones" onkeydown="return blockEnter(event);" immediate="true"
                                      value="#{item1.hiqcrespuesta}">
                      <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstOpciones}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="menuOpciones" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                  <h:panelGrid columns="2" rendered="#{item1.id.hiqnnumeral != \'0\' and item1.hiqcnoaplica == \'S\'}">
                    <h:selectOneRadio id="menuOpciones1" onkeydown="return blockEnter(event);" immediate="true"
                                      value="#{item1.hiqcrespuesta}" >
                      <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstOpcionesNoaplica}"/>
                    </h:selectOneRadio>
                    <a4j:outputPanel ajaxRendered="true">
                      <t:message for="menuOpciones1" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                  </h:panelGrid>
                </h:column>
              </h:dataTable>
              </t:buffer>
              <t:buffer into="#{tableScroller1}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_2" for="dtVerificado" fastStep="10" pageCountVar="pageCount"
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
              <h:outputText value="#{tableScroller1}" escape="false"/>
              <h:outputText value="#{table1}" escape="false"/>
              <h:outputText value="#{tableScroller1}" escape="false"/>
            </h:panelGrid>
          </s:fieldset>
          <s:fieldset legend="Otros Datos" id="fieldOtrosdatos" styleClass="fieldset">
            <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelOtrosDatos"
                         rowClasses="labelText,labelTextInfo">
              <h:outputText value="Observaciones"/>
              <h:panelGrid columns="2">
                <h:inputText id="observaciones" style="width:700px;height:60px" maxlength="400"
                             disabled="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcimpreso == \'S\'}"
                             value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqcobservac}"></h:inputText>
                <a4j:outputPanel ajaxRendered="true">
                  <t:message for="observaciones" styleClass="errorMessage"/>
                </a4j:outputPanel>
              </h:panelGrid>
                <h:outputText value="Anestesiologo(a)"  rendered="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqctipoaneste != \'3\'}"/>
                <h:panelGrid columns="2"  rendered="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqctipoaneste != \'3\'}">
                 <h:panelGroup>
                    <h:selectOneMenu id="mnuAnestesiologo"
                            value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqnanestesio}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstAnestesiologo}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                       <t:message for="mnuAnestesiologo" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                 </h:panelGroup>
              </h:panelGrid>
              <h:outputText value="Cirujano(a)"/>
              <h:panelGrid columns="2">
                 <h:panelGroup>
                    <h:selectOneMenu id="mnuCirujano" 
                            value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqncirujano}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstCirujano}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                       <t:message for="mnuCirujano" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                 </h:panelGroup>
              </h:panelGrid>
              <h:outputText value="Enfermera(o) o circulante"/>
              <h:panelGrid columns="2">
                 <h:panelGroup>
                    <h:selectOneMenu id="mnuEnfermera" 
                            value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqnenfermero}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstEnfermera}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                       <t:message for="mnuEnfermera" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                 </h:panelGroup>
              </h:panelGrid>
              <h:outputText value="Instrumentador(a)"/>
              <h:panelGrid columns="2">
                 <h:panelGroup>
                    <h:selectOneMenu id="mnuInstrumentador" 
                            value="#{registrarVerificacionQuirofanoEnfermeraBean.verquirofano.hvqninstrumen}">
                    <f:selectItems value="#{registrarVerificacionQuirofanoEnfermeraBean.lstInstrumentador}"/>
                    </h:selectOneMenu>
                    <a4j:outputPanel ajaxRendered="true">
                       <t:message for="mnuInstrumentador" styleClass="errorMessage"/>
                    </a4j:outputPanel>
                 </h:panelGroup>
              </h:panelGrid>
            </h:panelGrid>
          </s:fieldset>
        </t:panelTab>
      </t:panelTabbedPane>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonRegistrar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="btn btn btn-success"
                           action="#{registrarVerificacionQuirofanoEnfermeraBean.registrarVerificacion}"/>
        </h:panelGroup>
          <h:commandButton value="Generar Reporte" styleClass="btn btn btn-success"
                           rendered="#{registrarVerificacionQuirofanoEnfermeraBean.usuarioRegistra == \'E\'}"
                           action="#{registrarVerificacionQuirofanoEnfermeraBean.generarReporte}"/>
      </h:panelGrid>
    </h:panelGrid>
    <f:subview id="generarReporte"
                       rendered="#{registrarVerificacionQuirofanoEnfermeraBean.generoReporte}">
        <f:verbatim>
            <script type="text/javascript" language="JavaScript">
                window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
            </script>
        </f:verbatim>      
        </f:subview>
         <f:verbatim>
      <input type="hidden" name="pagina" id="pagina"/>  
</f:verbatim>

  </a4j:region>
</a4j:form>