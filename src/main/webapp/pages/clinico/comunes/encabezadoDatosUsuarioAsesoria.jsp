<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%> 

  <s:fieldset legend="Información General Usuario(a) " id="fieldAsesoria" styleClass="fieldset">
    <h:panelGrid columns="4" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuario" rowClasses="labelText,labelTextInfo">
      <h:outputText value="Código"/>
      <h:outputText value="Identificación"/>
      <h:outputText value="Nombre"/>
      <h:outputText value="Edad"/>
      <h:outputText value="#{registrarUsuarioAsesoriaBean.usuario.huslnumero}"/>
      <h:outputText value="#{registrarUsuarioAsesoriaBean.usuario.husetipoiden} #{registrarUsuarioAsesoriaBean.usuario.husanumeiden}"/>
      <h:outputText value="#{registrarUsuarioAsesoriaBean.usuario.huscprimernomb} #{registrarUsuarioAsesoriaBean.usuario.huscsegundnomb} #{registrarUsuarioAsesoriaBean.usuario.huscprimerapel} #{registrarUsuarioAsesoriaBean.usuario.huscsegundapel}"/>
      <h:outputText value="#{registrarUsuarioAsesoriaBean.usuario.edad}" />
      <h:outputText value="Sexo"/>
      <h:outputText value="Estado Civil"/>
      <h:outputText value="Dirección"/>
      <h:outputText value="Correo Electrónico"/>
      <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" value="#{registrarUsuarioAsesoriaBean.usuario.husesexo}" disabled="true">
        <f:selectItems value="#{registrarUsuarioAsesoriaBean.listSexos}"/>
      </h:selectOneMenu>
      <h:selectOneMenu id="radioEstadoCivil"  onkeydown="return blockEnter(event);" value="#{registrarUsuarioAsesoriaBean.usuario.huseestadcivil}" disabled="true">
        <f:selectItems value="#{registrarUsuarioAsesoriaBean.listEstadoCivil}"/>
      </h:selectOneMenu>
      <h:outputText value="#{registrarUsuarioAsesoriaBean.usuario.huscdireccion}"/>
      <h:outputText value="#{ (registrarUsuarioAsesoriaBean.usuario.husccorreoelec == null || registrarUsuarioAsesoriaBean.usuario.husccorreoelec == '') ? 'Sin Registrar' : registrarUsuarioAsesoriaBean.usuario.husccorreoelec }"/>
    </h:panelGrid>
  </s:fieldset>