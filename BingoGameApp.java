// Class: BingoGameApp
//
// Author:  Kelly Schultz and Alyce Brady
//
// Created on Mar 18, 2008
// Updated on Apr 21, 2009 to add control panel of buttons and color choosers.
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import java.awt.Color;

/**
 *  Bingo Game:<br>
 *
 *  A BingoGame object represents an application that plays a
 *  game of bingo.
 *
 *  @author Kelly Schultz and Alyce Brady
 *  @version April 21, 2009
 */
public class BingoGameApp
{
    /** The numbers on the Bingo cards will range from 1 to MAX_VALUE. */
    public static final int MAX_VALUE = BingoCard.NUMCOLS * BingoCard.NUMCOLS * 3;

    /** Executes the Bingo Game application.
     *    @param args  unused
     */
    public static void main(String[] args)
    {
        // Create and initialize the object that controls the game.
        BingoGame game = new BingoGame();
                                        
        // The game will play when the user clicks the Play button.
    }

}
