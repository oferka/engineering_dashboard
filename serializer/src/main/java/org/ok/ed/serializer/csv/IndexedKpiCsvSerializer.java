package org.ok.ed.serializer.csv;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.record.Record;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParser;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvParserSettings;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriter;
import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvWriterSettings;
import org.ok.ed.model.data.IndexedKpi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class IndexedKpiCsvSerializer {

    private IndexedKpiCsvSerializerSettings settings;

    public void exportToCsvFile(List<IndexedKpi> indexedKpis, File file) {
        CsvWriterSettings settings = new CsvWriterSettings();
        CsvWriter csvWriter = new CsvWriter(file, settings);
        csvWriter.writeHeaders(getIndexedKpiCsvHeaderLine());
        for(IndexedKpi indexedKpi : indexedKpis) {
            csvWriter.writeRow(getIndexedKpiCsvLine(indexedKpi));
        }
        csvWriter.close();
    }

    public List<IndexedKpi> importFromCsvFile(File file) {
        List<IndexedKpi> result = new ArrayList<>();
        CsvParserSettings settings = new CsvParserSettings();
        CsvParser csvParser = new CsvParser(settings);
        List<Record> records = csvParser.parseAllRecords(file);
//        Record headerRecord = records.get(0);
        for(int i=1; i<records.size(); i++) {
            Record record = records.get(i);
            result.add(getIndexedKpi(record));
        }
        csvParser.stopParsing();
        return result;
    }

    private String[] getIndexedKpiCsvHeaderLine() {
        return new String[] {
                "kpiName",
                "kpiDescription",
                "objectiveName",
                "objectiveDescription",
                "goalName",
                "goalDescription",
                "themeName",
                "themeDescription",
                "dashboardName",
                "dashboardDescription",
                "organizationName",
                "organizationDescription",
                "departmentName",
                "departmentDescription",
                "timePeriod",
                "value"
        };
    }

    private String[] getIndexedKpiCsvLine(IndexedKpi indexedKpi) {
        return new String[] {
                indexedKpi.getKpiName(),
                indexedKpi.getKpiDescription(),
                indexedKpi.getObjectiveName(),
                indexedKpi.getObjectiveDescription(),
                indexedKpi.getGoalName(),
                indexedKpi.getGoalDescription(),
                indexedKpi.getThemeName(),
                indexedKpi.getThemeDescription(),
                indexedKpi.getDashboardName(),
                indexedKpi.getDashboardDescription(),
                indexedKpi.getOrganizationName(),
                indexedKpi.getOrganizationDescription(),
                indexedKpi.getDepartmentName(),
                indexedKpi.getDepartmentDescription(),
                indexedKpi.getTimePeriod(),
                indexedKpi.getValue().toString()
        };
    }

    private IndexedKpi getIndexedKpi(Record record) {
        return new IndexedKpi(
                record.getString(0),
                record.getString(1),
                record.getString(2),
                record.getString(3),
                record.getString(4),
                record.getString(5),
                record.getString(6),
                record.getString(7),
                record.getString(8),
                record.getString(9),
                record.getString(10),
                record.getString(11),
                record.getString(12),
                record.getString(13),
                record.getString(14),
                record.getInt(15)
        );
    }
}
