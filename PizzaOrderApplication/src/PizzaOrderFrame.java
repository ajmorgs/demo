import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PizzaOrderFrame extends JFrame {

    JButton quitButton; JButton orderButton; JButton clearButton;
    JTextArea statusText;
    PizzaPanel crustPanel; PizzaPanel sizePanel; PizzaPanel toppingsPanel; JPanel resultsPanel;
    JScrollPane scrollPane;
    JCheckBox checkbox;
    JComboBox pizzaSizes;
    ButtonGroup bg;
    JRadioButton thinCrust;JRadioButton regularCrust;JRadioButton deepCrust;
    String s1[] = { "Green Peppers", "Onions", "Mushrooms", "Tomato", "Anchovies","Chicken","Pineapple" };
    StringBuilder strOrder = new StringBuilder();
  //  Font myFont = new Font("Arial", Font.PLAIN,12);

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

    private void clearOrder(){
        pizzaSizes.setSelectedIndex(0);
        statusText.setText("");
        bg.clearSelection();
        for(int x=0;x<s1.length;x++){
            checkbox = (JCheckBox) toppingsPanel.getComponent(x);
            checkbox.setSelected(false);
        }
    }
    private void processOrder(){
        statusText.append("==============================================\n");

        double grandTotal;double tax; double taxrate=.07;double runningTotal=0;double toppingsTotal=0;

        //get size
        String psize= (String) pizzaSizes.getSelectedItem();

        switch(psize){
            case "Small":
                runningTotal+=8;
                break;
            case "Medium":
                runningTotal+=12;
                break;
            case "Large":
                runningTotal+=16;
                break;
            case "Super":
                runningTotal+=20;
                break;
        }
        String crust="";
        //get crust type
        if(thinCrust.isSelected()){crust="Thin Crust";}
        if(regularCrust.isSelected()){crust="Regular Crust";}
        if(deepCrust.isSelected()){crust="Deep-dish";}
        statusText.append(String.format("%-20s\t\t$%5.2f\n", psize + " " + crust +  " Pizza " , runningTotal));

        String toppings="";
        //get toppings
        for(int x=0;x<s1.length;x++) {
            checkbox = (JCheckBox) toppingsPanel.getComponent(x);
            if(checkbox.isSelected()){
                toppingsTotal+=1;
                statusText.append(String.format("%-20s\t\t$%5.2f\n", checkbox.getText() , (double) 1.00));
            }
        }
       // if(toppings!=""){
        //remove last comma
       //     toppings = toppings.substring(0,toppings.length()-1);
       // }

        statusText.append("\n\n");

        statusText.append(String.format("%-20s\t\t$%5.2f\n","Sub-total:",runningTotal+toppingsTotal));
//
        //add tax
        tax=(runningTotal+toppingsTotal)*taxrate;

        statusText.append(String.format("%-20s\t\t$%5.2f\n","Tax:",tax));

        statusText.append("-------------------------------------\n");

        grandTotal=runningTotal+toppingsTotal+tax;
        statusText.append(String.format("%-20s\t\t$%5.2f\n","Total:",grandTotal));

    }

    private void createComponents() {

        JPanel mainPanel = new JPanel(new FlowLayout());

        pizzaSizes = new JComboBox();
        pizzaSizes.addItem("Small");
        pizzaSizes.addItem("Medium");
        pizzaSizes.addItem("Large");
        pizzaSizes.addItem("Super");
        pizzaSizes.setSelectedIndex(0);

        sizePanel=new PizzaPanel(new FlowLayout(),"Size");
        sizePanel.add(pizzaSizes);

        mainPanel.add(sizePanel);

         thinCrust=new JRadioButton("Thin");
         regularCrust=new JRadioButton("Regular");
         deepCrust=new JRadioButton("Deep-dish");
        thinCrust.setBounds(75,50,100,30);
        regularCrust.setBounds(75,100,100,30);
        deepCrust.setBounds(75,150,100,30);

        bg=new ButtonGroup();
        bg.add(thinCrust);bg.add(regularCrust);bg.add(deepCrust);

        crustPanel=new PizzaPanel(new FlowLayout(),"Crust Type");

        crustPanel.add(thinCrust);
        crustPanel.add(regularCrust);
        crustPanel.add(deepCrust);
        crustPanel.setPreferredSize(new Dimension(300,60));
        crustPanel.setBorder(BorderFactory.createTitledBorder("Crust Type"));

        mainPanel.add(crustPanel);

        toppingsPanel = new PizzaPanel(new FlowLayout(),"Toppings");

        for(int x=0; x< s1.length; x++){
            checkbox = new JCheckBox(s1[x]);
            toppingsPanel.add(checkbox);
        }

        mainPanel.add(toppingsPanel);

        add(mainPanel);

        statusText = new JTextArea();
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
        orderButton.addActionListener((ActionEvent event) -> processOrder());
        orderButton.setMargin(new Insets(5, 5, 5, 5));

        mainPanel.add(orderButton);

        clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(100,80));
        clearButton.addActionListener((ActionEvent event) -> clearOrder());
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
