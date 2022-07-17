package org.profamilia.hc.view.backing.webService;

import java.util.List;

public class DatosCodigoQRListDTO {

    private List<Object[]> listatoma;

    public DatosCodigoQRListDTO() {
    }


    public void setListatoma(List<Object[]> listatoma) {
        this.listatoma = listatoma;
    }

    public List<Object[]> getListatoma() {
        return listatoma;
    }
}
