<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<a4j:form  id="infoClinicaForm">
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
                <a4j:outputPanel id="ajaxRegionMensajesInformacionUsuario"
                                 ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInfInformacionUsuario" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
              <s:fieldset legend ="Lista de Noticias" styleClass="fieldset" rendered="#{not empty informacionUsuarioBean.lstnoticias}" >
                  <a4j:region renderRegionOnly="false">
          <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                       id="tableNoticias" styleClass="tabContainer">
            <t:buffer into="#{table}">
             
              <a4j:repeat var="item" 
                           rendered="#{not empty informacionUsuarioBean.lstnoticias}"
                           value="#{informacionUsuarioBean.lstnoticias}" rows="5"
                           id="dtAnestesiologo">

                <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"  style="background-color:powderblue;">
             
               
                  <f:facet name="header">
                    <h:outputText value="#{item.hnocnomnot}"/>
                  </f:facet>
                  <h:outputText value="#{item.hnocdesnot}"/>
                    <h:outputLink  value="#{item.hnoclinnot}"  target="_blank" rendered="#{item.hnoclinnot !=null}" >
                        <h:outputText value="#{item.hnoclinnot}" />
                    </h:outputLink>
                  </h:panelGrid>
                  <h:outputLabel value=""/>
                  <h:outputLabel value=""/>
              </a4j:repeat>
            </t:buffer>
            <t:buffer into="#{tableScroller}">
              <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
                <t:dataScroller id="scroll" for="dtAnestesiologo" fastStep="10" pageCountVar="pageCount"
                                pageIndexVar="pageIndex" styleClass="scroller" paginator="true" immediate="true"
                                paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false"
                                paginatorActiveColumnStyle="font-weight:bold;">
                  <f:facet name="first">
                    <t:graphicImage url="/comun/imagenes/primero.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="last">
                    <t:graphicImage url="/comun/imagenes/ultimo.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="previous">
                    <t:graphicImage url="/comun/imagenes/anterior.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="next">
                    <t:graphicImage url="/comun/imagenes/siguiente.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastforward">
                    <t:graphicImage url="/comun/imagenes/adelante.gif" alt="" border="0"/>
                  </f:facet>
                  <f:facet name="fastrewind">
                    <t:graphicImage url="/comun/imagenes/atras.gif" alt="" border="0"/>
                  </f:facet>
                </t:dataScroller>
              </h:panelGrid>
            </t:buffer>
            <h:outputText value="#{tableScroller}" escape="false"/>
            <h:outputText value="#{table}" escape="false"/>
            <h:outputText value="#{tableScroller}" escape="false"/>
          </h:panelGrid>
          </a4j:region>
            </s:fieldset>
    <h:panelGrid columns="1" id="tableInformacionUsuario" border="0" cellpadding="0" cellspacing="0" width="100%"
                 styleClass="td_ubicador">
      <h:outputText value="Informacion Usuario " id="infoUbication"/>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentInfoUsuario"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Usuario" id="fieldSetInfoUsuario" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoUsuario"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Nombre del Usuario"/>
          <h:outputText value="#{informacionUsuarioBean.usuario.curcnombre}"/>
        </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentInfoLab"
                 styleClass="tabContainer">
      <s:fieldset legend="Datos Clinica" id="fieldSetInfoBasica" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionInfoConsulta"
                     rowClasses="labelText,labelTextInfo">
          <h:outputText value="Nombre de la Clinica"/>
          <h:outputText value="Dirección"/>
          <h:outputText id="cltscdescripcion" value="#{informacionUsuarioBean.infoClinica.cclcnombre}"/>
          <h:outputText id="cltscdireccion" value="#{informacionUsuarioBean.infoClinica.cclcdirect}"/>
          <h:outputText value="Teléfono"/>
          <h:outputText value=" "/>
          <h:outputText id="cclctelefo" value="#{informacionUsuarioBean.infoClinica.cclctelefo}"/>
        </h:panelGrid>
      </s:fieldset>
    </h:panelGrid>
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                 id="tableInformacionConsultasSinCerrar" styleClass="tabContainer"
                 rendered="#{not empty informacionUsuarioBean.lstConsultasAbiertas}">
      <s:fieldset legend="Consultas sin cerrar" id="fieldSetInfoConsultasSinCerrar" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="panelRegionInfoConsultaSinCerrar" rowClasses="labelText,labelTextInfo">
          <h:outputText value="#{informacionUsuarioBean.msgCerrarConsulta}"/>
        </h:panelGrid>
        
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%"
                     id="tableContentTabsConsultasAbiertas"
                     rendered="#{not empty informacionUsuarioBean.lstConsultasAbiertas}" styleClass="tabContainer">
          <t:buffer into="#{table}">
          
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                         value="#{informacionUsuarioBean.lstConsultasAbiertas}" rows="10" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2"
                         binding="#{informacionUsuarioBean.dtConsultasAbiertas}" footerClass="paginacion"
                         id="dtConsultasAbiertas">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha"/>
                </f:facet>
                <h:outputText value="#{item.hcodfecregistr}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Consulta"/>
                </f:facet>
                <h:outputText value="#{item.hcolnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Numero Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcolusuario.huslnumero}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Nombre Usuario"/>
                </f:facet>
                <h:outputText value="#{item.hcolusuario.huscprimernomb} #{item.hcolusuario.huscprimerapel}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Servicio"/>
                </f:facet>
                <h:outputText value="#{item.hcocservicio.csvcnombre}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_Citologias" for="dtConsultasAbiertas" fastStep="10" pageCountVar="pageCount"
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
    </h:panelGrid>
    
  </a4j:region>
    <h:panelGrid>
              <h:panelGroup>
                <a4j:outputPanel id="ajaxRegionMensajesInformacion2"
                                 ajaxRendered="true">
                  <t:htmlTag value="br"/>
                  <t:messages id="msgInfInformacion2" showSummary="true"
                              errorClass="error" globalOnly="true"
                              layout="table" infoClass="informacion"/>
                </a4j:outputPanel>
              </h:panelGroup>
            </h:panelGrid>
</a4j:form>