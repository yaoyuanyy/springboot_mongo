package com.yy.util;

import org.bson.types.ObjectId;

/**
 * Created by skyler on 2017/4/5.
 */
public class MongoUtil {

    public static String getNewObjectId() {
        return new ObjectId().toString();
    }
}
