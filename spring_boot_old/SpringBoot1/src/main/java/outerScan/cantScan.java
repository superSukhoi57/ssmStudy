package outerScan;

import org.springframework.stereotype.Component;

@Component
public class cantScan {
    private String str;
    public String canScan(){
        System.out.println("it can be scan by componentScan!");
        return "Can be scaned!";
    }
}
