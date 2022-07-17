<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<a4j:region renderRegionOnly="false">
  <s:fieldset legend="Liquidos Eliminados" id="fieldLiquidosEliminados" styleClass="fieldset">
    <h:panelGrid columns="8" border="0" cellpadding="0" cellspacing="0" width="100%"
                 rowClasses="labelText,labelTextInfo" id="panelEliminarLiquidos">
      <h:outputText value="Diuresis" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelTextTipoDiuresis">
        <h:outputText value="Tipo Diuresis" styleClass="labelTextOblig"
                      rendered="#{controlLiquidosBean.renderDiuresis}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCuantificadaDiuresis">
        <h:outputText value="Cuantificada" styleClass="labelTextOblig"
                      rendered="#{controlLiquidosBean.renderDiuresis}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCantidadDiuresis">
        <h:outputText value="Cantidad(mL)" styleClass="labelTextOblig"
                      rendered="#{controlLiquidosBean.renderCantidadDiuresis && controlLiquidosBean.renderDiuresis}"/>
      </h:panelGroup>
      <h:outputText/>
      <!-- segunda fila -->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuDiuresis" immediate="true" 
                          value="#{controlLiquidosBean.liquidoDelete.hclcdiuresis}"
                          binding="#{controlLiquidosBean.mnuDiuresis}"
                          valueChangeListener="#{controlLiquidosBean.setHclcdiuresis}">
          <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
          <a4j:support id="supportmnuDiuresis" event="onclick" action="#{controlLiquidosBean.changeDiuresis}"
                       reRender="panelTextTipoDiuresis,panelTextCuantificadaDiuresis,panelTextCantidadDiuresis,panelMenuTipoDiuresis,panelMsgTipoDiuresis,panelMenuCuantificadaDiuresis,panelInputCantidadDiuresis,panelMsgCantidadDiuresis">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuDiuresis" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelMenuTipoDiuresis">
        <h:selectOneRadio id="mnuTipoDiuresis" immediate="true" 
                          rendered="#{controlLiquidosBean.renderDiuresis}"
                          binding="#{controlLiquidosBean.mnuTipoDiuresis}"
                          value="#{controlLiquidosBean.liquidoDelete.hclctipodiure}">
          <f:selectItems value="#{controlLiquidosBean.lstTipoDiuresis}"/>
        </h:selectOneRadio>
      </h:panelGroup>
      <h:panelGroup id="panelMsgTipoDiuresis">
        <a4j:outputPanel ajaxRendered="true" rendered="#{controlLiquidosBean.renderDiuresis}">
          <t:message for="mnuTipoDiuresis" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaDiuresis">
          <h:selectOneRadio id="mnuCuantificadaDiuresis" immediate="true" 
                            binding="#{controlLiquidosBean.mnuCuantificadaDiuresis}"
                            rendered="#{controlLiquidosBean.renderDiuresis}"
                            value="#{controlLiquidosBean.liquidoDelete.hclccuantdiure}"
                            valueChangeListener="#{controlLiquidosBean.setHclccuantdiure}">
            <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
            <a4j:support id="supportmnuCuantificadaDiuresis" event="onclick"
                         action="#{controlLiquidosBean.changeCuantificadaDiuresis}"
                         reRender="panelTextCantidadDiuresis,panelInputCantidadDiuresis,panelMsgCantidadDiuresis">
              <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
            </a4j:support>
          </h:selectOneRadio>
        </h:panelGroup>
      </a4j:region>
      <h:panelGroup id="panelMsgCuantificadaDiuresis">
        <a4j:outputPanel ajaxRendered="true" rendered="#{controlLiquidosBean.renderDiuresis}">
          <t:message for="mnuCuantificadaDiuresis" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelInputCantidadDiuresis">
        <h:inputText id="itCantidadDiuresis" immediate="true" 
                     binding="#{controlLiquidosBean.itCantidadDiuresis}"
                     rendered="#{controlLiquidosBean.renderCantidadDiuresis && controlLiquidosBean.renderDiuresis}"
                     maxlength="4" style="width:50px" value="#{controlLiquidosBean.liquidoDelete.hclndiuresis}"/>
      </h:panelGroup>
      <h:panelGroup id="panelMsgCantidadDiuresis">
        <a4j:outputPanel ajaxRendered="true"
                         rendered="#{controlLiquidosBean.renderCantidadDiuresis && controlLiquidosBean.renderDiuresis}">
          <t:message for="itCantidadDiuresis" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      
      <!-- tercera fila -->
      
      <h:outputText value="Deposiciones" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelTextCuantificadaDeposiciones">
        <h:outputText value="Cuantificada" styleClass="labelTextOblig"
                      rendered="#{controlLiquidosBean.renderDeposiciones}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCantidadDeposiciones">
        <h:outputText value="Cantidad(mL)" styleClass="labelTextOblig"
                      rendered="#{controlLiquidosBean.renderCantidadDeposiciones && controlLiquidosBean.renderDeposiciones}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- Cuarta fila-->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuDeposiciones" immediate="true" 
                          value="#{controlLiquidosBean.liquidoDelete.hclcdeposicion}"
                          binding="#{controlLiquidosBean.mnuDeposiciones}"
                          valueChangeListener="#{controlLiquidosBean.setHclcdeposicion}">
          <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
          <a4j:support id="supportmnuDeposiciones" event="onclick" action="#{controlLiquidosBean.changeDeposiciones}"
                       reRender="panelTextCuantificadaDeposiciones,panelTextCantidadDeposiciones,panelMenuCuantificadaDeposiciones,panelMsgCuantificadaDeposiciones,panelInputCantidadDeposiciones,panelMsgCantidadDeposiciones">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuDeposiciones" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaDeposiciones">
          <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id="mnuCuantificadaDeposiciones" immediate="true" 
                              binding="#{controlLiquidosBean.mnuCuantificadaDeposiciones}"
                              rendered="#{controlLiquidosBean.renderDeposiciones}"
                              value="#{controlLiquidosBean.liquidoDelete.hclccuantdepos}"
                              valueChangeListener="#{controlLiquidosBean.setHclccuantdepos}">
              <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
              <a4j:support id="supportmnuCuantificadaDeposiciones" event="onclick"
                           action="#{controlLiquidosBean.changeCuantificadaDeposiciones}"
                           reRender="panelTextCantidadDeposiciones,panelInputCantidadDeposiciones,panelMsgCantidadDeposiciones">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
          </a4j:region>
        </h:panelGroup>
      </a4j:region>
      <h:panelGroup id="panelMsgCuantificadaDeposiciones">
        <a4j:outputPanel ajaxRendered="true" rendered="#{controlLiquidosBean.renderDeposiciones}">
          <t:message for="mnuCuantificadaDeposiciones" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelInputCantidadDeposiciones">
        <h:inputText id="itCantidadDeposiciones"  immediate="true"
                     binding="#{controlLiquidosBean.itCantidadDeposiciones}"
                     rendered="#{controlLiquidosBean.renderCantidadDeposiciones && controlLiquidosBean.renderDeposiciones}"
                     maxlength="4" style="width:50px" value="#{controlLiquidosBean.liquidoDelete.hclndeposicion}"/>
      </h:panelGroup>
      <h:panelGroup id="panelMsgCantidadDeposiciones">
        <a4j:outputPanel ajaxRendered="true"
                         rendered="#{controlLiquidosBean.renderCantidadDeposiciones && controlLiquidosBean.renderDeposiciones}">
          <t:message for="itCantidadDeposiciones" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <!-- Quinta fila -->
      <h:outputText value="Emesis" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelCuantifiEme">
      <h:outputText value="Cuantificada" styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderEmesis}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelCantiEme">
      <h:outputText value="Cantidad mL" styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderEmeCuanti}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- -->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuEmesis" immediate="true" 
                          value="#{controlLiquidosBean.liquidoDelete.hclcemesis}"
                          binding="#{controlLiquidosBean.mnuEmesis}"
                          valueChangeListener="#{controlLiquidosBean.setHclcemesis}">
          <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
          <a4j:support id="supportmnuEmesis" event="onclick" action="#{controlLiquidosBean.changeEmesis}"
                       reRender="panelMenuCuantificadaEmesis, panelCuantifiEme">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <h:outputText/>
      
        <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaEmesis">
          <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuCuantifi" immediate="true"
                            rendered="#{controlLiquidosBean.renderEmesis}"
                            value="#{controlLiquidosBean.liquidoDelete.hclcemecua}"
                            binding="#{controlLiquidosBean.mnuCuantifi}"
                            valueChangeListener="#{controlLiquidosBean.setHclcemecua}">
          <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
          <a4j:support id="supportmnuCuantifi" event="onclick" action="#{controlLiquidosBean.changeEmesisCuanti}"
                        reRender="cantidadCuanti,panelCantiEme">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      </h:panelGroup>
      </a4j:region>
      <h:outputText/>
      <h:panelGroup id="cantidadCuanti">
      <h:inputText id="itCantidadEmesis" maxlength="3" style="width:50px" rendered="#{controlLiquidosBean.renderEmeCuanti}" immediate="true"
      binding="#{controlLiquidosBean.itCantidadEmesis}" value="#{controlLiquidosBean.liquidoDelete.hclnemecan}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- -->
      <h:outputText value="Drenaje" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:panelGroup id="panelTextTipoDrenaje">
        <h:outputText value="Tipo Drenaje" styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderDrenaje}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCuantificadaDrenaje">
        <h:outputText value="Cuantificado" styleClass="labelTextOblig" rendered="#{controlLiquidosBean.renderDrenaje}"/>
      </h:panelGroup>
      <h:outputText/>
      <h:panelGroup id="panelTextCantidadDrenaje">
        <h:outputText value="Cantidad en mL" styleClass="labelTextOblig"
                      rendered="#{controlLiquidosBean.renderCantidadDrenaje && controlLiquidosBean.renderDrenaje}"/>
      </h:panelGroup>
      <h:outputText/>
      <!-- -->
      <a4j:region renderRegionOnly="false">
        <h:selectOneRadio id="mnuDrenaje" immediate="true"  binding="#{controlLiquidosBean.mnuDrenaje}"
                          value="#{controlLiquidosBean.liquidoDelete.hclcdrenaje}"
                          valueChangeListener="#{controlLiquidosBean.setHclcdrenaje}">
          <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
          <a4j:support id="supportmnuDrenaje" event="onclick" action="#{controlLiquidosBean.changeDrenaje}"
                       reRender="panelTextTipoDrenaje,panelTextCuantificadaDrenaje,panelTextCantidadDrenaje,panelMenuTipoDrenaje,panelMsgTipoDrenaje,panelMenuCuantificadaDrenaje,panelMsgCuantificadaDrenaje,panelInputCantidadDrenaje,panelMsgCantidadDrenaje">
            <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
          </a4j:support>
        </h:selectOneRadio>
      </a4j:region>
      <a4j:outputPanel ajaxRendered="true">
        <t:message for="mnuDrenaje" styleClass="errorMessage"/>
      </a4j:outputPanel>
      <h:panelGroup id="panelMenuTipoDrenaje">
        <h:selectOneRadio id="mnuTipoDrenaje" immediate="true" 
                          rendered="#{controlLiquidosBean.renderDrenaje}"
                          binding="#{controlLiquidosBean.mnuTipoDrenaje}"
                          value="#{controlLiquidosBean.liquidoDelete.hclctipodrena}">
          <f:selectItems value="#{controlLiquidosBean.lstTipoDrenaje}"/>
        </h:selectOneRadio>
      </h:panelGroup>
      <h:panelGroup id="panelMsgTipoDrenaje">
        <a4j:outputPanel ajaxRendered="true" rendered="#{controlLiquidosBean.renderDrenaje}">
          <t:message for="mnuTipoDrenaje" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <a4j:region renderRegionOnly="false">
        <h:panelGroup id="panelMenuCuantificadaDrenaje">
          <a4j:region renderRegionOnly="false">
            <h:selectOneRadio id="mnuCuantificadaDrenaje" immediate="true" 
                              binding="#{controlLiquidosBean.mnuCuantificadaDrenaje}"
                              rendered="#{controlLiquidosBean.renderDrenaje}"
                              value="#{controlLiquidosBean.liquidoDelete.hclccuantdrena}"
                              valueChangeListener="#{controlLiquidosBean.setHclccuantdrena}">
              <f:selectItems value="#{controlLiquidosBean.lstOpciones}"/>
              <a4j:support id="supportmnuCuantificadaDrenaje" event="onclick"
                           action="#{controlLiquidosBean.changeCuantificadaDrenaje}"
                           reRender="panelTextCantidadDrenaje,panelInputCantidadDrenaje,panelMsgCantidadDrenaje">
                <a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender"/>
              </a4j:support>
            </h:selectOneRadio>
          </a4j:region>
        </h:panelGroup>
      </a4j:region>
      <h:panelGroup id="panelMsgCuantificadaDrenaje">
        <a4j:outputPanel ajaxRendered="true" rendered="#{controlLiquidosBean.renderDrenaje}">
          <t:message for="mnuCuantificadaDrenaje" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGroup id="panelInputCantidadDrenaje">
        <h:inputText id="itCantidadDrenaje"  maxlength="4" style="width:50px" immediate="true"
                     binding="#{controlLiquidosBean.itCantidadDrenaje}"
                     rendered="#{controlLiquidosBean.renderCantidadDrenaje && controlLiquidosBean.renderDrenaje}"
                     value="#{controlLiquidosBean.liquidoDelete.hclndrenaje}"/>
      </h:panelGroup>
      <h:panelGroup id="panelMsgCantidadDrenaje">
        <a4j:outputPanel ajaxRendered="true"
                         rendered="#{controlLiquidosBean.renderCantidadDrenaje && controlLiquidosBean.renderDrenaje}">
          <t:message for="itCantidadDrenaje" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <!--  -->
      <h:outputText value="Observaciones" styleClass="labelTextOblig"/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
      <!-- -->
      <h:panelGroup>
        <h:inputTextarea id="itObservacionesElimi" style="width:600px" onkeydown="return blockEnter(event);"
                         value="#{controlLiquidosBean.liquidoDelete.hclcobsliqelim}" immediate="true" >
          <f:validateLength maximum="600"/>
        </h:inputTextarea>
        <a4j:outputPanel ajaxRendered="true">
          <t:message for="itObservacionesElimi" styleClass="errorMessage"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:outputText/>
      <h:outputText/>
      <h:outputText/>
    </h:panelGrid>
    <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAgregarEliminar"
                 columnClasses="columnaBotones">
      <h:panelGroup>
        <t:htmlTag value="br"/>
        <a4j:commandButton value="Agregar" styleClass="btn btn btn-success"
                           action="#{controlLiquidosBean.agregarLiquidoEliminacion}"
                           reRender="panelTabEliminarLiquidos"/>
      </h:panelGroup>
    </h:panelGrid>
  </s:fieldset>
</a4j:region>
<s:fieldset legend="Liquidos Eliminados" id="fieldListaLiquidosEliminados" styleClass="fieldset">
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminadosSinDatos"
               rendered="#{empty controlLiquidosBean.lstLiquidosEliminadosSelect}" styleClass="tabContainer">
    <h:outputText value="#{msg.msg_sin_Datos}"/>
  </h:panelGrid>
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminados"
               rendered="#{not empty controlLiquidosBean.lstLiquidosEliminadosSelect}" styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   value="#{controlLiquidosBean.lstLiquidosEliminadosSelect}"
                   binding="#{controlLiquidosBean.dtLiquidosEliminados}" rows="5" styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion"
                   id="dtLiquidosEliminados">
        <h:column>
          <f:facet name="header">
            <h:outputText value="Hora  Registro"/>
          </f:facet>
          <h:outputText value="#{item.hcldhoraactivi}" style="align:center"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Tipo Diuresis "/>
          </f:facet>
          <h:outputText value="#{item.desTipoDiuresis}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad Diuresis"/>
          </f:facet>
          <h:outputText value="#{item.cantidadDiuresis}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad  Deposiciones"/>
          </f:facet>
          <h:outputText value="#{item.cantidadDeposiciones}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad Emesis"/>
          </f:facet>
          <h:outputText value="#{item.hclnemecan}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Tipo Drenaje"/>
          </f:facet>
          <h:outputText value="#{item.desTipoDrenaje}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Cantidad Drenaje"/>
          </f:facet>
          <h:outputText value="#{item.cantidadDrenaje}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Observaciones"/>
          </f:facet>
          <h:outputText value="#{item.hclcobsliqelim}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Eliminar"/>
          </f:facet>
          <a4j:commandLink id="eliminar" immediate="true"
                           onclick="if(!confirm(\' Desea remover este registro ? \')){ return false; }"
                           action="#{controlLiquidosBean.deleteLiquidoEliminado}"
                           reRender="fieldListaLiquidosEliminados">
            <t:graphicImage alt="" border="0" url="/comun/imagenes/quitar.gif"/>
          </a4j:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_7" for="dtLiquidosEliminados" fastStep="10" pageCountVar="pageCount"
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
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonesEliminacion"
             columnClasses="panelGridBotones">
  <h:panelGroup>
    <h:commandButton value="Registrar Eliminación Líquidos" styleClass="btn btn btn-success" immediate="true"
                     action="#{controlLiquidosBean.IngresoLiquidosEliminados}"/>
  </h:panelGroup>
</h:panelGrid>