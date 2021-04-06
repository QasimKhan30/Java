
public class LengtheningMascara extends Mascara{

    public LengtheningMascara(String brand, boolean waterProof) 
    {
        super(brand,true,false,false,waterProof);
    }
    
    public boolean needsMultipleCoats() 
    {
        return true;
    }
    
    public boolean  isForShortLashes() 
    {
        return true;
    }
    
    public boolean  isForThinLashes() 
    {
        return false;
    }
    
    public boolean isForStraightLashes() 
    {
        return false;
    }
    
    public String getInfo() 
    {
        String output = "";
        
        if (isForShortLashes()) 
        {
            output += "Short Lashes";
        }
        if (isForThinLashes())
        {
            if (output.equals(""))
            {
                output += "Thin Lashes";
            }
            else if (output.equals("") && (isWaterProof() ))
            {
                output += "Thin Lashes ";
            }
            else if (!(output.equals("")) && (!isWaterProof() ))
            {
                output += " Thin Lashes";
            }
        }
        if (isWaterProof())
        {
            output += " +Water Proof {may clump during application, require more time to dry}";
        }
        output += " +Needs Multiple Coats";
        
        return output;
    }

}
