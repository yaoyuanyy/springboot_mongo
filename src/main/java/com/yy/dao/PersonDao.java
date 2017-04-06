package com.yy.dao;

import com.yy.model.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

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

    public List<Person> list(String name) throws Exception {
        return mongoTemplate.find(Query.query(Criteria.where("name").is(name)).with(new Sort(Sort.Direction.DESC,"ctime")),Person.class);
    }
}
