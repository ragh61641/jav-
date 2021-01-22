import java.util.List;

public class Detective extends Player {

    private int position;


	public Detective(String name, String role,int position) {
		super(name, role);
		this.position=position;
		
	}




	public int getPosition() {
		return position;
	}




	public void setPosition(int position) {
		this.position = position;
	}

	
         
   
}