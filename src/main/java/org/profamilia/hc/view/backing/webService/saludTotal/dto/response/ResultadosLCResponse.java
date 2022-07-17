package org.profamilia.hc.view.backing.webService.saludTotal.dto.response;

import org.profamilia.hc.view.backing.webService.saludTotal.dto.DatoRespuesta;
import org.profamilia.hc.view.backing.webService.saludTotal.dto.NotificationDto;


public class ResultadosLCResponse {
      
    DatoRespuesta data;
    NotificationDto notification;


    public ResultadosLCResponse() {

    }


    public void setNotification(NotificationDto notification) {
        this.notification = notification;
    }

    public NotificationDto getNotification() {
        return notification;
    }

    public void setData(DatoRespuesta data) {
        this.data = data;
    }

    public DatoRespuesta getData() {
        return data;
    }
}
