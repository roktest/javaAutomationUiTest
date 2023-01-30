package utilities;

import java.util.List;
import java.util.Map;

public interface IDataReader {

    /**
     * Method to get all the rows from an Excel file
     *
     * @return List<Map<String, String>>
     */
    public List<Map<String, String>> getAllRows();

    /**
     * Method to get a single row from an Excel file
     *
     * @return Map<String, String>
     */
    public Map<String, String> getRow();

}
