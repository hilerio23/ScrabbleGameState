package com.example.scrabblegamestate;

import java.util.Random;

public class ScrabbleState {

        //15 x 15 board
        private ScrabbleLetter[][] board = new ScrabbleLetter[15][15];

        //an in to tell whos move it is 0 for human 1 for AI
        private int playerToMove;

        //array of SrabbleLetters for hand
        private ScrabbleLetter[] player1Hand = new ScrabbleLetter[7];
        private ScrabbleLetter[] player2Hand = new ScrabbleLetter[7];

        //array of ScrabbleLetters for Pool (100) total letters
        private ScrabbleLetter[] pool = new ScrabbleLetter[100];

        //game pause: 1 for pause 0 for playing
        private int gamePause;


        //constructor
        public ScrabbleState(){

            //sets board to blanks
            for(int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    board[i][j] = new ScrabbleLetter(' ');
                }
            }

            for(int i = 0; i < 7; i++){
                //generating random chars for each player
                Random rnd = new Random();
                char randomChar1 = (char) ('a' + rnd.nextInt(26));
                char randomChar2 = (char) ('a' + rnd.nextInt(26));
                //creating SrabbleLetters
                player1Hand[i] = new ScrabbleLetter(randomChar1);
                player2Hand[i] = new ScrabbleLetter(randomChar2);
            }

            for(int i = 0; i < 100; i++){
                Random rnd = new Random();
                char randomChar = (char) ('a' + rnd.nextInt(26));
                //doing random pool for now we can change how many of each letters we want later
                pool[i] = new ScrabbleLetter(randomChar);
            }

            //player 0 is human player
            playerToMove = 0;
            //0 = playing, 1 = pause
            gamePause = 0;

        }

        //deep copy
        public ScrabbleState(ScrabbleState scrabbleStateCopy){
            this.playerToMove = scrabbleStateCopy.playerToMove;
            this.gamePause = scrabbleStateCopy.gamePause;
            this.pool = scrabbleStateCopy.pool;
            this.board = scrabbleStateCopy.board;
            this.player1Hand = scrabbleStateCopy.player1Hand;
            this.player2Hand = null; //player1 can't see player 2 hand
        }

        @Override
        public String toString(){
            String output;
            output = "\ngame pause: " + this.gamePause + "\n";
            output += "player to move: " + this.playerToMove + "\n";

            output += "board: The board is empty";
            for(int i = 0; i < 15; i++) {
                for (int j = 0; j < 15; j++) {
                    output += this.board[i][j].getLetter() + " ";
                }
            }
            output += "\n";

            output += "pool: \n";
            for(int i = 0; i < 100; i++){
                output += this.pool[i].getLetter() + " ";
            }
            output += "\n";

            output += "player one hand: \n";
            for(int i = 0; i < 7; i++){
                output += this.player1Hand[i].getLetter() + " ";
            }
            output += "\n";

            if(this.player2Hand != null) {
                output += "player two hand: \n";
                for (int i = 0; i < 7; i++) {
                    output += this.player2Hand[i].getLetter() + " ";
                }
            }
            output += "\n";
            return output;

        }

        /**
         *
         * Methods in actions.txt
         *Also got rid of challenge because I don't think it's necessary
         *
         */

        public boolean isLegal(ScrabbleState scrabbleState){
            //code to determine if action is legal
            return true;
        }

        public boolean playWord(ScrabbleState scrabbleState){
            if(isLegal(scrabbleState) == true){
                return true;
            }
            else{
                return false;
            }
        }

        public boolean pass(ScrabbleState scrabbleState){
            if(isLegal(scrabbleState) == true){
                return true;
            }
            else{
                return false;
            }
        }

        public boolean exchange(ScrabbleState scrabbleState){
            if(isLegal(scrabbleState) == true){
                return true;
            }
            else{
                return false;
            }
        }

}
