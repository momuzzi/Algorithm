import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {        
        // 장르 종류
        Set<String> set = new HashSet<>();
        
        // 장르별 속한 노래의 총 실행 횟수
        Map<String, Integer> map1 = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            map1.put(genres[i], map1.getOrDefault(genres[i], 0) + plays[i]);
            set.add(genres[i]);
        }
        
        List<NodeB> nodeBList = new ArrayList<>();
        
        for (String s : set) {
            int n = map1.get(s);
            nodeBList.add(new NodeB(s, n));
        }
        
        nodeBList.sort((a, b) -> Integer.compare(b.cnt, a.cnt));
        
        // 장르 내 많이 재생된 노래 순서 정보
        Map<String, List<Node>> map2 = new HashMap<>();
        
        for (String s : set) {
            map2.put(s, new ArrayList<>());
        }
        
        for (int i = 0; i < genres.length; i++) {
            List<Node> list = map2.get(genres[i]);
            list.add(new Node(i, plays[i]));
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < nodeBList.size(); i++) {
            NodeB nodeB = nodeBList.get(i);
            List<Node> nodeList = map2.get(nodeB.genre);
            nodeList.sort((a, b) -> {
                if (a.cnt != b.cnt) return Integer.compare(b.cnt, a.cnt);
                return Integer.compare(a.idx, b.idx);
            });
            
            for (int j = 0; j < 2; j++) {
                if (j == 1 && nodeList.size() == 1) break;

                Node node = nodeList.get(j);
                answerList.add(node.idx);
            }
        }
        
        int[] answer = new int[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    static class Node {
        int idx;
        int cnt;
        
        Node(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    
    static class NodeB {
        String genre;
        int cnt;
        
        NodeB(String genre, int cnt) {
            this.genre = genre;
            this.cnt = cnt;
        }
    }
}