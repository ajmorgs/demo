import javax.swing.*;
import java.awt.*;

public class PizzaPanel extends JPanel {
    String borderTitle="";

    public PizzaPanel(LayoutManager layout, String borderTitle) {
        super(layout);
        this.borderTitle = borderTitle;
        setBorder(BorderFactory.createTitledBorder(borderTitle));
    }
}
