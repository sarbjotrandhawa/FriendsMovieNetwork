import java.net.*;
import java.util.*;
import java.io.*;

public class Server 
{
    ServerSocket serSock;
    Socket sock;
    ArrayList<Server.ClientHandler> al;
    Thread t;
    
    Server()
    {
        al = new ArrayList<>();
        
        try
        {
       serSock = new ServerSocket(9000);
       while(true)
       {
           sock = serSock.accept();
           Server.ClientHandler ch = new Server.ClientHandler(sock);
           al.add(ch);
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
           String s = chdis.readLine();
           System.out.println(s);
          chdos.writeBytes("OK "+ip+" \r\n");
                for (int i = 0; i < al.size(); i++) 
                {
                    System.out.println(al.get(i).ip);
                    
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        Server obj = new Server();
        
    }
    
}
