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

import junit.framework.AssertionFailedError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Tests the behavior of {@link Exercise#getNthMinInteger_minHeapAlgorithm(int, int[])}.
 *
 * @author PineForest (see https://github.com/PineForest) 09/23/2021
 */
class ExerciseTest {
  final static Map<Integer, Map<Integer, int[]>> TEST_DATA = Map.of(
      19, Map.of(5, new int[] {5, 3, 19, 4, 53, 1, 65, 102, 3265, 900}),
      4, Map.of(3, new int[] {9, 6, 8, 2, 3, 7, 4, 8})
  );

  @Test
  void getNthMinInteger_minHeapAlgorithm() throws AssertionError {
    Exercise exercise = new Exercise();
    for (Entry<Integer, Map<Integer, int[]>> testData : TEST_DATA.entrySet()) {
      int expected = testData.getKey();
      Entry<Integer, int[]> source =
          testData.getValue().entrySet().stream().findFirst().orElseThrow(AssertionFailedError::new);
      int actual = exercise.getNthMinInteger_minHeapAlgorithm(source.getKey(), source.getValue());
      Assertions.assertEquals(expected, actual);
      System.out.printf("Success: n=%d array=%s%n", expected, Arrays.toString(source.getValue()));
    }
  }
}