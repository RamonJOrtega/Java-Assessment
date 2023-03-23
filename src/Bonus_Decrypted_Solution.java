import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Bonus_Decrypted_Solution {

    private static final String KEY = "MOEBIUS";

    public static void main(String[] args) {
        String encryptedMessage = 
            "DiArJTs0JzgjJDYgOj0+Y2U7JiBzPiApNCwxczknIGIrO" +
            "j04PGUzPDAgOSYqLGhfWW1vZWJpdXNtb2ViaXVzbW9lYm" +
            "l1c21vZWJpdXNtb2ViaXVzY2hibEN1c21vZWJpe3RqYWV" +
            "iaXVzbWFlYml1c21vZWhucnltb2VicwoPYhB/Yml1c21h" +
            "T2JpdXNtb38dFXoMd29lYhYJe2IQZWJnb31nEBltFn9zbW9" +
            "/YmYJc3dvZWxue2ljaGtIaXV9amhreGl6D211ZWJpe3xkE2" +
            "ViaXJpamVlbRV1eW11ZWJue31qYWViZGhpInV4b0N1aRITa" +
            "h1zcn13dX9saXVzbWhlaG5yeW1vZWJjdXRjaGpsbnUMEWdq" +
            "HW57dHdoa2VDdWltYBlic3Vpd3V/eGl1c21vbx0Vegxnb2V" + 
            "iaXV+cG8qYnR4c21gbB5pdXNtaE9iaXJ9Y2hlYm5vaXdoZW" +
            "JpdXNnb2oeaX9zbW9lYmdyfGNoa2JpdXRHb2ViaXVzbW9lY" +
            "ml1c21vZWJpdXljYW9iaXVzbW9lYmlvWQ==";
        String decryptedMessage = decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    private static String decrypt(String encryptedMessage) {
        byte[] decodedBytes = Base64.getMimeDecoder().decode(encryptedMessage);
        byte[] keyBytes = KEY.getBytes(StandardCharsets.US_ASCII);
        byte[] decryptedBytes = new byte[decodedBytes.length];

        for (int i = 0; i < decodedBytes.length; i++) {
            decryptedBytes[i] = (byte) (decodedBytes[i] ^ keyBytes[i % keyBytes.length]);
        }

        return new String(decryptedBytes, StandardCharsets.US_ASCII);
    }
}
