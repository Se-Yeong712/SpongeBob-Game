package views;

public class ranking {

	public String name;
	public int score;
	
	
	public ranking(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
}
