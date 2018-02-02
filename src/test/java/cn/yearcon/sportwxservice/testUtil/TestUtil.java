package cn.yearcon.sportwxservice.testUtil;

import org.junit.Test;

/**
 * @author ayong
 * @create 2018-02-02 11:09
 **/
public class TestUtil {
    @Test
    public void test1(){
        String str="2018-01-2711:22";
        System.out.println(str);
        String sub=str.substring(0,10);
        System.out.println(sub);
        str=sub+" "+str.substring(10);
        System.out.println(str);
    }
}
