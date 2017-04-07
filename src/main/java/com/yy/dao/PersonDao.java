package com.yy.dao;

import com.mongodb.DBObject;
import com.yy.model.Person;
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
public class PersonDao {
    @Resource
    MongoTemplate mongoTemplate;

    public void save(Person p) throws Exception{

        mongoTemplate.save(p);
    }

    public Person getById(String id) throws Exception {
        return mongoTemplate.findById(id, Person.class);
    }

    public List<Person> list(DBObject dbObject) throws Exception {
       return list(dbObject, null);
    }

    public List<Person> list(DBObject dbObject, Sort sort) throws Exception {
        BasicQuery query = new BasicQuery(dbObject);
        if(!ObjectUtils.isEmpty(sort)) {
            query.with(sort);
        }

        List<Person> pss = mongoTemplate.find(query, Person.class);
        return pss;
    }

    public List<Person> list(Query query) throws Exception {
        return mongoTemplate.find(query, Person.class);
    }

    public void update(Query query, Update update) throws Exception{
        mongoTemplate.updateFirst(query, update, Person.class);
    }
}
