    import java.io.FileReader;
    import java.io.BufferedReader;
    import java.io.IOException;
    
    public class Main {
    
        static String dataset =
                """
    0Y()P7}zPcxSTEi7]=j9)WH}C8BX$T
    ,p50Guw;9nE2ek}uAi7nU1v+]#am
    (cA]xypiieP{4Ezk$$,#:Cq?UxtF
    yP%k!0Z);J(k%$8YvnrTvk4$%QcjKM
    UL);ZAtC?m6ZbW6YDD6u4/S.50ifE
    Y6j/t7jPiC2GU&L8h6!!%j/H%69!L
    HqT.N6,p.ZQT&KSV,mU[fLD@@(k+pX
    n2!r{hZri!X!b0q%zt_kQEN0#TA)KT
    1ijre(abt$Eq5d4$rzbv!bcuv&+ZR+
    rASh3H*r:eLy?BtT[A@qf!69#M],h]
    """;
    
        static String findMatchInString(String line, String match) {
            char letter;
            int matchLength = match.length();
            int needToFind = matchLength;
            outerLoop:
            for (int i = 0; i <= line.length() - matchLength; i++) {
                letter = line.charAt(i);
                while ((letter == match.charAt(matchLength - needToFind))) {
                    needToFind--;
                    if (needToFind == 0) {
                        break outerLoop;
                    }
                    i++;
                    letter = line.charAt(i);
                }
                needToFind = matchLength;
            }
            return needToFind == 0 ? line : null;
        }
    
        public static void main(String[] args) {
            String[] lines = dataset.split("\n");
            if (args.length == 0) {
                System.err.println("Provide 1 argument.");
                System.err.println("Usage: StringMatch [String]");
                System.exit(1);
            }
            String match = args[0];
            String findLine = null;
    
            for (String line : lines) {
                if ((findLine = findMatchInString(line, match)) != null) {
                    break;
                }
            }
            if (findLine == null) {
                System.err.println("NOT found");
                System.exit(1);
            } else {
                System.out.println("Found it here " + findLine);
                System.exit(0);
            }
        }
    }