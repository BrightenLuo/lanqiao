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
	Image imgD,imgDR,imgDL,imgU,imgUR,imgUL,imgL,imgLR,imgLL,imgR,imgRR,imgRL,currentImg;
	int x,y;
	int a;
	public MainCanvas(){
		try{
			  imgD=Image.createImage("/sayo10.png");
			  imgDR=Image.createImage("/sayo20.png");
			  imgDL=Image.createImage("/sayo00.png");
			  imgU=Image.createImage("/sayo14.png");
			  imgUR=Image.createImage("/sayo04.png");
			  imgUL=Image.createImage("/sayo24.png");
			  imgL=Image.createImage("/sayo12.png");
			  imgLR=Image.createImage("/sayo02.png");
			  imgLL=Image.createImage("/sayo22.png");
			  imgR=Image.createImage("/sayo16.png");
			  imgRR=Image.createImage("/sayo06.png");
			  imgRL=Image.createImage("/sayo26.png");
			  currentImg=imgD;
			  x=120;
			  y=100;
			  a=0;

		}
		catch(IOException e){
			 e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
	if(action==LEFT){
		if(a==0)
		currentImg=imgL;
		else if(a%2==0)
			currentImg=imgLL;
		else currentImg=imgLR;
		System.out.println("向左转");
		x--;
		repaint();
		a++;}
	if(action==UP){
		if(a==0)
		currentImg=imgU;
		else if(a%2==0)
			currentImg=imgUL;
		else currentImg=imgUR;
		System.out.println("向上转");
		y--;
		repaint();
		a++;}
	if(action==RIGHT){
		if(a==0)
		currentImg=imgR;
		else if(a%2==0)
			currentImg=imgRL;
		else currentImg=imgRR;
		System.out.println("向右转");
		x++;
		repaint();
		a++;}
	if(action==DOWN){
		if(a==0)
		currentImg=imgD;
		else if(a%2==0)
			currentImg=imgDL;
		else currentImg=imgDR;
		System.out.println("向下转");
		y++;
		repaint();
		a++;}
	}
}
