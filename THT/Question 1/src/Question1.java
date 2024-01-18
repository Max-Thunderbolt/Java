public class Question1 {

    public static void main(String[] args) {

        // Double array to store the price of each camera brand and type
        double[][] cameraBrand_Price = new double[3][2];
        cameraBrand_Price[0][0] = 10500;
        cameraBrand_Price[0][1] = 8500;
        cameraBrand_Price[1][0] = 9500;
        cameraBrand_Price[1][1] = 7200;
        cameraBrand_Price[2][0] = 12000;
        cameraBrand_Price[2][1] = 8000;

        // String array to store the camera brand
        String[] cameraBrand = new String[3];
        cameraBrand[0] = "Canon";
        cameraBrand[1] = "Sony";
        cameraBrand[2] = "Nikon";

        // String array to store the camera type
        String[] cameraType = new String[2];
        cameraType[0] = "Mirrorless";
        cameraType[1] = "DSLR";

        // Variables to keep track of the price difference between each camera brand and type
        double priceDifference, priceDifference_prev = 0;
        double mostExpensiveCamera = 0;
        int mostExpensiveCameraIndex = 0;

        // Display the camera technology report
        System.out.println("----------------------------------------------\nCAMERA TECHNOLOGY REPORT\n----------------------------------------------");
        System.out.println("\t\t" + cameraType[0] + "\t\t" + cameraType[1]);
        for(int i = 0; i < 3; i++){
            System.out.println(cameraBrand[i] + "\tR " + cameraBrand_Price[i][0] + "\t\tR " + cameraBrand_Price[i][1]);
        }

        // Display the camera technology results
        System.out.println("----------------------------------------------\nCAMERA TECHNOLOGY RESULTS\n----------------------------------------------");
        try {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    priceDifference = cameraBrand_Price[i][0] - cameraBrand_Price[i][1];
                    if (priceDifference != priceDifference_prev){
                        if (priceDifference >= 2500)
                            System.out.println(cameraBrand[i] + "\tR" + priceDifference + " ***");
                        else
                            System.out.println(cameraBrand[i] + "\tR" + priceDifference);
                    }
                    priceDifference_prev = priceDifference;
                    if (priceDifference > mostExpensiveCamera){ // -> ensure we get the most expensive camera
                        mostExpensiveCamera = priceDifference;
                        mostExpensiveCameraIndex = i;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bounds");
        }

        // Display the camera with the most cost difference
        System.out.println("CAMERA WITH THE MOST COST DIFFERENCE: " + cameraBrand[mostExpensiveCameraIndex]);
        System.out.println("----------------------------------------------");
    }
}