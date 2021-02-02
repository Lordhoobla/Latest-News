import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
public class FileCreate {
	  /*holds all of the keys for the US links*/
	  protected static ArrayList<String> listUS=new ArrayList<String>();
	  /*holds all of the keys for the UK links*/
	  protected static ArrayList<String> listUK=new ArrayList<String>();
	  /*holds all of the keys for the links for the Canadian links*/
	  protected static ArrayList<String> listCA=new ArrayList<String>();
	  /*holds all of the headlines with the links to them <headline><link>*/
	  protected static HashMap<String,String> links=new HashMap<String,String>();
	  /*holds all of the web sources that will be used in the program*/
	  protected static ArrayList<String> webSources=new ArrayList<String>();
	  /**all you should need to do is run the init() method and it should handle the rest of what's going on in the program
	  *head method
	  */
	  public static void init(){
		    Collections.addAll(webSources,
		    		"https://www.cnn.com/",
		    		"https://www.foxnews.com/",
		    		"https://www.cbsnews.com/",
		    		"https://www.nytimes.com/",
		    		"https://abcnews.go.com/",
		    		"https://www.bbc.com/",
		    		"https://www.telegraph.co.uk/",
		    		"https://www.theguardian.com/uk",
		    		"https://www.dailymail.co.uk/home/index.html",
		    		"https://www.mirror.co.uk/",
		    		"https://www.cbc.ca/",
		    		"https://www.ctvnews.ca/",
		    		"https://www.thestar.com/news/canada.html");
		    try{
		      for(int i=0;i<webSources.size();i++){
		        String url=collectHTML(webSources.get(i));
		        switch(i){
		          case 0:addLinksCNN(url);break;
		          case 1:addLinksFOX(url);break;
		          case 2:addLinksCBS(url);break;
		          case 3:addLinksNYT(url);break;
		          case 4:addLinksABC(url);break;
		          //change the loading bar for case 5
		          case 5:addLinksBBC(url);break;
		          case 6:addLinksTEL(url);break;
		          case 7:addLinksGUA(url);break;
		          case 8:addLinksTDM(url);break;
		          case 9:addLinksTMR(url);break;
		          //change the loading bar for case 10
		          case 10:addLinksCBC(url);break;
		          case 11:addLinksCTV(url);break;
		          case 12:addLinksTorStar(url);break;
		        }
		      }
		      //links.forEach((k,v)->System.out.println(k+"\n"+v+"\n"));
		      //listCA.forEach(n->System.out.println(n+"\n"+links.get(n)+"\n"));
		    }catch(Exception e){System.err.println("no work init");}
		    System.out.println("Complete, check info.txt for information");
	  }
	   /**This method will return the entire html coding of what's in the url parameter given
	    *String url - the url that you want to collect information from
	    */
	    protected static String collectHTML(String url){
	      try{
	        HttpClient client=HttpClient.newHttpClient();
	        HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
	        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
	        return response.body();
	      }
	      catch(Exception e){System.err.println("Request error (check internet)");return "";}
	    }
	    /*
	     * NEWS FROM US
	     */
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
	          title=title.replaceAll("<[^>]*>","");
	          listUS.add(title);
	          links.put(title,uri);
	          i++;
	        }
	      }catch(Exception e){System.err.println("addLinksCNN no work");}
	    }
	    /*collects the initial html for FOX and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksFOX(String html){
	    	try{
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
	    	}catch(Exception e){System.err.println("addLinksFOX no work");}
	    }
	    /*Collects the initial html for CBS and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksCBS(String html){
	    	try{
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
	    	}catch(Exception e){System.err.println("addLinksCBS no work");}
	    }
	    /*Collects the initial html for NYT and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksNYT(String html){
	    	try{
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
	    	}catch(Exception e){System.err.println("addLinksNYT no work");}
	    }
	    /*Collects the initial html for ABC and adds to the list and links the corresponding titles and links for the titles*/
	    protected static void addLinksABC(String html){
	    	try{
		      for(int i=0;i<5;i++){
		        html=html.substring(html.indexOf("caption-wrapper\">"));
		        html=html.substring(html.indexOf("https"));
		        String uri=html.substring(0,html.indexOf("\"")).trim();
		        html=html.substring(html.indexOf(">")+1);
		        String title=html.substring(0,html.indexOf("<")).trim();
		        if(title.isEmpty()){i--;
		        }else{
		        	listUS.add(title);
		        	links.put(title,uri);}
		      }
	    	}catch(Exception e){System.err.println("addLinksABC no work");}
	    }
	    /*
	     * NEWS FROM UK
	     */
	    /*Collects the initial html for BBC and adds to the UKList and links to the corresponding titles and links for the titles*/
	    protected static void addLinksBBC(String html){
	    	try{
		    	html=html.substring(html.indexOf("</h1>"));
		    	for(int i=0;i<5;i++){
		    		 html=html.substring(html.indexOf("aria-hidden")-75);
		    		 html=html.substring(html.indexOf("href")+6);
		    		 String uri=html.substring(0,html.indexOf("\""));
		    		 if(!uri.contains("https")){uri="https://www.bbc.com"+uri;}
		    		 html=html.substring(html.indexOf(">")+2);
		    		 String title=html.substring(0,html.indexOf("\"")).replaceAll("<a class=","").replaceAll("<p class=","").replaceAll("<[^>]*>","").trim();
		    		 html=html.substring(html.indexOf("<"));
		    		 listUK.add(title);
		    		 links.put(title,uri);
		    	}
	    	}catch(Exception e){System.err.println("addLinksBBC no work");}
	    }
	    /*Collects the initial html for Telegram and adds to the UKList and links to the corresponding titles and links for the titles*/
	    protected static void addLinksTEL(String html){
	    	try{
		    	html=html.substring(html.indexOf("<body"));
		    	html=html.substring(html.indexOf("<article"));
		    	for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf("href=")+6);
		    		String uri="https://www.telegraph.co.uk"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf("<span"));
		    		html=html.substring(html.indexOf(">")+1);
		    		String title=html.substring(0,html.indexOf("</a>")).replaceAll("<[^>]*>","").replaceAll("\"","").replaceAll("&#39;","'").replaceAll("\n"," ").trim();
		    		title=title.replaceAll("  "," ");
		    		html=html.substring(html.indexOf("</article")+10);
		    		listUK.add(title);
		    		links.put(title,uri);
		    	}
	    	}catch(Exception e){System.err.println("addLinksTEL no work");}
	    }
	    /*Collects the initial html for the Guardian and adds to the UKList and links to the corresponding titles and links for the titles*/
	    protected static void addLinksGUA(String html){
	    	try{
		    	html=html.substring(html.indexOf("</header>"));
		    	html=html.substring(html.indexOf("<h3"));
		    	html=html.substring(html.indexOf("<a"));
		    	html=html.substring(html.indexOf("href")+6);
		    	String uri=html.substring(0,html.indexOf("\""));
		    	html=html.substring(html.indexOf(">")+1);
		    	String title=html.substring(0,html.indexOf("</a>")).replaceAll("<[^>]*>","").replaceAll("\"","").replaceAll("&#39;","'").replaceAll("\n"," ").trim();
		    	listUK.add(title);
		    	links.put(title,uri);
		    	for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("href=")+6);
		    		uri=html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf(">")+1);
		    		title=html.substring(0,html.indexOf("</a>")).replaceAll("<[^>]*>","").replaceAll("\"","").replaceAll("&#39;","'").replaceAll("\n"," ").trim();
		    		if(listUK.contains(title)){i--;}else{listUK.add(title);links.put(title,uri);}
		    	}
	    	}catch(Exception e){System.err.println("addLinksGUA no work");}
	    }
	    /*Collects the initial html for The Daily mail and adds to the UKList and links to the corresponding titles and links for the titles*/
	    protected static void addLinksTDM(String html){
	    	try{
		    	html=html.substring(html.indexOf("\"content\""));
		    	for(int i=0;i<6;i++){
		    		html=html.substring(html.indexOf("<h2"));
		    		html=html.substring(html.indexOf("href")+6);
		    		String uri="https://www.dailymail.co.uk"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf(">")+1);
		    		String title=html.substring(0,html.indexOf("<"));
		    		html=html.substring(html.indexOf("<div"));
		    		listUK.add(title);
		    		links.put(title,uri);
		    	}
	    	}catch(Exception e){System.err.println("addLinksTDM no work");}
	    }
	    /*Collects the initial html for The Daily Mirror and adds to the UKList and links to the corresponding titles and links for the titles*/
	    protected static void addLinksTMR(String html){
	    	try{
		    	html=html.substring(html.indexOf("<main"));
		    	for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("<a class"));
		    		html=html.substring(html.indexOf("href")+6);
		    		String uri=html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf(">")+1);
		    		String title=html.substring(0,html.indexOf("<"));
		    		if(title.isEmpty()||!title.contains(" ")||links.containsValue(uri)||uri.contains("all-about")){
		    			i--;
		    		}else{
		    			listUK.add(title);
		    			links.put(title,uri);
		    		}
		    	}
	    	}catch(Exception e){System.err.println("addLinksTMR no work");}
	    }
	    /*
	     * NEWS FROM CANADA
	     */
	    /*Collects the initial html for the CBC and adds to the listCA and links to the corresponding titles and links for the titles*/
	    protected static void addLinksCBC(String html){
	    	try{
		    	html=html.substring(html.indexOf("<main"));
		    	for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("<a class"));
		    		html=html.substring(html.indexOf("href")+6);
		    		String uri="https://www.cbc.ca"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf(">")+1);
		    		String title=html.substring(0,html.indexOf("<")).replaceAll("&amp;","&").replaceAll("&#x27;","'");
		    		html=html.substring(html.indexOf("</a"));
		    		if(uri.length()<30){i--;
		    		}else{
		    			listCA.add(title);
		    			links.put(title,uri);}
		    	}
	    	}catch(Exception e){System.err.println("addLinksCBC no work");}
	    }
	    /*Collects the initial html for the CTV and adds to the listCA and links to the corresponding titles and links for the titles*/
	    protected static void addLinksCTV(String html){
	    	try{
		    	html=html.substring(html.indexOf("<body"));
		    	for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf("href")+6);
		    		String uri=html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf(">")+1);
		    		String title=html.substring(0,html.indexOf("<")).replaceAll("&#39;","'").trim();
		    		html=html.substring(html.indexOf("<article"));
		    		if(!title.contains(" ")){i--;
		    		}else{
		    			listCA.add(title);
		    			links.put(title,uri);
		    		}
		    	}
	    	}catch(Exception e){System.err.println("addLinksCTV no work");}
	    }
	    /*Collects the initial html for the Toronto Star and adds to the listCA and links to the corresponding titles and links for the titles*/
	    protected static void addLinksTorStar(String html){
	    	try{
		    	html=html.substring(html.indexOf("</header"));
		    	for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("<a")+9);
		    		String uri="https://www.thestar.com"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf(">")+1);
		    		String title=html.substring(0,html.indexOf("</h3>")).replaceAll("<[^>]*>","").trim();
		    		if(title.isEmpty()||!uri.endsWith("html")){i--;
		    		}else{
		    			listCA.add(title);
		    			links.put(title,uri);
		    		}
		    	}
	    	}catch(Exception e){System.err.println("addLinksTorStar no work");}
	    }
}
