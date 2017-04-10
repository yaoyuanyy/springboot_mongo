package com.yy.controller;

import com.yy.model.Person;
import com.yy.service.IPersonService;
import com.yy.service.PersonRepository;
import com.yy.util.MongoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Resource
    IPersonService personService;

    @Resource
    PersonRepository personRepository;


    @RequestMapping("/home")
    public String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() throws Exception {
        Person person = new Person();
        String id = MongoUtil.getNewObjectId();
        person.setId(id);
        person.setName("aa");
        person.setAge(10);
        person.setCtime(LocalDateTime.now());
        log.info("-----------"+person.toString());
        personService.save(person);

        return "success";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(String id) throws Exception {
        Person person = new Person();
        person.setId(id);
        person.setAge(11);
        person.setCtime(LocalDateTime.now());

        personService.update(person);

        return "update success";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getById(String id) throws Exception {
        Person p = personService.getById(id);
        System.out.println(p.getCtime());
        return p.toString();
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Person> list(String name) throws Exception {
        List<Person> ps = personRepository.findByNameIs(name);

        //List<Person> ps = personService.list(name);
        ps.forEach(p -> System.out.println(p));
        return ps;
    }
}
