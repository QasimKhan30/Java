public class PaperPurchase {

    private String purchasingCompany;
    private String datePurchased;
    private int totalCartonsPurchased;
    private PaperProduct paper;
    private double totalDue;

    public PaperPurchase() 
    {
        purchasingCompany = null;
        datePurchased = null;
        totalCartonsPurchased = 0;
        paper = null;

    }

    public PaperPurchase(String purchasingCompany, String datePurchased, int totalCartonsPurchased, PaperProduct paper) 
    {
        this.purchasingCompany = purchasingCompany;
        this.datePurchased = datePurchased;
        this.totalCartonsPurchased = totalCartonsPurchased;
        this.paper = paper;
        calcTotalDue();

    }

    public String getPurchasingCompany() 
    {
        return purchasingCompany;
    }

    public String getDatePurchased() 
    {
        return datePurchased;
    }

    public int getTotalCartonsPurchased() 
    {
        return totalCartonsPurchased;
    }

    public PaperProduct getPaperDetail() 
    {
        return paper;
    }

    public double getTotalDue() 
    {
        return totalDue;
    }

    public void setPurchasingCompany(String purchasingCompany) 
    {
        this.purchasingCompany = purchasingCompany;
    }

    public void setDatePurchased(String datePurchased) 
    {
        this.datePurchased = datePurchased;
    }

    public void setTotalCartonsPurchased(int totalCartonsPurchased) 
    {
        this.totalCartonsPurchased = totalCartonsPurchased;
    }

    public void setPaperDetail(PaperProduct paper)
    {
        this.paper = paper;
    }

    public void calcTotalDue() 
    {
        totalDue = totalCartonsPurchased * paper.getPricePerCarton();
    }

    public String toString() 
    {
        String output;
        String stringTotalDue = String.format("%.2f",totalDue);

        output = "" + "Purchasing Company: " + purchasingCompany + "\nDate Purchased: " + datePurchased + "\tTotal Cartons Purchased: " + totalCartonsPurchased + "\n"
        +"\nPurchase Detail:\n" + paper + "\nTotal Due: $" + stringTotalDue + "\n";

        return output;
    }
}