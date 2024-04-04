import com.example.service.config.myCongiuration;
import com.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//测试类并没有被Spring管理，使用bean时所以会报错。
//所以这个注解就是告诉Spring来管理这个配置类！！
//配置文件用：location=    ;配置类用value=XXXX.class
@SpringJUnitConfig(value= myCongiuration.class)
public class aopTest {


    @Autowired public Calculator calculator;//有接口尽量用接口取，防止后期取不到代理对象。

    //TODO:@Test注解加在测试范围的类的方法里面就能运行方法
    @Test
   public void work(){
        System.out.println("result="+calculator.add(1,1));

   }
}
