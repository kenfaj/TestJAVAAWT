import java.awt.*;
public class GUIExer7_FAJARDO extends Frame{
    {
        this.setLayout(new BorderLayout());
        this.setTitle("MegaCalc");
        this.setPreferredSize(new Dimension(400,300));
    }

    /**
     * 
     */
    public GUIExer7_FAJARDO(){
        Panel north = new Panel(new FlowLayout(FlowLayout.CENTER));

        Panel south = new Panel(new GridLayout(1,1));
        north.add(new TextField("",5));
        north.add(new Button("+"));
        north.add(new TextField("",5));

        this.add(north, BorderLayout.NORTH);


        
        this.setVisible(true);

    }
    public static void main(String[] args) {
        new GUIExer7_FAJARDO();
    }


}
