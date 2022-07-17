<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formValoracionPreanestesia">
 <a4j:region id="regionValoracionPreanestesia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionValoracionPreanestesia">
      <f:facet name="start">
        <t:div id="chargingValoracionPreanestesia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>



  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelGridValoracionPreanestesiaTab"
               styleClass="tabContainer">
    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0"
                       serverSideTabSwitch="false" activePanelTabVar="true"
                       width="100%" id="panelTabbedPaneValoracionPreanestesia"
                       styleClass="tabbedPane" activeTabStyleClass="activeTab"
                       inactiveTabStyleClass="inactiveTab"
                       disabledTabStyleClass="disabledTab"
                       activeSubStyleClass="activeSub"
                       inactiveSubStyleClass="inactiveSub"
                       selectedIndex="#{valoracionPreanestesiaBean.selectedIndex}"
                       tabContentStyleClass="tabContent">
      <t:panelTab id="panelTabValoracionPreanestesia" label="Valoración Preanestesia"  
        disabled="#{valoracionPreanestesiaBean.mostrarCirugias}">
      
           <s:fieldset legend="Cirugia" id="fieldCirugias"
                        styleClass="fieldset">
              <h:panelGrid columns="2" border="0" cellpadding="0"
                           cellspacing="0" width="100%" id="panelCirugias"
                           rowClasses="labelText,labelTextInfo">
                <h:outputText value="Intervención(es) Propuesta(s)"
                              styleClass="labelTextOblig"/>
                 <h:outputText/>
             <h:panelGrid columns="2" border="0" cellpadding="0"
                             cellspacing="0" width="100%"
                             id="panelBotonConsulta"
                             columnClasses="columnaBotonesCentrados">
                  <a4j:commandLink value="" immediate="true"
                                   title="Seleccionar Cirugias"
                                   action="#{valoracionPreanestesiaBean.consultarCirugias}"
                                   styleClass="boton_fieldset"
                                   reRender="panelGridValoracionPreanestesiaTab"
                                   id="idButt">
                    <t:graphicImage id = "imagelupa" alt=""  border="0" url="/comun/imagenes/lupa.gif"/>
                  </a4j:commandLink>
                    <a4j:outputPanel ajaxRendered="true">
                    <t:message for="imagelupa"
                               styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGrid>
              </h:panelGrid>
              <h:panelGrid columns="1" border="0" cellpadding="0"
                           rendered="#{not empty valoracionPreanestesiaBean.lstExamenesCirugias}"
                           cellspacing="0" width="100%"
                           id="tableContentTabsBucar" styleClass="tabContainer">
                <t:buffer into="#{table}">
                  <h:dataTable var="item" border="1" cellpadding="0"
                               cellspacing="0"
                               binding="#{valoracionPreanestesiaBean.dtServicios}"
                               value="#{valoracionPreanestesiaBean.lstExamenesCirugias}"
                               rows="10" styleClass="standard_table"
                               rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtCirugia">
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
                        <h:outputText value="Eliminar"/>
                      </f:facet>
                      <a4j:commandLink id="aceptarCirugias" immediate="true" onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }" 
                                        action="#{valoracionPreanestesiaBean.eliminarCirugia}"
                                        reRender="panelGridValoracionPreanestesiaTab">
                        <t:graphicImage border="0"  alt="" 
                                        url="/comun/imagenes/quitar.gif"/>
                      </a4j:commandLink>
                    </h:column>
                  </h:dataTable>
                </t:buffer>
                <t:buffer into="#{tableScroller}">
                  <h:panelGrid columns="1"
                               rowClasses="labelTextInfo,labelTextInfo">
                    <t:dataScroller id="scroll_1" for="dtCirugia"
                                    fastStep="10" pageCountVar="pageCount"
                                    pageIndexVar="pageIndex"
                                    styleClass="scroller" paginator="true"
                                    immediate="true" paginatorMaxPages="9"
                                    paginatorTableClass="paginator"
                                    renderFacetsIfSinglePage="false"
                                    paginatorActiveColumnStyle="font-weight:bold;">
                      <f:facet name="first">
                        <t:graphicImage alt=""  url="/comun/imagenes/primero.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="last">
                        <t:graphicImage alt=""  url="/comun/imagenes/ultimo.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="previous">
                        <t:graphicImage  alt="" url="/comun/imagenes/anterior.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="next">
                        <t:graphicImage alt=""  url="/comun/imagenes/siguiente.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastforward">
                        <t:graphicImage alt=""  url="/comun/imagenes/adelante.gif"
                                        border="0"/>
                      </f:facet>
                      <f:facet name="fastrewind">
                        <t:graphicImage alt=""  url="/comun/imagenes/atras.gif"
                                        border="0"/>
                      </f:facet>
                    </t:dataScroller>
                  </h:panelGrid>
                     </t:buffer>
                <h:outputText value="#{tableScroller}" escape="false"/>
                <h:outputText value="#{table}" escape="false"/>
                <h:outputText value="#{tableScroller}" escape="false"/>
              </h:panelGrid>   
        </s:fieldset>
      

      <s:fieldset legend="Cirujano(s)" id="fieldProgramacionMedico"
                        styleClass="fieldset">
                <h:panelGrid  columns="1" border="0" cellpadding="0" cellspacing="0"
                   width="100%"   rowClasses="labelText,labelTextInfo" id="tableMedico">
                        <h:outputText value="Medico(s)"/>
            <h:panelGrid columns="2">        
                <h:panelGroup>
                  <h:selectOneMenu id="mnuMedico" 
                                   value="#{valoracionPreanestesiaBean.medicoSelect}">
                    <f:selectItems value="#{valoracionPreanestesiaBean.lstProfesionales}"/>
                  </h:selectOneMenu>
                  <a4j:outputPanel ajaxRendered="true">
                    <t:message for="mnuMedico" styleClass="errorMessage"/>
                  </a4j:outputPanel>
                </h:panelGroup>
                
                 <a4j:commandLink id="agregarMedico"  action="#{valoracionPreanestesiaBean.agregarMedico}" reRender="panelGridValoracionPreanestesiaTab" >
                  <t:graphicImage border="0" url="/comun/imagenes/fnd_boton_agregar.gif" alt="Agregar" />
                </a4j:commandLink>

                </h:panelGrid>
            </h:panelGrid>
             <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="tableMedicoSeleccionados"
                rendered="#{not empty valoracionPreanestesiaBean.lstMedicoSelect}"
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   binding="#{valoracionPreanestesiaBean.dtMedico}"
                   value="#{valoracionPreanestesiaBean.lstMedicoSelect}" rows="10"
                   styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2"
                   footerClass="paginacion" id="dtMedico">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Codigo"/>
          </f:facet>
          <h:outputText value="#{item.id.cpfncodigo}"/>
        </h:column>
           <h:column>
          <f:facet name="header">
            <h:outputText value="Nombre"/>
          </f:facet>
          <h:outputText value="#{item.cpfcnombre}"/>
        </h:column>
       
        
        <h:column>
          <f:facet name="header">
            <h:outputText value="Eliminar"/>
          </f:facet>
            <a4j:commandLink id="eliminar" onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }" 
            action="#{valoracionPreanestesiaBean.eliminarMedico}" reRender="panelGridValoracionPreanestesiaTab">
                        <t:graphicImage alt=""  border="0" url="/comun/imagenes/quitar.gif"/>
          </a4j:commandLink>

        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_3" for="dtMedico" fastStep="10"
                        pageCountVar="pageCount" pageIndexVar="pageIndex"
                        styleClass="scroller" paginator="true" immediate="true"
                        paginatorMaxPages="9" paginatorTableClass="paginator"
                        renderFacetsIfSinglePage="false"
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
     <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
                         width="100%" id="panelBotonesOrden"
                         columnClasses="panelGridBotones">
              <h:panelGroup>
                <h:commandButton value="Generar Valoración"
                                   styleClass="boton_fieldset"
                                   action="#{valoracionPreanestesiaBean.generarValoracion}"/>
              </h:panelGroup>
            </h:panelGrid>
</t:panelTab>

       <t:panelTab id="panelTabBuscadorCirugias" label="Bucar Cirugias" rendered="#{valoracionPreanestesiaBean.mostrarCirugias}">
          <a4j:region id="regionCirugias" renderRegionOnly="false">
            <a4j:status for="regionCirugias">
              <f:facet name="start">
                <t:div id="chargingCirugias" styleClass="loading">
                  <h:panelGrid columns="1" cellpadding="0" cellspacing="0"
                               border="0">
                    <h:outputText value="Procesando..."/>
                    <h:outputText value="Por favor espere."/>
                  </h:panelGrid>
                </t:div>
              </f:facet>
              <f:facet name="stop"/>
            </a4j:status>
            <s:fieldset legend="Cirugias" id="fieldSetCirugias"
                        styleClass="fieldset">
              <jsp:include page="/pages/clinico/registro/buscadorCirugia.jsp"
                           flush="true"/>
              <h:panelGrid id="panelGridCirugia0Botones" width="100%"
                           columnClasses="columnaBotonesCentrados" dir="RTL">
                <t:htmlTag value="br"/>
                <h:panelGroup id="panelGroupCirugiaBotones1">
                  <a4j:commandButton value="Aceptar" styleClass="boton_fieldset"
                                     action="#{valoracionPreanestesiaBean.aceptarCirugia}"
                                     reRender="panelGridValoracionPreanestesiaTab">
                    <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
                  </a4j:commandButton>
                </h:panelGroup>
              </h:panelGrid>
            </s:fieldset>
          </a4j:region>
        </t:panelTab>
        
              <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMessagesatributo1"
                               ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgInformationAndErrors1" showSummary="true"
                            errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
</t:panelTabbedPane>
</h:panelGrid>
</a4j:region>
</a4j:form>