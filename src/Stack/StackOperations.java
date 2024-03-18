package Stack;

import javax.swing.text.html.HTML;

public class StackOperations {


    //This method searches a given value in a given stack
    public static boolean search(Stack stk, int val) {
        Stack tempStack = new Stack(stk.count());
        boolean isExists = false;
        while (!stk.isEmpty()) {
            int temp = stk.pop();
            if (temp == val) {
                isExists = true;
            }
            tempStack.push(temp);
            if (stk.isEmpty()) {
                isExists = false;
            }
        }
        while (!tempStack.isEmpty()) {
            int temp = tempStack.pop();
            stk.push(temp);
        }
        return isExists;
    }

    public static boolean isEqual(Stack s1, Stack s2) {
        if (s1.count() != s2.count())
            return false;
        Stack tempStack1 = new Stack(s1.count());
        Stack tempStack2 = new Stack(s1.count());
        boolean result = true;
        while (!s1.isEmpty()) {
            int val1 = s1.pop();
            int val2 = s2.pop();
            tempStack1.push(val1);
            tempStack2.push(val2);
            if (val1 != val2) {
                result = false;
                break;
            }
        }
        while (!tempStack1.isEmpty()) {
            s1.push(tempStack1.pop());
            s2.push(tempStack2.pop());
        }
        return result;
    }

    //write a remove method that will remove a specific element from a given stack
    public static void remove(Stack stk, int val){
        Stack tempStack = new Stack(stk.count());
        while (!stk.isEmpty()) {
            int temp = stk.pop();
            if (temp == val) {
                break;
            }
            tempStack.push(temp);
            if (stk.isEmpty()) {
                System.out.println("not exist");
            }
        }
        while (!tempStack.isEmpty()) {
            int temp = tempStack.pop();
            stk.push(temp);
        }
    }
}
