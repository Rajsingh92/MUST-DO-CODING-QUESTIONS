//              INCLUDE EXCLUDE BASED
//              INCLUDE EXCLUDE BASED
//              INCLUDE EXCLUDE BASED


//count of binary string with no consecutive zeros
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int oldCountZero = 1;
        int oldCountOne = 1;

        for (int i = 2; i < n + 1; i++) {
            int newCountZero = oldCountOne;
            int newCountOne = oldCountZero + oldCountOne;

            oldCountZero = newCountZero;
            oldCountOne = newCountOne;
        }

        System.out.println(oldCountZero + oldCountOne);
    }
}

// Arrange Buildings
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();

        long oldCountZero = 1;
        long oldCountOne = 1;

        for (int i = 2; i < n + 1; i++) {
            long newCountZero = oldCountOne;
            long newCountOne = oldCountZero + oldCountOne;

            oldCountZero = newCountZero;
            oldCountOne = newCountOne;
        }

        long ways = oldCountZero + oldCountOne;
        System.out.println(ways * ways);
    }
}

// count of substring of nature a+b+c+
public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        int a = 0;
        int ab = 0;
        int abc = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a') {
                a = 2 * a + 1;
            } else if (ch == 'b') {
                ab = 2 * ab + a;
            } else if (ch == 'c') {
                abc = 2 * abc + ab;
            }
        }

        System.out.println(abc);
    }
}


// Maximum Sum Non Adjacent Elements
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int inc = arr[0];
        int exc = 0;

        for (int i = 1; i < n; i++) {
            int ninc = exc + arr[i];
            int nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }

        int ans = Math.max(inc, exc);
        System.out.println(ans);
    }
}


// paint house
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] items = str.split(" ");
            arr[i][0] = Integer.parseInt(items[0]);
            arr[i][1] = Integer.parseInt(items[1]);
            arr[i][2] = Integer.parseInt(items[2]);
        }

        long red = arr[0][0];
        long blue = arr[0][1];
        long green = arr[0][2];

        for (int i = 1; i < arr.length; i++) {
            long nred = arr[i][0] + Math.min(blue, green);
            long nblue = arr[i][1] + Math.min(red, green);
            long ngreen = arr[i][2] + Math.min(red, blue);

            red = nred;
            blue = nblue;
            green = ngreen;
        }

        System.out.println(Math.min(red, Math.min(blue, green)));
    }
}

// paint house -- multiple color
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int k = Integer.parseInt(line.split(" ")[1]);
        int[][] arr = new int[n][k];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] items = str.split(" ");
            for (int j = 0; j < k; j++) {
                arr[i][j] = Integer.parseInt(items[j]);
            }
        }

        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[0][j] <= min) {
                smin = min;
                min = arr[0][j];
            } else if (arr[0][j] <= smin) {
                smin = arr[0][j];
            }
        }

        for (int i = 1; i < arr.length; i++) {
            int cmin = Integer.MAX_VALUE;
            int csmin = Integer.MAX_VALUE;

            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i - 1][j] != min) {
                    arr[i][j] += min;
                } else {
                    arr[i][j] += smin;
                }

                if (arr[i][j] <= cmin) {
                    csmin = cmin;
                    cmin = arr[i][j];
                } else if (arr[i][j] <= csmin) {
                    csmin = arr[i][j];
                }
            }

            min = cmin;
            smin = csmin;
        }

        System.out.println(min);
    }
}


// paint fence
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        // start 2
        long same = k;
        long diff = k * (k - 1);
        long total = same + diff;

        for (int i = 3; i <= n; i++) {
            same = diff;
            diff = total * (k - 1);
            total = same + diff;
        }

        System.out.println(total);
    }
}

