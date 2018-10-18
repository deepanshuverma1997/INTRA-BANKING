
package adminui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class BackgroundDesktopPane2 extends JDesktopPane {
    private Image img;

    public BackgroundDesktopPane2() {
        try{
            ImageIcon icon;
            icon=new ImageIcon(getClass().getResource("/adminui/banking.jpg"));
            img=icon.getImage();
        }catch(Exception ex){
            
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
       if(img==null){
           super.paintComponent(g);
       }else{
           g.drawImage(img,0,0,getWidth(),getHeight(), this);
       }
    }
}
