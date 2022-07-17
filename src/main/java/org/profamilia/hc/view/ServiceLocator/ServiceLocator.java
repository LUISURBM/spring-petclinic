package org.profamilia.hc.view.ServiceLocator;

import org.profamilia.hc.model.service.CirugiaService;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.model.service.CostosService;
import org.profamilia.hc.model.service.HistoriaService;
import org.profamilia.hc.model.service.NoticiaService;
import org.profamilia.hc.model.service.ReporteService;
import org.profamilia.hc.model.service.RipsService;


/**
 * Interface needs to be implemented by ServiceLocator.
 * <p>
 * ServiceLocator is used to lookup for business services.
 * 
 * @author Andres Riano
 */
public interface ServiceLocator {

    /**
     * Get the <code>ILinea018000Service</code>.
     * 
     * @return the ClinicoService
     */
    public ClinicoService getClinicoService();
    
    public CirugiaService getCirugiaService();
    
    public RipsService getRipsService();
    
    public NoticiaService getNoticiaService();
    
    public ReporteService getReporteService();
    
    public HistoriaService getHistoriaService();
    
    public CostosService getCostosService();
}
