package GUI;
import Model.*;
import java.awt.Color;
import static java.awt.Color.blue;

/**
 *
 * @author Montse R.Zamorano
 */
public class TreasureView extends javax.swing.JPanel {
    private Treasure treasureModel;
    private boolean selected=false;
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
    }
    
    /**
     * @brief actualiza los componentes que forman parte del diseño
     * de su vista
     * @param t 
     */
    public void setTreasure(Treasure t){
        treasureModel=t;
        name.setText(treasureModel.getName());
        coins.setText(Integer.toString(treasureModel.getGoldCoins()));
        minBonus.setText(Integer.toString(treasureModel.getMinBonus()));
        maxBonus.setText(Integer.toString(treasureModel.getMaxBonus()));
        type.setText(treasureModel.getStringType(treasureModel.getType()));
        repaint();
    }
    
    public boolean isSelected(){return selected;}
    public Treasure getTreasure(){return treasureModel;}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        minBonus = new javax.swing.JLabel();
        maxBonus = new javax.swing.JLabel();
        coins = new javax.swing.JLabel();
        type = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        name.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        name.setText("Name");

        jLabel2.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        jLabel2.setText("Bonus mínimo:");

        jLabel3.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        jLabel3.setText("Bonus máximo:");

        jLabel4.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        jLabel4.setText("Piezas de oro:");

        minBonus.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        minBonus.setText("minBonus");

        maxBonus.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        maxBonus.setText("maxBonus");

        coins.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        coins.setText("coins");

        type.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        type.setText("type");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(minBonus))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coins)
                                    .addComponent(maxBonus))))
                        .addContainerGap(107, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(type)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minBonus)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maxBonus)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coins)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selected = !selected;
        if(selected){
            setBackground(Color.LIGHT_GRAY);
            setOpaque(true);
        }
        if(!selected){
            setOpaque(false);
        }
        repaint();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel coins;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel maxBonus;
    private javax.swing.JLabel minBonus;
    private javax.swing.JLabel name;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
