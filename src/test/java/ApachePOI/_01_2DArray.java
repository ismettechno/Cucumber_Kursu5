package ApachePOI;

public class _01_2DArray {
    public static void main(String[] args) {
        String[][] zoo={
                {"Aslan","1"},
                {"Kaplan","2"},
                {"Zebra","3","1"},
                {"Fil","4"}
        };

        System.out.println("------------------------------");
        System.out.println(zoo[2][0]);
        System.out.println(zoo[2][1]);
        System.out.println("------------------------------");

        for (int i = 0; i < zoo.length; i++) {

            for (int j = 0; j < zoo[i].length ; j++) {
                System.out.print(zoo[i][j]+"\t");
            }

            System.out.println();
        }
    }
}
