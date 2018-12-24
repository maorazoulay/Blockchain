package blockchain;


public class Utils {
    
    public static String zeros(int length){
        StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            stringBuilder.append('0');
        }
        return stringBuilder.toString();
    }
}
