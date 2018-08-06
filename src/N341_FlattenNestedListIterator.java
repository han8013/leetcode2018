import java.util.*;


public class N341_FlattenNestedListIterator {

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {

        Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            List<Integer> nums = new ArrayList<>();
            if(nestedList != null) {
                flatten(nestedList,nums);
            }
            iterator = nums.iterator();
        }

        private void flatten(List<NestedInteger> nestedList, List<Integer> nums) {
             for(NestedInteger n : nestedList) {
                 if(n.isInteger()) {
                     nums.add(n.getInteger());
                 } else {
                     flatten(n.getList(),nums);
                 }
             }
//            Stack<NestedInteger> stack = new Stack<>();
//            for (int i = nestedList.size()-1; i >= 0; i--) {
//                stack.push(nestedList.get(i));
//            }
//            while (!stack.isEmpty()) {
//                NestedInteger n = stack.pop();
//                if (n.isInteger()) {
//                    nums.add(n.getInteger());
//                } else {
//                    for (int j = n.getList().size()-1; j >= 0; j--) {
//                        stack.push(n.getList().get(j));
//                    }
//                }
//            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
}



