import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.util.Objects;

public class JObjekte {
    public JObjekte(JFrame jFrame, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints, String labelOrButton, JLabel jLabel, JButton jButton, String backgroundColor, String foregroundColor, int preferredSizeWidth, int preferredSizeHeight, int fontSize, int gridx, int gridy, int gridwidth, int insetsUp, int insetsDown, int insetsRight, int insetsLeft){
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
            } else {
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
            if (!backgroundColor.equals("")) {
                jButton.setBackground(Color.decode(backgroundColor));
                jButton.setForeground(Color.decode(foregroundColor));
            }
            jButton.setPreferredSize(new Dimension(preferredSizeWidth, preferredSizeHeight));
            jButton.setVerticalAlignment(JLabel.CENTER);
            jButton.setHorizontalAlignment(JLabel.CENTER);
            if (!backgroundColor.equals("#000000")) {
                jButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
            } else {
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
            jFrame.add(jLabel);
        } else if (Objects.equals(labelOrButton, "jButton")) {
            gridBagLayout.setConstraints(jButton, gridBagConstraints);
            jFrame.add(jButton);
        }
    }
}
