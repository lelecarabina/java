import java.nio.file.*;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.util.Scanner;

public class WriteEmployeeFile {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Path file = Paths.get("Employees.txt");
		String s = "";
		String delimiter = ",";
		int id;
		String name;
		double payRate;
		final int QUIT = 999;
		
		try{
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, APPEND)); 
			//or: OutputStream output = Files.newOutputStream(file, APPEND);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
			
			System.out.println("Enter employee number: ");
			id = input.nextInt();
			
			while(id != QUIT) {
				System.out.println("Enter name for employee # " + id + ": ");
				input.nextLine();
				name = input.nextLine();
				
				System.out.println("Enter pay rate: ");
				payRate = input.nextDouble();
				
				s = id + delimiter + name + delimiter + payRate;
				writer.write(s, 0, s.length()); //Accepts string s from position 0 all the way to its length
				writer.newLine();
				
				System.out.println("Enter next ID number or " + QUIT + " to quit: ");
				id = input.nextInt();		
			}
			
			writer.close();
			output.close();
			System.out.println("Program ended.");	
		}
		catch(IOException e) {
			e.getMessage();	
		}
		
		input.close();
	}
}
