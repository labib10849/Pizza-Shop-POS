package pizza_pos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login implements ActionListener 
{
    TextField t1,t2;
    Label  l1,l2,l3,l4;
    Button b,c,d;
    Login()
    {
    	
       Frame f=new Frame("Control Panel");
     
        l1=new Label("Username");
        l1.setBounds(30,100,200,25);
        l2 =new Label("Password");
        l2.setBounds(30,150,200,25);
        l3=new Label("");
        l3.setBounds(20,350,100,25);
     
        f.add(l1);
        f.add(l2);
        f.add(l3);

        t1 =new TextField();
        t2 =new TextField();
        t1.setBounds(250,100,100,25);
        t2.setBounds(250,150,100,25);
        f.add(t1);
        f.add(t2);
        f.setSize(400,400);
        f.setLayout(null);
      
        f.setVisible(true);
        f.setBackground(Color.GREEN);

        b=new Button("Login");
        b.setBounds(300,200,50,30);
        f.add(b);
        b.addActionListener(this);
        c=new Button("Customer");
        c.setBounds(100,300,200,40);
        f.add(c);
        c.addActionListener(this);
        d=new Button("Admin");
        d.setBounds(100,60,200,30);
        f.add(d);
        
    }

   public void actionPerformed(ActionEvent event) 
    {
    
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","ict-7"); //establishes a connection
           Statement stmt= con.createStatement();
           ResultSet rs =stmt.executeQuery("select * from login1");
           String firstname=t1.getText();
           String passowrd=t2.getText();
           while (rs.next()) 
           {
        	   if (event.getSource() == c) 
               {
               	new NewJFrame().setVisible(true);
               }
        		
        	   else  if((firstname.equals(rs.getString(1)))&&(passowrd.equals(rs.getString(3))))
               {
                   l3.setText("Welcome");
                 // new NewJFrame().setVisible(true);
                   new AdminPage();
                   break;
               }
               else
               {
                   l3.setText("Invalid Login");
                   continue;
               }
           }
           rs.close();

       }
       catch (Exception e)
       {
           System.out.println("Exception caught: "+e);
       }

    }
}

    