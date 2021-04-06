public class PaperProduct {

    private String sku;
    private String brandName;
    private String paperSize;
    private double weight;
    private String paperType;
    private boolean recycled;
    private int sheetsPerReam;
    private int reamPerCarton;
    private double pricePerCarton;

    public PaperProduct() 
    {
        sku = null;
        brandName = null;
        paperSize = null;
        weight = 0.0;
        paperType = null;
        recycled = false;
        sheetsPerReam = 0;
        reamPerCarton = 0;
        pricePerCarton = 0.0;
    }

    public PaperProduct(String sku, String brandName, String paperSize, double weight, String paperType, boolean recycled, int sheetsPerReam, int reamPerCarton, double pricePerCarton) 
    {
        this.sku = sku;
        this.brandName = brandName;
        this.paperSize = paperSize;
        this.weight = weight;
        this.paperType = paperType;
        this.recycled = recycled;
        this.sheetsPerReam = sheetsPerReam;
        this.reamPerCarton = reamPerCarton;
        this.pricePerCarton = pricePerCarton;
    }

    public String getSku() 
    {
        return sku;
    }

    public String getBrandName() 
    {
        return brandName;
    }

    public String getPaperSize() 
    {
        return paperSize;
    }

    public double getWeight() 
    {
        return weight;
    }

    public String getPaperType() 
    {
        return paperType;
    }

    public boolean getRecycled() 
    {
        return recycled;
    }

    public int getSheetsPerReam() 
    {
        return sheetsPerReam;
    }

    public int getReamPerCarton() 
    {
        return reamPerCarton;
    }

    public double getPricePerCarton() 
    {
        return pricePerCarton;
    }

    public void setSku(String sku) 
    {
        this.sku = sku;
    }

    public void setBrandName(String brandName) 
    {
        this.brandName = brandName;
    }

    public void setPaperSize(String paperSize) 
    {
        this.paperSize = paperSize;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public void setPaperType(String paperType)
    {
        this.paperType = paperType;
    }

    public void setRecycled(boolean recycled)
    {
        this.recycled = recycled;
    }

    public void setSheetsPerReam(int sheetsPerReam)
    {
        this.sheetsPerReam = sheetsPerReam;
    }

    public void setReamPerCarton(int reamPerCarton)
    {
        this.reamPerCarton = reamPerCarton;
    }

    public void setPricePerCarton(double pricePerCarton) 
    {
        this.pricePerCarton = pricePerCarton;
    }

    public String toString() 
    {
        String representation;
        String stringPricePerCarton = String.format("%.2f",pricePerCarton);
        representation = "SKU: " + sku + "\tBrandname: " + brandName + "\tPaper Size: " + paperSize +
        "\nWeight (lbs): " + weight + "\tPaper Type: " + paperType + "\tRecycled: " + recycled +
        "\nSheets per Ream: " + sheetsPerReam + "\tReams per Carton: " + reamPerCarton +
        "\nPrice per Carton: $" + stringPricePerCarton + "\n";

        return representation;

    }

    public boolean equals(PaperProduct other) 
    {
        if (this.sku.equals(other.getSku()) && this.brandName.equals(other.getBrandName()) && this.paperSize.equals(other.getPaperSize()) 
        && this.weight == other.getWeight() && this.paperType.equals(other.getPaperType()) && this.recycled == other.getRecycled() 
        && this.sheetsPerReam == other.getSheetsPerReam() && this.reamPerCarton == other.getReamPerCarton() &&
        this.pricePerCarton == other.getPricePerCarton()) 
        {
            return true;
        }
        return false;
    }
}