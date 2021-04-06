
public class FiberMascara extends LengtheningMascara{
    
    public FiberMascara(String brand, boolean waterProof) 
    {
        super(brand,waterProof);
    }
    
    public boolean doubleStacked() 
    {
        return true;
    }
    
    @Override
    public String getInfo() 
    {
        String output = super.getInfo();
        output += " +Double Stacked {Mascara + Nylon Lash Fibers}";
        return output;
    }

}
