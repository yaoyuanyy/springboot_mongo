package com.yy.service.impl;

import com.mongodb.BasicDBObject;
import com.yy.dao.ChannelDao;
import com.yy.model.Channel;
import com.yy.service.IChannelService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by skyler on 2017/4/6.
 */
@Service
public class ChannelServiceImpl implements IChannelService {

    @Resource
    ChannelDao channelDao;

    @Override
    public void save(Channel channel) throws Exception{

        channelDao.save(channel);
    }

    @Override
    public Channel getById(String id) throws Exception {
        return channelDao.getById(id);
    }

    @Override
    public List<Channel> list(String name) throws Exception {
        //第一种写法
        //Query query =  Query.query(Criteria.where("name").is(name)).with(new Sort(Sort.Direction.DESC,"ctime"));
        //return personDao.list(query);

        BasicDBObject dbobject = new BasicDBObject();
        //第二种写法
        //dbobject.put("name",name);
        //dbobject.put("age",10);
        //return personDao.list(dbobject);

        //第三种写法
        /* 这样写排序不起作用
        DBObject sortObject = new BasicDBObject();
        sortObject.put("ctime ", -1);*/
        dbobject.append("name",name).append("desc","desc22");
        //return channelDao.list(dbobject, new Sort(Sort.Direction.DESC,"ctime"));
        return channelDao.list(dbobject, null);
    }

    @Override
    public void update(Channel channel) throws Exception {
        Query query = Query.query(Criteria.where("id").is(channel.getId()));
        Update update = Update.update("desc",channel.getDesc());
        channelDao.update(query, update);
    }

    @Override
    public List<Channel> getByCompanyId(long companyId) {
        Query query = Query.query(Criteria.where("companyId").is(companyId));
        query.with(new Sort(Sort.Direction.DESC,"utime"));
        return channelDao.find(query);
    }
}
