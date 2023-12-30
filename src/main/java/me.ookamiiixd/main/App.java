package me.ookamiiixd.main;

import com.formdev.flatlaf.FlatDarculaLaf;
import me.ookamiiixd.ui.PlayerWindow;

public class App {

    public static void run() {
        FlatDarculaLaf.setup();
        var window = new PlayerWindow();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        App.run();
    }
}
