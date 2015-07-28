package GUI;
import Model.*;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Montse R.Zamorano
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel=new Player();
    private Napakalaki napakalakiModel;
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
    
    /**
     * @brief llama al método setNapakalaki de la clase napakalakiView
     */
    public void setNapakalaki(Napakalaki n){
        this.napakalakiModel = n;
    }
    
    public void setEnabledmakeVisible(boolean b){
        visibleButton.setEnabled(b);
    }
    
    public void setEnabledbuyButton(boolean b){
        buyButton.setEnabled(b);
    }
    /**
     * @brief Método para obtener la lista de tesoros seleccionados
     */
    public ArrayList <Treasure> getSelectedTreasures(JPanel aPanel){
        TreasureView tv;
        ArrayList <Treasure> output = new ArrayList();
        for(Component c : aPanel.getComponents()){
            tv = (TreasureView) c;
            if(tv.isSelected())
                output.add(tv.getTreasure());
        }
        return output;
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
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        visibleButton.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        visibleButton.setText("Hacer tesoros visibles");
        visibleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visibleButtonActionPerformed(evt);
            }
        });

        discardButton.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        discardButton.setText("Descartar tesoros");
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(buyButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(visibleButton)
                .addGap(168, 168, 168)
                .addComponent(discardButton)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(name)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(level)))
                .addContainerGap(36, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyButton)
                    .addComponent(visibleButton)
                    .addComponent(discardButton))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void visibleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visibleButtonActionPerformed
        ArrayList <Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer (napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_visibleButtonActionPerformed

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        ArrayList <Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList <Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        playerModel.buyLevels(selVisible, selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_buyButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        ArrayList <Treasure> selHidden = getSelectedTreasures(hiddenTreasures);
        ArrayList <Treasure> selVisible = getSelectedTreasures(visibleTreasures);
        for(Treasure t: selHidden){
            playerModel.discardHiddenTreasure(t);
        }
        for(Treasure t1: selVisible){
            playerModel.discardVisibleTreasure(t1);
        }
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_discardButtonActionPerformed


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
