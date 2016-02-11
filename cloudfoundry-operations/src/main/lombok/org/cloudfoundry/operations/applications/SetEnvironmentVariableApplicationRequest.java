/*
 * Copyright 2013-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.operations.applications;

import lombok.Builder;
import lombok.Data;
import org.cloudfoundry.client.Validatable;
import org.cloudfoundry.client.ValidationResult;

/**
 * The request options for the set environment variable of an application operation
 */
@Data
public final class SetEnvironmentVariableApplicationRequest implements Validatable {

    /**
     * The application name
     * 
     * @param name the application name
     * @return the application name
     */
    private final String name;

    /**
     * The variable name
     * 
     * @param variableName the variable name
     * @return the variable name
     */
    private final String variableName;

    /**
     * The variable value
     * 
     * @param variableValue the variable value
     * @return the variable value
     */
    private final String variableValue;

    @Builder
    SetEnvironmentVariableApplicationRequest(String name,
                                             String variableName,
                                             String variableValue) {
        this.name = name;
        this.variableName = variableName;
        this.variableValue = variableValue;
    }

    @Override
    public ValidationResult isValid() {
        ValidationResult.ValidationResultBuilder builder = ValidationResult.builder();

        if (this.name == null) {
            builder.message("name must be specified");
        }

        if (this.variableName == null) {
            builder.message("variable name must be specified");
        }

        if (this.variableValue == null) {
            builder.message("variable value must be specified");
        }

        return builder.build();
    }

}
