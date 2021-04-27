import java.util.PriorityQueue;

public class ReArrange {

   static  class CharObject
    {
        char ch;
        int freq;
        public CharObject(char ch, int freq)
        {
            this.ch=ch;
            this.freq=freq;
        }
    }

    public static void main(String[] args) {
        String inputString = "";
        char[] freqArray = new char[26];

        for (int i = 0; i < inputString.length(); i++) {
            freqArray[inputString.charAt(i) - 'a']++;
        }

        // solve
        PriorityQueue<CharObject> queue=new PriorityQueue<CharObject>();

        for (int i = 0; i < freqArray.length; i++) {
            queue.add(new CharObject((char)(i+'a'),freqArray[i]));
        }


    }



}
