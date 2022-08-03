class MyCalendar {
    public class Pair{
        int a;
        int b;
        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }
    }
    ArrayList<Pair> cal;

    public MyCalendar() {
        ArrayList<Pair> cal = new ArrayList<>();
        this.cal = cal;
    }
    
    public boolean book(int start , int end) {
        int size = cal.size();
        for(int i = 0 ; i < size ; i++){
            Pair p = cal.get(i);
            int a = p.a;
            int b = p.b;
            if(start < b && end > a)
                return false;
        }
        
        cal.add(new Pair(start , end));
        
        return true;
    }
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */