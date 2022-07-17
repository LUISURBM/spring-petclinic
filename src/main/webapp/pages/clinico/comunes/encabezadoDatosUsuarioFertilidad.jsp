<%@ page contentType="text/html;charset=windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
 <script language="javascript" src="<%=request.getContextPath()%>/comun/js/common.js" type="text/javascript"></script>
 <script language="javascript" src="<%=request.getContextPath()%>/comun/js/effects.js" type="text/javascript"></script>


  <rich:panel id="fieldAsesoria">
  
    <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuarioMensaje2" rowClasses="labelText,labelTextInfo">
    <h:outputText value="#{datosBasicosUsuarioBean.mensaje}" style="color:blue"/>
    </h:panelGrid>
    <t:div id="infoBasica" style="display:none">
    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuarioII" rowClasses="labelText,labelTextInfo">
      <h:outputText value="Edad"/>
      <h:outputText value="Sexo"/>
      <h:outputText value="Estado Civil"/>
        <h:outputText value="#{datosBasicosUsuarioBean.usuario.edad}" />
   
      <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioBean.usuario.husesexo}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioBean.listSexos}"/>
      </h:selectOneMenu>
      <h:selectOneMenu id="radioEstadoCivil"  onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioBean.usuario.huseestadcivil}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioBean.listEstadoCivil}"/>
      </h:selectOneMenu>
         <h:outputText value="Dirección"/>
      <h:outputText value="Correo Electrónico"/>
      <h:outputText value = "Aseguradora"/>
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.huscdireccion}"/>
      <h:outputText value="#{ (datosBasicosUsuarioBean.usuario.husccorreoelec == null || datosBasicosUsuarioBean.usuario.husccorreoelec == '') ? 'Sin Registrar' : datosBasicosUsuarioBean.usuario.husccorreoelec }"/>
       <h:selectOneMenu id="radioAseguradora" onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioBean.usuario.huscentidadadm}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioBean.listEntidadAdm}"/>
      </h:selectOneMenu>
      
      <h:outputText value="Telefono Contacto" />
      <h:outputText value="Telefono Celular" />
       <h:outputText value="" />
        
       <h:outputText value="#{datosBasicosUsuarioBean.usuario.husctelefono}" />
       <h:outputText value="#{datosBasicosUsuarioBean.usuario.husccelular}" />
        <h:outputText value="" />
        
        
        
    </h:panelGrid>
      
     </t:div>
      <h:panelGrid columns="1" cellpadding="2" cellspacing="2" border="0" width="100%" style="vertical-align:sub;">
      <a4j:commandLink onclick="ToggleText('infoBasica'); return false" title="+/- Datos Básicos">
        <t:graphicImage alt="+/- Datos Básicos" title="+/- Datos Básicos" align="center" height="16" width="30" border="0" url="/comun/imagenes/ico_masymenos.jpg"/>
      </a4j:commandLink>
       </h:panelGrid>
  </rich:panel><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>registrarAnestesia</title>
  </head>
  <body></body>
</html>