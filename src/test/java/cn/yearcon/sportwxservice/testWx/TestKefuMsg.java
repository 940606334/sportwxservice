package cn.yearcon.sportwxservice.testWx;

import cn.yearcon.sportwxservice.service.WxKefuMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ayong
 * @create 2018-01-28 13:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestKefuMsg {
    @Autowired
    private WxKefuMessageService wxKefuMessageService;
    @Test
    public void test(){
        wxKefuMessageService.sendKefuMessage("1","1");
    }
}
