import java.util.Scanner
;
import java.io.*;

public class rabbiKey {
	public static Scanner choice = new Scanner(System.in);
	
	public static void main(String[] args) {
		int rabbiCode = 0;
		String rabbiName = "";
		String rebbetzinName = "";
		System.out.println("Know your shliach!\n");
		System.out.println("You will be asked a series of questions to identify a rabbi at this retreat. Each question has two responses: A and B. Pick whichever one is most accurate for you.\n");
		System.out.println("First of all, does your rabbi have black hair? A: Yes B: No");
		char iChoose = answer();
		if(iChoose == 'A'){
			System.out.println("Does your rabbi wear glasses? A: Yes B: No");
			iChoose = answer();
			if(iChoose == 'A') {
					System.out.println("Does his wife wear glasses? A: Yes B: No");
					iChoose = answer();
					if(iChoose == 'A') {
						rabbiCode = 9;
					}
					else {
						System.out.println("Is your rabbi's face more broad or narrow? A: Broad B: Narrow");
						iChoose = answer();
						if(iChoose == 'A'){
							System.out.println("Is his wife paler than he is? A: Yes B: No");
							iChoose = answer();
							if(iChoose == 'A'){
								rabbiCode = 8;
							}
							else{
								rabbiCode = 10;
							}
						}
						else {
								System.out.println("Which more accurately describes your rabbi's hair and beard? A: Thick and smooth B: Patchy");
								iChoose = answer();
								if(iChoose == 'A') {
								rabbiCode = 2;
								}
								else{
								rabbiCode = 11;
								}
							}
						}
					}
			
			else{
				rabbiCode = 1;
			}
		}
		else {
			System.out.println("Is your rabbi's hair visibly reddish in color? A: Yes B: No");
			iChoose = answer();
			if(iChoose == 'A') {
				System.out.println("How much gray does your rabbi have in his hair? A: A lot B: Very little");
				iChoose = answer();
				if(iChoose == 'A'){
					rabbiCode = 3;
				}
				else{
					rabbiCode = 4;
				}
			}
			else{
				System.out.println("How long is your rabbi's beard? A: Quite short B: Long");
				iChoose = answer();
				if(iChoose == 'A'){
					rabbiCode = 5;
				}
				else{
					System.out.println("How much hair does your rabbi have on top of his head? A: A fair amount B: Very little");
					iChoose = answer();
					if(iChoose == 'A'){
						rabbiCode = 6;
					}
					else{
						rabbiCode = 7;
					}
				}
			}
		}
		
		switch (rabbiCode) {
			
			case 1:
				rabbiName = "Hilel";
				rebbetzinName = "Miki";
				break;
			case 2:
				rabbiName = "Sharfstein";
				rebbetzinName = "Shifra";
				break;
			case 3:
				rabbiName = "Lazaroff";
				rebbetzinName = "Manya";
				break;
			case 4:
				rabbiName = "Boyarsky";
				rebbetzinName = "Yocheved";
				break;
			case 5:
				rabbiName = "Creeger";
				rebbetzinName = "Dina";
				break;
			case 6:
				rabbiName = "Friedman";
				rebbetzinName = "Shashie";
				break;
			case 7:
				rabbiName = "Liberow";
				rebbetzinName = "Rivka";
				break;
			case 8:
				rabbiName = "Waks";
				rebbetzinName = "Devorah";
				break;
			case 9:
				rabbiName = "Rothstein";
				rebbetzinName = "Chasi";
				break;
			case 10:
				rabbiName = "Bekerman";
				rebbetzinName = "Chanah Leah";
				break;
			case 11:
				rabbiName = "Gourarie";
				rebbetzinName = "Miri";
				break;			
		}
		
		System.out.println("Your shliach is Rabbi " + rabbiName + "!");
		System.out.println("His wife's name is " + rebbetzinName + "!");

	}
	
	public static char answer() {
		char chosen;
		do {
			System.out.println("Please pick one");
			String myChoice = choice.nextLine();
			String myAnswer = myChoice.toUpperCase();
			chosen = myAnswer.charAt(0);
		} while(chosen != 'A' && chosen != 'B');
		return chosen;
	}
	
}