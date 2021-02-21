import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.String;
public class FileCreate {
	  /*United States*/
	  protected static ArrayList<String> listUS=new ArrayList<String>();
	  /*United Kingdom*/
	  protected static ArrayList<String> listUK=new ArrayList<String>();
	  /*Canada*/
	  protected static ArrayList<String> listCA=new ArrayList<String>();
	  /*Australia / New Zealand*/
	  protected static ArrayList<String> listNZ=new ArrayList<String>();
	  /*France*/
	  protected static ArrayList<String> listFR=new ArrayList<String>();
	  /*Israel*/
	  protected static ArrayList<String> listIL=new ArrayList<String>();
	  /*Russia*/
	  protected static ArrayList<String> listRU=new ArrayList<String>();
	  /*India*/
	  protected static ArrayList<String> listIN=new ArrayList<String>();
	  /*Brazil*/
	  protected static ArrayList<String> listBR=new ArrayList<String>();
	  /*Mexico*/
	  protected static ArrayList<String> listME=new ArrayList<String>();
	  /*Germany*/
	  protected static ArrayList<String> listDE=new ArrayList<String>();
	  /*Italy*/
	  protected static ArrayList<String> listIT=new ArrayList<String>();
	  /*South Korea*/
	  protected static ArrayList<String> listSK=new ArrayList<String>();
	  /*Japan*/
	  protected static ArrayList<String> listJP=new ArrayList<String>();
	  /*North Korea*/
	  protected static ArrayList<String> listNK=new ArrayList<String>();
	  /*China*/
	  protected static ArrayList<String> listCH=new ArrayList<String>();
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
		    		"https://nationalpost.com/",
		    		"https://www.stuff.co.nz/",
		    		"http://www.thecivilian.co.nz/",
		    		"https://www.9news.com.au/",
		    		"https://www.smh.com.au/",
		    		"https://www.theage.com.au/",
		    		"https://www.centre-presse.fr/index.html",
		    		"https://www.clicanoo.re/",
		    		"https://www.lemonde.fr/",
		    		"https://www.francesoir.fr/",
		    		"https://www.estrepublicain.fr/",
		    		"https://www.timesofisrael.com/",
		    		"https://en.globes.co.il/en/",
		    		"https://www.jpost.com/",
		    		"https://www.haaretz.com/",
		    		"https://israelinewslive.org/",
		    		"https://www.themoscowtimes.com/",
		    		"https://www.rt.com/russia/",
		    		"https://english.pravda.ru/",
		    		"https://tass.com/",
		    		"https://sputniknews.com/",
		    		"https://timesofindia.indiatimes.com/india",
		    		"https://www.indiatoday.in/",
		    		"https://www.ndtv.com/",
		    		"https://zeenews.india.com/",
		    		"https://www.hindustantimes.com/",
		    		"https://www.reuters.com/places/brazil",
		    		"https://www.nsctotal.com.br/an",
		    		"https://www.anovademocracia.com.br/",
		    		"https://riotimesonline.com/",
		    		"https://www.aljazeera.com/where/brazil/",
		    		"https://mexiconewsdaily.com/",
		    		"https://mexicotoday.com/",
		    		"http://www.banderasnews.com/headlines/bay.htm",
		    		"https://cambiodemichoacan.com.mx/",
		    		"https://www.elimparcial.com/",
		    		"https://www.aerztezeitung.de/",
		    		"https://www.dw.com/en/aachen/t-38437968",
		    		"https://www.abendzeitung-muenchen.de/",
		    		"https://www.idowa.de/",
		    		"https://remszeitung.de/",
		    		"https://www.repubblica.it/",
		    		"https://www.bresciaoggi.it/",
		    		"https://www.tgcom24.mediaset.it/cronaca/campania/",
		    		"http://www.gaynews.it/",
		    		"https://ilpiccolo.gelocal.it/trieste",
		    		"https://www.koreatimes.co.kr/www2/index.asp",
		    		"http://www.arirang.com/News/News_Index.asp",
		    		"http://www.koreaherald.com/",
		    		"https://en.yna.co.kr/",
		    		"http://www.koreatimesus.com/news/",
		    		"https://www.japantimes.co.jp/",
		    		"https://mainichi.jp/english/",
		    		"http://www.rafu.com/",
		    		"http://www.asahi.com/ajw/",
		    		"https://the-japan-news.com/",
		    		"https://www.nknews.org/",
		    		"https://www.newsnow.co.uk/h/World+News/Asia/North+Korea?type=ln",
		    		"https://www.dailynk.com/english/",
		    		"https://kcnawatch.org/",
		    		"http://english.chosun.com/svc/list_in/list.html?catid=F",
		    		"http://www.xinhuanet.com/english/",
		    		"http://www.chinadaily.com.cn/index.html",
		    		"https://thechinatimes.com/china",
		    		"https://www.shine.cn/news/",
		    		"https://sampan.org/");
		    try{
		      String country="Loading: United States";
		      for(int i=0;i<webSources.size();i++){
		        String url=collectHTML(webSources.get(i));
		        switch(i){
		          case 0:addLinksCNN(url);break;
		          case 1:addLinksFOX(url);break;
		          case 2:addLinksCBS(url);break;
		          case 3:addLinksNYT(url);break;
		          case 4:addLinksABC(url);country="Loading: United Kingdom";break;
		          //UK
		          case 5:addLinksBBC(url);break;
		          case 6:addLinksTEL(url);break;
		          case 7:addLinksGUA(url);break;
		          case 8:addLinksTDM(url);break;
		          case 9:addLinksTMR(url);country="Loading: Canada";break;
		          //CA
		          case 10:addLinksCBC(url);break;
		          case 11:addLinksCTV(url);break;
		          case 12:addLinksTorStar(url);break;
		          case 13:addLinksFinPost(url);break;
		          case 14:addLinksNatPost(url);country="Loading: New Zealand/Australia";break;
		          //NZ/AU
		          case 15:addLinksSTU(url);break;
		          case 16:addLinksTCV(url);break;
		          case 17:addLinksNNews(url);break;
		          case 18:addLinksSMH(url);break;
		          case 19:addLinksAGE(url);country="Loading: France";break;
		          //FR
		          case 20:addLinksCentPre(url);break;
		          case 21:addLinksClic(url);break;
		          case 22:addLinksLeM(url);break;
		          case 23:addLinksFrSo(url);break;
		          case 24:addLinksESTR(url);country="Loading: Israel";break;
		          //IS
		          case 25:addLinksTOI(url);break;
		          case 26:addLinksGLO(url);break;
		          case 27:addLinksJPOst(url);break;
		          case 28:addLinksHAAre(url);break;
		          case 29:addLinksISRNews(url);country="Loading: Russia";break;
		          //RU
		          case 30:addLinksTMT(url);break;
		          case 31:addLinksRTCom(url);break;
		          case 32:addLinksPRA(url);break;
		          case 33:addLinksTASS(url);break;
		          case 34:addLinksSPUT(url);country="Loading: India";break;
		          //IN
		          case 35:addLinksTOIndia(url);break;
		          case 36:addLinksInTod(url);break;
		          case 37:addLinksNDTV(url);break;
		          case 38:addLinksZEE(url);break;
		          case 39:addLinksHindus(url);country="Loading: Brazil";break;
		          //BR
		          case 40:addLinksRET(url);break;
		          case 41:addLinksAN(url);break;
		          case 42:addLinksANO(url);break;
		          case 43:addLinksTRT(url);break;
		          case 44:addLinksALJA(url);country="Loading: Mexico";break;
		          //ME
		          case 45:addLinksMND(url);break;
		          case 46:addLinksMexTod(url);break;
		          case 47:addLinksBand(url);break;
		          case 48:addLinksCAM(url);break;
		          case 49:addLinksElIm(url);country="Loading: Germany";break;
		          //DE
		          case 50:addLinksARZ(url);break;
		          case 51:addLinksAACH(url);break;
		          case 52:addLinksABEND(url);break;
		          case 53:addLinksIDOWA(url);break;
		          case 54:addLinksREM(url);country="Loading: Italy";break;
		          //IT
		          case 55:addLinksITN(url);break;
		          case 56:addLinksBRES(url);break;
		          case 57:addLinksGIO(url);break;
		          case 58:addLinksGAY(url);break;
		          case 59:addLinksIlpi(url);country="Loading: South Korea";break;
		          //SK
		          case 60:addLinksTKT(url);break;
		          case 61:addLinksAIR(url);break;
		          case 62:addLinksTKH(url);break;
		          case 63:addLinksYON(url);break;
		          case 64:addLinksKoT(url);country="Loading: Japan";break;
		          //JP
		          case 65:addLinksJapT(url);break;
		          case 66:addLinksMaiN(url);break;
		          case 67:addLinksRAF(url);break;
		          case 68:addLinksASahI(url);break;
		          case 69:addLinksTJN(url);country="Loading: North Korea";break;
		          //NK
		          case 70:addLinksNKN(url);break;
		          case 71:addLinksNKT(url);break;
		          case 72:addLinksDNK(url);break;
		          case 73:addLinksKCNAnk(url);break;
		          case 74:addLinksCHO(url);country="Loading: China";break;
		          //CH
		          case 75:addLinksXIN(url);break;
		          case 76:addLinksCHD(url);break;
		          case 77:addLinksTCT(url);break;
		          case 78:addLinksShine(url);break;
		          case 79:addLinksSAM(url);break;
		        }
		        Main.progress(i*100/webSources.size(),country,-1);
		      }
		      Main.progress(100,"Setting up feed",0);
		      links.forEach((k,v)->System.out.println(k+"\n"+v+"\n"));
		    }catch(Exception e){Main.debug.append("no work init\n");e.printStackTrace();
		    }finally{
		    	/*addLinksCHO(collectHTML(webSources.get(74)));
		    	listNK.forEach(n->System.out.println(n+"\n"+links.get(n)+"\n\n"));*/
		    	
		    	if(!Main.debug.toString().isEmpty()){
		    		Main.printDebug();
		    		System.out.println("Complete, check debug.txt for information");}
			}
	  }
	   /**This method will return the entire html coding of what's in the url parameter given
	    *@param - String url - the url that you want to collect information from
	    */
	    private static String collectHTML(String url){
	      try{
	        HttpClient client=HttpClient.newHttpClient();
	        HttpRequest request=HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
	        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
	        String html=response.body();
	        return html;
	      }
	      catch(Exception e){
	    	  if(Main.percent==0){Main.percent=100;}
	    	  Main.progress(Main.percent,"ERROR 408: CHECK CONNECTION",1);
	    	  Main.debug.append("Request error (check internet)\n");
	    	  return "";}
	    }
/**addLinks list - adds the links and titles to their corresponding lists / links
 * @param - String html - the entire html for the page which is collected through the collectHtml
 * @return - void
 * {@summary} - adds the links and titles to their corresponding lists / links
 */
	    /*
	     * NEWS FROM US :: listUS
	     */
	    /*CNN*/
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
	      }catch(Exception e){Main.debug.append("addLinksCNN no work\n");}
	    }
	    /*FOX*/
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
		        if(!(title.length()<20||uri.isEmpty())){
		          listUS.add(title);
		          links.put(title,uri);
		          i--;
		        }
		        i++;
		      }
	    	}catch(Exception e){Main.debug.append("addLinksFOX no work\n");}
	    }
	    /*CBS*/
	    protected static void addLinksCBS(String html){
	    	try{
		      html=html.substring(html.indexOf("<!-- End I"));
		      for(int i=0;i<6;i++){
		        html=html.substring(html.indexOf("https"));
		        String uri=html.substring(0,html.indexOf("\"")).trim();
		        html=html.substring(html.indexOf("h4"));
		        html=html.substring(html.indexOf(">")+1);
		        String title=html.substring(0,html.indexOf("<")).trim();
		        if(title.isEmpty()||title.length()<20){i--;}
		        else{
		        	listUS.add(title);
		        	links.put(title,uri);}
		      }
	    	}catch(Exception e){Main.debug.append("addLinksCBS no work\n");}
	    }
	    /*NYT*/
	    protected static void addLinksNYT(String html){
	    	try{
		      html=html.substring(html.indexOf("<main"));
		      for(int i=0;i<5;i++){
		    	  if(html.contains("\"story-wrapper\"")){
		    		  html=html.substring(html.indexOf("\"story-wrapper\""));}
		    	  else if(html.contains("<article")){
		    		  html=html.substring(html.indexOf("<article"));}
		    	  html=html.substring(html.indexOf("href")+6);
		    	  String uri=html.substring(0,html.indexOf("\""));
		    	  html=html.substring(html.indexOf("<h"));
		    	  html=html.substring(html.indexOf(">")+1);
		    	  String title=html.substring(0,html.indexOf("</h")).replaceAll("<[^>]*>"," ").trim();
		    	  html=html.substring(html.indexOf("<section"));
		    	  if(!uri.contains("http")){uri="https://www.nytimes.com"+uri;}
		    	  if(title.contains("›")){i--;}
		    	  else{
			    	  listUS.add(title);
			    	  links.put(title,uri);}
		      }
	    	}catch(Exception e){Main.debug.append("addLinksNYT no work\n");}
	    }
	    /*ABC*/
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
	    	}catch(Exception e){Main.debug.append("addLinksABC no work\n");}
	    }
	    /*
	     * NEWS FROM UK :: listUK
	     */
	    /*BBC*/
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
	    	}catch(Exception e){Main.debug.append("addLinksBBC no work\n");}
	    }
	    /*Telegram*/
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
	    	}catch(Exception e){Main.debug.append("addLinksTEL no work\n");}
	    }
	    /*the Guardians*/
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
	    	}catch(Exception e){Main.debug.append("addLinksGUA no work\n");}
	    }
	    /*The Daily mail*/
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
	    	}catch(Exception e){Main.debug.append("addLinksTDM no work\n");}
	    }
	    /*The Daily Mirror*/
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
	    	}catch(Exception e){Main.debug.append("addLinksTMR no work\n");}
	    }
	    /*
	     * NEWS FROM CANADA :: listCA
	     */
	    /*CBC*/
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
	    	}catch(Exception e){Main.debug.append("addLinksCBC no work\n");}
	    }
	    /*CTV*/
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
	    	}catch(Exception e){Main.debug.append("addLinksCTV no work\n");}
	    }
	    /*the Toronto Star*/
	    protected static void addLinksTorStar(String html){
	    	try{
		    	html=html.substring(html.indexOf("<main"));
		    	for(int i=0;i<5;i++){
		    		html=html.substring(html.indexOf("<a href")+9);
		    		String uri="https://www.thestar.com"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf(">")+1);
		    		String title=html.substring(0,html.indexOf("</h3")).replaceAll("<[^>]*>","");
		    		html=html.substring(html.indexOf("</a"));
		    		listCA.add(title);
		    		links.put(title,uri);
		    	}
	    	}catch(Exception e){Main.debug.append("addLinksTorStar no work\n");}
	    }
	    /*the Financial Post*/
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
	    	}catch(Exception e){Main.debug.append("addLinksFinPost no work\n");}
	    }
	    /*the National Post*/
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
	    	}catch(Exception e){Main.debug.append("addLinksNatPost no work\n");}
	    }
	    /*
	     * NEWS FROM AUSTRALIA/NEW ZEALAND :: listNZ
	     */
	    /*the Stuff.co.nz*/
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
	    	}catch(Exception e){Main.debug.append("addLinksSTU no work\n");}
	    }
	    /*The Civilian*/
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
	    		for(int i=0;i<5;i++){
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
	    	}catch(Exception e){Main.debug.append("addLinksTCV no work\n");}
	    }
	    /*9news*/
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
	    	}catch(Exception e){Main.debug.append("addLinksNNews no work\n");}
	    }
	    /*The Sydney Morning Herald*/
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
	    	}catch(Exception e){Main.debug.append("addLinksSMH no work\n");}
	    }
	    /*the AGE*/
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
	    	}catch(Exception e){Main.debug.append("addLinksAGE no work\n");}
	    }
	    /*
	     * NEWS FROM FRANCE :: listFR
	     */
	    /*the Centre-press*/
	    protected static void addLinksCentPre(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"content\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("item_article"));
	    			html=html.substring(html.indexOf("titre"));
	    			html=html.substring(html.indexOf("<a href")+9);
	    			String uri="https://www.centre-presse.fr"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replaceAll("&apos;","'");
	    			try{
		    			String translate=GoogleTranslate.translate("fr","en",title);
		    			if(!translate.contains("<")){title=translate;}
	    			}catch(Exception e){Main.debug.append("Check connection 403 for Centre-press\n");}
	    			if(title.length()<20){i--;}
	    			else{
		    			listFR.add(title);
		    			links.put(title,uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksCentPre no work\n");e.printStackTrace();}
	    }
	    /*the Clicacoo*/
	    protected static void addLinksClic(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
		    	html=html.substring(html.indexOf("<h1"));
		    	html=html.substring(html.indexOf("href")+6);
		    	String uri="https://www.clicanoo.re"+html.substring(0,html.indexOf("'"));
		    	html=html.substring(html.indexOf(">")+1);
		    	String title=html.substring(0,html.indexOf("</")).replaceAll("&#039;","'").replaceAll("&quot;","\"");
		    	String translate=GoogleTranslate.translate("fr","en",title);
    			if(!translate.contains("<")){title=translate;}
		    	listFR.add(title);
		    	links.put(title,uri);
		    	for(int i=0;i<5;i++){
			    	html=html.substring(html.indexOf("<h3"));
			    	html=html.substring(html.indexOf("href")+6);
			    	uri="https://www.clicanoo.re"+html.substring(0,html.indexOf("'"));
			    	html=html.substring(html.indexOf(">")+1);
			    	title=html.substring(0,html.indexOf("</")).replaceAll("&#039;","'").replaceAll("&quot;","\"");
			    	translate=GoogleTranslate.translate("fr","en",title);
	    			if(!translate.contains("<")){title=translate;}
			    	listFR.add(title);
			    	links.put(title,uri);
		    	}
	    	}catch(Exception e){System.out.println("addLinksClic no work\n");}
	    }
	    /*Le Monde*/
	    protected static void addLinksLeM(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		html=html.substring(html.indexOf("<section"));
	    		html=html.substring(html.indexOf("<a href")+9);
	    		String uri=html.substring(0,html.indexOf("\""));
	    		html=html.substring(html.indexOf("<h1"));
	    		html=html.substring(html.indexOf(">")+1);
	    		String title=html.substring(0,html.indexOf("</h1")).replaceAll("<[^>]*>","").replaceAll("»","").replaceAll("«","");
	    		html=html.substring(html.indexOf("<section"));
	    		String translate=GoogleTranslate.translate("fr","en",title);
    			if(!translate.contains("<")){title=translate;}
	    		listFR.add(title);
	    		links.put(title,uri);
	    		for(int i=0;i<4;i++){
	    			html=html.substring(html.indexOf("<a href")+9);
		    		uri=html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf("<p "));
		    		html=html.substring(html.indexOf(">")+1);
		    		title=html.substring(0,html.indexOf("</p")).replaceAll("<[^>]*>","");
		    		html=html.substring(html.indexOf("<section"));
		    		translate=GoogleTranslate.translate("fr","en",title);
	    			if(!translate.contains("<")){title=translate;}
		    		if(title.length()<20||!uri.contains("http")){i--;
		    		}else{
		    			listFR.add(title);
		    			links.put(title,uri);
		    		}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksLeM no work\n");}
	    }
	    /*FranceSoir*/
	    protected static void addLinksFrSo(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("field-content"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.francesoir.fr"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("</strong>")+21);
	    			String title=html.substring(0,html.indexOf("<")).trim();
	    			String translate=GoogleTranslate.translate("fr","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			if(title.isEmpty()){i--;
	    			}else{
	    				listFR.add(title);
	    				links.put(title,uri);
	    			}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksFrSo no work\n");}
	    }
	    /*Est Republican*/
	    protected static void addLinksESTR(String html){
	    	try{
	    		html=html.substring(html.indexOf("<body"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.estrepublicain.fr"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h2"));
	    			String title=html.substring(0,html.indexOf("</h2")).replaceAll("<[^>]*>","").replaceAll("&quot;","\"").trim();
	    			String translate=GoogleTranslate.translate("fr","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listFR.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksESTR no work\n");}
	    }
	    /*
	     * NEWS FROM ISRAEL :: listIL
	     */
	    /*the Times of Israel*/
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
	    	}catch(Exception e){Main.debug.append("addLinksTOI no work\n");}
	    }
	    /*the Globes*/
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
	    	}catch(Exception e){Main.debug.append("addLinksGLO no work\n");}
	    }
	    /*the JPost*/
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
	    	}catch(Exception e){Main.debug.append("addLinksJPOst no work\n");}
	    }
	    /*the Haretz*/
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
	    	}catch(Exception e){Main.debug.append("addLinksHAAre no work\n");}
	    }
	    /*the Israeli news*/
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
	    	}catch(Exception e){Main.debug.append("addLinksISRNews no work\n");}
	    }
	    /*
	     * NEWS FROM RUSSIA :: listRU
	     */
	    /*Moscow Times*/
	    protected static void addLinksTMT(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"row-flex\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a href")+9);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h3")).replaceAll("<[^>]*>","").trim();
	    			html=html.substring(html.indexOf("</a"));
	    			if(title.contains("\n")||title.isEmpty()){i--;}
	    			else{
	    				listRU.add(title);
	    				links.put(title,uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksTMT no work\n");}
	    }
	    /*the RT*/
	    protected static void addLinksRTCom(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"media  \""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<strong"));
	    			html=html.substring(html.indexOf("<a class"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.rt.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).trim();
	    			html=html.substring(html.indexOf("<li"));
	    			if(title.isEmpty()){i--;}
	    			else{
	    				listRU.add(title);
	    				links.put(title,uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksRTCom no work\n");}
	    }
	    /*Pravda*/
	    protected static void addLinksPRA(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"page\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("\"title\""));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).trim();
	    			html=html.substring(html.indexOf("</a"));
	    			if(title.isEmpty()){i--;}
	    			else{
	    			listRU.add(title);
	    			links.put(title,uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksPRA no work\n");}
	    }
	    /*TASS*/
	    protected static void addLinksTASS(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a class"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://tass.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("title\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</span")).replaceAll("<[^>]*>"," ");
	    			while(title.contains("  ")){title=title.replaceAll("  "," ");}
	    			html=html.substring(html.indexOf("</a"));
	    			if(title.length()<20){i--;}
	    			else{
	    				listRU.add(title);
	    				links.put(title,uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksTASS no work\n");}
	    }
	    /*Sputnik news*/
	    protected static void addLinksSPUT(String html){
	    	try{
	    		html=html.substring(html.indexOf("main_top_news\""));
	    		html=html.substring(html.indexOf("title\""));
	    		html=html.substring(html.indexOf("href")+6);
	    		String uri="https://sputniknews.com"+html.substring(0,html.indexOf("\""));
	    		html=html.substring(html.indexOf(">")+1);
	    		String title=html.substring(0,html.indexOf("</a"));
	    		html=html.substring(html.indexOf("</a")+1);
	    		listRU.add(title);
	    		links.put(title,uri);
	    		for(int i=0;i<4;i++){
	    			html=html.substring(html.indexOf("</a"));
	    			html=html.substring(html.indexOf("href")+6);
	    			uri="https://sputniknews.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			title=html.substring(0,html.indexOf("</a")).replaceAll("<span>","").replaceAll("</span>"," ");
	    			while(title.contains("  ")){title=title.replaceAll("  "," ");}
	    			html=html.substring(html.indexOf("</a")+1);
	    			listRU.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksSPUT no work\n");}
	    }
	    /*
	     * NEWS FROM INDIA :: listIN
	     */
	    /*Times of India*/
	    protected static void addLinksTOIndia(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"top-newslist"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("w_tle"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://timesofindia.indiatimes.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("<li"));
	    			listIN.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksTOIndia no work\n");}
	    }
	    /*India Today*/
	    protected static void addLinksInTod(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		html=html.substring(html.indexOf("<h2"));
	    		html=html.substring(html.indexOf("href")+6);
	    		String uri="https://www.indiatoday.in"+html.substring(0,html.indexOf("\""));
	    		html=html.substring(html.indexOf(">")+1);
	    		String title=html.substring(0,html.indexOf("</a"));
	    		html=html.substring(html.indexOf("</div"));
	    		listIN.add(title);
	    		links.put(title,uri);
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf("href")+6);
		    		uri="https://www.indiatoday.in"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf(">")+1);
		    		title=html.substring(0,html.indexOf("</a"));
		    		html=html.substring(html.indexOf("</div"));
		    		if(title.contains("http")){i--;}
		    		else{
		    			listIN.add(title);
		    			links.put(title,uri);
		    		}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksInTod no work\n");}
	    }
	    /*NDTV*/
	    protected static void addLinksNDTV(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"thumbnail"));
	    		html=html.substring(html.indexOf("<h1"));
	    		html=html.substring(html.indexOf("href")+6);
	    		String uri=html.substring(0,html.indexOf("\""));
	    		html=html.substring(html.indexOf(">")+1);
	    		String title=html.substring(0,html.indexOf("</a"));
	    		html.substring(html.indexOf("</div"));
	    		listIN.add(title);
	    		links.put(title,uri);
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf("href")+6);
		    		uri=html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf(">")+1);
		    		title=html.substring(0,html.indexOf("</a"));
		    		html.substring(html.indexOf("</div"));
		    		listIN.add(title);
		    		links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksNDTV no work\n");}
	    }
	    /*ZEE*/
	    protected static void addLinksZEE(String html){
	    	try{
	    		html=html.substring(html.indexOf("<section>"));
	    		html=html.substring(html.indexOf("<h1"));
	    		html=html.substring(html.indexOf("href")+6);
	    		String uri="https://zeenews.india.com"+html.substring(0,html.indexOf("\""));
	    		html=html.substring(html.indexOf(">")+1);
	    		String title=html.substring(0,html.indexOf("</a")).replaceAll("\n","");
	    		html=html.substring(html.indexOf("</div"));
	    		listIN.add(title);
	    		links.put(title,uri);
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
		    		html=html.substring(html.indexOf("href")+6);
		    		uri="https://zeenews.india.com"+html.substring(0,html.indexOf("\""));
		    		html=html.substring(html.indexOf(">")+1);
		    		title=html.substring(0,html.indexOf("</a")).replaceAll("\n","");
		    		html=html.substring(html.indexOf("</div"));
		    		listIN.add(title);
		    		links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksZEE no work\n");}
	    }
	    /*Hindustan times*/
	    protected static void addLinksHindus(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"container\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.hindustantimes.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("\n","");
	    			html=html.substring(html.indexOf("</figure"));
	    			if(title.contains("/>")){i--;}
	    			else{
	    				listIN.add(title);
	    				links.put(title,uri);
	    			}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksHindus no work\n");}
	    }
	    /*
	     * NEWS FROM BRAZIL :: listBR
	     */
	    /*the Reuters*/
	    protected static void addLinksRET(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"group wrap\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("story-content"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.reuters.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").trim();
	    			html=html.substring(html.indexOf("<article"));
	    			listBR.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksRET no work\n");}
	    }
	    /*the Anoticia*/
	    protected static void addLinksAN(String html){
	    	try{
	    		html=html.substring(html.indexOf("<div>"));
	    		html=html.substring(html.indexOf("<article"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h")).replaceAll("<[^>]*>","");
	    			String translate=GoogleTranslate.translate("pt","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			if(listBR.contains(title)){i--;}
	    			else{
	    				listBR.add(title);
	    				links.put(title,uri);
	    			}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksAN no work\n");}
	    }
	    /*Anova*/
	    protected static void addLinksANO(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"body-wrapper\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h4"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.anovademocracia.com.br"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","");
	    			html=html.substring(html.indexOf("<div"));
	    			String translate=GoogleTranslate.translate("pt","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listBR.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksANO no work\n");}
	    }
	    /*The RIO times*/
	    protected static void addLinksTRT(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"td-block-title-wrap\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("&#8211;","-").replaceAll("&#8217;","'");
	    			html=html.substring(html.indexOf("td"));
	    			listBR.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addlinksTRT no work\n");}
	    }
	    /*Aljazeera*/
	    protected static void addLinksALJA(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"root\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.aljazeera.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","");
	    			html=html.substring(html.indexOf("</article"));
	    			listBR.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksALJA no work\n");}
	    }
	    /*
	     * NEWS FROM MEXICO :: listME
	     */
	    /*Mexico news daily*/
	    protected static void addLinksMND(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		html=html.substring(html.indexOf("</aside"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a href")+9);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h2"));
	    			html=html.substring(html.indexOf("<li"));
	    			listME.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksMND no work\n");}
	    }
	    /*Mexico Today*/
	    protected static void addLinksMexTod(String html){
	    	try{
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("&#8217;","'");
	    			html=html.substring(html.indexOf("</article"));
	    			listME.add(title);
	    			links.put(title,uri);
	    			
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksMexTod no work\n");}
	    }
	    /*Banderas news*/
	    protected static void addLinksBand(String html){
	    	try{
	    		html=html.substring(html.indexOf("Zone-Heading"));
	    		html=html.substring(html.indexOf("blat2"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			html=html.substring(html.indexOf("B>")+2);
	    			String title=html.substring(0,html.indexOf("</"));
	    			html=html.substring(html.indexOf("<BR"));
	    			listME.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksBand no work\n");}
	    }
	    /*Cambio de michogcan*/
	    protected static void addLinksCAM(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"wpb_wrapper\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","");
	    			html=html.substring(html.indexOf("title-wrap"));
	    			String translate=GoogleTranslate.translate("es","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listME.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksCAM no work\n");}
	    }
	    /*El Imparcial*/
	    protected static void addLinksElIm(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"pagebuilder"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.elimparcial.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("<")).replaceAll("<[^>]*>","");
	    			html=html.substring(html.indexOf("<article"));
	    			String translate=GoogleTranslate.translate("es","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listME.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksElIm no work\n");}
	    }
	    /*
	     * NEWS FROM GERMANY :: listDE
	     */
	    /*Arzietung*/
	    protected static void addLinksARZ(String html){
	    	try{
	    		html=html.substring(html.indexOf("article-top\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.aerztezeitung.de"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","");
	    			html=html.substring(html.indexOf("<article"));
	    			String translate=GoogleTranslate.translate("de","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listDE.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksARZ no work\n");}
	    }
	    /*Aachener*/
	    protected static void addLinksAACH(String html) {
	    	try{
	    		html=html.substring(html.indexOf("\"bodyMover\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("col1"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.dw.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h2")).replaceAll("<[^>]*>","").replaceAll("\n","");
	    			html=html.substring(html.indexOf("</a"));
	    			listDE.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksAACH");}
	    }
	    /*Abendzeitung*/
	    protected static void addLinksABEND(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.abendzeitung-muenchen.de"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).trim();
	    			html=html.substring(html.indexOf("</article"));
	    			String translate=GoogleTranslate.translate("de","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			if(listDE.contains(title)){i--;}
	    			else{
	    				listDE.add(title);
	    				links.put(title,uri);	    			}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksABEND no work\n");}
	    }
	    /*Idowa*/
	    protected static void addLinksIDOWA(String html){
	    	try{
	    		html=html.substring(html.indexOf("ressort\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("\"content\""));
	    			html=html.substring(html.indexOf("<a "));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h")).replaceAll("<[^>]*>","").replaceAll("\t","");
	    			String translate=GoogleTranslate.translate("de","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			html=html.substring(html.indexOf("</a"));
	    			if(uri.equals("#")){i--;}
	    			else{
		    			listDE.add(title);
		    			links.put(title,"https://www.idowa.de"+uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksIDOWA no work\n");}
	    }
	    /*Remszeitung*/
	    protected static void addLinksREM(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h")).replaceAll("<[^>]*>","");
	    			html=html.substring(html.indexOf("</article"));
	    			String translate=GoogleTranslate.translate("de","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listDE.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksREM no work\n");}
	    }
	    /*
	     * NEWS FROM ITALY :: listIT
	     */
	    /*ItalyNews.net*/
	    protected static void addLinksITN(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).trim();
	    			html=html.substring(html.indexOf("<article"));
	    			String translate=GoogleTranslate.translate("it","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listIT.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksITN no work\n");}
	    }
	    /*Bresciaggi*/
	    protected static void addLinksBRES(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"teaser-content-wrapper\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("</article"));
	    			String translate=GoogleTranslate.translate("it","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listIT.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksBRES no work\n");}
	    }
	    /*Giornale Compania*/
	    protected static void addLinksGIO(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"d\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replaceAll("&egrave;","è").replaceAll("&#39;","'").trim();
	    			html=html.substring(html.indexOf("</article"));
	    			String translate=GoogleTranslate.translate("it","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listIT.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksGIO no work\n");}
	    }
	    /*Gay news*/
	    protected static void addLinksGAY(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"jeg_main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("&#8217;","'");
	    			html=html.substring(html.indexOf("</article"));
	    			String translate=GoogleTranslate.translate("it","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listIT.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksGAY no work\n");}
	    }
	    /*Ilpiccolo*/
	    protected static void addLinksIlpi(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("</article"));
	    			String translate=GoogleTranslate.translate("it","en",title);
	    			if(!translate.contains("<")){title=translate;}
	    			listIT.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksIlpi no work\n");}
	    }
	    /*
	     * NEWS FROM SOUTH KOREA :: listSK
	     */
	    /*Korea times*/
	    protected static void addLinksTKT(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"main_nav\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("_headline "));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.koreatimes.co.kr"+html.substring(0,html.indexOf("'"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("article"));
	    			listSK.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksTKT no work\n");}
	    }
	    /*arirang*/
	    protected static void addLinksAIR(String html){
	    	try{
	    		html=html.substring(html.indexOf("<ul"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<li"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			if(uri.charAt(0)=='#'){uri="http://www.arirang.com/News/News_Index.asp"+uri;}
	    			else if(uri.charAt(0)=='N'){uri="http://www.arirang.com/News/"+uri;}
	    			else if(uri.charAt(1)=='n'){uri="http://www.arirang.com"+uri;}
	    			html=html.substring(html.indexOf("slide_txt\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</span"));
	    			if(title.length()<20){i--;}
	    			else{
	    				listSK.add(title);
	    				links.put(title,uri);
	    			}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksAIR no work\n");}
	    }
	    /*The Korean Herald*/
	    protected static void addLinksTKH(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"main\""));
	    		for(int i=0;i<4;i++){
	    			html=html.substring(html.indexOf("\"main_c"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="http://www.koreaherald.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("main_l_t1"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</div"));
	    			html=html.substring(html.indexOf("</li"));
	    			if(uri.contains(".css")||uri.charAt(uri.length()-1)==';'){i--;}
	    			else{
	    				listSK.add(title);
	    				links.put(title,uri);
	    			}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksTKH no work\n");}
	    }
	    /*Yonhap News Agency*/
	    protected static void addLinksYON(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"main-area\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("tit"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https:"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).trim();
	    			html=html.substring(html.indexOf("<article"));
	    			listSK.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksYON no work\n");}
	    }
	    /*Korea times*/
	    protected static void addLinksKoT(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"main-home\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("category3-text"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("main-headline"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).trim();
	    			if(title.contains("LEAD")){title=title.substring(title.indexOf(" ")+1);}
	    			html=html.substring(html.indexOf("<li"));
	    			listSK.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksKoT no work\n");}
	    }
	    /*
	     * NEWS FROM JAPAN :: listJP
	     */
	    /*Japan Times*/
	    protected static void addLinksJapT(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"main_content\""));
	    		html=html.substring(html.indexOf("lead_stories"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a "));
	    			String test=html.substring(0,html.indexOf("</a"));
	    			if(!test.contains("<p ")){i--;}
	    			else{
		    			html=html.substring(html.indexOf("https"));
		    			String uri=html.substring(0,html.indexOf("\""));
		    			html=html.substring(html.indexOf("<p "));
		    			html=html.substring(html.indexOf(">")+1);
		    			String title=html.substring(0,html.indexOf("</p")).trim().replaceAll("<[^>]*>","");
		    			listJP.add(title);
		    			links.put(title,uri);
	    			}
	    			html=html.substring(html.indexOf("</article"));
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksJapT no work\n");}
	    }
	    /*Mainchi*/
	    protected static void addLinksMaiN(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"main\""));
	    		html=html.substring(html.indexOf("midashi"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a href")+9);
	    			String uri="https:"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replaceAll("[\\r\\n]+"," ").trim().replaceAll("   "," ");
	    			html=html.substring(html.indexOf("<li"));
	    			listJP.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksMaiN no work\n");}
	    }
	    /*Japan Today*/
	    protected static void addLinksRAF(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"news-focus\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h2"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			listJP.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksRAF no work\n");}
	    }
	    /*Asahi Shimbun*/
	    protected static void addLinksASahI(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"MainInner\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a href")+9);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<p"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</p")).trim();
	    			if(title.contains("<span")){i--;}
	    			else{
	    				if(title.contains("href=")){
		    				title=title.substring(title.indexOf("href=")+6);
		    				uri=title.substring(0,title.indexOf("\""));
		    				title=title.substring(title.indexOf(">")+1);
		    			}
		    			title=title.replaceAll("<[^>]*>","");
		    			if(!uri.contains("http")){uri="http://www.asahi.com"+uri;}
		    			listJP.add(title);
		    			links.put(title,uri);}
	    			html=html.substring(html.indexOf("<li"));
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksASahI no work\n");}
	    }
	    /*The Japan News*/
	    protected static void addLinksTJN(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"content\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://the-japan-news.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h1"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</h")).replaceAll("<[^>]*>","").replaceAll("[\\r\\n]+"," ").replaceAll("PREMIUM","").trim();
	    			html=html.substring(html.indexOf("<li"));
	    			listJP.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksTJN no work\n");}
	    }
	    /*
	     * NEWS FROM NORTH KOREA :: listNK
	     */
	    /*NKNews*/
	    protected static void addLinksNKN(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"header-main\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("row"));
	    			if(title.contains("<img")){i--;}
	    			else{
		    			listNK.add(title);
		    			links.put(title,uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksNKN no work\n");}
	    }
	    /*NewsNow North Korea*/
	    protected static void addLinksNKT(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("\"hl"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("&#8217;","'");
	    			html=html.substring(html.indexOf("</div"));
	    			listNK.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksNKT no work\n");}
	    }
	    /*Daily NK*/
	    protected static void addLinksDNK(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"vc_section\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<a href")+9);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("title=\"")+7);
	    			String title=html.substring(0,html.indexOf("\"")).replaceAll("&#8217;","'");
	    			html=html.substring(html.indexOf("</a"));
	    			if(i<5){html=html.substring(html.indexOf("td-module-thumb"));}else{html=html.substring(html.indexOf("td-block-span"));}
	    			if(!uri.contains("http")||listNK.contains(title)){
	    				i--;
	    			}else{
		    			listNK.add(title);
		    			links.put(title,uri);}
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksDNK no work\n");}
	    }
	    /*KCNA watch north korea*/
	    protected static void addLinksKCNAnk(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"latest-articles\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("article-desc"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("</article"));
	    			listNK.add(title);
	    			links.put(title,uri);
	    			
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksKCNAnk no work\n");}
	    }
	    /*Chosun.com*/
	    protected static void addLinksCHO(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"list_area\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("\"list_item\""));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="http://english.chosun.com"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("&#39;","'");
	    			listNK.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksCHO no work\n");e.printStackTrace();}
	    }
	    /*
	     * NEWS FROM CHINA
	     */
	    /*Xinhau*/
	    protected static void addLinksXIN(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"focus\""));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("\"tit"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("<div"));
	    			listCH.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksXIN no work\n");}
	    }
	    /*China Daily*/
	    protected static void addLinksCHD(String html){
	    	try{
	    		html=html.substring(html.indexOf("\"tMain\""));
	    		for(int i=0;i<5;i++){
	    			if(i<5){
	    				html=html.substring(html.indexOf("<h3"));
	    			}else{
	    				html=html.substring(html.indexOf("_blank"));}
	    			html=html.substring(html.indexOf("<a target"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="http:"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").trim();
	    			listCH.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksCHD no work\n");}
	    }
	    /*The China Times*/
	    protected static void addLinksTCT(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a")).replaceAll("&#8217;","'");
	    			html=html.substring(html.indexOf("</article"));
	    			listCH.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksTCT no work\n");}
	    }
	    /*Shine*/
	    protected static void addLinksShine(String html){
	    	try{
	    		html=html.substring(html.indexOf("row row-story"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("top-story"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri="https://www.shine.cn"+html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf("<h"));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</"));
	    			listCH.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksShine no work\n");}
	    }
	    /*Sampan*/
	    protected static void addLinksSAM(String html){
	    	try{
	    		html=html.substring(html.indexOf("<main"));
	    		for(int i=0;i<5;i++){
	    			html=html.substring(html.indexOf("<article"));
	    			html=html.substring(html.indexOf("<h3"));
	    			html=html.substring(html.indexOf("href")+6);
	    			String uri=html.substring(0,html.indexOf("\""));
	    			html=html.substring(html.indexOf(">")+1);
	    			String title=html.substring(0,html.indexOf("</a"));
	    			html=html.substring(html.indexOf("</article"));
	    			listCH.add(title);
	    			links.put(title,uri);
	    		}
	    	}catch(Exception e){Main.debug.append("addLinksSAM no work\n");}
	    }
}
