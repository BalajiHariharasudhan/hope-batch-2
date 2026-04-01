class waveform_pattern {
    public static void main(String[] args) {
        String s = "VIRATKOHLI";

        StringBuilder s1 = new StringBuilder(); 
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < s.length(); i += 2) {
            s1.append(s.charAt(i));
        }

        for (int i = 1; i < s.length(); i += 2) {
            s2.append(s.charAt(i));
        }

        System.out.println(s1.append(s2));
    }
}
