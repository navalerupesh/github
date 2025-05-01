import java.io.*; 
import java.util.*; 
import java.util.concurrent.*; 
import java.util.regex.*; 
public class kalyani { 
    // Mapper: Splits lines into words and creates (word, 1) pairs 
    public static class Mapper { 
        public List<Map<String, Integer>> map(String input) { 
            List<Map<String, Integer>> wordCountList = new ArrayList<>(); 
            Map<String, Integer> wordCountMap = new HashMap<>(); 
            // Split the input into words (based on non-word characters) 
            String[] words = input.split("\\W+") 
            for (String word : words) { 
                if (!word.isEmpty()) { 
                    word = word.toLowerCase(); 
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1); 
                } 
            } 
            // Add the word counts from this line to the result 
            wordCountList.add(wordCountMap); 
            return wordCountList; 
        } 
    } 
    // Reducer: Aggregates word counts from all mappers 
    public static class Reducer { 
        public Map<String, Integer> reduce(List<Map<String, Integer>> mappedResults) { 
            Map<String, Integer> finalCountMap = new HashMap<>(); 
            // For each map in the list of results 
            for (Map<String, Integer> map : mappedResults) { 
                // For each word and its count in the map 
                for (Map.Entry<String, Integer> entry : map.entrySet()) { 
                    finalCountMap.put(entry.getKey(), finalCountMap.getOrDefault(entry.getKey(), 0) + 
entry.getValue()); 
                } 
            } 
            return finalCountMap; 
        } 
    } 
    // Main Method 
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException { 
        String inputText = "Hello world hello mapreduce hello Java world"; 
        // 1. Step 1: Map phase (split input into words and create word count pairs) 
        Mapper mapper = new Mapper(); 
        List<Map<String, Integer>> mappedResults = mapper.map(inputText); 
        // 2. Step 2: Reduce phase (aggregate word counts) 
        Reducer reducer = new Reducer(); 
        Map<String, Integer> finalWordCount = reducer.reduce(mappedResults); 
        // 3. Output the result 
        System.out.println("Word Count Results:"); 
        for (Map.Entry<String, Integer> entry : finalWordCount.entrySet()) { 
            System.out.println(entry.getKey() + ": " + entry.getValue()); 
        } 
    } 
}