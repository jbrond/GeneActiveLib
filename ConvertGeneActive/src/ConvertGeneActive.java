import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ConvertGeneActive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.err.println("usage: ConvertGeneActive filename");
			return;
		}
		
		File file = new File(args[0]);
		
		BufferedReader br;
		try {
			int n = 0;
			br = new BufferedReader(new FileReader(file));
			
			FileWriter fstream = new FileWriter(args[1]);
	        BufferedWriter out = new BufferedWriter(fstream);
			
			String line;
			//Read the header
			while ((line = br.readLine()) != null && n<101) {
			   // process the line.
				//System.out.println(line);
				n++;
			}
			
			
			n = 0;
			while ((line = br.readLine()) != null && n<1143000) {
				   // process the line.
					//System.out.println(line);
					
					String[] elements = line.split(",");
					
					String cvsStr = String.format("%s,%s,%s%n", elements[1],elements[2],elements[3]);
					
					out.write(cvsStr);
					
					n++;
				}
			
			br.close();
			out.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
