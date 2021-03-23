package service;

import org.apache.ibatis.session.SqlSession;

import mybatis.Mapper;
import mybatis.MybatisReader;

public class service {

	public static int fillTable(String good_name, String order_num, String person_name, String person_phone,
			String person_place, String good_id, String time, String shop) {
		SqlSession sqlSession = MybatisReader.getSession();
		int num = sqlSession.getMapper(Mapper.class).fillTable(good_name, order_num, person_name, person_phone, person_place, good_id, time, shop);
		sqlSession.commit();
		sqlSession.close();
		return num;
	}
}
