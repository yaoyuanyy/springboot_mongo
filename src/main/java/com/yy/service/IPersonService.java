package com.yy.service;

import com.yy.model.Person;

import java.util.List;

/**
 * Created by skyler on 2017/4/6.
 */
public interface IPersonService {
    void save(Person p) throws Exception;

    Person getById(String id) throws Exception;

    List<Person> list(String name) throws Exception;
}
