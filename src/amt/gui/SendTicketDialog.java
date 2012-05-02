package amt.gui;

import amt.comm.CommException;
import amt.comm.Database;
import amt.data.TaskFactory;
import amt.log.Logger;

/**
* Dialog box to send a Ticket
 *
 * @author Javier Gonzalez
 * @author Helen Chavez
 * @author Quanwei Zhao
 * @version 20100223
 *
 */

public class SendTicketDialog extends javax.swing.JDialog {

  Database server;
  String ticketType[] = {"Bug", "Suggestion", "Feedback"};
  private Logger logger = Logger.getLogger();

  /** Creates new form SendTicketDialog Form */
  public SendTicketDialog(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    try {
    server = Database.getInstance();
    } catch (CommException de) {
    // do somethign
    }

    this.setTitle("Send Feedback...");
    initComponents();
//    for (int i=0;i<ticketType.length; i++){
//      this.typeComboBox.addItem(ticketType[i]);
//    }
    this.setLocationRelativeTo(parent);
    this.pack();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        descriptionScroll = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        cancelButton = new javax.swing.JButton();
        sendButton = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionScroll.setViewportView(descriptionTextArea);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        label.setText("<html>If you would like to describe your suggestion or complaint, please do so. But even if you don’t, \nexit using the send button. This will tell the developers when you found the application confusing.<html>");
        label.setMaximumSize(new java.awt.Dimension(300, 14));
        label.setMinimumSize(new java.awt.Dimension(300, 14));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(sendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelButton))
                    .addComponent(descriptionScroll, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(sendButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
     // TODO add your handling code here:
     logger.out(Logger.ACTIVITY, "SendTicketDialog.sendButtonActionPerformed.1" , descriptionTextArea.getText());
     //String messageType = ticketType[typeComboBox.getSelectedIndex()];
     String messageType = "Feedback";
     try {
     Database.getInstance().insertTicket(TaskFactory.getInstance().getActualTask(), messageType,descriptionTextArea.getText().trim());
     } catch(CommException de) {
     //do something
       de.printStackTrace();
     }
     descriptionTextArea.setText("");
     this.dispose();
   }//GEN-LAST:event_sendButtonActionPerformed

   private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
     // TODO add your handling code here:
    logger.out(Logger.ACTIVITY, "SendTicketDialog.sendButtonActionPerformed.2");
    dispose();
   }//GEN-LAST:event_cancelButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane descriptionScroll;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel label;
    private javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables

}