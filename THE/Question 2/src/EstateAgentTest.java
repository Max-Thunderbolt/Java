import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals; 
    
public class EstateAgentTest extends EstateAgent {

    @Test 
    public void CalculateCommission_CalculatedSuccesfully(){
        double expected = 1;
        double actual = CalculateCommission("10", "0.1");
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void CalculateCommission_CalculatedUnSuccessfully(){
        double expected = 0;
        double actual = CalculateCommission("10", "0.1");
        assertNotEquals(expected, actual, 0.01);
    }

    @Test
    public void ValidationTest(){
        Data data = new Data("Cape Town", "John", 100, 0.1);
        boolean expected = true;
        boolean actual = ValidateData(data);
        assertEquals(expected, actual);
    }
}
    