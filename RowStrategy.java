
/**
 * Write a description of class RowStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RowStrategy implements WinningStrategy
{
    public String description()
    {
        return "all numbers in a row";
    }
    
    public boolean isWinner(BingoCard card)
    {
        int k = 0;
        
        for(int j = 0; j < BingoCard.NUMCOLS; j++)
        {
            for(int i = 1; i <= BingoCard.NUMCOLS; i++)
            {
                if(card.getCellAt(i, j).isMarked())
                {
                    k++;
                }                
            }
            if(k == BingoCard.NUMCOLS)
            {
                return true;
            }
            
            k = 0;
        }

        return false;
        
    }
}
