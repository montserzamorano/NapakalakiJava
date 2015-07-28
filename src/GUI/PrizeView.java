package GUI;
import Model.*;

/**
 *
 * @author montse
 */
public class PrizeView extends javax.swing.JPanel {
    private Prize prizeModel; 
    /**
     * Creates new form PrizeView
     */
    public PrizeView() {
        initComponents();
    }
    
    public void setPrize(Prize p){
        this.prizeModel=p;
        levels.setText(Integer.toString(prizeModel.getLevels()));
        treasures.setText(Integer.toString(prizeModel.getTreasures()));
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();
        treasures = new javax.swing.JLabel();

        setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Skia", 0, 15)); // NOI18N
        jLabel1.setText("Niveles:");

        jLabel2.setFont(new java.awt.Font("Skia", 0, 15)); // NOI18N
        jLabel2.setText("Tesoros:");

        levels.setFont(new java.awt.Font("Skia", 0, 15)); // NOI18N
        levels.setText("levels");

        treasures.setFont(new java.awt.Font("Skia", 0, 15)); // NOI18N
        treasures.setText("treasures");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(treasures))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(levels)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(levels))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(treasures))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel levels;
    private javax.swing.JLabel treasures;
    // End of variables declaration//GEN-END:variables
}
