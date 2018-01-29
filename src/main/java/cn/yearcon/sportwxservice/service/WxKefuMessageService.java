package cn.yearcon.sportwxservice.service;

import cn.yearcon.sportwxservice.entity.KefuMsg;
import cn.yearcon.sportwxservice.entity.SportsUsers;
import cn.yearcon.sportwxservice.entity.SportsWx;
import cn.yearcon.sportwxservice.entity.TicketMsg;
import cn.yearcon.sportwxservice.json.JsonResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ayong
 * @create 2018-01-28 13:12
 **/
@Service
public class WxKefuMessageService {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WxMpService wxService;
    @Autowired
    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;

    @Autowired
    private SportsUserService sportsUserService;

    @Autowired
    private SportsWxService sportsWxService;

    public JsonResult sendKefuMessage(KefuMsg kefuMsg){
        if(kefuMsg==null){
            logger.info("kefuMsg==null");
        }
        Integer webid=kefuMsg.getWebid();
        if(webid==null){
            logger.info("机构id为空");
            return new JsonResult(0,"机构id为空");
        }
        SportsWx sportsWx=sportsWxService.findByWebid(webid);
        if(sportsWx==null){
            logger.info("公众号配置为为空");
            return new JsonResult(0,"没有配置该机构的公众号");
        }
        String appid =sportsWx.getAppid();
        String appsecret =sportsWx.getSecret();
        Integer vipid=kefuMsg.getVipid();
        if(vipid==null){
            logger.info("会员id为空");
            return new JsonResult(0,"会员id为空");

        }
        SportsUsers sportsUsersEntity=sportsUserService.findByVipid(vipid);
        if(sportsUsersEntity==null){
            logger.info("会员信息为空");
            return new JsonResult(0,"会员信息为空");
        }
        String openid=sportsUsersEntity.getOpenid();
        String content=kefuMsg.getContent();
        wxMpInMemoryConfigStorage.setAppId(appid);
        wxMpInMemoryConfigStorage.setSecret(appsecret);
        wxService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        WxMpKefuMessage message =WxMpKefuMessage.TEXT()
                .toUser(openid)
                .content(content)
                .build();
        try {
            wxService.getKefuService().sendKefuMessage(message);
            return new JsonResult(1,"发送成功");
        } catch (WxErrorException e) {
            e.printStackTrace();
            return new JsonResult(0,e.getMessage());
        }
    }
}
