package GUI;
import Model.*;

/**
 *
 * @author Montse R.Zamorano
 */
public class NapakalakiView extends javax.swing.JFrame {
    private Napakalaki napakalakiModel;
    private boolean met=false;
    private boolean combated=false;
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
    }
    
    public void setNapakalaki(Napakalaki n){
        this.napakalakiModel = n;
        monsterView.setMonster(napakalakiModel.getCurrentMonster());
        monsterView.setVisible(false);
        playerView.setPlayer(napakalakiModel.getCurrentPlayer());
        playerView.setNapakalaki(napakalakiModel);        
        result.setText("");
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        meet = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();
        playerView = new GUI.PlayerView();
        result = new javax.swing.JLabel();
        monsterView = new GUI.MonsterView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        meet.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        meet.setText("Conoce al monstruo");
        meet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meetActionPerformed(evt);
            }
        });

        combat.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        combat.setText("¡¡A combatir!!");
        combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatActionPerformed(evt);
            }
        });

        nextTurn.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        nextTurn.setText("Siguiente turno");
        nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextTurnActionPerformed(evt);
            }
        });

        result.setFont(new java.awt.Font("Skia", 0, 16)); // NOI18N
        result.setForeground(new java.awt.Color(255, 0, 0));
        result.setText("Resultado del combate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, 964, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(meet)
                        .addGap(26, 26, 26)
                        .addComponent(nextTurn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combat))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meet)
                            .addComponent(nextTurn)
                            .addComponent(combat))
                        .addGap(15, 15, 15))
                    .addComponent(playerView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void meetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meetActionPerformed
        result.setText("");
        monsterView.setVisible(true);
        met = true;
    }//GEN-LAST:event_meetActionPerformed

    private void combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatActionPerformed
        if(met){
            result.setText("");
            CombatResult comb = napakalakiModel.combat();
            playerView.setEnabled(true);
            if(comb == CombatResult.LOSE)
                result.setText("Has perdido. Te toca cumplir el mal rollo.");
            else if(comb == CombatResult.LOSEANDDIE)
                result.setText("Has perdido. Estás muerto.");
            else if(comb == CombatResult.LOSEANDESCAPE)
                result.setText("Has perdido el combate pero consigues escapar.");
            else if(comb == CombatResult.WIN)
                result.setText("Has ganado el combate.");
            else if(comb == CombatResult.LOSEANDCONVERT)
                result.setText("Has perdido el combate, pero te conviertes en sectario.");
            else if(comb == CombatResult.WINANDWINGAME)
                result.setText("¡¡ENHORABUENA!! HAS GANADO EL JUEGO");
            
            combated = true;
        }
        else{
            result.setText("Tienes que conocer primero al monstruo.");
        }
    }//GEN-LAST:event_combatActionPerformed

    private void nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextTurnActionPerformed
        if(napakalakiModel.nextTurnAllowed() && combated){
            result.setText("");
            setEnabled(true);
            napakalakiModel.nextTurn();
            setNapakalaki(napakalakiModel);
        }
        else if(!combated){
            result.setText("No has combatido.");
        }
        else if(!napakalakiModel.nextTurnAllowed()){
            result.setText("No has cumplido el mal rollo o tienes que descartarte.");
            setEnabled(false);
        }
    }//GEN-LAST:event_nextTurnActionPerformed

    /**
     * @brief sustituir la función main por este método. A la vez que se abre 
     * otra clase, se oculta con setVisible la primera.
     */
    public void showView(){
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private javax.swing.JButton meet;
    private GUI.MonsterView monsterView;
    private javax.swing.JButton nextTurn;
    private GUI.PlayerView playerView;
    private javax.swing.JLabel result;
    // End of variables declaration//GEN-END:variables
}
