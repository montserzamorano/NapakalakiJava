package GUI;
import Model.*;

/**
 *
 * @author Montse R.Zamorano
 */
public class NapakalakiView extends javax.swing.JFrame {
    private Napakalaki napakalakiModel;

    /**
     * Creates new form NapakalakiView4
     */
    public NapakalakiView() {
        initComponents();
    }
    
    /**
     * @brief método para darle valor al atributo napakalakiModel
     */
    public void setNapakalaki(Napakalaki valor){
        this.napakalakiModel = valor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        meet = new javax.swing.JButton();
        combat = new javax.swing.JButton();
        nextTurn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 255));

        meet.setBackground(new java.awt.Color(255, 255, 204));
        meet.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        meet.setText("Conoce al monstruo");

        combat.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        combat.setText("¡¡A combatir!!");

        nextTurn.setBackground(new java.awt.Color(255, 102, 102));
        nextTurn.setFont(new java.awt.Font("Skia", 0, 14)); // NOI18N
        nextTurn.setText("Siguiente turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(combat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(nextTurn)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(meet)
                .addGap(112, 112, 112))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(meet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextTurn)
                    .addComponent(combat))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void showView(){
        this.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton combat;
    private javax.swing.JButton meet;
    private javax.swing.JButton nextTurn;
    // End of variables declaration//GEN-END:variables
}
