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
	Image currentImg;//��ǰͼƬ
	Image[][] heroImg=new Image[4][3];//��ά�����ͼƬ
	int x,y;//�����������Ҽ�����
	int flag;//�ж��˶�����
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

			//����ѭ����ȡͼƬ
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
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

	if(action==UP){

	    currentImg=heroImg[0][1];
		if(flag%2==0)
			currentImg=heroImg[0][0];
		else
			currentImg=heroImg[0][2];
		System.out.println("������");
		y--;
		repaint();
		flag++;
		}
	if(action==DOWN){
	    currentImg=heroImg[1][1];
		if(flag%2==0)
			currentImg=heroImg[1][0];
		else 
			currentImg=heroImg[1][2];
		System.out.println("������");
		y++;
		repaint();
		flag++;
		}
	if(action==LEFT){
	
	    currentImg=heroImg[2][1];
		if(flag%2==0)
			currentImg=heroImg[2][0];
		else 
			currentImg=heroImg[2][2];
		System.out.println("������");
		x--;
		repaint();
		flag++;
		}
	if(action==RIGHT){
	
	    currentImg=heroImg[3][1];
		if(flag%2==0)
			currentImg=heroImg[3][0];
		else 
			currentImg=heroImg[3][2];
		System.out.println("������");
		x++;
		repaint();
		flag++;
		}
	}
}
