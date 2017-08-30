package cn.newtouch.mohaijiang.test;

import cn.newtouch.mohaijiang.example.SampleController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleController.class)
public class MainTest {

    @Test
    public void test(){
        Assert.assertEquals("abcd","abcd");
    }

}
