package htwberlin.todolist.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class Utilitaries {

    public String convertSHA512(String message) {

        String result = "";
        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-512");


            digest.update(message.getBytes());


            byte[] hashedBytes = digest.digest();


            StringBuilder hexString = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                String hex = Integer.toHexString(0xff & hashedByte);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            result = hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String generateUniqueString() {
        LocalDateTime now = LocalDateTime.now();

        long timestamp = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();


        UUID uuid = new UUID(0, timestamp);


        String uniqueString = uuid.toString();

        return uniqueString;
    }


}
