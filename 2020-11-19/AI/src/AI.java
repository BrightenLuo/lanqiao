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
	Image currentImg;
	Image[] imgLEFT=new Image[3];
	Image[] imgUP=new Image[3];
	Image[] imgDOWN=new Image[3];
	Image[] imgRIGHT=new Image[3];
	int x,y;
	int a;
	public MainCanvas(){
		try{
			for(int i=0;i<3;i++){
				imgLEFT[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for(int i=0;i<3;i++){
				imgRIGHT[i]=Image.createImage("/sayo"+i+"6.png");
			}
			for(int i=0;i<3;i++){
				imgUP[i]=Image.createImage("/sayo"+i+"4.png");
			}
			for(int i=0;i<3;i++){
				imgDOWN[i]=Image.createImage("/sayo"+i+"0.png");
			}

			/*  //下
			  imgD=Image.createImage("/sayo10.png");
			  imgDR=Image.createImage("/sayo20.png");
			  imgDL=Image.createImage("/sayo00.png");
				//上
			  imgU=Image.createImage("/sayo14.png");
			  imgUR=Image.createImage("/sayo04.png");
			  imgUL=Image.createImage("/sayo24.png");
				//左
			  imgL=Image.createImage("/sayo12.png");
			  imgLR=Image.createImage("/sayo02.png");
			  imgLL=Image.createImage("/sayo22.png");
				//右
			  imgR=Image.createImage("/sayo16.png");
			  imgRR=Image.createImage("/sayo06.png");
			  imgRL=Image.createImage("/sayo26.png");
			  */

			  currentImg=imgDOWN[1];
			  x=120;
			  y=100;
			  a=1;
			  

		}
		catch(IOException e){
			 e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(250,220,190);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
	if(action==LEFT){
	
		if(a%2==0)
			currentImg=imgLEFT[2];
		else 
			currentImg=imgLEFT[0];
		System.out.println("向左走");
		x--;
		repaint();
		a++;
		}
	if(action==UP){
		
	    if(a%2==0)
			currentImg=imgUP[2];
		else 
			currentImg=imgUP[0];
		System.out.println("向上走");
		y--;
		repaint();
		a++;
		}
	if(action==RIGHT){
		
		 if(a%2==0)
			currentImg=imgRIGHT[2];
		else 
			currentImg=imgRIGHT[0];
		System.out.println("向右走");
		x++;
		repaint();
		a++;
		}
	if(action==DOWN){
		
	    if(a%2==0)
			currentImg=imgDOWN[2];
		else 
			currentImg=imgDOWN[0];
		System.out.println("向下走");
		y++;
		repaint();
		a++;
		}
	}
}
