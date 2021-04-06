
public class VolumizingMascara extends Mascara{
    

    public VolumizingMascara(String brand, boolean waterProof) 
    {
        super(brand,false,true,false,waterProof);
    }
    
    public boolean isForShortLashes() 
    {
        return false;
    }
    
    public boolean isForThinLashes() 
    {
        return true;
    }
    
    public boolean  isForStraightLashes() 
    {
        return false;
    }
}
