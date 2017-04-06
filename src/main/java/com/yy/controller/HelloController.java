package com.yy.controller;

import com.yy.model.Person;
import com.yy.util.MongoUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * springboot get started
 * @author skler
 *
 */
@RestController
@RequestMapping("/hello")
//@EnableAutoConfiguration
public class HelloController {

    @Resource
    MongoTemplate mongoTemplate;


    @RequestMapping("/home")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() {
        Person person = new Person();
        String id = MongoUtil.getNewObjectId();
        //String id = "ssssssAsssAAsdfdsfds_wrf@gdg232D2";
        System.out.println("id:"+id);
        person.setId(id);
        person.setName("aa");
        person.setAge(10);
        person.setCtime(LocalDateTime.now());

        mongoTemplate.save(person);
        //mongoTemplate.insert(person);

        return "success";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getById(String id) {
        Person p = mongoTemplate.findById(id, Person.class);
        System.out.println(p.getCtime());
        return p.toString();
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> list(String name) {
        List<Person> ps = mongoTemplate.find(Query.query(Criteria.where("name").is(name)).with(new Sort(Sort.Direction.DESC,"ctime")),Person.class);
        ps.forEach(p -> System.out.println(p));
        return ps;
    }
}
