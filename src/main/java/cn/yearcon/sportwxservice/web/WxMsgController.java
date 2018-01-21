package cn.yearcon.sportwxservice.web;


import cn.yearcon.sportwxservice.entity.TicketMsg;
import cn.yearcon.sportwxservice.json.JsonResult;
import cn.yearcon.sportwxservice.service.WxMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信消息模板
 *
 * @author itguang
 * @create 2018-01-17 11:02
 **/
@Controller
@RequestMapping(value = "wxmsg")
public class WxMsgController {

    @Autowired
    private WxMsgService wxMsgService;

    @RequestMapping(value = "sendTicketMsg")
    @ResponseBody
    public String getTicketMsg(TicketMsg ticketMsg, HttpServletRequest request){
        return wxMsgService.sendTicketMsg(ticketMsg,request);
    }
}
