import java.io.*;

public class Matching
{
	
	public static void main(String args[])
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		MyHashTable ht = new MyHashTable();

		while (true)
		{
			try
			{
				String input = br.readLine();
				if (input.compareTo("QUIT") == 0)
					break;

				command(input, ht);
			}
			catch (IOException e)
			{
				System.out.println("입력이 잘못되었습니다. 오류 : " + e.toString());
			}
		}
	}

	private static void command(String input, MyHashTable ht) throws IOException
	{
		Commander cmd = new Commander(input);
		cmd.work(ht);
		
	}
	
	
}