package cn.yearcon.sportwxservice.service;


import cn.yearcon.sportwxservice.entity.SportsMsgtemplate;
import cn.yearcon.sportwxservice.entity.SportsUsers;
import cn.yearcon.sportwxservice.entity.SportsWx;
import cn.yearcon.sportwxservice.entity.TicketMsg;
import cn.yearcon.sportwxservice.json.JsonResult;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信消息模板
 *
 * @author itguang
 * @create 2018-01-17 11:08
 **/
@Service
public class WxMsgService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private WxMpService wxService;
    @Autowired
    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;

    @Autowired
    private SportsUserService sportsUserService;
    @Autowired
    private SportsMsgtemplateService sportsMsgtemplateService;

    @Autowired
    private SportsWxService sportsWxService;
    /**
     * 发送店址电子小票
     * @param ticketMsg
     * @param request
     * @return
     */
    public JsonResult sendTicketMsg(TicketMsg ticketMsg, HttpServletRequest request){
        if(ticketMsg==null){
            logger.info("电子小票信息为空");
            return new JsonResult(0,"电子小票信息为空");
        }
        Integer webid=ticketMsg.getWebid();
        if(webid==null){
            logger.info("机构id为空");
            return new JsonResult(0,"机构id为空");
        }
        SportsWx sportsWx=sportsWxService.findByWebid(webid);
        if(sportsWx==null){
            logger.info("机构id为空");
            return new JsonResult(0,"没有配置该机构的公众号");
        }
        String appid = sportsWx.getAppid();
        String appsecret = sportsWx.getSecret();
        Integer vipid=ticketMsg.getVipid();
        if(vipid==null){
            logger.info("机构id为空");
            return new JsonResult(0,"会员id为空");
        }
        SportsUsers sportsUsersEntity=sportsUserService.findByVipid(vipid);
        if(sportsUsersEntity==null){
            logger.info("机构id为空");
            return new JsonResult(0,"会员信息为空");
        }
        String openid=sportsUsersEntity.getOpenid();
        SportsMsgtemplate sportsMsgtemplate=sportsMsgtemplateService.getByWebid(webid);
        if(sportsMsgtemplate==null){
            logger.info("机构id为空");
            return new JsonResult(0,"请配置电子小票模板");
        }
        wxMpInMemoryConfigStorage.setAppId(appid);
        wxMpInMemoryConfigStorage.setSecret(appsecret);
        wxService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser(openid)
                .templateId(sportsMsgtemplate.getTemplateid()).build();
        templateMessage.addWxMpTemplateData(
                new WxMpTemplateData("first", sportsMsgtemplate.getFirst(), "#343434"));
        templateMessage.addWxMpTemplateData(
                new WxMpTemplateData("remark", ticketMsg.toString()+sportsMsgtemplate.getRemark(), "#343434"));
        templateMessage.getData().add(new WxMpTemplateData("keyword1", ticketMsg.getKeyword1(), "#343434"));//交易单号
        templateMessage.getData().add(new WxMpTemplateData("keyword2", ticketMsg.getKeyword2(), "#343434"));//交易时间
        templateMessage.getData().add(new WxMpTemplateData("keyword3", ticketMsg.getKeyword3(), "#343434"));//交易金额
        templateMessage.setUrl(sportsMsgtemplate.getRedirecturl());
        JsonResult jsonResult=null;
        try {
            String msgId = this.wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            logger.info("发送成功:msgid="+msgId);
            jsonResult=new JsonResult(1,msgId);
        }catch (WxErrorException e){
            logger.debug(e.getMessage());
            jsonResult=new JsonResult(0,e.getMessage());
        }
        return jsonResult;
    }
}
