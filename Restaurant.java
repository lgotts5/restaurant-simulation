import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Write a description of class Restaurant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restaurant extends JFrame
{
    private Map<Table,String> tables;
    //private Queue<String> orders;
    private static final int numTables = 6;
    private int xPosWaiter = 150;
    private int yPosWaiter = 150;
    private Image waiter;
    private Image scaledimage;
    private Image table0;
    private Image scaledimage0;
    private Table zero;
    private Image table1;
    private Image scaledimage1;
    private Table one;
    private Image table2;
    private Image scaledimage2;
    private Table two;
    private Image table3;
    private Image scaledimage3;
    private Table three;
    private Image table4;
    private Image scaledimage4;
    private Table four;
    private Image table5;
    private Image scaledimage5;
    private Table five;
    private Image bubble;
    private Image bubbleScaled;
    private Image Pizza;
    //private int yPizza;
    private Image Spaghetti;
    private Image Chicken;
    private Image Caprese;
    private Image Meatballs;
    private Image Rigatoni;
    private Image Cake;
    private boolean drawVoice;
    private JButton[] tableButtons;
    private int[] xPOS = {200,300,500,700, 800,900};
    private int[] yPOS = {110,550,300,500,100, 370};
    private JPanel drawingPanel;
    private static final int EPSILON = 50;
    private static final ArrayList<String> food = new ArrayList<String>();
    private JButton menu;
    private boolean drawMenu;
    private boolean showFood;
    //private static int buttonPressed;
    private int yFood = -50;
    private String zeroDish; 
    private String oneDish ;
    private String twoDish ;
    private String threeDish ;
    private String fourDish;
    private String fiveDish;
    private Timer timer;
    public Restaurant()  {
        tables = new HashMap<Table, String>();
        food.add("Cheese Pizza");
        food.add("Spaghetti Bolognese");
        food.add("Chicken parmesan");
        food.add("Caprese Salad");
        food.add("Meatballs");
        food.add("Rigatoni Vodka");
        food.add("Chocolate cake");
        zeroDish = food.get((int)(Math.random() * food.size()));
        food.remove(zeroDish);
        oneDish = food.get((int)(Math.random() * food.size()));
        food.remove(oneDish);
        twoDish = food.get((int)(Math.random() * food.size()));
        food.remove(twoDish);
        threeDish = food.get((int)(Math.random() * food.size()));
        food.remove(threeDish);
        fourDish = food.get((int)(Math.random() * food.size()));
        food.remove(fourDish);
        fiveDish = food.get((int)(Math.random() * food.size()));
        //orders = new LinkedList<String>();
        table0 = new ImageIcon("images/table0.png").getImage();
        scaledimage0 = table0.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        table1 = new ImageIcon("images/table0.png").getImage();
        scaledimage1 = table0.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        table2 = new ImageIcon("images/table0.png").getImage();
        scaledimage2 = table0.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        table3 = new ImageIcon("images/table0.png").getImage();
        scaledimage3 = table0.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        table4 = new ImageIcon("images/table0.png").getImage();
        scaledimage4 = table0.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        table5 = new ImageIcon("images/table0.png").getImage();
        scaledimage5 = table0.getScaledInstance(200,200,Image.SCALE_SMOOTH);
        Pizza = new ImageIcon("images/cheese.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Spaghetti = new ImageIcon("images/spag.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Chicken = new ImageIcon("images/chicken.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Caprese = new ImageIcon("images/caprese.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Meatballs = new ImageIcon("images/meatballs.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Rigatoni = new ImageIcon("images/rigatoni.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        Cake = new ImageIcon("images/cake2.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);;
        setTitle("Restaurant");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        waiter = new ImageIcon("images/waiter.png").getImage();
        scaledimage = waiter.getScaledInstance(40,100,Image.SCALE_SMOOTH);
        bubble = new ImageIcon("images/bubble.png").getImage();
        bubbleScaled = bubble.getScaledInstance(90,70,Image.SCALE_SMOOTH);
        tableButtons = new JButton[6];
        drawVoice = false;
        drawMenu = false;
        showFood = false;
        //buttonPressed=-1;
        // Create a JPanel with custom drawing
        drawingPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Add your custom drawing code here
                drawBackround(g);
                drawTables(g);
                drawVoiceBubble(g);
                drawMenu(g);
                drawFood(g);
            }
        };
        drawingPanel.setLayout(null);
        // Add the drawing panel to the frame
        createButtons();
        menu = new JButton("Menu");
        menu.setVisible(true);
        menu.setBounds(0, 0, 80, 40);
        drawingPanel.add(menu);
        //add(drawingPanel);
        for(int i = 0; i < 6; i++) {
            tableButtons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Code to be executed when the button is pressed
                        if(drawVoice) {
                            drawVoice = false;
                        }
                        else {
                            drawVoice = true;
                        }
                        drawingPanel.paintImmediately(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
                        drawingPanel.requestFocus();
                    }
                });
        }

        menu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Code to be executed when the button is pressed
                    if(drawMenu) {
                        drawMenu = false;
                    }
                    else {
                        drawMenu = true;
                    }
                    drawingPanel.paintImmediately(0, 0, drawingPanel.getWidth(), drawingPanel.getHeight());
                    drawingPanel.requestFocus();
                }
            });

        timer = new Timer(50, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    yFood+= 5;
                    // Repaint the panel to reflect the changes
                    drawingPanel.repaint();
                    if(!drawMenu) {
                        timer.stop();
                        yFood = -50;
                    }
                    // Optionally, you can add a condition to stop the animation
                    // For example, if (xCoordinate >= 300) timer.stop();
                }
            });
        drawingPanel.addKeyListener(new MyKeyListener());
        drawingPanel.setFocusable(true);
        add(drawingPanel);
        // Make the frame visible
        setVisible(true);
    }
    private class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            // Invoked when a key is pressed down
            int keyCode = e.getKeyCode();

            // Move the object based on the arrow keys
            if (keyCode == KeyEvent.VK_LEFT) {
                xPosWaiter -= 8;
            } else if (keyCode == KeyEvent.VK_RIGHT) {
                xPosWaiter += 8;
            } else if (keyCode == KeyEvent.VK_UP) {
                yPosWaiter -= 8;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                yPosWaiter += 8;
            }

            // Repaint the panel to show the updated position
            drawingPanel.repaint();
            checkCollision();
        }

    }

    private void drawBackround(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLUE);
    }

    private void drawFood(Graphics g) {
        g.drawImage(Pizza,xPOS[0],yFood,null);
        g.drawImage(Spaghetti,xPOS[1],yFood,null);
        g.drawImage(Chicken,xPOS[2],yFood,null);
        g.drawImage(Caprese,xPOS[3],yFood,null);
        g.drawImage(Meatballs,xPOS[4],yFood,null);
        g.drawImage(Rigatoni,xPOS[5],yFood,null);
        g.drawImage(Cake,xPOS[5]+90,yFood,null);
    }

    private void drawTables(Graphics g) { 
        g.drawImage(scaledimage0,xPOS[0],yPOS[0],null);
        zero = new Table("zero", xPOS[0],yPOS[0], 0);
        tables.put(zero, "");
        g.drawImage(scaledimage1,xPOS[1],yPOS[1],null);
        one = new Table("zero", xPOS[0],yPOS[0], 0);
        tables.put(one, "");
        g.drawImage(scaledimage2,xPOS[2],yPOS[2],null);
        two = new Table("zero", xPOS[0],yPOS[0], 0);
        tables.put(two, "");
        g.drawImage(scaledimage3,xPOS[3],yPOS[3],null);
        three = new Table("zero", xPOS[0],yPOS[0], 0);
        tables.put(three, "");
        g.drawImage(scaledimage4,xPOS[4],yPOS[4],null);
        four = new Table("zero", xPOS[0],yPOS[0], 0);
        tables.put(four, "");
        g.drawImage(scaledimage5,xPOS[5],yPOS[5],null);
        five = new Table("zero", xPOS[0],yPOS[0], 0);
        tables.put(five, "");
        //create waiter
        g.drawImage(scaledimage,xPosWaiter,yPosWaiter,null);
    }

    private void drawVoiceBubble(Graphics g) { 
        if(drawVoice&& Math.abs(xPosWaiter - tableButtons[0].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[0].getLocation().y) < EPSILON) {
            g.setColor(Color.WHITE);
            g.fillOval(xPOS[0]+100,yPOS[0], 140, 60);
            Font customFont = new Font("Arial", Font.PLAIN, 9);
            setFont(customFont);
            g.setColor(Color.BLACK);
            tables.replace(zero,zeroDish);
            g.drawString(tables.get(zero), xPOS[0]+110, yPOS[0]+35);
        }
        if(drawVoice &Math.abs(xPosWaiter - tableButtons[1].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[1].getLocation().y) < EPSILON) {
            g.setColor(Color.WHITE);
            g.fillOval(xPOS[1]+100,yPOS[1], 140, 60);
            Font customFont = new Font("Arial", Font.PLAIN, 9);
            setFont(customFont);
            g.setColor(Color.BLACK);
            tables.replace(one,oneDish);
            g.drawString(tables.get(one), xPOS[1]+110, yPOS[1]+35);
        }
        if(drawVoice &Math.abs(xPosWaiter - tableButtons[2].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[2].getLocation().y) < EPSILON) {
            g.setColor(Color.WHITE);
            g.fillOval(xPOS[2]+100,yPOS[2], 140, 60);
            Font customFont = new Font("Arial", Font.PLAIN, 9);
            setFont(customFont);
            g.setColor(Color.BLACK);
            tables.replace(two,twoDish);
            g.drawString(tables.get(two), xPOS[2]+110, yPOS[2]+35);
        }
        if(drawVoice & Math.abs(xPosWaiter - tableButtons[3].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[3].getLocation().y) < EPSILON) {
            g.setColor(Color.WHITE);
            g.fillOval(xPOS[3]+100,yPOS[3], 140, 60);
            Font customFont = new Font("Arial", Font.PLAIN, 9);
            setFont(customFont);
            g.setColor(Color.BLACK);
            tables.replace(three,threeDish);
            g.drawString(tables.get(three), xPOS[3]+110, yPOS[3]+35);
        }
        if(drawVoice & Math.abs(xPosWaiter - tableButtons[4].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[4].getLocation().y) < EPSILON) {
            g.setColor(Color.WHITE);
            g.fillOval(xPOS[4]+100,yPOS[4], 140, 60);
            Font customFont = new Font("Arial", Font.PLAIN, 9);
            setFont(customFont);
            g.setColor(Color.BLACK);
            tables.replace(four,fourDish);
            g.drawString(tables.get(four), xPOS[4]+110, yPOS[4]+35);

        }
        if(drawVoice & Math.abs(xPosWaiter - tableButtons[5].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[5].getLocation().y) < EPSILON) {
            g.setColor(Color.WHITE);
            g.fillOval(xPOS[5]+100,yPOS[5], 140, 60);
            Font customFont = new Font("Arial", Font.PLAIN, 9);
            setFont(customFont);
            g.setColor(Color.BLACK);
            tables.replace(five,fiveDish);
            g.drawString(tables.get(five), xPOS[5]+110, yPOS[5]+35);
        }
    }

    private void drawMenu(Graphics g) {
        if(drawMenu) {
            timer.start();
            g.setColor(Color.WHITE);
            g.fillRect(10,40,270,300);
            g.setColor(Color.RED);
            Font font1 = new Font("Monospaced", Font.BOLD, 24);
            g.setFont(font1);
            g.drawString("Mimi's place",35,80);
            Font font3 = new Font("Monospaced", Font.BOLD, 14);
            g.setFont(font3);
            g.drawString("For solo diners :)",35,100);
            g.setColor(Color.BLACK);
            Font font2 = new Font("Monospaced", Font.ITALIC, 18);
            g.setFont(font2);
            g.drawString("Cacio e pepe $23",15,120);
            g.drawString("Spaghetti Bolognese $32",15,150);
            g.drawString("Chicken parmesan $40",15,180);
            g.drawString("Caprese Salad $16",15,210);
            g.drawString("Meatballs $18",15,240);
            g.drawString("Rigatoni Vodka $22",15,270);
            g.drawString("Chocolate cake $12",15,300);
        }
    }

    private void createButtons() {
        for (int i = 0; i < numTables; i++) {
            tableButtons[i] = new JButton("Take Order");
            tableButtons[i].setVisible(false);
            tableButtons[i].setBounds(xPOS[i], yPOS[i], 80, 40);
            drawingPanel.add(tableButtons[i]);
        }

    }

    private void checkCollision() {
        if (Math.abs(xPosWaiter - tableButtons[0].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[0].getLocation().y) < EPSILON) {
            tableButtons[0].setVisible(true);
        }
        else tableButtons[0].setVisible(false);
        if (Math.abs(xPosWaiter - tableButtons[1].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[1].getLocation().y) < EPSILON) {
            tableButtons[1].setVisible(true);
        }
        else tableButtons[1].setVisible(false);
        if (Math.abs(xPosWaiter - tableButtons[2].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[2].getLocation().y) < EPSILON) {
            tableButtons[2].setVisible(true);
        }
        else tableButtons[2].setVisible(false);
        if (Math.abs(xPosWaiter - tableButtons[3].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[3].getLocation().y) < EPSILON) {
            tableButtons[3].setVisible(true);
        }
        else tableButtons[3].setVisible(false);
        if (Math.abs(xPosWaiter - tableButtons[4].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[4].getLocation().y) < EPSILON) {
            tableButtons[4].setVisible(true);
        }
        else tableButtons[4].setVisible(false);
        if (Math.abs(xPosWaiter - tableButtons[5].getLocation().x) < EPSILON && Math.abs(yPosWaiter - tableButtons[5].getLocation().y) < EPSILON) {
            tableButtons[5].setVisible(true);
        }
        else tableButtons[5].setVisible(false);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Restaurant());
    }
}
