The following methods are defined for you in Java.  If you recall others, you may use them as well.

Syntax:
- `Class::method` allows you to use a method from a class as if it were a function object,
    where "Class" is the name of the class and "method" is the name of the method.

Enumerations:
- `String name()` return the literal name of the value in the enumeration.
- `Enum[] values()` returns all possible non-null values of the given enumeration, where Enum is the
   name of the enum type.
- `Enum valueOf(String)` returns the value with the exact same name as the String. Case
   is not ignored in this method. Enum is the name of the enum type.

The `List<T>` interface:
- You can create a list from a bunch of elements with `List.of(x, y, z, ...)`
- You can create a list from an array of elements with `List.of(arr)`
- You can create an empty list with `new ArrayList<>()`
- `int size()` returns the number of elements in the list
- `boolean isEmpty()` returns whether size is currently zero
- `T get(int index)` returns the requested element (0-based) of the list
- `T set(int index, T newVal)` updates the value at the requested index (0-based) and returns the previous value
- `boolean add(T newVal)` adds the value to the end of the list, and returns true upon success
- `boolean addAll(Collection<T> newVals)` essentially calls `this.add` on each element of the given list
    and returns true upon success
- `void clear()` empties out the list
- `List<T> subList(int startIndex, int endIndex)` returns a list containing `(endIndex - startIndex)` elements,
   starting from `startIndex` (0-based) and ending just before `endIndex`.  Mutating this list will mutate
   the original list.
- `boolean remove(T item)` removes the first occurrence of the item, and returns true if successful
- `boolean remove(int index)` removes the item at the requested (0-based) index and returns true if successful
- `void sort(Comparator<T> comp)` sorts the elements by the given comparator
- `boolean equals(List<T> other)` returns true if the given list is the same size as this one, and
    corresponding elements of the two lists are `.equals` to each other
- `T[] toArray(T[])` returns an array copy of the list with the exact same length as the size of the list.
  Usually used as `list.toArray(new T[0])` if the client is unsure how long the array should be.
  
The `Comparator<T>` interface:
- `int compare(T item1, T item2)` returns a negative number if `item1` comes before `item2`, zero if they're the same,
    or a positive number if `item1` comes after `item2`.
- You can create a comparator manually, 
- You can create a comparator via `Comparator.comparingInt(Function<T, Integer>)` that converts each `T`
    item to an integer via the given function, and then compares the resulting integers.
- You can create a comparator via `Comparator.comparingDouble(Function<T, Double>)` that converts each `T`
  item to a double via the given function, and then compares the resulting doubles.

The `Set<T>` interface:
- You can create a set from a bunch of elements with `Set.of(x, y, z, ...)`
- You can create an empty set with `new HashSet<>()`
- `int size()` returns the number of elements in the set
- `boolean isEmpty()` returns whether size is currently zero
- `boolean contains(T item)` returns true if the set contains the given item (compared with `.equals`) 
- `boolean remove(T item)` removes the first occurrence of the item, and returns true if successful
- `boolean add(T newVal)` adds the value to the end of the list, and returns true if the value was 
   not previously present
- `boolean addAll(Collection<T> newVals)` essentially calls `this.add` on each element of the given list
    and returns true if any elements were added
- `void clear()` empties out the list
- `boolean equals(Set<T> other)` returns true if the given set is the same size as this one, and
    the elements of the two sets are `.equals` to each other

The `Collection<T>` interface:
- Describes a bunch of items
- Lists and Sets are both Collections

The `Map<K, V>` interface:
- You can create an empty map via `new HashMap<>()`
- `int size()` returns the number of elements in the map
- `boolean isEmpty()` returns whether size is currently zero
- `V get(K key)` returns the requested value associated with the key, or `null` if not present
- `V getOrDefault(K key, V default)` returns the requested value associated with the key, 
    or the given `default` if not present
- `V put(K key, V newVal)` updates the value at the requested key and returns the previous value
- `void putAll(Map<K, V> newVals)` essentially calls `this.put` on each entry from the given map
- `boolean containsKey(K key)` returns true if and only if the existing key exists in the map.
   The check is made using the equals method of the object.
- `Set<K> keySet()` returns a set of all the keys in this map.  Mutating this set will likely 
   throw a `ConcurrentModificationException`
- `Collection<V> values()` returns a collection of all the values in this map (there may be duplicates).
- `void clear()` empties out the map
- `boolean remove(K key)` removes the requested key from the map, and returns true if successful
- `boolean equals(Map<K, V> other)` returns true if the given map is the same size as this one, and
  corresponding elements of the two maps are `.equals` to each other

The `Collections` static methods:
- `<T extends Comparable<T>> void sort(List<T> list)` will sort the given list by its natural order
- `<T> void sort(List<T> list, Comparator<T> comp)` will sort the given list by the given comparator
- `<T> List<T> Collections.unmodifiableList(List<T> list)` returns a new list with the same content and order
   as the given list, but that cannot be mutated
- `<T> Set<T> Collections.unmodifiableSet(Set<T> set)` returns a new set with the same content
    as the given set, but that cannot be mutated
- `<K, V> Map<K, V> Collections.unmodifiableMap(Map<K, V> map)` returns a new map with the same content 
   as the given map, but that cannot be mutated

JUnit assertions:
- `<T> Assert.assertEquals(T expected, T actual)` checks whether the two values are `.equals`
- `<T> Assert.assertEquals(double expected, double actual, double delta)` checks whether the two doubles are within delta of each other, where delta is a really small number.
- `<T> Assert.assertNotEquals(T expected, T actual)` checks whether the two values are not `.equals`
- `<T> Assert.assertArrayEquals (T[] expected, T[] actual)` checks whether two arrays have `.equals` contents in the exact same order
- `<T extends Exception> Assert.assertThrows(Class<T> exceptionType, ThrowingRunnable func)` runs the given 
    function-object `func`, and checks to see whether it indeed throws an exception of the expected type.
- `@Test` is used to annotate test methods
- `@Test` can be annotated with `(expected=name-of-exception.class)` to pass if any line throws that exception
- `@Before` is used to annotate test fixtures that run before each `@Test` method