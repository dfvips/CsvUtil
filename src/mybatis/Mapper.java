package mybatis;

public interface Mapper {
	public int fillTable(String good_name, String order_num, String person_name, String person_phone,
			String person_place, String good_id, String time, String shop);
}
