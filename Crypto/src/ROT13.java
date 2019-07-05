import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private int shift;
    private int decrypt;

    ROT13(Character cs, Character cf) {
        shift = cf - cs;
        decrypt = Math.abs(cs - cf);
    }

    ROT13() {
        shift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        String result ="";

        for (int i = 0; i < text.length(); i++) {
            if(validChar(text.charAt(i))){
                if(Character.isUpperCase(text.charAt(i))){
                    if((int)text.charAt(i) + shift <= 90){
                        result += (char)((int)text.charAt(i) + shift);
                    }else
                        result += Character.toString((char)( ((((int)text.charAt(i) + shift) - 90) + 64) ));

                }else{
                    if((int)text.charAt(i) + shift <= 122){
                        result += (char)((int)text.charAt(i) + shift);
                    }else
                        result += Character.toString((char)( ((((int)text.charAt(i) + shift) - 122) + 96) ));
                }
            } else
                result += text.charAt(i);
        }

        return result;
    }

    private Boolean validChar(Character chara){
        if((int)chara >= 65 && (int)chara <= 90){
            return true;
        }

        if( (int)chara >= 97 && (int)chara <= 122 ){
            return true;
        }

        return false;
    }

    public String encrypt(String text) {
        String result ="";

        for (int i = 0; i < text.length(); i++) {
            if(validChar(text.charAt(i))){
                if(Character.isUpperCase(text.charAt(i))){
                    if((int)text.charAt(i) + shift <= 90){
                        result += (char)((int)text.charAt(i) + shift);
                    }else
                        result += Character.toString((char)( ((((int)text.charAt(i) + shift) - 90) + 64) ));

                }else{
                    if((int)text.charAt(i) + shift <= 122){
                        result += (char)((int)text.charAt(i) + shift);
                    }else
                        result += Character.toString((char)( ((((int)text.charAt(i) + shift) - 122) + 96) ));
                }
            } else
                result += text.charAt(i);
        }

        return result;
    }

    public String decrypt(String text) {
        String result ="";

        for (int i = 0; i < text.length(); i++) {
            if(validChar(text.charAt(i))){
                if(Character.isUpperCase(text.charAt(i))){
                    if((int)text.charAt(i) - decrypt >= 65){
                        result += (char)((int)text.charAt(i) - decrypt);
                    }else
                        result += Character.toString((char)( 90 - ( decrypt - ((int)text.charAt(i) - 64))) );

                }else{
                    if((int)text.charAt(i) - decrypt >= 97){
                        result += (char)((int)text.charAt(i) - decrypt);
                    }else{
                        result += Character.toString((char)( 122 - ( decrypt - ((int)text.charAt(i) - 96))) );

                    }
                }
            } else
                result += text.charAt(i);
        }

        return result;
    }

    public static String rotate(String s, Character c) {
        Integer shift = findRotShift(s, c);
        StringBuilder string = new StringBuilder();

        for (int i = 0; i <s.length() ; i++) {
            if(i + shift < s.length()){
                string.append(s.charAt(i + shift));
            }else
                string.append(s.charAt(i - shift));

        }
        return string.toString();
    }

    private static Integer findRotShift(String s, Character c){
        Integer counter = 0;
        for (char each : s.toCharArray()) {
            if(each == c){
                return counter;
            }
            counter++;
        }

        return null;
    }

}
