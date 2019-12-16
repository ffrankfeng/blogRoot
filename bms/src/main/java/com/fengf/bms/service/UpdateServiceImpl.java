package com.fengf.bms.service;

import com.fengf.bms.pojo.ArticleQueryVo;
import com.fengf.bms.pojo.Articles;
import com.fengf.common.utils.JedisPoolUtil;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    private JedisPoolUtil jedis;
    @Autowired
    private ArticleService articleService;

    @Override
    public boolean updateRedis() {
        jedis.flushAll();
        return true;
    }

    @Override
    public boolean updateSolr(){
        //创建一个SolrServer对象，创建一个连接。参数solr服务的url
        SolrServer solrServer = new HttpSolrServer("http://fengf-xy.top/solr/collection1");
//        solrServer.up
        try {
            solrServer.deleteByQuery("*:*");
        }catch (SolrServerException |IOException e){
            System.out.println(e);
            return false;
        }
        List<Articles> articles = articleService.selectAllArticles();
        for (Articles article : articles){
            //创建一个文档对象SolrInputDocument
            SolrInputDocument document = new SolrInputDocument();
            //向文档对象中添加域。文档中必须包含一个id域，所有的域的名称必须在schema.xml中定义。
            document.addField("id", article.getArticleId().toString());
            document.addField("item_title", article.getTitle());
            document.addField("item_content", article.getContent());
            document.addField("item_author", article.getAuthor());
            try {
                //把文档写入索引库
                solrServer.add(document);
                //提交
                solrServer.commit();
            } catch (SolrServerException e) {
                System.out.println(e);
                return false;
            } catch (IOException e) {
                System.out.println(e);
                return false;
            }
        }
        return true;
    }
}
