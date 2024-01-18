class Data{
    // Data class to create data objects.
    private String location, agentName;
    private double propertyPrice, agentCommission;

    public Data(){
        location = "";
        agentName = "";
        propertyPrice = 0;
        agentCommission = 0;
    }

    public Data(String location, String agentName, double propertyPrice, double agentCommission){
        this.location = location;
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
        this.agentCommission = agentCommission;
    }

    public String getLocation(){
        return location;
    }

    public String getAgentName(){
        return agentName;
    }

    public double getPropertyPrice(){
        return propertyPrice;
    }

    public double getAgentCommission(){
        return agentCommission;
    }
}

public interface IEstateAgent {
    double CalculateCommission(String propertyPrice, String agentCommission);
    boolean ValidateData(Data data);
}
