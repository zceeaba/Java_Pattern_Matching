package javaclasses;

public class hashing {
    //This algorithm implements a rolling hash,i.e. the hash value of the next element is calculated based on the hash value of the previous element
    public final static int d = 256;

    public int computehashing(String a, String b, int q) {
        //q is an unique prime number
        int result=0;
        int M = a.length();
        int N = b.length();
        int i, j;
        int p = 0;//hash value for pattern
        int t = 0;//hash value for text
        int h = 1;

        for (i = 0; i < M-1; i++) {
            h = (h * d) % q;
            System.out.println(h);
        }
        for (i = 0; i < M; i++)
        {   System.out.println(b);
            p = (d * p + a.charAt(i)) % q;
            t = (d * t + b.charAt(i)) % q;

        }
        for (i = 0; i <= N - M; i++) {
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (b.charAt(i + j) != a.charAt(j))
                        break;
                }
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("Pattern found at index " + i);
                    result=i;
            }
            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - b.charAt(i) * h) + b.charAt(i + M)) % q;
                if (t < 0) {
                    t = (t + q);
                }
            }

        }
        return result;

    }
}
