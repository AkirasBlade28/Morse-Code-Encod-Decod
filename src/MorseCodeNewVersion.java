import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MorseCodeNewVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var toWords = new MorseAlfabetX(".... .- .-. .-. -.--  .... .- -.-. -.- . .-. --..--  .. ...  -.-"
				+ " --. -...  .- --. . -. - -.-.-- -.-.-- -.-.--  .-- .  .... .- ...- .  -... . . -.  .--."
				+ " .-.. .- -.-- . -..  .- .-.. .-..  .- .-.. .-.. --- -. --.  ");
		var toMorse = new MorseAlfabetX("HARRY HACKER, IS KGB AGENT!!! WE HAVE BEEN PLAYED ALL ALLONG");
		System.out.println(toWords.morseDecoderStr());
		System.out.println(toMorse.morseEncoderStr());
	}

}
class MorseAlfabetX{ 
	private HashMap <String, String> mapEncode;
	private HashMap<String,String> mapDecode;
	private String input;
	
	public MorseAlfabetX (String s) {//c
		this.input = s;
	}
	

	private HashMap<String,String> MorseDecode(){// for decoding
		this.mapDecode = new HashMap<>();
		mapDecode.put(".-", "A");
		mapDecode.put("-...", "B");
		mapDecode.put("-.-.", "C");
		mapDecode.put("-..", "D");
		mapDecode.put(".", "E");
		mapDecode.put("..-.", "F");
		mapDecode.put("--.", "G");
		mapDecode.put("....", "H");
		mapDecode.put("..", "I");
		mapDecode.put(".---", "J");
		mapDecode.put("-.-","K");
		mapDecode.put(".-..", "L");
		mapDecode.put("--", "M");
		mapDecode.put("-.", "N");
		mapDecode.put("---", "O");
		mapDecode.put(".--.", "P");
		mapDecode.put("--.-", "Q");
		mapDecode.put(".-.", "R");
		mapDecode.put("...", "S");
		mapDecode.put("-", "T");
		mapDecode.put("..-", "U");
		mapDecode.put("...-","V");
		mapDecode.put(".--", "W");
		mapDecode.put("-..-", "X");
		mapDecode.put("-.--", "Y");
		mapDecode.put("--..", "Z");
		mapDecode.put(".----", "1");
		mapDecode.put("..---", "2");
		mapDecode.put("...--", "3");
		mapDecode.put("....-", "4");
		mapDecode.put(".....", "5");
		mapDecode.put("-....", "6");
		mapDecode.put("--...", "7");
		mapDecode.put("---..", "8");
		mapDecode.put("----.", "9");
		mapDecode.put("-----", "0");
		mapDecode.put("..--..", "?");
		mapDecode.put("-.-.--", "!");
		mapDecode.put(".-.-.-", ".");
		mapDecode.put("--..--", ",");
		mapDecode.put("-.-.-.", ";");
		mapDecode.put("---...", ":");
		mapDecode.put(".-.-.", "+");
		mapDecode.put("-....-", "-");
		mapDecode.put("-..-.", "/");
		mapDecode.put("-...-", "=");
		
		return mapDecode;		
	}
	
	private HashMap<String, String> MorseEncode(){// for encoding
		this.mapEncode = new HashMap<>();
		mapEncode.put("A", ".-");
		mapEncode.put("B", "-...");
		mapEncode.put("C", "-.-.");
		mapEncode.put("D", "-..");
		mapEncode.put("E", ".");
		mapEncode.put("F", "..-.");
		mapEncode.put("G", "--.");
		mapEncode.put("H", "....");
		mapEncode.put("I", "..");
		mapEncode.put("J", ".---");
		mapEncode.put("K", "-.-");
		mapEncode.put("L", ".-..");
		mapEncode.put("M", "--");
		mapEncode.put("N", "-.");
		mapEncode.put("O", "---");
		mapEncode.put("P", ".--.");
		mapEncode.put("Q", "--.-");
		mapEncode.put("R", ".-.");
		mapEncode.put("S", "...");
		mapEncode.put("T", "-");
		mapEncode.put("U", "..-");
		mapEncode.put("V", "...-");
		mapEncode.put("W", ".--");
		mapEncode.put("X", "-..-");
		mapEncode.put("Y", "-.--");
		mapEncode.put("Z", "--..");
		mapEncode.put("1", ".----");
		mapEncode.put("2", "..---");
		mapEncode.put("3", "...--");
		mapEncode.put("4", "....-");
		mapEncode.put("5", ".....");
		mapEncode.put("6", "-....");
		mapEncode.put("7", "--...");
		mapEncode.put("8", "---..");
		mapEncode.put("9", "----.");
		mapEncode.put("0", "-----");
		mapEncode.put("?", "..--..");
		mapEncode.put("!", "-.-.--");
		mapEncode.put(".", ".-.-.-");
		mapEncode.put(",", "--..--");
		mapEncode.put(";", "-.-.-.");
		mapEncode.put(":", "---...");
		mapEncode.put("+", ".-.-.");
		mapEncode.put("-", "-....-");
		mapEncode.put("/", "-..-.");
		mapEncode.put("=", "-...-");
		return mapEncode;
		}
	
	private List<String> setInListStringWords(){
		input+=" "; ///add space for .isBlank method so it can   // ..to be translated word for word..
		//check the last chars	
		
		List <String> list = new ArrayList<>();
		String whatMorse = "";
		int lineOfMorse = 1;
		
		for(int i=0; i<input.length(); ++i) {
			whatMorse = whatMorse+input.substring(i, lineOfMorse);
			list.add(whatMorse);
			whatMorse = ""; // reset
			++lineOfMorse;
		}
		
		return list;
	}
	
	public String morseDecoderStr () {
		List<String> l = setInListStringWords();
		HashMap<String,String> map = MorseDecode();
		String s = "";
		String result = "";
		//check list and merge elements with spacing rule 
		for(int i=0; i<l.size(); ++i) {
			if(!l.get(i).isBlank())
				s = s + l.get(i);
			if(l.get(i).isBlank()) {
				if(map.get(s)==null) 
					result += " ";
				if(map.get(s)!=null)
				result += map.get(s);
				s = "";
			}
			
		}
		result = result.replaceAll("( )+", " "); // trim the excess spacing 
		return result;
	}
	public String morseEncoderStr () {
		List<String> l = setInListStringWords();
		HashMap<String,String> map = MorseEncode();
		String s = "";
		String result = "";
		//check list and merge elements with spacing rule 
		for(int i=0; i<l.size(); ++i) {
			if(!l.get(i).isBlank())
				s = map.get(l.get(i));
				result += s+" ";
			if(l.get(i) == " ") { // one space 
				result = result + "  "; //+ 2 spaces
				s = "";
			}
			s = "";
			
		}
		return result;
	}
	
}