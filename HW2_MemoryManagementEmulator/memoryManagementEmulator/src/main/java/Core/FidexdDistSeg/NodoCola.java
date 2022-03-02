
package Core.FidexdDistSeg;


public class NodoCola {
    private int TaPartition;
    public NodoCola SigPartition;

    public NodoCola(int TaPartition) {
        this.TaPartition = TaPartition;
        this.SigPartition = SigPartition;
    }

    public int getTaPartition() {
        return TaPartition;
    }

    public void setTaPartition(int TaPartition) {
        this.TaPartition = TaPartition;
    }

    public NodoCola getSigPartition() {
        return SigPartition;
    }

    public void setSigPartition(NodoCola SigPartition) {
        this.SigPartition = SigPartition;
    }
    
    
}
