package xyz.terrific.gui.packet_information;

import xyz.terrific.gui.Pacman_GUI;
import xyz.terrific.utils.HTTPUtils;
import xyz.terrific.utils.Pacman_Utils;

import java.io.IOException;
import java.util.ArrayList;

public enum JListInteraction {
    INSTANCE;

    private ArrayList<String> jlist_data = new ArrayList<>();
    private boolean running = false;

    public void start() {
        if (running) return;

        this.running = true;
        new Thread(this::execute).start();
    }

    public void clean() {
        this.stop();
        jlist_data.clear();
        Pacman_GUI.jlist.setListData(jlist_data.toArray());
        Pacman_GUI.Information_Area.setText("");
    }

    public void stop() {
        this.running = false;
    }



    public void element_selected() {
        Object selected = Pacman_GUI.jlist.getSelectedValue();
        if (selected == null) {
            Pacman_GUI.install_button.setVisible(false);
            return;
        }

        String req_res = Pacman_Utils.getPackageInformation( selected.toString() + "/" );

        Pacman_GUI.Information_Area.setText("===  " + selected.toString().toUpperCase() + " ===");
        addText( "Architecture: "   + HTTPUtils.getXpathLike(req_res, "(title.*Browse packages for .* architecture.*\">)(.*)(<\\/a>)") );
        addText( "Repository: "     + HTTPUtils.getXpathLike(req_res, "(title.*Browse the .* repository.*\">)(.*)(<\\/a>)") );
        addText( "Description: "    + HTTPUtils.getXpath(req_res, ".*", "itemprop", "description") );
        addText( "Upstream URL: "   + HTTPUtils.getXpathLike(req_res, "(title.*Visit the website for .*.*\">)(.*)(<\\/a>)") );
        addText( "Maintainers: "    + HTTPUtils.getXpathLike(req_res, "(title.*View packages maintained by .*.*\">)(.*)(<\\/a>)") );

        Pacman_GUI.install_button.setVisible(true);

    }

    void addText(String text) {
        Pacman_GUI.Information_Area.setText( Pacman_GUI.Information_Area.getText() + "\n" + text );
    }


    public void execute() {
        // https://archlinux.org/packages/?sort=&q=Test

        String keyword = Pacman_GUI.keyword.getText();
        if (keyword.isEmpty()) { Pacman_GUI.Error.setText("\"Search Bar\" is empty"); return; }
        try {
            String res = HTTPUtils.get("https://archlinux.org/packages/?sort=&q=" + keyword);

            String amount = HTTPUtils.getXpathLike(res, "(<.*>)(.*)(matching packages found.)").replace(" ", "");
            for (int i=0; i < Integer.parseInt(amount.trim().strip()); i++) {
                String something = HTTPUtils.getXpathLike(res, "(title.*View package details for .*.*\">)(.*)(<\\/a>)");
                res = res.replace("View package details for " + something, "");
                jlist_data.add(something);
            }
        } catch (IOException | InterruptedException e) {
            this.stop();
            throw new RuntimeException(e);
        }


        Pacman_GUI.jlist.setListData( jlist_data.toArray() );

        this.stop();

    }
}
