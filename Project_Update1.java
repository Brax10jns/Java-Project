//Main.java

import javax.swing.*;
import java.awt.Graphics;
import java.io.File;

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
            hBox1.setBounds(414, 278, 162, 91);

            JTextField gBox1 = new JTextField();
            gBox1.setBounds(596, 278, 162, 91);

            JTextField hBox2 = new JTextField();
            hBox2.setBounds(414, 394, 162, 91);

            JTextField gBox2 = new JTextField();
            gBox2.setBounds(596, 394, 162, 91);

    

            background.setLayout(null);

            frame.setContentPane(background);

            frame.setSize(1920, 1080);
            frame.add(hBox1);
            frame.add(gBox1);
            frame.add(hBox2);
            frame.add(gBox2);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}