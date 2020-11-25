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
	Image imgDown,imgDownL,imgDownR,imgUp,imgUpL,imgUpR,imgLeft,imgLeftL,imgLeftR,imgRight,imgRightL,imgRightR,currentImg;
	int x,y;//坐标
	int flag;//左右手脚互换标志
	int oldAction;//记录上一个方向
	int action;//转范围为成员变量
	public MainCanvas(){
		try{
			imgDown=Image.createImage("/sayo10.png");
			imgDownL=Image.createImage("/sayo20.png");
			imgDownR=Image.createImage("/sayo00.png");
			imgUp=Image.createImage("/sayo14.png");
			imgUpL=Image.createImage("/sayo24.png");
			imgUpR=Image.createImage("/sayo04.png");
			imgLeft=Image.createImage("/sayo12.png");
			imgLeftL=Image.createImage("/sayo22.png");
			imgLeftR=Image.createImage("/sayo02.png");
			imgRight=Image.createImage("/sayo16.png");
			imgRightL=Image.createImage("/sayo26.png");
			imgRightR=Image.createImage("/sayo06.png");
			currentImg=imgDown;
			x=120;
			y=100;
			flag=-1;
			oldAction=-1;

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
		action=getGameAction(keyCode);
		if(oldAction==-1)
			oldAction=action;
		if(action==UP){
			if(flag==-1){
				currentImg=imgUp;
				flag++;
			}
			else if(action!=oldAction)
				currentImg=imgUp;
				else{
					if(flag%2==0)
					currentImg=imgUpL;
					else
					currentImg=imgUpR;
				}
			System.out.println("move UP!");
			repaint();
			y--;
			flag++;
		}
		if(action==DOWN){
			if(flag==-1){
				currentImg=imgDown;
				flag++;
			}
			else if(action!=oldAction)
				currentImg=imgDown;
				else{
					if(flag%2==0)
					currentImg=imgDownL;
					else
					currentImg=imgDownR;
				}
			System.out.println("move DOWN!");
			repaint();
			y++;
			flag++;
		}
		if(action==LEFT){
			if(flag==-1){
				currentImg=imgLeft;
				flag++;
			}
			else if(action!=oldAction)
				currentImg=imgLeft;
				else{
					if(flag%2==0)
					currentImg=imgLeftL;
					else
					currentImg=imgLeftR;
				}
			System.out.println("move LEFT!");
			repaint();
			x--;
			flag++;
		}
		if(action==RIGHT){
			if(flag==-1){
				currentImg=imgRight;
				flag++;
			}
			else if(action!=oldAction)
				currentImg=imgRight;
				else{
					if(flag%2==0)
					currentImg=imgRightL;
					else
					currentImg=imgRightR;
				}
			System.out.println("move RIGHT!");
			repaint();
			x++;
			flag++;
		}
		oldAction=action;
	}
}