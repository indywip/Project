package ui;

import model.WeeklyClasses;
import model.EventLog;
import model.Event;
import persistence.JsonWriter;
import persistence.JsonReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// Student classes per week application UI
public class WeeklyClassesUI extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField field;
    private WeeklyClasses mySchedule;
    private JLabel header;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/schedule.json";

    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public WeeklyClassesUI() {
        super("Class Scheduling App");
        mySchedule = new WeeklyClasses("my schedule");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(0, 13, 13, 13));
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
        btn5.addActionListener(this);
        label = new JLabel("<html>" + mySchedule.mondayToString() + "<br><br/>" + mySchedule.tuesdayToString()
                + "<br><br/>" + mySchedule.wednesdayToString() + "<br><br/>" + mySchedule.thursdayToString()
                + "<br><br/>" + mySchedule.fridayToString() + "</html>");
        field = new JTextField(6);
        header = new JLabel(new ImageIcon("header.png"));
        add(header);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(label);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    // EFFECTS: prints formatted schedule in the application interface
    public void printSchedule() {
        label.setText("<html>" + mySchedule.mondayToString() + "<br><br/>" + mySchedule.tuesdayToString()
                + "<br><br/>" + mySchedule.wednesdayToString() + "<br><br/>" + mySchedule.thursdayToString()
                + "<br><br/>" + mySchedule.fridayToString() + "</html>");
    }

    // This is the method that is called when the JButton btn is clicked
    // EFFECTS: performs the user stories based on the btn pressed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add")) {
            addClass();
        } else if (e.getActionCommand().equals("Remove")) {
            removeClass();
        } else if (e.getActionCommand().equals("Save")) {
            saveMySchedule();
        } else if (e.getActionCommand().equals("Load")) {
            loadMySchedule();
        } else if (e.getActionCommand().equals("View")) {
            createUIComponents();
        }
    }

    // EFFECTS: adds class to schedule by inputting its name then selecting day from drop down
    public void addClass() {
        String[] optionsToChoose = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String getDay = (String) JOptionPane.showInputDialog(null, field, "Choose day of the week",
                JOptionPane.QUESTION_MESSAGE, new ImageIcon("tobstiny.jpg"), optionsToChoose, optionsToChoose[3]);
        if (getDay != null) {
            mySchedule.addClass(field.getText(), getDay);
        }
        printSchedule();
        EventLog.getInstance();
    }

    // REQUIRES: class must be in the schedule and the selected day
    // MODIFIES: this
    // EFFECTS: removes class from schedule by inputting its name then selecting day from drop down
    public void removeClass() {
        String[] optionsToChoose = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        String getDay = (String) JOptionPane.showInputDialog(
                null, field, "Choose day of the week", JOptionPane.QUESTION_MESSAGE,
                new ImageIcon("tobstiny.jpg"), optionsToChoose, optionsToChoose[3]);
        if (getDay != null) {
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
        }
        printSchedule();
        EventLog.getInstance();
    }

    // EFFECTS: saves schedule by writing it to file
    public void saveMySchedule() {
        jsonWriter = new JsonWriter(JSON_STORE);
        try {
            jsonWriter.open();
            jsonWriter.write(mySchedule);
            jsonWriter.close();
            JOptionPane.showMessageDialog(null, "Saved " + mySchedule.getName() + " to "
                    + JSON_STORE);
        } catch (FileNotFoundException f) {
            JOptionPane.showMessageDialog(null, "Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: loads schedule by reading it from file
    public void loadMySchedule() {
        jsonReader = new JsonReader(JSON_STORE);
        try {
            mySchedule = jsonReader.read();
            JOptionPane.showMessageDialog(null, "Loaded " + mySchedule.getName()
                    + " from " + JSON_STORE);
            printSchedule();
        } catch (IOException g) {
            JOptionPane.showMessageDialog(null, "Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: prints out schedule in new window
    private void createUIComponents() {
        JFrame frame = new JFrame();
        frame.setTitle("My Schedule");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setVisible(true);
        frame.add(label);
    }

    public static void printLog(EventLog el) {
        for (Event next : el) {
            System.out.println(next.toString() + "\n\n");
        }
    }


    // EFFECTS: creates a splash screen
    public static void splash() {
        JWindow window = new JWindow();
        window.getContentPane().add(
                new JLabel("", new ImageIcon("splash.png"), SwingConstants.CENTER));
        window.setBounds(285, 200, 800, 500);
        window.setVisible(true);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
    }

    private static class MyThread extends Thread {

        public void run() {
            printLog(EventLog.getInstance());
        }
    }


    // EFFECTS: starts the application
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(new MyThread());

        splash();
        new WeeklyClassesUI();
    }
}
