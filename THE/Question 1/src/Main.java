public class Main extends EstateAgent{
    final static String[][] propertySales = {{"JAN", "FEB", "MAR"}, {"Joe Bloggs", "Jane Doe"}}; // Stays final as we will not be changing any value at any point.
    final static double sales[][] = {{800000, 1500000, 2000000},{700000, 1200000, 1600000}}; // Additional 2D array to store the different sales values for the 2 estate agents.

    public static void displayArray(){
        /*
         * This a simple method used to display all the elements in both arrays in a table format.
         * The method is static as it is not being called from another class.
         * The method is void as it does not return any value.
         */

        System.out.print("\t\t\t\t" + propertySales[0][0] + "\t\t\t\t");
        System.out.print(propertySales[0][1]+ "\t\t\t\t");
        System.out.print(propertySales[0][2]+ "\n");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.print(propertySales[1][0] + "\t\t\t");
        System.out.print("R" + sales[0][0] + "\t\t\t");
        System.out.print("R" + sales[0][1] +  "\t\t\t");
        System.out.println("R" + sales[0][2]);
        System.out.print(propertySales[1][1] + "\t\t\t");
        System.out.print("R" + sales[1][0] + "\t\t\t");
        System.out.print("R" + sales[1][1] + "\t\t\t");
        System.out.print("R" + sales[1][2]);
        System.out.println("\n");
    }

    /*
     * This method just adds commas between tens, hundreds, thousands, etc.
     */
    public static String displayWithCommas(int num){
        int length = String.valueOf(num).length();
        String returnNum = Integer.toString(num);

        // Work from right -> left
        // Add "," after every 3rd digit
        for(int i = length - 3; i > 0; i -= 3){
            returnNum = returnNum.substring(0, i) + "," + returnNum.substring(i);
        }
        return returnNum;
    }

    public static void main(String[] args) {
        EstateAgent agents = new EstateAgent(); // Create an instance of the EstateAgent class.

        System.out.println("ESTATE SALES REPORT \n");

        displayArray();

        // Sales
        System.out.println("Total sales for " + propertySales[1][0] + " = R " + displayWithCommas((int)agents.EstateAgentSales(sales[0])));
        System.out.println("Total sales for " + propertySales[1][1] + " = R " + displayWithCommas((int)agents.EstateAgentSales(sales[1])));

        // Commissions
        System.out.println("\nSales commission for " + propertySales[1][0] + " = R " + displayWithCommas((int)agents.EstateAgentCommission(sales[0])));
        System.out.println("Sales commission for " + propertySales[1][1] + " = R " + displayWithCommas((int)agents.EstateAgentCommission(sales[1])));

        // Top Estate Agent
        System.out.println("\nTop performing estate agent: " + propertySales[1][agents.TopEstateAgent(sales[0])]);
    }
}