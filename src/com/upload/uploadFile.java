package com.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

public class uploadFile {

	public String[] upload(File proFile[], String proFileFileName[]) throws Exception {
		try {	
			if (proFile != null && proFile.length > 0) {
				String[] names = new String[proFile.length];
				for (int i = 0; i < proFile.length; i++) {
					if (proFile[i].length() > 0) {// �ж���û��ͼƬ
						String prffix =proFileFileName[i]
								.substring(proFileFileName[i].lastIndexOf("."));
						System.out.println(prffix);
						if (prffix.equalsIgnoreCase(".jpg")
								|| prffix.equalsIgnoreCase(".gif")) {// �жϸ�ʽ
							String proname = new Date().getTime()+""+i
									+ prffix;
							System.out.println(proname);
							InputStream is = new FileInputStream(proFile[i]);
							OutputStream os = new FileOutputStream(new File("D:\\repast\\WebRoot\\images\\"+proname));
							int n = -1;
							byte b[] = new byte[1024];
							while ((n = is.read(b)) > 0) {
								os.write(b, 0, n);
							}
							// proname��Ҫ��������ֱ���� ͼƬ���ݱ��·������
							os.close();
							is.close();
							names[i] = proname;
						} else {
							throw new RuntimeException("ͼƬ�����Ϲ���");
						}
					}
				}
				return names;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}

