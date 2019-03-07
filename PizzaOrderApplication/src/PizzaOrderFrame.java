import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PizzaOrderFrame extends JFrame {

    JButton quitButton; JButton orderButton; JButton clearButton;

    JTextArea statusText;
    PizzaPanel crustPanel; PizzaPanel sizePanel; PizzaPanel toppingsPanel; JPanel resultsPanel; JPanel finalPanel;
    JScrollPane scrollPane;
    JCheckBox checkbox;

    JLabel userLabel;JLabel computerLabel;JLabel tiesLabel;

    public PizzaOrderFrame() throws HeadlessException {
        createComponents();
    }

    private void exitPrompt(){

        int dialogButton = JOptionPane.OK_CANCEL_OPTION;
        int input=JOptionPane.showConfirmDialog (null, "Would You Like to Quit the Application","Warning",dialogButton);
        System.out.println(input);
        if (input==0) {
            System.exit(0);
        }
    }

    private void createComponents() {

        JPanel mainPanel = new JPanel(new FlowLayout());

        JComboBox pizzaSizes = new JComboBox();
        pizzaSizes.addItem("Small");
        pizzaSizes.addItem("Medium");
        pizzaSizes.addItem("Large");
        pizzaSizes.addItem("Super");
        pizzaSizes.setSelectedIndex(0);

        sizePanel=new PizzaPanel(new FlowLayout(),"Size");
        sizePanel.add(pizzaSizes);

        mainPanel.add(sizePanel);

        JRadioButton thinCrust=new JRadioButton("Thin");
        JRadioButton regularCrust=new JRadioButton("Regular");
        JRadioButton deepCrust=new JRadioButton("Deep-dish");
        thinCrust.setBounds(75,50,100,30);
        regularCrust.setBounds(75,100,100,30);
        deepCrust.setBounds(75,150,100,30);

        ButtonGroup bg=new ButtonGroup();
        bg.add(thinCrust);bg.add(regularCrust);bg.add(deepCrust);

        crustPanel=new PizzaPanel(new FlowLayout(),"Crust Type");

        crustPanel.add(thinCrust);
        crustPanel.add(regularCrust);
        crustPanel.add(deepCrust);
        crustPanel.setPreferredSize(new Dimension(300,60));
        crustPanel.setBorder(BorderFactory.createTitledBorder("Crust Type"));

        mainPanel.add(crustPanel);

        String s1[] = { "Green Peppers", "Onions", "Mushrooms", "Tomato", "Anchovies","Chicken","Pineapple" };

        toppingsPanel = new PizzaPanel(new FlowLayout(),"Toppings");

        for(int x=0; x< s1.length; x++){
            checkbox = new JCheckBox(s1[x]);
            toppingsPanel.add(checkbox);
        }

        mainPanel.add(toppingsPanel);

        add(mainPanel);

        statusText = new JTextArea(10,40);
        statusText.setEditable(false);
        statusText.setFont(new Font("Serif", Font.ITALIC, 16));
        statusText.setLineWrap(true);
        statusText.setWrapStyleWord(true);

        scrollPane = new JScrollPane(statusText);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        resultsPanel = new JPanel();
        resultsPanel.add(scrollPane);

        mainPanel.add(resultsPanel);

        orderButton = new JButton("Order");
        orderButton.setPreferredSize(new Dimension(100,80));
      //  orderButton.addActionListener((ActionEvent event) -> exitPrompt());
        orderButton.setMargin(new Insets(5, 5, 5, 5));

        mainPanel.add(orderButton);

        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(100,80));
      //  clearButton.addActionListener((ActionEvent event) -> exitPrompt());
        clearButton.setMargin(new Insets(5, 5, 5, 5));

        mainPanel.add(clearButton);

        quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(100,80));
        quitButton.addActionListener((ActionEvent event) -> exitPrompt());
        quitButton.setMargin(new Insets(5, 5, 5, 5));

        mainPanel.add(quitButton);

        setSize(900, 600);
        setBounds(200,200,700,600);

        repaint();
        setTitle("Order your Pizza");

    }

}
