package bsu.comp442;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Main {

    public static void main(String[] args)
    {
        final String url = "https://jobs.bridgew.edu/postings/search";
        try {
            final Document document = Jsoup.connect(url).get();
            //for(Element row: document.select())
            System.out.println(document.outerHtml());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
