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
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos.css"/>
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/comun/css/estilos2.css"/>
    
          </head>
      <body><a4j:page id="completePage">
            <tiles:insert definition="layout" flush="false">
               <tiles:put name="body" value="/pages/pamec/registrarPreguntaBody.jsp"/>
            </tiles:insert>
         </a4j:page></body>
   </f:view>
</html>