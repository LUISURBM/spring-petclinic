 // Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 30/09/2016 12:47:39 a. m.
 // Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
 // Decompiler options: packimports(3) 
 // Source File Name:   BuscadorDisponibilidadSalaBean.java

 package org.profamilia.hc.view.backing.comun.buscador;

 import java.text.SimpleDateFormat;
 import java.util.*;
 import javax.faces.component.UIInput;
 import javax.faces.event.ValueChangeEvent;
 import org.profamilia.hc.model.dto.Cpclinica;
 import org.profamilia.hc.model.exceptions.ModelException;
 import org.profamilia.hc.model.service.ClinicoService;
 import org.profamilia.hc.view.ServiceLocator.ServiceLocator;
 import org.profamilia.hc.view.backing.BaseBean;

 public class BuscadorDisponibilidadSalaBean extends BaseBean
 {

     public BuscadorDisponibilidadSalaBean()
     {
     }

     public void init()
     {
         fechaActual = null;
         lstCirugias = new ArrayList();
         msg_sin_registros = "Sin Consultar.";
     }

     public void setFechaActual(Date fechaActual)
     {
         this.fechaActual = fechaActual;
     }

     public Date getFechaActual()
     {
         return fechaActual;
     }

     public void setLstCirugias(List lstCirugias)
     {
         this.lstCirugias = lstCirugias;
     }

     public List getLstCirugias()
     {
         return lstCirugias;
     }

     public void setFechaActual(ValueChangeEvent valueChangeEvent)
     {
         setFechaActual((Date)valueChangeEvent.getNewValue());
         ((UIInput)valueChangeEvent.getComponent()).setLocalValueSet(false);
     }

     public void changeAgendaCirugia()
     {
         try
         {
             if(fechaActual != null && getClinica() != null)
                 lstCirugias = getServiceLocator().getClinicoService().getConsultasClinicasXDia(fechaActual, Integer.valueOf(0), getClinica().getCclncodigo());
         }
         catch(ModelException e)
         {
             e.printStackTrace();
         }
     }

     public void setExisteCirugia(boolean existeConsulta)
     {
         existeCirugia = existeConsulta;
     }

     public boolean isExisteCirugia()
     {
         if(lstCirugias.size() > 0)
         {
             existeCirugia = true;
         } else
         {
             existeCirugia = false;
             if(fechaActual != null)
             {
                 String DATE_FORMAT = "dd/MM/yyyy";
                 SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                 String fechaCons = sdf.format(fechaActual);
                 msg_sin_registros = (new StringBuilder()).append("No existen Cirugias para el D\355a:  ").append(fechaCons).toString();
             }
         }
         return existeCirugia;
     }

     public void setMsg_sin_registros(String msg_sin_registros)
     {
         this.msg_sin_registros = msg_sin_registros;
     }

     public String getMsg_sin_registros()
     {
         return msg_sin_registros;
     }

     private Date fechaActual;
     private List lstCirugias;
     private String msg_sin_registros;
     boolean existeCirugia;
 }
