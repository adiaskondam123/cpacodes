import java.util.*; 
class ShortestSubarray { 
public int shortestSubarray(int[] A, int K) { 
int N = A.length; 
long[] P = new long[N + 1]; 
for (int i = 0; i < N; ++i) 
P[i + 1] = P[i] + (long) A[i]; 
// Want smallest y-x with P[y] - P[x] >= K 
int ans = N + 1; // N+1 is impossible 
Deque < Integer > monoq = new LinkedList<>(); //opt(y) candidates, as indices of P 
for (int y = 0; y < P.length; ++y) { 
// Want opt(y) = largest x with P[x] <= P[y] - K; 
while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()]) 
monoq.removeLast(); 
while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K) 
ans = Math.min(ans, y - monoq.removeFirst()); 
monoq.addLast(y); 
} 
return ans < N + 1 ? ans : -1; 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
int n = sc.nextInt(); 
int k = sc.nextInt(); 
int arr[] = new int[n]; 
for (int i = 0; i < n; i++) 
arr[i] = sc.nextInt(); 
System.out.println(new ShortestSubarray().shortestSubarray(arr, k)); 
sc.close();
} 
}  
