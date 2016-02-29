package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controler.AbsControler;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import observer.Observer;

public class View extends JFrame implements Observer{

	  private JPanel container = new JPanel();
	   
	  String[] tab_string = {"7", "8", "9", "4", "5", "6", "1", "2", "3", "0", ".", "=", "C", "+", "-", "*", "/", "%"};
	  JButton[] tab_button = new JButton[tab_string.length];
	   
	  private JTextField ecran = new JTextField();
	  private Dimension dim = new Dimension(50, 60);
	  private Dimension dim2 = new Dimension(60, 38);
	  private AbsControler controler;

	  public View(AbsControler controler){                
	    this.setSize(260, 335);
	    this.setTitle("simpleCount");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    initComposant();                
	    this.controler = controler;                
	    this.setContentPane(container);
	    this.setVisible(true);
	  }

	  private void initComposant(){
	    Font police = new Font("Segoe UI", Font.BOLD, 19);
	    ecran = new JTextField("0");
	    ecran.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    ecran.setHorizontalAlignment(SwingConstants.RIGHT);
		ecran.setBackground(Color.LIGHT_GRAY);
		container.add(ecran);
	    ecran.setColumns(15);

	    JPanel operateur = new JPanel();        
	    operateur.setPreferredSize(new Dimension(65, 400));
	    JPanel chiffre = new JPanel();
	    chiffre.setPreferredSize(new Dimension(165, 400));

	    OperateurListener opeListener = new OperateurListener();

	    for(int i = 0; i < tab_string.length; i++)
	    {
	      tab_button[i] = new JButton(tab_string[i]);
	      tab_button[i].setPreferredSize(dim);
	      tab_button[i].setFont(police);
	      switch(i){
	        case 11 :
	          tab_button[i].addActionListener(opeListener);
	          chiffre.add(tab_button[i]);
	          break;
	        case 12 :
	          tab_button[i].setForeground(Color.red);
	          tab_button[i].addActionListener(new ResetListener());
	          tab_button[i].setPreferredSize(dim2);
	          operateur.add(tab_button[i]);
	          break;
	        case 13 :
	        case 14 :
	        case 15 :
	        case 16 :
	        case 17 :
	          tab_button[i].setForeground(Color.red);
	          tab_button[i].addActionListener(opeListener);
	          tab_button[i].setPreferredSize(dim2);
	          operateur.add(tab_button[i]);
	          break;
	        default :
	          chiffre.add(tab_button[i]);
	          tab_button[i].addActionListener(new ChiffreListener());
	          break;                       
	      }                    
	    }
	    container.add(chiffre, BorderLayout.CENTER);
	    container.add(operateur, BorderLayout.EAST);          
	  }   

	
	  class ChiffreListener implements ActionListener{ 
	    public void actionPerformed(ActionEvent e) {
	      String str = ((JButton)e.getSource()).getText();
	      if(!ecran.getText().equals("0"))
	        str = ecran.getText() + str;

	      controler.setNombre(((JButton)e.getSource()).getText());
	    }                
	  }

	  class OperateurListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      controler.setOperateur(((JButton)e.getSource()).getText());
	    }           
	  }
	   
	  class ResetListener implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	      controler.reset();
	    }               
	  }
	   
	  public void update(String str) {
	    ecran.setText(str);
	  }  
	}
