<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form id="formCargarDatosLectura" enctype="multipart/form-data"> 

  <a4j:region id="regionLecturaCitologia" renderRegionOnly="false">
    <a4j:status id="statusButton" for="regionLecturaCitologia">
      <f:facet name="start">
        <t:div id="chargingLecturaCitologia" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
   
  
   
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridLecturaCitologiaTab"
                 styleClass="tabContainer">
      <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                         width="100%" id="panelTabbedPanelLecturaCitologia" styleClass="tabbedPane"
                         activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                         disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                         inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
            <t:panelTab id="panelTabLecturaCitologia" label="Cargar Datos">
          
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="panelGridLecturaCitologia1" styleClass="tabContainer">
            <s:fieldset legend="Cargar Datos" id="fieldLectura" styleClass="fieldset">
              <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%"
                           id="panelDatosLecturaCitologia" rowClasses="labelText,labelTextInfo">
                      
                  <h:panelGrid columns="2"
                  
                                         styleClass="altaUpload"
                                         footerClass="pieUpload"
                                         headerClass="cabeceraUpload"
                                         columnClasses="etiquetaUpload,inputUpload">
                                         
                             <f:facet name="header">
                                         <h:outputText id="lHeader"
                                   value="#{msg.msg_fileupload_gimmeimage}"/>
                             </f:facet>
                             <f:facet name="footer">
                                   <h:outputText value=""/>
                             </f:facet>
                             
                           
                             <!-- input que toma el documento csv de carga de citologias -->
                             <h:panelGroup>
                                         <t:inputFileUpload id="docDocumento2" onchange="comprueba_extension(this.value)" styleClass="btn btn-warning fileinput-button"
                                   value="#{uploadBean.docDocumento}" 
                                   required="true"  
                                   storage="file"
                                   /> 
                             </h:panelGroup>
                             <div id="upload-progress" class="span4 fileupload-progress fade">
                             <div class="progress progress-success progress-striped active">
                             <div class="bar"</div>
                             </div>
                             
                           
                             <!--- Boton que sube el archivo de carga citologias-->
                            <t:htmlTag value="br"/> 
                             <h:panelGroup>
                             <h:commandButton id="boton1" styleClass="btn btn btn-success"   value="CARGAR"     
                                  action="#{uploadBean.upload}" />    
                             </h:panelGroup>
                             </h:panelGrid>
              
            <h:panelGrid>
            <h:panelGroup>
            
            
            </h:panelGroup>
            </h:panelGrid>
            </h:panelGrid> 
             <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               value="#{uploadBean.lstCitologia}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtBucarEpicrisis">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Numero Citologia"/>
                      </f:facet>
                      <h:outputText value="#{item.clcnnumero}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Clinica"/>
                      </f:facet>
                      <h:outputText value="#{item.clcnclinic}"/>
                    </h:column>
                     <h:column>
                      <f:facet name="header">
                        <h:outputText value="Fecha de Toma"/>
                      </f:facet>
                      <h:outputText value="#{item.clcdprilec}">
                      <f:convertDateTime pattern="dd/MM/yyyy"/>
                      </h:outputText>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombre de Profesional"/>
                      </f:facet>
                      <h:outputText value="#{item.clccnompri}"/>
                    </h:column>
                    
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Numero de Tarjeta Profesional"/>
                      </f:facet>
                      <h:outputText value="#{item.clccnumpri}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Fecha de Registro"/>
                      </f:facet>
                      <h:outputText value="#{item.clcdfecreg}"/>
                    </h:column>
                     <h:column>
                      <f:facet name="header">
                        <h:outputText value="Consecutivo"/>
                      </f:facet>
                      <h:outputText value="#{item.clcnconsec}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Numero de Profesional"/>
                      </f:facet>
                      <h:outputText value="#{item.clccprilec}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Usuario de Registro"/>
                      </f:facet>
                      <h:outputText value="#{item.clccusureg}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Fecha de Registro"/>
                      </f:facet>
                      <h:outputText value="#{item.clcdfecreg}"/>
                    </h:column>
                   <h:column>
                      <f:facet name="header">
                        <h:outputText value="Microorganismos"/>
                      </f:facet>
                      <h:outputText value="#{item.clccmicorg}"/>
                    </h:column>
                  
                  
                  
                  
                  </h:dataTable>
                  </t:buffer>
                   <t:buffer into="#{tableScroller}">
                <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                  <t:dataScroller id="scroll_Interconsulta" for="dtBucarEpicrisis" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                  paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
            
          
            </s:fieldset>
          </h:panelGrid>
          <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonAceptarLectura"
                       columnClasses="panelGridBotones">
            
          </h:panelGrid>
          <h:panelGrid>
            <h:panelGroup>
              <a4j:outputPanel id="ajaxRegionMsgLecturaCito" ajaxRendered="true">
                <t:htmlTag value="br"/>
                <t:messages id="msgLecturaCito" showSummary="true" errorClass="error" globalOnly="true" layout="table"
                            infoClass="informacion"/>
              </a4j:outputPanel>
            </h:panelGroup>
          </h:panelGrid>
        </t:panelTab>
      </t:panelTabbedPane>
    </h:panelGrid>
  </a4j:region>
</a4j:form>