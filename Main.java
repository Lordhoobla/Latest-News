import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Main{
	public static void main(String[] args) {
		FileCreate.init();
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
}
