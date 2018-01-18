package cn.yearcon.sportwxservice.service;


import cn.yearcon.sportwxservice.dao.SportsMsgtemplateDao;
import cn.yearcon.sportwxservice.entity.SportsMsgtemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author itguang
 * @create 2018-01-17 14:27
 **/
@Service
public class SportsMsgtemplateService {
    @Autowired
    private SportsMsgtemplateDao sportsMsgtemplateDao;

    public SportsMsgtemplate getByWebid(Integer webid){
        return sportsMsgtemplateDao.findOne(webid);
    }
}
