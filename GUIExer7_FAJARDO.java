import java.awt.*;
public class GUIExer7_FAJARDO extends Frame{
    {
        this.setLayout(new BorderLayout());
        this.setTitle("Silly String Game");
        this.setPreferredSize(new Dimension(300, 100));
    }

    /**
     * 
     */
    public GUIExer7_FAJARDO(){
        Panel north = new Panel(new FlowLayout(FlowLayout.CENTER));

        Panel south = new Panel(new GridLayout(1,1));
        north.add(new TextField("",5));
        north.add(new Button("+"))
        north.add(new TextField("",5));




        
        this.setVisible(true);

    }
    public static void main(String[] args) {
        new GUIExer7_FAJARDO();
    }














}
