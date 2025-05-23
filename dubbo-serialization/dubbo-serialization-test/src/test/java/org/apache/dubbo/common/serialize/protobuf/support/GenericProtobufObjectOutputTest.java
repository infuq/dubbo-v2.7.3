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
package org.apache.dubbo.common.serialize.protobuf.support;

import org.apache.dubbo.common.serialize.protobuf.support.model.GooglePB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GenericProtobufObjectOutputTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    private GenericProtobufObjectOutput genericProtobufObjectOutput;
    private GenericProtobufObjectInput genericProtobufObjectInput;
    private ByteArrayInputStream byteArrayInputStream;

    @BeforeEach
    public void setUp() {
        this.byteArrayOutputStream = new ByteArrayOutputStream();
        this.genericProtobufObjectOutput = new GenericProtobufObjectOutput(byteArrayOutputStream);
    }

    @Test
    public void testWriteObjectNull() throws IOException {
        assertThrows(IllegalArgumentException.class, () -> {
            this.genericProtobufObjectOutput.writeObject(null);
        });
    }

    @Test
    public void testWriteGooglePbObject() throws IOException {
        Random random = new Random();
        final int bound = 100000;
        List<GooglePB.PhoneNumber> phoneNumberList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            phoneNumberList.add(GooglePB.PhoneNumber.newBuilder().setNumber(random.nextInt(bound) + "").setType(GooglePB.PhoneType.forNumber(random.nextInt(GooglePB.PhoneType.values().length - 1))).build());
        }

        Map<String, GooglePB.PhoneNumber> phoneNumberMap = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            phoneNumberMap.put("phoneNumber" + i, GooglePB.PhoneNumber.newBuilder().setNumber(random.nextInt(bound) + "").setType(GooglePB.PhoneType.forNumber(random.nextInt(GooglePB.PhoneType.values().length - 1))).build());
        }
        GooglePB.PBRequestType request = GooglePB.PBRequestType.newBuilder()
                .setAge(15).setCash(10).setMoney(16.0).setNum(100L)
                .addAllPhone(phoneNumberList).putAllDoubleMap(phoneNumberMap).build();

        this.genericProtobufObjectOutput.writeObject(request);
        this.flushToInput();
        assertThat(genericProtobufObjectInput.readObject(GooglePB.PBRequestType.class), is(request));
    }

    private void flushToInput() {
        this.genericProtobufObjectOutput.flushBuffer();
        this.byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        this.genericProtobufObjectInput = new GenericProtobufObjectInput(byteArrayInputStream);
    }
}

