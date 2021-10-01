
/**
 * Customer Class acts as a template to make objects in the kiosk class 
 * whenever a customer purchasing instance is initiated.
 *
 * @author Anmol Bagati
 * @version v2.3 
 */
public class Customer
{
    private String name;
    private String items;
    private int totalCost;
    private int credits;

    /**
     * Default Constructor for objects of class Customer
     */
    public Customer()
    {
        name = "";
        items = "";
        totalCost = 0;
        credits = 0;
    }

    /**
     * Non-default Constructor for objects of class Customer
     * 
     * @param  newName   a string to take customer name as input while creating object
     * @param  newItems   a string to take item names as input while creating object
     * @param  newCredits   an integer to take customer name as input while creating object
     */
    public Customer(String newName, String newItems, int newCredits)
    {
        name = newName;
        items = newItems;
        totalCost = 0;
        credits = newCredits;
    }
    
    /**
     * Accessor Method to return credits attribute
     * 
     * @return   credits value (Integer)
     */
    public int getCredits()
    {
        return credits;
    }
    
    /**
     * Accessor Method to return items attribute
     * 
     * @return   item value (String)
     */
    public String getItems()
    {
        return items;
    }

    /**
     * Accessor Method to return name attribute
     * 
     * @return    name value (String)
     */
    public String getName()
    {
        return name;
    }

    /**
     * Accessor Method to return totalCost attribute
     * 
     * @return    totalcost value (Integer)
     */
    public int getTotalCost()
    {
        return totalCost;
    }

    /**
     * Mutator Method to modify credits attribute
     * 
     * @param  newCredits   an integer to be assigned to the credits
     */
    public void setCredits(int newCredits)
    {
        credits = newCredits;
    }

    /**
     * Mutator Method to modify items attribute
     * 
     * @param  newItems   a string to be assigned to the items
     */
    public void setItems(String newItems)
    {
        items = newItems;
    }

    /**
     * Mutator Method to modify name attribute
     * 
     * @param  newName   a string to be assigned to the name
     */
    public void setName(String newName)
    {
        name = newName;
    }

    /**
     * Mutator Method to modify totalCost attribute
     * 
     * @param  newTotalCost   an integer to be assigned to the totalCost 
     */
    public void setTotalCost(int newTotalCost)
    {
        totalCost = newTotalCost;
    }
}
