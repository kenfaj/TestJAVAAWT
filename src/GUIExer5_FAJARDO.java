package src;
import java.awt.*;
import static java.awt.BorderLayout.*;

public class GUIExer5_FAJARDO extends Frame{
    {
        this.setTitle("Compose Message");
        this.setSize(300,200);
    }

    public GUIExer5_FAJARDO(){
        //to cc
        Panel north = new Panel(new GridLayout(2,1));
        Panel north1 = new Panel(new BorderLayout());
        Panel north2 = new Panel(new BorderLayout());

        north1.add(new Label("To:"),WEST);
        north2.add(new Label("CC:"),WEST);
        north1.add(new TextField("",20),CENTER);
        north2.add(new TextField("",20),CENTER);
        //NORTH FOR FRAME
        north.add(north1);
        north.add(north2);
        this.add(north,NORTH);

        //TextField in center
        this.add(new TextArea());

        //send button
        Panel south = new Panel(new BorderLayout());
        south.add(new Button("Send"),EAST);
        this.add(south,SOUTH);

        this.setVisible(true);

    }
    public static void main(String[] args) {
        new GUIExer5_FAJARDO();
    }














}
