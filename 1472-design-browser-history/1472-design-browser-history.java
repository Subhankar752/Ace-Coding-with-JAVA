class BrowserHistory {
    
    ArrayList<String> list = new ArrayList<>();
    int idx = -1;
    
    public BrowserHistory(String homepage) {
        list.add(homepage);
        idx = 0;
    }
    
    public void visit(String url) {
        while(list.size() - 1 != idx){
            list.remove(list.size() - 1);
        }
        list.add(url);
        idx++;
    }
    
    public String back(int steps) {
        while(steps > 0){
            steps--;
            idx--;
        }
        if(idx < 0)
            idx = 0;
        return list.get(idx);
    }
    
    public String forward(int steps) {
        while(steps > 0){
            idx++;
            steps--;
        }
        if(idx > list.size() - 1)
            idx = list.size() - 1;
        return list.get(idx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */