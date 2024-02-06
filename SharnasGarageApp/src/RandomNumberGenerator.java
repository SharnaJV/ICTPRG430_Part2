import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomNumberGenerator {

    private static Set<String> hashmap = new HashSet<>();


    static int randNumGen(boolean hasGenuineParts)
    {
        String val = "";
        int returnValue = -1;
        if (hasGenuineParts)
        {
            Random myRandNumGen = new Random();
            int myCount = 0;
            int minNum = 10000;
            int maxNum = 100000;
            int myRand = myRandNumGen.nextInt((maxNum - minNum) + 1) + minNum;
            int result = 0;

            ArrayList<Integer> randArray = new ArrayList<Integer>();

            if (!randArray.contains(myRand)) {
                myCount++;
                randArray.add(myRand);
                result = (randArray.get(myCount - 1));
                returnValue = result;
                //System.out.println("Order Number: 1" + result);
                val = "1";
                val += result;
            }
        }
        else
        {
            Random myRandNumGen = new Random();
            int myCount = 0;
            int minNum = 10000;
            int maxNum = 100000;
            int myRand = myRandNumGen.nextInt((maxNum - minNum) + 1) + minNum;
            int result = 0;

            ArrayList<Integer> randArray = new ArrayList<Integer>();

            if (!randArray.contains(myRand)) {
                myCount++;
                randArray.add(myRand);
                result = (randArray.get(myCount - 1));
                returnValue = result;
                //System.out.println("Order Number: 2" + result);
                val = "2";
                val += result;
            }
        }
        return  Integer.parseInt(val);
    }

//    public static void main(String[] args) {
//        //for testing
//        System.out.println(" generateRandomNumber : " + generateRandomNumber());
//    }

//    public String generateRandomNumber() {
//
//        StringBuilder randomNumberString = new StringBuilder(); // Instance to append Number
//        Random random = new Random(); // instance to create Random Number
//
//        while (randomNumberString.length() < 6) { // running till the length becomes the 6
//            int digit = random.nextInt(10); // generate Random Number
//            randomNumberString.append(digit); // append into randomNumberString...
//        }
//
//        String generatedNumber = randomNumberString.toString();
//
//        while (hashmap.contains(generatedNumber)) { // Running until we gets the unique number
//            randomNumberString = new StringBuilder();
//            while (randomNumberString.length() < 6) {
//                int digit = random.nextInt(10);
//                randomNumberString.append(digit);
//            }
//            generatedNumber = randomNumberString.toString();
//        }
//
//        // Add the generated number to the set
//        // to avoid repetition in the same day
//        hashmap.add(generatedNumber);
//
//        return generatedNumber;
//    }



}
