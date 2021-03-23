package test;

import static org.hamcrest.CoreMatchers.nullValue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.BigIntegerConversion;

import com.sun.xml.internal.ws.util.StringUtils;

import entity.tableAll;
import entity.tableBrush;
import service.service;
import util.*;

class Test {

	@org.junit.jupiter.api.Test
	public void test() {
//		CvsCopy.copy();
//		Cvsbrush.copy();
		List<String> Csvlist = FileReader.reader("C:\\Users\\��ؼ���ķ�\\Desktop\\�½��ļ���\\������", ".csv");
		List<tableAll> tableall = new ArrayList<tableAll>();
		for (String path : Csvlist) {
			List<tableAll> current = CvsCopy.copy(path);
			for (tableAll tableAll : current) {
				tableall.add(tableAll);
			}
		}
		tableall = Combine1(tableall);
		List<tableBrush> brushall = new ArrayList<tableBrush>();
		List<String> Brushlist = FileReader.reader("C:\\Users\\��ؼ���ķ�\\Desktop\\�½��ļ���\\������ˢ��", ".xlsx");
		String shop = "������";
		for (String path : Brushlist) {
			List<tableBrush> current = CvsBrush.copy(path);
			for (tableBrush tableBrush : current) {
				brushall.add(tableBrush);
			}
		}
		brushall = Combine2(brushall);
		List<tableAll> result = Combine(tableall,brushall);
		int i = 0;
		for (tableAll tableAll2 : result) {
			if(i<1) {
				i++;
				continue;
			}
			String good_name = tableAll2.getGoodsName();
			String order_num = tableAll2.getOrderNum();
			String person_name = tableAll2.getPersonName().replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.��,��������]+","-_-"); 
			String person_phone = tableAll2.getPersonPhone();
			String person_place = tableAll2.getPerPlace().replaceAll("[^0-9a-zA-Z\u4e00-\u9fa5.��,��������]+","-_-");
			String good_id = tableAll2.getGoodId();
			String time = tableAll2.getTime();
			service.fillTable(good_name, order_num, person_name, person_phone, person_place, good_id, time, shop);
		}
//		Output.writeTxt("C:\\Users\\��ؼ���ķ�\\Desktop\\333.txt", result.toString());
//		System.out.println(Output.isphone("18350267321"));
//		System.out.println(Output.isphone("��¶Ƚ"));
	}

	public static List<tableAll> Combine1(List<tableAll> list) {
		System.out.println("Դ����������"+list.size());
		for (int i = 0; i < list.size(); i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).getOrderNum().equals(list.get(i).getOrderNum())) {
					list.remove(j);
				}
			}
		}
		System.out.println("Դȥ�غ�"+list.size());
		return list;
	}

	public static List<tableBrush> Combine2(List<tableBrush> list) {
		System.out.println("ˢ������������"+list.size());
		for (int i = 0; i < list.size(); i++) {
			for (int j = list.size() - 1; j > i; j--) {
				try {
					if (list.get(j).getOrderNum().equals(list.get(i).getOrderNum())) {
						list.remove(j);
					}
				}catch (Exception e) {
					// TODO: handle exception
					if(list.get(j).getPersonPhone()==null) {
						list.remove(j);
					}
				}

			}
		}
		System.out.println("ˢ����ȥ�غ�"+list.size());
		return list;
	}
	
	public static List<tableAll> Combine(List<tableAll> list1,List<tableBrush> list2) {
		for (int i = 0; i < list1.size(); i++) {
			for (int j = 0;j<list2.size();j++) {
				try {
					if (list1.get(i).getOrderNum().equals(list2.get(j).getOrderNum())) {
						list1.remove(i);
					}
					if(Output.isphone(list1.get(i).getPersonPhone())==false) {
						list1.remove(i);
					}
				}catch (Exception e) {
					// TODO: handle exception
//					if(list1.get(i).getPersonPhone()==null) {
//						list1.remove(i);
//					}
				}

			}
		}
		System.out.println("���������������"+list1.size());
		return list1;
	}
}
