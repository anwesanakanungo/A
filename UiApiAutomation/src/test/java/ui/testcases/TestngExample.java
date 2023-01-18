package ui.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ui.util.MyListener;
@Listeners(MyListener.class)
public class TestngExample {
    @Test
    public void test1(){
        System.out.println("testcase1");
    }
    @Test(groups= {"SmokeTest"})
    public void test2(){
        System.out.println("testcase2");
    }
    @Test(enabled = false)
    public void test3(){
        System.out.println("testcase3");
    }

    @Test(groups= {"SmokeTest"})
    public void test4(){
        System.out.println("testcase4");
    }

    @Test(groups= {"SmokeTest"})
    public void test5(){
        System.out.println("testcase5");
    }
}
