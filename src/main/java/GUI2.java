import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUI2 extends JPanel {
    JButton oname, ohp, ow, os, name, hp, w, s, oh,h;
    GridBagConstraints c = new GridBagConstraints();

    public GUI2(){
        setLayout(new GridBagLayout());
        oname = new JButton("opponent name");
        oname.setPreferredSize(new Dimension(200,150));
        c.gridx=24;
        c.gridy=0;
        c.gridwidth=4;
        c.gridheight=4;
        c.fill = GridBagConstraints.BOTH;
        add(oname,c);
        ohp = new JButton("opponent hp");
        ohp.setPreferredSize(new Dimension(200,150));
        c.gridx=24;
        c.gridy=4;
        c.gridheight=4;
        c.gridheight=4;
        c.fill = GridBagConstraints.BOTH;
        add(ohp,c);
        ow = new JButton ("opponent weapon");
        ow.setPreferredSize(new Dimension(200,150));
        c.gridx =20;
        c.gridy=0;
        c.gridwidth=4;
        c.gridheight=4;
        c.fill = GridBagConstraints.BOTH;
        add(ow,c);
        os = new JButton ("opponent shield");
        os.setPreferredSize(new Dimension(200,150));
        c.gridx=20;
        c.gridy=4;
        c.gridheight=4;
        c.gridwidth=4;
        c.fill = GridBagConstraints.BOTH;
        add(os,c);
        oh = new JButton ("opponent hand card");
        oh.setPreferredSize(new Dimension(200,150));
        c.gridx = 0;
        c.gridy=0;
        c.gridheight=8;
        c.gridwidth=20;
        c.fill = GridBagConstraints.BOTH;
        add(oh,c);
        name = new JButton ("your name");
        name.setPreferredSize(new Dimension(200,150));
        c.gridx=24;
        c.gridy=20;
        c.gridheight=4;
        c.gridwidth=4;
        c.fill = GridBagConstraints.BOTH;
        add(name,c);
        hp = new JButton ("your hp");
        hp.setPreferredSize(new Dimension(200,150));
        c.gridx=24;
        c.gridy=24;
        c.gridheight=4;
        c.gridwidth=4;
        c.fill = GridBagConstraints.BOTH;
        add(hp,c);
        w = new JButton ("your weapon");
        w.setPreferredSize(new Dimension(200,150));
        c.gridx=20;
        c.gridy=20;
        c.gridwidth=4;
        c.gridheight=4;
        c.fill = GridBagConstraints.BOTH;
        add(w,c);
        s = new JButton ("your shield");
        s.setPreferredSize(new Dimension(200,150));
        c.gridx=20;
        c.gridy=24;
        c.gridheight=4;
        c.gridwidth=4;
        c.fill = GridBagConstraints.BOTH;
        add(s,c);
        h = new JButton("your hand card");
        h.setPreferredSize(new Dimension(1000,300));
        c.gridx=0;
        c.gridy=20;
        c.gridheight=8;
        c.gridwidth=20;
        c.fill = GridBagConstraints.BOTH;
        add(h,c);
    }
    public static void main(String[]argv){
        GUI2 gui = new GUI2();
        JFrame frame = new JFrame("Legends of the Three Kingdoms");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(1400,800);
        frame.setBackground(Color.DARK_GRAY);
        frame.setResizable(false);
        frame.add(gui);
        frame.setVisible(true);
    }





}

