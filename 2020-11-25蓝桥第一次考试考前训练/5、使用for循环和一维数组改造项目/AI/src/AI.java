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
	Image[] heroUp=new Image[3];
	Image[] heroDown=new Image[3];
	Image[] heroLeft=new Image[3];
	Image[] heroRight=new Image[3];
	int x,y;//坐标
	int flag;//左右手脚互换标志
	int oldAction;//记录上一个方向
	int action;//转范围为成员变量
	public MainCanvas(){
		try{
			for(int i=0;i<3;i++){
				heroUp[i]=Image.createImage("/sayo"+i+"4.png");
				heroDown[i]=Image.createImage("/sayo"+i+"0.png");
				heroLeft[i]=Image.createImage("/sayo"+i+"2.png");
				heroRight[i]=Image.createImage("/sayo"+i+"6.png");
			}
			currentImg=heroDown[1];
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
				currentImg=heroUp[1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroUp[1];
				else{
					if(flag%2==0)
					currentImg=heroUp[2];
					else
					currentImg=heroUp[0];
				}
			System.out.println("move UP!");
			repaint();
			y--;
			flag++;
		}
		if(action==DOWN){
			if(flag==-1){
				currentImg=heroDown[1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroDown[1];
				else{
					if(flag%2==0)
					currentImg=heroDown[2];
					else
					currentImg=heroDown[0];
				}
			System.out.println("move DOWN!");
			repaint();
			y++;
			flag++;
		}
		if(action==LEFT){
			if(flag==-1){
				currentImg=heroLeft[1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroLeft[1];
				else{
					if(flag%2==0)
					currentImg=heroLeft[2];
					else
					currentImg=heroLeft[0];
				}
			System.out.println("move LEFT!");
			repaint();
			x--;
			flag++;
		}
		if(action==RIGHT){
			if(flag==-1){
				currentImg=heroRight[1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroRight[1];
				else{
					if(flag%2==0)
					currentImg=heroRight[2];
					else
					currentImg=heroRight[0];
				}
			System.out.println("move RIGHT!");
			repaint();
			x++;
			flag++;
		}
		oldAction=action;
	}
}