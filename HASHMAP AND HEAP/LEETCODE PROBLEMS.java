//  | 981 | Time Based Key-Value Store |  Medium | Facebook |

class TimeMap {

    HashMap<String, HashMap<Integer, String>> map = new HashMap<>();

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        HashMap<Integer, String> temp = map.getOrDefault(key, new HashMap<Integer, String>());
        temp.put(timestamp, value);
        map.put(key, temp);
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)){
            Map<Integer, String> tempMap = map.get(key);
            for (int i = timestamp; i >= 0; i--) {
                if (tempMap.containsKey(i)) {
                    return tempMap.get(i);
                }
            }
            return "";
        }else {
            return "";
        }
    }
}
