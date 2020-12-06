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
	int flag;//判断运动动作
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
		currentImg=heroImg[direction][1];
		if(flag%2==0)
			currentImg=heroImg[direction][0];
		else
			currentImg=heroImg[direction][2];
		repaint();
		flag++;
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
	    if(action==UP){
		   imageMove(0);//调用方法
		   y--;
		}
	    if(action==DOWN){
		   imageMove(1);
		   y++;
		}
	    if(action==LEFT){
		   imageMove(2);
		   x--;
		}
	    if(action==RIGHT){
		   imageMove(3);
		   x++;
		}
	   
	}
}
