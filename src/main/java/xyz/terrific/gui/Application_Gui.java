package xyz.terrific.gui;

import xyz.terrific.Main;

import javax.swing.*;
import java.awt.*;

public class Application_Gui {

    public static void init() {
        Main.frame = new Pacman_GUI();
        Main.frame.setTitle("Pacman GUI");
        Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.frame.setSize(new Dimension(866, 510));

        Pacman_GUI.install_button.setVisible(false);

        Main.frame.setVisible(true);
    }

}
