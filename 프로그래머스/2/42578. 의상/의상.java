import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 2차원 배열이 <옷 이름, 옷 종류> 로 이루어져 있다.
        // 옷 종류를 기준으로 하는 리스트에 옷 이름을 전부 담는다. (옷 이름의 중복은 없다)
        
        // 키 : 옷 종류(type), 값 : 옷 종류의 수
        Map<String, Integer> hashMap = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            hashMap.put(type, hashMap.getOrDefault(type, 0) + 1);
        }
        
        // 예를 들어 모자 2개, 안경 1개면 모자를 안쓰는 것도 모자라고 생각하고 1을 더해야하고
        // 안경을 안쓰는 것도 안경이라 생각하고 1을 더함. 그럼 3 * 2가지의 경우가 나온다.
        // 각 종류별 옷의 수 + 1 (안 입는 경우도 포함) 을 곱한다.
        for (int count : hashMap.values()) {
            answer *= (count + 1);
        }
        
        // 위에서 3 * 2 가지의 경우 중, 단 한 가지 경우 모자도 안쓰고 안경도 안쓰는 경우는
        // 조건에서 최소 한개는 입는다 했기 때문에
        // 아무 것도 입지 않는 경우의 수 1을 뺀다.
        return answer - 1;    
    
    }
}