import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int result = 0;
        int end = discount.length;

        Map<String, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }

        if (isAllMatch(map, windowMap)) {
            result++;
        }

        for (int rt = 10; rt < end; rt++) {
            windowMap.put(discount[rt], windowMap.getOrDefault(discount[rt], 0) + 1);

            String lt = discount[rt - 10];
            windowMap.put(lt, windowMap.get(lt) - 1);
            if (windowMap.get(lt) == 0) {
                windowMap.remove(lt);
            }

            if (isAllMatch(map, windowMap)) {
                result++;
            }
        }

        return result;
    }

    private boolean isAllMatch(Map<String, Integer> map, Map<String, Integer> windowMap) {
        for (String key : map.keySet()) {
            if (map.get(key) != windowMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }
}
