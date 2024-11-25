import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class seriesDataSet {
    @DataProvider(name = "seriesCSVData")
    public Object[][] getCSVData() throws IOException {
        String filePath = "./src/test/resources/series.csv";
        List<Object[]> data = new ArrayList<>();
        CSVParser csvParser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withFirstRecordAsHeader());

        for(CSVRecord csvRecord:csvParser){
            String series = csvRecord.get("series");
            String expectedResult = csvRecord.get("expectedResult");
            data.add(new Object[]{series,expectedResult});

        }
        return data.toArray(new Object[0][]);
    }
}

