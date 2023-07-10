package com.company.blood;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 91963
 */
public class Final extends JFrame implements ActionListener
{

    JButton bRegister,bDisplay,bUpdate,bSearch,bDonor,bRec;

    Container ca;
    JLabel c;
    Final()
    {
        ca=getContentPane();
        c=new JLabel(new ImageIcon("D:\\okc\\my new files\\src\\com\\company\\blood\\1.PNG"));
        c.setBounds(0, 0, 1360, 850);
        ca.add(c);
        bRegister=new JButton("LOGIN");
        bDisplay=new JButton("DISPLAY");
        bUpdate= new JButton("SEARCH");
        bSearch= new JButton("UPDATE");
        bDonor= new JButton("DONOR");
        bRec= new JButton("RECEIVER");

        this.setLayout(null);
        this.setSize(1360, 850);

        bRegister.setBounds(1160, 25, 100, 30);
        bDisplay.setBounds(1040, 25, 100, 30);
        bSearch.setBounds(920, 25, 100, 30);
        bUpdate.setBounds(800, 25, 100, 30);
        bDonor.setBounds(800, 500, 100, 50);
        bRec.setBounds(1000, 500, 100, 50);

        c.add(bRegister);
        c.add(bDisplay);
        c.add(bUpdate);
        c.add(bSearch);
        c.add(bDonor);
        c.add(bRec);

        bRegister.addActionListener(this);
        bDisplay.addActionListener(this);
        bUpdate.addActionListener(this);
        bSearch.addActionListener(this);
        bDonor.addActionListener(this);
        bRec.addActionListener(this);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e )
    {
        if(e.getActionCommand().equals("LOGIN"))
        {
            this.setVisible(false);
            PersonLogin1 s=new PersonLogin1(this);
        }
        else if(e.getActionCommand().equals("DISPLAY"))
        {
            this.setVisible(false);
            PersonTableDisplay s=new PersonTableDisplay(this);
        }
        else if(e.getActionCommand().equals("SEARCH"))
        {
            this.setVisible(false);
            PersonSearch1 s=new PersonSearch1(this);
        }
        else if(e.getActionCommand().equals("UPDATE"))
        {
            this.setVisible(false);
            PersonUpdate s=new PersonUpdate(this);
        }
        else if(e.getActionCommand().equals("DONOR"))
        {
            this.setVisible(false);
            PersonDonor s=new PersonDonor(this);
        }
        else if(e.getActionCommand().equals("RECEIVER"))
        {
            this.setVisible(false);
            PersonReceiver s=new PersonReceiver( this);
        }
    }
    public static void main (String args[])

    {
        Final f=new Final();
        f.setTitle("Free Blood Donation");
    }
}





