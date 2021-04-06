
public class CurlingMascara extends Mascara{
    
    protected String specialApplicator;
    
    public CurlingMascara(String brand, boolean waterProof, String specialApplicator) 
    {
        super(brand,false,false,true,waterProof);
        this.specialApplicator = specialApplicator;
    }
    
    public CurlingMascara(String brand, boolean waterProof) 
    {
        //CurlingMascara(brand,waterProof,null);
        super(brand,false,false,true,waterProof);
        specialApplicator = null;
    }
    
    
    public boolean needsSpecialApplicator() 
    {
        if (specialApplicator != null) 
        {
            return true;
        }
        return false;
    }
    @Override
    public String getInfo() 
    {
        String output = super.getInfo();
        if (specialApplicator != null) 
        {
            output += " +Requires Special Applicator";
        }
        
        return output;
    }
    
    @Override
    public String toString() 
    {
        String output = super.toString();
        if(specialApplicator != null)
        {
            output+= ": " + "\""+ specialApplicator + "\"" ;
        }
        return output;
    }
    
    

}
