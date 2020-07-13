
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.net.InetAddress;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


public class StreamingServer implements Runnable
{
  String ip1;
  int portno1;
  String id;
  EmbeddedMediaPlayer mediaPlayer1;
  String media1;
  Thread t;
  
  StreamingServer(String mediapath,int portno)
  {
    try
    {    
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\vlcj data\\");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        
        id = "hello";
        ip1 = InetAddress.getLocalHost().getHostAddress();
        portno1 = portno;
        media1 = mediapath;
        t = new Thread(this);
        t.start();
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
    }    
  }
  public void run()
  {
      try
      {
        
        String options1 = formatRtspStream(ip1, portno1,id);
          
        System.out.println(options1);
        System.out.println("Streaming '" + media1 + "' to '" + options1 + "'");
        MediaPlayerFactory mediaPlayerFactory1 = new MediaPlayerFactory();
    
        mediaPlayer1 = mediaPlayerFactory1.newEmbeddedMediaPlayer();
        mediaPlayer1.playMedia(media1,options1,":no-sout-rtp-sap",":no-sout-standard-sap",":sout-all",":sout-keep");
    
        System.out.println("RTPS Server started");   
        
        Thread.currentThread().join();

        
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
      }
  }
  
  String formatRtspStream(String serverAddress, int serverPort, String id)
  {
      
    System.out.println("in format Rtsp stream");
    StringBuilder sb = new StringBuilder(60);
    sb.append(":sout=#rtp{sdp=rtsp://@");
    sb.append(serverAddress);
    sb.append(':');
    sb.append(serverPort);
    sb.append('/');
    sb.append(id);
    sb.append("}");
    return sb.toString();
  }
  
  public static void main(String args[])
  {
    StreamingServer obj1 = new StreamingServer("D:\\Videos\\one.flv",8555);
    
  }
  
}
