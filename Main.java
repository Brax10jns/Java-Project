//Main.java

import javax.swing.*;
import java.awt.Graphics;
import java.io.File;
import java.awt.Font;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            // Look for the image in the working directory first,
            // then next to the compiled class file.
            File imageFile = new File("GPA Calculator Template.png");
            if (!imageFile.exists()) {
                try {
                    File classDir = new File(Main.class.getProtectionDomain()
                            .getCodeSource().getLocation().toURI());
                    if (classDir.isFile()) classDir = classDir.getParentFile();
                    imageFile = new File(classDir, "GPA Calculator Template.png");
                } catch (Exception ignored) { }
            }
            ImageIcon backgroundImage =
                    new ImageIcon(imageFile.getAbsolutePath());

            if (backgroundImage.getIconWidth() <= 0) {
                // Warn, but keep running so the calculator still works
                JOptionPane.showMessageDialog(
                        null,
                        "Could not load the image:\n"
                                + imageFile.getAbsolutePath()
                                + "\n\nThe calculator will open without the background.",
                        "Image Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }

            JFrame frame = new JFrame("College GPA Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel background = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);

                    g.drawImage(
                            backgroundImage.getImage(),
                            0, 0,
                            getWidth(), getHeight(),
                            this
                    );
                }
            };

            JTextField hBox1 = new JTextField();
            hBox1.setBounds(414, 295, 172, 101);

            JTextField gBox1 = new JTextField();
            gBox1.setBounds(596, 295, 172, 101);

            JTextField hBox2 = new JTextField();
            hBox2.setBounds(414, 406, 172, 101);

            JTextField gBox2 = new JTextField();
            gBox2.setBounds(596, 406, 172, 101);

            JTextField hBox3 = new JTextField();
            hBox3.setBounds(414, 518, 172, 101);

            JTextField gBox3 = new JTextField();
            gBox3.setBounds(596, 518, 172, 101);

            JTextField hBox4 = new JTextField();
            hBox4.setBounds(414, 630, 172, 101);

            JTextField gBox4 = new JTextField();
            gBox4.setBounds(596, 630, 172, 101);

            JTextField hBox5 = new JTextField();
            hBox5.setBounds(414, 742, 172, 101);

            JTextField gBox5 = new JTextField();
            gBox5.setBounds(596, 742, 172, 101);

            JTextField hBox6 = new JTextField();
            hBox6.setBounds(798, 295, 172, 101);

            JTextField gBox6 = new JTextField();
            gBox6.setBounds(980, 295, 172, 101);

            JTextField hBox7 = new JTextField();
            hBox7.setBounds(798, 406, 172, 101);

            JTextField gBox7 = new JTextField();
            gBox7.setBounds(980, 406, 172, 101);

            JTextField hBox8 = new JTextField();
            hBox8.setBounds(798, 518, 172, 101);

            JTextField gBox8 = new JTextField();
            gBox8.setBounds(980, 518, 172, 101);

            JTextField hBox9 = new JTextField();
            hBox9.setBounds(798, 630, 172, 101);

            JTextField gBox9 = new JTextField();
            gBox9.setBounds(980, 630, 172, 101);

            JTextField hBox10 = new JTextField();
            hBox10.setBounds(798, 742, 172, 101);

            JTextField gBox10 = new JTextField();
            gBox10.setBounds(980, 742, 172, 101);

            JTextField gpaBox = new JTextField();
            gpaBox.setBounds(1185, 184, 238, 166);
            gpaBox.setEditable(false); // output only, the user shouldn't type here

            // ---------- connect the GUI to GpaCalculator ----------

            // Put the boxes in arrays so we can loop over them.
            // hourBoxes[i] and gradeBoxes[i] are the same course (row).
            JTextField[] hourBoxes = {hBox1, hBox2, hBox3, hBox4, hBox5,
                                      hBox6, hBox7, hBox8, hBox9, hBox10};
            JTextField[] gradeBoxes = {gBox1, gBox2, gBox3, gBox4, gBox5,
                                       gBox6, gBox7, gBox8, gBox9, gBox10};

            GpaCalculator calculator = new GpaCalculator();
            
            Font boxFont = new Font("Times New Roman", Font.PLAIN, 44);
            for (int i = 0; i < hourBoxes.length; i++) {
                hourBoxes[i].setFont(boxFont);
                gradeBoxes[i].setFont(boxFont);


                hourBoxes[i].setHorizontalAlignment(JTextField.CENTER);
                gradeBoxes[i].setHorizontalAlignment(JTextField.CENTER);
            } 

            gpaBox.setFont(new Font("Times New Roman", Font.BOLD, 60));
            gpaBox.setHorizontalAlignment(JTextField.CENTER);
           
            JButton calcButton = new JButton("Calculate GPA");
            calcButton.setBounds(1185, 370, 238, 60);
            calcButton.setFont(new Font("Arial", Font.BOLD, 25));


            calcButton.addActionListener(e -> {
                calculator.reset(); // start fresh each time the button is clicked
                int coursesEntered = 0;

                for (int i = 0; i < hourBoxes.length; i++) {
                    String hoursText = hourBoxes[i].getText().trim();
                    String gradeText = gradeBoxes[i].getText().trim();

  
                    if (hoursText.isEmpty() && gradeText.isEmpty()) {
                        continue;
                    }

                    try {
                        int hours = Integer.parseInt(hoursText);
                        calculator.addCourse(hours, gradeText);
                        coursesEntered++;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Course " + (i + 1) + ": credit hours must be a whole number.",
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Course " + (i + 1) + ": " + ex.getMessage(),
                                "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                if (coursesEntered == 0) {
                    JOptionPane.showMessageDialog(frame,
                            "Enter at least one course.",
                            "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                gpaBox.setText(String.format("%.2f", calculator.getGpa()));
            });


            background.setLayout(null);

            frame.setContentPane(background);

            frame.setSize(1920, 1080);
            frame.add(hBox1);
            frame.add(gBox1);
            frame.add(hBox2);
            frame.add(gBox2);
            frame.add(hBox3);
            frame.add(gBox3);
            frame.add(hBox4);
            frame.add(gBox4);
            frame.add(hBox5);
            frame.add(gBox5);
            frame.add(hBox6);
            frame.add(gBox6);
            frame.add(hBox7);
            frame.add(gBox7);
            frame.add(hBox8);
            frame.add(gBox8);
            frame.add(hBox9);
            frame.add(gBox9);
            frame.add(hBox10);
            frame.add(gBox10);
            frame.add(gpaBox);
            frame.add(calcButton); // NEW
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

/**
 * Handles all of the GPA math. It has no Scanner and no println,
 * so the GUI (or any other class) can use it.
 */
class GpaCalculator {

    private double totalQualityPoints = 0; // sum of (grade points * credit hours)
    private int totalCreditHours = 0;

    /** Converts a letter grade to grade points. Returns -1 if the grade isn't recognized. */
    public static double gradeToPoints(String grade) {
        grade = grade.trim().toUpperCase();

        if (grade.equals("A")) {
            return 4.0;
        } else if (grade.equals("B")) {
            return 3.0;
        } else if (grade.equals("C")) {
            return 2.0;
        } else if (grade.equals("D")) {
            return 1.0;
        } else if (grade.equals("F")) {
            return 0.0;
        } else {
            return -1;
        }
    }

    /** Adds one course to the running totals. */
    public void addCourse(int creditHours, String grade) {
        double points = gradeToPoints(grade);
        if (points < 0) {
            throw new IllegalArgumentException("Invalid letter grade: " + grade);
        }
        if (creditHours <= 0) {
            throw new IllegalArgumentException("Credit hours must be greater than 0.");
        }
        totalQualityPoints += points * creditHours;
        totalCreditHours += creditHours;
    }

    /** Returns the credit-weighted GPA, or 0 if no courses were added. */
    public double getGpa() {
        if (totalCreditHours == 0) {
            return 0;
        }
        return totalQualityPoints / totalCreditHours;
    }

    /** Clears everything so the calculator can be reused. */
    public void reset() {
        totalQualityPoints = 0;
        totalCreditHours = 0;
    }
}
