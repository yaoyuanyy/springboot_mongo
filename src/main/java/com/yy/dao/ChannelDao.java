package com.yy.dao;

import com.mongodb.DBObject;
import com.yy.model.Channel;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by skyler on 2017/4/6.
 */

@Repository
public class ChannelDao {
    @Resource
    MongoTemplate mongoTemplate;

    public void save(Channel channel) throws Exception{

        mongoTemplate.save(channel);
    }

    public Channel getById(String id) throws Exception {
        return mongoTemplate.findById(id, Channel.class);
    }

    public List<Channel> list(DBObject dbObject) throws Exception {
       return list(dbObject, null);
    }

    public List<Channel> list(DBObject dbObject, Sort sort) throws Exception {
        BasicQuery query = new BasicQuery(dbObject);
        if(!ObjectUtils.isEmpty(sort)) {
            query.with(sort);
        }

        List<Channel> pss = mongoTemplate.find(query, Channel.class);
        return pss;
    }

    public List<Channel> list(Query query) throws Exception {
        return mongoTemplate.find(query, Channel.class);
    }

    public void update(Query query, Update update) throws Exception{
        mongoTemplate.updateFirst(query, update, Channel.class);
    }

    public List<Channel> find(Query query) {
        return mongoTemplate.find(query, Channel.class);
    }
}
