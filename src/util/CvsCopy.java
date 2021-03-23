package util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import entity.tableAll;

public class CvsCopy {
	@SuppressWarnings("resource")
	public static List<tableAll> copy(String path) {
		File csv = new File(path);
		BufferedReader br = null;
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(csv), "UTF-8");  
			br = new BufferedReader(isr);    
			String line = "";
			ArrayList<tableAll> list = new ArrayList<tableAll>();
			while ((line = br.readLine()) != null) { // 读取到的内容给line变量
				String goodsName = null;
				String orderNum = null;
				String personName = null;
				String personPhone = null;
				String perPlace = null;
				String goodId = null;
				String time = null;
				tableAll tb = new tableAll();
				String s[] = line.split(",");
				if(s.length<50) {
					System.out.println(line);
				}

				for (int i = 0; i < s.length; i++) {
					if(s.length>50) {
						goodsName = s[0].trim();
						orderNum = s[1].trim();
						personName = s[14].trim();
						personPhone = s[15].trim();
						perPlace = s[17]+s[18]+s[19]+s[20].trim();
						goodId = s[26].trim();
						time = s[21].trim();
						if(Output.isphone(personPhone)==false) {
							goodsName = s[0].trim();
							orderNum = s[1].trim();
							personName = s[15].trim();
							personPhone = s[16].trim();
							perPlace = s[18]+s[19]+s[20]+s[21].trim();
							goodId = s[28].trim();
							time = s[22].trim();
						}
					}else {
						goodsName = s[0].trim();
						orderNum = s[1].trim();
						personName = s[4].trim();
						personPhone = s[5].trim();
						perPlace = s[7]+s[8]+s[9]+s[10].trim();
						goodId = s[13].trim();
						time = s[11].trim();
					}
					
				}
				tb.setGoodId(goodId);
				tb.setGoodsName(goodsName);
				tb.setOrderNum(orderNum);
				tb.setPerPlace(perPlace);
				tb.setPersonName(personName);
				tb.setPersonPhone(personPhone);
				tb.setTime(time);
				list.add(tb);
			}
			return list;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
