import java.awt.*;
public class GUIExer6_FAJARDO extends Frame{
    {
        this.setLayout(new BorderLayout());
        this.setTitle("Silly String Game");
        this.setPreferredSize(new Dimension(300, 100));
    }

    public GUIExer6_FAJARDO(){
        Panel north = new Panel(new FlowLayout(FlowLayout.LEFT));
        Panel south = new Panel(new FlowLayout(FlowLayout.LEFT));

        north.add(new Button("UpperCase"));
        south.add(new Button("LowerCase"));

        this.add(north,BorderLayout.NORTH);
        this.add(new TextField("",15),BorderLayout.CENTER);
        this.add(south,BorderLayout.SOUTH);

        
        this.pack();
        this.setVisible(true);

    }
    public static void main(String[] args) {
        new GUIExer6_FAJARDO();
    }














}
