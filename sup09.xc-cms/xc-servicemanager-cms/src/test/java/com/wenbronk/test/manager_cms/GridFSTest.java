package com.wenbronk.test.manager_cms;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.wenbronk.manager_cms.ManagerCmsApplication;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author wenbronk <meng.wen@kangtaitong.cn>
 * @Date 2019-09-09 14:14
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagerCmsApplication.class)
@EnableConfigurationProperties(MongoProperties.class)
public class GridFSTest {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    /**
     * 存储
     * @throws FileNotFoundException
     */
    @Test
    public void testSaveFile() throws FileNotFoundException {
        String filePath = "/Users/wenbronk/code/IdeaProjects/itcast57/sup09.xc-cms/xc-learn/src/main/resources/templates/index_banner.ftl";

        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        ObjectId id = gridFsTemplate.store(fileInputStream, "轮播图测试", "");
        // 5d75f53716ee1407ba33e56e
        System.out.println(id.toString());
    }

    @Autowired
    private MongoProperties mongoProperties;
    @Autowired
    private MongoClient mongoClient;

    @Test
    public void testRead() throws IOException {
        MongoDatabase mongoDatabase = mongoClient.getDatabase(mongoProperties.getDatabase());
        GridFSBucket gridFSBucket = GridFSBuckets.create(mongoDatabase);

        String id = "5d75f53716ee1407ba33e56e";
        GridFSFile gridFSFile = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(id)));

        // 打开下载流
        GridFSDownloadStream gridFSDownloadStream = gridFSBucket.openDownloadStream(gridFSFile.getObjectId());

        // 创建gridResource获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);

        String str = IOUtils.toString(gridFsResource.getInputStream(), "utf-8");
        System.out.println(str);
    }

    @Test
    public void testDelete() {
        String id = "5d75f53716ee1407ba33e56e";
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is(id)));
    }
}
