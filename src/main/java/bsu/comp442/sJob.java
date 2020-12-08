package bsu.comp442;

public class sJob
{
    private String title;
    private String description;
    private String contact;
    private int jobNo;

    public String getTitle(){return title;}
    public String getDescription(){return description;}
    public String getContact(){return contact;}
    public int getJobNo(){return jobNo;}

    @Override
    public String toString()
    {
        return ("{\n"+"\ttitle: "+this.getTitle()+"\n\tdescription: "+this.getDescription()+"\n\tcontact: "+this.getContact()+"\n}");
    }
}
