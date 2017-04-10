package com.yy.service;

import com.yy.model.Channel;

import java.util.List;

/**
 * Created by skyler on 2017/4/7.
 */
public interface IChannelService {

    void save(Channel channel) throws Exception;

    Channel getById(String id) throws Exception;

    List<Channel> list(String name) throws Exception;

    void update(Channel channel) throws Exception;

    List<Channel> getByCompanyId(long companyId);
}
