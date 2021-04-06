
public class MascaraList {

    Mascara[] mascaraList;

    public MascaraList(int length) 
    {
        mascaraList = new Mascara[length];
    }

    public void addMascara(Mascara mascara) 
    {
        Mascara[] tempArray = new Mascara[mascaraList.length +1];

        for (int i = 0 ; i < mascaraList.length ; i++) 
        {
            tempArray[i] = mascaraList[i];
        }
        tempArray[mascaraList.length] = mascara;

        mascaraList = tempArray;
    }

    public String toString() 
    {
        int number = 1;
        String output = "";

        for (int i = 0 ; i < mascaraList.length ; i++) 
        {
            if (mascaraList[i] == null)
            {
                continue;
            }
            output += number +". " + mascaraList[i].toString() + "\n";
            number++;
        }
        return output;
    }
}
