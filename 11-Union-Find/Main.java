package IMUHERO;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
        int size=10000;
        int m=100000;
        UnionFind1 UF1=new UnionFind1(size);
        UnionFind2 UF2=new UnionFind2(size);
        UnionFind3 UF3=new UnionFind3(size);
        UnionFind4 UF4=new UnionFind4(size);
        UnionFind5 UF5=new UnionFind5(size);

        System.out.println(testUF(UF1,m));
        System.out.println(testUF(UF2,m));
        System.out.println(testUF(UF3,m));
        System.out.println(testUF(UF4,m));
        System.out.println(testUF(UF5,m));


    }

    public  static double testUF(UF uf,int times){
        int size=uf.getSize();
        Random random=new Random();
        long startTime=System.nanoTime();

        for (int i=0;i<times;i++){
            int a= random.nextInt(size);
            int b=random.nextInt(size);
            uf.UnionElement(a,b);
        }

        for (int i=0;i<times;i++){
            int a= random.nextInt(size);
            int b=random.nextInt(size);
            uf.isConnected(a,b);
        }
        long endTime=System.nanoTime();
        double time=(endTime-startTime)/1000000000.0;
        return time;
    }
}
