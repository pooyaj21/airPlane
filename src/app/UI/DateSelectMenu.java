package app.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class DateSelectMenu extends JPanel {
    ImageIcon image = new ImageIcon("assets/blurBack.png");
    int day=1;
    int month=0;
    String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };
    int year=2023;
    JLabel dayLabel = new JLabel(String.valueOf(day));
    JLabel monthLabel = new JLabel(months[month]);
    JLabel yearLabel = new JLabel(String.valueOf(year));
    JPanel datePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int width = getWidth();
            int height = getHeight();
            Shape shape = new RoundRectangle2D.Double(0, 0, width, height, 30, 30);
            g2.setColor(Color.white);
            g2.fill(shape);
            g2.setColor(Color.BLACK);
            g2.dispose();
        }
    };

    public DateSelectMenu(FirstMenu firstMenu, JButton button) {
        this.setLayout(null);
        this.setBounds(0, 0, firstMenu.getWidth(), firstMenu.getHeight());
        this.setVisible(true);
        datePanel.setVisible(true);

        Image image1 = image.getImage(); // transform it
        Image image2 = image1.getScaledInstance(firstMenu.getWidth()*2, firstMenu.getHeight() - 30, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        image = new ImageIcon(image2);

        datePanel.setBounds(0, (firstMenu.getHeight() / 10) * 7, firstMenu.getWidth(), (firstMenu.getHeight() / 10) * 3);
        datePanel.setLayout(null);
        // day top button
        RoundedButton topDay = new RoundedButton("⬆", new Color(0xf6f6f6), Color.black, 21);
        topDay.setBounds(0, 10, (firstMenu.getWidth() / 3)-8, (datePanel.getHeight() / 3) - 28);
        topDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (day<31) day++;
                else day=1;
                dayLabel.setText(String.valueOf(day));

            }
        });
        datePanel.add(topDay);
        //day label text
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dayLabel.setVerticalAlignment(SwingConstants.CENTER);
        dayLabel.setBounds(0,  (datePanel.getHeight() / 3)- 14, (firstMenu.getWidth() / 3)-8, (datePanel.getHeight() / 3) - 28);
        datePanel.add(dayLabel);
        // day bot button
        RoundedButton botDay = new RoundedButton("⬇", new Color(0xf6f6f6), Color.black, 21);
        botDay.setBounds(0,  (datePanel.getHeight() / 3)*2- 42, (firstMenu.getWidth() / 3)-8 , (datePanel.getHeight() / 3) - 28);
        botDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (day>1) day--;
                else day=31;
                dayLabel.setText(String.valueOf(day));
            }
        });
        datePanel.add(botDay);

        // month top button
        RoundedButton topMonth = new RoundedButton("⬆", new Color(0xf6f6f6), Color.black, 21);
        topMonth.setBounds((firstMenu.getWidth() / 3)+4, 10, (firstMenu.getWidth() / 3)-8, (datePanel.getHeight() / 3) - 28);
        topMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (month<11) month++;
                else month=0;
                monthLabel.setText(months[month]);

            }
        });
        datePanel.add(topMonth);
        //month label text
        monthLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        monthLabel.setVerticalAlignment(SwingConstants.CENTER);
        monthLabel.setBounds((firstMenu.getWidth() / 3)+4,  (datePanel.getHeight() / 3)- 14, (firstMenu.getWidth() / 3)-8, (datePanel.getHeight() / 3) - 28);
        datePanel.add(monthLabel);
        // month bot button
        RoundedButton botMonth = new RoundedButton("⬇", new Color(0xf6f6f6), Color.black, 21);
        botMonth.setBounds((firstMenu.getWidth() / 3)+4,  (datePanel.getHeight() / 3)*2- 42, (firstMenu.getWidth() / 3)-8 , (datePanel.getHeight() / 3) - 28);
        botMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (month>0) month--;
                else month =11;
                monthLabel.setText(months[month]);
            }
        });
        datePanel.add(botMonth);

        // year top button
        RoundedButton topYear = new RoundedButton("⬆", new Color(0xf6f6f6), Color.black, 21);
        topYear.setBounds((firstMenu.getWidth() / 3)*2, 10, (firstMenu.getWidth() / 3)-8, (datePanel.getHeight() / 3) - 28);
        topYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                year++;
                yearLabel.setText(String.valueOf(year));

            }
        });
        datePanel.add(topYear);
        //year label text
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yearLabel.setVerticalAlignment(SwingConstants.CENTER);
        yearLabel.setBounds((firstMenu.getWidth() / 3)*2,  (datePanel.getHeight() / 3)- 14, (firstMenu.getWidth() / 3)-8, (datePanel.getHeight() / 3) - 28);
        datePanel.add(yearLabel);
        // year bot button
        RoundedButton botYear = new RoundedButton("⬇", new Color(0xf6f6f6), Color.black, 21);
        botYear.setBounds((firstMenu.getWidth() / 3)*2,  (datePanel.getHeight() / 3)*2- 42, (firstMenu.getWidth() / 3)-8 , (datePanel.getHeight() / 3) - 28);
        botYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (year>2023) year--;
                yearLabel.setText(String.valueOf(year));
            }
        });
        datePanel.add(botYear);

        //submit button
        RoundedButton submitButton = new RoundedButton("Submit", new Color(0x192032), Color.white, 21);
        submitButton.setBounds((firstMenu.getWidth() / 3)+4,  (datePanel.getHeight() / 3)*2, (firstMenu.getWidth() / 3)-8 , (datePanel.getHeight() / 3) - 28);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    button.setText(dayLabel.getText()+monthLabel.getText()+yearLabel.getText());
                    button.setFont(new Font("Arial", Font.PLAIN, 20));
                DateSelectMenu.this.setVisible(false);
                datePanel.setVisible(false);
                firstMenu.mainPanel.setVisible(true);
                firstMenu.headerLabel.setVisible(true);
            }
        });
        datePanel.add(submitButton);

        firstMenu.add(datePanel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image.getImage(), 0, 0, null);
    }
}
