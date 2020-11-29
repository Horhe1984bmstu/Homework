package cucumber;

import org.junit.After;

public class Hooks {

    @After
    public void after()
    {
        System.out.println("END TEST");
    }
}
