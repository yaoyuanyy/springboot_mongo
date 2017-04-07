package com.yy.service.impl;

import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by skyler on 2017/4/7.
 */
@Repository
public class BaseServiceImpl {

    @Resource
    protected MongoTemplate mongoTemplate;

    public List<? extends Object> list(DBObject dbObject, DBObject fieldsObject, Class clazz) throws Exception {
        BasicQuery query = new BasicQuery(dbObject, fieldsObject);
        return mongoTemplate.find(query, clazz);
    }
}
