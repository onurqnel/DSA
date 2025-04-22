### Characteristics of an Algorithm
1. **Input(s):**  
    An algorithm may have zero or more inputs.
2. **Output(s):**  
    It must produce at least one output.
3. **Definiteness:**  
    Every step must be clearly and unambiguously defined—no vague or unknown instructions.
4. **Finiteness:**  
    It must terminate after a finite number of steps (unless it's designed as a continuous service).
5. **Effectiveness:**  
    Each step must be simple and doable. Avoid unnecessary operations.

### Algorithm Analysis Criteria
1. **Time Complexity** – How long the algorithm takes to run.
2. **Space Complexity** – How much memory it uses.
3. **Network/Data Transfer Usage** – Relevant in distributed systems.
4. **Power Consumption** – Important for mobile or embedded systems.
5. **Register/Processor Usage** – For low-level optimization.
```cpp
swap(a, b) {
    temp = a;  // 1
    a = b;     // 1
    b = temp;  // 1
}
```
Total steps: **3** Time Complexity: **O(1)** (constant time)

### Frequency Count Method
Frequency Count is a method of analyzing an algorithm by counting how many times each line or group of lines executes in terms of the input size `n`. This helps derive a function `f(n)` to represent its time complexity.
```cpp
Alg(A, n) {
	s = 0;  // 1 time
    for (i = 0; i < n; i++) // (n + 1) times 
    {  
        s = s + A[i];    // n times
    }
    return s;            // 1 time
}
// Total operations: f(n) = 2n + 3
// Time Complexity: O(n)
```

```cpp
AlgAdd(A, B, n) {
    for (i = 0; i < n; i++) {   // (n + 1) times
        for (j = 0; j < n; j++) {    // n × (n + 1)
            C[i][j] = A[i][j] + B[i][j];  // n² times
        }
    }
}
// Total operations: f(n) = 2n² + 2n + 1
// Time Complexity: O(n²)
```

| Variable | Space Used | Notes          |
| -------- | ---------- | -------------- |
| A        | `n²`       | Matrix A       |
| B        | `n²`       | Matrix B       |
| C        | `n²`       | Result matrix  |
| n, i, j  | `1` each   | Constant space |
**Total space:** `3n² + 3`  
**Space Complexity:** `O(n²)`