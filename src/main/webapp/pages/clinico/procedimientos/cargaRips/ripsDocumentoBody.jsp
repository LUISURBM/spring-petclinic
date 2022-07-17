<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.XlsServlet"%>
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
                                   value="#{ripsSaludtoolBean.docDocumento}" 
                                  
                                   storage="file"
                                   /> 
                             </h:panelGroup>
                             <div id="upload-progress" class="span4 fileupload-progress fade">
                             <div class="progress progress-success progress-striped active">
                             <div class="bar"</div>
                             </div>
                             
                           

                            <t:htmlTag value="br"/> 
                             <h:panelGroup id="pgcarga">
                             <h:commandButton id="boton1" styleClass="btn btn btn-success" disabled="#{ripsSaludtoolBean.renderValidar}"   value="CARGAR"     
                                  action="#{ripsSaludtoolBean.upload}" />    
                             </h:panelGroup>
                               <h:panelGroup id="pgvalida">
                             <h:commandButton id="boton2" styleClass="btn btn btn-success" disabled="#{!ripsSaludtoolBean.renderValidar}"  value="VALIDAR"     
                                  action="#{ripsSaludtoolBean.validarInformacion}" />    
                             </h:panelGroup>
                             </h:panelGrid>
              
            <h:panelGrid>
            <h:panelGroup>
            
            
            </h:panelGroup>
            </h:panelGrid>
            </h:panelGrid> 
             <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                               value="#{ripsSaludtoolBean.lstRipsSalud}" rows="10"
                               styleClass="standard_table" rowClasses="standardTable_Row1,standardTable_Row2"
                               footerClass="paginacion" id="dtBucarEpicrisis">
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Tipo de Documento"/>
                      </f:facet>
                      <h:outputText value="#{item.cstctipide}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="N�mero de Documento"/>
                      </f:facet>
                      <h:outputText value="#{item.cstanumide}"/>
                    </h:column>
                     <h:column>
                      <f:facet name="header">
                        <h:outputText value="Nombres"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcnombre}">
                      <f:convertDateTime pattern="dd/MM/yyyy"/>
                      </h:outputText>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Apellidos"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcapelli}"/>
                    </h:column>
                    
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Hora y Fecha de Atenci�n"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcfecate}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Servicio Prestado"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcservic}"/>
                    </h:column>
                     <h:column>
                      <f:facet name="header">
                        <h:outputText value="Tipo de Consulta"/>
                      </f:facet>
                      <h:outputText value="#{item.cstctipoci}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="Causa Externa"/>
                      </f:facet>
                      <h:outputText value="#{item.cstccausae}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="C�digo CIE10"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcciepri}"/>
                    </h:column>
                    <h:column>
                      <f:facet name="header">
                        <h:outputText value="CIE10"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcdespri}"/>
                    </h:column>
                   <h:column>
                      <f:facet name="header">
                        <h:outputText value="C�digo CIE10 Secundario"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcciesec}"/>
                    </h:column>
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="CIE10 Secundario"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcdessec}"/>
                    </h:column>
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="Sede"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcclinic}"/>
                    </h:column>
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="Profesional"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcprofes}"/>
                    </h:column>
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="Departamento"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcdepart}"/>
                    </h:column>
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="Ciudad"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcciudad}"/>
                    </h:column>
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="G�nero"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcsexo}"/>
                    </h:column>
                       <h:column>
                      <f:facet name="header">
                        <h:outputText value="Edad"/>
                      </f:facet>
                      <h:outputText value="#{item.cstcedad}"/>
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
          <f:subview id="generarReporte" rendered="#{ripsSaludtoolBean.generoReporte}">
        <f:verbatim>
          <script type="text/javascript" language="JavaScript"> 
            function enviar(){
                window.location="<%=request.getSession().getAttribute(XlsServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>";
            }
            </script>
          <a href="javascript:enviar()"><img src="../../../../comun/imagenes/xls.png" height="100" width="100" alt="Descargue"><br/>Descargar Archivo</a>
        </f:verbatim>
      </f:subview>
    </h:panelGrid>
  </a4j:region>
</a4j:form>