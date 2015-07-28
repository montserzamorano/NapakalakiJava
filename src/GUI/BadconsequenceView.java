package GUI;
import Model.*;
/**
 *
 * @author montse
 */
public class BadconsequenceView extends javax.swing.JPanel {
    private BadConsequence bcModel;
    /**
     * Creates new form BadconsequenceView
     */
    public BadconsequenceView() {
        initComponents();
    }

    public void setBadConsequence(BadConsequence bc){
        this.bcModel = bc;
        //texto
        text.setText(bcModel.getText());
        //niveles
        levelsText.setText(Integer.toString(bcModel.getLevels()));
        //Muerte
        if(bcModel.kills())
            deathText.setText("Estás muerto");
        else{
            deathText.setText("");
        }
        //número tesoros ocultos y visibles
        String hidden=null;
        String visible=null;
        if(bcModel.getnHiddenTreasures() != 0){
            hidden="Pierdes " + Integer.toString(bcModel.getnHiddenTreasures())
                    + " tesoros ocultos.";
        }
        if(bcModel.getnVisibleTreasures() != 0){
            visible="Pierdes " + Integer.toString(bcModel.getnVisibleTreasures())
                    + " tesoros visibles.";
        }
        numberHidden.setText(hidden);
        numberVisible.setText(visible);
        //tesoros específicos
        String hid = null;
        if(!bcModel.getSpecificHiddenTreasures().isEmpty()){
            hid = "Tesoros ocultos específicos:";
            for(TreasureKind t :bcModel.getSpecificHiddenTreasures()){
                if(t == TreasureKind.ARMOR)
                    hid+="\nArmadura";
                if(t == TreasureKind.BOTHHANDS)
                    hid+="\nAmbas manos";
                if(t == TreasureKind.HELMET)
                    hid+="\nCasco";
                if(t == TreasureKind.NECKLACE)
                    hid+="\nCollar";
                if(t == TreasureKind.ONEHAND)
                    hid+="\nMano";
                if(t == TreasureKind.SHOE)
                    hid+="\nCalzado";
            }
            
        }
        else{
            hid = "No hay tesoros ocultos específicos";
        }
        
        String vis = null;
        if(!bcModel.getSpecificVisibleTreasures().isEmpty()){
            vis = "Tesoros visibles específicos:";
            for(TreasureKind t :bcModel.getSpecificVisibleTreasures()){
                if(t == TreasureKind.ARMOR)
                    vis+="\nArmadura";
                if(t == TreasureKind.BOTHHANDS)
                    vis+="\nAmbas manos";
                if(t == TreasureKind.HELMET)
                    vis+="\nCasco";
                if(t == TreasureKind.NECKLACE)
                    vis+="\nCollar";
                if(t == TreasureKind.ONEHAND)
                    vis+="\nMano";
                if(t == TreasureKind.SHOE)
                    vis+="\nCalzado";
            }
            
        }
        else{
            vis = "No hay tesoros visibles específicos";
        }
        
        specificH.setText(hid);
        specificV.setText(vis);
        
        repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();
        levelsText = new javax.swing.JLabel();
        deathText = new javax.swing.JLabel();
        numberHidden = new javax.swing.JLabel();
        numberVisible = new javax.swing.JLabel();
        specificV = new javax.swing.JLabel();
        specificH = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        text.setBackground(new java.awt.Color(204, 204, 255));
        text.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        text.setText("Text");

        levelsText.setBackground(new java.awt.Color(204, 204, 255));
        levelsText.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        levelsText.setText("levelsText");

        deathText.setBackground(new java.awt.Color(204, 204, 255));
        deathText.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        deathText.setText("deathText");

        numberHidden.setBackground(new java.awt.Color(204, 204, 255));
        numberHidden.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        numberHidden.setText("numberHidden");

        numberVisible.setBackground(new java.awt.Color(204, 204, 255));
        numberVisible.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        numberVisible.setText("numberVisible");

        specificV.setBackground(new java.awt.Color(204, 204, 255));
        specificV.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        specificV.setText("specificV");

        specificH.setBackground(new java.awt.Color(204, 204, 255));
        specificH.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        specificH.setText("specificH");

        jLabel8.setBackground(new java.awt.Color(204, 204, 255));
        jLabel8.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        jLabel8.setText("Nivel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(specificV)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberHidden)
                            .addComponent(numberVisible)
                            .addComponent(deathText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(levelsText))
                            .addComponent(specificH)
                            .addComponent(text))
                        .addGap(0, 348, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(levelsText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deathText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numberVisible)
                .addGap(18, 18, 18)
                .addComponent(numberHidden)
                .addGap(18, 18, 18)
                .addComponent(specificV)
                .addGap(21, 21, 21)
                .addComponent(specificH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel deathText;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel levelsText;
    private javax.swing.JLabel numberHidden;
    private javax.swing.JLabel numberVisible;
    private javax.swing.JLabel specificH;
    private javax.swing.JLabel specificV;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
