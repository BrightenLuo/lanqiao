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
	Image currentImg;//当前图片
	Image[][] heroImg=new Image[4][3];//二维数组存图片
	int x,y;//控制上下左右即坐标
	int flag;//判断左右手的先后动作
	int action;//接收按键动作
	int oldAction;//存储上一个动作，用于判断转向时先立正
	int first;//判断是否第一次执行转向
	public MainCanvas(){
		try{
			/*
			i means:
			0:UP
			1:DOWN
			2:LEFT
			3:RIGHT
			*/

			/*
			j means:
			0:left hand
			1:stand
			2:right hand
			*/

			//二重循环读取图片
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
					}
			}

		     currentImg=heroImg[1][1];
		     x=120;
		     y=100;
			 flag=0;
			 oldAction=-1;
			 first=-1;
			 
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

	//自定义方法
	public void imageMove(int direction){
		if(first==-1){     //第一次转向解决方案
		currentImg=heroImg[direction][1];
		first++;
		}
		else{
			if(action!=oldAction)    //判断是否转向了，是的话先立正
				currentImg=heroImg[direction][1];
			else{
				if(flag%2==0)
				currentImg=heroImg[direction][0];
				else
				currentImg=heroImg[direction][2];
				}
		}
			switch(direction){
				case 0: System.out.println("UP");y--;break;
				case 1: System.out.println("DOWN");y++;break;
				case 2: System.out.println("LEFT");x--;break;
				case 3: System.out.println("RIGHT");x++;break;
			}
		repaint();
		flag++;
	}

	public void keyPressed(int keyCode){
		action=getGameAction(keyCode);
		if(oldAction==-1)
			oldAction=action;//第一次保存上一个动作
	    if(action==UP)
		   imageMove(0);//调用方法
	    if(action==DOWN)
		   imageMove(1);
	    if(action==LEFT)
		   imageMove(2);
	    if(action==RIGHT)
		   imageMove(3);
	    oldAction=action;//把现动作变为旧动作
	}
}
