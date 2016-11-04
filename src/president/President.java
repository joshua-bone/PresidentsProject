package president;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class President {
	private String name;
	private String term;
	private String party;
	private String fact;
	private String imgURL;
	
	
	public President(String name, String term, String party, String fact, String imgURL) {
		super();
		this.name = name;
		this.term = term;
		this.party = party;
		this.fact = fact;
		this.imgURL = imgURL;
	}
	
	public President(){}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getFact() {
		return fact;
	}
	public void setFact(String fact) {
		this.fact = fact;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
	public static ArrayList<President> getPresidents(){
		ArrayList<President> presidents = new ArrayList<>();
		try(BufferedReader bufIn = new BufferedReader(new FileReader("presidents.txt"))){
			String line;
			while ((line=bufIn.readLine()) != null){
				String[] values = line.split(",");
				presidents.add(new President(values[1], 
						values[3].substring(values[3].length()-4) + "-" + values[4].substring(values[4].length()-4),
						values[5].trim(), "",""
						));
						
			}
		} catch (Exception e) {
			System.out.println("Could not load presidents");
		}
		return presidents;
	}
	
	
	@Override
	public String toString() {
		return "President [name=" + name + ", term=" + term + ", party=" + party + ", fact=" + fact + ", imgURL="
				+ imgURL + "]";
	}

	public static void main(String[] args) {
		ArrayList<President> ps = getPresidents();
		for (President p : ps){
			System.out.println(p);
		}
	}
}
