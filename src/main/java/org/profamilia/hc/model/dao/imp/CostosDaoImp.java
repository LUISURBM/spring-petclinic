package org.profamilia.hc.model.dao.imp;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;

import org.profamilia.hc.model.dto.Chcontmedane;
import org.profamilia.hc.model.dto.Chvademecum;
import org.profamilia.hc.model.dto.Chvademprof;
import org.profamilia.hc.model.dto.Cisaludtool;
import org.profamilia.hc.model.dto.Cpempresa;
import org.profamilia.hc.model.dto.Cpinsumate;
import org.profamilia.hc.model.dto.Cpservicio;
import org.profamilia.hc.model.dto.Crcup;
import org.profamilia.hc.model.dto.Ctacumcosto;
import org.profamilia.hc.model.dto.Ctwsdetsolent;
import org.profamilia.hc.model.dto.FichaTecnicaCostosDTO;
import org.profamilia.hc.model.exceptions.ModelException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.profamilia.hc.model.dao.CostosDao;


public class CostosDaoImp extends HibernateDaoSupport implements CostosDao {
    public CostosDaoImp() {
        super();
    }

  
 
    public Cpempresa getCpempresa() throws ModelException {
        List<Cpempresa> resultList = null;

        try {
                StringBuffer sb = new StringBuffer();
                sb.append(" select cpem from " + Cpempresa.class.getName()+" cpem ");       
                resultList = 
                        (List<Cpempresa>) this.getHibernateTemplate().find(sb.toString());
                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Cpempresa" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Cpempresa:" + 
                                     e.getMessage(), e);
        }

    }
    
    public List<FichaTecnicaCostosDTO> getServiciosByInsumo(String codigoServicio) throws ModelException {
        List<Object[]> resultList = null;
        List parametros = new ArrayList();
        List<FichaTecnicaCostosDTO>lstFicha = new ArrayList<FichaTecnicaCostosDTO>();
        try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select cpse.csvccodigo,cpse.csvcnombre,cpse.csvcrelecost,cpin.cimccargpaci,cpin.cimncantusad,cpin.id.cimcservic,cpin.cimcuniduso from  " + Cpservicio.class.getName() + " cpse , "+Cpinsumate.class.getName()+
                          " cpin where  cpin.id.cimcinsumo = cpse.csvccodigo and cpin.id.cimcservic = ? and ");
                sb.append(" ((cpse.csvcrelecost ='S' OR cpin.cimccargpaci ='S' ) OR (cpse.csvctipomat IN('DI') AND cpse.csvcareauso IS NOT NULL)) ");
                
                parametros.add(codigoServicio);
                resultList = 
                        (List<Object[]>) this.getHibernateTemplate().find(sb.toString(),parametros.toArray());
                        
                if (!resultList.isEmpty()) {
                
                    for(int i = 0;i<resultList.size();i++){
                        FichaTecnicaCostosDTO aux = new FichaTecnicaCostosDTO();
                        aux.setCodigoServicio((String)resultList.get(i)[0]);
                        aux.setNombreServicio((String)resultList.get(i)[1]);
                        aux.setTrazador((String)resultList.get(i)[2]);
                        aux.setCargo((String)resultList.get(i)[3]);
                        aux.setCantidad(((BigDecimal)resultList.get(i)[4]).longValue());
                        aux.setCodigoInsumo((String)resultList.get(i)[5]);
                        aux.setUnidadUso((String)resultList.get(i)[6]);
                        lstFicha.add(aux);

                    }
                    return lstFicha;
                }
                return null;
        }catch(HibernateException e){
            e.printStackTrace();
            throw new ModelException("Error consultando Servicios Insumo" + 
                                     e.getMessage(), e);
                                    
        }
         catch (Exception e) {
             e.printStackTrace();
            throw new ModelException("Error consultando Servicios Insumo " +  e.getMessage(), e);
          
         }
    }
    
    public List<String> geLstLotesByCodigo(String codigo) throws ModelException {
        List<String> resultList = null;
        List parametros = new ArrayList();
        try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select ctws.cdseclote from  " + Ctwsdetsolent.class.getName() + " ctws "+
                          " where  ctws.cdseccodmat = ? order by ctws.cdsedfecreg desc ");
                
                parametros.add(codigo);
                
                resultList = 
                        (List<String>) this.getHibernateTemplate().find(sb.toString(),parametros.toArray());
                        
                if (!resultList.isEmpty()) {
                    return resultList;
                }
                return null;
        }catch(HibernateException e){
            e.printStackTrace();
            throw new ModelException("Error consultando Lotes por Insumo" + 
                                     e.getMessage(), e);
                                    
        }
         catch (Exception e) {
             e.printStackTrace();
            throw new ModelException("Error consultando Lotes por Insumo " +  e.getMessage(), e);
          
         }
    }
    
    public List<Ctwsdetsolent> geLstLotesByCodigoDto(String codigo) throws ModelException {
        List<Ctwsdetsolent> resultList = null;
        List parametros = new ArrayList();
        try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select ctws from  " + Ctwsdetsolent.class.getName() + " ctws "+
                          " where  ctws.cdseccodmat = ? order by ctws.cdsedfecreg desc ");
                
                parametros.add(codigo);
                
                resultList = 
                        (List<Ctwsdetsolent>) this.getHibernateTemplate().find(sb.toString(),parametros.toArray());
                        
                if (!resultList.isEmpty()) {
                    return resultList;
                }
                return null;
        }catch(HibernateException e){
            e.printStackTrace();
            throw new ModelException("Error consultando Lotes por Insumo" + 
                                     e.getMessage(), e);
                                    
        }
         catch (Exception e) {
             e.printStackTrace();
            throw new ModelException("Error consultando Lotes por Insumo " +  e.getMessage(), e);
          
         }
    }
    
    public Date getFechaByLote(String codigo) throws ModelException {
        List<Date> resultList = null;
        List parametros = new ArrayList();
        try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select ctws.cdsedfecvenc from  " + Ctwsdetsolent.class.getName() + " ctws "+
                          " where  ctws.cdseclote = ? order by ctws.cdsedfecreg desc ");
                
                parametros.add(codigo);
                
                resultList = 
                        (List<Date>) this.getHibernateTemplate().find(sb.toString(),parametros.toArray());
                        
                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
                return null;
        }catch(HibernateException e){
            e.printStackTrace();
            throw new ModelException("Error consultando Fecha del lote" + 
                                     e.getMessage(), e);
                                    
        }
         catch (Exception e) {
             e.printStackTrace();
            throw new ModelException("Error consultando Fecha del lote " +  e.getMessage(), e);
          
         }
    }
    
    public Date getFechaByLote(String codigo, String codsap) throws ModelException {
        List<Date> resultList = null;
        List parametros = new ArrayList();
        try {

                StringBuffer sb = new StringBuffer();
                sb.append(" select ctws.cdsedfecvenc from  " + Ctwsdetsolent.class.getName() + " ctws "+
                          " where  ctws.cdseclote = ?  and ctws.cdseccodmat = ? order by ctws.cdsedfecreg desc ");
                
                parametros.add(codigo);
                parametros.add(codsap);
                
                resultList = 
                        (List<Date>) this.getHibernateTemplate().find(sb.toString(),parametros.toArray());
                        
                if (!resultList.isEmpty()) {
                    return resultList.get(0);
                }
                return null;
        }catch(HibernateException e){
            e.printStackTrace();
            throw new ModelException("Error consultando Fecha del lote" + 
                                     e.getMessage(), e);
                                    
        }
         catch (Exception e) {
             e.printStackTrace();
            throw new ModelException("Error consultando Fecha del lote " +  e.getMessage(), e);
          
         }
    }

    public void savelstCtacumcosto(List<Ctacumcosto> lstAcumuladores) throws ModelException {
        try {
            this.getHibernateTemplate().saveOrUpdate(lstAcumuladores);
        } catch (HibernateException e) {
            throw new ModelException("Error insertando lista de acumuladores:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error insertando lista de acumuladores:" + 
                                     e.getMessage(), e);
        }

    }
    
    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcontmedane> getMedicamentosAnestesia(Long numeroCirugia, 
                                                       String tipoServicio) throws ModelException {
        List<Chcontmedane> resultList = null;
        List parametros = new ArrayList<Chcontmedane>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chma from " + Chcontmedane.class.getName() + 
                      " chma  where chma.id.hmalconsulta = ? AND chma.id.hmactiposerv = ?  ");
            parametros.add(numeroCirugia);
            parametros.add(tipoServicio);


            resultList = 
                    (List<Chcontmedane>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Medicamentos Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Medicamentos Anestesia: " + 
                                     e.getMessage(), e);
        }

    }
    
    /**
     * @param numeroCirugia
     * @param tipoServicio
     * @return
     * @throws ModelException
     */
    public List<Chcontmedane> getMedicamentosAnestesiaInsumo(Long numeroCirugia, 
                                                       String tipoServicio) throws ModelException {
        List<Chcontmedane> resultList = null;
        List parametros = new ArrayList<Chcontmedane>();

        try {

            StringBuffer sb = new StringBuffer();
            sb.append(" select chma from " + Chcontmedane.class.getName() + 
                      " chma  where chma.id.hmalconsulta = ? AND chma.id.hmactiposerv = ? AND chma.hmaccodsap is not null  ");
            parametros.add(numeroCirugia);
            parametros.add(tipoServicio);


            resultList = 
                    (List<Chcontmedane>) this.getHibernateTemplate().find(sb.toString(), parametros.toArray());

            if (!resultList.isEmpty()) {
                return resultList;
            }

            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Medicamentos Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Medicamentos Anestesia: " + 
                                     e.getMessage(), e);
        }

    }
    
    /**
     * @return
     * @throws ModelException
     */
    public List<Chvademprof> getIniciaVademecumAnestesia() throws ModelException {
        List<Chvademprof> resultList = null;
        List parametros = new ArrayList();

        try {


            StringBuffer sb = new StringBuffer();
            sb.append(" select chvp from " + Chvademprof.class.getName() + 
                      " chvp, " + Cpinsumate.class.getName()+" cpin where chvp.hvpcanestesia  = 'N' and chvp.hvpcinicianest = 'N'  ");
            sb.append(" and cpin.id.cimcinsumo = chvp.hvpccodisap order by  chvp.hvpcprincactiv ");


            resultList = 
                    (List<Chvademprof>) this.getHibernateTemplate().find(sb.toString());


            if (!resultList.isEmpty()) {
                for(int i =0;i<resultList.size();i++){
                List<Object[]> servicio = new ArrayList<Object[]>();
                List<FichaTecnicaCostosDTO>lstFicha = new ArrayList<FichaTecnicaCostosDTO>();
                
                parametros.clear();
                    StringBuffer sb1 = new StringBuffer();
                    sb1.append(" select cpse.csvccodigo,cpse.csvcnombre,cpse.csvcrelecost,cpin.cimccargpaci,cpin.cimncantusad,cpin.id.cimcservic,cpin.cimcuniduso from  " + Cpservicio.class.getName() + " cpse , "+Cpinsumate.class.getName()+
                              " cpin where  cpin.id.cimcinsumo = cpse.csvccodigo and cpin.id.cimcservic = ?  ");
                    parametros.add(resultList.get(i).getHvpccodisap()); 
                    servicio = 
                            (List<Object[]>) this.getHibernateTemplate().find(sb1.toString(), parametros.toArray());
                    if(!servicio.isEmpty()){
                        lstFicha.clear();
                        FichaTecnicaCostosDTO aux = new FichaTecnicaCostosDTO();
                        aux.setCodigoServicio((String)servicio.get(i)[0]);
                        aux.setNombreServicio((String)servicio.get(i)[1]);
                        aux.setTrazador((String)servicio.get(i)[2]);
                        aux.setCargo((String)servicio.get(i)[3]);
                        aux.setCantidad(((BigDecimal)servicio.get(i)[4]).longValue());
                        aux.setCodigoInsumo((String)servicio.get(i)[5]);
                        aux.setUnidadUso((String)servicio.get(i)[6]);
                        resultList.get(i).setFichaTecnica(aux);
                    }
                }
                return resultList;
            }


            return null;

        } catch (HibernateException e) {
            throw new ModelException("Error consultando Vademecum Inicial Anestesia:" + 
                                     e.getMessage(), e);
        } catch (Exception e) {
            throw new ModelException("Error consultando Vademecum Inicial Anestesia:" + 
                                     e.getMessage(), e);
        }

    }

}
