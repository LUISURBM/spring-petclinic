<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<script language="javascript" src="<%=request.getContextPath()%>/comun/js/common.js" type="text/javascript"></script>
<script language="javascript" src="<%=request.getContextPath()%>/comun/js/effects.js" type="text/javascript"></script>
&quot;
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/stylesRadio.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<rich:panel id="fieldAsesoria" bodyClass="fieltset">
 <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuario"
              rowClasses="labelText,labelTextInfo">
  <h:outputText value="Identificación"/>
  <h:outputText value="Edad"/>
  <h:outputText value="Nombre"/>
  <h:outputText value=""/>
  <h:outputText value=""/>
  <h:outputText value=""/>
  <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.husetipoiden} #{datosBasicosUsuarioCirugiaBean.usuario.husanumeiden}"/>
  <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.edad}"/>
  <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.huscprimernomb} #{datosBasicosUsuarioCirugiaBean.usuario.huscsegundnomb} #{datosBasicosUsuarioCirugiaBean.usuario.huscprimerapel} #{datosBasicosUsuarioCirugiaBean.usuario.huscsegundapel}"/>
  <h:outputText value=""/>
  <h:outputText value=""/>
      <h:panelGrid width="100%" columns="1" style="vertical-align:bottom;text-align:center;" rendered="#{not empty datosBasicosUsuarioCirugiaBean.lstHistoricoAntecedente}">
          <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true" displayAtDistanceX="-100" displayAtDistanceY="-100" >
            <h:graphicImage url="/comun/imagenes/antecedentes.png"/>
            <f:facet name="popup">
              <h:panelGroup>
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{datosBasicosUsuarioCirugiaBean.lstHistoricoAntecedente}" rows="20" styleClass="standard_table"
                       rowClasses="standardTable_Row1,standardTable_Row2" id="dtHistoricoAntecedentes">
            <h:column>
              <f:facet name="header">
                <h:outputText value="Tipo Antecedente"/>
              </f:facet>
              <h:outputText value="#{item.hancnomtipante}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Descripción"/>
              </f:facet>
              <h:outputText value="#{item.hantdescripcio}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Fecha Registro"/>
              </f:facet>
              <h:outputText value="#{item.handfecregistr}"/>
            </h:column>
          </h:dataTable>
              </h:panelGroup>
            </f:facet>
          </t:popup>
        </h:panelGrid>
 </h:panelGrid>
 <t:div id="infoBasica" style="display:none">
  <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuarioII"
               rowClasses="labelText,labelTextInfo">
   <h:outputText value="Código"/>
   <h:outputText value="Sexo"/>
   <h:outputText value="Estado Civil"/>
   <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.huslnumero}"/>
   <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);"
                    value="#{datosBasicosUsuarioCirugiaBean.usuario.husesexo}" disabled="true">
    <f:selectItems value="#{datosBasicosUsuarioCirugiaBean.listSexos}"/>
   </h:selectOneMenu>
   <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);"
                    value="#{datosBasicosUsuarioCirugiaBean.usuario.huseestadcivil}" disabled="true">
    <f:selectItems value="#{datosBasicosUsuarioCirugiaBean.listEstadoCivil}"/>
   </h:selectOneMenu>
   <h:outputText value="Dirección"/>
   <h:outputText value="Correo Electrónico"/>
   <h:outputText value="Aseguradora"/>
   <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.huscdireccion}"/>
   <h:outputText value="#{ (datosBasicosUsuarioCirugiaBean.usuario.husccorreoelec == null || datosBasicosUsuarioCirugiaBean.usuario.husccorreoelec == \'\') ? \'Sin Registrar\' : datosBasicosUsuarioCirugiaBean.usuario.husccorreoelec }"/>
   <h:selectOneMenu id="radioAseguradora" onkeydown="return blockEnter(event);"
                    value="#{datosBasicosUsuarioCirugiaBean.usuario.huscentidadadm}">
    <f:selectItems value="#{datosBasicosUsuarioCirugiaBean.listEntidadAdm}"/>
   </h:selectOneMenu>
   <h:outputText value="Telefono Contacto"/>
   <h:outputText value="Telefono Celular"/>
   <h:outputText value=""/>
   <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.husctelefono}"/>
   <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.husccelular}"/>
   <h:outputText value=""/>
  </h:panelGrid>
 </t:div>
 <h:panelGrid columns="1" cellpadding="2" cellspacing="2" border="0" width="100%" style="vertical-align:sub;">
  <a4j:commandLink onclick="ToggleText(\'infoBasica\'); return false" title="+/- Datos Básicos">
   <t:graphicImage alt="+/- Datos Básicos" title="+/- Datos Básicos" align="center" height="16" width="30" border="0"
                   url="/comun/imagenes/ico_masymenos.jpg"/>
  </a4j:commandLink>
 </h:panelGrid>
</rich:panel>