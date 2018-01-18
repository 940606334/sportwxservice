package cn.yearcon.sportwxservice.service;

import cn.yearcon.sportwxservice.dao.SportsWxRepository;
import cn.yearcon.sportwxservice.entity.SportsWx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author itguang
 * @create 2018-01-18 9:59
 **/
@Service
public class SportsWxService {
    @Autowired
    private SportsWxRepository sportsWxRepository;

    public SportsWx findByWebid(Integer webid){
        return sportsWxRepository.findByWebid(webid);
    }
}
