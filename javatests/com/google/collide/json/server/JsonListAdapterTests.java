// Copyright 2012 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.collide.json.server;

import com.google.collide.json.shared.JsonArray;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Tests a JSON List adapter used by JsonArray
 */
public class JsonListAdapterTests extends TestCase {

  private static <T> JsonArray<T> create() {
    return new JsonArrayListAdapter<T>(new ArrayList<T>());
  }

  public void testOutOfBounds() {
    JsonArray<Integer> numbers = create();
    numbers.add(0);
    try {
      numbers.set(2, 2);
    } catch (IndexOutOfBoundsException ex) {
      // We expect this.
      return;
    }
    fail("IndexOutOfBoundsException didn't occur");
  }
}