package president;

public interface PresidentDAO {
	public void readFile();
	public String getName();
	public String getParty();
	public String getTerm();
	public String getFact();
	public String getImgURL();
	public void readFactFile();
	public void incrementIndex();
	public void decrementIndex();
	public void setIndex(int i);
}
