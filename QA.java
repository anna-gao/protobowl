/**
 * Has the set of questions
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import chn.util.*;

public class QA
{
    /*
     * Using ArrayLists for questionSet and answerSet allow for easy addition of questions and answers
     * To prevent repeating the same question, the chosen question will switch places with the index of the last question
     * and the randomization for the next question will be index-1 (avoids getting the same question again)
     */
    ArrayList<String> q = new ArrayList<String>(); //creates a new ArrayList to insert the set of questions
    ArrayList<String> a = new ArrayList<String>(); //creates a new ArrayList to insert the set of answers (corresponding in index with questionSet)
    int random;
    boolean correct = false;
    
    /**
     * Constructor for objects of class Question
     * Reads from a file with all the questions
     */
    public QA(FileInput inFile, FileInput inFile2)
    {
        String line, line2; //each line of the question
        String empty; // for blank spaces
        
        //reads the questions from the text file into ArrayList q
        while(inFile.hasMoreLines())
        {
            line = inFile.readLine(); //reads line of text
            q.add(line);
            if(inFile.hasMoreLines())
                empty = inFile.readLine(); //reads the empty space
            line = "";
        }
        
        //reads the answers from the text file into ArrayList a
        while (inFile2.hasMoreLines())
        {
            line2 = inFile2.readLine(); //reads line of text
            a.add(line2);
            line2 = "";
        }
    }

    /**
     * Generates a random index of a question in ArrayList 
     */
    public String getQuestion()
    {
        random = (int)(Math.random() * q.size());
        String question = q.get(random);
        return question;
    }
    
    public void wordByWord() throws InterruptedException
    {
        String singQ = getQuestion();
        String [] split = singQ.split(" ");
        int i;
        int word = 0;
        int time;
        
        for (i = 0; i < split.length; i++)
        {
            word++;
        }
        
        for (i = 0; i < split.length; i++)
        {
            System.out.print(split[i] + " ");
            Thread.sleep(20000/word);
        }
    }

    
    /** 
     * Gets the answer at the random index in ArrayList a
     */
    public String getAnswer()
    {
        return a.get(random);
    }
    
    /**
     * Returns true if the player answers the question correctly (keyword exists in answer)
     * Gets answer as a lowercase
     */
    public boolean isCorrect(String guess)
    {
       String lowGuess = guess.toLowerCase();
       String ans = a.get(random); //actual answer to the question at the random index        
       String lowAns = ans.toLowerCase();
       int start = ans.indexOf('(');
       int end = ans.indexOf(')');
       //another if else statement
        
       //if the answer is within some part of the guess, then return true
       if ((lowGuess.indexOf(lowAns.substring(start + 1, end)) != -1))
       {
           return true;
       }
       else //if the guess is within any part of the answer, then return false
       {
           return false;
       }
    }
}    
