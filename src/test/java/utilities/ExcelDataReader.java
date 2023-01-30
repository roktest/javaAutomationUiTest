package utilities;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExcelDataReader implements IDataReader{

    private final ExcelConfiguration excelConfiguration;
    private Logger logger = LoggerFactory.getLogger(ExcelDataReader.class);

    public ExcelDataReader(ExcelConfiguration excelConfiguration){
        this.excelConfiguration = excelConfiguration;
    }

    // 1 get instance of work book
    private XSSFWorkbook getWorkBook() throws IOException, InvalidFormatException {
        return new XSSFWorkbook(new File(excelConfiguration.getFileLocation()));
    }

    // 2 get the sheet using the work book object
    private XSSFSheet getSheet(XSSFWorkbook workbook){
        return workbook.getSheet(excelConfiguration.getSheetName());
    }

    // 3 get the header from the Excel file
    private List<String> getHeaders(XSSFSheet sheet){
        List<String> headers = new ArrayList<String>();
        XSSFRow row = sheet.getRow(0);
        row.forEach(new Consumer<Cell>() {
            @Override
            public void accept(Cell cell) {
                headers.add(cell.getStringCellValue());
            }
        });
        return Collections.unmodifiableList(headers);
    }


    @Override
    public List<Map<String, String>> getAllRows() {
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        try(XSSFWorkbook workbook = getWorkBook()) {
            XSSFSheet sheet = getSheet(workbook);
            data = getData(sheet);

        } catch (Exception e){
            logger.error(e, new Supplier<String>() {
                @Override
                public String get() {
                    return String.format("Not able to read the %s from location %s", excelConfiguration.getFileName(), excelConfiguration.getFileLocation());
                }
            });
            return Collections.emptyList();
        }
        return data;
    }

    private List<Map<String, String>> getData(XSSFSheet sheet){
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        List<String> headers = getHeaders(sheet);

        for (int i = 1; i<= sheet.getLastRowNum(); i++){
            Map<String, String> rowMap = new HashedMap<String, String>();
            XSSFRow row =sheet.getRow(i);

            forEachWithCounter(row, new BiConsumer<Integer, Cell>() {
                @Override
                public void accept(Integer integer, Cell cell) {
                    String header = headers.get(integer);
                    String value = cell.getStringCellValue();
                    rowMap.put(header, value);
                }
            });
            data.add(rowMap);
        }
        return Collections.unmodifiableList(data);
    }

    @Override
    public Map<String, String> getRow() {
        Map<String, String> data = new HashedMap<String, String>();
        try(XSSFWorkbook workbook = getWorkBook()) {
            XSSFSheet sheet = getSheet(workbook);
            data = getData(sheet, excelConfiguration.getIndex());

        } catch (Exception e){
            logger.error(e, new Supplier<String>() {
                @Override
                public String get() {
                    return String.format("Not able to read the %s from location %s", excelConfiguration.getFileName(), excelConfiguration.getFileLocation());
                }
            });
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(data);
    }

    private Map<String, String> getData(XSSFSheet sheet, int rowIndex){
        List<String> headers = getHeaders(sheet);
        Map<String, String> rowMap = new HashedMap<String, String>();

        XSSFRow row = sheet.getRow(rowIndex);
        forEachWithCounter(row, new BiConsumer<Integer, Cell>() {
            @Override
            public void accept(Integer integer, Cell cell) {
                String header = headers.get(integer);
                String value = cell.getStringCellValue();
                rowMap.put(header, value);
            }
        });

        return Collections.unmodifiableMap(rowMap );
    }

    private void forEachWithCounter(Iterable<Cell> source, BiConsumer<Integer, Cell> biConsumer){
        int i = 0;
        for(Cell cell : source){
            biConsumer.accept(i, cell);
            i++;
        }
    }
}