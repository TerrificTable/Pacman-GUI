/*
 * Created by JFormDesigner on Sun Jul 24 22:18:00 CEST 2022
 */

package xyz.terrific.gui;

import xyz.terrific.Main;
import xyz.terrific.gui.packet_information.JListInteraction;
import xyz.terrific.utils.PackageInstaller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class Pacman_GUI extends JFrame {
    public Pacman_GUI() {
        initComponents();
    }


    private void Menu_ExitMouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Main.exit();
        }
    }

    private void Start_Test_ButtonMouseClicked(MouseEvent e) {
        JListInteraction.INSTANCE.start();
    }

    private void Stop_Test_ButtonMouseClicked(MouseEvent e) {
        JListInteraction.INSTANCE.stop();
    }

    private void Clear_List_ButtonMouseClicked(MouseEvent e) {
        JListInteraction.INSTANCE.clean();
    }

    private void test_jlistMouseClicked(MouseEvent e) {
        JListInteraction.INSTANCE.element_selected();
    }

    private void install_buttonMouseClicked(MouseEvent e) {
        new Thread(PackageInstaller::install).start();
        Error.setText("Installing...");
        install_button.disable();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menu1 = new JMenu();
        Scroll_test_jlist = new JScrollPane();
        jlist = new JList();
        Start_Test_Button = new JButton();
        Clear_List_Button = new JButton();
        Scroll_Information_Area = new JScrollPane();
        Information_Area = new JTextArea();
        Label_Information_Area = new JLabel();
        keyword = new JTextField();
        label1 = new JLabel();
        Error = new JLabel();
        install_button = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menu1 ========
        {
            menu1.setText("text");
        }
        contentPane.add(menu1);
        menu1.setBounds(new Rectangle(new Point(25, -25), menu1.getPreferredSize()));

        //======== Scroll_test_jlist ========
        {

            //---- jlist ----
            jlist.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    test_jlistMouseClicked(e);
                }
            });
            Scroll_test_jlist.setViewportView(jlist);
        }
        contentPane.add(Scroll_test_jlist);
        Scroll_test_jlist.setBounds(25, 30, 800, 265);

        //---- Start_Test_Button ----
        Start_Test_Button.setText("Search");
        Start_Test_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Start_Test_ButtonMouseClicked(e);
            }
        });
        contentPane.add(Start_Test_Button);
        Start_Test_Button.setBounds(600, 300, 105, 30);

        //---- Clear_List_Button ----
        Clear_List_Button.setText("Clear");
        Clear_List_Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Stop_Test_ButtonMouseClicked(e);
                Clear_List_ButtonMouseClicked(e);
            }
        });
        contentPane.add(Clear_List_Button);
        Clear_List_Button.setBounds(720, 300, 104, Clear_List_Button.getPreferredSize().height);

        //======== Scroll_Information_Area ========
        {

            //---- Information_Area ----
            Information_Area.setEditable(false);
            Scroll_Information_Area.setViewportView(Information_Area);
        }
        contentPane.add(Scroll_Information_Area);
        Scroll_Information_Area.setBounds(25, 335, 565, 130);

        //---- Label_Information_Area ----
        Label_Information_Area.setText("Information");
        Label_Information_Area.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        contentPane.add(Label_Information_Area);
        Label_Information_Area.setBounds(new Rectangle(new Point(25, 305), Label_Information_Area.getPreferredSize()));
        contentPane.add(keyword);
        keyword.setBounds(660, 405, 165, keyword.getPreferredSize().height);

        //---- label1 ----
        label1.setText("Search");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(605, 410), label1.getPreferredSize()));
        contentPane.add(Error);
        Error.setBounds(600, 370, 225, 30);

        //---- install_button ----
        install_button.setText("Install");
        install_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                install_buttonMouseClicked(e);
            }
        });
        contentPane.add(install_button);
        install_button.setBounds(720, 335, 105, install_button.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(850, 510));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    public static JMenu menu1;
    public static JScrollPane Scroll_test_jlist;
    public static JList jlist;
    public static JButton Start_Test_Button;
    public static JButton Clear_List_Button;
    public static JScrollPane Scroll_Information_Area;
    public static JTextArea Information_Area;
    public static JLabel Label_Information_Area;
    public static JTextField keyword;
    public static JLabel label1;
    public static JLabel Error;
    public static JButton install_button;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
