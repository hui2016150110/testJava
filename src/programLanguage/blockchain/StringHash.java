package programLanguage.blockchain;

import java.security.MessageDigest;

//创建自己的Hash
public class StringHash {
    public static String createHash(String preHash){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //Applies sha256 to our input,
            byte[] hash = digest.digest(preHash.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
