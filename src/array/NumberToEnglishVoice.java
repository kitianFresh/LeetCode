package array;

import java.util.HashMap;

class NumberToEnglishVoice {
    static HashMap<Integer, String> units = new HashMap<Integer, String>();
    static {
        units.put(0, "Zero");
        units.put(1, "One");
        units.put(2, "Two");
        units.put(3, "Three");
        units.put(4, "Four");
        units.put(5, "Five");
        units.put(6, "Six");
        units.put(7, "Seven");
        units.put(8, "Eight");
        units.put(9, "Nine");
        units.put(10, "Ten");
        units.put(11, "Eleven");
        units.put(12, "Twelve");
        units.put(13, "Thirteen");
        units.put(14, "Fourteen");
        units.put(15, "Fifteen");
        units.put(16, "Sixteen");
        units.put(17, "Seventeen");
        units.put(18, "Eighteen");
        units.put(19, "Nineteen");
        units.put(20, "Twenty");
        units.put(30, "Thirty");
        units.put(40, "Forty");
        units.put(50, "Fifty");
        units.put(60, "Sixty");
        units.put(70, "Seventy");
        units.put(80, "Eighty");
        units.put(90, "Ninety");
        units.put(100, "Hundred");
    }
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int d1 = num % 1000;
        int d2 = num / 1000 % 1000;
        int d3 = num / 1000000 % 1000;
        int d4 = num / 1000000000 % 1000;
        String words = "";
        if (d4 != 0) {
            String space = words == ""?"": " ";
            words += space + groupToWords(d4, " Billion");
        }
        if (d3 != 0) {
            String space = words == ""?"": " ";
            words += space + groupToWords(d3, " Million");
        }
        if (d2 != 0) {
            String space = words == ""?"": " ";
            words += space + groupToWords(d2, " Thousand");
        }
        if (d1 != 0) {
            String space = words == ""?"": " ";
            words += space + groupToWords(d1, "");
        }
        return words;
    }
    
    public String groupToWords(int num, String unit) {
        int level = 0;
        int[] r = new int[3];
        for (int i = 0; num != 0; i ++) {
            r[i] = num % 10;
            num /= 10;
            level ++;
        }
        String words = "";
       
        if (level == 1) {
            words = units.get(r[0]);
        }
        if (level == 2) {
            if (r[1] == 1) {
                words = units.get(r[1]*10 + r[0]);
            }
            else {
                if (r[0] != 0) {
                    words = units.get(r[1] * 10) + " " + units.get(r[0]);
                } else {
                    words = units.get(r[1] * 10);
                }
            }
        }
        if (level == 3) {
            words = units.get(r[2]) + " " + units.get(100);
            if (r[1] != 0 && r[0] == 0) {
                words += " " + units.get(r[1] * 10);
            }
            if (r[1] ==0 && r[0] != 0) {
                words += " " + units.get(r[0]);
            }
            if (r[1] != 0 && r[0] != 0) {
                if (r[1] == 1) {
                    words += " " + units.get(r[1] * 10 + r[0]);
                }
                else {
                    words += " " + units.get(r[1] * 10) + " " + units.get(r[0]);
                }
            }
            
        }
        return words+unit;
    }
}
