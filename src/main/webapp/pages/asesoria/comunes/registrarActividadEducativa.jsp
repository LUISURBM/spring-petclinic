<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<%@ taglib uri="http://myfaces.apache.org/sandbox" prefix="s"%>
<h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="920px"
             id="panelGridRegistraActividadesEducativasTab" styleClass="tabContainer">
   <t:panelTabbedPane border="0" cellpadding="0" cellspacing="0" serverSideTabSwitch="false" activePanelTabVar="true"
                     width="100%" id="panelTabbedPaneActividadesEducativas" styleClass="tabbedPane"
                     selectedIndex="#{registrarAsesoriaAviseBean.selectedIndex}"
                     activeTabStyleClass="activeTab" inactiveTabStyleClass="inactiveTab"
                     disabledTabStyleClass="disabledTab" activeSubStyleClass="activeSub"
                     inactiveSubStyleClass="inactiveSub" tabContentStyleClass="tabContent">
    <t:panelTab id="panelTabDatosRegistrarActividadesEducativas" label="Registrar Actividades Educativas">
      <a4j:outputPanel id="ajaxRegionMessage" ajaxRendered="true">
        <t:htmlTag value="br"/>
        <t:messages id="msgInformation" showSummary="false" errorClass="error" globalOnly="true" layout="table"
                    infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
        <t:htmlTag value="br"/>
      </a4j:outputPanel>
      <s:fieldset legend="Acción " id="fieldSetRegistrarActividadesEducativas" styleClass="fieldset">
        <h:panelGrid columns="6" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelGridRegistrarActividades"
                     rowClasses="labelText,labelTextInfo">
        
   
       <h:outputText value = "Asesor"  styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
       
        <h:outputText value = "#{registrarActividadEducativaBean.nombreAsesor}"  styleClass="textOblig"/>
        <h:outputText value = ""/>
        <h:outputText value = ""/>
        <h:outputText value = ""/>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
        
       <h:outputText value = "Fecha Asesoria"  styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Hora Inical Asesoria" styleClass="labelTextOblig" />
       <h:outputText value = ""/>
       <h:outputText value = "Hora Final Asesoria" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       
    
     <t:inputCalendar id="fechaActividadEducativa" monthYearRowClass="yearMonthHeader" weekRowClass="weekHeader"
                           title="Formato: dd/mm/yyyy" currentDayCellClass="currentDayCell" popupDateFormat="dd/MM/yyyy"
                           renderAsPopup="true" disabled="false" required="true"
                           value="#{registrarActividadEducativaBean.actividad.haedfechases}" popupTodayString="Hoy"
                           popupWeekString="Semana" popupButtonString="Fecha" readonly="false" maxlength="11" size="11"
                           popupButtonImageUrl="/comun/imagenes/ico_calendario2.gif" renderPopupButtonAsImage="true"
                           align="top">
            <f:validator validatorId="dateMenorActualValidator"/>
          </t:inputCalendar>
          <a4j:outputPanel ajaxRendered="true">
            <t:message for="fechaActividadEducativa" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          <h:panelGroup>
          
          <h:panelGroup>
          <h:inputText id = "itHoraInicial" 
          value = "#{registrarActividadEducativaBean.actividad.haenhorainic}"
          required="true" style="width:40px" maxlength="2">
          <f:validateDoubleRange maximum="24" minimum="0"/>
          </h:inputText>
          
           <a4j:outputPanel ajaxRendered="true">
            <t:message for="itHoraInicial" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value = " : "/>
          
          <h:panelGroup>
          <h:inputText id = "itMinutoInicial" 
          value = "#{registrarActividadEducativaBean.actividad.haenminuinic}"
          required="true" style="width:40px" maxlength="2">
          <f:validateDoubleRange maximum="59" minimum="0"/>
          </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="itMinutoInicial" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGroup>
          </h:panelGroup>
          <h:outputText/>
          
             <h:panelGroup>
          
          <h:panelGroup>
          <h:inputText id = "itHoraFinal" 
          value = "#{registrarActividadEducativaBean.actividad.haenhorafina}"
           required="true" style="width:40px" maxlength="2">
          <f:validateDoubleRange maximum="24" minimum="0"/>
          </h:inputText>
        
           <a4j:outputPanel ajaxRendered="true">
            <t:message for="itHoraFinal" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGroup>
          <h:outputText value = " : "/>
          
          <h:panelGroup>
          <h:inputText id = "itMinutoFinal"
          value = "#{registrarActividadEducativaBean.actividad.haenminufina}"
          required="true" style="width:40px" maxlength="2">
          <f:validateDoubleRange maximum="59" minimum="0"/>
          </h:inputText>
            <a4j:outputPanel ajaxRendered="true">
            <t:message for="itMinutoFinal" styleClass="errorMessage"/>
          </a4j:outputPanel>
          </h:panelGroup>
          </h:panelGroup>
            <h:outputText/>
          
             
        <h:outputText value = "Lugar"  styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Tipo" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Naturaleza" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       
       <h:inputTextarea  id = "itLugar" style="width:200px"
       required="true"
       value = "#{registrarActividadEducativaBean.actividad.haeclugar}">
       <f:validateLength maximum="400" minimum="0"/>
    </h:inputTextarea>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itLugar" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
         <h:selectOneMenu id="mnuTipo" required="true"
                 value="#{registrarActividadEducativaBean.actividad.haentipoacti}">
               <f:selectItems value="#{registrarActividadEducativaBean.lstActividad}"/>
        </h:selectOneMenu>  
     
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuTipo" styleClass="errorMessage"/>
          </a4j:outputPanel>
       
       
       <h:selectOneMenu id="mnuNaturaleza"  required="true"
                 value="#{registrarActividadEducativaBean.actividad.haennatuacti}">
               <f:selectItems value="#{registrarActividadEducativaBean.lstNaturaleza}"/>
        </h:selectOneMenu>  
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuNaturaleza" styleClass="errorMessage"/>
          </a4j:outputPanel>
       
       <h:outputText value = "Proyecto"  styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Ejes Temáticos" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Persona contacto" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       
       
    
           
       <h:inputText  id = "itProyecto" required="true" maxlength="200"
       value = "#{registrarActividadEducativaBean.actividad.haecproyacti}"/>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itProyecto" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
           <h:selectOneMenu id="mnuTema"  required="true"
                 value="#{registrarActividadEducativaBean.actividad.haentemaacti}">
               <f:selectItems value="#{registrarActividadEducativaBean.lstEjes}"/>
        </h:selectOneMenu>  
         <a4j:outputPanel ajaxRendered="true">
         <t:message for="mnuTema" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          
          <h:inputText  id = "itPersonaContacto" required="true" maxlength="60"
       value = "#{registrarActividadEducativaBean.actividad.haecperscont}"/>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itPersonaContacto" styleClass="errorMessage"/>
          </a4j:outputPanel>
       
       
       <h:outputText value = "Direccion"  styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Telefono" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Poblacion" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       
       
             <h:inputText  id = "itDireccion" required="true" maxlength="60"
       value = "#{registrarActividadEducativaBean.actividad.haecdirecont}"/>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itDireccion" styleClass="errorMessage"/>
          </a4j:outputPanel>
             <h:inputText  id = "itTelefono" required="true"
       value = "#{registrarActividadEducativaBean.actividad.haectelecont}"/>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itTelefono" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
          
        <h:selectOneMenu id="mnuPoblacion" required="true"
                  value = "#{registrarActividadEducativaBean.actividad.haenpoblacti}">
               <f:selectItems value="#{registrarActividadEducativaBean.lstPoblacion}"/>
        </h:selectOneMenu>  
         
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuPoblacion" styleClass="errorMessage"/>
          </a4j:outputPanel>
       
       
       <h:outputText value = "Condición"  styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Etnia" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
       
         <h:selectOneMenu id="mnuCondicion" required="true"
                  value = "#{registrarActividadEducativaBean.actividad.haencondacti}">
               <f:selectItems value="#{registrarActividadEducativaBean.lstCondicion}"/>
        </h:selectOneMenu>  

         <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuCondicion" styleClass="errorMessage"/>
          </a4j:outputPanel>
          
             <h:selectOneMenu id="mnuEtnia" required="true"
                  value = "#{registrarActividadEducativaBean.actividad.haecetniacti}">
               <f:selectItems value="#{registrarActividadEducativaBean.lstEtnia}"/>
        </h:selectOneMenu>  
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="mnuEtnia" styleClass="errorMessage"/>
          </a4j:outputPanel>
       <h:outputText value = ""/>
       <h:outputText value = ""/>
        
      
      <h:outputText value = "No Hombres"  styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "No Mujeres" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       <h:outputText value = "Valor Actividad" styleClass="labelTextOblig"/>
       <h:outputText value = ""/>
       
       
               <h:inputText  id = "itNumeroHombres" required="true" 
               maxlength="4" style="width:50px"
       value = "#{registrarActividadEducativaBean.actividad.haennumehomb}"/>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroHombres" styleClass="errorMessage"/>
          </a4j:outputPanel>
      <h:inputText  id = "itNumeroMujeres" required="true"
      maxlength="4" style="width:50px"
       value = "#{registrarActividadEducativaBean.actividad.haennumemuje}"/>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itNumeroMujeres" styleClass="errorMessage"/>
          </a4j:outputPanel>
       <h:inputText  id = "itValorActividad" required="true"
       value = "#{registrarActividadEducativaBean.actividad.haeavaloacti}"/>
         <a4j:outputPanel ajaxRendered="true">
            <t:message for="itValorActividad" styleClass="errorMessage"/>
          </a4j:outputPanel>

        </h:panelGrid>
        <t:htmlTag value="br"/>
      </s:fieldset>
      <h:panelGroup>
        <a4j:outputPanel id="ajaxRegionMessagesRegistrarActividades" ajaxRendered="true">
          <t:htmlTag value="br"/>
          <t:messages id="msgInformationAndErrorsRegistrarActividades" showSummary="false" errorClass="error" globalOnly="true"
                      layout="table" infoClass="informacion" showDetail="true" tooltip="true" warnClass="advertencia"/>
          <t:htmlTag value="br"/>
        </a4j:outputPanel>
      </h:panelGroup>
      <h:panelGrid columns="1" border="0" cellpadding="0" cellspacing="0" width="100%" id="panelBotonModificar"
                   columnClasses="panelGridBotones">
        <h:panelGroup>
          <h:commandButton value="Guardar" styleClass="boton_fieldset"
                           action="#{registrarActividadEducativaBean.guardarActividad}">
            <a4j:support event="onclick" status="statusButton"/>
          </h:commandButton>
        </h:panelGroup>
      </h:panelGrid>
    </t:panelTab>
    
  
    
    
  </t:panelTabbedPane>
  <script language="javascript" type="text/javascript">
        document.forms[1].elements[6].focus()
</script>
</h:panelGrid> 