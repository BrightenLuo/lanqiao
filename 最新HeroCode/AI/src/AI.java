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

	//自定义方法
	public void heroAction(int direction){
		if((flag==-1)&&(direction!=1))	//第一次转向，并判断它是不是在初始方向下移动
			currentImg=heroMove[direction][1];
		else if(action!=oldAction)
			currentImg=heroMove[direction][1];
			else{
				if(flag%2==0)
				currentImg=heroMove[direction][0];
				else
				currentImg=heroMove[direction][2];
			}
		switch(direction){
			case 0:System.out.println("move UP!");y--;break;
			case 1:System.out.println("move DOWN!");y++;break;
			case 2:System.out.println("move LEFT!");x--;break;
			case 3:System.out.println("move RIGHT!");x++;break;
		}
		repaint();
		flag++;
	}
	public void keyPressed(int keyCode){
		action=getGameAction(keyCode);//接收方向按键
		if(oldAction==-1)	//第一次赋予oldAction值
			oldAction=action;
		if(action==UP)
			heroAction(0);//调用方法
		if(action==DOWN)
			heroAction(1);
		if(action==LEFT)
			heroAction(2);
		if(action==RIGHT)
			heroAction(3);
		oldAction=action;//将现动作变为上一个动作
	}
}