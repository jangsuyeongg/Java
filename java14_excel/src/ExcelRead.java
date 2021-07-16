import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelRead {

	public ExcelRead() {
		
	}
	public void start() {
		try {
			File file = new File("D://testFile","member.xls");
			FileInputStream fis = new FileInputStream(file);
			
			//byteCode인 InputStream을 excel 파일로 변환하는 클래스
			POIFSFileSystem poi = new POIFSFileSystem(fis);
			
			//1.workbook 객체 얻어오기
			HSSFWorkbook workbook = new HSSFWorkbook(poi);
			
			//시트의 수 구하기
			int sheetCnt =workbook.getNumberOfSheets();
			System.out.println("시트수 = "+ sheetCnt);
			
			//2. sheet객체 얻어오기
			
			HSSFSheet sheet = workbook.getSheet("회원목록");//workbook.getSheetAt(1)
			//행의 수 구하기
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("행의수 = " + rowCount);
			
			//제목
			System.out.println("번호\t이름\t연락처\t\t나이\t등록일");
			
			for(int rowIdx=1;rowIdx<rowCount;rowIdx++) {//1,2,3
				//3. 행객체를 구하기 
				HSSFRow row = sheet.getRow(rowIdx);
				
				//셀수 구하기
				int cellCount = row.getPhysicalNumberOfCells();
				//System.out.println("셀의수 = " + cellCount);
				for(int cellIdx =0;cellIdx<cellCount;cellIdx++) {//0,1,2,3,4
					 HSSFCell cell = row.getCell(cellIdx);
					 //번호, 나이
					 if(cellIdx==0 || cellIdx==3) {
						 int data = (int)cell.getNumericCellValue(); 
						 System.out.print(data+"\t");
					 //이름, 연락처
					 }else if(cellIdx==1 || cellIdx==2) {
						 String data = cell.getStringCellValue();
						 System.out.print(data+"\t");
					 //등록일
					 }else if(cellIdx==4) {//등록일
						 Date date = cell.getDateCellValue();
						 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
						 String dateStr = format.format(date);
						 System.out.println(dateStr);	 
					 }
				}
				//System.out.println();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ExcelRead().start();

	}
}
