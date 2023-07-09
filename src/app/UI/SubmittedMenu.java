package app.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SubmittedMenu extends JPanel {
    JPanel mainPanel = new JPanel() {
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

            // Draw arrow line
            int arrowX = 80; // X coordinate of the arrow
            int arrowY = 140; // Y coordinate of the arrow
            int arrowWidth = 140; // Width of the arrow
            Graphics2D g3 = (Graphics2D) g.create();
            // Adjust the starting position of the arrow based on the rounded corners
            int cornerRadius = 30; // Radius of the rounded corners
            arrowX += cornerRadius; // Add the radius to the X coordinate

            g3.setColor(new Color(0xE0E0E0));
            g3.setStroke(new BasicStroke(1)); // Set the thickness of the line

            // Draw a straight line
            g3.drawLine(arrowX, arrowY, arrowX + arrowWidth, arrowY);

            // Draw arrowhead
            int[] xPoints = {arrowX + arrowWidth - 10, arrowX + arrowWidth, arrowX + arrowWidth - 10};
            int[] yPoints = {arrowY - 5, arrowY, arrowY + 5};
            g3.fillPolygon(xPoints, yPoints, 3);

            g3.dispose();
        }
    };

    JPanel headerLabel = new JPanel();
    Random random = new Random();
    String randomLetter = String.valueOf((char) (random.nextInt(26) + 'A'));
    int randomNumber = random.nextInt(10);


    public SubmittedMenu(FirstMenu firstMenu) {

        String randomFlightCode = String.valueOf((char) (random.nextInt(26) + 'A')) + (char) (random.nextInt(26) + 'A')
                + "-" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
        String randomGate = String.valueOf((char) (random.nextInt(26) + 'A')) + random.nextInt(10);
        String randomTerminal = String.valueOf(random.nextInt(10)) + random.nextInt(10);
        String randomSeatNumber = String.valueOf((char) (random.nextInt(26) + 'A')) + random.nextInt(10);

        this.setLayout(null);
        this.setBounds(0, 0, firstMenu.getWidth(), firstMenu.getHeight());
        this.setVisible(true);

        ImageIcon headerIcon = new ImageIcon("assets/airPlaneLogo.png");
        Image imageHeader = headerIcon.getImage(); // transform it
        Image newimgHeader = imageHeader.getScaledInstance((this.getWidth() / 10) * 8, (this.getHeight() / 10) * 2, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        headerIcon = new ImageIcon(newimgHeader);

        Image imageMain = headerIcon.getImage(); // transform it
        Image newimgMain = imageMain.getScaledInstance(70, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ImageIcon mainLogo = new ImageIcon(newimgMain);

        ImageIcon planeIcon = new ImageIcon("assets/airPlane.jpg");
        Image imagePlane = planeIcon.getImage(); // transform it
        Image newimgPlane = imagePlane.getScaledInstance(70, 40, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        planeIcon = new ImageIcon(newimgPlane);

        ImageIcon qrIcon = new ImageIcon("assets/your flight ticket.png");
        Image imageQr = qrIcon.getImage(); // transform it
        Image newimgQr = imageQr.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        qrIcon = new ImageIcon(newimgQr);


        mainPanel.setBounds((this.getWidth() / 20), (this.getHeight() / 20) * 3, (this.getWidth() / 10) * 9, (this.getHeight() / 20) * 13);
        mainPanel.setBackground(Color.white);
        mainPanel.setForeground(Color.BLACK);
        mainPanel.setLayout(null);
        //top Logo
        JLabel logoImage = new JLabel(mainLogo);
        logoImage.setBounds(this.getWidth() / 2 - ((this.getWidth() / 20) * 3) + 5, 30, 70, 40);
        mainPanel.add(logoImage);

        JLabel logoName = new JLabel("Nizek air");
        logoName.setBounds(this.getWidth() / 2 - ((this.getWidth() / 20) * 3) + 10, 60, 70, 40);
        logoName.setFont(new Font("Arial", Font.PLAIN, 15));
        mainPanel.add(logoName);


        JLabel from = new JLabel("From");
        from.setBounds(30, 105, 70, 40);
        from.setFont(new Font("Arial", Font.PLAIN, 10));
        from.setForeground(new Color(0xB2B0B0));
        mainPanel.add(from);

        JLabel fromCity = new JLabel(firstMenu.startButton.getText());
        fromCity.setBounds(30, 120, 70, 40);
        fromCity.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(fromCity);


        JLabel flightDate = new JLabel(firstMenu.dateButton.getText());
        flightDate.setBounds(this.getWidth() / 2 - ((this.getWidth() / 20) * 3) + 5, 90, 90, 40);
        flightDate.setFont(new Font("Arial", Font.PLAIN, 10));
        mainPanel.add(flightDate);

        JLabel planeImage = new JLabel(planeIcon);
        planeImage.setBounds(this.getWidth() / 2 - ((this.getWidth() / 20) * 3) + 5, 120, 70, 40);
        mainPanel.add(planeImage);

        JLabel flightTime = new JLabel("14h55m");
        flightTime.setBounds(this.getWidth() / 2 - ((this.getWidth() / 20) * 3) + 15, 150, 70, 40);
        flightTime.setFont(new Font("Arial", Font.PLAIN, 12));
        mainPanel.add(flightTime);


        JLabel to = new JLabel("To");
        to.setBounds(270, 105, 70, 40);
        to.setFont(new Font("Arial", Font.PLAIN, 10));
        to.setForeground(new Color(0xB2B0B0));
        mainPanel.add(to);

        JLabel toCity = new JLabel(firstMenu.destinationButton.getText());
        toCity.setBounds(270, 120, 70, 40);
        toCity.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(toCity);


        JLabel name = new JLabel("Passenger Name");
        name.setBounds(30, 180, 90, 40);
        name.setFont(new Font("Arial", Font.PLAIN, 10));
        name.setForeground(new Color(0xB2B0B0));
        mainPanel.add(name);

        JLabel passenger = new JLabel("the user");//TODO : add user name
        passenger.setBounds(30, 195, 100, 40);
        passenger.setFont(new Font("Arial", Font.BOLD, 15));
        mainPanel.add(passenger);


        JLabel flightTypeHeader = new JLabel("Flight Type");
        flightTypeHeader.setBounds(160, 180, 90, 40);
        flightTypeHeader.setFont(new Font("Arial", Font.PLAIN, 10));
        flightTypeHeader.setForeground(new Color(0xB2B0B0));
        mainPanel.add(flightTypeHeader);

        JLabel flightType = new JLabel(firstMenu.flightTypeButton.getText());
        flightType.setBounds(160, 195, 100, 40);
        flightType.setFont(new Font("Arial", Font.BOLD, 13));
        mainPanel.add(flightType);


        JLabel flightCodeHeader = new JLabel("Flight Code");
        flightCodeHeader.setBounds(270, 180, 90, 40);
        flightCodeHeader.setFont(new Font("Arial", Font.PLAIN, 10));
        flightCodeHeader.setForeground(new Color(0xB2B0B0));
        mainPanel.add(flightCodeHeader);

        JLabel flightCode = new JLabel(randomFlightCode);
        flightCode.setBounds(270, 195, 100, 40);
        flightCode.setFont(new Font("Arial", Font.BOLD, 13));
        mainPanel.add(flightCode);


        JLabel boardingDateHeader = new JLabel("Boarding Date");
        boardingDateHeader.setBounds(30, 255, 90, 40);
        boardingDateHeader.setFont(new Font("Arial", Font.PLAIN, 10));
        boardingDateHeader.setForeground(new Color(0xB2B0B0));
        mainPanel.add(boardingDateHeader);

        JLabel boardingDate = new JLabel(firstMenu.dateButton.getText());
        boardingDate.setBounds(30, 270, 100, 40);
        boardingDate.setFont(new Font("Arial", Font.BOLD, 10));
        mainPanel.add(boardingDate);


        JLabel gateHeader = new JLabel("Gate");
        gateHeader.setBounds(130, 255, 40, 40);
        gateHeader.setFont(new Font("Arial", Font.PLAIN, 10));
        gateHeader.setForeground(new Color(0xB2B0B0));
        mainPanel.add(gateHeader);

        JLabel gate = new JLabel(randomGate);
        gate.setBounds(130, 270, 60, 40);
        gate.setFont(new Font("Arial", Font.BOLD, 13));
        mainPanel.add(gate);

        JLabel terminalHeader = new JLabel("Terminal");
        terminalHeader.setBounds(190, 255, 60, 40);
        terminalHeader.setFont(new Font("Arial", Font.PLAIN, 10));
        terminalHeader.setForeground(new Color(0xB2B0B0));
        mainPanel.add(terminalHeader);

        JLabel terminal = new JLabel(randomTerminal);
        terminal.setBounds(190, 270, 40, 40);
        terminal.setFont(new Font("Arial", Font.BOLD, 13));
        mainPanel.add(terminal);


        JLabel seatNumberHeader = new JLabel("Seat Number");
        seatNumberHeader.setBounds(270, 255, 90, 40);
        seatNumberHeader.setFont(new Font("Arial", Font.PLAIN, 10));
        seatNumberHeader.setForeground(new Color(0xB2B0B0));
        mainPanel.add(seatNumberHeader);

        JLabel seatNumber = new JLabel(randomSeatNumber);
        seatNumber.setBounds(270, 270, 100, 40);
        seatNumber.setFont(new Font("Arial", Font.BOLD, 13));
        mainPanel.add(seatNumber);


        JLabel theQrCode = new JLabel(qrIcon);
        theQrCode.setBounds(130, 340, 110, 110);
        mainPanel.add(theQrCode);


        this.add(mainPanel);


        headerLabel.setBounds(0, 0, this.getWidth(), (this.getHeight() / 10) * 2);
        headerLabel.setBackground(new Color(0x00ef40));
        headerLabel.setLayout(null);

        //header Setup
        JLabel headerImage = new JLabel(headerIcon);
        headerImage.setBounds(0, 0, this.getWidth(), (this.getHeight() / 10) * 2);
        headerLabel.add(headerImage);
        this.add(headerLabel);

        RoundedButton submitButton = new RoundedButton("Print the Ticket", new Color(0x192032), Color.white, 18);
        submitButton.setBounds((this.getWidth() / 20), (this.getHeight() / 20) * 16 + 20, (this.getWidth() / 10) * 9, (this.getHeight() / 10));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage theTicket = capturePanel(mainPanel);
                saveImage(theTicket, "The ticket.png");
            }
        });
        this.add(submitButton);

    }

    public static BufferedImage capturePanel(JPanel panel) {
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        panel.paint(image.getGraphics());
        return image;
    }

    public static void saveImage(BufferedImage image, String imagePath) {
        try {
            ImageIO.write(image, "png", new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
