package ui;

import ui.WeeklyClassesApp;
import model.WeeklyClasses;
import model.MyClass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class WeeklyClassesUI extends JFrame implements ActionListener {
    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField field;
    private WeeklyClasses mySchedule;
    private JLabel header;

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public WeeklyClassesUI() {
        super("Class Scheduling App");
        mySchedule = new WeeklyClasses("My schedule");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 400));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        JButton btn1 = new JButton("Add a class");
        JButton btn2 = new JButton("Remove a class");
        JButton btn3 = new JButton("View my schedule");
        JButton btn4 = new JButton("Save my schedule");
        JButton btn5 = new JButton("Load my schedule");
        btn1.setActionCommand("Add");
        btn2.setActionCommand("Remove");
        btn3.setActionCommand("View");
        btn4.setActionCommand("Save");
        btn5.setActionCommand("Load");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this); // Sets "this" object as an action listener for btn
        // so that when the btn is clicked,
        // this.actionPerformed(ActionEvent e) will be called.
        // You could also set a different object, if you wanted
        // a different object to respond to the button click
        label = new JLabel("Monday \n Tuesday \n Wednesday \n Thursday \n Friday");
        //label2 = new JLabel("Tuesday");
        //label3 = new JLabel("Wednesday");
        //label4 = new JLabel("Thursday");
        //label5 = new JLabel("Friday");
        field = new JTextField(6);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(label);
        //add(label2);
        //add(label3);
        //add(label4);
        //add(label5);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    //This is the method that is called when the JButton btn is clicked
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public void actionPerformed(ActionEvent e) {
        createUIComponents();
        String[] optionsToChoose = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        if (e.getActionCommand().equals("Add")) {

            String getDay = (String) JOptionPane.showInputDialog(
                    null, field,
                    "Choose day of the week",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    optionsToChoose[3]);
            mySchedule.addClass(field.getText(), getDay);
            //label.setText("Monday: " + field.getText());
            label.setText(mySchedule.toString());
        } else if (e.getActionCommand().equals("Remove")) {
            String getDay = (String) JOptionPane.showInputDialog(
                    null, field,
                    "Choose day of the week",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionsToChoose,
                    optionsToChoose[3]);
            if (getDay.equals("Monday")) {
                mySchedule.removeClassMonday(field.getText());
            } else if (getDay.equals("Tuesday")) {
                mySchedule.removeClassTuesday(field.getText());
            } else if (getDay.equals("Wednesday")) {
                mySchedule.removeClassWednesday(field.getText());
            } else if (getDay.equals("Thursday")) {
                mySchedule.removeClassThursday(field.getText());
            } else {
                mySchedule.removeClassFriday(field.getText());
            }
            //label.setText("Monday: " + field.getText());
            label.setText(mySchedule.toString());
        } //else if (e.getActionCommand().equals("View")) {
        //  mySchedule.toString();
        // } else if (e.getActionCommand().equals("Save")) {
        //
        // }
    }

    private void createUIComponents() {
        header = new JLabel(new ImageIcon("header.png"));
        header.setHorizontalTextPosition(JLabel.CENTER);
        header.setVerticalTextPosition(SwingConstants.TOP);


        JFrame frame = new JFrame();
        frame.setTitle("Tobs");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(900, 400);
        frame.setVisible(true);
        frame.add(header);
    }

    // starts the application
    public static void main(String[] args) {
        // try {
        new WeeklyClassesUI();
        // } catch (FileNotFoundException e) {
        //   System.out.println("Unable to run application: file not found");
        //}
    }
}
