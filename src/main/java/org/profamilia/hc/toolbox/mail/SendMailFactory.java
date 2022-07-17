package org.profamilia.hc.toolbox.mail;

import java.io.IOException;

public class SendMailFactory {

    private String smtpHost;
    private String smtpPort;
    private String mail;
    private String from;
    private String login;
    private String password;

    public SendMailFactory() {
    }
    
    
    
    public SendMail createMailSender() throws IOException {
        SendMail sendMail = new SendMail();
        sendMail.setMail(mail);
        sendMail.setFrom(from);
        sendMail.setSmtpHost(smtpHost);
        sendMail.setSmtpPort(smtpPort);
        
        if(login != null)
            sendMail.setLogin(login);
        
        if(password != null)
            sendMail.setPassword(password);
        
        return sendMail;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpPort(String smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }
}
