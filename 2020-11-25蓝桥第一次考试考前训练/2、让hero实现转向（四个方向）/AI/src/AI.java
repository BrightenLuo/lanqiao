import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image imgDown,imgUp,imgLeft,imgRight,currentImg;
	public MainCanvas(){
		try{
			imgDown=Image.createImage("/sayo10.png");
			imgUp=Image.createImage("/sayo14.png");
			imgLeft=Image.createImage("/sayo12.png");
			imgRight=Image.createImage("/sayo16.png");
			currentImg=imgDown;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==UP){
			currentImg=imgUp;
			System.out.println("UP!");
			repaint();
		}
		if(action==DOWN){
			currentImg=imgDown;
			System.out.println("DOWN!");
			repaint();
		}
		if(action==LEFT){
			currentImg=imgLeft;
			System.out.println("LEFT!");
			repaint();
		}
		if(action==RIGHT){
			currentImg=imgRight;
			System.out.println("RIGHT!");
			repaint();
		}
	}
}