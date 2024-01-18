import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EstateAgentTest {

    @Test
    public void CalculateTotalSales_ReturnSalesTotal(){

        // Setting up the 2D arrays
        String[][] propertySales = {{"JAN", "FEB", "MAR"}, {"Joe Bloggs", "Jane Doe"}};
        double[][] sales = {{800000, 1500000, 2000000},{700000, 1200000, 1600000}};

        // Setting up the test data
        EstateAgent agents = new EstateAgent();
        double sales1 = agents.EstateAgentSales(sales[0]);
        double sales2 = agents.EstateAgentSales(sales[1]);

        // Expected amounts
        double expectedAgent1 = 4300000;
        double expectedAgent2 = 3500000;

        // Testing the method
        assertEquals(expectedAgent1, sales1, 0.01);
        assertEquals(expectedAgent2, sales2, 0.01);
    }

    @Test
    public void CalculateTotalCommission_ReturnsCommission(){
        // Setting up the 2D arrays
        String[][] propertySales = {{"JAN", "FEB", "MAR"}, {"Joe Bloggs", "Jane Doe"}};
        double[][] sales = {{800000, 1500000, 2000000},{700000, 1200000, 1600000}};

        // Setting up the test data
        EstateAgent agents = new EstateAgent();
        double commission1 = agents.EstateAgentCommission(sales[0]);
        double commission2 = agents.EstateAgentCommission(sales[1]);

        // Expected amounts
        double expectedAgent1 = 86000;
        double expectedAgent2 = 70000;

        // Testing the method
        assertEquals(expectedAgent1, commission1, 0.01);
        assertEquals(expectedAgent2, commission2, 0.01);
    }

    @Test
    public void TopAgent_ReturnsTopPosition(){
        // Setting up the 2D arrays
        String[][] propertySales = {{"JAN", "FEB", "MAR"}, {"Joe Bloggs", "Jane Doe"}};
        double[][] sales = {{800000, 1500000, 2000000},{700000, 1200000, 1600000}};

        // Setting up the test data
        EstateAgent agents = new EstateAgent();
        int topAgent = agents.TopEstateAgent(sales[0]);

        // Expected amount
        int expectedAgent = 0;

        // Testing the method
        assertEquals(expectedAgent, topAgent);
    }
}
    