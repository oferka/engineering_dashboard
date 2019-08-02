package org.ok.ed.es.loader;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.ok.ed.model.data.IndexedKpi;
import org.ok.ed.serializer.csv.IndexedKpiCsvSerializer;
import org.ok.ed.serializer.csv.IndexedKpiCsvSerializerSettings;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class IndexedKpiElasticsearchLoader {

    private IndexedKpiElasticsearchLoaderSettings settings;

    public void load(List<IndexedKpi> indexedKpis) throws IOException {
        RestHighLevelClient client = getClient();
        for(IndexedKpi indexedKpi : indexedKpis) {
            index(client, indexedKpi);
        }
        client.close();
    }

    public void loadFromCsvFile(File file) throws IOException {
        IndexedKpiCsvSerializerSettings settings = new IndexedKpiCsvSerializerSettings();
        IndexedKpiCsvSerializer indexedKpiCsvSerializer = new IndexedKpiCsvSerializer(settings);
        List<IndexedKpi> indexedKpis = indexedKpiCsvSerializer.importFromCsvFile(file);
        load(indexedKpis);
    }

    private RestHighLevelClient getClient() {
         return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")
                )
        );
    }

    private void index(RestHighLevelClient client, IndexedKpi indexedKpi) throws IOException {
        IndexRequest indexRequest = getIndexRequest(indexedKpi);
        client.index(indexRequest, RequestOptions.DEFAULT);
    }

    private IndexRequest getIndexRequest(IndexedKpi indexedKpi) {
        return new IndexRequest("engineering_dashboard_kpis")
                .type("engineering_dashboard_kpis")
//                .id("2")
                .source(getSourceMap(indexedKpi));
    }

    private Map getSourceMap(IndexedKpi indexedKpi) {
        Map<String, Object> result = new HashMap<>();
        result.put("kpiName", indexedKpi.getKpiName());
        result.put("kpiDescription", indexedKpi.getKpiDescription());
        result.put("objectiveName", indexedKpi.getObjectiveName());
        result.put("objectiveDescription", indexedKpi.getObjectiveDescription());
        result.put("goalName", indexedKpi.getGoalName());
        result.put("goalDescription", indexedKpi.getGoalDescription());
        result.put("themeName", indexedKpi.getThemeName());
        result.put("themeDescription", indexedKpi.getThemeDescription());
        result.put("dashboardName", indexedKpi.getDashboardName());
        result.put("dashboardDescription", indexedKpi.getDashboardDescription());
        result.put("organizationName", indexedKpi.getOrganizationName());
        result.put("organizationDescription", indexedKpi.getOrganizationDescription());
        result.put("departmentName", indexedKpi.getDepartmentName());
        result.put("departmentDescription", indexedKpi.getDepartmentDescription());
        result.put("timePeriod", indexedKpi.getTimePeriod());
        result.put("value", indexedKpi.getValue());
        result.put("postDate", new Date());
        return result;
    }
}
