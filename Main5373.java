import java.util.Scanner;

class Face {
    int[] coord;
    char color;

    Face(int x, int y, int z, char color) {
        this.coord = new int[]{ x, y, z };
        this.color = color;
    }

    void rotate(int a, int b, boolean invert) {
        int x = coord[a], y = coord[b];
        coord[b] = invert ? -x :  x;
        coord[a] = invert ?  y : -y;
    }
}

class Cube {
    static final int X = 0, Y = 1, Z = 2;
    Face[] faces = new Face[6*9];

    Cube() {
        int i = 0;
        for (int n = -2; n <= 2; n += 2) {
            for (int m = -2; m <= 2; m += 2) {
                faces[i++] = new Face( 3,  n,  m, 'b');  // right:  blue
                faces[i++] = new Face( n,  3,  m, 'w');  // up:     white
                faces[i++] = new Face( n,  m,  3, 'r');  // front:  red
                faces[i++] = new Face(-3,  n,  m, 'g');  // left:   green
                faces[i++] = new Face( n, -3,  m, 'y');  // down:   yellow
                faces[i++] = new Face( n,  m, -3, 'o');  // back:   orange
            }
        }
    }

    void execute(String move) {
        char side = move.charAt(0);
        boolean invert = move.charAt(1) == '-';
        for (Face f: faces) {
            switch (side) {
                case 'R': if (f.coord[X] >  1) f.rotate(Z, Y, invert); break;
                case 'U': if (f.coord[Y] >  1) f.rotate(X, Z, invert); break;
                case 'F': if (f.coord[Z] >  1) f.rotate(Y, X, invert); break;
                case 'L': if (f.coord[X] < -1) f.rotate(Y, Z, invert); break;
                case 'D': if (f.coord[Y] < -1) f.rotate(Z, X, invert); break;
                case 'B': if (f.coord[Z] < -1) f.rotate(X, Y, invert); break;
            }
        }
    }

    void printTop() {
        char[] buf = "...\n...\n...".toCharArray();
        for (Face f: faces)
            if (f.coord[Y] == 3) buf[2*f.coord[Z] + f.coord[X]/2 + 5] = f.color;
        System.out.println(buf);
    }
}

class Main {
    public static void main(String... args) {
        Scanner sc = new java.util.Scanner(System.in);
        int cases = sc.nextInt();
        while (cases-- > 0) {
            int N = sc.nextInt();
            Cube cube = new Cube();
            while (N-- > 0) cube.execute(sc.next());
            cube.printTop();
        }
    }
}