import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.StringBuilder;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Main{
	@SuppressWarnings("deprecation")
	public static void main(String[] args)throws Exception{
		setProgressBar();
		FileCreate.init();
		progressBar.hide();
	}
	/*Creates the info.txt file in the same directory
	   *CHANGE TO HTML WHEN PUTTING IN ECLIPSE
	   */
	public static void create(){
	     try{
	       File info=new File("info.txt");
	       info.createNewFile();
	     }catch(IOException e){System.err.println("no work create");}
	   }
	   /**Use this to actually write to the info.txt file. 
	    *NOTE: THIS METHOD CAN ONLY BE CALLED once
	    */
	public static void writeTo(String html){
	     try{
	       FileWriter fl=new FileWriter("info.txt");
	       StringBuilder x=new StringBuilder(html);
	       //listUS.forEach(n->{x.append(links.get(n)+"\n");});
	       fl.write(x.toString());
	       fl.close();
	     }catch(IOException e){System.err.println("no work writeTo");}
	   }
	//holds the progress bar for the file
	private static JFrame progressBar=new JFrame();
	//initializes the progress bar
	protected static void setProgressBar(){
		progressBar.setSize(400,200);
		progressBar.setTitle("Loading");
		progressBar.setLocationRelativeTo(null);
		ImageIcon logo=new ImageIcon("icon.png");
		progressBar.setIconImage(logo.getImage());
		progressBar.setResizable(false);
		progressBar.setBackground(Color.GRAY);
		progressBar.setVisible(true);
	}
	/*Updates the progress bar
	 * @param per - the percentage/100 that it's at
	 * @param load - what it's loading now
	 */
	protected static void progress(int per,String load,boolean loading){
		Container c=progressBar.getContentPane();
		c.setLayout(new BorderLayout());
		Rect.x=Rect.y=0;Rect.w=400;Rect.l=200;
		Rect.x2=Rect.y2=50;Rect.w2=275;Rect.l2=30;
		Rect.x3=Rect.y3=55;Rect.w3=per*270/100;Rect.l3=20;
		Rect.text="Loading: "+load;
		Rect.c=Color.DARK_GRAY;Rect.c2=Color.BLACK;Rect.c4=Color.WHITE;
		if(loading){Rect.c3=Color.green;}
		else{Rect.c3=Color.BLUE;}
		Rect r=new Rect();
		c.add(r);
		progressBar.setVisible(true);
	}
		//variables for translate
	 private static final String CLIENT_ID="FREE_TRIAL_ACCOUNT",CLIENT_SECRET="PUBLIC_SECRET",ENDPOINT="http://api.whatsmate.net/v1/translation/translate";
		/*
		 * Translates the text into the language given
		 * @param fromLang - the language that it's coming from
		 * @param toLang - the language that it's converting to
		 * @param text - the text being translated
		 * @return the translated text
		 * NOTE: en-english :: es-spanish :: iw-hebrew :: fr-french :: ru-russian :: de-german :: it-italian :: ko-korean :: ja-japanese :: gu-gujarati :: bn-bengali :: hi-hindi :: pt-portuguese
		 */
	public static String translate(String fromLang, String toLang, String text) throws Exception{
		  String jsonPayload=new StringBuilder().append("{").append("\"fromLang\":\"").append(fromLang).append("\",").append("\"toLang\":\"").append(toLang).append("\",").append("\"text\":\"").append(text).append("\"").append("}").toString();
	      URL url=new URL(ENDPOINT);
		  HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		  conn.setDoOutput(true);
		  conn.setRequestMethod("POST");
		  conn.setRequestProperty("X-WM-CLIENT-ID",CLIENT_ID);
		  conn.setRequestProperty("X-WM-CLIENT-SECRET",CLIENT_SECRET);
		  conn.setRequestProperty("Content-Type","application/json");
	      OutputStream os=conn.getOutputStream();
		  os.write(jsonPayload.getBytes());
		  os.flush();
		  os.close();
	      int statusCode=conn.getResponseCode();
		  BufferedReader br=new BufferedReader(new InputStreamReader((statusCode==200)?conn.getInputStream():conn.getErrorStream()));
		  String output,ret="";
		  while((output=br.readLine())!=null){ret+=output;}conn.disconnect();
		  if(ret.contains("error_message")){return "<";}
	      return ret;
		}
}
