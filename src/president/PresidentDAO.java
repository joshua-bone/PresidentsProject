package president;

public interface PresidentDAO {
	
	void readFile(); 
	
	String getName();
	
	public void incremenetIndex();
	public void decrementIndex();
	public void setIndex(int i);

}
