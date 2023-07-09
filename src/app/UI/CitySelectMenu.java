package app.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class CitySelectMenu extends JPanel {
    ImageIcon image = new ImageIcon("assets/blurBack.png");
    ArrayList<String> defualtCitys = new ArrayList<>(Arrays.asList("New York", "London", "Tokyo", "Paris", "Valoran"));


    public CitySelectMenu(FirstMenu firstMenu, RoundedButton button) {
        //for start button
        this.setLayout(null);
        this.setBounds(0, 0, firstMenu.getWidth(), firstMenu.getHeight());
        this.setVisible(true);


        Image image1 = image.getImage(); // transform it
        Image image2 = image1.getScaledInstance(firstMenu.getWidth()*2, firstMenu.getHeight() - 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(image2);

        ArrayList<String> citys = new ArrayList<>(defualtCitys);
        for (int i = 0; i < citys.size(); i++) {
            RoundedButton city = new RoundedButton(citys.get(i), new Color(0xf6f6f6), Color.black, 20);
            city.setBounds(40, firstMenu.headerLabel.getHeight() + (50 * i), 305, 50);
            city.setHorizontalAlignment(SwingConstants.CENTER);
            city.setVerticalAlignment(SwingConstants.CENTER);
            int theCity = i;
            city.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!firstMenu.destinationButton.getText().equals(citys.get(theCity))) {
                        button.setText(citys.get(theCity));
                        button.setFont(new Font("Arial", Font.PLAIN, 20));
                    }
                    CitySelectMenu.this.setVisible(false);
                    firstMenu.mainPanel.setVisible(true);
                    firstMenu.headerLabel.setVisible(true);
                }
            });
            this.add(city);
        }

    }
    public CitySelectMenu(FirstMenu firstMenu, RoundedButton button,String firstButton) {
//for destination button
        this.setLayout(null);
        this.setBounds(0, 0, firstMenu.getWidth(), firstMenu.getHeight());
        this.setVisible(true);


        Image image1 = image.getImage(); // transform it
        Image image2 = image1.getScaledInstance(firstMenu.getWidth()*2, firstMenu.getHeight() - 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(image2);

        ArrayList<String> citys = new ArrayList<>(defualtCitys);
        citys.remove(firstButton);
        for (int i = 0; i < citys.size(); i++) {
            RoundedButton city = new RoundedButton(citys.get(i), new Color(0xf6f6f6), Color.black, 20);
            city.setBounds(40, firstMenu.headerLabel.getHeight() + (50 * i), 305, 50);
            city.setHorizontalAlignment(SwingConstants.CENTER);
            city.setVerticalAlignment(SwingConstants.CENTER);
            int theCity = i;
            city.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!firstMenu.startButton.getText().equals(citys.get(theCity))) {
                        button.setText(citys.get(theCity));
                        button.setFont(new Font("Arial", Font.PLAIN, 20));
                    }
                    CitySelectMenu.this.setVisible(false);
                    firstMenu.mainPanel.setVisible(true);
                    firstMenu.headerLabel.setVisible(true);
                }
            });
            this.add(city);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 0, 0, null);
    }
}