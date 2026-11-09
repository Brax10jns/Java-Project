//Main.java

import javax.swing.*;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.io.File;
import java.time.format.TextStyle;

class Project_Update1 {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            File imageFile = new File("GPA Calculator Template.png");
            ImageIcon backgroundImage =
                    new ImageIcon(imageFile.getAbsolutePath());

            if (backgroundImage.getIconWidth() <= 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Could not load the image:\n"
                                + imageFile.getAbsolutePath(),
                        "Image Error",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
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
            hBox1.setBounds(414, 295, 162, 91);

            JTextField gBox1 = new JTextField();
            gBox1.setBounds(596, 295, 162, 91);

            JTextField hBox2 = new JTextField();
            hBox2.setBounds(414, 406, 162, 91);

            JTextField gBox2 = new JTextField();
            gBox2.setBounds(596, 406, 162, 91);

            JTextField hBox3 = new JTextField();
            hBox3.setBounds(414, 518, 162, 91);

            JTextField gBox3 = new JTextField();
            gBox3.setBounds(596, 518, 162, 91);

            JTextField hBox4 = new JTextField();
            hBox4.setBounds(414, 630, 162, 91);

            JTextField gBox4 = new JTextField();
            gBox4.setBounds(596, 630, 162, 91);

            JTextField hBox5 = new JTextField();
            hBox5.setBounds(414, 742, 162, 91);

            JTextField gBox5 = new JTextField();
            gBox5.setBounds(596, 742, 162, 91);

            JTextField hBox6 = new JTextField();
            hBox6.setBounds(798, 295, 162, 91);

            JTextField gBox6 = new JTextField();
            gBox6.setBounds(980, 295, 162, 91);

            JTextField hBox7 = new JTextField();
            hBox7.setBounds(798, 406, 162, 91);

            JTextField gBox7 = new JTextField();
            gBox7.setBounds(980, 406, 162, 91);

            JTextField hBox8 = new JTextField();
            hBox8.setBounds(798, 518, 162, 91);

            JTextField gBox8 = new JTextField();
            gBox8.setBounds(980, 518, 162, 91);
            
            JTextField hBox9 = new JTextField();
            hBox9.setBounds(798, 630, 162, 91);

            JTextField gBox9 = new JTextField();
            gBox9.setBounds(980, 630, 162, 91);

            JTextField hBox10 = new JTextField();
            hBox10.setBounds(798, 742, 162, 91);

            JTextField gBox10 = new JTextField();
            gBox10.setBounds(980, 742, 162, 91);

            JTextField gpaBox = new JTextField();
            gpaBox.setBounds(1185, 184, 238, 166);

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
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}