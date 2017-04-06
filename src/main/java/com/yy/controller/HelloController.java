package com.yy.controller;

import com.yy.model.Person;
import com.yy.service.IPersonService;
import com.yy.util.MongoUtil;
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
    IPersonService personService;


    @RequestMapping("/home")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() throws Exception {
        Person person = new Person();
        String id = MongoUtil.getNewObjectId();
        //String id = "ssssssAsssAAsdfdsfds_wrf@gdg232D2";
        System.out.println("id:"+id);
        person.setId(id);
        person.setName("aa");
        person.setAge(10);
        person.setCtime(LocalDateTime.now());

        personService.save(person);

        return "success";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getById(String id) throws Exception {
        Person p = personService.getById(id);
        System.out.println(p.getCtime());
        return p.toString();
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> list(String name) throws Exception {
        List<Person> ps = personService.list(name);
        ps.forEach(p -> System.out.println(p));
        return ps;
    }
}
