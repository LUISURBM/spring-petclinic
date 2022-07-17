package org.profamilia.hc.view.util;

import org.profamilia.hc.model.dto.Chautoinfopsic;
import org.profamilia.hc.model.dto.Chautornota;
import org.profamilia.hc.model.dto.Cncitologi;
import org.profamilia.hc.model.exceptions.NoFoundMailException;
import org.profamilia.hc.toolbox.mail.SendMail;
import org.profamilia.hc.view.backing.BaseBean;


public class AlertaEmail extends BaseBean {

    private String recipientTo;

    private String recipientCc;

    private StringBuffer htmlContent;

    private String subject;
    
    private String rutaAdjunto;
    private String rutaimagen;
    int emailExterno;


    public void sendSolicitudMailNotaAclaratoria(Chautornota autoriza,String recipientTo,String recipientCc) throws NoFoundMailException {

        StringBuffer htmlContent = new StringBuffer();

            htmlContent.append("<h1 style=\"font:Verdana,Helvetica;font-size:14pt\">");
            htmlContent.append("Solicitud de nota aclaratoria</h1>");
            htmlContent.append("<br><br>");
            htmlContent.append("<table border= \"1\" style=\"font-family:Verdana,Helvetica;font-size:10pt;\">");
            htmlContent.append("<tr><th colspan=\"2\"><h2> Se cre� una solicitud de nota aclaratoria </h2></th></tr>");
            htmlContent.append("<tr><th colspan=\"2\"><h4> Es necesaria su gestion para la siguiente solicitud: </h4></th></tr>");
       
            htmlContent.append("<tr><td><strong>Usuario que solicita: </strong></td>" + 
                               "<td>" + autoriza.getHancoperasolic()+ "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de registro : </strong></td>" + 
                               "<td>" + 
                               formatearCampo(autoriza.getHandfechasolic()) + 
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Servicio: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHancservicio() +" - "+ autoriza.getHancnombserv()+
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de consulta : </strong></td>" + 
                           "<td>" + 
                           formatearCampo(autoriza.getHandfechaconsu()) + 
                           "</td></tr>");                          
            htmlContent.append("<tr><td><strong>Paciente: </strong></td>" + 
                               "<td>" + autoriza.getHancnombpaci() + " "+autoriza.getHanctipoiden()+" "+autoriza.getHannnumeiden()+ 
                               "</td></tr>");
                               
        htmlContent.append("<tr><td><strong>Motivo: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHancmotivsolic() + 
                               "</td></tr>");
            htmlContent.append("</table>");

        this.htmlContent = htmlContent;
        this.recipientTo = recipientTo;
        this.recipientCc = recipientCc;
        this.subject = "Solicitud de aprobaci�n nota aclaratoria ";
        this.sendSD();
    }

    public void sendAprobacionMailNotaAclaratoria(Chautornota autoriza,String recipientTo) throws NoFoundMailException {

        String asunto ="";
        
        StringBuffer htmlContent = new StringBuffer();

            htmlContent.append("<h1 style=\"font:Verdana,Helvetica;font-size:14pt\">");
            if("S".equals(autoriza.getHancaceptsolic())){
                htmlContent.append("Aprobaci�n de nota aclaratoria</h1>");
                htmlContent.append("<br><br>");
                htmlContent.append("<table border= \"1\" style=\"font-family:Verdana,Helvetica;font-size:10pt;\">");
                htmlContent.append("<tr><th colspan=\"2\"><h2> Se aprob� la solicitud de nota aclaratoria </h2></th></tr>");
                asunto = "Aprobaci�n nota aclaratoria";
            }else if("N".equals(autoriza.getHancaceptsolic())){
                htmlContent.append("Rechazo de nota aclaratoria</h1>");
                htmlContent.append("<br><br>");
                htmlContent.append("<table border= \"1\" style=\"font-family:Verdana,Helvetica;font-size:10pt;\">");
                htmlContent.append("<tr><th colspan=\"2\"><h2> Se rechaz� la solicitud de nota aclaratoria </h2></th></tr>");
                asunto = "Rechazo nota aclaratoria";
            }
           
       
            htmlContent.append("<tr><td><strong>Usuario que solicita: </strong></td>" + 
                               "<td>" + autoriza.getHancoperasolic()+ "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de registro : </strong></td>" + 
                               "<td>" + 
                               formatearCampo(autoriza.getHandfechasolic()) + 
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Servicio: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHancservicio() +" - "+ autoriza.getHancnombserv()+
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de consulta : </strong></td>" + 
                           "<td>" + 
                           formatearCampo(autoriza.getHandfechaconsu()) + 
                           "</td></tr>");                          
            htmlContent.append("<tr><td><strong>Paciente: </strong></td>" + 
                               "<td>" + autoriza.getHancnombpaci() + " "+autoriza.getHanctipoiden()+" "+autoriza.getHannnumeiden()+ 
                               "</td></tr>");
                               
        htmlContent.append("<tr><td><strong>Motivo Solicitud: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHancmotivsolic() + 
                               "</td></tr>");
                               
        if("N".equals(autoriza.getHancaceptsolic())){
            htmlContent.append("<tr><td><strong>Motivo Rechazo: </strong></td>" + 
                                   "<td>" + 
                                   autoriza.getHancmotivrecha() + 
                                   "</td></tr>");
        }
        
        htmlContent.append("<tr><td><strong>Usuario de Respuesta: </strong></td>" + 
                           "<td>" + autoriza.getHadcoperarespu()+ "</td></tr>");
        htmlContent.append("<tr><td><strong>Fecha de Respuesta : </strong></td>" + 
                           "<td>" + 
                           formatearCampo(autoriza.getHandfecharespu()) + 
                           "</td></tr>");
            htmlContent.append("</table>");

        this.htmlContent = htmlContent;
        this.recipientTo = recipientTo;
        this.subject = asunto;
        try {
            this.send();
        } catch (Exception ex) {
            FacesUtils.addWarnMessage("Error al enviar el correo ");
        }
    }
    
    public void sendSolicitudMailInformePsicologico(Chautoinfopsic autoriza,String recipientTo,String recipientCc) throws NoFoundMailException {

        StringBuffer htmlContent = new StringBuffer();

            htmlContent.append("<h1 style=\"font:Verdana,Helvetica;font-size:14pt\">");
            htmlContent.append("Solicitud del informe psicologico</h1>");
            htmlContent.append("<br><br>");
            htmlContent.append("<table border= \"1\" style=\"font-family:Verdana,Helvetica;font-size:10pt;\">");
            htmlContent.append("<tr><th colspan=\"2\"><h2> Se cre� una solicitud del informe Psicologico </h2></th></tr>");
            htmlContent.append("<tr><th colspan=\"2\"><h4> Es necesaria su gestion para la siguiente solicitud: </h4></th></tr>");
       
            htmlContent.append("<tr><td><strong>Usuario que solicita: </strong></td>" + 
                               "<td>" + autoriza.getHaipcoperasolic()+ "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de registro : </strong></td>" + 
                               "<td>" + 
                               formatearCampo(autoriza.getHaipdfechasolic()) + 
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Servicio: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHaipcservicio() +" - "+ autoriza.getHaipcnombserv()+
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de consulta : </strong></td>" + 
                           "<td>" + 
                           formatearCampo(autoriza.getHaipdfechaconsu()) + 
                           "</td></tr>");                          
            htmlContent.append("<tr><td><strong>Paciente: </strong></td>" + 
                               "<td>" + autoriza.getHaipcnombpaci() + " "+autoriza.getHaipctipoiden()+" "+autoriza.getHaipnnumeiden()+ 
                               "</td></tr>");
                               
        htmlContent.append("<tr><td><strong>Motivo: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHaipcmotivsolic() + 
                               "</td></tr>");
            htmlContent.append("</table>");

        this.htmlContent = htmlContent;
        this.recipientTo = recipientTo;
        this.recipientCc = recipientCc;
        this.subject = "Solicitud de aprobaci�n informe Psicologico ";
        this.sendSD();
    }

    public void sendAprobacionMailNotaAclaratoria(Chautoinfopsic autoriza,String recipientTo) throws NoFoundMailException {

        String asunto ="";
        
        StringBuffer htmlContent = new StringBuffer();

            htmlContent.append("<h1 style=\"font:Verdana,Helvetica;font-size:14pt\">");
            if("S".equals(autoriza.getHaipcaceptsolic())){
                htmlContent.append("Aprobaci�n del informe psicologico</h1>");
                htmlContent.append("<br><br>");
                htmlContent.append("<table border= \"1\" style=\"font-family:Verdana,Helvetica;font-size:10pt;\">");
                htmlContent.append("<tr><th colspan=\"2\"><h2> Se aprob� la solicitud del informe psicologico </h2></th></tr>");
                asunto = "Aprobaci�n informe psicologico";
            }else if("N".equals(autoriza.getHaipcaceptsolic())){
                htmlContent.append("Rechazo de informe psicologico</h1>");
                htmlContent.append("<br><br>");
                htmlContent.append("<table border= \"1\" style=\"font-family:Verdana,Helvetica;font-size:10pt;\">");
                htmlContent.append("<tr><th colspan=\"2\"><h2> Se rechaz� la solicitud del informe psicologico </h2></th></tr>");
                asunto = "Rechazo informe Psicologico";
            }
           
       
            htmlContent.append("<tr><td><strong>Usuario que solicita: </strong></td>" + 
                               "<td>" + autoriza.getHaipcoperasolic()+ "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de registro : </strong></td>" + 
                               "<td>" + 
                               formatearCampo(autoriza.getHaipdfechasolic()) + 
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Servicio: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHaipcservicio() +" - "+ autoriza.getHaipcnombserv()+
                               "</td></tr>");
            htmlContent.append("<tr><td><strong>Fecha de consulta : </strong></td>" + 
                           "<td>" + 
                           formatearCampo(autoriza.getHaipdfechaconsu()) + 
                           "</td></tr>");                          
            htmlContent.append("<tr><td><strong>Paciente: </strong></td>" + 
                               "<td>" + autoriza.getHaipcnombpaci() + " "+autoriza.getHaipctipoiden()+" "+autoriza.getHaipnnumeiden()+ 
                               "</td></tr>");
                               
        htmlContent.append("<tr><td><strong>Motivo Solicitud: </strong></td>" + 
                               "<td>" + 
                               autoriza.getHaipcmotivsolic() + 
                               "</td></tr>");
                               
        if("N".equals(autoriza.getHaipcaceptsolic())){
            htmlContent.append("<tr><td><strong>Motivo Rechazo: </strong></td>" + 
                                   "<td>" + 
                                   autoriza.getHaipcmotivrecha() + 
                                   "</td></tr>");
        }
        
        htmlContent.append("<tr><td><strong>Usuario de Respuesta: </strong></td>" + 
                           "<td>" + autoriza.getHaipcoperarespu()+ "</td></tr>");
        htmlContent.append("<tr><td><strong>Fecha de Respuesta : </strong></td>" + 
                           "<td>" + 
                           formatearCampo(autoriza.getHaipdfecharespu()) + 
                           "</td></tr>");
            htmlContent.append("</table>");

        this.htmlContent = htmlContent;
        this.recipientTo = recipientTo;
        this.subject = asunto;
        try {
            this.send();
        } catch (Exception ex) {
            FacesUtils.addWarnMessage("Error al enviar el correo para la encuesta:");
        }
    }
    
    
    public void sendCorreosParametrizados(Cncitologi citologia,String recipientTo,String entidad,String nombreArchivo) throws NoFoundMailException {

//        String asunto ="Resultado VPH "+citologia.getCcictipide()+" "+citologia.getCcianumide()+" "+entidad;
        String asunto ="Profamilia " + entidad + " " + citologia.getCcictipide()+ " " +citologia.getCcianumide();
        
        StringBuffer htmlContent = new StringBuffer();

            htmlContent.append("<h1 style=\"font:Verdana,Helvetica;font-size:14pt\">");
          
                htmlContent.append("Resultados Lectura VPH</h1>");
                htmlContent.append("<br><br>");
        htmlContent.append("<p> Importante: Esta direcci�n de correo electr�nico es �nicamente para env�os autom�ticos de informaci�n y no est� habilitada para recibir respuestas o consultas</p>");

        this.htmlContent = htmlContent;
        this.recipientTo = recipientTo;       
        this.rutaAdjunto = nombreArchivo;
        this.subject = asunto;
        this.sendAttachment();
    }

//    public void sendCierreConsulta(Cnconsclin consulta, Chusuario usuario, 
//                                   String recipvienTo, 
//                                   String linkSurveypal) throws NoFoundMailException {
    public void sendCierreConsulta(String recipvienTo, String linkSurveypal) throws NoFoundMailException, 
                                                         Exception {
       String asunto = "Encuesta de satisfacci�n Profamilia";
       //String rutaImages= "../../../comun/imagenes/encuestasatisfaccionEmilia.png";
       StringBuffer htmlContent = new StringBuffer();
       htmlContent.append(" <h1 style=\"font:Verdana,Helvetica;font-size:14pt\">");
       htmlContent.append(" </h1>");
       htmlContent.append(" Estimada usuaria/o </h1>");
       htmlContent.append("<br><br>");
       htmlContent.append("<p>�C�mo te fue con los servicios de Profamilia? </p>");
       htmlContent.append("<p>Te invitamos a diligenciar una peque�a encuesta dando click en el siguiente link: </p>");
       htmlContent.append("<br><br>");
       htmlContent.append("<a "+linkSurveypal +"  target=\"_blank\">");
       htmlContent.append("Haz click aqui");
       //htmlContent.append("<img src=\"https://profamilia.org.co/wp-content/uploads/2021/10/Encuesta-satisfaccion-Emilia.png\" width=\"350\" height=\"625\" />");
       htmlContent.append("</a>");
       htmlContent.append("<p>Gracias por ayudarnos a mejorar.</p>");
       htmlContent.append("<br><br>");
       htmlContent.append("<p> Importante: Esta direcci�n de correo electr�nico es �nicamente para env�os autom�ticos de informaci�n y no est� habilitada para recibir respuestas o consultas</p>");
            
       this.htmlContent = htmlContent;
       this.recipientTo = recipvienTo;
       this.subject = asunto;
       try {
           this.send();
       } catch (Exception ex) {
           ex.printStackTrace();
           throw new Exception(ex);
       } 
    }

    public void simpleMail(String to, String tema, String observacion) {

        this.htmlContent = new StringBuffer();
        this.htmlContent.append(observacion);
        this.recipientTo = to;
        this.subject = tema;
        try {
            this.send();
        } catch (Exception ex) {
            FacesUtils.addWarnMessage("Error al enviar el correo ");
        }
    }


    private void send() throws Exception {
        try {
            SendMail sendMail;
            sendMail = new SendMail();
            sendMail.setFrom("adminAplicaciones@profamilia.org.co");
            sendMail.addRecipientTo(recipientTo);// correo a enviar
            sendMail.setSubject(subject);//asunto
            sendMail.setHtmlContent(htmlContent.toString());//contenido

            sendMail.send();

        } catch (Exception ex) {
            throw new Exception(ex);
//            FacesUtils.addWarnMessage("Error al enviar el correo para la encuesta:");
        }
    }

    private void sendAttachment() {
        try {
            SendMail sendMail;
            sendMail = new SendMail();
            sendMail.setFrom("adminAplicaciones@profamilia.org.co");
            sendMail.addRecipientTo(recipientTo);
            sendMail.setSubject(subject);
            sendMail.setHtmlContent(htmlContent.toString());
            if(rutaAdjunto !=null && !"".equals(rutaAdjunto)){
            sendMail.addAttachment(rutaAdjunto);
            }
            sendMail.send();

        } catch (Exception ex) {
            FacesUtils.addWarnMessage("Error al enviar el correo " );
        }
    }


    private void sendSD() {
        try {
            SendMail sendMail;
            sendMail = new SendMail();
            sendMail.setFrom("adminAplicaciones@profamilia.org.co");
            sendMail.addRecipientTo(recipientTo);
            sendMail.addRecipientCc(recipientCc);
            sendMail.setSubject(subject);
            sendMail.setHtmlContent(htmlContent.toString());
            sendMail.send();

        } catch (Exception ex) {
            FacesUtils.addWarnMessage("Error al enviar el correo");
        }
    }

}
