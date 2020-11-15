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
	Image imgD,imgU,imgL,imgR,currentImg;
	public MainCanvas(){
		try{
			  imgD=Image.createImage("/sayo10.png");
			  imgU=Image.createImage("/sayo14.png");
			  imgL=Image.createImage("/sayo12.png");
			  imgR=Image.createImage("/sayo16.png");

		}
		catch(IOException e){
			 e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			currentImg=imgL;
			System.out.println("向左转");
			repaint();}
			else if(action==UP){
				currentImg=imgU;
				System.out.println("向上转");
				repaint();}
				else if(action==RIGHT){
					currentImg=imgR;
					System.out.println("向右转");
					repaint();}
					else {
						currentImg=imgD;
						System.out.println("向下转");
						repaint();}
	}
}
