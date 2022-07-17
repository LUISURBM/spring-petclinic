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
      <h:outputText value="#{registrarUsuarioTelefonicoBean.usuario.huslnumero}"/>
      <h:outputText value="#{registrarUsuarioTelefonicoBean.usuario.husetipoiden} #{registrarUsuarioTelefonicoBean.usuario.husanumeiden}"/>
      <h:outputText value="#{registrarUsuarioTelefonicoBean.usuario.huscprimernomb} #{registrarUsuarioTelefonicoBean.usuario.huscsegundnomb} #{registrarUsuarioTelefonicoBean.usuario.huscprimerapel} #{registrarUsuarioTelefonicoBean.usuario.huscsegundapel}"/>
      <h:outputText value="#{registrarUsuarioTelefonicoBean.usuario.edad}" />
      <h:outputText value="Sexo"/>
      <h:outputText value="Estado Civil"/>
      <h:outputText value="Dirección"/>
      <h:outputText value="Correo Electrónico"/>
      <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" value="#{registrarUsuarioTelefonicoBean.usuario.husesexo}" disabled="true">
        <f:selectItems value="#{registrarUsuarioTelefonicoBean.listSexos}"/>
      </h:selectOneMenu>
      <h:selectOneMenu id="radioEstadoCivil"  onkeydown="return blockEnter(event);" value="#{registrarUsuarioTelefonicoBean.usuario.huseestadcivil}" disabled="true">
        <f:selectItems value="#{registrarUsuarioTelefonicoBean.listEstadoCivil}"/>
      </h:selectOneMenu>
      <h:outputText value="#{registrarUsuarioTelefonicoBean.usuario.huscdireccion}"/>
      <h:outputText value="#{ (registrarUsuarioTelefonicoBean.usuario.husccorreoelec == null || registrarUsuarioTelefonicoBean.usuario.husccorreoelec == '') ? 'Sin Registrar' : registrarUsuarioTelefonicoBean.usuario.husccorreoelec }"/>
      
       <h:outputText value="Telefono Contacto" />
       <h:outputText value="Telefono Celular" />
       <h:outputText value="" />
       <h:outputText value="" />
       
       
        <h:outputText value="#{registrarUsuarioTelefonicoBean.usuario.husctelefono}" />
       <h:outputText value="#{registrarUsuarioTelefonicoBean.usuario.husccelular}" />
        <h:outputText value="" />
          <h:outputText value="" />
          
      
    </h:panelGrid>
  </s:fieldset>