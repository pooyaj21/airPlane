package app.UI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WelcomeMenu extends JPanel {
    ImageIcon image = new ImageIcon("assets/airPlaneLogo.png");
    RoundedTextField nameTextField = new RoundedTextField(20,60,Color.GRAY,Color.white,20){
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (getText().isEmpty() && !hasFocus()) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.white);
                g2.drawString("Enter your Name", getInsets().left, g.getFontMetrics().getAscent() + getInsets().top*4);
            }
        }
    };


    public WelcomeMenu(FirstMenu firstMenu) {
        this.setLayout(null);
        this.setBounds(0, 0, firstMenu.getWidth(), firstMenu.getHeight());
        this.setVisible(true);
        this.setBackground(Color.BLACK);
        Image image1 = image.getImage(); // transform it
        Image image2 = image1.getScaledInstance(firstMenu.getWidth(),image.getIconHeight(), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(image2);

        RoundedButton submitButton = new RoundedButton("➡",60,Color.BLACK,Color.GRAY,21);
        submitButton.setBounds(firstMenu.getWidth()-60,firstMenu.getHeight()/2+30,40,40);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WelcomeMenu.this.setVisible(false);
                firstMenu.theUserName = nameTextField.getText();
                firstMenu.welcome.setText("Hello "+nameTextField.getText());
                firstMenu.headerLabel.setVisible(true);
                firstMenu.mainPanel.setVisible(true);
            }
        });
        this.add(submitButton);


        nameTextField.setBounds(10,firstMenu.getHeight()/2+20,firstMenu.getWidth()-20,60);
        nameTextField.setEnabled(false);
        nameTextField.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                nameTextField.setEnabled(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });;

        this.add(nameTextField);


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 0, this.getHeight()/2-image.getIconHeight(), null);
    }
}
