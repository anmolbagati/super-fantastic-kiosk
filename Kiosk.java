import java.util.Scanner;

/**
 * The kiosk class is the main class where the customer will interact with the kiosk to do multiple functions
 * The customer can create an order, add credits to user account, view and purchase items and simulate collection of order
 * 
 * @author Anmol Bagati
 * @version v3.5 
 */
public class Kiosk
{
    private Customer cust;
    private LuckyDipGenerator randomNum;

    /**
     * Default Constructor for objects of class Kiosk
     */
    public Kiosk()
    {
        cust = new Customer();
        randomNum = new LuckyDipGenerator();
    }

    /**
     * Non-Deafult Constructor for objects of class Kiosk with parameterisd variables
     */
    public Kiosk(Customer newCustomer, LuckyDipGenerator newRandomNum)
    {
        cust = new Customer();
        randomNum = new LuckyDipGenerator();
    }

    /**
     * Method to take user input from system keyboard through console
     * 
     * @param  message   a String data type which prints the message before taking user input
     * @return           input by user (String)
     */

    private String acceptStringInput(String message)
    {
        Scanner sc = new Scanner(System.in);
        print(message); // print out the parameter
        return sc.nextLine().strip(); 
    }

    /**
     * Method to buy credits when user selects the option 2.
     * 
     * It uses another method getNewCredits(); to input the credits from the user
     * and then sets the new credit by adding new to the existing and displays it to user.
     * 
     */
    private void buyCredit()
    {
        print("Please enter the amount of credit you wish to buy");
        int buyCredits = getNewCredits(); 
        cust.setCredits(cust.getCredits() + buyCredits);
        print("The updated credit amount is $" + cust.getCredits() +"\n");
    }

    /**
     * Method to check credit balance available is greater than the itemcost of the item
     * selected to be purchased.
     * 
     * @param  itemCost   An integer cost of the selected item.
     * @returns           a value if available user credits is greater than the cost of item selected
     */
    private boolean checkCreditBalance(int itemCost)
    {
        if (cust.getCredits() < itemCost)
        {
            return false;
        }
        return true;
    }

    /**
     * Method to check if a customer exixts in the kiosk system.
     * 
     * @returns       value if the customer has been created by user (boolean)
     */
    private boolean checkCustomerExists()
    {
        if (cust.getName().equals(""))
        {
            return false;
        }
        return true;
    }
    
    /**
     * Method to collect order after the order is processed for checkout by the user, using option 5.
     * This methods displays the item purchased with a goodbye message.
     * 
     * The method also clears the customer object for fresh entry.
     */
    private void collectOrder()
    {
        displayItemsOrdered();
        print("Thank you for shopping with us. Please collect your goods (and your remaining balance) at the front desk.\n");
        cust = new Customer(); 
    }

    /**
     * Method to create a new order after option 1 is selected by the user.
     * 
     * If customer already exists, it will clear the old customer and create new one.
     * The method inputs name and initial credits from the user to create an order.
     */
    private void createOrder()
    {
        //cust = new Customer();
        if (!cust.getName().equals(""))
            collectOrder();
        String name = getCustomerName();
        int credits = getNewCredits();
        cust = new Customer(name,"", credits);
        print("A Customer with Name: " + cust.getName() + " and $" + cust.getCredits() + " credits has been created.\n");
    }

    /**
     * Method to display the help or instructions to use the application
     */
    private void displayHelp()
    {
        print("Super Fantastic Kiosk Help Guide");
        print("=================================");
        print("Hello Customer, here are some pointers which will help shop with us");
        print("a. If you like to shop with us, you have to first create a new order.");
        print("b. Before purchasing an item, make sure you have enough credit.");
        print("c. You can add extra credit to your account by choosing option 2.");
        print("d. Option 3 will display all the items we have for you today");
        print("e. If you're anything like the coder, and cant decide what to purchase, choose option 6");
        print("=================================");
        print("Thanks for shopping with us during the pandemic :)");
    }

    /**
     * Method to display the items ordered by the user, when customer selects option 4.
     * 
     * The method checks if the user has purchased items, if yes, displays the items purchased, 
     * total expense and the remaining credit balance.
     */
    private void displayItemsOrdered()
    {
        if (cust.getItems().equals(""))
            print("Customer " + cust.getName() + " has not purchased any items!");
        else
        {
            print("Customer " + cust.getName() + " has purchased these items:");
            print(cust.getName() + "you have purchased these items:");
            print("\t" + cust.getItems()); 
            print("Total Money Spent: $" + cust.getTotalCost());
        }
        print("Remaining Credit Balance: $" + cust.getCredits() + "\n");
    }

    /**
     * Method to display main menu
     */
    private void displayMainMenu()
    {
        print("Welcome to Super Fantastic Kiosk");
        print("================================");
        print("(1) Create A New Order");
        print("(2) Buy More Credit");
        print("(3) Purchase An Item");
        print("(4) What Have I Ordered So Far?");
        print("(5) Collect My Order");
        print("(6) Display Help");
        print("(7) Leave Kiosk");
    }

    /**
     * Method to display purchase menu
     */
    private void displayPurchaseMenu()
    {
        print("These are the items available for sale today:");
        print("------------------------------------------------------------");
        print("(1) PEN, worth $10.");
        print("(2) BOOK, worth $20.");
        print("(3) DVD, worth $30.");
        print("(4) MOUSE, worth $40.");
        print("(5) KEYBOARD, worth $50.");
        print("(6) Let ME pick a random item for you!!!");

    }
    
    /**
     * Method to input 'valid' customer name in a string from the user.
     * 
     * @returns     a value of the name inout by user through console (String)
     */
    private String getCustomerName()
    {
        boolean gotName = false;
        String name = new String();
        do
        {
        name = acceptStringInput("Please enter the name of new customer: ");
        if (validateName(name) == false)
            print("Customer name entered is Invalid. Please enter a valid name: ");
        else
            gotName = true;
        }
        while (!gotName); // run loop till we get correct name with valid data type
        return name;
    }
    
    /**
     * Method to input 'valid' customer credits from the user.
     * 
     * @returns        if credits is validated (Integer)
     */
    private int getNewCredits()
    {
        String creditInput = "";
        int credits = 0;
        while (credits <= 0)
        {
            creditInput = acceptStringInput("Buy some credits please: $");
            if (isInteger(creditInput))
            {
                credits = Integer.parseInt(creditInput);
                if (credits <= 0)
                    print("Please enter a credit value greater than 0\n");
            }
            else
                print("Please enter a valid integer value!!");   
        }
        return credits;
    }

    /**
     * Method to check if an user input value is integer or not
     * 
     * @param  inputString   a user input of String data type from the system console
     * @returns              value if its an integer (boolean)
     */

    private boolean isInteger(String inputString)
    {
        try
        {
            Integer.parseInt(inputString);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    /**
     * Method to exit the kiosk by resetting the kiosk application
     */
    private void leaveKiosk()
    {
        print("Thank you for shopping with us. Please visit again soon");
        System.exit(1);

    }

    /**
     * Method to print a message
     * 
     * @param  message   a string that is to be printed to the user through system console
     */
    private void print(String message)
    {
        System.out.println(message); 
    }

    /**
     * Method to accept user input for the purchase menu options
     * and validate input (is it between 1-6?)
     */
    private void purchaseAnItem()
    {
        String userOption = "";
        boolean isValid = false;
        int randomNumber = 0;
        while (!isValid)
        {
            displayPurchaseMenu();
            userOption = acceptStringInput("Pick a number between 1-6: ");

            if (userOption.equals("6"))
            {
                randomNumber = randomNum.generateRandomNumber(1,5);
                print("Computer picked item number : " + randomNumber);
                isValid = purchaseItemOptions(String.valueOf(randomNumber));
            }
            else
            {
                isValid = purchaseItemOptions(userOption);     
            }
        }

    }
    
    /**
     * Method to purchase the item (if enough credit), performing the calculations of remaining credits
     * 
     * @param  itemName   a string to store item name
     * @param  itemCost   an integer to store item cost
     */
    private void purchaseItem(String itemName, int itemCost)
    {
        if (checkCreditBalance(itemCost))
        {
            print("You have bought a " + itemName + ", worth $" + itemCost + ".");
            cust.setCredits(cust.getCredits() - itemCost); 
            print("Your new credit balance is now: $" + cust.getCredits() + "\n");
            String newItems = "";
            if (cust.getItems().equals(""))
                newItems = itemName;
            else
                newItems = cust.getItems() + ", " + itemName;
            cust.setItems(newItems);
            cust.setTotalCost(cust.getTotalCost() + itemCost);
        }
        else
        {
            print("Sorry, you do not have enough credit to purchase this item!");
            print("Credit Balance: $" + cust.getCredits() + ", Item Cost: $" + itemCost + "\n");   
        }
    }
    
    /**
     * Method to get user input to purchase which item
     * 
     * userOption - a string input from user after the user has selected which item to purchase
     */
    private boolean purchaseItemOptions(String userOption)
    {
        switch (userOption)
        {
            case "1":
                purchaseItem("PEN", 10); break;
            case "2":
                purchaseItem("BOOK", 20); break;
            case "3":
                purchaseItem("DVD", 30); break;
            case "4": 
                purchaseItem("MOUSE", 40); break;
            case "5":
                purchaseItem("KEYBOARD", 50); break;
            default:
                print("Error: your choice must be between 1-6.");
            return false;
        }
        return true;
    }

    /**
     *  Method to start the main interaction with the program
     */
    public void startProgram()
    {
        print("\u000C");
        String userOption = "";
        while (true)
        {
            displayMainMenu();
            userOption = acceptStringInput("Choose an option:");
            // condition to check is users try to buy credits without creating an order (or customer)
            if ((userOption.equals("2") || 
                userOption.equals("3") || 
                userOption.equals("4") || 
                userOption.equals("5")) && 
                !checkCustomerExists())
            {
                print("Please create an order first\n");
            }
            else
            {
                switch (userOption)
                {
                    case "1":
                        createOrder(); break;
                    case "2":
                        buyCredit(); break;
                    case "3":
                        purchaseAnItem(); break;
                    case "4":
                        displayItemsOrdered(); break;
                    case "5":
                        collectOrder(); break;
                    case "6":
                        displayHelp(); break;
                    case "7":
                        leaveKiosk(); break;
                    default:
                        print("Please enter a correct option!"); break;
                }
            }
        }
    }
    
    /**
     *  Method to validate if the user inputed name is of valid format.
     *  
     *  @returns      a true value if the format is valid (boolean)
     */
    private boolean validateName(String name) 
    {
        name = name.toLowerCase();
        char[] charArray = name.toCharArray();
        for (int i = 0; i < charArray.length; i++) 
        {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z')) 
            return false;
        }
        return true;
    }
}
