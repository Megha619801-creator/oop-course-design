package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;

    public Dictionary() {
        words = new HashMap<>();
    }

    public void addWord(String word, String meaning) {
        words.put(word.toLowerCase(), meaning);
    }

    public String getMeaning(String word) throws Exception {
        if (word == null || word.trim().isEmpty()) {
            throw new Exception("Word is empty!");
        }
        String meaning = words.get(word.toLowerCase());
        if (meaning == null) {
            throw new Exception("Word not found!");
        }
        return meaning;
    }
}
