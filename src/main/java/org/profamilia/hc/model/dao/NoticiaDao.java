package org.profamilia.hc.model.dao;

import java.util.List;

import org.profamilia.hc.model.dto.Chnoticia;
import org.profamilia.hc.model.exceptions.ModelException;

public interface NoticiaDao {

    public void saveOrUpdateNoticia(Chnoticia noticia)throws ModelException;
    public List<Chnoticia> readNoticia()throws ModelException;

}
