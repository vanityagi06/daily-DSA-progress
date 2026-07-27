class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> stc = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '('){
                if(!stc.isEmpty()){
                    res.append(c);
                }

                stc.push(c);
            } else{
                stc.pop();
                if(!stc.isEmpty()){
                    res.append(c);
                }
            }
        }

        // while(!stc.isEmpty()){
        //     res.append(stc.pop());
        // }
        return res.toString();
    }
}