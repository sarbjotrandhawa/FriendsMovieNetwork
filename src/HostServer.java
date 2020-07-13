import java.net.*;
import java.io.*;

public class HostServer
{
    ServerSocket serSock;
    Socket hssock;
    Thread cht;
    String ip;
    
    HostServer()
    {
        try
        {
        serSock = new ServerSocket(8900);
        hssock = serSock.accept();
        
        
       ClientHandler chObj = new ClientHandler(hssock);
        cht = new Thread(chObj);
        cht.start(); 
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
  
    class ClientHandler implements Runnable
    {
        Socket chsock;
        public ClientHandler(Socket sock) 
        {
            chsock = sock;
        }
        
        public void run()
        {
        try
        {
       String ip = chsock.getInetAddress().getHostAddress();
        DataInputStream chdis = new DataInputStream(chsock.getInputStream());
        DataOutputStream chdos = new DataOutputStream(chsock.getOutputStream());
        
        String s = chdis.readLine();
           System.out.println(s);
           chdos.writeBytes("OK "+ip+" \r\n");
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            
        }
    }
  
    
    public static void main(String[] args) 
    {
        HostServer hsObj = new HostServer(); 
        
    }
 
}
