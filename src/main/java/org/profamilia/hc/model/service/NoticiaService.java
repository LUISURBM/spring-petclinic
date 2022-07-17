// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 29/09/2016 5:34:44 p. m.
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ClinicoService.java

package org.profamilia.hc.model.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.profamilia.hc.model.dto.Chnoticia;
import org.profamilia.hc.model.exceptions.DAOException;
import org.profamilia.hc.model.exceptions.ModelException;

public interface NoticiaService
{
    public void saveOrUpdateNoticia(Chnoticia noticia)throws ModelException;
    public List<Chnoticia> readNoticia()throws ModelException;
}

