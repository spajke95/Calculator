/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author aca
 */
public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[9];
    JButton addButton,substractButton,multiplyButton,divideButton;
    JButton decimalButton,equalsButton,deleteButton,clearButton,negativeButton;
    JPanel panel;
    
    Font myFont =new Font("Ink Free",Font.BOLD,30);
    
    double num1=0,num2=0,result=0;
    char operator;
    
    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        
        textfield=new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);//notWritable
        
        addButton=new JButton("+");
        substractButton=new JButton("-");
        multiplyButton=new JButton("*");
        divideButton=new JButton("/");
        decimalButton=new JButton(".");
        equalsButton=new JButton("=");
        deleteButton=new JButton("Delete");
        clearButton=new JButton("Clear");
        negativeButton=new JButton("(-)");
        
        functionButtons[0]=addButton;
        functionButtons[1]=substractButton;
        functionButtons[2]=multiplyButton;
        functionButtons[3]=divideButton;
        functionButtons[4]=decimalButton;
        functionButtons[5]=equalsButton;
        functionButtons[6]=deleteButton;
        functionButtons[7]=clearButton;
        functionButtons[8]=negativeButton;
        
        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
         for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negativeButton.setBounds(50, 430, 100, 50);
        deleteButton.setBounds(150,430,100,50);
        clearButton.setBounds(250,430,100,50);//position x,position y,width,height
        
        panel=new JPanel();//making new section 
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));//rows,columns,horizontalgap,verticalgapp
        //panel.setBackground(Color.GRAY);
        panel.add(numberButtons[1]);//adding numbers and buttons to section grid
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(substractButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divideButton);
        
        
        
        frame.add(panel);//adding section to frame
        frame.add(negativeButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        
        Calculator calc=new Calculator();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0;i<10;i++){
           if(e.getSource()==numberButtons[i]){
               textfield.setText(textfield.getText().concat(String.valueOf(i)));//nadovezuje tekst na postojeci tekst
           }
       }
       if(e.getSource()==decimalButton){
               textfield.setText(textfield.getText().concat("."));
           }
        if(e.getSource()==addButton){
               num1=Double.parseDouble(textfield.getText());
               operator='+';
               textfield.setText("");
           }
         if(e.getSource()==substractButton){
               num1=Double.parseDouble(textfield.getText());
               operator='-';
               textfield.setText("");
           }
          if(e.getSource()==multiplyButton){
               num1=Double.parseDouble(textfield.getText());
               operator='*';
               textfield.setText("");
           }
           if(e.getSource()==divideButton){
               num1=Double.parseDouble(textfield.getText());
               operator='/';
               textfield.setText("");
           }
           if(e.getSource()==equalsButton){
               num2=Double.parseDouble(textfield.getText());
               
               switch(operator){
                   case '+':
                       result=num1+num2;
                       break;
                   case '-':
                       result=num1-num2;
                       break;
                   case '*':
                       result=num1*num2;
                       break;
                   case '/':
                       result=num1/num2;
                       break;
               }
               textfield.setText(String.valueOf(result));
               num1=result;
               
           }
            if(e.getSource()==clearButton){
               textfield.setText("");
           }
            if(e.getSource()==deleteButton){
                String s=textfield.getText();
                textfield.setText("");
                for(int i=0;i<s.length()-1;i++){
                    textfield.setText(textfield.getText()+s.charAt(i));//writes all characters except the last one
                }
             
           }
            if(e.getSource()==negativeButton){
                 double temp=Double.parseDouble(textfield.getText());
                 temp*=-1;
                 textfield.setText(String.valueOf(temp));
             }
            
         
    }
    
}
