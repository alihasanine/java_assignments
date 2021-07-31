import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Pyramid> pyramids;
		
		pyramids = PyramidCSVDAO.readPyramidCSV("pyramids.csv");
		
		for(Pyramid p : pyramids)
			System.out.println(p.toString());;
	}

}
