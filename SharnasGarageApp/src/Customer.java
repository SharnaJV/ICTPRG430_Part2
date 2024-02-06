import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customer {

//assigned variables for cust. details to be input
    private String CustFirstName;
    private String CustLastName;
    private String CustEmail;
    private String CustPhone;

    public Customer(){}
    public Customer(String custFirstName, String custLastName, String custEmail, String custPhone) {
        CustFirstName = custFirstName;
        CustLastName = custLastName;
        CustEmail = custEmail;
        CustPhone = custPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustFirstName='" + CustFirstName + '\'' +
                ", CustLastName='" + CustLastName + '\'' +
                ", CustEmail='" + CustEmail + '\'' +
                ", CustPhone='" + CustPhone + '\'' +
                '}';
    }


    // Customer inputs their data
    public void CustInput()
    {
        Scanner scanner = new Scanner(System.in);

        Customer newCust  = null;

        System.out.println("Please Enter your details.");
        System.out.println("First Name: ");
        this.CustFirstName = scanner.next();
        System.out.println("Last Name: ");
        this.CustLastName = scanner.next();
        System.out.println("Email: ");
        this.CustEmail = scanner.next();
        System.out.println("Phone Number: ");
        this.CustPhone = scanner.next();

        newCust = this;
        newCust = new Customer(getCustFirstName(),getCustLastName(),getCustEmail(),getCustPhone());

        // Data is recorded to text file
        try
        {
            FileWriter custWriter = new FileWriter("Customer Data.txt", true);
            BufferedWriter myWriter = new BufferedWriter(custWriter);
            myWriter.write(newCust.CustFirstName + ", " + newCust.CustLastName + ", " +  newCust.CustEmail + ", " + newCust.CustPhone + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
            catch (IOException e)
        {
            System.out.println("An error occurred.");
           // e.printStackTrace();
        }
    }


    /**
     * getter and setters
     * @return
     */
    public String getCustFirstName() {
        return CustFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        CustFirstName = custFirstName;
    }

    public String getCustLastName() {
        return CustLastName;
    }

    public void setCustLastName(String custLastName) {
        CustLastName = custLastName;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String custEmail) {
        CustEmail = custEmail;
    }

    public String getCustPhone() {
        return CustPhone;
    }

    public void setCustPhone(String custPhone) {
        CustPhone = custPhone;
    }
}

