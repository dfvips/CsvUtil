package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	public static List<String> reader(String place,String type) {
		//"C:\\Users\\梦丶随心飞\\Desktop\\新建文件夹\\雅丽"
		//".csv"
		List<String> pathList = new ArrayList<String>();
		File[] list = new File(place).listFiles();
        for(File file : list)
        {
           if(file.isFile())
           {
               if (file.getName().endsWith(type)) {
                   // 就输出该文件的绝对路径
                   pathList.add(file.getAbsolutePath());
               }
           }
        }
        return pathList;
	}
}
