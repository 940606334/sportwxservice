package cn.yearcon.sportwxservice.service;


import cn.yearcon.sportwxservice.dao.SportsUsersRepository;

import cn.yearcon.sportwxservice.entity.SportsUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * 会员认证业务层
 *
 * @author itguang
 * @create 2017-12-08 13:38
 **/
@Service
public class SportsUserService {

    @Autowired
    private SportsUsersRepository sportsUsersRepository;



    /**根据vipid查询会员信息*/
    public SportsUsers findByVipid(Integer vipid){
        return sportsUsersRepository.findOne(vipid);
    }

    /**根据openid查询会员信息*/
    public SportsUsers findByOpenid(String openid){
        return sportsUsersRepository.findByOpenid(openid);
    }

    public void deleteById(Integer vipid){
        sportsUsersRepository.delete(vipid);
    }
}
