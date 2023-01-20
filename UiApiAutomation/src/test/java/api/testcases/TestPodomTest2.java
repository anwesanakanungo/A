package api.testcases;

import api.pojo.User;
import org.testng.annotations.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class TestPodomTest2 {
    @Test
    public void test11(){
        PodamFactory factory = new PodamFactoryImpl();
        User user1= factory.manufacturePojo(User.class);
        System.out.println(user1.toString());
        System.out.println(user1);

    }
}
