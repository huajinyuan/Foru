package com.forudesigns.foru.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompileUtil {
    /*public static boolean IsPhone(String phonestr) {

		boolean flag;
		// String phoneStr = phone.getText ( ).toString ( ).trim ( );
		if (phonestr.equals("")) {
			flag = false;
		} else {
			Pattern p = Pattern.compile("^1[3,4,5,7,8]+\\d{9}");
			Matcher m = p.matcher(phonestr);
			m.matches();
			if (m.matches()) {
				flag = true;
			} else {
				flag = false;
			}
		}

		return flag;
	}*/

    public static boolean IsEmail(String email) {
        Pattern pattern = Pattern.compile("[^@] + @+[^@]");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean IstruePWD(String pwd) {
        boolean flag = false;
        Pattern p = Pattern.compile("^[^\\s^\u4e00-\u9fa5]{6,20}$");
        Matcher m = p.matcher(pwd);
        m.matches();
        if (m.matches()) {
            flag = true;

        } else {
            flag = false;
        }
        return flag;
    }

    public static boolean IsStartWithLetter(String str) {
        if ((65 <= str.getBytes()[0] && str.getBytes()[0] <= 90) || (97 <= str.getBytes()[0] && str.getBytes()[0] <= 122)) {
            return true;
        } else {
            return false;
        }
    }

}
