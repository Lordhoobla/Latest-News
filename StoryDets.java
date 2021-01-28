public class StoryDets {
	protected static String uri,country,desc,title;
	  public StoryDets(String u,String c,String d,String t){
	    uri=u;country=c;desc=d;title=t;
	  }
	  public String toString(){
	    return country+"\n\n"+title+"\n\n"+desc;
	  }
}
