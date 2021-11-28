public class main {
    public static void main(String args[]){
        QuickUnion sample = new QuickUnion(8);
        sample.union(7,2);
        sample.union(0,5);
        sample.union(1,6);
        sample.union(1,0);
        System.out.println(sample.root(5));
        System.out.println(sample.size[1]);
        /*
        sample.union(2,1);
        sample.union(3,4);
        sample.union(3,7);

        System.out.println(sample.connected(2,3));
        System.out.println(sample.connected(5,7));
        System.out.println(sample.connected(4,3));
        System.out.println(sample.connected(7,5));
        System.out.println(sample.size[7]);
         */
    }
}
class QuickUnion{
    private int[] id;
    public int[] size;

    //Initialize Array
    public QuickUnion(int N){
        id = new int[N];
        size = new int[N];

        for(int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    public int root(int i){
        while(i != id[i]){
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
    public boolean connected(int p, int q){
        return root(p)==root(q);
    }
    public void union(int p, int q){
        if(root(p) == root(q)) return;
        if(size[root(p)] < size[root(q)]) {
            id[root(p)] = root(q);
            size[root(p)] += size[p];
        }
        else{
            id[root(q)] = root(p);
            size[root(q)] += size[q];
        }
    }
}