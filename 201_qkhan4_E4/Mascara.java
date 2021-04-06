
public class Mascara {

    private boolean forShortLashes;
    private boolean forThinLashes;
    private boolean forStraightLashes;
    private boolean  waterProof;
    private String brand;

    public Mascara(String brand, boolean forShortLashes, boolean forThinLashes, boolean forStraightLashes, boolean waterProof) 
    {
        this.brand = brand;
        this.forShortLashes = forShortLashes;
        this.forThinLashes = forThinLashes;
        this.forStraightLashes = forStraightLashes;
        this.waterProof = waterProof;
    }

    public void setInfo(boolean forShortLashes, boolean forThinLashes, boolean forStraightLashes, boolean waterProof) 
    {
        this.forShortLashes = forShortLashes;
        this.forThinLashes = forThinLashes;
        this.forStraightLashes = forStraightLashes;
        this.waterProof = waterProof;

    }

    public String getBrandName() 
    {
        return brand;
    }

    public boolean isForShortLashes() 
    {
        return forShortLashes;
    }

    public boolean isForThinLashes() 
    {
        return forThinLashes;
    }

    public boolean isForStraightLashes() 
    {
        return forStraightLashes;
    }

    public boolean isWaterProof() 
    {
        return waterProof;
    }

    public String getInfo() 
    {
        String[] arr = new String[4];
        int count = 0;
        if (isForShortLashes()) 
        {
            arr[0] = "Short Lashes";
            count++;
        }
        if (isForThinLashes()) 
        {
            arr[1] = "Thin Lashes";
            count++;
        }
        if (isForStraightLashes()) 
        {
            arr[2] = "Straight Lashes";
            count++;
        }
        if (isWaterProof()) 
        {
            arr[3] = "+Water Proof {may clump during application, require more time to dry}";
            count++;
        }

        String[] arr2 = new String[count];
        int index = 0;
        for (int i = 0 ; i < 4; i++)
        {
            if (arr[i] != null)
            {
                arr2[index] = arr[i];
                index++;
            }
        }

        String output = "";

        for (int i = 0 ; i < arr2.length; ++i) 
        {
            output+= arr2[i];
            if (i != arr2.length-1) 
            {
                output += " ";
            }

        }
        return output;
    }

    @Override
    public String toString() 
    {
        String output = "Brand: " + brand + ", Good For: " + getInfo();
        return output;
    }

}