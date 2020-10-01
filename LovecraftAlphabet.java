import java.util.*;
import java.io.*;

public class LovecraftAlphabet {
	
	private static boolean test;
	
	public static void main(String[] args){
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		String[] names = {"Abdul Alhazred", "Black Goat", "Cthulhu", "Deep Ones", "Eldritch", "Fear", "Ghouls", "Hastur", "Innsmouth", "John Raymond Legrasse", "K'n-Yan", "Lovecraft", "Miskatonic University", "Necronomicon", "Old Ones", "Providence", "Q'yth-az", "R'lyeh", "Shoggoth", "Tiara of Dagon", "Unnamable", "Vigilant", "Witch House", "Xiurhn", "Yog-Sothoth", "Zombies"};
			
		HashMap<Character, String> alphabet = new HashMap<Character, String>();
		for(int i = 0; i < 26; i++){
			alphabet.put(letters[i], names[i]);
		}
		System.out.println("Welcome to the Lovecraft alphabet search! Please, enter a letter of the alphabet!");
		Scanner getLetter = new Scanner(System.in);
		String s = getLetter.nextLine().toUpperCase();
		char input = s.charAt(0);
		test = false;
		check(letters, input);
		while(test == false)
		{
			System.out.println("Sorry, that is not a letter of the alphabet. Please try again.");
			s = getLetter.nextLine().toUpperCase();
			input = s.charAt(0);
			check(letters, input);
			
		}
		String wantedName = alphabet.get(input);
		System.out.println("The letter you chose stands for " + wantedName);
		System.out.println("Now enter the name of a file and we'll tell you if the word appears in it!");
		Scanner getFile = new Scanner(System.in);
		String fileName = getFile.nextLine();
		String fileText = "";
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null){
				fileText += str;
			}
			br.close();
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
		String phrase = fileText.toUpperCase();
		String[] splitPhrase = phrase.split("\\W+");
		int wordAppears = 0;
		if(wantedName.contains(" "))
		{
			int numSpaces = 0;
			for(int o = 0; o < wantedName.length(); o++)
			{
				if(wantedName.charAt(o) == ' ')
				{
					numSpaces += 1;
				}
				String mergedPhrase = "";
				if(numSpaces == 1)
				{
					for(int p = 0; p < splitPhrase.length - 1; p++)
					{
						mergedPhrase = splitPhrase[p] + " " + splitPhrase[p + 1];
						if(mergedPhrase.equals(wantedName.toUpperCase()))
						{
							wordAppears += 1;
						}
					}
				}
				else if(numSpaces == 2)
				{
					for(int q = 0; q < splitPhrase.length - 2; q++)
					{
						mergedPhrase = splitPhrase[q] + " " + splitPhrase[q + 1] + " " + splitPhrase[q + 2];
						if(mergedPhrase.equals(wantedName.toUpperCase()))
						{
							wordAppears += 1;
						}
					}
				}
			}
		}
		else{
		for(int a = 0; a < splitPhrase.length; a++)
		{
			if(splitPhrase[a].equals(wantedName.toUpperCase()))
			{
				wordAppears += 1;
			}
		}
		}
		System.out.println("This word appears " + String.valueOf(wordAppears) + " times in this file");
	}
	
	
	private static void check(char[] array, char inputChar)
	{
		for(int m = 0; m < array.length; m++)
		{
			if(array[m] == inputChar)
			{
				test = true;
			}
		}
	}
	
	
}