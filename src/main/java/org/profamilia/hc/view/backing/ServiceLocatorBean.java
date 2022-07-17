package org.profamilia.hc.view.backing;

import javax.servlet.ServletContext;

import org.profamilia.hc.model.service.CirugiaService;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.model.service.CostosService;
import org.profamilia.hc.model.service.NoticiaService;
import org.profamilia.hc.model.service.ReporteService;
import org.profamilia.hc.model.service.RipsService;
import org.profamilia.hc.model.service.HistoriaService;
import org.profamilia.hc.view.ServiceLocator.ServiceLocator;
import org.profamilia.hc.view.util.FacesUtils;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * The implementation of <code>ServiceLocator</code>.
 * <p>
 * This class is managed by the JSF managed bean facility,
 * and is set with application scope.
 * 
 * @author John Carranza
 * @see ServiceLocator
 */
public class ServiceLocatorBean implements ServiceLocator {
    //the usuarioservice bean name
     

    private static final String SERVICE_BEAN_CLINICO = "clinicoService";
    
    private static final String SERVICE_BEAN_CIRUGIA = "cirugiaService";
    
    private static final String SERVICE_BEAN_RIPS = "ripsService";
    
    private static final String SERVICE_BEAN_NOTICIA = "noticiaService";
    
    private static final String SERVICE_BEAN_REPORTE = "reporteService";
    
    private static final String SERVICE_BEAN_HISTORIA = "historiaService";
    
    private static final String SERVICE_BEAN_COSTOS = "costosService";

    //the Spring application context
    private ApplicationContext appContext;


    private ClinicoService clinicoService;
    
    private CirugiaService cirugiaService;
    // campos agregado por CJET
    private RipsService ripsService;
    private NoticiaService noticiaService;
    private ReporteService reporteService;
    private HistoriaService historiaService;
    private CostosService costosService;

    /**
     * Constructor.
     * <p>
     * The following steps being done:
     * <ul>
     * <li>retrieve Spring application context from servlet context.
     * <li>look up <code>CatalogService</code> from Spring application context.
     * <li>look up <code>UserService</code> from Spring applicatino context.
     * </ul>
     */
    public ServiceLocatorBean() {
        ServletContext context = FacesUtils.getServletContext();
        this.appContext = 
                WebApplicationContextUtils.getRequiredWebApplicationContext(context);

        this.clinicoService = 
                (ClinicoService)this.lookupService(SERVICE_BEAN_CLINICO);
                
        this.cirugiaService = 
                (CirugiaService)this.lookupService(SERVICE_BEAN_CIRUGIA);
                
        this.ripsService = 
                (RipsService)this.lookupService(SERVICE_BEAN_RIPS);
                
        this.noticiaService = 
                (NoticiaService)this.lookupService(SERVICE_BEAN_NOTICIA);
                
        this.reporteService = 
                (ReporteService)this.lookupService(SERVICE_BEAN_REPORTE);
        
        this.historiaService = 
                (HistoriaService)this.lookupService(SERVICE_BEAN_HISTORIA);
        
        this.costosService = 
                (CostosService)this.lookupService(SERVICE_BEAN_COSTOS);
    }


    /**
     * Lookup service based on service bean name.
     * 
     * @param serviceBeanName the service bean name
     * @return the service bean
     */
    public Object lookupService(String serviceBeanName) {
        return appContext.getBean(serviceBeanName);
    }

    /**
     * Get the <code>CatalogService</code>
     * 
     * @return the catalog service
     */
    public ClinicoService getClinicoService() {
        return this.clinicoService;
    }

    public CirugiaService getCirugiaService() {
        return this.cirugiaService;
    }
    
    public RipsService getRipsService() {
        return this.ripsService;
    }
    
    public NoticiaService getNoticiaService() {
        return this.noticiaService;
    }

    public ReporteService getReporteService() {
        return this.reporteService;
    }
    
    public HistoriaService getHistoriaService() {
        return this.historiaService;
    }


    public CostosService getCostosService() {
        return this.costosService;
    }
}

