<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=iso-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<f:loadBundle basename="org.profamilia.hc.view.bundle.Messages" var="msg"/>
<html>
   <f:view>
      <head>
       <meta http-equiv="X-UA-Compatible" content="IE =EmulateIE6"/>
         <title>:: PROFAMILIA ** HISTORIAS CLINICAS ::</title>
         <link rel="stylesheet"
               href="/historiasroot/faces/myFacesExtensionResource/org.apache.myfaces.renderkit.html.util.MyFacesResourceLoader/12544153/calendar.HtmlCalendarRenderer/WH/theme.css"
               type="text/css"/>
         <link rel="stylesheet"
               href="/historiasroot/faces/myFacesExtensionResource/org.apache.myfaces.renderkit.html.util.MyFacesResourceLoader/12544153/calendar.HtmlCalendarRenderer/DB/theme.css"
               type="text/css"/>
         <script type="text/javascript"
                 src="/historiasroot/faces/myFacesExtensionResource/org.apache.myfaces.renderkit.html.util.MyFacesResourceLoader/12544153/prototype.PrototypeResourceLoader/prototype.js">
         </script>
         <script type="text/javascript"
                 src="/historiasroot/faces/myFacesExtensionResource/org.apache.myfaces.renderkit.html.util.MyFacesResourceLoader/12544153/calendar.HtmlCalendarRenderer/date.js">
         </script>
         <script type="text/javascript"
                 src="/historiasroot/faces/myFacesExtensionResource/org.apache.myfaces.renderkit.html.util.MyFacesResourceLoader/12544153/calendar.HtmlCalendarRenderer/popcalendar.js">
         </script>
         <script type="text/javascript"
                 src="/historiasroot/faces/myFacesExtensionResource/org.apache.myfaces.renderkit.html.util.MyFacesResourceLoader/12544153/inputTextHelp.HtmlTextHelpRenderer/inputTextHelp.js">
          </script>
           <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.css"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/bootstrap-responsive.min.css"/>
    <script language="javascript" src="<%=request.getContextPath()%>/comun/js/common.js" type="text/javascript"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/comun/js/effects.js" type="text/javascript"></script>
         
         <script language="javascript" type="text/javascript">
        </script>
      </head>
      <body><a4j:page id="completePage">
            <tiles:insert definition="layout" flush="false">
               <tiles:put name="body" value="/pages/clinico/registro/enfermeria/historiaAnticoncepcionEnfermeriaRetiro/datosUsuarioAnticoncepcionEnfermeriaRetiroBody.jsp"/>
            </tiles:insert>
         </a4j:page></body>
   </f:view>
</html>