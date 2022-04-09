import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import comee.Application;
import comee.entity.Emp;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@SpringBootTest(classes = Application.class)
public class EsMain {

    PreBuiltTransportClient pt;

    {
        try {
            pt = init();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    //@Test
    //创建连接
    public PreBuiltTransportClient init() throws UnknownHostException {
        PreBuiltTransportClient preBuiltTransportClient = new
                PreBuiltTransportClient(Settings.EMPTY);
        preBuiltTransportClient.addTransportAddress(new TransportAddress(
                InetAddress.getByName("192.168.230.131"),9300
        ));
//        System.out.println(preBuiltTransportClient.);
        return preBuiltTransportClient;
    }

    //创建索引
    @Test
    public void createIndex() throws UnknownHostException, ExecutionException, InterruptedException{
        PreBuiltTransportClient pt = this.init();

        CreateIndexRequest eme = new CreateIndexRequest("eme");

        CreateIndexResponse cir = pt.admin().indices().create(eme).get();
        System.out.println(cir.isAcknowledged());
    }

    //删除索引
    @Test
    public void deleteIndex() throws UnknownHostException, ExecutionException, InterruptedException{
        PreBuiltTransportClient pt = init();
        DeleteIndexRequest ems = new DeleteIndexRequest("eme");

        AcknowledgedResponse acknowledgedRequest = pt.admin().indices().delete(ems).get();

        System.out.println(acknowledgedRequest);
    }

    //创建索引和数据类型
    @Test
    public void createTable() throws UnknownHostException, ExecutionException, InterruptedException{
        PreBuiltTransportClient pt = init();
        //创建索引
        CreateIndexRequest ems = new CreateIndexRequest("emt");
        //定义json格式
        String json = "{\"properties\":{\"name\":{\"type\":\"text\",\"analyzer\":\"ik_max_word\"},\"age\":{\"type\":\"integer\"},\"sex\":{\"type\":\"keyword\"},\"content\":{\"type\":\"text\",\"analyzer\":\"ik_max_word\"}}}";
        //设置类型和mapping
        ems.mapping("emp",json, XContentType.JSON);
        //执行创建
        CreateIndexResponse ci = pt.admin().indices().create(ems).get();
        System.out.println(ci.isAcknowledged());
    }

    //添加数据
    @Test
    public void insert() throws JsonProcessingException{
        Emp emp = new Emp("小陈", 23, "男", "这是一个单纯的少年,单纯的我!");
        String s = JSONObject.toJSONString(emp);
        IndexResponse indexResponse = pt.prepareIndex("emt","emp","1").setSource(s, XContentType.JSON).get();
        System.out.println(indexResponse.status());
    }

    //添加数据时自动生成id
    @Test
    public void insert2() throws JsonProcessingException{
        Emp emp = new Emp("小陈", 23, "男", "这是一个单纯的少年,单纯的我!");
        String s = JSONObject.toJSONString(emp);
        IndexResponse indexResponse = pt.prepareIndex("emt","emp").setSource(s, XContentType.JSON).get();
        System.out.println(indexResponse.status());
    }

    //更新索引
    @Test
    public void update() throws IOException{
        Emp emp = new Emp();
        emp.setName("giaogiao");
        String s = JSONObject.toJSONString(emp);
        UpdateResponse updateResponse = pt.prepareUpdate("emt","emp","1").setDoc(s, XContentType.JSON).get();
        System.out.println(updateResponse);
    }

    //删除索引
    @Test
    public void delete(){
        DeleteResponse deleteResponse = pt.prepareDelete("emt","emp","1").get();
        System.out.println(deleteResponse.status());
    }

    //批量操作
    @Test
    public void totalUpdate(){
        IndexRequest request1 = new IndexRequest("emt","emp","1");
        Emp emp1 = new Emp("中国科技", 23, "男", "这是好人");
        request1.source(JSONObject.toJSONString(emp1),XContentType.JSON);
        IndexRequest request2 = new IndexRequest("emt","emp","2");
        Emp emp2 = new Emp("中国科技", 23, "男", "这是好人");
        request2.source(JSONObject.toJSONString(emp2),XContentType.JSON);
        UpdateRequest updateRequest = new UpdateRequest("emt","emp","1");
        Emp empUpdate = new Emp();
        empUpdate.setName("中国力量");
        updateRequest.doc(JSONObject.toJSONString(empUpdate),XContentType.JSON);
        BulkResponse bulkItemResponses = pt.prepareBulk().add(request1).add(request2).add(updateRequest).get();
    }

    public void getResult(SearchHits hits){
        System.out.println("符合条件记录数： " + hits.totalHits);
        for (SearchHit hit : hits){
            System.out.print("当前索引分数" + hit.getScore());
            System.out.print(",对应结果:" + hit.getSourceAsString());
            System.out.println(",指定字段结果：" + hit.getSourceAsMap().get("name"));
            System.out.println("=================================");
        }
    }
    //查询所有并排序
    @Test
    public void machAll(){
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(QueryBuilders.matchAllQuery()).addSort("age", SortOrder.DESC).get();
        SearchHits searchHits = response.getHits();
        getResult(searchHits);
    }

    //分页查询
    @Test
    public void formMachAll(){
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(QueryBuilders.matchAllQuery()).setFrom(0).setSize(2).get();
        getResult(response.getHits());
    }

    //查询返回字段
    @Test
    public void machOofAll(){
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(QueryBuilders.matchAllQuery()).setFetchSource("*","age").get();
        getResult(response.getHits());
    }

    //term查询
    @Test
    public void tTerm(){
        TermQueryBuilder builder = QueryBuilders.termQuery("name","中国");
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(builder).get();
        getResult(response.getHits());
    }

    //range查询
    @Test
    public void tRange(){
        RangeQueryBuilder builder = QueryBuilders.rangeQuery("age").lt(50).gte(8);
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(builder).get();
        getResult(response.getHits());
    }

    //prefix查询
     @Test
    public void tPrefix(){
         PrefixQueryBuilder builder = QueryBuilders.prefixQuery("name", "中");
         SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                 .setQuery(builder).get();
         getResult(response.getHits());
    }

    //wildcard查询
    @Test
    public void tWildcard(){
        WildcardQueryBuilder builder = QueryBuilders.wildcardQuery("name","国*");
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(builder).get();
        getResult(response.getHits());
    }

    //fuzzy查询
    @Test
    public void tFuzzy(){
        FuzzyQueryBuilder builder = QueryBuilders.fuzzyQuery("content","少年");
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(builder).get();
        getResult(response.getHits());
    }

    //ids查询
    @Test
    public void tIds(){
        IdsQueryBuilder builder = QueryBuilders.idsQuery().addIds("1","RWUfTnsBpWTI04bHW84L");
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(builder).get();
        getResult(response.getHits());
    }

    //bool查询
    @Test
    public void tBool(){
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        builder.should(QueryBuilders.matchAllQuery());
        builder.must(QueryBuilders.termQuery("name","中国"));
        builder.mustNot(QueryBuilders.idsQuery().addIds("1"));
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .setQuery(builder).get();
        getResult(response.getHits());
    }

    //高亮查询
    @Test
    public void tHighLight(){
        TermQueryBuilder builder = QueryBuilders.termQuery("name","中国");
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.requireFieldMatch(false).field("name").field("content")
                .preTags("<span style='color:red'>").postTags("</span>");
        SearchResponse response = pt.prepareSearch("emt").setTypes("emp")
                .highlighter(highlightBuilder).setQuery(builder).get();
        SearchHits hits = response.getHits();
        System.out.println("符合条件记录数： " + hits.totalHits);
        for (SearchHit hit : hits){
            Map<String,Object> map1 = hit.getSourceAsMap();
            Map<String, HighlightField> map2 = hit.getHighlightFields();
            System.out.println("================高亮之前==========");
            for(Map.Entry<String,Object> entry:map1.entrySet()){
                System.out.println("key: "+entry.getKey() +"   value: "+entry.getValue());
            }
            System.out.println("================高亮之后==========");
            for (Map.Entry<String,Object> entry:map1.entrySet()){
                HighlightField highlightField = map2.get(entry.getKey());
                if (highlightField!=null){
                    System.out.println("key: "+entry.getKey() +"   value: "+ highlightField.fragments()[0]);

                }else{
                    System.out.println("key: "+entry.getKey() +"   value: "+entry.getValue());
                }
            }
        }
    }
}
