import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 * Paint Class to paint on canvas
 * <p>
 * Purdue University -- CS18000 -- Fall 2023 -- Homework12 -- Paint
 *
 * @author Annalise Wang Purdue CS
 * @version November 10, 2023
 */


public class Paint extends JComponent implements Runnable {
    Random random = new Random();

    Image image; // the canvas
    Graphics2D graphics2D;  // this will enable drawing
    int curX; // current mouse x coordinate
    int curY; // current mouse y coordinate
    int oldX; // previous mouse x coordinate
    int oldY; // previous mouse y coordinate

    JButton clrButton; // clear button
    JButton fillButton; // fill button

    JButton eraseButton;

    JButton randomButton;

    JButton hexButton;

    JButton rgbButton;

    JTextField hexText;

    JTextField rText;

    JTextField gText;

    JTextField bText;

    Color backgroundColor = Color.white;


    Paint paint; // variable of the type Paint

    protected void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);

            // this lets us draw on the image (ie. the canvas)
            graphics2D = (Graphics2D) image.getGraphics();

            // gives us better rendering quality for the drawing lines
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            graphics2D.setStroke(new BasicStroke(5));

            // set canvas to white with default paint color
            graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, getSize().width, getSize().height);
            graphics2D.setPaint(Color.black);

            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }


    public Paint() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // set oldX and oldY coordinates to beginning mouse press
                oldX = e.getX();
                oldY = e.getY();
            }
        });


        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // set current coordinates to where mouse is being dragged
                curX = e.getX();
                curY = e.getY();

                // draw the line between old coordinates and new ones
                graphics2D.drawLine(oldX, oldY, curX, curY);

                // refresh frame and reset old coordinates
                repaint();
                oldX = curX;
                oldY = curY;

            }
        });
    }

    public void draw(int size) {
        graphics2D.setStroke(new BasicStroke(size));
    }

    public void clrButtonMethod() {
        graphics2D.setPaint(Color.white);
        backgroundColor = Color.white;
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void fillButtonMethod() {
        Color currentColor = (Color) graphics2D.getPaint();
        backgroundColor = currentColor;
        graphics2D.setPaint(currentColor);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        repaint();
        graphics2D.setPaint(Color.black);
        // should the background be set to the new background
    }

    public void eraseButtonMethod() {
        graphics2D.setPaint(backgroundColor);

    }

    public void randomButtonMethod(Color color) {
        graphics2D.setPaint(color);
    }

    public void hexButtonMethod(Color color) {
        graphics2D.setPaint(color);
    }

    public void rgbButtonMethod(Color color) {
        graphics2D.setPaint(color);
    }


    ActionListener actionListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == clrButton) { // clearing Button
                paint.clrButtonMethod();
                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");

            }
            if (e.getSource() == fillButton) {
                paint.fillButtonMethod();
                hexText.setText("#");
                rText.setText("");
                gText.setText("");
                bText.setText("");

            }
            if (e.getSource() == eraseButton) {
                paint.eraseButtonMethod();

            }
            if (e.getSource() == randomButton) {
                int r = random.nextInt(251);
                int g = random.nextInt(251);
                int b = random.nextInt(251);
                hexText.setText(String.format("#%02x%02x%02x", r, g, b));
                Color rgbColor = new Color(r, g, b);
                paint.randomButtonMethod(rgbColor);
                String red = String.valueOf(rgbColor.getRed());
                String blue = String.valueOf(rgbColor.getBlue());
                String green = String.valueOf(rgbColor.getGreen());
                rText.setText(red);
                gText.setText(green);
                bText.setText(blue);
            }
            if (e.getSource() == hexButton) {
                try {
                    Color hexColor = Color.decode(String.valueOf(hexText.getText()));
                    paint.hexButtonMethod(hexColor);
                    String red = String.valueOf(hexColor.getRed());
                    String blue = String.valueOf(hexColor.getBlue());
                    String green = String.valueOf(hexColor.getGreen());
                    rText.setText(red);
                    bText.setText(blue);
                    gText.setText(green);
                } catch (NumberFormatException f) {
                    JOptionPane.showMessageDialog(null, "Not a valid Hex Value",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (e.getSource() == rgbButton) {
                if (rText.getText().isEmpty()) {
                    rText.setText(String.valueOf(0));
                }
                if (gText.getText().isEmpty()) {
                    gText.setText(String.valueOf(0));
                }
                if (bText.getText().isEmpty()) {
                    bText.setText(String.valueOf(0));
                }
                try {
                    int r = Integer.parseInt(rText.getText());
                    int b = Integer.parseInt(bText.getText());
                    int g = Integer.parseInt(gText.getText());
                    Color rgbColor = new Color(r, g, b);
                    hexText.setText(String.format("#%02x%02x%02x", r, g, b));
                    paint.rgbButtonMethod(rgbColor);

                    rText.setText(String.valueOf(r));
                    bText.setText(String.valueOf(b));
                    gText.setText(String.valueOf(g));
                } catch (IllegalArgumentException f) {
                    JOptionPane.showMessageDialog(null, "Not a valid RGB Value",
                            "Error", JOptionPane.ERROR_MESSAGE);

                }
            }
            if (e.getSource() == rText) {
                if (rText.getText().isEmpty()) {
                    rText.setText(String.valueOf(0));
                }
            }
            if (e.getSource() == gText) {
                if (gText.getText().isEmpty()) {
                    gText.setText(String.valueOf(0));
                }
            }
            if (e.getSource() == bText) {
                if (bText.getText().isEmpty()) {
                    bText.setText(String.valueOf(0));
                }
            }
        }
    };


    public void run() {
        JFrame frame = new JFrame();
        frame.setTitle("Paint Challenge");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        paint = new Paint();
        content.add(paint, BorderLayout.CENTER);
        content.add(paint);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        hexText = new JTextField("#", 10);
        hexText.addActionListener(actionListener);
        bottomPanel.add(hexText);

        hexButton = new JButton("Hex Color");
        hexButton.addActionListener(actionListener);
        bottomPanel.add(hexButton);

        rText = new JTextField("", 5);
        rText.addActionListener(actionListener);
        bottomPanel.add(rText);

        gText = new JTextField("", 5);
        gText.addActionListener(actionListener);
        bottomPanel.add(gText);

        bText = new JTextField("", 5);
        bText.addActionListener(actionListener);
        bottomPanel.add(bText);

        rgbButton = new JButton("RGB");
        rgbButton.addActionListener(actionListener);
        bottomPanel.add(rgbButton);

        content.add(bottomPanel, BorderLayout.SOUTH);

        clrButton = new JButton("Clear");
        clrButton.addActionListener(actionListener);
        topPanel.add(clrButton);

        fillButton = new JButton("Fill");
        fillButton.addActionListener(actionListener);
        topPanel.add(fillButton);

        eraseButton = new JButton("Erase");
        eraseButton.addActionListener(actionListener);
        topPanel.add(eraseButton);

        randomButton = new JButton("Random Color");
        randomButton.addActionListener(actionListener);
        topPanel.add(randomButton);

        content.add(topPanel, BorderLayout.NORTH);


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Paint());


    }
}
