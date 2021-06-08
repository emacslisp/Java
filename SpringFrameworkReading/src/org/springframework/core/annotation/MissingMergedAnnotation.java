/*
 * Copyright 2002-2019 the original author or authors.
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

package org.springframework.core.annotation;

import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.lang.Nullable;

/**
 * An {@link AbstractMergedAnnotation} used as the implementation of
 * {@link MergedAnnotation#missing()}.
 *
 * @author Phillip Webb
 * @author Juergen Hoeller
 * @since 5.2
 * @param <A> the annotation type
 */
final class MissingMergedAnnotation<A extends Annotation> extends AbstractMergedAnnotation<A> {

	private static final MissingMergedAnnotation<?> INSTANCE = new MissingMergedAnnotation<>();

	private MissingMergedAnnotation() {
	}

	@Override
	public Class<A> getType()
	{Thread.dumpStack();
		throw new NoSuchElementException("Unable to get type for missing annotation");
	}

	@Override
	public boolean isPresent()
	{Thread.dumpStack();
		return false;
	}

	@Override
	@Nullable
	public Object getSource()
	{Thread.dumpStack();
		return null;
	}

	@Override
	@Nullable
	public MergedAnnotation<?> getMetaSource()
	{Thread.dumpStack();
		return null;
	}

	@Override
	public MergedAnnotation<?> getRoot()
	{Thread.dumpStack();
		return this;
	}

	@Override
	public List<Class<? extends Annotation>> getMetaTypes()
	{Thread.dumpStack();
		return Collections.emptyList();
	}

	@Override
	public int getDistance()
	{Thread.dumpStack();
		return -1;
	}

	@Override
	public int getAggregateIndex()
	{Thread.dumpStack();
		return -1;
	}

	@Override
	public boolean hasNonDefaultValue(String attributeName)
	{Thread.dumpStack();
		throw new NoSuchElementException("Unable to check non-default value for missing annotation");
	}

	@Override
	public boolean hasDefaultValue(String attributeName)
	{Thread.dumpStack();
		throw new NoSuchElementException("Unable to check default value for missing annotation");
	}

	@Override
	public <T> Optional<T> getValue(String attributeName, Class<T> type)
	{Thread.dumpStack();
		return Optional.empty();
	}

	@Override
	public <T> Optional<T> getDefaultValue(@Nullable String attributeName, Class<T> type)
	{Thread.dumpStack();
		return Optional.empty();
	}

	@Override
	public MergedAnnotation<A> filterAttributes(Predicate<String> predicate)
	{Thread.dumpStack();
		return this;
	}

	@Override
	public MergedAnnotation<A> withNonMergedAttributes()
	{Thread.dumpStack();
		return this;
	}

	@Override
	public AnnotationAttributes asAnnotationAttributes(Adapt... adaptations)
	{Thread.dumpStack();
		return new AnnotationAttributes();
	}

	@Override
	public Map<String, Object> asMap(Adapt... adaptations)
	{Thread.dumpStack();
		return Collections.emptyMap();
	}

	@Override
	public <T extends Map<String, Object>> T asMap(Function<MergedAnnotation<?>, T> factory, Adapt... adaptations)
	{Thread.dumpStack();
		return factory.apply(this);
	}

	@Override
	public String toString()
	{Thread.dumpStack();
		return "(missing)";
	}

	@Override
	public <T extends Annotation> MergedAnnotation<T> getAnnotation(String attributeName, Class<T> type)
			throws NoSuchElementException
	{

		throw new NoSuchElementException("Unable to get attribute value for missing annotation");
	}

	@Override
	public <T extends Annotation> MergedAnnotation<T>[] getAnnotationArray(String attributeName, Class<T> type)
			throws NoSuchElementException
	{

		throw new NoSuchElementException("Unable to get attribute value for missing annotation");
	}

	@Override
	protected <T> T getAttributeValue(String attributeName, Class<T> type)
	{Thread.dumpStack();
		throw new NoSuchElementException("Unable to get attribute value for missing annotation");
	}

	@Override
	protected A createSynthesized()
	{Thread.dumpStack();
		throw new NoSuchElementException("Unable to synthesize missing annotation");
	}

	@SuppressWarnings("unchecked")
	static <A extends Annotation> MergedAnnotation<A> getInstance()
	{Thread.dumpStack();
		return (MergedAnnotation<A>) INSTANCE;
	}

}
