import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 *  Bingo Game:<br>
 *
 *  A BingoGame object controls the play of a game of bingo.
 *
 *  @author Kelly Schultz and Alyce Brady
 *  @version April 21, 2009
 */
public class BingoGame
{
    // Public constant value (not tied to a particular instance).
    /** The numbers on the Bingo cards will range from 1 to MAX_VALUE. */
    public static final int MAX_VALUE = 76;

    // Instance variables: Encapsulated data for each BingoGame object
    private Random    randNumGenerator;
    private BingoCard card;
    private BingoGUI  display;
    private WinningStrategy x;
    private WinningStrategy y;
    private WinningStrategy u;
    private WinningStrategy v;
    private WinningStrategy w;
    private ArrayList<WinningStrategy>  registeredStrategies;

    /**
     * Constructs an object that controls games of Bingo.
     */
    public BingoGame()
    {
        // Create a random number generator to use for calling numbers.
        this.randNumGenerator = new Random();

        // Create and initialize the card for the bingo game.
        this.card = new BingoCard(MAX_VALUE);

        // Create graphical user interface capable of displaying
        // the bingo game.  This will also display the initial card.
        this.display = new BingoGUI(card, this,
                                    "Kelly Schultz and Alyce Brady",  // authors
                                    "",  // outside assistance
                                    "April 2009",  // date
                                    ""); // help file, e.g. "file:Bingo.html"
        //this.x = new RowStrategy();
        // this.y = new ColumnStrategy();
        this.registeredStrategies = new ArrayList<WinningStrategy>();
        //registeredStrategies.add(x);
        //registeredStrategies.add(y);
        
    }

    /** Includes or removes the Complete Row Marked winning strategy when
     *  user clicks the appropriate button.
     */
    public void onCompleteRowWinsButtonClick()
    {
        // Create a warning dialog box (JOptionPane).
        

        // Should call toggle with a new object of your row winning strategy class.
        toggle(new RowStrategy());
    }
    
    public void onCompleteColumnWinsButtonClick()
    {
        // Create a warning dialog box (JOptionPane).
        

        // Should call toggle with a new object of your row winning strategy class.
        toggle(new ColumnStrategy());
    }
    
    public void onCompleteDeclineWinsButtonClick()
    {
        // Create a warning dialog box (JOptionPane).
        

        // Should call toggle with a new object of your row winning strategy class.
        toggle(new DeclineStrategy());
    }
    
    public void onCompleteInclineWinsButtonClick()
    {
        // Create a warning dialog box (JOptionPane).
        

        // Should call toggle with a new object of your row winning strategy class.
        toggle(new InclineStrategy());
    }
    
    public void onCompleteCornerWinsButtonClick()
    {
        // Create a warning dialog box (JOptionPane).

        // Should call toggle with a new object of your row winning strategy class.
        toggle(new CornerStrategy());
    }
    
    
    
    public boolean printStrategy()
    {
        if(x.isWinner(card) == true || y.isWinner(card) == true || u.isWinner(card) || v.isWinner(card) || w.isWinner(card))
        return true;
        else
        return false;
        
    }
    

    /** Adds or removes the given strategy from the list of registered
     *  strategies, depending on whether it is already there.
     */
    
    
     private void toggle(WinningStrategy strategy)
     {
         if ( ! registeredStrategies.remove(strategy) )
             registeredStrategies.add(strategy);
     }
     

    

    /** Plays a game of Bingo when user clicks the Play button.
     *  (Precondition: <code>setDisplay</code> must be called first.)
     */
    public void onPlayButtonClick()
    {
        // Initialize the Bingo card.
        card.initialize();
        int countOfNumbersCalled = 0;
        
        if(registeredStrategies.isEmpty())
        {
            onCompleteRowWinsButtonClick();
            onCompleteColumnWinsButtonClick();
            onCompleteDeclineWinsButtonClick();
            onCompleteInclineWinsButtonClick();
        }

        // Let the user know which strategies are being used.
        reportStrategies();
        
        // Play the game.
        while (gameOver() == false)   // this loop is stub behavior
        {
            card.playNumber(randNumGenerator.nextInt(MAX_VALUE));
            countOfNumbersCalled++;
            System.out.print(".");
            display.showGrid();
        }

        // Indicate that the game is over.
        card.indicateCardWon();
        display.showGrid();
        System.out.println("\nPlayed " + countOfNumbersCalled + " numbers.");
    }

    /** Reports which winning strategies will be used.  (If no winning
     *  strategies were chosen, uses a pre-determined set of basic ones.)
     */
    private void reportStrategies()
    {
        // Let the user know which strategies are being used.
        System.out.println("\nPlaying Bingo with following strategies:");
        System.out.println("\t");   // stub behavior
        
        for(WinningStrategy c: registeredStrategies)
        {
            System.out.println("\t" + c.description());
        }
        
    }

    /** Returns <code>true</code> if the game is over (a Bingo card has won
     *  according to a registered strategy).
     */
    private boolean gameOver()
    {
        // Check whether the card has won according to any of the registered
        // strategies.
        for(WinningStrategy c: registeredStrategies)
        {
            if(c.isWinner(card) == true)
            {
                return true;
            }
         
        }
        /**
        if(printStrategy() == true)
        {
            return true;
        }
        */
        
        return false;

        // You will implement this method
                  // stub behavior
    }
}
