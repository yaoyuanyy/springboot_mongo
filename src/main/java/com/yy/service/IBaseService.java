package com.yy.service;

import com.mongodb.DBObject;

import java.util.List;

/**
 * Created by skyler on 2017/4/7.
 */
public interface IBaseService {

    public List<? extends Object> list(DBObject dbObject, DBObject fieldsObject, Class clazz);
}
