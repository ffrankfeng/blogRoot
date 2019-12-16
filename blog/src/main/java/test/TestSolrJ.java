package test;

import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.jupiter.api.Test;

public class TestSolrJ {

	@Test
	public void addDocument() throws Exception {
		//创建一个SolrServer对象，创建一个连接。参数solr服务的url
		SolrServer solrServer = new HttpSolrServer("http://fengf-xy.top/solr/collection1");
		//创建一个文档对象SolrInputDocument
		SolrInputDocument document = new SolrInputDocument();
		//向文档对象中添加域。文档中必须包含一个id域，所有的域的名称必须在schema.xml中定义。
		document.addField("id", "doc01");
		document.addField("item_title", "测试标题01");
		document.addField("item_content", "测试内容01");
		document.addField("item_author", "testuser");
		//把文档写入索引库
		solrServer.add(document);
		//提交
		solrServer.commit();
	}
	
	@Test
	public void deleteDocument() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://fengf-xy.top/solr/collection1");
		//删除文档
		//solrServer.deleteById("doc01");
		solrServer.deleteByQuery("id:doc01");
		//提交
		solrServer.commit();
	}
	
	@Test
	public void queryIndex() throws Exception {
		//创建一个SolrServer对象。
		SolrServer solrServer = new HttpSolrServer("http://fengf-xy.top/solr/collection1");
		//创建一个SolrQuery对象。
		SolrQuery query = new SolrQuery();
		//设置查询条件。
		//query.setQuery("*:*");
		query.set("q", "*:*");
		//执行查询，QueryResponse对象。
		QueryResponse queryResponse = solrServer.query(query);
		//取文档列表。取查询结果的总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
		//遍历文档列表，从取域的内容。
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("item_title"));
			System.out.println(solrDocument.get("item_content"));
			System.out.println(solrDocument.get("item_author"));
		}
	}
	
	@Test
	public void queryIndexFuza() throws Exception {
		SolrServer solrServer = new HttpSolrServer("http://fengf-xy.top/solr/collection1");
		//创建一个查询对象
		SolrQuery query = new SolrQuery();
		//查询条件
		query.setQuery("1");
		query.setStart(0);
		query.setRows(50);
		query.set("df", "item_keywords");
		query.setHighlight(true);
		query.addHighlightField("item_title,item_content,item_author");
		query.setHighlightSimplePre("<em>");
		query.setHighlightSimplePost("</em>");
		//执行查询
		QueryResponse queryResponse = solrServer.query(query);
		//取文档列表。取查询结果的总记录数
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		System.out.println("查询结果总记录数：" + solrDocumentList.getNumFound());
		//遍历文档列表，从取域的内容。
		Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			//取高亮显示
			List<String> title_list = highlighting.get(solrDocument.get("id")).get("item_title");
			String title = "";
			if (title_list !=null && title_list.size() > 0 ) {
				title = title_list.get(0);
			} else {
				title = (String) solrDocument.get("item_title");
			}
			List<String> content_list = highlighting.get(solrDocument.get("id")).get("item_content");
			String content = "";
			if (content_list !=null && content_list.size() > 0 ) {
				content = content_list.get(0);
			} else {
				content = (String) solrDocument.get("item_content");
			}
			List<String> author_list = highlighting.get(solrDocument.get("id")).get("item_title");
			String author = "";
			if (author_list !=null && author_list.size() > 0 ) {
				author = author_list.get(0);
			} else {
				author = (String) solrDocument.get("item_author");
			}
//			System.out.println(title);
//			System.out.println(content);
//			System.out.println(author);
		}
	}
	
}
