package com.yy.service;

import com.yy.model.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 方式二：特殊式
 * 优点：可以自动根据entity属性生成对应的方法，所以简便。但是没有针对某个属性的update相关方法，所以最好和一般式{@link com.yy.service.impl.ChannelServiceImpl}结合使用
 * 利用spring data mongodb提供的简便的方式：根据属性自动生成对应方法，只需要自定义一个继承了MongoRepository<Person, String>接口，如本接口
 * Created by skyler on 2017/4/6.
 */
public interface IChannelService2 extends MongoRepository<Channel, String> {

    List<Channel> findByCompanyId(long companyId);

    Channel findById(String id);

    @Override
    void delete(String s);
}
