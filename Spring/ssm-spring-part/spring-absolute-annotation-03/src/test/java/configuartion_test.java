import com.example.Student.StudentController;
import com.example.config.configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//在测试类写Test注解就能运行函数！！！！
public class configuartion_test {
    @Test
    public void run(){
        //1、AnnotationConfigApplicationContext 根据配置类创建 I0C 容器对象
        ApplicationContext iocContainerAnnotation= new AnnotationConfigApplicationContext(configuration.class);

        StudentController service=iocContainerAnnotation.getBean(StudentController.class);
        System.out.println("service is"+service);
        //2、方式2：
        /*//AnnotationConfigApplicationContext-I0C容器对象
        ApplicationContext iocContainerAnnotation=new AnnotationconfigApplicationcontext();
        //外部设置配置类
        iocContainerAnnotation.register(MyConfiguration.class)
         //刷新后方可生效!!
        iocContainerAnnotation.refresh();*/

    }
}
