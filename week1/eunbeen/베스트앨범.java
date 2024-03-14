import java.util.*;

public class Music implements Comparable<Music>{

    public int index;
    public int count;
    
    public Music(int index,int count){
        this.index = index;
        this.count = count;
    }
    
    @Override
	public int compareTo(Music o) {
		return o.count - this.count;
	}
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        List<Integer> answer = new ArrayList();
        
        Map<String, Integer> map_count = new HashMap();
        Map<String, List<Music>> map_music = new HashMap();
        
        for(int i=0; i < genres.length; i++){
            List<Music> list = map_music.getOrDefault(genres[i], new ArrayList());
            list.add(new Music(i, plays[i]));
            
            map_music.put(genres[i], list);
            map_count.put(genres[i], map_count.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        int size = map_count.size();
        
        for(int i=0; i<size; i++){
            String maxKey = map_count.keySet().stream()
                            .max(Comparator.comparing(map_count::get))
                            .orElse(null);
            map_count.remove(maxKey);
            
            List<Music> list = map_music.get(maxKey);
            Collections.sort(list);
            
            for(int j=0; j<list.size(); j++){
                if(j == 2) break;
                
                answer.add(list.get(j).index);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}