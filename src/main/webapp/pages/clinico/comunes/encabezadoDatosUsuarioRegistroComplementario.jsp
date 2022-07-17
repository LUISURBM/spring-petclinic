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
      <h:outputText value="#{registrarUsuarioComplementarioBean.usuario.huslnumero}"/>
      <h:outputText value="#{registrarUsuarioComplementarioBean.usuario.husetipoiden} #{registrarUsuarioComplementarioBean.usuario.husanumeiden}"/>
      <h:outputText value="#{registrarUsuarioComplementarioBean.usuario.huscprimernomb} #{registrarUsuarioComplementarioBean.usuario.huscsegundnomb} #{registrarUsuarioComplementarioBean.usuario.huscprimerapel} #{registrarUsuarioComplementarioBean.usuario.huscsegundapel}"/>
      <h:outputText value="#{registrarUsuarioComplementarioBean.usuario.edad}" />
      <h:outputText value="Sexo"/>
      <h:outputText value="Estado Civil"/>
      <h:outputText value="Dirección"/>
      <h:outputText value="Correo Electrónico"/>
      <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" value="#{registrarUsuarioComplementarioBean.usuario.husesexo}" disabled="true">
        <f:selectItems value="#{registrarUsuarioComplementarioBean.listSexos}"/>
      </h:selectOneMenu>
      <h:selectOneMenu id="radioEstadoCivil"  onkeydown="return blockEnter(event);" value="#{registrarUsuarioComplementarioBean.usuario.huseestadcivil}" disabled="true">
        <f:selectItems value="#{registrarUsuarioComplementarioBean.listEstadoCivil}"/>
      </h:selectOneMenu>
      <h:outputText value="#{registrarUsuarioComplementarioBean.usuario.huscdireccion}"/>
      <h:outputText value="#{ (registrarUsuarioComplementarioBean.usuario.husccorreoelec == null || registrarUsuarioComplementarioBean.usuario.husccorreoelec == '') ? 'Sin Registrar' : registrarUsuarioComplementarioBean.usuario.husccorreoelec }"/>
    </h:panelGrid>
  </s:fieldset>