package cn.newtouch.mohaijiang.test;

import cn.newtouch.mohaijiang.example.DemoApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MainTest {

    @Test
    public void test(){
        Assert.assertEquals("abcd","abcd");
    }

    @Test
    public void testLength(){

        Assert.assertEquals("224765a6bdbecd6e91195a8a00180e263b397e74902c0b5a0420a9b1cb6529df".length(),64);
    }

}
