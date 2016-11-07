package president;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.servlet.ServletContext;

public class PresDAO implements PresidentDAO {

	private static final String filename = "presidents.txt";
	private ServletContext servletContext;
	private ArrayList<President> filterList;
	private ArrayList<President> presidents = new ArrayList<>();
	// private ArrayList<String> fact = new ArrayList<>();
	private int index;

	public PresDAO(ServletContext context) {
		this.servletContext = context;
		readFile();
		readFactFile();
		setIndex(0);
	}

	@Override
	public void readFile() {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/presidents.txt");
		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			String line;
			int counter = 0;
			while ((line = buf.readLine()) != null) {
				String[] values = line.split(",");
				presidents
						.add(new President(values[1],
								values[3].substring(values[3].length() - 4) + "-"
										+ values[4].substring(values[4].length() - 4),
								values[5].trim(), null,
								"https://www.whitehouse.gov/sites/default/files/imagecache/gallery_img_full/image/image_file/"
										+ values[6].trim(),
								(counter++) + 1));
				filterList = presidents;
			}
		} catch (Exception e) {
			System.out.println("Could not load presidents");
		}
		// special case since Obama doesn't have a painted portrait yet
		presidents.get(presidents.size() - 1)
				.setImgURL("https://upload.wikimedia.org/wikipedia/commons/e/e9/Official_portrait_of_Barack_Obama.jpg");

	}

	public void readFactFile() {
		InputStream is = servletContext.getResourceAsStream("WEB-INF/PresidentFacts.txt");

		try (BufferedReader buf = new BufferedReader(new InputStreamReader(is))) {
			int index = 0;
			String line;
			while ((line = buf.readLine()) != null) {
				presidents.get(index++).setFact(line);
			}

		} catch (IOException ioe) {
			System.out.println("Could not load presidents fact file");
		}
	}

	public boolean implementFilter(String filter) {
		boolean matches = false;
		if (filter.equals("")) {
			filterList = presidents;
			index = 0;
		} else {
			ArrayList<President> newList = new ArrayList<President>();
			for (President p : presidents) {
				if (p.toString().contains(filter)) {
					newList.add(p);
				}
			}
			if (newList.size() > 0){
				filterList = newList;
				index = 0;
				matches = true;
			}
		}
		return matches;
	}

	public String getName() {
		return filterList.get(index).getName();
	}

	public String getParty() {
		return filterList.get(index).getParty();
	}

	public String getTerm() {
		return filterList.get(index).getTerm();
	}

	public String getFact() {
		return filterList.get(index).getFact();
	}

	public String getImgURL() {
		return filterList.get(index).getImgURL();
	}

	@Override
	public void incrementIndex() {
		if (index < filterList.size() - 1)
			index++;
	}

	@Override
	public void decrementIndex() {
		if (index > 0)
			index--;
	}

	@Override
	public void setIndex(int i) {
		if (i >= 0 && i < filterList.size()) {
			this.index = i;
		}
	}

	@Override
	public int getNthTerm() {
		return filterList.get(index).getNthTerm();
	}

}
