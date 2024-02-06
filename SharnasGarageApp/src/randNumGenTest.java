//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

class randNumGenTest
{

    /**
     * This class has two test cases...
     */

    @Test
    void thisWillGenerateANonRecurringRandomNumber()
    {
        RandomNumberGenerator rng1 = new RandomNumberGenerator();
        RandomNumberGenerator rng2 = new RandomNumberGenerator();
        int a = rng1.randNumGen(true);
        int b = rng1.randNumGen(true);
        Assert.assertEquals(false,rng2.randNumGen(true) == (rng1.randNumGen(true)));
    }

    @Test
    void readPartsFromFile() throws FileNotFoundException {
        Main main = new Main();
        ArrayList<Parts> listOfParts = main.readPartsFromFile(); // reading the parts from the file...

        Assert.assertEquals(true,listOfParts.size() > 0);
    }

}