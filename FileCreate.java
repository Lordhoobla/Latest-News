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
	  /*holds all of the keys for the Canadian links*/
	  protected static ArrayList<String> listCA=new ArrayList<String>();
	  /*holds all of the keys for the New Zealand/Australian links*/
	  protected static ArrayList<String> listNZ=new ArrayList<String>();
	  /*holds all of the keys for the French links*/
	  protected static ArrayList<String> listFR=new ArrayList<String>();
	  /*holds all of the keys for the Israeli links*/
	  protected static ArrayList<String> listIL=new ArrayList<String>();
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
		    		"https://www.thestar.com/news/canada.html",
		    		"https://financialpost.com",
		    		"https://nationalpost.com/category/news/canada/",
		    		"https://www.stuff.co.nz/",
		    		"http://www.thecivilian.co.nz/",
		    		"https://www.9news.com.au/",
		    		"https://www.smh.com.au/",
		    		"https://www.theage.com.au/",
		    		"https://www.centre-presse.fr/",
		    		"https://www.clicanoo.re/",
		    		"https://www.lemonde.fr/",
		    		"https://www.francesoir.fr/",
		    		"https://www.estrepublicain.fr/",
		    		"https://www.timesofisrael.com/",
		    		"https://en.globes.co.il/en/",
		    		"https://www.jpost.com/",
		    		"https://www.haaretz.com/",
		    		"https://israelinewslive.org/");
		    try{
		    	String country="United States";
		      for(int i=0;i<webSources.size();i++){
		        String url=collectHTML(webSources.get(i));
		        Main.progress(i*100/webSources.size(),country,true);
		        switch(i){
		          case 0:addLinksCNN(url);break;
		          case 1:addLinksFOX(url);break;
		          case 2:addLinksCBS(url);break;
		          case 3:addLinksNYT(url);break;
		          case 4:addLinksABC(url);country="United Kingdom";break;
		          //UK
		          case 5:addLinksBBC(url);break;
		          case 6:addLinksTEL(url);break;
		          case 7:addLinksGUA(url);break;
		          case 8:addLinksTDM(url);break;
		          case 9:addLinksTMR(url);country="Canada";break;
		          //CA
		          case 10:addLinksCBC(url);break;
		          case 11:addLinksCTV(url);break;
		          case 12:addLinksTorStar(url);break;
		          case 13:addLinksFinPost(url);break;
		          case 14:addLinksNatPost(url);country="New Zealand/Australia";break;
		          //NZ/AU
		          case 15:addLinksSTU(url);break;
		          case 16:addLinksTCV(url);break;
		          case 17:addLinksNNews(url);break;
		          case 18:addLinksSMH(url);break;
		          case 19:addLinksAGE(url);country="France";break;
		          //FR
		          case 20:addLinksCentPre(url);break;
		          case 21:addLinksClic(url);break;
		          case 22:addLinksLeM(url);break;
		          case 23:addLinksFrSo(url);break;
		          case 24:addLinksESTR(url);country="Israel";break;
		          //IS
		          case 25:addLinksTOI(url);break;
		          case 26:addLinksGLO(url);break;
		          case 27:addLinksJPOst(url);break;
		          case 28:addLinksHAAre(url);break;
		          case 29:addLinksISRNews(url);break;
		        }
		      }
		      //addLinksTOI(collectHTML(webSources.get(25)));
		      Main.progress(100,"Setting up feed",false);
		      links.forEach((k,v)->System.out.println(k+"\n"+v+"\n"));
		      //listIL.forEach(n->System.out.println(n+"\n"+links.get(n)+"\n"));
		    }catch(Exception e){System.err.println("no work init");}
		    System.out.println("Complete, check info.txt for information");
	  }
	   /**This method will return the entire html coding of what's in the url parameter given
	    *String url - the url that you want to collect information from
	    */
	    private static String collectHTML(String url){
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
	        while(title.contains("strong>")){title=title.substring(0,title.indexOf("\\"))+title.substring(title.indexOf(">")+1);}
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
		    	for(int i=0;i<6;i++){
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
		    	for(int i=0;i<7;i++){
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
		    	for(int i=0;i<6;i++){
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
	    /*Collects the initial html for the Financial Post and adds to the listCA and links to the corresponding titles and links for the titles*/
	    protected static void addLinksFinPost(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		html=html.substring(html.indexOf("<article")+2);
	    		html=html.substring(html.indexOf("<article"));
	    		for(int i=0;i<6;i++){
	    			html=html.substring(html.indexOf("<h3")-150);
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://financialpost.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h3")).replaceAll("<[^>]*>","").trim();
	    			html=html.substring(html.indexOf("<article"));
	    			listCA.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksFinPost no work");}
	    }
	    /*Collects the initial html for the National Post and adds to the listCA and links to the corresponding titles and links for the titles*/
	    protected static void addLinksNatPost(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		html=html.substring(html.indexOf("<h2")-150);
	    		html=html.substring(html.indexOf("href")+6);
	    		String uri="https://nationalpost.com"+html.substring(0,html.indexOf("\""));
	    		html=html.substring(html.indexOf("<h2"));
	    		html=html.substring(html.indexOf(">")+1);
	    		String title=html.substring(0,html.indexOf("</h2")).replaceAll("<[^>]*>","").trim();
	    		html=html.substring(html.indexOf("<article"));
	    		listCA.add(title);
	    		links.put(title,uri);
	    		for(int i=0;i<7;i++){
	    			html=html.substring(html.indexOf("<h3")-150);
		    		html=html.substring(html.indexOf("href")+6);
		    		uri="https://nationalpost.com"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf(">")+1);
		    		title=html.substring(0,html.indexOf("</h3")).replaceAll("<[^>]*>","").trim();
		    		listCA.add(title);
		    		links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksNatPost no work");}
	    }
	    /*
	     * NEWS FROM AUSTRALIA/NEW ZEALAND
	     */
	    /*Collects the initial html for the Stuff.co.nz and adds to the listNZ and links to the corresponding titles and links for the titles*/
	    protected static void addLinksSTU(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a _ngcontent"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.stuff.co.nz"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h3")).replaceAll("<[^>]*>","").trim();
	    			html=html.substring(html.indexOf("</article"));
	    			listNZ.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksSTU no work");}
	    }
	    /*Collects the initial html for The Civilian and adds to the listNZ and links to the corresponding titles and links for the titles*/
	    protected static void addLinksTCV(String html){
	    	try{
	    		String uri,title;
	    		html=html.substring(html.indexOf("<tr"));
	    		for(int i=0;i<2;i++){
	    			html=html.substring(html.indexOf("<a")+9);
	    			uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h2")+4);
	    			title=html.substring(0,html.indexOf("<"));
	    			listNZ.add(title);
	    			links.put(title,uri);
	    		}
	    		for(int i=0;i<3;i++){
	    			html=html.substring(html.indexOf("post-content"));
	    			html=html.substring(html.indexOf("<a")+9);
	    			uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			title=html.substring(0,html.indexOf("<"));
	    			html=html.substring(html.indexOf("class"));
	    			if(title.isEmpty()){i--;
	    			}else{
	    				listNZ.add(title);
	    				links.put(title,uri);}
	    		}
	    	}catch(Exception e){System.err.println("addLinksTCV no work");}
	    }
	    /*Collects the initial html for 9news and adds to the listNZ and links to the corresponding titles and links for the titles*/
	    protected static void addLinksNNews(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"content\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h")).replaceAll("<[^>]*>","").replaceAll("&#x27;","'");
	    			html=html.substring(html.indexOf("</article"));
	    			listNZ.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksNNews no work");}
	    }
	    /*Collects the initial html for The Sydney Morning Herald and adds to the listNZ and links to the corresponding titles and links for the titles*/
	    protected static void addLinksSMH(String html){
	    	try{
	    		html=html.substring(html.indexOf("<section"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.smh.com.au"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("<"));
	    			html=html.substring(html.indexOf("</h3"));
	    			if(title.length()<30){
	    				i--;
	    			}else{
	    				listNZ.add(title);
	    				links.put(title,uri);}
	    		}
	    	}catch(Exception e){System.err.println("addLinksSMH no work");}
	    }
	    /*Collects the initial html for the AGE and adds to the listNZ and links to the corresponding titles and links for the titles*/
	    protected static void addLinksAGE(String html){
	    	try{
	    		html=html.substring(html.indexOf("<section"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.theage.com.au"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("<"));
	    			html=html.substring(html.indexOf("</h3"));
	    			if(title.length()<30){
	    				i--;
	    			}else{
	    				listNZ.add(title);
	    				links.put(title,uri);}
	    		}
	    	}catch(Exception e){System.err.println("addLinksAGE no work");}
	    }
	    /*
	     * NEWS FROM FRANCE
	     */
	    /*Collects the initial html for the Centre-press and adds to the listFR and links to the corresponding titles and links for the titles*/
	    protected static void addLinksCentPre(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("titre"));
	    			html=html.substring(html.indexOf("a href")+8);
	    			String uri="https://www.centre-presse.fr"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","");
	    			if(!Main.translate("fr","en",title).contains("<")){title=Main.translate("fr","en",title);}
	    			listFR.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksCentPre no work");}
	    }
	    /*Collects the initial html for the Clicacoo and adds to the listFR and links to the corresponding titles and links for the titles*/
	    protected static void addLinksClic(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
		    	html=html.substring(html.indexOf("<h1"));
		    	html=html.substring(html.indexOf("href")+6);
		    	String uri="https://www.clicanoo.re"+html.substring(0,html.indexOf("'"));
		    	html=html.substring(html.indexOf(">")+1);
		    	String title=html.substring(0,html.indexOf("</")).replaceAll("&#039;","'").replaceAll("&quot;","\"");
		    	if(!Main.translate("fr","en",title).contains("<")){title=Main.translate("fr","en",title);}
		    	listFR.add(title);
		    	links.put(title,uri);
		    	for(int i=0;i<5;i++){
			    	html=html.substring(html.indexOf("<h3"));
			    	html=html.substring(html.indexOf("href")+6);
			    	uri="https://www.clicanoo.re"+html.substring(0,html.indexOf("'"));
			    	html=html.substring(html.indexOf(">")+1);
			    	title=html.substring(0,html.indexOf("</")).replaceAll("&#039;","'").replaceAll("&quot;","\"");
			    	if(!Main.translate("fr","en",title).contains("<")){title=Main.translate("fr","en",title);}
			    	listFR.add(title);
			    	links.put(title,uri);
		    	}
	    	}catch(Exception e){System.out.println("addLinksClic no work");}
	    }
	    /*Collects the initial html for Le Monde and adds to the listFR and links to the corresponding titles and links for the titles*/
	    protected static void addLinksLeM(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		html=html.substring(html.indexOf("<h1")-200);
	    		html=html.substring(html.indexOf("href")+6);
	    		String uri=html.substring(0,html.indexOf("\""));
	    		html=html.substring(html.indexOf("<h1"));
	    		html=html.substring(html.indexOf(">")+1);
	    		String title=html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","").replaceAll("»","").replaceAll("«","").trim();
	    		if(!Main.translate("fr","en",title).contains("<")){title=Main.translate("fr","en",title);}
	    		listFR.add(title);
	    		links.put(title,uri);
	    		for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("a href")+8);
		    		uri=html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf("<p "));
		    		html=html.substring(html.indexOf(">")+1);
		    		title=html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","").replaceAll("»","").replaceAll("«","").trim();
		    		if(!Main.translate("fr","en",title).contains("<")){title=Main.translate("fr","en",title);}
		    		listFR.add(title);
		    		links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksLeM no work");}
	    }
	    /*Collects the initial html for FranceSoir and adds to the listFR and links to the corresponding titles and links for the titles*/
	    protected static void addLinksFrSo(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("field-content"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.francesoir.fr"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("</strong>")+21);
	    			String title=html.substring(0,html.indexOf("<")).trim();
	    			if(!Main.translate("fr","en",title).contains("<")){title=Main.translate("fr","en",title);}
	    			if(title.isEmpty()){i--;
	    			}else{
	    				listFR.add(title);
	    				links.put(title,uri);
	    			}
	    		}
	    	}catch(Exception e){System.err.println("addLinksFrSo no work");}
	    }
	    /*Collects the initial html for Est Republican and adds to the listFR and links to the corresponding titles and links for the titles*/
	    protected static void addLinksESTR(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h2"));
	    			String title=html.substring(0,html.indexOf("</h2")).replaceAll("<[^>]*>","").trim();
	    			if(!Main.translate("fr","en",title).contains("<")){title=Main.translate("fr","en",title);}
	    			listFR.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksESTR no work");}
	    }
	    /*
	     * NEWS FROM ISRAEL
	     */
	    /*Collects the initial html for the Times of Israel and adds to the listIL and links to the corresponding titles and links for the titles*/
	    protected static void addLinksTOI(String html){
	    	try{
	    		html=html.substring(html.indexOf("<section"));
	    		for(int i=0;i<6;i++){
	    			html=html.substring(html.indexOf("\"headline\""));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").trim();
	    			html=html.substring(html.indexOf("</div"));
	    			listIL.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksTOI no work");}
	    }
	    /*Collects the inital html for the Globes and adds to the listIL and links to the corresponding titles and links for the titles*/
	    protected static void addLinksGLO(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"mainContent\""));
	    		for(int i=0;i<6;i++){
	    			html=html.substring(html.indexOf("<b>"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://en.globes.co.il"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("</div"));
	    			listIL.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksGLO no work");}
	    }
	    /*Collects the initial html for the JPost and adds to the listIL and links to the corresponding titles and links for the titles*/
	    protected static void addLinksJPOst(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"one-row"));
	    		for(int i=0;i<6;i++){
	    			html=html.substring(html.indexOf("<a href")+9);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</"));
	    			while(title.contains("&#x2")){title=title.substring(0,title.indexOf("&"))+"'"+title.substring(title.indexOf(";")+1);}
	    			html=html.substring(html.indexOf("</div"));
	    			if(!uri.contains("http")){i--;
	    			}else{
	    				listIL.add(title);
		    			links.put(title,uri);}
	    		}
	    	}catch(Exception e){System.err.println("addLinksJPOst no work");}
	    }
	    /*Collects the initial html for the Haretz and adds to the listIL and links to the corresponding titles and links for the titles*/
	    protected static void addLinksHAAre(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replaceAll("&#x27;","'").trim();
	    			html=html.substring(html.indexOf("<div"));
	    			if(!uri.contains("http")){i--;
	    			}else{
	    				listIL.add(title);
	    				links.put(title,uri);}
	    		}
	    	}catch(Exception e){System.err.println("addLinksHAAre no work");}
	    }
	    /*Collects the initial html for the Israeli news and adds to the listIL and links to the corresponding titles and links for the titles*/
	    protected static void addLinksISRNews(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<6;i++){
	    			html=html.substring(html.indexOf("<h4"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("<article"));
	    			listIL.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){System.err.println("addLinksISRNews no work");}
	    }
}
