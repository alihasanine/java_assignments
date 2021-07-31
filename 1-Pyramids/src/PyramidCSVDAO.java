
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PyramidCSVDAO {

public static List <Pyramid> readPyramidCSV(String fileName){
	ArrayList<Pyramid> pyramids = new ArrayList<Pyramid>();
	File pyramid_csv = new File(fileName);
	
	try {
		String [] line;
		Scanner fileInput = new Scanner(pyramid_csv);
		fileInput.nextLine();
		while(fileInput.hasNextLine()) {
		
			line = fileInput.nextLine().split(",");
			pyramids.add(createPyramid(line));
		}
		fileInput.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return pyramids;
}

private static Pyramid createPyramid(String [] line) {
	String pharaoh = line[0];
	String modern_name = line[2];
	double lat = Double.parseDouble(line[10]);
	double lon = Double.parseDouble(line[11]);
	
	//System.out.println(line[0]);
	//System.out.println(line[2]);
	//System.out.println(line[10]);
	//System.out.println(line[11]);
	return new Pyramid(pharaoh , modern_name , lat , lon);
	
}
}
