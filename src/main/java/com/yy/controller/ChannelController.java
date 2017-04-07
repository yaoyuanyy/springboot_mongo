package com.yy.controller;

import com.yy.model.Channel;
import com.yy.model.MsgConf;
import com.yy.service.IChannelService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by skyler on 2017/4/7.
 */
@RestController
@RequestMapping("/channel")
public class ChannelController {

    @Resource
    private IChannelService channelService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Channel channel) throws Exception {
        long time = new Date().getTime();
        channel.setCtime(time);
        channel.setUtime(time);
        MsgConf msgConf = new MsgConf();
        channel.setMsgConf(msgConf);
        channelService.save(channel);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Channel get(String id) throws Exception {
        return channelService.getById(id);
    }

    @RequestMapping(value = "/getByCompanyId", method = RequestMethod.GET)
    public List<Channel> getByCompanyId(long companyId) throws Exception {
        return channelService.getByCompanyId(companyId);
    }
}
