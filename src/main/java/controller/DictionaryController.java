package controller;

import model.Dictionary;

public class DictionaryController {
    private Dictionary dictionary;

    public DictionaryController() {
        dictionary = new Dictionary();

        // Temporary hardcoded words
        dictionary.addWord("apple", "A fruit that is red or green.");
        dictionary.addWord("java", "A popular programming language.");
        dictionary.addWord("keyboard", "Input device for computers.");
    }

    public String searchWord(String word) {
        try {
            return dictionary.getMeaning(word);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void addWord(String word, String meaning) {
        dictionary.addWord(word, meaning);
    }
}
