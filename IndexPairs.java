import java.util.*; 
class IndexPairs { 
public int[][] indexPairs(String text, String[] words) { 
List < int[] > indexPairsList = new ArrayList < int[] > (); 
for (String word: words) { 
int wordLength = word.length(); 
int curIndex = 0; 
while (curIndex >= 0) { 
curIndex = text.indexOf(word, curIndex); 
if (curIndex >= 0) { 
indexPairsList.add(new int[] { 
curIndex, 
curIndex + wordLength - 1 
}); 
curIndex++; 
} 
} 
} 
Collections.sort(indexPairsList, new Comparator < int[] > () { 
public int compare(int[] array1, int[] array2) { 
return ((array1[0] != array2[0]) ? (array1[0] - array2[0]) : (array1[1] - array2[1])); 
} 
}); 
int length = indexPairsList.size(); 
int[][] indexPairs = new int[length][2]; 
for (int i = 0; i < length; i++) { 
int[] indexPair = indexPairsList.get(i); 
indexPairs[i][0] = indexPair[0]; 
indexPairs[i][1] = indexPair[1]; 
} 
return indexPairs; 
} 
public static void main(String args[]) { 
Scanner sc = new Scanner(System.in); 
String text = sc.nextLine(); 
String[] words = sc.nextLine().split(" "); 
int[][] result = new IndexPairs().indexPairs(text, words); 
for (int[] res: result) 
System.out.print(Arrays.toString(res)); 
sc.close();
} 
}
