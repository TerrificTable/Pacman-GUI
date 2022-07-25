package xyz.terrific.utils;

import java.io.IOException;

public class Pacman_Utils {

    public static String getPackageInformation(String package_name) {
        try {
            String res = HTTPUtils.get( "https://archlinux.org/packages/community/x86_64/" + package_name );
            // System.out.println(res);
            return res;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
