	package president;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;

public class PresDAO implements PresidentDAO{
	
	private static final String filename = "presidents.txt";
	private ServletContext servletContext;
	private ArrayList<President> presidents = new ArrayList<>();
	private int index; 
	
	public PresDAO(ServletContext context){
	this.servletContext = context;
	}
	
	@Override
	public void readFile() {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/presidents.txt");
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line=buf.readLine()) != null){
				String[] values = line.split(",");
				presidents.add(new President(values[1], 
						values[3].substring(values[3].length()-4) + "-" + values[4].substring(values[4].length()-4),
						values[5].trim(), "https://www.whitehouse.gov/sites/default/files/imagecache/gallery_img_full/image/image_file/" + values[6].trim(),""
						));		
			}
		} catch (Exception e) {
			System.out.println("Could not load presidents");
		}
		//special case since Obama doesn't have a painted portrait yet
		presidents.get(presidents.size()-1).setImgURL("https://commons.wikimedia.org/wiki/File:Official_portrait_of_Barack_Obama.jpg");
	
	}
		
	public String getName() {
		return presidents.get(index).getName();
	}
	public String getParty(){
		return presidents.get(index).getParty();
	}
	public String getTerm(){
		return presidents.get(index).getTerm();
	}
	public String getFact(){		
		return presidents.get(index).getFact();
	}
	public String getImgURL(){		
		return presidents.get(index).getImgURL();
	}

	@Override
	public void incrementIndex() {
		if (index < presidents.size() - 1 ) index++; 
	}

	@Override
	public void decrementIndex() {
		if (index > 0) index--; 
	}

	@Override
	public void setIndex(int i) {
		this.index=i; 
		
	}

}
