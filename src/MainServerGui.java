
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class MainServerGui extends javax.swing.JFrame 
{ 
    ConnSysTable cst;
   
    ArrayList<Server.ClientHandler> al = new ArrayList<>();
   
    public MainServerGui() 
    {
        cst =  new ConnSysTable();
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btStart = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btStart.setText("Start Server");
        btStart.setBorder(new javax.swing.border.MatteBorder(null));
        btStart.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("   Connected systems");

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(cst);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btStart, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(131, 131, 131))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btStart, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        Server sObj;
        sObj = new Server();
        Thread st = new Thread(sObj);
        st.start();
    
        btStart.setEnabled(false);
       
    }//GEN-LAST:event_btStartActionPerformed

     
    public class Server implements Runnable
    {
    ServerSocket serSock;
    Socket sock;
    
    Thread t;
    
    Server()
    {
        try 
        {
            serSock = new ServerSocket(9000);
            System.out.println("server start to accept connections");
             JOptionPane.showMessageDialog(null, "server started");
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public void run()
    {
        try
        {
       
          while(true)
          {
            sock = serSock.accept();
            ClientHandler ch = new ClientHandler(sock);
        
            al.add(ch);
         
            cst.fireTableDataChanged();
            t = new Thread(ch);
            t.start();
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
     
    
    class ClientHandler implements Runnable
    {
        Socket chsock;
        String ip;
        String getName;
        
        ClientHandler(Socket sock)
        {
            chsock = sock;
        }
        public void run()
        {
            try
            {
               ip = chsock.getInetAddress().getHostAddress();
              DataInputStream chdis = new DataInputStream(chsock.getInputStream());
             DataOutputStream chdos = new DataOutputStream(chsock.getOutputStream());

             while(true)
             {
                 try
                 {
                     String s = chdis.readLine();
                     if(s.equals("Testing"))
                     {
                         System.out.println(s);
                         String name = chdis.readLine();
                         getName = name;
                         System.out.println("name:::"+name);
                         int flag =0;
                         for (int i = 0; i < al.size(); i++) 
                         {
                   
                             if(name.equals(al.get(i).getName) && !(ip.equals(al.get(i).ip)))
                             {
                                 flag=1;
                                 break;
                             }
                         }
                         if(flag==1)
                         {
                             chdos.writeBytes("Name already taken\r\n");
                         }
                         else
                         {
                             chdos.writeBytes("OK\r\n");
                         }
                     }
                        

           if(s.equalsIgnoreCase("Get List"))
           {
               chdos.writeBytes("get list response\r\n");
               chdos.writeBytes(al.size()+"\r\n");
               
              for(int i=0;i< al.size();i++)
              {
               String name = al.get(i).getName;
               String ips = al.get(i).ip;
               chdos.writeBytes(ips+"\r\n");
               chdos.writeBytes(name+"\r\n");
               
              }
           }
                 } 
                 catch(Exception e)
                 {
                     al.remove(this);
                     cst.fireTableDataChanged();
                 }
             }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    }
   
    
    
    
    
    public class ConnSysTable extends AbstractTableModel
    {
               
        String title[] = {"User Name","IP"};
        
        @Override
        public String getColumnName(int index)
        {
            return title[index];
        }

        @Override
        public int getRowCount()
        {
           return  al.size();
        }

        @Override
        public int getColumnCount() 
        {
            return title.length;
        }

        @Override
        public Object getValueAt(int row, int col) 
        {
            if(col==0)
            {
             return al.get(row).getName;
            }
            
            else 
            {
                return al.get(row).ip;
            }
          
        }
            
    }
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainServerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainServerGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
