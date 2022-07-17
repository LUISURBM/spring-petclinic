<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="empresaForm">
    <a4j:region id="bodyRegionCU" renderRegionOnly="false">
        <a4j:status id="statusButton" for="bodyRegionCU">
            <f:facet name="start">
                <t:div id="chargindDiv3" styleClass="loading">
                    <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
                        <h:outputText value="Procesando..."/>
                        <h:outputText value="Por favor espere."/>
                    </h:panelGrid>
                </t:div>
            </f:facet>
            <f:facet name="stop"/>
        </a4j:status>
        <h:panelGrid columns="2" id="tableBodyGeneral" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="verticalaligntop,td_fondoBarraH">
            <h:panelGroup id="tableGroupContent">
                <h:panelGrid columns="1" id="tableInfoUbication" border="0" cellpadding="0" cellspacing="0" width="100%" columnClasses="td_ubicador">
                    <h:outputText value="Historias Clinicas >> Consulta General de Patologos" id="infoUbication"/>
                </h:panelGrid>
                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentTabs" styleClass="tabContainer">
                    <a4j:outputPanel id="ajaxRegionMessages" ajaxRendered="true">
                        <t:htmlTag value="br"/>
                        <t:messages id="msgInformationAndErrors" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                        <t:htmlTag value="br"/>
                    </a4j:outputPanel>
                    <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true" width="100%" id="tabbedPaneEmpresa" styleClass="tabbedPane"
                                       activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab" disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                                       inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
                        <t:panelTab id="panelTabInfoGenral" label="Consultar Profesionales Lectura" rendered="true">
                            <t:htmlTag value="br"/>
                            <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoBasica" styleClass="fieldset">
                                <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoBasica" rowClasses="labelText,labelTextInfo">
                                    <h:outputText value="Cod Centro Lectura"/>
                                    <h:outputText value=""/>
                                    <h:outputText value="Cod Profesional"/>
                                    <h:outputText value=""/>
                                    <h:inputText id="labelcltscnombre" value="#{profesionalPatologoBean.profesionalLec.comp_id.hppnclinlect}"/>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="labelcltscnombre" id="messagecltscnombre" errorClass="errorMessage"/>
                                    </a4j:outputPanel>
                                    <h:inputText id="labelcltscdescripcion" value="#{profesionalPatologoBean.profesionalLec.comp_id.hppncodprofes}"/>
                                    <a4j:outputPanel ajaxRendered="true">
                                        <t:message for="labelcltscdescripcion" id="messagecltscdescripcion" errorClass="errorMessage"/>
                                    </a4j:outputPanel>
                                </h:panelGrid>
                                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonConsulta" columnClasses="columnaBotonesCentrados">
                                    <t:htmlTag value="br"/>
                                    <a4j:commandButton value="Buscar" action="#{profesionalPatologoBean.buscar}" reRender="tableContentTabs" styleClass="boton_fieldset"/>
                                </h:panelGrid>
                            </s:fieldset>
                            <s:fieldset legend="Operaciones Basicas" id="fieldSetOperBasica" styleClass="fieldset">
                                <h:panelGrid columns="2" rowClasses="labelText,labelText">
                                    <h:outputText value="Adicionar : "/>
                                    <h:commandButton value="Profesional" action="#{profesionalPatologoBean.verAdicionar}" styleClass="boton_fieldset"/>
                                </h:panelGrid>
                            </s:fieldset>
                            <s:fieldset legend="Resultados Consulta" id="fieldSetResConsulta" styleClass="fieldset_dataTable">
                                <h:panelGrid columns="1" id="panelGridNoEmpresa" rendered="#{empty profesionalPatologoBean.listaProfesionalesLec}">
                                    <h:outputText value="#{msg.msg_sin_consultar}"/>
                                </h:panelGrid>
                                <h:panelGrid columns="1" id="panelGridEmpresa" rendered="#{not empty profesionalPatologoBean.listaProfesionalesLec}" width="100%" style="text-align:center;">
                                    <t:buffer into="#{table}">
                                        <h:dataTable var="item" border="0" cellpadding="0" cellspacing="0" binding="#{profesionalPatologoBean.dtProfesionalLectura}"
                                                     value="#{profesionalPatologoBean.listaProfesionalesLec}" styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                                                     footerClass="paginacion" rows="20" id="idDtProfesionales">
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="Profesional"/>
                                                </f:facet>
                                                <h:outputText value="#{item.comp_id.hppncodprofes} - #{item.cpprofesio.cpfcnombre}"/>
                                            </h:column>
                                            
                                            
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="Patologia"/>
                                                </f:facet>
                                                <h:outputText value="#{item.comp_id.hppcservicio} - #{item.nombservicio}"/>
                                            </h:column>                                            
                                            
                                            
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="Centro de Profesional"/>
                                                </f:facet>
                                                <h:outputText value="#{item.hppnclinprof} - #{item.centroProfesional}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="Centro para Lectura"/>
                                                </f:facet>
                                                <h:outputText value="#{item.comp_id.hppnclinlect} - #{item.centroLectura}"/>
                                            </h:column>
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="Estado"/>
                                                </f:facet>
                                                <h:outputText value="#{item.hppcestado}"/>
                                            </h:column>
                                                                                        
                                            <h:column>
                                                <f:facet name="header">
                                                    <h:outputText value="Editar"/>
                                                </f:facet>
                                                <h:commandLink id="editar" action="#{profesionalPatologoBean.verEditar}">
                                                    <t:graphicImage border="0" url="/comun/imagenes/editar.gif"/>
                                                </h:commandLink>
                                            </h:column>
                                        </h:dataTable>
                                    </t:buffer>
                                  
                                    <t:buffer into="#{tableScroller}">
                                        <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                                            <t:dataScroller id="scroll_1" for="idDtProfesionales" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true"
                                                            immediate="true" renderFacetsIfSinglePage="false" paginatorMaxPages="9" paginatorTableClass="paginator"
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
                                            <t:dataScroller id="scroll_2" for="idDtProfesionales" immediate="true" rowsCountVar="rowsCount" displayedRowsCountVar="displayedRowsCountVar"
                                                            firstRowIndexVar="firstRowIndex" lastRowIndexVar="lastRowIndex" pageCountVar="pageCount" pageIndexVar="pageIndex">
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
                        </t:panelTab>
                    </t:panelTabbedPane>
                </h:panelGrid>
                <h:panelGroup>
                    <a4j:outputPanel id="ajaxRegionMessagesInfoClinInfe" ajaxRendered="true">
                        <t:messages id="messageListInf" showSummary="false" errorClass="error" globalOnly="true" layout="table" infoClass="informacion" showDetail="true" tooltip="true"/>
                    </a4j:outputPanel>
                    <t:htmlTag value="br"/>
                </h:panelGroup>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:region>
</a4j:form>