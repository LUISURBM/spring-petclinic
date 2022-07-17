package org.profamilia.hc.view.backing.webService.saludTotal.dto;

import org.apache.http.HttpStatus;

public class NotificationDto {

    String status;
    String message;
    
    public NotificationDto() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
