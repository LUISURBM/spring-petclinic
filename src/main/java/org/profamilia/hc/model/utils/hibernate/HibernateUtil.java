package org.profamilia.hc.model.utils.hibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;


/**
 * Utilidad que maneja la configuraci�n e inicializaci�n de
 * <code>SessionFactory</code> para Hibernate y provee acceso f�cil a nuevas
 * <code>Sessions</code>.
 * <p>
 * Esta implementaci�n est� especialmente dise�ada para ser utilizadas por
 * <code>Servlet Engines</code> debido a que permite la reutilizaci�n de
 * sesiones en m�ltiples <code>threads</code>.
 * <p>
 * <b><i>Static Initializer Block </i> </b>
 * <p>
 * Inicializa el <code>SessionFactory</code> en un bloque est�tico. Este
 * bloque es ejecutado cuando el <code>classloader</code> carga la clase.
 * <p>
 * <b><i>throws </i> </b>
 * <p>
 * ExceptionInInitializerError si el archivo de configuraci�n no se encuentra
 * definido o si la clase del dialecto no es v�lida.
 * 
 * @author Jhon Carranza Silva
 * @version
 */
public class HibernateUtil {
    /**
     * El <code>logger</code> de la clase que permite generar logs utilizando
     * la librer�a <code>Log4j</code>.
     */
    private static Logger log = Logger.getLogger(HibernateUtil.class);

    /**
     * El <code>SessionFactory</code> que permite generar las
     * <code>Sessions</code>. Es� asociado a una variable est�tica y final
     * para que todos los threads puedan compartirla. No hay riesgo en esto
     * porque la clase <code>SessionFactory</code> es <code>threadsafe</code>
     */
    public static final SessionFactory sessionFactory;

    /*
	 * Constructor est�tico
	 */
    static {
        String configFile = "/hibernate.cfg.xml";
        try {

            Configuration cfg = new Configuration().configure(configFile);
            sessionFactory = cfg.buildSessionFactory();

        } catch (Throwable ex) {
            log.error("Initial SessionFactory creation failed (LOCAL).", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    /**
     * Closes the current SessionFactory and releases all resources.
     * <p>
     * The only other method that can be called on HibernateUtil after this one
     * is rebuildSessionFactory(Configuration).
     */
    public static void shutdown() {
        log.debug("Shutting down Hibernate.");
        // Close caches and connection pools
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
