package xyz.terrific;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerContrastIJTheme;
import xyz.terrific.gui.Application_Gui;
import xyz.terrific.gui.Pacman_GUI;
import xyz.terrific.gui.packet_information.JListInteraction;

public class Main {

    public static Pacman_GUI frame;


    public static void main(String[] args) {

        FlatLaf.install(new FlatMaterialDarkerContrastIJTheme());
        Application_Gui.init();

    }


    public static void exit() {
        JListInteraction.INSTANCE.stop();
        Pacman_GUI.install_button.setVisible(false);

        frame.dispose();


        System.exit(0);
    }

}
