/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.rpc.cluster.merger;

import org.apache.dubbo.common.utils.ArrayUtils;
import org.apache.dubbo.rpc.cluster.Merger;

public class FloatArrayMerger implements Merger<float[]> {

    @Override
    public float[] merge(float[]... items) {
        if (ArrayUtils.isEmpty(items)) {
            return new float[0];
        }
        int total = 0;
        for (float[] array : items) {
            if (array != null) {
                total += array.length;
            }
        }
        float[] result = new float[total];
        int index = 0;
        for (float[] array : items) {
            if (array != null) {
                for (float item : array) {
                    result[index++] = item;
                }
            }
        }
        return result;
    }
}
