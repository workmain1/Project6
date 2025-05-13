// Part 3. Analysis of Algorithms and Big O Notation

// Part 3.1 (2 pts.)
// The key operation in the split() method is the modulus operation `n % 2`.
// This is because it determines whether the number is even or odd.
// For every element in pList, we check if it is even or odd,
// and then we add it to either pEvenList or pOddList.
// The key operation happens once for every item in the list.

// Part 3.2 (2 pts.)
// Let n be the number of elements in pList.
// The loop runs n times, and each time we do a modulus operation and one add operation.
// So, the number of times the key operation is done is f(n) = n.
// This means the time complexity of the split() method is O(n).

// Part 3.3 (2 pts.)
// If the elements of pList were sorted in ascending order, the split() method would still do the same amount of work.
// It checks each number to see if it is even or odd, no matter what order they are in.
// So the time complexity stays O(n), even if the list is sorted.
