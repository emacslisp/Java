/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.util.xml;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.springframework.lang.Nullable;

/**
 * Abstract base class for {@code XMLStreamReader}s.
 *
 * @author Arjen Poutsma
 * @since 3.0
 */
abstract class AbstractXMLStreamReader implements XMLStreamReader {

	@Override
	public String getElementText() throws XMLStreamException
	{Thread.dumpStack();
		if (getEventType() != XMLStreamConstants.START_ELEMENT) {
			throw new XMLStreamException("Parser must be on START_ELEMENT to read next text", getLocation());
		}
		int eventType = next();
		StringBuilder builder = new StringBuilder();
		while (eventType != XMLStreamConstants.END_ELEMENT) {
			if (eventType == XMLStreamConstants.CHARACTERS || eventType == XMLStreamConstants.CDATA
					|| eventType == XMLStreamConstants.SPACE || eventType == XMLStreamConstants.ENTITY_REFERENCE) {
				builder.append(getText());
			} else if (eventType == XMLStreamConstants.PROCESSING_INSTRUCTION
					|| eventType == XMLStreamConstants.COMMENT) {
				// skipping
			} else if (eventType == XMLStreamConstants.END_DOCUMENT) {
				throw new XMLStreamException("Unexpected end of document when reading element text content",
						getLocation());
			} else if (eventType == XMLStreamConstants.START_ELEMENT) {
				throw new XMLStreamException("Element text content may not contain START_ELEMENT", getLocation());
			} else {
				throw new XMLStreamException("Unexpected event type " + eventType, getLocation());
			}
			eventType = next();
		}
		return builder.toString();
	}

	@Override
	public String getAttributeLocalName(int index)
	{Thread.dumpStack();
		return getAttributeName(index).getLocalPart();
	}

	@Override
	public String getAttributeNamespace(int index)
	{Thread.dumpStack();
		return getAttributeName(index).getNamespaceURI();
	}

	@Override
	public String getAttributePrefix(int index)
	{Thread.dumpStack();
		return getAttributeName(index).getPrefix();
	}

	@Override
	public String getNamespaceURI()
	{Thread.dumpStack();
		int eventType = getEventType();
		if (eventType == XMLStreamConstants.START_ELEMENT || eventType == XMLStreamConstants.END_ELEMENT) {
			return getName().getNamespaceURI();
		} else {
			throw new IllegalStateException("Parser must be on START_ELEMENT or END_ELEMENT state");
		}
	}

	@Override
	public String getNamespaceURI(String prefix)
	{Thread.dumpStack();
		return getNamespaceContext().getNamespaceURI(prefix);
	}

	@Override
	public boolean hasText()
	{Thread.dumpStack();
		int eventType = getEventType();
		return (eventType == XMLStreamConstants.SPACE || eventType == XMLStreamConstants.CHARACTERS
				|| eventType == XMLStreamConstants.COMMENT || eventType == XMLStreamConstants.CDATA
				|| eventType == XMLStreamConstants.ENTITY_REFERENCE);
	}

	@Override
	public String getPrefix()
	{Thread.dumpStack();
		int eventType = getEventType();
		if (eventType == XMLStreamConstants.START_ELEMENT || eventType == XMLStreamConstants.END_ELEMENT) {
			return getName().getPrefix();
		} else {
			throw new IllegalStateException("Parser must be on START_ELEMENT or END_ELEMENT state");
		}
	}

	@Override
	public boolean hasName()
	{Thread.dumpStack();
		int eventType = getEventType();
		return (eventType == XMLStreamConstants.START_ELEMENT || eventType == XMLStreamConstants.END_ELEMENT);
	}

	@Override
	public boolean isWhiteSpace()
	{Thread.dumpStack();
		return getEventType() == XMLStreamConstants.SPACE;
	}

	@Override
	public boolean isStartElement()
	{Thread.dumpStack();
		return getEventType() == XMLStreamConstants.START_ELEMENT;
	}

	@Override
	public boolean isEndElement()
	{Thread.dumpStack();
		return getEventType() == XMLStreamConstants.END_ELEMENT;
	}

	@Override
	public boolean isCharacters()
	{Thread.dumpStack();
		return getEventType() == XMLStreamConstants.CHARACTERS;
	}

	@Override
	public int nextTag() throws XMLStreamException
	{Thread.dumpStack();
		int eventType = next();
		while (eventType == XMLStreamConstants.CHARACTERS && isWhiteSpace()
				|| eventType == XMLStreamConstants.CDATA && isWhiteSpace() || eventType == XMLStreamConstants.SPACE
				|| eventType == XMLStreamConstants.PROCESSING_INSTRUCTION || eventType == XMLStreamConstants.COMMENT) {
			eventType = next();
		}
		if (eventType != XMLStreamConstants.START_ELEMENT && eventType != XMLStreamConstants.END_ELEMENT) {
			throw new XMLStreamException("expected start or end tag", getLocation());
		}
		return eventType;
	}

	@Override
	public void require(int expectedType, String namespaceURI, String localName) throws XMLStreamException
	{Thread.dumpStack();
		int eventType = getEventType();
		if (eventType != expectedType) {
			throw new XMLStreamException("Expected [" + expectedType + "] but read [" + eventType + "]");
		}
	}

	@Override
	@Nullable
	public String getAttributeValue(@Nullable String namespaceURI, String localName)
	{Thread.dumpStack();
		for (int i = 0; i < getAttributeCount(); i++) {
			QName name = getAttributeName(i);
			if (name.getLocalPart().equals(localName)
					&& (namespaceURI == null || name.getNamespaceURI().equals(namespaceURI))) {
				return getAttributeValue(i);
			}
		}
		return null;
	}

	@Override
	public boolean hasNext()
	{Thread.dumpStack();
		return getEventType() != END_DOCUMENT;
	}

	@Override
	public String getLocalName()
	{Thread.dumpStack();
		return getName().getLocalPart();
	}

	@Override
	public char[] getTextCharacters()
	{Thread.dumpStack();
		return getText().toCharArray();
	}

	@Override
	public int getTextCharacters(int sourceStart, char[] target, int targetStart, int length)
	{Thread.dumpStack();
		char[] source = getTextCharacters();
		length = Math.min(length, source.length);
		System.arraycopy(source, sourceStart, target, targetStart, length);
		return length;
	}

	@Override
	public int getTextLength()
	{Thread.dumpStack();
		return getText().length();
	}

}
