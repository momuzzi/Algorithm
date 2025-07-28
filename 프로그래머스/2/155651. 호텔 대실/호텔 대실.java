import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Book> bookPq = new PriorityQueue<>((a, b) -> {
            if (a.start == b.start) {
                return Integer.compare(a.end, b.end);
            }
            
            return Integer.compare(a.start, b.start);
        });
        
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].substring(0, 2)) * 3600 
                + Integer.parseInt(book_time[i][0].substring(3, 5)) * 60;
            int end = Integer.parseInt(book_time[i][1].substring(0, 2)) * 3600 
                + Integer.parseInt(book_time[i][1].substring(3, 5)) * 60;
            
            bookPq.offer(new Book(start, end));
        }
        
        PriorityQueue<Book> roomPq = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        
        Book book = bookPq.poll();
        roomPq.offer(book);
        
        for (int i = 1; i < book_time.length; i++) {
            Book nowbook = bookPq.poll();
            
            Book alreadyBook = roomPq.peek();
            
            if (alreadyBook.end + 600 <= nowbook.start) {
                roomPq.poll();
            }
            
            roomPq.offer(nowbook);
        }
        
        answer = roomPq.size();
        
        return answer;
    }
    
    
    static class Book {
        int start;
        int end;
        
        Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}