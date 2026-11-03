import javax.swing.*;
import java.awt.Graphics;
import java.io.File;

class Main {
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

            background.setLayout(null);

            frame.setContentPane(background);

            frame.setSize(1920, 1080);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}