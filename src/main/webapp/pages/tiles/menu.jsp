<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://myfaces.apache.org/tomahawk" prefix="t"%>
<f:loadBundle basename="org.profamilia.hc.view.bundle.Messages" var="msg"/>
<a4j:form>
    <h:panelGrid columns="1" cellpadding="0" border="0" cellspacing="0" id="tableHeaderMenuDetail" width="100%"
                 columnClasses="td_5,td_5">
                 
        <t:jscookMenu layout="hbr" theme="ThemeTwo" styleLocation="/comun/css/jscookmenu" id="jsCookMenuBasic"
                      javascriptLocation="/comun/js/jscookmenu" immediate="true"
                      rendered="#{!empty MenuBean.menuAdmin}" imageLocation="/comun/imagenes">
            <t:navigationMenuItems value="#{MenuBean.menuAdmin}"/>
            
        </t:jscookMenu>
        <h:panelGrid columns="1" id="panelGridNoMenuPrin" rendered="#{empty MenuBean.menuAdmin}"
                     style="color:rgb(255,255,255);">
                   
            <h:outputText value="#{msg.msg_sin_perfil}" style="color:rgb(255,255,255);"/>
        </h:panelGrid>
    </h:panelGrid>
</a4j:form>