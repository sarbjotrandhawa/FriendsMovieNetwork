
import com.sun.jna.NativeLibrary;
import com.sun.jna.Native;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class StreamingPlayer extends javax.swing.JFrame 
{
    String media="";
    EmbeddedMediaPlayer player;
    
    public StreamingPlayer(String media) 
    {
        this.media = media;
        setVisible(true);
        setSize(800,500);
        initComponents();
        
        
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:\\vlcj data");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        
        MediaPlayerFactory mediafactory = new MediaPlayerFactory();
        
        player = mediafactory.newEmbeddedMediaPlayer();
        
        CanvasVideoSurface surface = mediafactory.newVideoSurface(canvas1);
        player.setVideoSurface(surface);
        
        player.playMedia(media);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        canvas1.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(canvas1);
        canvas1.setBounds(40, 40, 530, 340);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) 
    {
        StreamingPlayer obj = new StreamingPlayer("rtsp://192.168.137.18:8555/hello");
    }

}
