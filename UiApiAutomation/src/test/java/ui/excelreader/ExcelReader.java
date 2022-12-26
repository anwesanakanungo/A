package ui.excelreader;

import com.creditdatamw.zerocell.Reader;
import java.io.File;
import java.util.List;

public final class ExcelReader {
    private  ExcelReader() {
    }


    public static List<DataModel> getDataModels() {
        return dataModels;
    }

    private static List<DataModel> dataModels = null ;

   static {
      dataModels = Reader.
               of(DataModel.class).
               from(new File(
                       System.getProperty("user.dir") + "/src/main/resources/testdata/TestData.xlsx"
               ))
               .sheet("Sheet1") //sheet name to read
               .skipHeaderRow(true) //skipping headers
               .list();
   }
    }

