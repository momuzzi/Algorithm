import java.util.*;

class Solution {
    
    static int defaultMin;
    static int defaultFee;
    static int extraMin;
    static int extraFee;
    
    public int[] solution(int[] fees, String[] records) {        
        defaultMin = fees[0];
        defaultFee = fees[1];
        extraMin = fees[2];
        extraFee = fees[3];
        
        // <차랑 번호, 총 시간>
        Map<String, Integer> carTotalMin = new HashMap<>();

        // <차량 번호, 마지막 IN 시각>
        Map<String, Integer> carLastInTime = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] line = records[i].split(" ");
            
            String time = line[0];
            String carNum = line[1];
            String status = line[2];
            
            if (status.equals("IN")) {
                carLastInTime.put(carNum, toIntTime(time));
            }else {
                int outTime = toIntTime(time);
                int lastInTime = carLastInTime.get(carNum);
                
                carTotalMin.put(carNum, carTotalMin.getOrDefault(carNum, 0) + outTime - lastInTime);
                carLastInTime.remove(carNum);
            }
        }
        
        Set<String> notOutCarSet = carLastInTime.keySet();
        for (String carNum : notOutCarSet) {
            int endTime = 23 * 60 + 59;
            
            int lastInTime = carLastInTime.get(carNum);
            carTotalMin.put(carNum, carTotalMin.getOrDefault(carNum, 0) + endTime - lastInTime);
        }
        
        Set<String> allCarSet = carTotalMin.keySet();
        List<String> allCarList = new ArrayList<>(allCarSet);
        allCarList.sort((a, b) -> a.compareTo(b));
        
        int[] answer = new int[allCarList.size()];
        
        for (int i = 0; i < allCarList.size(); i++) {
            answer[i] = calTotalFee(carTotalMin.get(allCarList.get(i))); 
        }
        
        return answer;
    }
    
    static int toIntTime(String time) {
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);
        
        return h * 60 + m;
    }
    
    static int calTotalFee(int totalMin) {
        if (totalMin <= defaultMin) return defaultFee;
        
        int moreMin = totalMin - defaultMin;
        
        int moreFee = moreMin / extraMin * extraFee;
        if (moreMin % extraMin != 0) {
            moreFee += extraFee;
        }
        
        return defaultFee + moreFee;
    }
}