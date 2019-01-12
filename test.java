
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

public class test extends JPanel
{
    JButton art = new JButton("Fine Arts");
    JButton lit = new JButton("Literature");
    JButton history = new JButton("History");
    JButton music = new JButton("Music");
    JButton sm = new JButton("Science/Math");
    
    JPanel panel = new JPanel(new GridBagLayout());
    JFrame frame = new JFrame();
    
    GridBagConstraints gbc = new GridBagConstraints();
    public test()
    {
        
        setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.1;
        panel.add(art, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(lit, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(history, gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 0;
        panel.add(music, gbc);
        
        gbc.gridx = 4;
        gbc.gridy = 0;
        panel.add(sm, gbc);
        
        JTextArea question = new JTextArea("When ready, press next!");
        JScrollPane questionScroll = new JScrollPane(question);
        questionScroll.setPreferredSize(new Dimension(750, 200));
        
        gbc.gridx = 0;
        gbc.gridy = -1;
        
        gbc.gridwidth = 8;
        gbc.gridheight = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.fill = GridBagConstraints.VERTICAL;
        panel.add(questionScroll, gbc);
        
        frame.add(panel);
        frame.setSize(new Dimension(800, 400));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Protobowl!");
        frame.setResizable(false);
    }
    
    private void createView()
    {
        frame.setVisible((true));
    }
    
    public static void main(String[] args)
    {
        test proto = new test();
        proto.createView();
    }
    
}
