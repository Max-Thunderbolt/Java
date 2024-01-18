class EstateAgent implements IEstateAgent{
    // Boolean validation
    public boolean validLocation(String location){
        if(location.equals("")){
            return false;
        }
        return true;
    }

    public boolean validAgentName(String agentName){
        if(agentName.equals("")){
            return false;
        }
        return true;
    }

    public boolean validPropertyPrice(double propertyPrice){
        try{
           
            if(propertyPrice <= 0){
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    public boolean validAgentCommission(double agentCommission){
        try{
            
            if(agentCommission <= 0){
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }

    // Interface methods
    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        double price = Double.parseDouble(propertyPrice);
        double commission = Double.parseDouble(agentCommission);
        return price * commission;
    }

    @Override
    public boolean ValidateData(Data data) {
        if (validLocation(data.getLocation()) && 
        validAgentName(data.getAgentName()) && 
        validPropertyPrice(data.getPropertyPrice()) && 
        validAgentCommission(data.getAgentCommission())){
            return true;
        } else {
            return false;
        }
    }
}
