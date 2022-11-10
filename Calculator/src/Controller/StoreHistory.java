
package Controller;

public class StoreHistory {
    public static java.util.List<String> evaluationhistory=new java.util.ArrayList<>();
    public void history(String answerhistory)
    {
        evaluationhistory.add(answerhistory);
    } 
    public void showHistory()
    {
        for(int i=0;i<evaluationhistory.size();i++)
        {
            System.out.println(evaluationhistory.get(i));
        }
        System.out.println("                                            >>> NOTHING MORE   <<<");
    }
    public void clear()
    {
        evaluationhistory.clear();
    }
    
}
