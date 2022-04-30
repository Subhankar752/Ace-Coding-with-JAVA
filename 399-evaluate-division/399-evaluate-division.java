class Solution {
   Map<String, Map<String, Double>> graph = new HashMap<>();
    double res = 0.0D;
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    buildGraph(equations, values);
    
    double ans[] = new double[queries.size()];
    
    for(int i=0; i<queries.size(); i++)
    {
        List<String> eq = queries.get(i);
        
        String sA = eq.get(0);
        String sB = eq.get(1);
        
        if(!graph.containsKey(sA) || !graph.containsKey(sB))
        {
            ans[i] = -1.0D;
        }
        else
        {
            res = -1.0D;
            dfs(sA, sB, 1.0D, new HashSet<>()); 
            ans[i] = res;
        }
        
    }
    
    return ans;
}

private void dfs(String src, String target, double number, Set<String> visited)
{
    if(visited.contains(src)) return;
    
    if(target.equals(src))
    {
        res = number;
        return;
    }
    
    visited.add(src);
    
    Map<String, Double> edge = graph.get(src);
    
    for(String next : edge.keySet())
    {
        if(!visited.contains(next))
        {
            dfs(next, target, number*edge.get(next), visited);
           // if(result >= 0.0D) return result;
        }
    }
}

private void buildGraph(List<List<String>> equations, double[] values)
{

    for(int i=0; i<values.length; i++)
    {
        List<String> eq = equations.get(i);
        
        String a = eq.get(0);
        String b = eq.get(1);
        
        // Map<String, Double> edgeA = graph.computeIfAbsent(a, f -> new HashMap<>());
        // edgeA.put(b, values[i]);
        
        if(graph.containsKey(a)){
            Map<String , Double> m = graph.get(a);
            m.put(b , values[i]);
            graph.put(a , m);
        }
        else{
            Map<String , Double> m = new HashMap<>();
            m.put(b , values[i]);
            graph.put(a , m);
        }
        

        // Map<String, Double> edgeB = graph.computeIfAbsent(b, f -> new HashMap<>());
        // edgeB.put(a, 1 / values[i]);
        if(graph.containsKey(b)){
            Map<String , Double> m = graph.get(b);
            m.put(a , 1/values[i]);
            graph.put(b , m);
        }
        else{
            Map<String , Double> m = new HashMap<>();
            m.put(a , 1/ values[i]);
            graph.put(b , m);
        }
    }
}
}