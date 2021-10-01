import java.util.Random;
/**
 * LuckyDipGenerator is a class which generates a random number between
 * a programable 2 numbers.
 *
 * @author Anmol Bagati
 * @version v2.2
 */
public class LuckyDipGenerator
{
    int randomNum;

    /**
     * Constructor for objects of class LuckyDipGenerator
     */
    public LuckyDipGenerator()
    {
        randomNum = 0; 
    }

    /**
     * Non-default Constructor for objects of class LuckyDipGenerator
     */
    public LuckyDipGenerator(int newRandomNum)
    {
        randomNum = newRandomNum; 
    }

    /**
     * Method to generate a random number between a maximum and minimum value passed as parameters
     *
     * @param  min   a minimum value of the range
     * @param  max   a maximum value of the range
     * @return   a generated random number between those 2 numbers (Integer)
     */
    public int generateRandomNumber(int min, int max)
    {

        Random rand = new Random();
        randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
