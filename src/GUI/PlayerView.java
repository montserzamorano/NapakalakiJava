package GUI;
import Model.*;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Montse R.Zamorano
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel=new Player();
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList){
        aPanel.removeAll();
        for(Treasure t : aList){
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
    }
    
    /**
     * @brief le da valor al atributo playerModel
     * @param p 
     */
    public void setPlayer(Player p){
        this.playerModel=p;
        level.setText(Integer.toString(playerModel.getLevel()));
        name.setText(playerModel.getName());
        fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        level = new javax.swing.JLabel();
        hiddenTreasures = new javax.swing.JPanel();
        visibleTreasures = new javax.swing.JPanel();
        buyButton = new javax.swing.JButton();
        visibleButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();

        setForeground(new java.awt.Color(238, 238, 238));

        name.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        name.setText("Name");

        jLabel2.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        jLabel2.setText("Nivel:");

        level.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        level.setText("Level");

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        visibleTreasures.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        visibleTreasures.setToolTipText("");

        buyButton.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        buyButton.setText("Comprar niveles");

        visibleButton.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        visibleButton.setText("Hacer tesoros visibles");

        discardButton.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        discardButton.setText("Descartar tesoros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(buyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visibleButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discardButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(level)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(level))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButton)
                    .addComponent(visibleButton)
                    .addComponent(discardButton))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyButton;
    private javax.swing.JButton discardButton;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel level;
    private javax.swing.JLabel name;
    private javax.swing.JButton visibleButton;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
