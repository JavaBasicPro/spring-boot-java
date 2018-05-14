package com.java.springbootjava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Created by jinpanpan on 2018/4/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitModelTest {

    @Test
    public void test(){

        System.out.println("开始");

        Assert.assertNotNull("");

        int a=1;

        assertTrue(a==1);

        System.out.println("结果");
    }

}
