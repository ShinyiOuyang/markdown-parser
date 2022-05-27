//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
//https://stackoverflow.com/questions/1005073/initialization-of-an-arraylist-in-one-line


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if (openBracket == -1 || 
                closeBracket == -1 || 
                openParen == -1 || 
                closeParen == -1) {
                break;
            }

            boolean noLinkFound = false;
            while (openParen - closeBracket != 1) {
                currentIndex = closeBracket + 1;
                openBracket = markdown.indexOf("[", currentIndex);
                closeBracket = markdown.indexOf("]", openBracket);
                if (openBracket == -1 || 
                    closeBracket == -1) {
                    // Break out of the entire program
                    noLinkFound = true;
                    break;
                }
            }

            //Break out of the entire program
            if (noLinkFound) {
                break;
            }

            int exclamation = markdown.indexOf("!", openBracket - 1);
            if ((exclamation == -1) || (openBracket - exclamation != 1)) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
            }
            
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
