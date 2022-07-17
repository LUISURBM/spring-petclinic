package org.profamilia.hc.view.backing.comun;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import org.profamilia.hc.view.backing.BaseBean;

public class SubirImagenBean extends BaseBean {
	private UploadedFile upload;

	public UploadedFile getUpload() {
		return upload;
	}

	public void setUpload(UploadedFile upload) {
		this.upload = upload;
	}

	public SubirImagenBean() {

	}

	public String uploadFile() {
		File savedFileName;
		String dirPath = "c:\\Temp\\";
		InputStream fileContent = null;
		if (upload == null) {
			return "success";
		}
		try {
			fileContent = upload.getInputStream();

		} catch (IOException e) {
			e.printStackTrace();
		}
		String uploadFileName = trimFilePath(upload.getName());
		savedFileName = new File(dirPath + uploadFileName);
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(savedFileName));
		} catch (FileNotFoundException e) {
		}
		byte[] buffer = new byte[1024];
		int len;
		try {
			while ((len = fileContent.read(buffer)) >= 0) {
				bos.write(buffer, 0, len);
			}
		} catch (IOException e) {
		}
		try {
			fileContent.close();
			bos.close();
		} catch (IOException e) {
		}
		return "success";
	}

	public static String trimFilePath(String fileName) {
		return fileName.substring(fileName.lastIndexOf("/") + 1).substring(
				fileName.lastIndexOf("\\") + 1);
	}
}