import javax.swing.*;
import java.awt.*;

public class GUI {
    JPanel panel1;
    static JFrame frame = new JFrame("Legends of the Three Kingdoms");
    static JPanel opponent = new JPanel();
    static JPanel player = new JPanel();
    static JPanel hand = new JPanel();
    static JPanel equipment = new JPanel();
    static JPanel opponent_equipment = new JPanel();
    static JButton opponent_name = new JButton("opponent name");
    static JButton opponent_hp = new JButton ("opponent hp");
    static JButton your_name = new JButton ("your name");
    static JButton your_hp = new JButton ("your hp");
    static JButton opponent_weapon = new JButton ("opponent weapon");
    static JButton opponent_shield = new JButton ("opponent shield");
    static JButton your_weapon = new JButton ("your weapon");
    static JButton your_shield = new JButton ("your shield");


    public static void set_opponent_layout() {
        opponent.setLayout(new BoxLayout(opponent,BoxLayout.PAGE_AXIS));
        opponent.setBackground(Color.DARK_GRAY);
        opponent.add(opponent_name);
        opponent.add(opponent_hp);
        frame.add(opponent);
        frame.pack();
        frame.setVisible(true);

    }

    public static void set_hand_layout(){
        hand.setLayout(new BoxLayout(hand,BoxLayout.LINE_AXIS));
        hand.setBackground(Color.BLACK);
        frame.add(hand);
        frame.pack();
        frame.setVisible(true);
    }

    public static void set_player_layout(){
        player.setLayout(new BoxLayout(player,BoxLayout.PAGE_AXIS));
        player.setBackground(Color.BLUE);
        player.add(your_name);
        player.add(your_hp);
        frame.add(player);
        frame.pack();
        frame.setVisible(true);

    }

    public static void set_equipment_layout () {
        equipment.setLayout(new BoxLayout(player,BoxLayout.PAGE_AXIS));
        equipment.setBackground(Color.GREEN);
        equipment.add(your_weapon);
        equipment.add(your_shield);
        frame.add(equipment);
        frame.pack();
        frame.setVisible(true);
    }

    public static void set_opponent_equipment_layout(){
        opponent_equipment.setLayout(new BoxLayout(player,BoxLayout.PAGE_AXIS));
        opponent_equipment.setBackground(Color.gray);
        opponent_equipment.add(opponent_weapon);
        opponent_equipment.add(opponent_shield);
        frame.add(opponent_equipment);
        frame.pack();
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                set_opponent_layout();
                set_hand_layout();
                set_player_layout();
                set_equipment_layout();
                set_opponent_equipment_layout();
            }
        });


    }
}