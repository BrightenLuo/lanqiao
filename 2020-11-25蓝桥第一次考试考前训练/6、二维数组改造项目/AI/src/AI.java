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
	Image[][] heroMove=new Image[4][3];
	int x,y;//坐标
	int flag;//左右手脚互换标志
	int oldAction;//记录上一个方向
	int action;//转范围为成员变量
	public MainCanvas(){
		try{
			/*			
			i=0:UP			j=0:leftHand
			i=1:DOWN		j=1:stand
			i=2:LEFT		j=2:rightHand
			i=3:RIGHT
			*/

			for(int i=0;i<4;i++)
				for(int j=0;j<3;j++)
					heroMove[i][j]=Image.createImage("/sayo"+i+j+".png");
			currentImg=heroMove[1][1];
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
				currentImg=heroMove[0][1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroMove[0][1];
				else{
					if(flag%2==0)
					currentImg=heroMove[0][0];
					else
					currentImg=heroMove[0][2];
				}
			System.out.println("move UP!");
			repaint();
			y--;
			flag++;
		}
		if(action==DOWN){
			if(flag==-1){
				currentImg=heroMove[1][1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroMove[1][1];
				else{
					if(flag%2==0)
					currentImg=heroMove[1][0];
					else
					currentImg=heroMove[1][2];
				}
			System.out.println("move DOWN!");
			repaint();
			y++;
			flag++;
		}
		if(action==LEFT){
			if(flag==-1){
				currentImg=heroMove[2][1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroMove[2][1];
				else{
					if(flag%2==0)
					currentImg=heroMove[2][0];
					else
					currentImg=heroMove[2][2];
				}
			System.out.println("move LEFT!");
			repaint();
			x--;
			flag++;
		}
		if(action==RIGHT){
			if(flag==-1){
				currentImg=heroMove[3][1];
				flag++;
			}
			else if(action!=oldAction)
				currentImg=heroMove[3][1];
				else{
					if(flag%2==0)
					currentImg=heroMove[3][0];
					else
					currentImg=heroMove[3][2];
				}
			System.out.println("move RIGHT!");
			repaint();
			x++;
			flag++;
		}
		oldAction=action;
	}
}