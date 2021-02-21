import java.lang.String;
/***************************************************************************************************************
 * Holds the information for each article
 * @use - to create a story, follow these steps:
 * 	1: create an object of Story with the proper parameters
 * 	2: call to setAuthor(String) to get the author
 * 	3: All information is set, use the toString or get methods to retrieve information for each object
 * 
 * 	EX: Story x = new Story("<Title of article>", "<https://title-of-article.com>", "<News Station>");
 * 		x.setAuthor(x.getUrl());
 * 		System.out.print(x);
 * 
 * 		"title: <Title of article>
 * 		 url: <https://title-of-article.com>
 * 		 publication: <News Station>
 * 		 author: <author of article>"
 * 
 * @author - Nobody
 ***************************************************************************************************************/
public class Story{
	private String title,url,publication,author;
	/**
	 * Constructor for the class, holds information
	 * @param x - title of article
	 * @param y - url for the article
	 * @param z - publication source
	 */
	public Story(String x,String y,String z){title=x;url=y;publication=z;}
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
	 * Works through the citation machine to set the author of the Article
	 * @param url - url of the article
	 * @return a boolean that says says whether it worked or not
	 */
	protected boolean setAuthor(String url){
		try{
			return true;
		}catch(Exception e){
			Main.debug.append("Citation not working, (probably bad url)\n");
			author=publication;
			return false;}
	}
}
