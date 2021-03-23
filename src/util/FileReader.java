package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	public static List<String> reader(String place,String type) {
		//"C:\\Users\\��ؼ���ķ�\\Desktop\\�½��ļ���\\����"
		//".csv"
		List<String> pathList = new ArrayList<String>();
		File[] list = new File(place).listFiles();
        for(File file : list)
        {
           if(file.isFile())
           {
               if (file.getName().endsWith(type)) {
                   // ��������ļ��ľ���·��
                   pathList.add(file.getAbsolutePath());
               }
           }
        }
        return pathList;
	}
}
