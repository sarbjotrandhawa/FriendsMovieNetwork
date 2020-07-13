
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;


public class MainClientGui extends javax.swing.JFrame 
{   
     int rowIndex;
    File f1;
    String request="";
    String inputName;
    String fetchip;
    String fetchname;
    Client obj;
    Socket c1sock; 
    ArrayList<IpDesc> alClient = new ArrayList<>();
    ArrayList <FileDetail> alFileDetail = new ArrayList<>();
    ConnClientTable cct;
    SearchedFileTable sft;
    Downloads dFrame;
    DownloadingPanel dp;
    JFileChooser chooser;
    String serverIp;
    
    
    public MainClientGui() 
    {
       cct = new ConnClientTable();
       dFrame = new Downloads();
       sft = new SearchedFileTable();
       serverIp = JOptionPane.showInputDialog(null, " Server IP");
        initComponents();
        
        new Thread(new MiniServer()).start();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btConnect = new javax.swing.JButton();
        btGetList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btCheck = new javax.swing.JButton();
        tfSearch = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btDownload = new javax.swing.JButton();
        btViewDownload = new javax.swing.JButton();
        btStream = new javax.swing.JButton();

        jButton1.setText("start miniserver");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btConnect.setBackground(new java.awt.Color(255, 255, 255));
        btConnect.setText("CONNECT");
        btConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectActionPerformed(evt);
            }
        });

        btGetList.setBackground(new java.awt.Color(255, 255, 255));
        btGetList.setText("Get List");
        btGetList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGetListActionPerformed(evt);
            }
        });

        jTable1.setModel(cct);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("           Online Clients");

        btCheck.setBackground(new java.awt.Color(255, 255, 255));
        btCheck.setText("Check");
        btCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCheckActionPerformed(evt);
            }
        });

        btSearch.setText("SEARCH");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        jTable2.setModel(sft);
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("                  Search Result");

        jLabel3.setText("File Name");

        btDownload.setBackground(new java.awt.Color(255, 255, 255));
        btDownload.setText("DOWNLOAD");
        btDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadActionPerformed(evt);
            }
        });

        btViewDownload.setText("View Download");
        btViewDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btViewDownloadActionPerformed(evt);
            }
        });

        btStream.setBackground(new java.awt.Color(255, 255, 255));
        btStream.setText("STREAM");
        btStream.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStreamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btGetList, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(btSearch)))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(btCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(158, 158, 158))))
            .addGroup(layout.createSequentialGroup()
                .addGap(285, 285, 285)
                .addComponent(btDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btStream, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btViewDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btGetList, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btSearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btViewDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btStream, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnectActionPerformed

      try    
      {
       while(true)
       {
      inputName = JOptionPane.showInputDialog(this,"Enter Your Name");
      
       if(inputName==null) 
      {
         JOptionPane.showMessageDialog(this,"Enter Valid Name");
      } 
      else if(inputName.trim().equals(""))
      {
          JOptionPane.showMessageDialog(this,"Enter Valid Name");
      }
      else 
      {
          break;
      }
      
  }
   
       obj = new Client();
            
       Thread t = new Thread(obj);
        t.start();
         }
         catch(Exception e)
          {
           e.printStackTrace();
          }
             
       btConnect.setEnabled(false);
     
    }//GEN-LAST:event_btConnectActionPerformed

    private void btGetListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGetListActionPerformed
     try{
        obj.c1dos.writeBytes("Get List\r\n");
        }
        catch(Exception e)
        {
         e.printStackTrace();
        }
     alClient.clear();
     
     
    }//GEN-LAST:event_btGetListActionPerformed

    private void btCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCheckActionPerformed
     request="Check";
     rowIndex = jTable1.getSelectedRow();
     if(rowIndex!=-1)
     {
            String indexIp =  alClient.get(rowIndex).ip;
            MiniClient mcObj1 = new MiniClient(indexIp);
            Thread mct = new Thread(mcObj1);
            mct.start();
     }
     else
         JOptionPane.showMessageDialog(null, "Select a client to connect");

    }//GEN-LAST:event_btCheckActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
  
    request = "Search";
        
     for(int i=0; i< alClient.size(); i++)
     {
         MiniClient mObj = new MiniClient(alClient.get(i).ip);
         Thread mct = new Thread(mObj);
         mct.start();
     }
     
     alFileDetail.clear();
    }//GEN-LAST:event_btSearchActionPerformed

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadActionPerformed

        
         chooser = new JFileChooser("D:");
         chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
         rowIndex = jTable2.getSelectedRow();
         MiniClient mObj;
         
        
        if(rowIndex!=-1)
        {
            request = "Download";
            mObj = new MiniClient(alFileDetail.get(rowIndex).ip);
            Thread mct = new Thread(mObj);
            mct.start();
         
        }
       else
        {
            JOptionPane.showMessageDialog(null, "Select File First...");
        }
        
         
      
      
    }//GEN-LAST:event_btDownloadActionPerformed

    private void btViewDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btViewDownloadActionPerformed

      dFrame.setVisible(true);  
        
    }//GEN-LAST:event_btViewDownloadActionPerformed

    private void btStreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStreamActionPerformed

        rowIndex = jTable2.getSelectedRow();
         MiniClient mObj;
        
        if(rowIndex != -1)
        {
            request = "stream";
            mObj = new MiniClient(alFileDetail.get(rowIndex).ip);
            Thread mct = new Thread(mObj);
            mct.start();
          
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Select file first..");
        }
        
        
    }//GEN-LAST:event_btStreamActionPerformed

    class Client implements Runnable
    {
        String s ;
        DataInputStream c1dis;
        DataOutputStream c1dos;
        Client()
        {
            try
            {
                c1sock = new Socket(serverIp,9000);
                c1dis = new DataInputStream(c1sock.getInputStream());
                c1dos = new DataOutputStream(c1sock.getOutputStream());
            }
            catch(Exception e)
            {
            JOptionPane.showMessageDialog(null,"server not Started");
            }
        }
    
        public void run()
        {
            try
            {
              c1dos.writeBytes("Testing\r\n");
              c1dos.writeBytes(inputName+"\r\n");
                while(true)
                {
                String s = c1dis.readLine();
                    System.out.println(s);
                 if(s.startsWith("OK"))
                 {
                     
                     System.out.println(s);
                 }
 
                 else if(s.equals("Name already taken"))
                {
                   
                    while(true)
                    {
                        JOptionPane.showMessageDialog(null, "Name Already Taken");
                        inputName = JOptionPane.showInputDialog(this,"Enter Your Name");
                        if(inputName==null) 
                        {
                           JOptionPane.showMessageDialog(null,"Enter Valid Name");
                        } 
                        else if(inputName.trim().equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"Enter Valid Name");
                        }
                        else 
                        {
                            break;
                        }
                    }
                    c1dos.writeBytes("Testing\r\n");
                    c1dos.writeBytes(inputName+"\r\n");
                }
                 
                else if(s.startsWith("get list response"))
                {
                   int size = Integer.parseInt(c1dis.readLine());
                    System.out.println("Size::::"+size);
                    for (int i = 0; i < size; i++) 
                    {
                         
                        
                    fetchip = c1dis.readLine();
                  fetchname = c1dis.readLine();
                        
                        alClient.add(new IpDesc(fetchip, fetchname));
                         if(fetchip.equals(InetAddress.getLocalHost().getHostAddress()))
                         {
                             alClient.remove(i);
                         }
                        cct.fireTableDataChanged();
                       
                    }
                    
                }
                
                 
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public class ConnClientTable extends AbstractTableModel
    {

        String title[] = {"User Name","IP"}; 
        
        public String getColumnName(int c)
        {
            return title[c];
        }
        
        @Override
        public int getRowCount()
        {
            return alClient.size();           
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
              return alClient.get(row).name;
            }
            
              else
              {
              return alClient.get(row).ip;
              
             }
        }
        
       
    }
    
    
 public  class MiniClient implements Runnable
 {
    Socket mClientsock;
    DataInputStream mClientdis;
    DataOutputStream mClientdos;
    String s;
    
    MiniClient(String ip)
    {
        try
        {
        mClientsock = new Socket(ip,9100);
        mClientdis = new DataInputStream(mClientsock.getInputStream());
        mClientdos = new DataOutputStream(mClientsock.getOutputStream());
        
        
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void run()
    {
        try
        {
            if(request.equals("Check"))
            {
                mClientdos.writeBytes("Testing1\r\n");
                s = mClientdis.readLine();
                System.out.println(s);
            }
            
            else if(request.equals("Search"))
            {
               mClientdos.writeBytes("Search,"+tfSearch.getText().trim()+"\r\n");
               s = mClientdis.readLine();
               System.out.println(s);
               
               if(s.equals("Search Response"))
               {               
                   int getTotalFiles = Integer.parseInt(mClientdis.readLine());
                   System.out.println(getTotalFiles);
                   
                   for(int i=1;i<=getTotalFiles;i++)
                   {
                     String getFileName =  mClientdis.readLine();
                       String getFileSize = mClientdis.readLine();
                       
                       double getSize =  Double.parseDouble(getFileSize);
                 
               if(getSize>=1024 && getSize<(1024*1024))
               {
                  getSize = getSize/1024;
                  
                  DecimalFormat df = new DecimalFormat("#.##");
                      getSize = Double.parseDouble(df.format(getSize));
                  
                      getFileSize = getSize+" KB";
               }
               else if(getSize>=(1024*1024) && getSize<(1024*1024*1024))
               {
                  getSize = getSize/(1024*1024);
                  
                    DecimalFormat df = new DecimalFormat("#.##");
                      getSize = Double.parseDouble(df.format(getSize));
             
                     getFileSize = getSize+" MB";
               }
               else if(getSize>=(1024*1024*1024))
               {
                   getSize = getSize/(1024*1024*1024);
                   
                    DecimalFormat df = new DecimalFormat("#.##");
                      getSize = Double.parseDouble(df.format(getSize));
     
                     getFileSize = getSize+" GB";
               }
               else
               {
                     getFileSize = getSize+" B";
              
               }   
                       
                           String getIp = mClientdis.readLine();
                     String getUserName = mClientdis.readLine();      
                           
                      alFileDetail.add(new FileDetail(getFileName,getFileSize,getUserName,getIp));     
                      sft.fireTableDataChanged();
                   }
               }
            }
           
            else if(request.equalsIgnoreCase("download"))
            {
                mClientdos.writeBytes("download file\r\n");
                 
                s = mClientdis.readLine();
                
            if(s.startsWith("Download Response"))
            {
                String selectedFile= alFileDetail.get(rowIndex).fileName;
                mClientdos.writeBytes(selectedFile+"\r\n");
                
                int p = chooser.showSaveDialog(null);
                 File f3 = null;
                
                if(p==JFileChooser.APPROVE_OPTION)
                {
                   f3 = chooser.getSelectedFile();
                   FileOutputStream fos = new FileOutputStream(f3.getPath()+"\\"+selectedFile);
          
                long size = Long.parseLong(mClientdis.readLine());
                        
                long count = 0;
                byte[] b = new byte[100000];
                
                  dp = new DownloadingPanel(selectedFile);
                   dFrame.jP1.add(dp);
                   
                   
                while(true)
                {
                    int r = mClientdis.read(b,0,100000);
                    fos.write(b,0,r);
                    
                    count = count+r;
                    
                    int pbValue = (int)((count*100)/size);
                    
//                    dp.pb.setBackground(Color.GREEN);
                    dp.pb.setString("downloading per "+pbValue+" %");
                    
                    if(count==size)
                    {
                        break;
                    }
                    
                    
                }
                
           //     dp.pb.setString("downloaded");
                     fos.close();

            }
                
                
                else if(p==JFileChooser.CANCEL_OPTION)
                {
                    System.out.println("Cancel");
                    JOptionPane.showMessageDialog(null, "Operation cancelled by User");
                }

                
          }
        }
            
            else if(request.equalsIgnoreCase("stream"))
            {
               mClientdos.writeBytes("stream\r\n");
                 
                s = mClientdis.readLine();
                
                if(s.equalsIgnoreCase("Stream response"))
                {
                    String selectedFile= alFileDetail.get(rowIndex).fileName;
                    mClientdos.writeBytes(selectedFile+"\r\n");
                    
                    String selectedIp= alFileDetail.get(rowIndex).ip;
                    
                    int getportNo = mClientdis.readInt();
                    
                    StreamingPlayer streamPlayer = new StreamingPlayer("rtsp://"+selectedIp+":"+getportNo+"/hello");
               
                    streamPlayer.setSize(800,600);
                }
                
            }
                
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
       
 }
  
 
 public class SearchedFileTable extends AbstractTableModel
 {
       String title[] = {"File Name","File Size","User Name","IP"};
       
        public String getColumnName(int c)
        {
            return title[c];
        }
        
        @Override
        public int getRowCount() 
        {
           return alFileDetail.size();
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
                return alFileDetail.get(row).fileName;
            }
            
            else if(col==1)
            {
               
                return alFileDetail.get(row).fileSize;
            }   
            
            else if(col==2)
            {
                return alFileDetail.get(row).userName;
            }
            
            else
            {
                return alFileDetail.get(row).ip;
            }
        }
     
 }
 
  
 
 public class MiniServer implements Runnable
 {
    ServerSocket miniserSock;
    Socket miniSock;
    Thread t;
    
    MiniServer()
    {
       
        try
        {
            miniserSock = new ServerSocket(9100);
            System.out.println("MINI SERVER STARTED AT 9100");
       
        }
        catch(Exception e)
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
                miniSock = miniserSock.accept();
                System.out.println("CONNECTION BUILD AT  MINISERVER");
                MiniClientHandler ch = new MiniClientHandler(miniSock);
                t = new Thread(ch);
                t.start();
           
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    class MiniClientHandler implements Runnable
    {
        Socket minichsock;
        String ip;
        DataInputStream minichdis;
        DataOutputStream minichdos;
        String searchFile;
        String getToken[];
        File f = new File("D:\\Videos");
        
        MiniClientHandler(Socket sock)
        {
            minichsock = sock;
        }
        public void run()
        {
            try
            {
               ip = minichsock.getInetAddress().getHostAddress();
               minichdis = new DataInputStream(minichsock.getInputStream());
               minichdos = new DataOutputStream(minichsock.getOutputStream());
             
               String s = minichdis.readLine();
               System.out.println(s);
              
               if(s.equals("Testing1"))
               {
                     minichdos.writeBytes("OK "+ip+"\r\n");
               }
                   
               
               if(s.startsWith("Search"))
               {
                StringTokenizer st = new StringTokenizer(s,",");
                st.nextToken();
                
                if(st.hasMoreTokens())
                {
                   searchFile = st.nextToken(); 
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Enter FileName");
                }
              
                
                System.out.println("serachfile:::"+searchFile);
                String files[] = f.list();
                int total=0;
                
                for(int i=0; i<files.length; i++)
                {
                    if(files[i].toUpperCase().indexOf(searchFile.toUpperCase())!=-1)
                    { 
                        total++;
                    }
                }
                   System.out.println("total:::::"+total);
                minichdos.writeBytes("Search Response\r\n");
                minichdos.writeBytes(total+"\r\n");
                
               for(int i=0; i<files.length; i++)
                {
                    if(files[i].toUpperCase().indexOf(searchFile.toUpperCase())!=-1)
                    { 
                        minichdos.writeBytes(files[i]+"\r\n");
                        f1 = new File("D:\\Videos\\"+files[i]);

                        minichdos.writeBytes(f1.length()+"\r\n");
                        
                        String ipOwn = InetAddress.getLocalHost().getHostAddress();
                        minichdos.writeBytes(ipOwn+"\r\n");
                        System.out.println("filename:::"+files[i]+"size::::"+f1.length());
                        minichdos.writeBytes(inputName+"\r\n");
                    }
                } 
               }
               
               
               if(s.equalsIgnoreCase("download file"))
               {

                    minichdos.writeBytes("Download Response\r\n");
                    
                   String getSelectedFile = minichdis.readLine();
                   File f2 = new File("D:\\Videos\\"+getSelectedFile); 
                   
                   FileInputStream fis = new FileInputStream(f2);
                   
                   long count = 0;
                   byte[] b = new byte[100000];
                   long size = f2.length();
                   
                   minichdos.writeBytes(size+"\r\n");
                   
                 
                   
                   while(true)
                   {
                       int r = fis.read(b,0,100000);
                       minichdos.write(b,0,r);
                       
                       count = count+r;
                       
                       if(count == size)
                       {
                           break;
                       }
                   }
               }
               
               if(s.equalsIgnoreCase("stream"))
               {
                  minichdos.writeBytes("Stream Response\r\n"); 
                   
                   String getSelectedFile = minichdis.readLine();
                   File f4 = new File("D:\\Videos\\"+getSelectedFile); 
                   
                   FileInputStream fis = new FileInputStream(f4);
                   
                   int portNo = (int)(5000 + (10000*Math.random()));
                   
                   minichdos.writeInt(portNo);
                   
                   StreamingServer obj = new StreamingServer(f4.getPath(),portNo);
                  
               }
               
               
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
     
     
 }
 
   
 public class DownloadingPanel extends JPanel
 {
     JProgressBar pb;
     JLabel lbFile;
     
     
     DownloadingPanel(String labelFile)
     {
         setLayout(new FlowLayout((int)LEFT_ALIGNMENT));
         
         pb = new JProgressBar(JProgressBar.HORIZONTAL,0,100);
 
       
         pb.setStringPainted(true);
         
         lbFile = new JLabel(labelFile);
         
         add(pb);
         add(lbFile);
         
     }


       
 }
 
 
 
 
 public class Downloads extends javax.swing.JFrame 

{
  
    public Downloads()
    {  
        initComponents();       
        setSize(500,500);
        setVisible(false);
       setDefaultCloseOperation(HIDE_ON_CLOSE);
       jP1.setPreferredSize(new Dimension(100, 500));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jP1 = new javax.swing.JPanel();

        getContentPane().setLayout(null);

        jScrollPane1.setViewportView(jP1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 485, 485);

        pack();
    }// </editor-fold>                        
                    
    private javax.swing.JPanel jP1;
    private javax.swing.JScrollPane jScrollPane1;
                 
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
            java.util.logging.Logger.getLogger(MainClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainClientGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainClientGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCheck;
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btDownload;
    private javax.swing.JButton btGetList;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btStream;
    private javax.swing.JButton btViewDownload;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}


class IpDesc
{
    String ip;
    String name;

    public IpDesc(String ip, String name) 
    {
        this.ip = ip;
        this.name = name;
    }
    
}


class FileDetail
{
    String fileName,ip,userName,fileSize;
    
    public FileDetail(String fileName, String fileSize,String userName, String ip)
    {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.userName = userName;
        this.ip = ip;
              
    }
    
}