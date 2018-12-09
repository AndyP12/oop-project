/*Created by t00199548 on 26/11/18.
 * */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

// The computer will guess any 2-D shape with the information provided


public class guesstheshape extends JFrame implements ActionListener {

    JMenu fileMenu, shapeMenu;
    ArrayList <Shape> shape;

    public static void main(String[] args) {
        guesstheshape frame = new guesstheshape();
        frame.setVisible(true);
    }

    public guesstheshape( ) {
        newSystem();
        setTitle("Guess The Shape");
        setSize(  500,  300);
        setLocation( 100, 100 );
        Container pane = getContentPane();
        pane.setBackground(new Color( 240, 210, 240));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        createFileMenu();
        createShapeMenu();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(shapeMenu);
    }

    public void newSystem() { shape = new ArrayList<Shape>(); }


    public void save() throws IOException {
        ObjectOutputStream os;
        os = new ObjectOutputStream(new FileOutputStream ("shapes.dat"));
        os.writeObject(shape);
        os.close();
    }

    public void open() {
        try{
            ObjectInputStream is;
            is = new ObjectInputStream(new FileInputStream ("shapes.dat"));
            shape  = (ArrayList<Shape>) is.readObject(); // CHANGED
            is.close();
        }

        catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(null,"FileNotFound: did not work");
            e.printStackTrace();
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,"IOException: did not work");
            e.printStackTrace();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"open did not work");
            e.printStackTrace();


        }}



    public void display(){
        JTextArea area = new JTextArea();
        int numSides = shape.size();
        if (numSides == 0) {
            area.setText("Not a valid number of sides!\n\n");
        }
        else if (numSides == 1) {
            area.setText("Circle");
        }

        else if (numSides == 2) {
            area.setText("Line");
        }

        else if (numSides == 3) {
            area.setText("Triangle");
        }

        else if (numSides == 4) {
            area.setText("Square");
        }

        else if (numSides == 5) {
            area.setText("Pentagon");
        }

        else if (numSides == 6) {
            area.setText("Hexagon");
        }

        else if (numSides == 7) {
            area.setText("Heptagon");
        }

        else if (numSides == 8) {
            area.setText("Octagon");
        }

        else
        {
            area.setText("Number of sides too high!");}


    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand() .equals ("Quit")){
            showMessage("Shutting down the system");
            System.exit(0);


        private void createShapeMenu(){
            shapeMenu = new JMenu("Shape");
            JMenuItem item;

            item = new JMenuItem("Add");
            item.addActionListener(this);
            shapeMenu.add(item);

            item = new JMenuItem("Display");
            item.addActionListener(this);
            shapeMenu.add(item);
        }


}

}
