package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.tableBrush;

/**
 * Created by wdnnccey on 17/2/27.
 * <p>
 * <p>
 * 2017年02月27日21:27:26，
 *
 */
public class CvsBrush {

    public static List<tableBrush> copy(String path){

        File excelFile = new File(path); //替换你文档地址
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfSheets = wb.getNumberOfSheets();
        ArrayList<tableBrush> list = new ArrayList<tableBrush>();
        for (int x = 0; x < numberOfSheets; x++) {
            XSSFSheet sheet = wb.getSheetAt(x);
            int columnNum = 0;
            if (sheet.getRow(0) != null) {
                columnNum = sheet.getRow(0).getLastCellNum()
                        - sheet.getRow(0).getFirstCellNum();
            }
            if (columnNum > 0) {
                for (Row row : sheet) {
                	String str = "";
                    String[] singleRow = new String[columnNum];
                    int n = 0;
                    for (int i = 0; i < columnNum; i++) {
                        Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                        String temp = "";
                        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        	DecimalFormat df = new DecimalFormat("#");
                        	temp = df.format(cell.getNumericCellValue());
                        }else {
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            temp = cell.getStringCellValue();
                        }
                        singleRow[n] = temp.trim();
                        str += singleRow[n] + ",";
                        n++;
                    }
                    if(str.startsWith(",,,,,")) {
                    	break;
                    }
                    tableBrush tb = new tableBrush();
    				String s[] = str.split(",");
    				String orderNum = null;
    				String personName = null;
    				String personPhone = null;
    				for (int i = 0; i < s.length; i++) {
    					try {
        					orderNum = s[2].trim();
    					}catch (Exception e) {
							// TODO: handle exception
    						orderNum = null;
						}
    					try {
        					personName = s[3].trim();
    					}catch (Exception e) {
							// TODO: handle exception
    						personName = null;
						}
    					try {
    						personPhone = s[4].trim();
    					}catch (Exception e) {
    						personPhone = null;
    					}
    				}
    				tb.setOrderNum(orderNum);
    				tb.setPersonName(personName);
    				tb.setPersonPhone(personPhone);
    				list.add(tb);
                }
            }
        }
        return list;
    }
}