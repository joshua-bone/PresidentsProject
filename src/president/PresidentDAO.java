package president;

public interface PresidentDAO {
	public void readFile();
	public void readFactFile(); 
	public String getName();
	public String getParty();
	public String getTerm();
	public String getFact();
	public String getImgURL();
	public void incrementIndex();
	public void decrementIndex();
	public void setIndex(int i);
	public boolean implementFilter(String n);
	public int getNthTerm();
}
