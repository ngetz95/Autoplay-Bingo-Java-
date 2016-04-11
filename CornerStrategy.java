
/**
 * Write a description of class CornerStrategy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CornerStrategy implements WinningStrategy
{
    public String description()
    {
        return "all four corners";
    }

    public boolean isWinner(BingoCard card)
    {
        int k = 0;

        for(int i = 0; i < BingoCard.NUMCOLS; i++)
        {

            if(card.getCellAt(1, 0).isMarked() && card.getCellAt(1, BingoCard.NUMCOLS).isMarked() && card.getCellAt(1 + BingoCard.NUMCOLS, 0).isMarked() && card.getCellAt(1 + BingoCard.NUMCOLS, BingoCard.NUMCOLS).isMarked())
            {
                k++;
            }                

            if(k == 1)
            {
                return true;
            }

        }

        return false;
    }
}
