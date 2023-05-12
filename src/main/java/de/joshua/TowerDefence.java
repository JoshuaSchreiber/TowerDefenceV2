package de.joshua;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import de.joshua.util.window.GameWindow;

import javax.swing.*;
import java.io.IOException;

public class TowerDefence extends JFrame {
    public int height;
    public int width;

    private TowerDefence() throws IOException {
        setTitle("Tower Defence");
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

        height = getHeight();
        width = getWidth();

        GameWindow gameWindow = new GameWindow(this, height, width);
        add(gameWindow);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        FlatMaterialDeepOceanIJTheme.setup();
        try {
            UIManager.setLookAndFeel(new FlatMaterialDeepOceanIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        new TowerDefence();
    }

}
