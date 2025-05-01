public class wordcount{ 
    public static void main(String[] args) { 
        // Sample input string 
        String text = "this is a wordcount example."; 
        // Count words in the input string 
        int wordCount = countWords(text); 
        // Output the result 
        System.out.println("Word count: " + wordCount); 
    } 
    public static int countWords(String text) { 
        // Trim any leading or trailing spaces 
        text = text.trim(); 
        // If the string is empty, return 0 
        if (text.isEmpty()) { 
            return 0; 
        } 
        // Split the text by one or more spaces 
        String[] words = text.split("\\s+"); 
        // Return the number of words in the array 
        return words.length; 
    } 
}