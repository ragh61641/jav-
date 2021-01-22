
public class Play {
	static int Tour;//tour impair correspond aux detectives et tour pair au Mr jack

	public static int getTour() {
		return Tour;
	}

	public void setTour(int tour) {
		Play.Tour =Play.Tour+1; // Play.Tour+=1;
	}
	

	public Play(int Tour) {
		super();
		Play.Tour = Tour;
	}
	
	

}
