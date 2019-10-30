package hash;

import java.util.HashSet;
import java.util.Set;

public class lc929 {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) {
            return 0;
        }
        Set<String> hash = new HashSet<>();
        for (String s : emails) {
            String modify = helper(s);
            hash.add(modify);
        }

        return hash.size();
    }

    public String helper(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') {
                continue;
            }
            if (c == '@') {
                sb.append(s.substring(i));
                break;
            } else if (c == '+') {
                flag = true;
            } else {
                if (flag == false) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
