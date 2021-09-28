/*
 * Copyright © 2021  David Williams
 *
 * This file is part of the interview-find-nth-min.
 *
 * interview-find-nth-min is free software: you can redistribute it and/or modify it under the terms of the
 * Lesser GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * interview-find-nth-min is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the Lesser GNU General Public
 * License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public License along with interview-find-nth-min.
 * If not, see <a href="http://www.gnu.org/licenses/">www.gnu.org/licenses/</a>.
 */
package com.example.code;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Finds the nth minimum integer out of array of integers.
 * <p/>
 * For example, if the input array is [9, 6, 8, 2, 3, 7, 4, 8] and n = 3, then the result is 4.
 *
 * @author PineForest (see https://github.com/PineForest) 09/23/2021
 */
public class Exercise {
  /*
     From Java PriorityQueue documentation:
       this implementation provides O(log(n)) time for the enqueing and dequeing methods
       (offer, poll, remove() and add); linear time for the remove(Object) and
       contains(Object) methods; and constant time for the retrieval methods
       (peek, element, and size).
   */
  public int getNthMinInteger_minHeapAlgorithm(int n, int[] integers) {
    int integersSize = integers.length;
    assert integersSize >= n;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(integersSize);
    List<Integer> integersList = Arrays.stream(integers).boxed().collect(Collectors.toList());
    minHeap.addAll(integersList);
    int nthMinInteger = -1;
    for (int i = 0; i < n; ++i) {
      nthMinInteger = minHeap.remove();
    }
    return nthMinInteger;
  }
}
