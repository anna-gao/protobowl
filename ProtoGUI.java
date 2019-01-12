import java.awt.Point;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import chn.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Timer;
//import java.util.TimerTask;

//import javax.swing.Timer;


public class ProtoGUI extends JFrame implements KeyListener
{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextArea question = new JTextArea("When ready, press next!");
    JLabel label = new JLabel("What is your answer?");
    JButton button = new JButton("Check!");
    JButton buttonNext = new JButton("Next");
    JButton buttonClear = new JButton("Clear History");
    
    JButton art = new JButton("Fine Arts");
    JButton lit = new JButton("Literature");
    JButton history = new JButton("History");
    JButton music = new JButton("Music");
    JButton sm = new JButton("Science/Math");
    String print = "";
   
    
    JTextField textField = new JTextField();
    JTextArea previousAnswers = new JTextArea();
    //Countdown timer = new Countdown();
    FileInput infile1 = new FileInput("protobowlquestions.txt");
    FileInput infile2 = new FileInput("protobowlanswers.txt");
    QA load;
    private String questionNext;
    String[] split;
    
    JLabel time = new JLabel("Time");
    private Timer timer;
    private int counter = 20; // the duration
    private int delay = 1000;
    //Countdown counter;
    
    Thread t1;
    boolean first = true;
    boolean checked = true;

    public ProtoGUI()
    {
        load = new QA(infile1, infile2);
        button.addActionListener(new ButtonCheckActionListener());
        buttonNext.addActionListener(new ButtonNextActionListener());
        buttonClear.addActionListener(new ButtonClearActionListener());
        textField.setPreferredSize(new Dimension(200, 30));
        
        art.addActionListener(new ButtonArtActionListener());
        lit.addActionListener(new ButtonLitActionListener());
        history.addActionListener(new ButtonHistoryActionListener());
        music.addActionListener(new ButtonMusicActionListener());
        sm.addActionListener(new ButtonSMActionListener());
        
        textField.addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        question.setEditable(false);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        
        JScrollPane questionScroll = new JScrollPane(question);
        questionScroll.setPreferredSize(new Dimension(750, 200));
        
        previousAnswers.setEditable(false);
        previousAnswers.setLineWrap(true);
        previousAnswers.setWrapStyleWord(true);
        
        JScrollPane scroll = new JScrollPane(previousAnswers);
        scroll.setPreferredSize(new Dimension(350, 90));
        
        panel.add(art);
        panel.add(lit);
        panel.add(history);
        panel.add(music);
        panel.add(sm);
        panel.add(questionScroll);
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        panel.add(buttonNext);
        panel.add(scroll);
        panel.add(buttonClear);
        panel.add(time);
        
        frame.add(panel);
        
        frame.setSize(new Dimension(800, 400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Protobowl!");
        frame.setResizable(false);
        
    }
    
    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            buttonNext.doClick();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            checked = false;
        }
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            button.doClick();
        }
    }
    
    public void keyTyped(KeyEvent e) 
    {
        
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
    }
    
    
    private class ButtonClearActionListener implements ActionListener
    {   
        public void actionPerformed(ActionEvent e)
        {
           previousAnswers.setText("");
        }
    }
    
    private class ButtonNextActionListener implements ActionListener
    {
        
        
        public void actionPerformed(ActionEvent e) 
        {

             questionNext = load.getQuestion();
              split = questionNext.split(" ");
             /*
            for (int i = 0; i < split.length; i++)
            {
                System.out.println(split[i]);
            }
            */
               //question.setText(questionNext);
           
           
               label.setText("");
               previousAnswers.setText("");
               //timer.stop();
               counter = 20;
               //startCounter();
               t1.start();
           
           
        }
    }
    
    private class ButtonCheckActionListener implements ActionListener
    {
        private String correct;
        
        public void actionPerformed(ActionEvent e)
        {
            String answer = textField.getText();
            
            if (load.isCorrect(answer))
            {
                correct = "right!";
                label.setText("Your answer is " + correct);
                t1.stop();
            }
            else
            {
                correct = "wrong!";
                label.setText("Your answer is " + correct);
                checked = true;

                    synchronized (t1) 
                    {
                        t1.notify();
                        // msg.notifyAll();

                }
            }
        
                
            //label.setText("Your answer is " + correct);
            
            previousAnswers.append("\n" + answer + " (" + correct + ")");
            textField.setText("");
            
         }
    }
    
    private class ButtonArtActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    
    private class ButtonLitActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    
    private class ButtonHistoryActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    
    private class ButtonMusicActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    
    private class ButtonSMActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        }
    }
    
    public void startCounter()
    {
        t1 = new Thread()
        {
            public void run()
            {                
                if (!first)
                    {                        
                    int word = 0;
                    
                    for (int i = 0; i < split.length; i++)
                    {
                        word++;
                    }
                    
                    int numPerSec = word / 10;
                    String print = "";
 
                   while (counter > 0)
                    {
                        time.setText(String.valueOf(counter));
                        time.paintImmediately(time.getVisibleRect());
                        for (int i = 0; i < numPerSec; i++)
                        {
                            if (split[i] != null)
                            {
                                print = print + split[i] + " ";
                                question.setText(print);
                                question.paintImmediately(question.getVisibleRect());
                            }
                            
                            try
                                {
                                    Thread.sleep(1000/numPerSec);
                                    }
                                catch (InterruptedException ex)
                                {
                                    Thread.currentThread().interrupt();
                                    }
                            
                            synchronized (this) 
                            {
                                try 
                                {
                                    while (!checked)
                                    {
                                        wait();
                                    }
                                } 
                                catch (InterruptedException e) 
                                {
                                }
                            }
                        }
                        
                        for (int j = 0; j < split.length - numPerSec; j++)
                        {
                            split[j] = split[j + numPerSec];
                            split[j + numPerSec] = null;
                        }
                        counter--;
                    }
                    //timer.stop();
                    time.setText("The time is up!");
                }
            }
         };

        setVisible(true);
        first = false;
    }
    
    
    private void createView()
    {
        frame.setVisible((true));
        startCounter();
    }
    
    public static void main(String[] args)
    {
        ProtoGUI proto = new ProtoGUI();
        proto.createView();
    }
}
