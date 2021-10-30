import java.util.HashMap;
import java.util.Map;

public class LabThree {

    public static void main(String[] args) {
        /**
         * Third Java Lab
         * @author Yevhenii Shchuryk
         * C3 = 9129 % 3 = 0 = StringBuilder
         * C17= 9129 % 17= 0 = Знайти найбільшу к-сть речень заданого тексту, в яких є однакові слова.
         */

        StringBuilder text = new StringBuilder("Hello there, yes, you, over there. Hello my dear friend! It`s so nice there, you will not " +
                "believe me, can you hear me?");

        String stringText = text.toString();

        String[] sentences;

        sentences = stringText.split("(! )|(\\. )|(\\?)");

        String[] words;

        Map<String, Integer> maxWord = new HashMap();
        Map<String, Map> sentencesDict = new HashMap();

        System.out.println();
        System.out.println(text);
        System.out.println();

        for (int s = 0; s < sentences.length; s++) {
//            System.out.println(sentences[s]);

            words = sentences[s].split("( )|(  )|(, )|(,)");

            for (int i = 0; i < words.length; i++) {

                if (maxWord.containsKey(words[i])) {

                    maxWord.replace(words[i], maxWord.get(words[i]) + 1);

                } else {
                    maxWord.put(words[i], 1);
                }
            }

            String l = null;
            int p = 0;

            for (String word :maxWord.keySet()) {

                if (p < maxWord.get(word)) {

                    p = maxWord.get(word);
                    l = word;

                }
            }

            Map<String, Integer> maxWordDict = new HashMap();

            maxWordDict.put(l, maxWord.get(l));

            sentencesDict.put("Sentence" + s, maxWordDict);

            maxWord.clear();
        }

        System.out.println();

        System.out.println(sentencesDict);
    }

}
