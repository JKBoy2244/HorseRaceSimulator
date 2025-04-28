
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class RaceGUI {

    private static int lanes; 
    private static String shape;
    private static Random random = new Random();
    private static List<Horse> horses = new ArrayList<Horse>();
    private static String weather;
    private static String horseBreed;
    private static int length;
    
    public static void main(String[] args) {
        final JFrame frame = new JFrame("Horse Race Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(20000, 17000); 
        frame.setLayout(null);

        final JLabel label1 = new JLabel("Enter the number of lanes (1-3):");
        label1.setBounds(10, 10, 300, 25);
        frame.add(label1);

        final JTextField input1 = new JTextField();
        input1.setBounds(10, 40, 165, 25);
        frame.add(input1);

        final JButton button1 = new JButton("Proceed");
        button1.setBounds(10, 70, 100, 25);
        frame.add(button1);

        final JLabel label2 = new JLabel("Enter the track length (10-50 meters):");
        label2.setBounds(10, 110, 300, 25);
        label2.setVisible(false);
        frame.add(label2);

        final JTextField input2 = new JTextField();
        input2.setBounds(10, 140, 165, 25);
        input2.setVisible(false);
        frame.add(input2);

        final JButton button2 = new JButton("Proceed");
        button2.setBounds(10, 170, 100, 25);
        button2.setVisible(false);
        frame.add(button2);

        final JLabel label3 = new JLabel("Choose the track shape (oval, figure-eight, zigzag):");
        label3.setBounds(10, 210, 400, 25);
        label3.setVisible(false);
        frame.add(label3);

        final JTextField input3 = new JTextField();
        input3.setBounds(10, 240, 165, 25);
        input3.setVisible(false);
        frame.add(input3);

        final JButton button3 = new JButton("Proceed");
        button3.setBounds(10, 270, 100, 25);
        button3.setVisible(false);
        frame.add(button3);

        final JLabel label4 = new JLabel("Choose a suitable weather(foggy, raining, sunny, windy):");
        label4.setBounds(10, 310, 400, 25);
        label4.setVisible(false);
        frame.add(label4);

        final JTextField input4 = new JTextField();
        input4.setBounds(10, 340, 165, 25);
        input4.setVisible(false);
        frame.add(input4);

        final JButton button4 = new JButton("Proceed");
        button4.setBounds(10, 370, 100, 25);
        button4.setVisible(false);
        frame.add(button4);

        final JLabel label5 = new JLabel("Choose a horse breed (Thorough bred, Arabian, Quarter Horse):");
        label5.setBounds(10, 410, 300, 25);
        label5.setVisible(false);
        frame.add(label5);

        final JTextField input5 = new JTextField();
        input5.setBounds(10, 440, 165, 25);
        input5.setVisible(false);
        frame.add(input5);

        final JButton button5 = new JButton("Proceed");
        button5.setBounds(10, 470, 100, 25);
        button5.setVisible(false);
        frame.add(button5);

        final JLabel label6 = new JLabel("Choose a coat colour for the horse(Red, Orange, Yellow, Green, Blue, Purple, Black, White):");
        label6.setBounds(10, 510, 300, 25);
        label6.setVisible(false);
        frame.add(label6);

        final JTextField input6 = new JTextField();
        input6.setBounds(10, 540, 165, 25);
        input6.setVisible(false);
        frame.add(input6);

        final JButton button6 = new JButton("Proceed");
        button6.setBounds(10, 570, 100, 25);
        button6.setVisible(false);
        frame.add(button6);

        final JLabel label7 = new JLabel("Choose a symbol to represent(🦄, 🐎, 🐴):");
        label7.setBounds(10, 610, 400, 25);
        label7.setVisible(false);
        frame.add(label7);

        final JTextField input7 = new JTextField();
        input7.setBounds(10, 640, 165, 25);
        input7.setVisible(false);
        frame.add(input7);

        final JButton button7 = new JButton("Proceed");
        button7.setBounds(10, 670, 100, 25);
        button7.setVisible(false);
        frame.add(button7);

        final JLabel label8 = new JLabel("Choose a horshoe status(lightweight, regular or heavyweight):");
        label8.setBounds(10, 710, 400, 25);
        label8.setVisible(false);
        frame.add(label8);

        final JTextField input8 = new JTextField();
        input8.setBounds(10, 740, 165, 25);
        input8.setVisible(false);
        frame.add(input8);

        final JButton button8 = new JButton("Proceed");
        button8.setBounds(10, 770, 100, 25);
        button8.setVisible(false);
        frame.add(button8);

        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    lanes = Integer.parseInt(input1.getText());
                    if (lanes >= 1 && lanes <= 3) {
                        JOptionPane.showMessageDialog(frame, "Valid number of lanes.");
                        label2.setVisible(true);
                        input2.setVisible(true);
                        button2.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Number of lanes must be between 1 and 3.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(input2.getText());
                    if (length >= 10 && length <= 50) {
                        JOptionPane.showMessageDialog(frame, "Valid track length.");
                        label3.setVisible(true);
                        input3.setVisible(true);
                        button3.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Track length must be between 10 and 50 meters.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number.");
                }
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String shape = input3.getText().toLowerCase();
                if (shape.equals("oval") || shape.equals("figure-eight") || shape.equals("figure eight") || shape.equals("zigzag") || shape.equals("zig-zag")) {
                    JOptionPane.showMessageDialog(frame, "Valid track shape selected: " + shape);

                    label4.setVisible(true);
                    input4.setVisible(true);
                    button4.setVisible(true);
 
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid track shape. Please enter oval, figure-eight, or zigzag.");
                    return;
                }
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String weather = input4.getText().toLowerCase();
                if (weather.equals("foggy") || weather.equals("raining") || weather.equals("windy") || weather.equals("sunny")) {
                    JOptionPane.showMessageDialog(frame, "Valid weather selected: " + weather);
                    

                    label5.setVisible(true);
                    input5.setVisible(true);
                    button5.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid weather input. Please enter only foggy, raining, sunny, windy.");
                    return;
                }
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String horseBreed = input5.getText();
                if (horseBreed.equals("Thoroughbred") || horseBreed.equals("Arabian") || horseBreed.equals("Quarter Horse")) {
                    JOptionPane.showMessageDialog(frame, "Valid horse breed selected: " + horseBreed);

                    label6.setVisible(true);
                    input6.setVisible(true);
                    button6.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid horse breed. Please enter Thoroughbred, Arabian, or Quarter Horse.");
                    return;
                }
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String horseColor = input6.getText();
                if (horseColor.equals("Red") || horseColor.equals("Orange") || horseColor.equals("Yellow") || horseColor.equals("Green") || horseColor.equals("Blue") || horseColor.equals("Purple") || horseColor.equals("Black") || horseColor.equals("White")) {
                    JOptionPane.showMessageDialog(frame, "Valid colour selected: " + horseColor);

                    label7.setVisible(true);
                    input7.setVisible(true);
                    button7.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid colour option. Please enter Red, Orange, Yellow, Green, Blue, Purple, Black, White.");
                    return;
                }
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String symbol = input7.getText();
                if (symbol.equals("🦄") || symbol.equals("🐎") || symbol.equals("🐴") || symbol.equals("god")) {
                    JOptionPane.showMessageDialog(frame, "Valid horse symbol selected: " + symbol);

                    label8.setVisible(true);
                    input8.setVisible(true);
                    button8.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid symbol. Please choose (🦄, 🐎, 🐴).");
                    return;
                }
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String horseShoeStatus = input8.getText();
                
                if (horseShoeStatus.equals("regular") || horseShoeStatus.equals("lightweight") || horseShoeStatus.equals("heavyweight")) {
                    JOptionPane.showMessageDialog(frame, "Valid horse Shoe status selected: " + horseShoeStatus);

                    for (int i = 1; i <= lanes; i++) {
                        char symbol = (char) ('A' + i - 1);
                        String name = "Horse" + i;
                        double confidence = 0.8 + (random.nextDouble() * 0.2);
                        Horse horse = new Horse(symbol, name, confidence);
                        horses.add(horse);
                    }

                    for (Horse horse : horses) {

                        if (weather.equals("foggy")) {
                            horse.setConfidence(horse.getConfidence() - 0.1);
                        } else if (weather.equals("windy")) {
                            horse.setConfidence(horse.getConfidence() + 0.2);
                        } else if (weather.equals("raining")) {
                            horse.setConfidence(horse.getConfidence() - 0.05);
                        } else if (weather.equals("sunny")) {
                            horse.setConfidence(horse.getConfidence() + 0.15);
                        }

                        if (shape.equals("oval")) {
                            horse.setConfidence(horse.getConfidence() + 0.05);
                        } else if (shape.equals("figure-eight")) {
                            horse.setConfidence(horse.getConfidence() - 0.1);
                        } else if (shape.equals("zigzag")) {
                            horse.setConfidence(horse.getConfidence() - 0.1);
                        }

                        if (horseShoeStatus.equals("lightweight")) {
                            horse.setConfidence(horse.getConfidence() + 0.2);
                        } else if (horseShoeStatus.equals("regular")) {
                            horse.setConfidence(horse.getConfidence() + 0.05);
                        } else if (horseShoeStatus.equals("heavyweight")) {
                            horse.setConfidence(horse.getConfidence() - 0.3);
                        } 

                    if (horseBreed.equals("Thoroughbred")) {
                        horse.setConfidence(horse.getConfidence() + 0.05);
                    } else if (horseBreed.equals("Arabian")) {
                            horse.setConfidence(horse.getConfidence() + 0.05);
                        }  else if (horseBreed.equals("Quarter Horse")) {
                        horse.setConfidence(horse.getConfidence() + 0.05);
                    }  
                 } 
                    
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid horse Shoe status. Please select lightweight, regular or heavyweight.");
                    return;
                }
            }
        });     
        
      }
 }
