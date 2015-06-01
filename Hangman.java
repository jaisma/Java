import java.util.*;

public class Hangman {

    public static void main(String[] args) {
        String[] wordList = new String[12];
        wordList[0] = "zeroth";
        wordList[1] = "first";
        wordList[2] = "second";
        wordList[3] = "third";
        wordList[4] = "fourth";
        wordList[5] = "fifth";
        wordList[6] = "sixth";
        wordList[7] = "seventh";
        wordList[8] = "eighth";
        wordList[9] = "ninth";
        wordList[10] = "tenth";
        wordList[11] = "eleven";

        Random numgen = new Random();
        int randInt = numgen.nextInt(11);
        
        String word = wordList[randInt];
        int wordLength = word.length();
        
        String[] hangman = new String[wordLength];
        for(int i = 0; i < wordLength; i++){
            hangman[i] = "_ ";
        }
        int life = 6;
        
        System.out.println("Welcome to HANGMAN!");
        while(life > 0){
            for(String i: hangman)
                System.out.print(i);
            System.out.print(" Guesses left: " + life);
            
            Scanner in = new Scanner(System.in);
            System.out.print(" Which letter? ");
            String guess = in.nextLine();

            boolean changed = false;
            int count = 0;
            for(int i = 0; i < wordLength; i++){
                if(word.charAt(i) == guess.charAt(0)){
                    hangman[i] = guess.charAt(0) + " ";
                    changed = true;
                    count ++;
                }
            }
            
            if (changed == true)
                System.out.println("You got " + count + " letter(s) correct!");
            else if (changed == false){
                System.out.println("Sorry, you got that wrong");    
                life--;
            }
            
            boolean status = true;
            for(int i = 0; i < wordLength; i++){
                status = "_ ".equals(hangman[i]);
            }
            if(status == false)
                break;
        }
        System.out.print("YOU WON!! The word was: ");
        for(String i: hangman)
                System.out.print(i);
    }
}
