import java.util.*;

public class OTPGenerator {

    public static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }

    public static boolean areOTPsUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps) {
            set.add(otp);
        }
        return set.size() == otps.length;
    }

    public static void main(String[] args) {
        int[] otpList = new int[10];

        for (int i = 0; i < 10; i++) {
            otpList[i] = generateOTP();
            System.out.println("OTP " + (i + 1) + ": " + otpList[i]);
        }

        if (areOTPsUnique(otpList)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Duplicate OTPs found.");
        }
    }
}
