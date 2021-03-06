public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("My name is Ico. I am robot. I am . I cool. I go. I have food");
        StringBuilder uniq = makeUniq(sb);
        System.out.println(uniq);
        System.out.println();
        countWords(sb);


    }

    private static String makeuniq(StringBuilder sb) {
        String[] sentences = sb.toString().replaceAll("[!]", ".")
                .replaceAll("[...]", ".")
                .replaceAll("[?]", ".")
                .toLowerCase()
                .split("[.]");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i] = sentences[i].trim();
            System.out.println(sentences[i]);
        }

        String[][] words = new String[sentences.length][sb.length()];
        for (int i = 0; i < sentences.length; i++) {
            words[i] = sentences[i].split(" ");
        }
        StringBuilder[] sen = new StringBuilder[sentences.length];
        for (int i = 0; i < sen.length; i++)
            sen[i] = new StringBuilder(sentences[i]);


        int max = 0;
        int buff = 0;
        String ms = "";
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                for (int k = 0; k < sen.length; k++) {
                    if (i == k) continue;
                    if (sen[k].indexOf(words[i][j]) != -1) buff++;
                }
                if (max < buff) {
                    max = buff;
                    ms = words[i][j];
                }
                buff = 1;
            }
        }
        if (max == 1) return "not found repeates";
        return ms + " " + max;
    }

    private static void countWords(StringBuilder sb) {
        char[] sentences = sb.toString().replaceAll("[!]", ".")
                .replaceAll("[...]", ".")
                .replaceAll("[?]", ".")
                .toLowerCase().toCharArray();
        int number = 0;
        int numbOfwords = 0;
        StringBuilder res = new StringBuilder("count words:" + "\n");
        StringBuilder buff = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i] == '.') {
                System.out.println(buff + " " + number);
                buff.delete(0, buff.length());
                number++;
                numbOfwords++;
                res.append(numbOfwords + "\n");
                numbOfwords = 0;
                continue;
            }
            if (buff.length() != 0 && sentences[i] == ' ') {
                System.out.println(buff + " " + number);
                buff.delete(0, buff.length());
                numbOfwords++;
                continue;
            }
            if (sentences[i] != ' ')
                buff.append(sentences[i]);
        }
        System.out.println(res);
    }

    private static StringBuilder makeUniq(StringBuilder sb) {
        String[] sentences = sb.toString().replaceAll("[!]", "")
                .replaceAll("[...]", "")
                .replaceAll("[?]", "")
                .toLowerCase()
                .split(" ");

        String[] result = new String[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (sentences[i].equals(result[j])) break;
                if (result[j] == null) {
                    result[j] = sentences[i];
                    break;
                }
            }
        }
        StringBuilder uniq = new StringBuilder();
        for (String s : result)
            if (s != null && !s.equals(""))
                uniq.append(s + "\n");

        return uniq;
    }
}
