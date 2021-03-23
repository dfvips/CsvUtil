package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Output {
	/**
	 * ����txt·����ȡtxt�ļ�
	 * 
	 * @param txtPath
	 * @return ���ض�ȡ��������
	 */
	public static String readTxt(String txtPath) {
		File file = new File(txtPath);
		if (file.isFile() && file.exists()) {
			try {
				FileInputStream fileInputStream = new FileInputStream(file);
				InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

				StringBuffer sb = new StringBuffer();
				String text = null;
				while ((text = bufferedReader.readLine()) != null) {
					sb.append(text);
				}
				return sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * ʹ��FileOutputStream��д��txt�ļ�
	 * 
	 * @param txtPath txt�ļ�·��
	 * @param content ��Ҫд����ı�
	 */
	public static void writeTxt(String txtPath, String content) {
		FileOutputStream fileOutputStream = null;
		File file = new File(txtPath);
		try {
			if (file.exists()) {
				file.createNewFile();
			}
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(content.getBytes());
			fileOutputStream.flush();
			fileOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isphone(String phone) {
		String regx = "^1(3([0-35-9]\\d|4[1-8])|4[14-9]\\d|5([0125689]\\d|7[1-79])|66\\d|7[2-35-8]\\d|8\\d{2}|9[89]\\d)\\d{7}$";
		Pattern p = Pattern.compile(regx);
		Matcher m = p.matcher(phone);
		return m.matches();
	}
}