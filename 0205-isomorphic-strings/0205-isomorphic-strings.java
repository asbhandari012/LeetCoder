class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> revMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }

            if(revMap.containsKey(t.charAt(i))){
                if(revMap.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }

            map.put(s.charAt(i), t.charAt(i));
            revMap.put(t.charAt(i), s.charAt(i));
        }


        
        return true;
    }
}