import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\java\\features\\scenario.feature", // путь до пакета с feature файлами
        glue = "src\\main\\java\\cucumber", // путь до пакета с шагами
        tags = "@1" // теги по которым будут запущены сценарии

)
public class Runner {

   @Test
    public static void run (String []args)
    {

    }


}
