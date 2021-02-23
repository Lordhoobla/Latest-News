import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.StringBuilder;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.lang.Thread;
import java.lang.String;
public class Main{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)throws Exception{
		setProgressBar();
		FileCreate.init();
		Thread.sleep(2000);
		progressBar.hide();
		System.exit(1);
	}
	/*Creates the info.txt file in the same directory
	   *CHANGE TO HTML WHEN PUTTING IN ECLIPSE
	   */
	protected static File info=new File("info.html");
	public static void create(){
	     try{
	       info.createNewFile();
	     }catch(IOException e){debug.append("no work create\n");}
	   }
	   /**Use this to actually write to the info.txt file. 
	    *NOTE: THIS METHOD CAN ONLY BE CALLED once
	    */
	public static void writeTo(String html){
	     try{
	       html="<!DOCTYPE html>\n<html>\n<body>\n"+html+"</body>\n</html>";
	       FileWriter fl=new FileWriter("info.html");
	       fl.write(html);
	       fl.close();
	     }catch(IOException e){debug.append("no work writeTo\n");}
	   }
	//holds the progress bar for the file
	private static JFrame progressBar=new JFrame();
	//finds and holds the icon for the bar
	private ImageIcon log=new javax.swing.ImageIcon(this.getClass().getResource("icon.png"));
	//initializes the progress bar
	protected static void setProgressBar(){
		progressBar.setSize(400,200);
		progressBar.setTitle("Loading");
		progressBar.setLocationRelativeTo(null);
		ImageIcon logo=new Main().log;
		progressBar.setIconImage(logo.getImage());
		progressBar.setResizable(false);
		progressBar.setBackground(Color.GRAY);
		progressBar.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		progressBar.setVisible(true);
	}
	protected static int percent;
	/*Updates the progress bar
	 * @param per - the percentage/100 that it's at
	 * @param load - what it's loading now
	 */
	protected static void progress(int per,String load,int loading){
		percent=per;
		Container c=progressBar.getContentPane();
		c.setLayout(new BorderLayout());
		Rect.x=Rect.y=0;Rect.w=400;Rect.l=200;
		Rect.x2=Rect.y2=50;Rect.w2=275;Rect.l2=30;
		Rect.x3=Rect.y3=55;Rect.w3=percent*265/100;Rect.l3=20;
		Rect.text=load;
		Rect.c=Color.DARK_GRAY;Rect.c2=Color.BLACK;Rect.c4=Color.WHITE;
		switch(loading){
			case 0:Rect.c3=Color.BLUE;break;
			case 1:Rect.c3=Color.RED;break;
			default:Rect.c3=Color.GREEN;
		}
		Rect r=new Rect();
		c.add(r);
		progressBar.setVisible(true);
	}
	//contains debug info
	protected static StringBuilder debug=new StringBuilder();
	/**
	 * @function :: prints the debug info while also making a new file "debug.txt" with the information
	 */
	protected static void printDebug(){
		System.out.println("DEBUG INFO:\n\n"+debug.toString());
		try{
			File f=new File("debug.txt");
			f.createNewFile();
			FileWriter fl=new FileWriter("debug.txt");
			fl.write(debug.toString());
			fl.close();
		}catch(Exception e){e.printStackTrace();}
	}
}
