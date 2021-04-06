
public class PaperOrder {
    private PaperPurchase[] items;
    private int capacity;
    private int count;

    public PaperOrder() 
    {
        capacity = 100;
        items = new PaperPurchase[capacity];
        count = 0;
    }

    public PaperOrder(int num) 
    {
        capacity = num;
        items = new PaperPurchase[capacity];
        count = 0;
    }

    public int getCapacity() 
    {
        return capacity;
    }

    public void setCapacity(int num) 
    {
        capacity = num;
    }

    public void addPurchase(PaperPurchase paper) 
    {
        if (count != capacity) 
        {
            items[count] = paper;
            count +=1;
        }
    }

    public boolean deletePurchase(PaperPurchase paper) 

    {
        for(int i = 0 ; i <count ; i++) 
        {
            if (items[i].equals(paper)) 
            {
                items[i] = null;
                count -=1;

                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() 
    {
        boolean test = true;
        for (int i = 0 ; i < items.length ; ++i)
        {
            if (items[i] == null) 
            {
                test = true;
            }
            else 
            {
                test = false;
                break;
            }
        }
        return test;
    }

    public boolean isFull() 
    {
        if (count == capacity) 
        {
            return true;
        }
        return false;
    }

    public void printAllOrders() 
    {

        for (int i = 0 ; i < items.length ; ++i) 
        {
            if (items[i] == null) 
            {
                continue;
            }
            System.out.println(items[i]);
        }
    }

    public void printOrdersbyCompany(String company) 
    {

        for (int i = 0 ; i < items.length ; ++i) 
        {
            if (items[i] == null)
            {
                continue;
            }
            
            if (items[i].getPurchasingCompany().equals(company)) 
            {
                System.out.println(items[i]);
            }
            
        }
    }

    public double calcTotalDueforCompany(String company) 
    {
        double sumTotal = 0.0;

        for (int i = 0 ; i < items.length ; ++i) 
        {
            if (items[i] == null)
            {
                continue;
            }
            if (items[i].getPurchasingCompany().equals(company)) 
            {
                sumTotal += items[i].getTotalDue();
            }
        }

        return sumTotal;
    }
}