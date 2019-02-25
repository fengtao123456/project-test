package cn.newyork.base.utils;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LuceneUtil {

    private static final String INDEX_DIRCTORY = "D:\\java_study\\object\\dms\\base_utils\\log\\";
    private static Directory directory;//存放索引的目录
    private static IndexWriter indexWriter;//索引写对象，线程安全
    private static IndexReader indexReader;//索引读对象，线程安全
    private static IndexSearcher indexSearcher;//索引查询对象，线程安全
    private static Analyzer analyzer;//分词器对象

    static{
        try {
            //如果父目录不存在，先创建父目录
            File file = new File(INDEX_DIRCTORY);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            directory = FSDirectory.open(Paths.get(INDEX_DIRCTORY));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取IndexWriter对象
     * @return
     * @throws IOException
     */
    public static IndexWriter getIndexWriter(){
        try {
            if(indexWriter==null){
                Analyzer analyzer = getAnalyzer();
                IndexWriterConfig conf = new IndexWriterConfig(analyzer);
                indexWriter = new IndexWriter(directory,conf);
            }
            return indexWriter;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取IndexReader
     * @return
     * @throws Exception
     */
    public static IndexReader getIndexReader(){
        try {
            if(indexReader==null){
                indexReader = DirectoryReader.open(directory);
            }else {
                //如果不为空，就使用DirectoryReader打开一个索引变更过的IndexReader类
                DirectoryReader newIndexReader = DirectoryReader.openIfChanged((DirectoryReader) indexReader);
                if(newIndexReader!=null){
                    //把旧的索引读对象关掉
                    indexReader.close();
                    indexReader = newIndexReader;
                }
            }
            return indexReader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取IndexSearcher对象
     * @return
     * @throws IOException
     */
    public static IndexSearcher getIndexSearcher(){
        if(indexSearcher==null){
            indexSearcher = new IndexSearcher(getIndexReader());
        }
        return indexSearcher;
    }

    /**
     * 获取分词器对象
     * @return
     */
    public static Analyzer getAnalyzer() {
        if(analyzer!=null){
            return analyzer;
        }
        return new IKAnalyzer();
    }

    /**
     * 创建QueryParser对象
     * @param field
     * @return
     */
    public static QueryParser createQueryParser(String field)
    {
        return new QueryParser(field,getAnalyzer());
    }

    /**
     * 创建Query对象
     * @param field
     * @param queryStr
     * @return
     */
    public static Query createQuery(String field[],String queryStr){
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        for (String f : field) {
            builder.add(new TermQuery(new Term(f,queryStr)), BooleanClause.Occur.SHOULD);
        }
        return builder.build();
    }

    /**
     * 分页查询索引
     * @param field
     * @param queryStr
     * @param pageNum
     * @param pageSize
     * @return
     * @throws IOException
     */
    public static List<Document> getHitDocuments(String[] field,String queryStr,int pageNum,int pageSize){

        List<Document> list = new ArrayList<>();

        try {
            IndexSearcher indexSearcher = getIndexSearcher();
            Query query = createQuery(field,queryStr);
            System.out.println(query);

            // 查询数据， 结束页面自前的数据都会查询到，但是只取本页的数据
            TopDocs topDocs = indexSearcher.search(query, pageNum * pageSize);
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            System.out.println(scoreDocs.length);

            //总条目数
            int totalHits = topDocs.totalHits;


            int start = (pageNum-1)*pageSize;
            int end = (pageNum*pageSize)>totalHits?totalHits:(pageNum*pageSize);
            for(int i=start;i<end;i++){
                ScoreDoc scoreDoc = scoreDocs[i];
                Document document = indexSearcher.doc(scoreDoc.doc);
                list.add(document);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 总共命中的条目数
     * @param field
     * @param queryStr
     * @return
     * @throws IOException
     */
    public static long totalHits(String[] field,String queryStr){
        try {
            IndexSearcher indexSearcher = getIndexSearcher();
            Query query = createQuery(field,queryStr);
            TopDocs topDocs = indexSearcher.search(query, 10);
            return topDocs.totalHits;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除索引
     * @param field
     * @param queryStr
     * @throws IOException
     */
    public static void deleteIndex(String[] field,String queryStr){
        try {
            Query query = createQuery(field,queryStr);
            getIndexWriter().deleteDocuments(query);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除所有索引
     * @throws IOException
     */
    public static void deleteAllIndex()throws IOException{
        getIndexWriter().deleteAll();
    }

    /**
     * 更新索引文档:有就更新，没有就插入
     * @param term
     * @param document
     */
    public static void updateIndex(Term term,Document document) {
        try {
            getIndexWriter().updateDocument(term, document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新索引文档:
     * @param field
     * @param value
     * @param document
     */
    public static void updateIndex(String field,String value,Document document) {
        updateIndex( new Term(field, value), document);
    }

    /**
     * 添加索引文档
     * @param document
     */
    public static void addIndex(Document document) {
        updateIndex(null, document);
    }


    /**
     * 关闭资源
     */
    public static void closeAll(){
        try {
            if (indexWriter!=null)
                indexWriter.close();
            if(indexReader!=null)
                indexReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
