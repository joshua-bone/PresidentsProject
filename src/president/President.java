package president;

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
	
}
