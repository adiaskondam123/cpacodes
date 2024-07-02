import java.util.*; 
class Kdiffintegers { 
public int subarraysWithKDistinct(int[] A, int K) { 
return atMostK(A, K) - atMostK(A, K - 1); 
} 
int atMostK(int[] A, int K) { 
int i = 0, res = 0; 
Map < Integer, Integer > count = new HashMap < > (); 
for (int j = 0; j < A.length; ++j) { 
if (count.getOrDefault(A[j], 0) == 0) K--; 
count.put(A[j], count.getOrDefault(A[j], 0) + 1); 
while (K < 0) { 
count.put(A[i], count.get(A[i]) - 1); 
if (count.get(A[i]) == 0) K++; 
i++; 
} 
res += j - i + 1; 
} 
return res; 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
int n = sc.nextInt(); 
int k = sc.nextInt(); 
int arr[] = new int[n]; 
for (int i = 0; i < n; i++) 
arr[i] = sc.nextInt(); 
System.out.println(new Kdiffintegers().subarraysWithKDistinct(arr, k)); 
sc.close();
} 
} 