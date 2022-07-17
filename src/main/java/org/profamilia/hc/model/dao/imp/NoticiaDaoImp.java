package org.profamilia.hc.model.dao.imp;

import java.util.List;

import org.hibernate.HibernateException;
import org.profamilia.hc.model.dao.NoticiaDao;
import org.profamilia.hc.model.dto.Chnoticia;
import org.profamilia.hc.model.exceptions.ModelException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class NoticiaDaoImp extends HibernateDaoSupport implements NoticiaDao {
    public NoticiaDaoImp() {
    }

    public void saveOrUpdateNoticia(Chnoticia noticia) throws ModelException {
        List<Integer> resultList = null;
        try {
        if(noticia.getHnoncodnot()==null){
            StringBuffer sb = new StringBuffer();
            sb.append("select NVL(max(c.hnoncodnot),0) from Chnoticia c");
            resultList = 
                    (List<Integer>) this.getHibernateTemplate().find(sb.toString());
                    Integer consecutivo = 1;
            if (!resultList.isEmpty()) {
               consecutivo = (resultList.get(0))+1;
               
            }
            noticia.setHnoncodnot(consecutivo);
            
        }
           
            this.getHibernateTemplate().saveOrUpdate(noticia);
        } catch (HibernateException e) {
            throw new ModelException("Error Insertando Noticia :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error Insertando Noticia:" + 
                                     e.getMessage(), e);
        }
    }

    public List<Chnoticia> readNoticia() throws ModelException {
        List<Chnoticia> resultList = null;
        try {
                StringBuffer sb = new StringBuffer();
                sb.append(" select c from ").append(Chnoticia.class.getName()).append(" c ");
                sb.append("where c.hnocestado = 'VG'");
             
            

                resultList = 
                        (List<Chnoticia>) getHibernateTemplate().find(sb.toString());
                if (!resultList.isEmpty()) {
                    return resultList;
                }
            }

        catch (HibernateException e) {
            throw new ModelException("Error consultando noticias :" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando noticias: " + 
                                     e.getMessage(), e);
        }
        return null;
    }
    
}
