package app.UI;

import app.FlightType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class FlightTypeSelectMenu extends JPanel {
    ImageIcon image = new ImageIcon("assets/blurBack.png");

    public FlightTypeSelectMenu(FirstMenu firstMenu, JButton button) {
        this.setLayout(null);
        this.setBounds(0, 0, firstMenu.getWidth(), firstMenu.getHeight());
        this.setVisible(true);


        Image image1 = image.getImage(); // transform it
        Image image2 = image1.getScaledInstance(firstMenu.getWidth()*2, firstMenu.getHeight() - 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(image2);
        ArrayList<String> flightTypeNames = new ArrayList<>();
        for (FlightType flightType : FlightType.values()) {
            flightTypeNames.add(flightType.getName());
        }
        for (int i = 0; i < flightTypeNames.size(); i++) {
            RoundedButton flightType = new RoundedButton(flightTypeNames.get(i), new Color(0xf6f6f6), Color.black, 20);
            flightType.setBounds(40, firstMenu.headerLabel.getHeight() + (50 * i), 305, 50);
            flightType.setHorizontalAlignment(SwingConstants.CENTER);
            flightType.setVerticalAlignment(SwingConstants.CENTER);
            int theFlightType = i;
            flightType.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        button.setText(flightTypeNames.get(theFlightType));
                        button.setFont(new Font("Arial", Font.PLAIN, 20));
                    FlightTypeSelectMenu.this.setVisible(false);
                    firstMenu.mainPanel.setVisible(true);
                    firstMenu.headerLabel.setVisible(true);
                }
            });
            this.add(flightType);
        }

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 0, 0, null);
    }
}
