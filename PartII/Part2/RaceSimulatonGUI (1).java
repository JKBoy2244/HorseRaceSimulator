
    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.util.*;
    import java.util.List;

    class RaceSimulationGUI {
        private JFrame raceFrame;
        private JPanel racePanel;
        private ArrayList<JLabel> horseLabels;
        private javax.swing.Timer raceTimer;
        private  List<Horse> horses;
        private long startTime;
        private int trackLengthPixels = 700; 
        private String trackShape;

        public RaceSimulationGUI(List<Horse> horses) {
            this.horses = horses;
            horseLabels = new ArrayList<JLabel>();

            raceFrame = new JFrame("Horse Race Simulation");
            raceFrame.setSize(900, 400);
            raceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            raceFrame.setLayout(null);

            racePanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    for (int i = 1; i <= RaceSimulationGUI.this.horses.size(); i++) {
                        g.drawLine(0, i * 100, 900, i * 100);
                    }
                }
            };
            racePanel.setBounds(0, 0, 900, 300);
            racePanel.setLayout(null);
            raceFrame.add(racePanel);

            for (int i = 0; i < horses.size(); i++) {
                JLabel horseLabel = new JLabel(String.valueOf(horses.get(i).getSymbol()));
                horseLabel.setFont(new Font("Arial", Font.PLAIN, 36));
                horseLabel.setBounds(0, i * 100 + 30, 60, 60);
                horseLabels.add(horseLabel);
                racePanel.add(horseLabel);
            }

            JButton startButton = new JButton("Commence Race");
            startButton.setBounds(370, 310, 150, 30);
            raceFrame.add(startButton);

            startButton.addActionListener(e -> startRace());

            raceFrame.setVisible(true);
        }

        private void startRace() {
            startTime = System.currentTimeMillis();

            raceTimer = new javax.swing.Timer(100, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boolean raceOver = false;

                    for (int i = 0; i < horses.size(); i++) {
                        Horse horse = horses.get(i);
                        JLabel horseLabel = horseLabels.get(i);

                        if (!horse.hasFallen() && horse.getDistanceTravelled() * 10 < trackLengthPixels) {
                            if (Math.random() < horse.getConfidence()) {
                                horse.moveForward();
                            } else if (Math.random() > horse.getConfidence()) {
                                horse.fall();
                                horseLabel.setText("❌");
                            }
                        }

                        int pixelPosition = horse.getDistanceTravelled() * 10;
                        int horseX = pixelPosition; // Assuming horse's X coordinate is derived from distance
                        int horseY = horseLabel.getY();

                        if (trackShape.equalsIgnoreCase("oval")) {
                            horseY = (int)(100 * Math.sin(Math.toRadians(horseX / 5.0)));
                        } else if (trackShape.equalsIgnoreCase("figure-eight")) {
                            horseY = (int)(50 * Math.sin(Math.toRadians(horseX / 5.0))) +
                                     (int)(25 * Math.sin(Math.toRadians(2 * horseX / 5.0)));
                        } else if (trackShape.equalsIgnoreCase("zigzag")) {
                            horseY += (horseX % 40 < 20) ? 1 : -1;
                        }
                        horseLabel.setLocation(pixelPosition, horseY);

                        if (pixelPosition >= trackLengthPixels && !horse.hasFallen()) {
                            raceTimer.stop();
                            long elapsed = System.currentTimeMillis() - startTime;
                            double seconds = elapsed / 1000.0;
                            JOptionPane.showMessageDialog(null, "🏆 Winner: " + horse.getName() + " in " + seconds + " seconds!");
                            raceFrame.dispose();
                            return;
                        }
                    }

                    raceOver = horses.stream().allMatch(Horse::hasFallen);
                    if (raceOver) {
                        raceTimer.stop();
                        JOptionPane.showMessageDialog(null, "All horses have fallen! No winner!");
                        raceFrame.dispose();
                    }
                }
            });

            raceTimer.start();
        }
    }