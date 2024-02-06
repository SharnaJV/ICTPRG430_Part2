import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws FileNotFoundException {

//In this method I have created an arraylist for the purpose of indicating the products that are available,
//the cost of each product and whether the product is genuine or not.
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        ArrayList<Parts> listOfParts = new ArrayList<>();
        listOfParts = readPartsFromFile(); // reading the parts from the file...
        Scanner scanner = new Scanner(System.in);

//Create customer, order list, and initialize selected items list
        Customer customer = new Customer();
        OrderList orderList = new OrderList();
        Parts selectedItem = null;
        ArrayList<Parts> selectedItemsList = new ArrayList<>();

//Get customer details
        customer.CustInput();

//This while loop allows customer to select items
        while (true) {
            try {
                displayPartsList(listOfParts);

                System.out.println("Welcome " + customer.getCustFirstName() + ", please select from the following menu items by typing in the index number and pressing enter, '0' to finish:");
                System.out.println("-----------------------------------------");
                int itemSelect = scanner.nextInt();

                if (itemSelect == 0) {
//This will generate the order number and print it in the terminal
                    int orderNumber = randomNumberGenerator.randNumGen(true);
                    System.out.println("-----------------------------------------");
                    System.out.println(" Your order Number is :  " + orderNumber);
                    System.out.println("-----------------------------------------");

//This is going to calculate the prices of all the ordered items and print total in the terminal
                    int total = 0;
                    for (int i = 0; i < selectedItemsList.size(); i++) {
                        Parts p = (Parts) selectedItemsList.get(i);
                        total += p.getItemPrice();
                    }
                    System.out.println(" Total : $" + total);
                    System.out.println("-----------------------------------------");

                    break;
//This will inform the user that they have entered invalid input during the order process
                } else if (itemSelect < 0 || itemSelect > 10) {
                    System.out.println("-----------------------------------------");
                    System.out.println("Invalid selection, please try again");
                    System.out.println("-----------------------------------------");
                } else {

                    selectedItem = checkSelectedItem(itemSelect, listOfParts);
                    System.out.println("-----------------------------------------");
                    System.out.println("selected: " + selectedItem.getItemName() + " valued at $" + selectedItem.getItemPrice());

                    try {
                        FileWriter custWriter = new FileWriter("Customer Data.txt", true);
                        BufferedWriter myWriter = new BufferedWriter(custWriter);
                        int rand = randomNumberGenerator.randNumGen(true);
                        myWriter.write(selectedItem.getItemName() + ", " + selectedItem.getItemPrice() + ", " + rand + "\n");
                        myWriter.close();
                        System.out.println("Successfully added to the order.");

//This will write the order to the Customer data file
                        orderList.addOrder(new Order(customer.getCustFirstName(), customer.getCustLastName(),
                                customer.getCustEmail(), customer.getCustPhone(), "" + rand, selectedItem));

                        String d = "" + rand;
                        boolean val = (d.charAt(0) == '1') ? true : false;
                        selectedItem.setGenuine(val);
                        System.out.println("-----------------------------------------");
                        selectedItemsList.add(selectedItem);

//This code determines if a part is genuine or not
                        boolean isGenuine = false;
                        for (Parts part : selectedItemsList) {
                            if (part.isGenuine()) {
                                isGenuine = true;
                            } else {
                                isGenuine = false;
                            }
                        }
                        if (isGenuine) {
                            System.out.println(" There are 1 or more items in your order that are genuine");
                        } else {
                            System.out.println("the Item(s) you have ordered are third-party");
                        }


                    } catch (IOException e) {
                        System.out.println("An error occurred.");
                        System.out.println("-----------------------------------------");
                        e.printStackTrace();
                    }

                    //genuine part code
                }

            }catch (Exception e)
            {
                System.out.println(" Please enter valid input ! ");
            }
        }
// System.out.println("Thankyou " + customer.getCustFirstName() + " please wait while we generate your Service I.D. number and remember it for when it is called out");
//        boolean hasGenuineParts = false;
//        Order.randNumGen(hasGenuineParts);
//        hasGenuineParts = false;
//        for (Parts part : selectedItemsList) {
//            if (part.getIsGenuine()) {
//                hasGenuineParts = true;
//                System.out.println(" There are 1 or more items in your order that are genuine");
//        } else {
//                System.out.println("the Item(s) you have ordered are third-party");
//            }
//        }
//        if (hasGenuineParts) {
//            System.out.println(" There are 1 or more items in your order that are genuine");
//        } else {
//            System.out.println("the Item(s) you have ordered are third-party");
//        }
    }

    /**
     *Validate and retrieve a selected item from the PartsList.txt
     * @param itemSelect
     * @param listOfParts
     * @return
     */
    private static Parts checkSelectedItem(int itemSelect, ArrayList<Parts> listOfParts) {
        Parts parts = null;

        for (int i = 0; i < listOfParts.size(); i++) {
            if(listOfParts.get(i).getId().equalsIgnoreCase(String.valueOf(itemSelect)))
            {
                parts = listOfParts.get(i);
                return parts;
            }
            else continue;
        }

        return parts;
    }

    /**
     * This method displays the parts list in a menu
     * @param listOfParts
     */
    public static void displayPartsList(ArrayList<Parts> listOfParts) {
        for (Parts Parts : listOfParts) {
            System.out.println(Parts.getId() + ": " + Parts.getItemName() + " ----- $" + Parts.getItemPrice());
            System.out.println("____________________________________");
        }
    }

    /**
     * method to read data from files...
     * @return
     * @throws FileNotFoundException
     */
    public static ArrayList<Parts> readPartsFromFile() throws FileNotFoundException {
        ArrayList<Parts> list  = new ArrayList<>();
        File file = new File("PartsList.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine())
        {
            String[] data = scanner.nextLine().split(",");
            String price  = data[2].replace("$","");
            Parts parts = new Parts(data[0],data[1],Double.parseDouble(price));
            list.add(parts);
        }

       // System.out.println("size:"+list.size());

        return list;
    }
}
