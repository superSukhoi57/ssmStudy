package myTest;

import com.example.config.configuration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.example.Service.*;
@SpringJUnitConfig(configuration.class)
public class Txtest {

    @Autowired
    private service myService;
    @Test
    public void test(){
        myService.updatePrice();
    }
}
