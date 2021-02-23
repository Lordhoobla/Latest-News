import java.lang.String;
public class Story{
	private String title,url,publication,author;
	/**
	 * Constructor for the class, holds information
	 * @param x - title of article
	 * @param y - url for the article
	 * @param z - publication source
	 * @param w - author of article
	 */
	public Story(String x,String y,String z,String w){
		title=x;url=y;publication=z;
		if(w.length()>25||w.isBlank()){author=z;
		}else{author=w;}
	}
	/**
	 * @return - title of article
	 */
	protected String getTitle(){return title;}
	/**
	 * @return - url of article
	 */
	protected String getUrl(){return url;}
	/**
	 * @return - publication company of article
	 */
	protected String getPublication(){return publication;}
	/**
	 * @return - author of article
	 */
	protected String getAuthorArticle(){return author;}
	/**
	 * @return - returns a string containing all information held in this class
	 */
	public String toString(){return "title: "+title+"\nurl: "+url+"\npublication: "+publication+"\nauthor: "+author+"\n";}
	/**
	 * @function - takes in the url, converts it into an iframely link and outputs the frame
	 * @param url - the url for the story
	 */
	protected String getIframe(){
		return "<div class=\"iframely-embed\">"
					+"<div class=\"iframely-responsive\" "
					+"style=\"padding-bottom: 75%; padding-top: 120px;\">"
					+"<a href=\""+url+"\""
					+" data-iframely-url=\"//cdn.iframe.ly/api/iframe?url="+url.replaceAll("/","%2F").replaceAll(":","%3A")+"&amp;key=6d15cc1daec6da49865a7a2165717208\">"
					+"</a></div></div><script async src=\"https://cdn.iframe.ly/embed.js\" charset=\"utf-8\"></script>";
	}
/**
 * getAuthor methods - gets the author for the article
 * @param html - html for the story
 * @param empty - there is no author
 */
	/*
	 * NEWS FROM United States
	 */
	/*CNN*/
	protected static String getAuthorCNN(String html){
		try{
			html=html.substring(html.indexOf("byline__author\""));
			html=html.substring(html.indexOf(">")+4);
			String author=html.substring(0,html.indexOf("</span"));
			return author.replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorCNN no work\n");return "CNN";}
	}
	/*FOX*/
	protected static String getAuthorFOX(String html){
		try{
			html=html.substring(html.indexOf("author-byline\""));
			html=html.substring(html.indexOf(">")+1);
			String author=html.substring(0,html.indexOf("</div")).replaceAll("<[^>]*>","").replaceAll("By","").trim();
			return author.substring(0,author.indexOf("|"));
		}catch(Exception e){Main.debug.append("getAuthorFOX no work\n");return "FOX News";}
	}
	/*CBS*/
	protected static String getAuthorCBS(){return "CBS News";}
	/*NYT*/
	protected static String getAuthorNYT(String html){
		try{
			html=html.substring(html.indexOf("<article"));
			html=html.substring(html.indexOf("\"name\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorNYT no work\n");return "New York Times";}
	}
	/*ABC*/
	protected static String getAuthorABC(){return "The Associated Press";}
	/*
	 * NEWS FROM UK
	 */
	/*BBC*/
	protected static String getAuthorBBC(){return "BBC";}
	/*Telegraph*/
	protected static String getAuthorTEL(String html){
		try{
			html=html.substring(html.indexOf("__author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorTEL no work\n");return "Telegraph";}
	}
	/*The Guardian*/
	protected static String getAuthorGUA(String html){
		try{
			html=html.substring(html.indexOf("rel=\"author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a"));
		}catch(Exception e){Main.debug.append("getAuthorGUA no work\n");return "The Guardian";}
	}
	/*The Daily Mail*/
	protected static String getAuthorTDM(String html){
		try{
			html=html.substring(html.indexOf("class=\"author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorTDM no work\n");return "The Daily Mail";}
	}
	/*The Daily Mirror*/
	protected static String getAuthorTMR(String html){
		try{
			html=html.substring(html.indexOf("\"author-label\""));
			html=html.substring(html.indexOf(">")+1);
			String author=html.substring(0,html.indexOf("<ul")).replaceAll("<[^>]*>",",");
			while(author.contains(",,")){author=author.replaceAll(",,",",");}
			return author.replace("By,","").replaceAll(",",", ");
		}catch(Exception e){Main.debug.append("getAuthorTMR no work\n");return "The Daily Mirror";}
	}
	/*
	 * NEWS FROM CANADA
	 */
	/*CBC*/
	protected static String getAuthorCBC(){return "CBC News";}
	/*CTV*/
	protected static String getAuthorCTV(){return "The Canadian Press Staff";}
	/*Toronto Star*/
	protected static String getAuthorTorStar(String html){
		try{
			html=html.substring(html.indexOf("article__author-name\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorTorStar no work\n");return "Toronto Star Staff";}
	}
	/*Financial Post*/
	protected static String getAuthorFinPost(String html){
		try{
			html=html.substring(html.indexOf("\"published-by__author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("<"));
		}catch(Exception e){Main.debug.append("getAuthorFinPost no work\n");return "Financial Post Staff";}
	}
	/*National Post*/
	protected static String getAuthorNatPost(String html){
		try{
			html=html.substring(html.indexOf("\"article-meta\""));
			html=html.substring(html.indexOf("\"visually-hidden\""));
			html=html.substring(html.indexOf("alt=")+5);
			return html.substring(0,html.indexOf("\""));
		}catch(Exception e){Main.debug.append("getAuthorNatPost no work\n");return "National Post Staff";}
	}
	/*
	 * NEWS FROM AUSTRALIA / NEW ZEALAND
	 */
	/*Stuff.co.nz*/
	protected static String getAuthorSTU(String html){
		try{
			html=html.substring(html.indexOf("__author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorSTU no work\n");return "Stuff.co.nz staff";}
	}
	/*The Civilian*/
	protected static String getAuthorTCV(){return "The Civilian staff";}
	/*9News*/
	protected static String getAuthorNNews(String html){
		try{
			html=html.substring(html.indexOf("\"text--author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","").replaceAll("By ","");
		}catch(Exception e){Main.debug.append("getAuthorNNews no work\n");return "9News staff";}
	}
	/*Sydney Morning Herald*/
	protected static String getAuthorSMH(String html){
		try{
			html=html.substring(html.indexOf("<aside"));
			html=html.substring(html.indexOf("<h5"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</h5")).replaceAll("<[^>]*>","").replace("By ","");
		}catch(Exception e){Main.debug.append("getAuthorSMH no work\n");return "Sydney Morning Herald Staff";}
	}
	/*The Age*/
	protected static String getAuthorAGE(String html){
		try{
			html=html.substring(html.indexOf("<aside"));
			html=html.substring(html.indexOf("<h5"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</h5")).replaceAll("<[^>]*>","").replace("By ","");
		}catch(Exception e){Main.debug.append("getAuthorAGE no work\n");return "The Age staff";}
	}
	/*
	 * NEWS FROM FRANCE
	 */
	/*Centre-presse*/
	protected static String getAuthorCentPre(){return "Centre-Presse Staff";}
	/*The Clicanoo*/
	protected static String getAuthorClic(){return "Clicanoo Staff";}
	/*Le Monde*/
	protected static String getAuthorLeM(String html){
		try{
			html=html.substring(html.indexOf("\"article__author-link\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a"));
		}catch(Exception e){Main.debug.append("getAuthorLeM no work\n");return "Le Monde Staff";}
	}
	/*FranceSoir*/
	protected static String getAuthorFrSo(){return "FranceSoir";}
	/*Est Republicain*/
	protected static String getAuthorESTR(String html){
		try{
			html=html.substring(html.indexOf("class=\"author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorESTR no work\n");return "Est republicain";}
	}
	/*
	 * NEWS FROM ISRAEL
	 */
	/*the Times of Israel*/
	protected static String getAuthorTOI(String html){
		try{
			html=html.substring(html.indexOf("\"byline\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","").replace("By ","").trim();
		}catch(Exception e){Main.debug.append("getAuthorTOI no work\n");return "Times of Israel";}
	}
	/*The globes*/
	protected static String getAuthorGLO(String html){
		try{
			html=html.substring(html.indexOf("\"articleAuthor\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","").trim();
		}catch(Exception e){Main.debug.append("getAuthorGLO no work\n");return "The Globes";}
	}
	/*JPOst*/
	protected static String getAuthorJPOst(String html){
		try{
			html=html.substring(html.indexOf("class=\"author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replace("By ","").trim();
		}catch(Exception e){Main.debug.append("getAuthorJPOst no work\n");return "Jpost";}
	}
	/*Haaretz*/
	protected static String getAuthorHAAre(String html){
		try{
			html=html.substring(html.indexOf("/misc/writers"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("<div")).replaceAll("<[^>]*>"," ").replaceAll("    ",", ");
		}catch(Exception e){Main.debug.append("getAuthorHAAre no work\n");return "Haaretz";}
	}
	/*Israeli News live*/
	protected static String getAuthorISRNews(String html){
		try{
			html=html.substring(html.indexOf("\"entry-author-name\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorISRNews no work\n");return "Israeli news";}
	}
	/*
	 * NEWS FROM RUSSIA
	 */
	/*The Moscow Times*/
	protected static String getAuthorTMT(){return "AFP";}
	/*RT.com*/
	protected static String getAuthorRTcom(){return "Russia Times";}
	/*Pravda*/
	protected static String getAuthorPRA(String html){
		try{
			html=html.substring(html.indexOf("\"source\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replaceAll("Author`s name","").trim();
		}catch(Exception e){Main.debug.append("getAuthorPRA no work\n");return "Pravda news";}
	}
	/*Tass*/
	protected static String getAuthorTASS(){return "TASS";}
	/*Sputnik news*/
	protected static String getAuthorSPUT(String html){
		try{
			html=html.substring(html.indexOf("rel=\"author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a"));
		}catch(Exception e){Main.debug.append("getAuthorSPUT no work\n");return "Sputnik News";}
	}
	/*
	 * NEWS FROM INDIA
	 */
	/*Times of India*/
	protected static String getAuthorTOIndia(){return "Times of India";}
	/*India Today*/
	protected static String getAuthorInTod(String html){
		try{
			html=html.substring(html.indexOf("\"posted-name\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorInTod no work\n");return "India Today";}
	}
	/*NDTV*/
	protected static String getAuthorNDTV(String html){
		try{
			html=html.substring(html.indexOf("\"pst-by_li\""));
			html=html.substring(html.indexOf("\"name\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorNDTV no work\n");return "NDTV staff";}
	}
	/*ZEE news*/
	protected static String getAuthorZEE(String html){
		try{
			html=html.substring(html.indexOf("/author/"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a"));
		}catch(Exception e){Main.debug.append("getAuthorZEE no work\n");return "ZEE news";}
	}
	/*Hindustan times*/
	protected static String getAuthorHindus(){return "PTI";}
	/*
	 * NEWS FROM BRAZIL
	 */
	/*Reuters*/
	protected static String getAuthorRET(String html){
		try{
			html=html.substring(html.indexOf("\"ArticleBody-byline-container-3H6dy"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("<div")).replaceAll("<[^>]*>","").replace("By ","");
		}catch(Exception e){Main.debug.append("getAuthorRET no work\n");return "Reuters";}
	}
	/*Anoticia*/
	protected static String getAuthorAN(String html){
		try{
			html=html.substring(html.indexOf(" Author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</div")).replace("Por ","").replaceAll("<!-- -->"," ").replaceAll("  ",", ").trim();
		}catch(Exception e){Main.debug.append("getAuthorAN no work\n");return "Anoticia";}
	}
	/*Anova*/
	protected static String getAuthorANO(String html){
		try{
			html=html.substring(html.indexOf("\"name\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorANO no work\n");return "Anova";}
	}
	/*The Rio Times*/
	protected static String getAuthorTRT(String html){
		try{
			html=html.substring(html.indexOf("\"td-author-by"));
			html=html.substring(html.indexOf("href"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorTRT no work\n");return "Times of Rio";}
	}
	/*Aljazeera*/
	protected static String getAuthorALJA(String html){
		try{
			html=html.substring(html.indexOf("author-link\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a"));
		}catch(Exception  e){Main.debug.append("getAuthorALJA no work\n");return "Aljazeera";}
	}
	/*
	 * NEWS FROM MEXICO
	 */
	/*Mexico News Daily*/
	protected static String getAuthorMND(String html){
		try{
			html=html.substring(html.indexOf("Source: "));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorMND no work\n");return "Mexico News Daily Staff";}
	}
	/*Mexico Today*/
	protected static String getAuthorMexTod(){return "Mexico Today Staff";}
	/*Banderas News*/
	protected static String getAuthorBand(String html){
		try{
			html=html.substring(html.indexOf("\"ByLine-AuthorName"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorBand no work\n");return "Banderas News Staff";}
	}
	/*Cambio de michogcan*/
	protected static String getAuthorCAM(String html){
		try{
			html=html.substring(html.indexOf("\"td-author-by"));
			html=html.substring(html.indexOf("href"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorCAM no work\n");return "Cambio de michogcan Staff";}
	}
	/*El Imparcial*/
	protected static String getAuthorElIm(String html){
		try{
			html=html.substring(html.indexOf("newsfull__author\""));
			html=html.substring(html.indexOf("<span")+6);
			return html.substring(0,html.indexOf("</")).trim();
		}catch(Exception e){Main.debug.append("getAuthorElIm no work\n");return "El Imparcial Staff";}
	}
	/*
	 * NEWS FROM GERMANY
	 */
	/*Arzietung*/
	protected static String getAuthorARZ(String html){
		try{
			html=html.substring(html.indexOf("class=\"author-names\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replace("Von ","");
		}catch(Exception e){Main.debug.append("getAuthorARZ no work\n");return "Arzte Zeitung staff";}
	}
	/*Aachen*/
	protected static String getAuthorAACH(String html){
		try{
			html=html.substring(html.indexOf(">Author<"));
			html=html.substring(html.indexOf("g>")+2);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","").trim();
		}catch(Exception e){Main.debug.append("getAuthorAACH no work\n");return "Aachen staff";}
	}
	/*Abendzeitung*/
	protected static String getAuthorABEND(){return "Abendzeitung staff";}
	/*Idowa*/
	protected static String getAuthorIDOWA(String html){
		try{
			html=html.substring(html.indexOf("\"article-details\""));
			html=html.substring(html.indexOf("author"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorIDOWA no work\n");return "Idowa staff";}
	}
	/*Remszeitung*/
	protected static String getAuthorREM(String html){
		try{
			html=html.substring(html.indexOf("\"author\""));
			html=html.substring(html.indexOf("\"name\": \"")+9);
			return html.substring(0,html.indexOf("\"")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorREM no work\n");return "Remszeitung staff";}
	}
	/*
	 * NEWS FROM ITALY
	 */
	/*ItalyNews.net*/
	protected static String getAuthorITN(String html){
		try{
			html=html.substring(html.indexOf("\"story__author"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).trim().replaceAll("&nbsp;","").replaceAll("\t","").replaceAll("[\\r\\n]+"," ");
		}catch(Exception e){Main.debug.append("getAuthorITN no work\n");return "The Italy News staff";}
	}
	/*Bresciaggi*/
	protected static String getAuthorBRES(){return "Bresciaggi staff";}
	/*Giornale Compania*/
	protected static String getAuthorGIO(){return "Giornale Compania staff";}
	/*Gay news*/
	protected static String getAuthorGAY(String html){
		try{
			html=html.substring(html.indexOf("\"jeg_meta_author"));
			html=html.substring(html.indexOf("href"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorGAY no work\n");return "Gay News staff";}
	}
	/*Ilpiccolo*/
	protected static String getAuthorIlpi(String html){
		try{
			html=html.substring(html.indexOf("entry_author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</"));
		}catch(Exception e){Main.debug.append("getAuthorIlpi no work\n");return "Ilpiccolo";}
	}
	/*
	 * NEWS FROM SOUTH KOREA
	 */
	/*The korean times*/
	protected static String getAuthorTKT(String html){
		try{
			html=html.substring(html.indexOf("By ")+3);
			return html.substring(0,html.indexOf("<"));
		}catch(Exception e){Main.debug.append("getAuthorTKT no work\n");return "Times of Korea";}
	}
	/*airang*/
	protected static String getAuthorAIR(String html){
		try{
			html=html.substring(html.indexOf("aNV_reporter\"")-150);
			html=html.substring(html.indexOf("<br")+4);
			return html.substring(0,html.indexOf("<")).trim();
		}catch(Exception e){Main.debug.append("getAuthorAIR no work\n");return "Airang staff";}
	}
	/*The Korean Herald*/
	protected static String getAuthorTKH(String html){
		try{
			html=html.substring(html.indexOf("view_tit_byline_l\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</")).replaceAll("<[^>]*>","").replace("By ","");
		}catch(Exception e){Main.debug.append("getAuthorTKH no work\n");return "The Korean Herald";}
	}
	/*Yonhap news*/
	protected static String getAuthorYON(){return "Yonhap news";}
	/*korea times*/
	protected static String getAuthorKoT(){return "The korea Times";}
	/*
	 * NEWS FROM JAPAN
	 */
	/*Japan Times*/
	protected static String getAuthorJapT(String html){
		try{
			html=html.substring(html.indexOf("\"credit"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("<"));
		}catch(Exception e){Main.debug.append("getAuthorJapT no work\n");return "Japan Times staff";}
	}
	/*Mainichi*/
	protected static String getAuthorMaiN(){return "Mainichi Japan";}
	/*Rafu*/
	protected static String getAuthorRAF(){return "Rafu Shimpo";}
	/*Asahi Shimbun*/
	protected static String getAuthorASahI(String html){
		try{
			html=html.substring(html.indexOf("EnArticleName\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("<")).replace("By ","");
		}catch(Exception e){Main.debug.append("getAuthorASahI no work\n");return "Asahi Shimbun";}
	}
	/*The Japan News*/
	protected static String getAuthorTJN(){return "The Japan News staff";}
	/*
	 * NEWS FROM NORTH KOREA
	 */
	/*NKNews*/
	protected static String getAuthorNKN(String html){
		try{
			html=html.substring(html.indexOf("\"text-underline"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("<"));
		}catch(Exception e){Main.debug.append("getAuthorNKN no work\n");return "NKNews staff";}
	}
	/*NewsNow North Korea*/
	protected static String getAuthorNKT(){return "NewsNow staff";}
	/*Daily NK*/
	protected static String getAuthorDNK(String html){
		try{
			html=html.substring(html.indexOf("td-author-by\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","").replace("By ","");
		}catch(Exception e){Main.debug.append("getAuthorDNK no work\n");return "Daily North Korea staff";}
	}
	/*KCNA north korea*/
	protected static String getAuthorKCNAnk(){return "KCNA watch";}
	/*Chosun.com*/
	protected static String getAuthorCHO(String html){
		try{
			html=html.substring(html.indexOf("news_title_author\""));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</li")).replaceAll("<[^>]*>","").replace("By ","").trim();
		}catch(Exception e){Main.debug.append("getAuthorCHO no work\n");return "Chosun.com staff";}
	}
	/*
	 * NEWS FROM CHINA
	 */
	/*Xinhua*/
	protected static String getAuthorXIN(){return "Xinhua";}
	/*China Daily*/
	protected static String getAuthorCHD(String html){
		try{
			html=html.substring(html.indexOf("\"info_l"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("|")).replace("By ","").trim();
		}catch(Exception e){Main.debug.append("getAuthorCHD no work\n");return "China Daily";}
	}
	/*The China Times*/
	protected static String getAuthorTCT(){return "China Times";}
	/*Shine*/
	protected static String getAuthorShine(String html){
		try{
			html=html.substring(html.indexOf("\"author-name"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("<"));
		}catch(Exception e){Main.debug.append("getAuthorShine no work\n");return "Shine staff";}
	}
	/*Sampan*/
	protected static String getAuthorSAM(String html){
		try{
			html=html.substring(html.indexOf("\"entry-author-name"));
			html=html.substring(html.indexOf(">")+1);
			return html.substring(0,html.indexOf("</a")).replaceAll("<[^>]*>","");
		}catch(Exception e){Main.debug.append("getAuthorSAM no work\n");return "Sampan";}
	}
}
