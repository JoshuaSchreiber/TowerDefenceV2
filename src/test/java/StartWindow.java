import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Objects;

public class StartWindow extends JPanel {
    JFrame mainFrame = new JFrame();
    GridBagConstraints gridBagConstraints = new GridBagConstraints();
    GridBagLayout gridBagLayout = new GridBagLayout();

    public StartWindow(){
        mainFrame.setVisible(true);
        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        JButton button = new JButton();
        JLabel l = new JLabel();
        this.add(newField("jButton", l, button, "#FFFBE5", "#F6EB47", 300, 300, 20, 1,1,1,0,0,0,0   ));
        setLayout(gridBagLayout);
    }

    public void createStartGameButton(){
        GridBagLayout gridBagLayout = new GridBagLayout();
        setLayout(gridBagLayout);
        GridBagConstraints  gridBagConstraints = new GridBagConstraints();
        JPanel jPanel = new JPanel();
        mainFrame.add(jPanel);
        JButton startGameButton = new JButton("Start Tower Defence");
        startGameButton.setHorizontalAlignment(SwingConstants.CENTER);
        startGameButton.setVerticalAlignment(SwingConstants.CENTER);
        startGameButton.setPreferredSize(new Dimension(300, 66));
        startGameButton.setBackground(Color.BLACK);
        startGameButton.setForeground(Color.WHITE);
        startGameButton.setFont(startGameButton.getFont().deriveFont(20f));
        jPanel.add(startGameButton);
    }

    public static void main(String[] args){
        StartWindow startWindow = new StartWindow();
    }

    public JLabel newField(String labelOrButton, JLabel jLabel, JButton jButton, String backgroundColor, String foregroundColor, int preferredSizeWidth, int preferredSizeHeight, int fontSize, int gridx, int gridy, int gridwidth, int insetsUp, int insetsDown, int insetsRight, int insetsLeft) {
        if (Objects.equals(labelOrButton, "jLabel")) {
            if (!backgroundColor.equals("")) {
                jLabel.setBackground(Color.decode(backgroundColor));
                jLabel.setForeground(Color.decode(foregroundColor));
            }
            jLabel.setPreferredSize(new Dimension(preferredSizeWidth, preferredSizeHeight));
            jLabel.setVerticalAlignment(JLabel.CENTER);
            jLabel.setHorizontalAlignment(JLabel.CENTER);
            if (!backgroundColor.equals("#000000")) {
                jLabel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            }else{
                jLabel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1));
            }
            if (fontSize == 1) {
                jLabel.setFont(jLabel.getFont().deriveFont(20f));
            } else if (fontSize == 2) {
                jLabel.setFont(jLabel.getFont().deriveFont(40f));
            }
            jLabel.setFont(jLabel.getFont().deriveFont(Font.BOLD));
            // jLabel.setBorder(new OvalBorder());
            jLabel.setOpaque(true);
        } else if (Objects.equals(labelOrButton, "jButton")) {
            if(!backgroundColor.equals("")) {
                jButton.setBackground(Color.decode(backgroundColor));
                jButton.setForeground(Color.decode(foregroundColor));
            }
            jButton.setPreferredSize(new Dimension(preferredSizeWidth, preferredSizeHeight));
            jButton.setVerticalAlignment(JLabel.CENTER);
            jButton.setHorizontalAlignment(JLabel.CENTER);
            if (!backgroundColor.equals("#000000")) {
                jButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            }else {
                jButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 1));
            }
            jButton.setFont(jButton.getFont().deriveFont(20f));
            jButton.setFont(jButton.getFont().deriveFont(Font.BOLD));
            jButton.setOpaque(true);
        }
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = gridx;
        gridBagConstraints.gridy = gridy;
        gridBagConstraints.gridwidth = gridwidth;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(insetsUp, insetsLeft, insetsDown, insetsRight);
        if (Objects.equals(labelOrButton, "jLabel")) {
            gridBagLayout.setConstraints(jLabel, gridBagConstraints);
            add(jLabel);
        } else if (Objects.equals(labelOrButton, "jButton")) {
            gridBagLayout.setConstraints(jButton, gridBagConstraints);
            add(jButton);
        }
        return jLabel;
    }

}
