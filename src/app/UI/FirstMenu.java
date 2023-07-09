package app.UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class FirstMenu extends JFrame {

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
        }
    };
    JPanel headerLabel = new JPanel();
    RoundedButton startButton = new RoundedButton("       From?", new Color(0xf6f6f6), Color.black, 20);
    RoundedButton destinationButton = new RoundedButton("           To?", new Color(0xf6f6f6), Color.black, 18);
    RoundedButton dateButton = new RoundedButton("         Select Your date", new Color(0xf6f6f6), Color.black, 18);
    RoundedButton flightTypeButton = new RoundedButton("Select Your flight type", new Color(0xf6f6f6), Color.black, 18);
    JLabel error = new JLabel("");


    public FirstMenu() {
        this.setTitle("Nizek Air");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false); // Disable resizing
        this.setSize(400, 700); // Adjusted dimensions for a mobile-sized frame
        this.setLocationRelativeTo(null); // Center the frame on the screen
        this.setVisible(true);
        this.setBackground(new Color(0x508bd0));
        this.setLayout(null);


        ImageIcon placeHolder = new ImageIcon("assets/Placeholder.png");// PLace Holder
        ImageIcon startPlane = new ImageIcon("assets/startPlane.png");
        ImageIcon landingPlane = new ImageIcon("assets/landingPlane.png");
        ImageIcon dateIcon = new ImageIcon("assets/dateIcon.png");
        Image imageDate = dateIcon.getImage(); // transform it
        Image newimgDate = imageDate.getScaledInstance(49, 49, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        dateIcon = new ImageIcon(newimgDate);

        ImageIcon flightTypeIcon = new ImageIcon("assets/flightTypeIcon.png");
        Image imageFlightType = flightTypeIcon.getImage(); // transform it
        Image newimgFlightType = imageFlightType.getScaledInstance(49, 49, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        flightTypeIcon = new ImageIcon(newimgFlightType);

        ImageIcon pfpIcon = new ImageIcon("assets/Pfp.png");
        Image imagePfp = pfpIcon.getImage(); // transform it
        Image newimgPfp = imagePfp.getScaledInstance(49, 49, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        pfpIcon = new ImageIcon(newimgPfp);

        ImageIcon headerIcon = new ImageIcon("assets/worldMap.png");
        Image imageHeader = headerIcon.getImage(); // transform it
        Image newimgHeader = imageHeader.getScaledInstance(this.getWidth(), (this.getHeight() / 10) * 2, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        headerIcon = new ImageIcon(newimgHeader);


        Image image = placeHolder.getImage(); // transform it
        Image newimg = image.getScaledInstance(49, 49, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        placeHolder = new ImageIcon(newimg);


        headerLabel.setBounds(0, 0, this.getWidth(), (this.getHeight() / 10) * 2);
        headerLabel.setBackground(new Color(0x508bd0));
        headerLabel.setForeground(Color.white);
        headerLabel.setLayout(null);


        // setup Pfp
        JLabel pfpLabel = new JLabel(pfpIcon);
        pfpLabel.setBounds(30, 25, 50, 50);
        headerLabel.add(pfpLabel);
        // welcome msg
        JLabel welcome = new JLabel("Hello 'the user'");//TODO : add user name
        welcome.setBounds(80, 30, 75, 20);
        welcome.setForeground(Color.white);
        welcome.setFont(new Font("Arial", Font.PLAIN, 11));
        headerLabel.add(welcome);

        // Header text
        JLabel headerText = new JLabel("Where are you going?");
        headerText.setBounds(80, 45, 250, 30);
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Arial", Font.BOLD, 21));
        headerLabel.add(headerText);

        //Header backGround Image
        JLabel headerImage = new JLabel(headerIcon);
        headerImage.setBounds(0, 0, this.getWidth(), (this.getHeight() / 10) * 2);
        headerLabel.add(headerImage);

        mainPanel.setLayout(null);
        mainPanel.setBounds(0, (this.getHeight() / 10) * 2 - 40, this.getWidth(), this.getHeight() - ((this.getHeight() / 10) * 2 - 40));
        // Start Picture
        JLabel startLabel = new JLabel(startPlane);
        startLabel.setBounds(40, 79, 50, 50);
        mainPanel.add(startLabel);
        // Start Menu
        startButton.setBounds(40, 80, 305, 50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setText("");
                captureAndSaveImage();
                FirstMenu.this.add(new CitySelectMenu(FirstMenu.this, startButton));
                FirstMenu.this.mainPanel.setVisible(false);
                FirstMenu.this.headerLabel.setVisible(false);
            }
        });
        mainPanel.add(startButton);

        // Destination Picture
        JLabel destinationLabel = new JLabel(landingPlane);
        destinationLabel.setBounds(40, 129, 50, 50);
        mainPanel.add(destinationLabel);
        //Destination Menu
        destinationButton.setBounds(40, 130, 305, 50);

        destinationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setText("");
                captureAndSaveImage();
                FirstMenu.this.add(new CitySelectMenu(FirstMenu.this, destinationButton, startButton.getText()));
                FirstMenu.this.mainPanel.setVisible(false);
                FirstMenu.this.headerLabel.setVisible(false);
            }
        });
        mainPanel.add(destinationButton);

        // Date Picture
        JLabel dateLabel = new JLabel(dateIcon);
        dateLabel.setBounds(40, 229, 50, 50);
        mainPanel.add(dateLabel);
        //Date Menu
        dateButton.setBounds(40, 230, 305, 50);
        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setText("");
                captureAndSaveImage();
                FirstMenu.this.add(new DateSelectMenu(FirstMenu.this, dateButton));
                FirstMenu.this.mainPanel.setVisible(false);
                FirstMenu.this.headerLabel.setVisible(false);
            }
        });
        mainPanel.add(dateButton);


        // Flight Type Picture
        JLabel flightTypeLabel = new JLabel(flightTypeIcon);
        flightTypeLabel.setBounds(40, 319, 50, 50);
        mainPanel.add(flightTypeLabel);
        //Flight Type Menu
        flightTypeButton.setBounds(40, 320, 305, 50);
        flightTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                error.setText("");
                captureAndSaveImage();
                FirstMenu.this.add(new FlightTypeSelectMenu(FirstMenu.this, flightTypeButton));
                FirstMenu.this.mainPanel.setVisible(false);
                FirstMenu.this.headerLabel.setVisible(false);
            }
        });
        mainPanel.add(flightTypeButton);


        error.setForeground(Color.red);
        error.setBounds(40, 460, 305, 50);
        error.setFont(new Font("Arial", Font.PLAIN, 14));
        mainPanel.add(error);


        RoundedButton submitButton = new RoundedButton("Submit", new Color(0x192032), Color.white, 18);
        submitButton.setBounds(40, 400, 305, 50);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!startButton.getText().equals("       From?") &&!destinationButton.getText().equals("           To?")
                &&!dateButton.getText().equals("         Select Your date")&&!flightTypeButton.getText().equals("Select Your flight type")) {
                    error.setText("");
                    FirstMenu.this.add(new SubmittedMenu(FirstMenu.this));
                    FirstMenu.this.mainPanel.setVisible(false);
                    FirstMenu.this.headerLabel.setVisible(false);

                }else error.setText("*all Fields must be completed");
            }
        });
        mainPanel.add(submitButton);
        this.add(mainPanel);
        this.add(headerLabel);

    }

    public static BufferedImage blur(BufferedImage img, int range, int angle) {
        BufferedImage b = new BufferedImage(img.getWidth() * 2, img.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = b.createGraphics();

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {

                //horizontal

                int[] red = new int[range * 2], green = new int[range * 2], blue = new int[range * 2];
                int[] pixels = new int[range * 2];

                for (int i = 0; i < pixels.length; i++) {
                    pixels[i] = img.getRGB(clamp(x - clamp(range / 2, 0, range) + i, 0, img.getWidth() - 1), clamp(y - clamp(range / 2, 0, range) + (int) (i * Math.toRadians(angle)), 0, img.getHeight() - 1));

                    red[i] = (pixels[i] >> 16) & 0xff;
                    green[i] = (pixels[i] >> 8) & 0xff;
                    blue[i] = (pixels[i]) & 0xff;
                }

                int red_t = 0, green_t = 0, blue_t = 0;

                for (int i = 0; i < pixels.length; i++) {
                    red_t += red[i];
                    green_t += green[i];
                    blue_t += blue[i];
                }

                int r = red_t / (range * 2);
                int gr = green_t / (range * 2);
                int bl = blue_t / (range * 2);

                g.setColor(new Color(r, gr, bl));
                g.fillRect(x, y, 1, 1);

            }
        }
        g.dispose();

        return b;
    }

    private static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FirstMenu();
            }
        });
    }

    private void captureAndSaveImage() {
        try {
            Robot robot = new Robot();
            BufferedImage image = robot.createScreenCapture(getBounds());
            BufferedImage imageBlur = cropImage(blur(image, 5, 0), 0, 30);
            ImageIO.write(imageBlur, "png", new File("assets/blurBack.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private BufferedImage cropImage(BufferedImage src, int x, int y) {
        BufferedImage dest = src.getSubimage(x, y, src.getWidth(), src.getHeight() - y);
        return dest;
    }

}
