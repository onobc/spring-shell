/*
 * Copyright 2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.shell.boot;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.DefaultShellApplicationRunner;
import org.springframework.shell.ShellApplicationRunner;
import org.springframework.shell.ShellRunner;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(SpringShellProperties.class)
public class ApplicationRunnerAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean(ShellApplicationRunner.class)
	public DefaultShellApplicationRunner defaultShellApplicationRunner(List<ShellRunner> shellRunners) {
		return new DefaultShellApplicationRunner(shellRunners);
	}
}
