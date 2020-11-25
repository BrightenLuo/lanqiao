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
	int x,y;
	public MainCanvas(){
		try{
			imgDown=Image.createImage("/sayo10.png");
			imgUp=Image.createImage("/sayo14.png");
			imgLeft=Image.createImage("/sayo12.png");
			imgRight=Image.createImage("/sayo16.png");
			currentImg=imgDown;
			x=120;
			y=100;
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==UP){
			currentImg=imgUp;
			System.out.println("move UP!");
			repaint();
			y--;
		}
		if(action==DOWN){
			currentImg=imgDown;
			System.out.println("move DOWN!");
			repaint();
			y++;
		}
		if(action==LEFT){
			currentImg=imgLeft;
			System.out.println("move LEFT!");
			repaint();
			x--;
		}
		if(action==RIGHT){
			currentImg=imgRight;
			System.out.println("move RIGHT!");
			repaint();
			x++;
		}
	}
}