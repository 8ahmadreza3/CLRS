package S05_AdvancedDataStructures.Chapter20;

public class VanEmdeBoas {
    int universeSize;
    int minimum;
    int maximum;
    VanEmdeBoas summary;
    VanEmdeBoas[] clusters;

    public VanEmdeBoas(int size) {
        this.universeSize = size;
        this.minimum = -1;
        this.maximum = -1;

        if (size <= 2) {
            this.summary = null;
            this.clusters = new VanEmdeBoas[0];
        } else {
            int noClusters = (size + 1) / 2;
            this.summary = new VanEmdeBoas(noClusters);
            this.clusters = new VanEmdeBoas[noClusters];

            for (int i = 0; i < noClusters; i++)
                this.clusters[i] = new VanEmdeBoas((size + 1) / 2);
        }
    }

    int high(int x) {
        int div = (this.universeSize + 1) / 2;
        return x / div;
    }

    int low(int x) {
        int mod = (this.universeSize + 1) / 2;
        return x % mod;
    }

    int generateIndex(int x, int y) {
        int ru = (this.universeSize + 1) / 2;
        return x * ru + y;
    }
}
