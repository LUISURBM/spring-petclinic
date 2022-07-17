package org.profamilia.hc.view.backing.procedimiento.cargaRips;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import org.apache.myfaces.custom.fileupload.UploadedFile;

import org.profamilia.hc.view.backing.BaseBean;
import org.profamilia.hc.view.util.FacesUtils;
import org.apache.myfaces.custom.fileupload.UploadedFile;

public class CargaImagenBean extends BaseBean {

private UploadedFile imageSrc;

public UploadedFile getImageSrc() {

return imageSrc;

}

public void setImageSrc(UploadedFile imageSrc) {

this.imageSrc = imageSrc;

}

public void uploadFile() {

UploadedFile myFile = getImageSrc();

byte[] buffer = null;

if (myFile != null) {

String extension =  getExtension(myFile);

File outfile = new File("C:/."+extension);

long size = myFile.getSize();

System.out.println("File Size ==>"+size);

try{

OutputStream out = new FileOutputStream(outfile);

InputStream in = new BufferedInputStream(myFile

.getInputStream());

try {

buffer = new byte[64 * 1024];

int count;

while ((count = in.read(buffer)) > 0)

out.write(buffer, 0, count);

} finally {

in.close();

out.close();

}

}catch(Exception e){

e.printStackTrace();

}

}

}

public static String getExtension(UploadedFile f) {

String ext = null;

String s = f.getName();

int i = s.lastIndexOf(".");

if (i > 0 && i < s.length() - 1 ) {

ext = s.substring(i + 1).toLowerCase();

}

return ext;

}
}