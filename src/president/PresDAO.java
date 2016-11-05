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
		InputStream is = servletContext.getResourceAsStream("presidents.txt");
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			while ((line=buf.readLine()) != null){
				String[] values = line.split(",");
				presidents.add(new President(values[1], 
						values[3].substring(values[3].length()-4) + "-" + values[4].substring(values[4].length()-4),
						values[5].trim(), "",""
						));		
			}
		} catch (Exception e) {
			System.out.println("Could not load presidents");
		}
	
	}
		
	

	@Override
	public String getName() {
		String name = presidents.get(index) .getName();
		return name;
	}

	@Override
	public void incrementIndex() {
		index++; 
		
	}

	@Override
	public void decrementIndex() {
		index--; 
		
	}

	@Override
	public void setIndex(int i) {
		this.index=i; 
		
	}

}
