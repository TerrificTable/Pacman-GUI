package xyz.terrific.utils;

import xyz.terrific.gui.Pacman_GUI;

import java.io.IOException;
import java.io.OutputStream;

public class PackageInstaller {

    public static void install() {

        try {

            // This was not tested, may work may not...
            Process proc = Runtime.getRuntime().exec("sudo pacman -Sy " + Pacman_GUI.jlist.getSelectedValue());
            OutputStream out = proc.getOutputStream();
            System.out.println(String.valueOf(out));

            Pacman_GUI.Information_Area.setText("Installing " + Pacman_GUI.jlist.getSelectedValue());
            Pacman_GUI.Information_Area.setText(String.valueOf(out));


            proc.getOutputStream().close();
            proc.waitFor();
            Pacman_GUI.install_button.enable();
        } catch (IOException | InterruptedException e) {
            Pacman_GUI.Information_Area.setText("Error while trying to install Package " + Pacman_GUI.jlist.getSelectedValue() + ": \n" + e.getMessage());
            throw new RuntimeException(e);
        }

    }

}
