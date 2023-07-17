/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> obj;

    public int getImportance(List<Employee> employees, int id) {
        obj = new HashMap<>();
        for (Employee p : employees) {
            obj.put(p.id, p);
        }
        return calculate(id);
    }

    public int calculate(int id) {
        int val = obj.get(id).importance;
        for (int v : obj.get(id).subordinates) {
            val += calculate(v);
        }
        return val;
    }
}
