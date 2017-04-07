package com.yy.service.impl;

import com.mongodb.BasicDBObject;
import com.yy.dao.PersonDao;
import com.yy.model.Person;
import com.yy.service.IPersonService;
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
public class PersonServiceImpl implements IPersonService {

    @Resource
    PersonDao personDao;

    @Override
    public void save(Person p) throws Exception{

        personDao.save(p);
    }

    @Override
    public Person getById(String id) throws Exception {
        return personDao.getById(id);
    }

    @Override
    public List<Person> list(String name) throws Exception {
        //Query query =  Query.query(Criteria.where("name").is(name)).with(new Sort(Sort.Direction.DESC,"ctime"));
        //return personDao.list(query);

        BasicDBObject dbobject = new BasicDBObject();

        //dbobject.put("name",name);
        //dbobject.append("name",name).append("age",10);
        //return personDao.list(dbobject);

        /* 这样写排序不起作用
        DBObject sortObject = new BasicDBObject();
        sortObject.put("ctime ", -1);*/
        dbobject.append("name",name).append("age",10);
        //return personDao.list(dbobject, new Sort(Sort.Direction.DESC,"ctime"));//加入排序
        return personDao.list(dbobject, null);//不加排序
    }

    @Override
    public void update(Person p) throws Exception {
        Query query = Query.query(Criteria.where("id").is(p.getId()));
        Update update = Update.update("age",p.getAge());
        personDao.update(query, update);
    }
}
