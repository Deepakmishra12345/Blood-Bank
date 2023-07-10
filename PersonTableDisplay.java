package com.company.blood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonTableDisplay extends JFrame implements ActionListener
{


    Final fp;
    Container c;
    JTable jt;
    JScrollPane sp;
    JButton b1;
    PersonTableDisplay(Final f)
    {
        c=getContentPane();
        fp=f;
        String column[]={"fname","lname","address","password","subject","gender","branch"};
        String data[][]=new String[100][7];

        b1=new JButton("BACK");

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();//this statement loads the driver for the databse
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","Omkar@123");
            //here nitesh is database name, root is username and  password is empty String
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from person");

            int i=0;
            while(rs.next()==true)

            {
                //System.out.println("Hello");

                data[i][0]=rs.getString(1);
                data[i][1]=rs.getString(2);
                data[i][2]=rs.getString(3);
                data[i][3]=rs.getString(4);
                data[i][4]=rs.getString(5);
                data[i][5]=rs.getString(6);
                data[i][6]=rs.getString(7);

                    /*System.out.println(data[i][0]);
					System.out.println(data[i][1]);
					System.out.println(data[i][2]);
					System.out.println(data[i][3]);
					System.out.println(data[i][4]);
					System.out.println(data[i][5]);
					System.out.println(data[i][6]);

					*/
                if(rs.getString(5).equals("D"))
                    data[i][4]="DOCTOR";
                else if(rs.getString(5).equals("S"))
                    data[i][4]="STAFF MEMBER";
                else if(rs.getString(5).equals("P"))
                    data[i][4]="PATIENT";
              /*  switch(sub)
                {
                    case "" :  data[i][4]="";
                        break;
                    case "m":  data[i][4]="DOCTOR";
                        break;
                    case "j":  data[i][4]="STAFF MEMBER";
                        break;
                    case "d":  data[i][4]="PATIENT";
                        break;
                }*/
                if(rs.getString(6).equals("M"))
                    data[i][5]="Male";
                else if(rs.getString(6).equals("F"))
                    data[i][5]="Female";
                else if(rs.getString(6).equals("O"))
                    data[i][5]="Others";
                //cbranch.setSelectedItem(rs.getString(7));

                i++;
            }
            jt=new JTable(data,column);
            sp=new JScrollPane(jt);
            c.add(sp,BorderLayout.CENTER);
            c.add(b1,BorderLayout.SOUTH);
            b1.addActionListener(this);
            this.setSize(1360,850);
            this.setVisible(true);
            setTitle("Person Display");
            con.close();

        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("BACK"))
        {
            this.setVisible(false);
            fp.setVisible(true);
        }
    }
}
