public class EstateAgent implements IEstateAgent{

    @Override
    public double EstateAgentSales(double[] propertySales) {
        // This method sums all the values in the array and returns the total.
        double totalSales = 0;
        for(int i = 0; i < propertySales.length; i++){
            totalSales += propertySales[i];
        }
        return totalSales;
    }

    @Override
    public double EstateAgentCommission(double[] propertySales) {
        // This method sums all the values in the array and adds a 2% commission to each summed value.
        double totalCommission = 0;
        for(int i = 0; i < propertySales.length; i++){
            totalCommission += propertySales[i] * 0.02;
        }
        return totalCommission;
    }

    @Override
    public int TopEstateAgent(double[] propertySales) {
        // This method finds the highest totalSales in the array and returns the index of that value, indicating which agent holds the highest sales.
        double topSales = 0;
        int topEstateAgent = 0;
        for(int i = 0; i < 2 - 1; i++){
            if(propertySales[i] > topSales){
                topSales = propertySales[i];
                topEstateAgent = i;
            }
        }
        return topEstateAgent;
    }
}
