import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    
    public static String outputFile = "D:\\test.xls";

    public static void main(String argv[]) {

        String[][] data={{"科目","分数"},{"语文","99"},{"数学","100"},{"英语","120"}};

        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("学生成绩");
            for(int i=0;i<data.length;i++){
                HSSFRow row=sheet.createRow((short)i);
                for(int j=0;j<data[i].length;j++){
                    HSSFCell cell=row.createCell((short)j);
                    cell.setCellValue(data[i][j]);
                }
            }
            
            /*
            HSSFRow row = sheet.createRow((short)0);
            HSSFRow row1=sheet.createRow((short)1);
            HSSFRow row2=sheet.createRow((short)2);
            HSSFRow row3=sheet.createRow((short)3);

            HSSFCell cell01 = row.createCell((short)0);
            HSSFCell cell02 = row.createCell((short)1);
            HSSFCell cell11=row1.createCell((short)0);
            HSSFCell cell12=row1.createCell((short)1);
            HSSFCell cell21=row2.createCell((short)0);
            HSSFCell cell22=row2.createCell((short)1);
            HSSFCell cell31=row3.createCell((short)0);
            HSSFCell cell32=row3.createCell((short)1);
            
            cell01.setCellValue("科目");
            cell02.setCellValue("分数");
            cell11.setCellValue("语文");
            cell12.setCellValue("99");
            cell21.setCellValue("数学");
            cell22.setCellValue("100");
            cell31.setCellValue("英语");
            cell32.setCellValue("120");
           */

            FileOutputStream fOut = new FileOutputStream(outputFile);
            workbook.write(fOut);
            fOut.flush();
            
            fOut.close();
            System.out.println("文件已生成！");
        } catch (Exception e) {
            System.out.println("xlCreate() : " + e);
        }
    }
}