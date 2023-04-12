// GUI and main program for the Training Record updated by shermina on 12.24
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    
    private JTextField Repetitions = new JTextField(4);
    private JTextField Recovery = new JTextField(4);
    private JTextField terrain = new JTextField(4);
    private JTextField tempo = new JTextField(4);
    private JTextField where = new JTextField(4);
    
    
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    
    
    private JLabel labRepet = new JLabel(" Repetitions:");
    private JLabel labRecov = new JLabel(" Recovery:");
    private JLabel labter = new JLabel(" Terrain:");
    private JLabel labtemp = new JLabel(" Tempo:");
    private JLabel labwhr = new JLabel(" where:");
   
    
    private JLabel labdist = new JLabel(" Distance (km):");
   
    private JButton addR = new JButton("Add");
    private JButton addC = new JButton("AddC");
    private JButton addS = new JButton("AddS");

    
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton FindAllByDate = new JButton("Find All ByDate");
    private JButton RemoveEntry = new JButton("Remove");
    
    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        
        add(labRepet);
        add(Repetitions);
        Repetitions.setEditable(true);
        add(labRecov);
        add(Recovery);
        Recovery.setEditable(true);
        add(labter);
        add(terrain);
        terrain.setEditable(true);
        add(labtemp);
        add(tempo);
        tempo.setEditable(true);
        add(labwhr);
        add(where);
        where.setEditable(true);
        
        
        
        add(addR);
        addR.addActionListener(this);
        add(addC);
        addC.addActionListener(this);
        add(addS);
        addS.addActionListener(this);
        
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(FindAllByDate);
        FindAllByDate.addActionListener(this);
        add(RemoveEntry);
        RemoveEntry.addActionListener(this);
        
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntryR("generic");
        }
        if (event.getSource() == addC) {
            message = addEntryC("generic");
        }
        if (event.getSource() == addS) {
            message = addEntryS("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == FindAllByDate) {
            message = lookupAll();
        }
        if (event.getSource() == RemoveEntry) {
            message = RemoveEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntryR(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        int Repet = Integer.parseInt(Repetitions.getText());
        int Recov = Integer.parseInt(Recovery.getText());
        Entry e = new SprintEntry(n, d, m, y, h, mm, s, km, Repet, Recov);
        myAthletes.addEntry(e);
        return message; 
    }
    
    public String addEntryC(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String ter = terrain.getText();
        String temp = tempo.getText();
        Entry e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, temp);
        myAthletes.addEntry(e);
        return message;
    }
    
    public String addEntryS(String what) {
    	Entry e;
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
       
    	String ter = terrain.getText();
        String temp = tempo.getText();
        int Repet = Integer.parseInt(Repetitions.getText());
        int Recov = Integer.parseInt(Recovery.getText());
    	String whr = where.getText();
   
    if (!whr.isEmpty())
    	e = new SwimEntry(n, d, m, y, h, mm, s, km, whr); 
    else if (!temp.isEmpty() && !ter.isEmpty())
    	e = new CycleEntry(n, d, m, y, h, mm, s, km, ter, temp);
    else if (!Repetitions.getText().isEmpty() && !Recovery.getText().isEmpty() )
        e = new SwimEntry(n, d, m, y, h, mm, s, km, whr);
    else 
      e = new Entry (n, d, m, y, h, mm, s, km);
      myAthletes.addEntry(e);
     
      return message;
    		
}
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }

    public String lookupAll() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupAll(d, m, y);
        return message;
    }
    
    public String RemoveEntry() {
    	String n= name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.removeRecord( n ,d, m, y);
        return message;
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

