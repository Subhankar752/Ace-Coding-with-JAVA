class Solution {
    public int countCollisions(String directions) {
        
        Stack<Character> st= new Stack<>();
        int collisions=0;
        for(char d:directions.toCharArray())
        {
            if(d=='R') st.push(d);
            
            else if(d=='L')
            {
                if(!st.isEmpty() && st.peek()=='R')
                {
                    // R-> <-L
                    int car=st.pop();
                    collisions+=2;
                    
                    // Now due to collision, car became stationary ,therefore, all right moving cars will collide.
                    // R-> S
                    collisions+= collideRightCars(st);
                }
                
                // S <-L
                else if(!st.isEmpty() && st.peek()=='S') collisions++;
            }
            
            // R-> S
            else if(d=='S') collisions+= collideRightCars(st);  
        }
        
        return collisions;
    }
    
    private int collideRightCars(Stack<Character> st)
    {
        int collisions=0;
        while(!st.isEmpty() && st.peek()=='R') 
        {
            collisions++;
            st.pop();
        }
        st.push('S');
        
        return collisions;
    }
}