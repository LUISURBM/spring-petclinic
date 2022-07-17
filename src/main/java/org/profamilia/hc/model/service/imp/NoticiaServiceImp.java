// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:36:16 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoServiceImp.java

package org.profamilia.hc.model.service.imp;

import java.math.BigDecimal;
import java.util.*;

import javax.faces.model.SelectItem;

import org.profamilia.hc.model.dto.*;
import org.profamilia.hc.model.exceptions.DAOException;
import org.profamilia.hc.model.exceptions.ModelException;
import org.profamilia.hc.model.dao.ClinicoDao;
import org.profamilia.hc.model.dao.NoticiaDao;
import org.profamilia.hc.model.dao.RipsDao;
import org.profamilia.hc.model.service.ClinicoService;
import org.profamilia.hc.model.service.NoticiaService;
import org.profamilia.hc.model.service.RipsService;

public class NoticiaServiceImp implements NoticiaService{
       private NoticiaDao noticiaDAO;


    public void saveOrUpdateNoticia(Chnoticia noticia) throws ModelException {
        noticiaDAO.saveOrUpdateNoticia(noticia);
    }

    public List<Chnoticia> readNoticia() throws ModelException {
        return noticiaDAO.readNoticia();
    }

    public void setNoticiaDAO(NoticiaDao noticiaDAO) {
        this.noticiaDAO = noticiaDAO;
    }

    public NoticiaDao getNoticiaDAO() {
        return noticiaDAO;
    }
}
