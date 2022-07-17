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
  
    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuario" rowClasses="labelText,labelTextInfo">
      <h:outputText value="Código"/>
      <h:outputText value="Identificación"/>
      <h:outputText value=""/>
       
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.huslnumero}"/>
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.husetipoiden} #{datosBasicosUsuarioBean.usuario.husanumeiden}"/>
      <h:outputText value=""/>
      
      <h:outputText value="Nombre"/>
      <h:outputText value="Como desea ser llamado"/>
      <h:outputText value=""/>
   
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.huscprimernomb} #{datosBasicosUsuarioBean.usuario.huscsegundnomb} #{datosBasicosUsuarioBean.usuario.huscprimerapel} #{datosBasicosUsuarioBean.usuario.huscsegundapel}"/>
      <h:outputText value="#{datosBasicosUsuarioBean.usuario.huscnombralter}" style="color:orange"/>
      <h:outputText value=""/>
      
      <h:outputText/>
      <h:outputText value=""/>
      <h:outputText value=""/>
      
       <h:outputText value=""/>
       <h:outputText value=""/>
      <h:panelGrid width="100%" columns="1" style="vertical-align:bottom;text-align:center;" rendered="#{not empty datosBasicosUsuarioBean.lstHistoricoAntecedente}">
          <t:popup styleClass="popup" closePopupOnExitingElement="true" closePopupOnExitingPopup="true" displayAtDistanceX="-100" displayAtDistanceY="-100" >
            <h:graphicImage url="/comun/imagenes/antecedentes.png"/>
            <f:facet name="popup">
              <h:panelGroup>
                <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{datosBasicosUsuarioBean.lstHistoricoAntecedente}" rows="20" styleClass="standard_table"
                       rowClasses="standardTable_Row1,standardTable_Row2" id="dtHistoricoAntecedentes">
            <h:column>
              <f:facet name="header">
                <h:outputText value="Tipo Antecedente"/>
              </f:facet>
              <h:outputText value="#{item.tipoAntecedente}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Descripción"/>
              </f:facet>
              <h:outputText value="#{item.descripcionAntecedente}"/>
            </h:column>
            <h:column>
              <f:facet name="header">
                <h:outputText value="Fecha Registro"/>
              </f:facet>
              <h:outputText value="#{item.fechaRegistro}"/>
            </h:column>
          </h:dataTable>
              </h:panelGroup>
            </f:facet>
          </t:popup>
        </h:panelGrid>
    </h:panelGrid>
    
    <h:outputText value="Pareja" style="font-size:18px" rendered="#{datosBasicosUsuarioBean.esFertilidad}"/>
 
     <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoPareja" 
     rendered="#{datosBasicosUsuarioBean.esFertilidad}"
     rowClasses="labelText,labelTextInfo">
      <h:outputText value="Identificacion"/>
      <h:outputText value="Nombre"/>
      <h:outputText value=""/>
        
   <h:outputText value="#{datosBasicosUsuarioBean.identPareja}" />
    <h:outputText value="#{datosBasicosUsuarioBean.nombrePareja}" />
    
    </h:panelGrid>
 

    
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
  </rich:panel>