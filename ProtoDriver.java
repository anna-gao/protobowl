/**
 * Write a description of class ProtoDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import chn.util.*; //for ConsoleIO

public class ProtoDriver
{
    /**
     * Here is the main() method
     * 
     */
    public static void main(String[] args) throws InterruptedException
    {
        /* Variables */
        FileInput inFileQ = new FileInput("protobowlquestions.txt");
        FileInput inFileA = new FileInput("protobowlanswers.txt");
        QA test = new QA(inFileQ, inFileA);
        Player player = new Player();
        ConsoleIO input = new ConsoleIO(); 
        String answer;
        
        /*
        ProtoGUI proto = new ProtoGUI();
        proto.setQuestion
        proto.newQuestion(test.getQuestion());
        */
       
        /* Introduction */
        System.out.println("Welcome to Protobowl! Protobowl is a buzzer-style trivia game and a player is given twenty seconds to read the question and buzz in to answer." +
        "If the answer is correct, the team earns 10 points. If the answer is incorrect, the game provides the answer for the player and the incorrect buzz results in a 5 point penalty." +
        "Please make sure to check your spelling, as spelling errors will be penalized." + "Players will be allowed to buzz in more than once.");
        System.out.println("Click the \" Start \" button to begin.");
        System.out.println("\n");
        
        /*Processing the questions and answers */
        System.out.print("Question: ");
        test.wordByWord();
        System.out.print("Answer: ");
        answer = input.readLine();
        
        if(test.isCorrect(answer))
        {
            System.out.println("Correct!");
            player.addPoints(); 
            player.tossRight();
            System.out.println("Number of toss-ups correct: " + player.getTossRight());
            System.out.println("Number of toss-ups wrong: " + player.getTossWrong());
            System.out.println("Number of points you have: " + player.getPoints());
            System.out.println();
        }
        else
        {
            System.out.println("Incorrect. The correct answer is " + test.getAnswer());
            player.deductPoints(); 
            player.tossWrong();
            System.out.println("Number of toss-ups correct: " + player.getTossRight());
            System.out.println("Number of toss-ups wrong: " + player.getTossWrong());
            System.out.println("Current number of points: " + player.getPoints());
            System.out.println();
        }
    }
}
