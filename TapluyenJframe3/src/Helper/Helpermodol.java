package Helper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entities.Student;

public class Helpermodol {
	public static List<Student> imporfile(String file) {
		List<Student> student = new ArrayList<Student>();
		try {
			List<String> line = Files.readAllLines(Paths.get(file));
			for(String i : line) {
				String [] result = i.split(",");
				student.add(new Student(result[0],result[1],
						Double.parseDouble(result[2]),
						Integer.parseInt((result[3]).trim())));
				
			}
			
			
		} catch (Exception e) {
			System.out.println("fault");
		}
		return student;
	}

}
