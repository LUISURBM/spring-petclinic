package org.profamilia.hc.view.backing.procedimiento.carga;

import java.io.IOException;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import org.profamilia.hc.view.backing.BaseBean;

public class FileUploadForm extends BaseBean
{
  private UploadedFile upFile;
  private String name = "";

  public UploadedFile getUpFile()
  {
    return this.upFile;
  }

  public void setUpFile(UploadedFile upFile)
  {
    this.upFile = upFile;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String upload() throws IOException
  {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    facesContext.getExternalContext().getApplicationMap().put("fileupload_bytes", this.upFile.getBytes());
    facesContext.getExternalContext().getApplicationMap().put("fileupload_type", this.upFile.getContentType());
    facesContext.getExternalContext().getApplicationMap().put("fileupload_name", this.upFile.getName());
    return "ok";
  }

  public boolean isUploaded()
  {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    return facesContext.getExternalContext().getApplicationMap().get("fileupload_bytes") != null;
  }
}