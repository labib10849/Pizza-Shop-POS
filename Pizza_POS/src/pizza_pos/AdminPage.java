package pizza_pos;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminPage implements ActionListener 
{
    Button b,c,d,e;
    
    AdminPage()
    {
    	  Frame f=new Frame("Admin Panel");
    	  f.setSize(400,400);
          f.setLayout(null);
        
          f.setVisible(true);
          f.setBackground(Color.ORANGE);
          
          b=new Button("Update_Pizza_Price");
          b.setBounds(100,110,200,35);
          f.add(b);
          b.addActionListener(this);
          c=new Button("Add_New_Catagory_Pizza");
          c.setBounds(100,200,200,30);
          f.add(c);
          c.addActionListener(this);
          d=new Button("Delete_Old_Catagory_Pizza");
          d.setBounds(100,300,200,40);
          f.add(d);
          e=new Button("View_Customer_Request");
          e.setBounds(100,40,200,30);
          f.add(e);
          
      }

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
    }