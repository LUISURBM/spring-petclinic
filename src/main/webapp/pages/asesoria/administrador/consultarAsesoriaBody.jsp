<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<%@ page import="org.profamilia.hc.view.servlet.PdfServlet"%>
<a4j:form id="consultarAsesoriaForm">
  <a4j:region id="bodyRegionConsultarAsesoria">
    <a4j:status id="statusButton" for="bodyRegionConsultarAsesoria">
      <f:facet name="start">
        <t:div id="chargindConsultarAsesoria" styleClass="loading">
          <h:panelGrid columns="1" cellpadding="0" cellspacing="0" border="0">
            <h:outputText value="Procesando..."/>
            <h:outputText value="Por favor espere."/>
          </h:panelGrid>
        </t:div>
      </f:facet>
      <f:facet name="stop"/>
    </a4j:status>
    
      <h:panelGrid columns="1" id="tableConsultarAsesoria" border="0" cellpadding="0"
                 cellspacing="0" width="100%" styleClass="td_ubicador">
        <h:outputText value="Consultar otras asesorias "
                      id="infoUbication"/>
    </h:panelGrid>
    
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableContentConsultarAsesoria"
                 styleClass="tabContainer">
       <s:fieldset legend="Criterios de Busqueda" id="fieldSetInfoUsuarioAsesoria" styleClass="fieldset">
        <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelRegionUsuarioAsesoria"
                     rowClasses="labelText,labelTextInfo">
        <h:outputText value="Tipo Identificaci�n" />
        <h:outputText value=" Numero Identificaci�n" />
         <h:panelGroup>
          <h:selectOneMenu id="tipoIdentificacion" 
                           value="#{consultarOtrasAsesoria.usuario.husetipoiden}">
            <f:selectItems value="#{consultarOtrasAsesoria.listTipoIdentificacion}"/>
          </h:selectOneMenu>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="tipoIdentificacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
        <h:panelGroup>
          <h:inputText id="itNumeroDocumento" 
                       value="#{consultarOtrasAsesoria.usuario.husanumeiden}">
         </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>

        <h:outputText value="Primer Nombre" />
        <h:outputText value=" Segundo Nombre" />
        
           <h:panelGroup>
          <h:inputText id="itPrimerNombre" styleClass="textmayuscula"
                value="#{consultarOtrasAsesoria.usuario.huscprimernomb}">
                          <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>


   <h:panelGroup>
          <h:inputText id="itSegundoNombre" styleClass="textmayuscula"
                      value="#{consultarOtrasAsesoria.usuario.huscsegundnomb}">
                         <f:converter converterId="cadena.stringUpperCaseConverter"/>
                </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>

        

       
        <h:outputText value="Primer Apellido" />
        <h:outputText value=" Segundo Apellido" />
           <h:panelGroup>
          <h:inputText id="itPrimerApellido" styleClass="textmayuscula"
                       value="#{consultarOtrasAsesoria.usuario.huscprimerapel}">
                          <f:converter converterId="cadena.stringUpperCaseConverter"/>
            </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>


   <h:panelGroup>
          <h:inputText id="itSegundoApellido" styleClass="textmayuscula"
                        value="#{consultarOtrasAsesoria.usuario.huscsegundapel}">
                           <f:converter converterId="cadena.stringUpperCaseConverter"/>
            </h:inputText>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroDocumento" styleClass="errorMessage"/>
          </a4j:outputPanel>
        </h:panelGroup>
  </h:panelGrid>
         <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="panelBotonUsuarioAsesoria"
               columnClasses="columnaBotonesCentrados">
    <h:panelGroup>
      <a4j:outputPanel id="consultarUsuarioAsesoria" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:message for="idButtonUsuarioAsesoria" id="msgInformationUsuarioAsesoria"
                   errorClass="error" infoClass="informacion"/>
      </a4j:outputPanel>
    </h:panelGroup>
    <t:htmlTag value="br"/>
    <a4j:commandButton value="Buscar" action="#{consultarOtrasAsesoria.consultarUsuario}"
                       reRender="fieldSetConsultarAsesoria"
                       styleClass="btn btn btn-success" id= "idButtonUsuarioAsesoria" />
        </h:panelGrid>
      </s:fieldset>
      
      
      <s:fieldset legend="Resultados Consulta" id="fieldSetConsultarAsesoria"
            styleClass="fieldset_dataTable">
            
        <h:panelGrid columns="1" id="panelGridConsultarAsesoria"
                rendered="#{empty consultarOtrasAsesoria.lstUsuarios}">
                    <h:outputText value="#{msg.msg_sin_consultar}"/>
                        </h:panelGrid>    
  <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0"
               width="100%" id="tableContentTabsConsultarAsesoria"
               rendered="#{not empty consultarOtrasAsesoria.lstUsuarios}" 
               styleClass="tabContainer">
    <t:buffer into="#{table}">
      <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0"
                   binding="#{consultarOtrasAsesoria.dtConsultaUsuario}"
                   value="#{consultarOtrasAsesoria.lstUsuarios}" rows="10"
                   styleClass="standard_table"
                   rowClasses="standardTable_Row1,standardTable_Row2"
                   footerClass="paginacion" id="dtBucarUsuarios">
      
         <h:column>
          <f:facet name="header">
            <h:outputText value="Fecha Asesoria"/>
          </f:facet>
          <h:outputText value="#{item.hasdfecregistr}"/>
          
        </h:column>
      
        <h:column>
          <f:facet name="header">
            <h:outputText value="Numero Documento"/>
          </f:facet>
          <h:outputText value="#{item.hasetipoiden} #{item.hasanumeiden}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Nombre"/>
          </f:facet>
           <h:outputText value="#{item.hascprimernomb}  #{item.hascsegundnomb} #{item.hascprimerapel} #{item.hascsegundapel}"/>
        </h:column>
        <h:column>
          <f:facet name="header">
            <h:outputText value="Edad"/>
          </f:facet>
          <h:outputText value="#{item.hasnedad}"/>
        </h:column>
     
        <h:column>
          <f:facet name="header">
            <h:outputText value="Imprimir"/>
          </f:facet>
           <h:commandLink id="aceptarAsesoria"
                                  action="#{consultarOtrasAsesoria.imprimirAsesoria}">
                    <t:graphicImage alt=""  border="0"
                                    url="/comun/imagenes/print_Spa.gif"/>
                  </h:commandLink>
        </h:column>
      </h:dataTable>
    </t:buffer>
    <t:buffer into="#{tableScroller}">
      <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
        <t:dataScroller id="scroll_1" for="dtBucarUsuarios" fastStep="10"
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
    </h:panelGrid>
      <h:panelGrid>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMsgUsuarioAsesoria" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationMsgUsuarioAsesoria" showSummary="true"
                      errorClass="error" globalOnly="true" layout="table"
                      infoClass="informacion"/>
        </a4j:outputPanel>
      </h:panelGroup>
    </h:panelGrid>
    
         <f:subview id="generarOtraAsesoria" rendered="#{consultarOtrasAsesoria.generoAsesoria}">
            <f:verbatim>
                <script type="text/javascript" language="JavaScript">
           window.open("<%=request.getSession().getAttribute(PdfServlet.DOCUMENT_NAME_ATTRIBUTE_NAME)%>", "Documento" , "width=800,height=600");
        </script>
            </f:verbatim>
        </f:subview>

  </a4j:region>
</a4j:form>