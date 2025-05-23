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
package org.apache.dubbo.config.builders;

import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.config.AbstractConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * AbstractBuilder
 *
 * @since 2.7
 */
public abstract class AbstractBuilder<T extends AbstractConfig, B extends AbstractBuilder> {
    /**
     * The config id
     */
    protected String id;
    protected String prefix;

    protected B id(String id) {
        this.id = id;
        return getThis();
    }

    protected B prefix(String prefix) {
        this.prefix = prefix;
        return getThis();
    }

    protected abstract B getThis();

    protected static Map<String, String> appendParameter(Map<String, String> parameters, String key, String value) {
        if (parameters == null) {
            parameters = new HashMap<>();
        }
        parameters.put(key, value);
        return parameters;
    }

    protected static Map<String, String> appendParameters(Map<String, String> parameters, Map<String, String> appendParameters) {
        if (parameters == null) {
            parameters = new HashMap<>();
        }
        parameters.putAll(appendParameters);
        return parameters;
    }

    protected void build(T instance) {
        if (!StringUtils.isEmpty(id)) {
            instance.setId(id);
        }
        if (!StringUtils.isEmpty(prefix)) {
            instance.setPrefix(prefix);
        }
    }
}
