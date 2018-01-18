package cn.yearcon.sportwxservice.testWx;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author itguang
 * @create 2018-01-17 9:21
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMsg {
    @Autowired
    private WxMpService wxService;
    @Autowired
    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;
    @Test
    public void testSendTemplateMsg() throws WxErrorException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss.SSS");
        /*TestConfigStorage configStorage = (TestConfigStorage) this.wxService
                .getWxMpConfigStorage();*/
        String appid = "wxe781b118ac32a986";
        String appsecret = "943d048dbe3d6b765143b86522873409";
        wxMpInMemoryConfigStorage.setAppId(appid);
        wxMpInMemoryConfigStorage.setSecret(appsecret);
        wxService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o7PMW096FQsh_IjhPu1AtUv7IFpE")
                .templateId("a-MfSIu-nc5eNrrnyr8zND1dkbW7cfa7yTj0lvGPzOA").build();
        templateMessage.addWxMpTemplateData(
                new WxMpTemplateData("first", dateFormat.format(new Date()), "#FF00FF"));
        templateMessage.addWxMpTemplateData(
                new WxMpTemplateData("remark", RandomStringUtils.randomAlphanumeric(100), "#FF00FF"));
        templateMessage.setUrl(" ");
        String msgId = this.wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        Assert.assertNotNull(msgId);
        System.out.println(msgId);
    }
}
