import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.lang.StringBuilder;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class FileCreate {
	/*holds all of the keys for the links for the US links*/
	  protected static ArrayList<String> listUS=new ArrayList<String>();
	  /*holds all of the headlines with the links to them <headline><link>*/
	  protected static HashMap<String,String> links=new HashMap<String,String>();
	  /*contains all of the stories that are going to be used*/
	  protected static HashMap<String,StoryDets> stories=new HashMap<String,StoryDets>();
	  /*holds all of the web sources that will be used in the program*/
	  protected static ArrayList<String> webSources=new ArrayList<String>();
	  /**all you should need to do is run the init() method and it should handle the rest of what's going on in the program
	  *head method
	  */
	  public static void init(){
		    Collections.addAll(webSources,"https://www.cnn.com/","https://www.foxnews.com/","https://www.cbsnews.com/","https://www.nytimes.com/","https://abcnews.go.com/");
		    try{
		      for(int i=0;i<webSources.size();i++){
		        String url=collectHTML(webSources.get(i));
		        switch(i){
		          case 0:addLinksCNN(url);break;
		          case 1:addLinksFOX(url);break;
		          case 2:addLinksCBS(url);break;
		          case 3:addLinksNYT(url);break;
		          case 4:addLinksABC(url);break;
		        }
		      }
		      collectStoriesUS();
		    }catch(Exception e){System.err.println("no work init");}
		    System.out.println("Complete, check info.txt for information");
	  }
	  /*Creates the info.txt file in the same directory
	   *CHANGE TO HTML WHEN PUTTING IN ECLIPSE
	   */
	   protected static void create(){
	     try{
	       File info=new File("info.txt");
	       info.createNewFile();
	     }catch(IOException e){System.err.println("no work create");}
	   }
	   /**Use this to actually write to the info.txt file. 
	    *NOTE: THIS METHOD CAN ONLY BE CALLED once
	    */
	   protected static void writeTo(String html){
	     try{
	       FileWriter fl=new FileWriter("info.txt");
	       StringBuilder x=new StringBuilder(html);
	       //listUS.forEach(n->{x.append(links.get(n)+"\n");});
	       fl.write(x.toString());
	       fl.close();
	     }catch(IOException e){System.err.println("no work writeTo");}
	   }
	   /**This method will return the entire html coding of what's in the url parameter given
	    *String url - the url that you want to collect information from
	    */
	    protected static String collectHTML(String url){
	      try{
	        HttpClient client = HttpClient.newHttpClient();
	          HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
	          HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
	        return response.body();
	      }
	      catch(Exception e){System.err.println("Request error (check internet)");return "";}
	    }
	    /**This method will return the entire html coding of what's in the url parameter given
	    *String url - the url that you want to collect information from
	    */
	    protected static String collectHTMLStory(String url){
	      try{
	        URL u=new URL(url);
	        Scanner sc=new Scanner(u.openStream());
	        StringBuilder x=new StringBuilder();
	        while(sc.hasNextLine()){x.append(sc.nextLine());}
	        sc.close();
	        return x.toString();
	      }catch(Exception e){System.err.println("no work collectHTMLStory");return "";}
	    }
	    /*collects the initial html for CNN and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksCNN(String html){
	      html=html.substring(html.indexOf("{\"articleList")+16);
	      html=html.substring(0,html.indexOf("registryURL"));
	      int i=0;
	      try{
	        while(html.contains("uri\"")){
	          if(i==6){break;}
	          html=html.substring(html.indexOf("uri\":"));
	          String uri="https://cnn.com"+html.substring(html.indexOf(":\"")+2,html.indexOf(".html")+5);
	          if(uri.contains(".cnn")){
	            uri=uri.substring(0,uri.indexOf(".cnn")+4);
	          }
	        if(!html.contains("headline")){break;}
	          html=html.substring(html.indexOf("headline")+11);
	          String title=html.substring(0,html.indexOf("\"")).trim();
	          if(i==0){
	            title=title.substring(title.indexOf(">")+1,title.lastIndexOf("\\"));
	          }
	          while(title.contains("\\")){title=title.substring(0,title.indexOf("\\"))+title.substring(title.indexOf(">")+1);}
	          listUS.add(title);
	          links.put(title,uri);
	          i++;
	        }
	      }catch(Exception e){System.err.println("addLinksCNN no work");}
	    }
	    /*collects the initial html for FOX and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksFOX(String html){
	      html=html.substring(html.indexOf("kicker-text")+13);
	      html=html.substring(0,html.indexOf("sidebar-primary")-12);
	      int i=0;
	      while(html.contains("href=\"")){
	        if(i==6){break;}
	        html=html.substring(html.indexOf("href=\"")+6);
	        String uri=html.substring(0,html.indexOf("\""));
	        html=html.substring(html.indexOf(">")+1);
	        if(uri.contains("video.")){
	          html=html.substring(html.indexOf("href"));
	          html=html.substring(html.indexOf("\">")+2);
	        }
	        String title=html.substring(0,html.indexOf("<"));
	        title=title.replaceAll("&#x27;","'").trim();
	        if(!(title.isEmpty()||uri.isEmpty())){
	          listUS.add(title);
	          links.put(title,uri);
	          i--;
	        }
	        i++;
	      }
	    }
	    /*Collects the initial html for CBS and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksCBS(String html){
	      html=html.substring(html.indexOf("<!-- End I"));
	      for(int i=0;i<6;i++){
	        html=html.substring(html.indexOf("https"));
	        String uri=html.substring(0,html.indexOf("\"")).trim();
	        html=html.substring(html.indexOf("h4"));
	        html=html.substring(html.indexOf(">")+1);
	        String title=html.substring(0,html.indexOf("<")).trim();
	        listUS.add(title);
	        links.put(title,uri);
	      }
	    }
	    /*Collects the initial html for NYT and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksNYT(String html){
	      html=html.substring(html.indexOf("story-wrapper\"")+14);
	      html=html.substring(html.indexOf("https"));
	      String uri=html.substring(0,html.indexOf("\""));
	      html=html.substring(html.indexOf("<span>")+6);
	      String title=html.substring(0,html.indexOf("</span>"));
	      listUS.add(title);
	      links.put(title,uri);
	      for(int i=0;i<5;i++){
	        html=html.substring(html.indexOf("<span>")-150);
	        html=html.substring(html.indexOf("href=\"")+6);
	        uri="https://www.nytimes.com"+html.substring(0,html.indexOf("\""));
	        html=html.substring(html.indexOf("<span>")+6);
	        title=html.substring(0,html.indexOf("<"));
	        listUS.add(title);
	        links.put(title,uri);
	      }
	    }
	    /*Collects the initial html for ABC and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksABC(String html){
	      for(int i=0;i<5;i++){
	        html=html.substring(html.indexOf("caption-wrapper\">"));
	        html=html.substring(html.indexOf("https"));
	        String uri=html.substring(0,html.indexOf("\"")).trim();
	        html=html.substring(html.indexOf(">")+1);
	        String title=html.substring(0,html.indexOf("<")).trim();
	        listUS.add(title);
	        links.put(title,uri);
	      }
	    }
	    /*Collects the stories from the US stations and adds them to the stories HashMap*/
	    protected static void collectStoriesUS(){
	      for(String tmp:listUS){
	        if(links.get(tmp).contains(".cnn")){collectStoryCNN(collectHTMLStory(links.get(tmp)),links.get(tmp),tmp);}
	        if(links.get(tmp).contains(".fox")){collectStoryFOX(collectHTMLStory(links.get(tmp)),links.get(tmp),tmp);}
	        if(links.get(tmp).contains("cbs")) {collectStoryCBS(collectHTMLStory(links.get(tmp)),links.get(tmp),tmp);}
	      }
	    }
	    /*adds the story for CNN to the stories hashmap*/
	    protected static void collectStoryCNN(String html,String uri,String title){
	      try{
	        if(uri.contains("/videos/")){
	          html=html.substring(html.indexOf("--inline\">")+10);
	          stories.put(title,new StoryDets(uri,"US",html.substring(0,html.indexOf("</div")).replaceAll("<[^>]*>", ""),title));
	        }else{
	          html=html.substring(html.indexOf("\"/profiles")+10);
	          String desc="";
	          for(int i=0;i<2;i++){
	            html=html.substring(html.indexOf("paragraph\""));
	            html=html.substring(html.indexOf(">")+1);
	            desc+=html.substring(0,html.indexOf("</div")).replaceAll("<[^>]*>", "")+"\n";
	          }
	          stories.put(title,new StoryDets(uri,"US",desc,title));
	        }
	      }catch(Exception e){System.out.println(uri);System.err.println("collectStoryCNN no work");}
	    }
	    /*adds the story for FOX to the stories hashmap*/
	    protected static void collectStoryFOX(String html,String uri,String title){
	    	try{
	    		String desc="";
	    		if(uri.contains("video.")){
	    			html=html.substring(html.indexOf(":description"));
	    			html=html.substring(html.indexOf("=")+2);
	    			desc=html.substring(0,html.indexOf("\"")).replaceAll("â€˜","'").replaceAll("â€™","'");
	    			stories.put(title,new StoryDets(uri,"US",desc,title));
	    		}else {
	    			html=html.substring(html.indexOf("description"));
	    			html=html.substring(html.indexOf("content=\"")+9);
	    			desc=html.substring(0,html.indexOf("\"")).replaceAll("&#x27;","'").replaceAll("&quot;","").replaceAll("â€˜","'").replaceAll("â€™","'").replaceAll("â€œ","\"")+"\n";
	    			for(int i=0;i<3;i++){
	    				html=html.substring(html.indexOf("<p>")+4);
	    				desc+=html.substring(html.indexOf("</p>")).replaceAll("<[^>]*>","");
	    			}
	    			stories.put(title,new StoryDets(uri,"US",desc,title));
	    		}
	    	}catch(Exception e){System.out.println(uri);System.err.println("collectStoryFOX no work");}
	    }
	    /*adds the story for CBS to the stories hashmap*/
	    protected static void collectStoryCBS(String html,String uri,String title){
	    	try{
	    		String desc="";
	    		if(uri.contains("/video/")){
	    			html=html.substring(html.indexOf("html=\"")+5);
	    			html=html.substring(html.indexOf(">")+1);
	    			desc+=html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>", "");
	    			stories.put(title,new StoryDets(uri,"US",desc,title));
	    		}else{
	    			for(int i=0;i<3;i++){
	    				html=html.substring(html.indexOf("<p>")+3);
	    				desc+=html.substring(0,html.indexOf("</p>")).replaceAll("<[^>]*>","").replaceAll("&nbsp;","").replaceAll("&ndash;","-").replaceAll("&mdash;","--");
	    				if(desc.charAt(desc.length()-1)=='"'){desc=desc.substring(0,desc.length()-1);}
	    			}
	    			stories.put(title,new StoryDets(uri,"US",desc,title));
	    		}
	    	}catch(Exception e){System.out.println(uri);System.err.println("collectStoryCBS no work");}
	    }
}
