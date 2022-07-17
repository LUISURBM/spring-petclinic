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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
<rich:panel id="fieldAsesoria" bodyClass="fieltset">
  <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuario" rowClasses="labelText,labelTextInfo">
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
    <h:panelGrid columns="3" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoUsuarioII" rowClasses="labelText,labelTextInfo">
      <h:outputText value="Código"/>
      <h:outputText value="Sexo"/>
      <h:outputText value="Estado Civil"/>
      <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.huslnumero}"/>
      <h:selectOneMenu id="radioSexo" onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioCirugiaBean.usuario.husesexo}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioCirugiaBean.listSexos}"/>
      </h:selectOneMenu>
      <h:selectOneMenu id="radioEstadoCivil" onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioCirugiaBean.usuario.huseestadcivil}" disabled="true">
        <f:selectItems value="#{datosBasicosUsuarioCirugiaBean.listEstadoCivil}"/>
      </h:selectOneMenu>
      <h:outputText value="Dirección"/>
      <h:outputText value="Correo Electrónico"/>
      <h:outputText value="Aseguradora"/>
      <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.huscdireccion}"/>
      <h:outputText value="#{ (datosBasicosUsuarioCirugiaBean.usuario.husccorreoelec == null || datosBasicosUsuarioCirugiaBean.usuario.husccorreoelec == \'\') ? \'Sin Registrar\' : datosBasicosUsuarioCirugiaBean.usuario.husccorreoelec }"/>
      <h:selectOneMenu id="radioAseguradora" onkeydown="return blockEnter(event);" value="#{datosBasicosUsuarioCirugiaBean.usuario.huscentidadadm}">
        <f:selectItems value="#{datosBasicosUsuarioCirugiaBean.listEntidadAdm}"/>
      </h:selectOneMenu>
      <h:outputText value="Telefono Contacto"/>
      <h:outputText value="Telefono Celular"/>
      <h:outputText value=""/>
      <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.husctelefono}"/>
      <h:outputText value="#{datosBasicosUsuarioCirugiaBean.usuario.husccelular}"/>
      <h:outputText value=""/>
    </h:panelGrid>
    
    <s:fieldset legend="Datos del Usuario" id="fieldAntecedentesPesoTalla" styleClass="fieldset">
      <h:panelGrid columns="2" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelInfoPesoTalla" rowClasses="labelText,labelTextInfo">
        <h:outputText value="Peso"/>
        <h:outputText value="Talla"/>
        <h:outputText value="#{datosBasicosUsuarioCirugiaBean.peso}"/>
        <h:outputText value="#{datosBasicosUsuarioCirugiaBean.talla}"/>
      </h:panelGrid>
      <s:fieldset legend="Historial Signos Vitales " id="fieldLiquidosEliminacionAnestesia" styleClass="fieldset">
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminadosAnteriormenteSinDatosAnestesia"
                     rendered="#{empty datosBasicosUsuarioCirugiaBean.lstHistorialSignosVitalesTomados}" styleClass="tabContainer">
          <h:outputText value="#{msg.msg_sin_Datos}"/>
        </h:panelGrid>
        <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="tableLiquidosEliminadosAnteriormenteAnestesia"
                     rendered="#{not empty datosBasicosUsuarioCirugiaBean.lstHistorialSignosVitalesTomados}" styleClass="tabContainer">
          <t:buffer into="#{table}">
            <h:dataTable var="item" border="1" cellpadding="0" cellspacing="0" value="#{datosBasicosUsuarioCirugiaBean.lstHistorialSignosVitalesTomados}" rows="5" styleClass="standard_table"
                         rowClasses="standardTable_Row1,standardTable_Row2" footerClass="paginacion" id="dtHistorialLiquidosEliminadosAnestesia">
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Fecha y Hora Registro"/>
                </f:facet>
                <h:outputText value="#{item.hsvdhoraactivi}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Presion Arterial"/>
                </f:facet>
                <h:outputText value="#{item.hsvnpresart1} / #{item.hsvnpresart2} mm Hg"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia Cardiaca"/>
                </f:facet>
                <h:outputText value="#{item.hsvnfreccard} l.p.m"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia Respiratoria"/>
                </f:facet>
                <h:outputText value="#{item.hsvnfrecresp}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Frecuencia Cardiaca"/>
                </f:facet>
                <h:outputText value="#{item.hsvnfreccard}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Tipo de Temperatura"/>
                </f:facet>
                <h:outputText value="#{item.hsvetipotemper}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Temperatura"/>
                </f:facet>
                <h:outputText value="#{item.hsvatemperatu}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Saturación"/>
                </f:facet>
                <h:outputText value="#{item.hsvnsatuoxihe}"/>
              </h:column>
              <h:column>
                <f:facet name="header">
                  <h:outputText value="Codigo Enfermera"/>
                </f:facet>
                <h:outputText value="#{item.hsvcoperador}"/>
              </h:column>
            </h:dataTable>
          </t:buffer>
          <t:buffer into="#{tableScroller}">
            <h:panelGrid columns="1" rowClasses="labelTextInfo,labelTextInfo">
              <t:dataScroller id="scroll_9_anestesia" for="dtHistorialLiquidosEliminadosAnestesia" fastStep="10" pageCountVar="pageCount" pageIndexVar="pageIndex" styleClass="scroller"
                              paginator="true" immediate="true" paginatorMaxPages="9" paginatorTableClass="paginator" renderFacetsIfSinglePage="false" paginatorActiveColumnStyle="font-weight:bold;">
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
    </s:fieldset>
     
    <s:fieldset legend="Signos Vitales Ingreso Enfermeria" id="fieldAntecedentesSignosVitales" styleClass="fieldset"></s:fieldset>
  </t:div>
  <h:panelGrid columns="1" cellpadding="2" cellspacing="2" border="0" width="100%" style="vertical-align:sub;">
    <a4j:commandLink onclick="ToggleText(\'infoBasica\'); return false" title="+/- Datos Básicos">
      <t:graphicImage alt="+/- Datos Básicos" title="+/- Datos Básicos" align="center" height="16" width="30" border="0" url="/comun/imagenes/ico_masymenos.jpg"/>
    </a4j:commandLink>
  </h:panelGrid>
</rich:panel>