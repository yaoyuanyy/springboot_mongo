package com.yy.service.iml;

import com.yy.dao.PersonDao;
import com.yy.model.Person;
import com.yy.service.IPersonService;
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
        return personDao.list(name);
    }
}
