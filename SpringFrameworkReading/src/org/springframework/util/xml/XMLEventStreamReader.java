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

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Comment;
import javax.xml.stream.events.Namespace;
import javax.xml.stream.events.ProcessingInstruction;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.XMLEvent;

import org.springframework.lang.Nullable;

/**
 * Implementation of the {@link javax.xml.stream.XMLStreamReader} interface that
 * wraps a {@link XMLEventReader}. Useful because the StAX
 * {@link javax.xml.stream.XMLInputFactory} allows one to create a event reader
 * from a stream reader, but not vice-versa.
 *
 * @author Arjen Poutsma
 * @since 3.0
 * @see StaxUtils#createEventStreamReader(javax.xml.stream.XMLEventReader)
 */
class XMLEventStreamReader extends AbstractXMLStreamReader {

	private XMLEvent event;

	private final XMLEventReader eventReader;

	public XMLEventStreamReader(XMLEventReader eventReader) throws XMLStreamException {
		this.eventReader = eventReader;
		this.event = eventReader.nextEvent();
	}

	@Override
	public QName getName()
	{Thread.dumpStack();
		if (this.event.isStartElement()) {
			return this.event.asStartElement().getName();
		} else if (this.event.isEndElement()) {
			return this.event.asEndElement().getName();
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public Location getLocation()
	{Thread.dumpStack();
		return this.event.getLocation();
	}

	@Override
	public int getEventType()
	{Thread.dumpStack();
		return this.event.getEventType();
	}

	@Override
	@Nullable
	public String getVersion()
	{Thread.dumpStack();
		if (this.event.isStartDocument()) {
			return ((StartDocument) this.event).getVersion();
		} else {
			return null;
		}
	}

	@Override
	public Object getProperty(String name) throws IllegalArgumentException
	{Thread.dumpStack();
		return this.eventReader.getProperty(name);
	}

	@Override
	public boolean isStandalone()
	{Thread.dumpStack();
		if (this.event.isStartDocument()) {
			return ((StartDocument) this.event).isStandalone();
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public boolean standaloneSet()
	{Thread.dumpStack();
		if (this.event.isStartDocument()) {
			return ((StartDocument) this.event).standaloneSet();
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	@Nullable
	public String getEncoding()
	{Thread.dumpStack();
		return null;
	}

	@Override
	@Nullable
	public String getCharacterEncodingScheme()
	{Thread.dumpStack();
		return null;
	}

	@Override
	public String getPITarget()
	{Thread.dumpStack();
		if (this.event.isProcessingInstruction()) {
			return ((ProcessingInstruction) this.event).getTarget();
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public String getPIData()
	{Thread.dumpStack();
		if (this.event.isProcessingInstruction()) {
			return ((ProcessingInstruction) this.event).getData();
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public int getTextStart()
	{Thread.dumpStack();
		return 0;
	}

	@Override
	public String getText()
	{Thread.dumpStack();
		if (this.event.isCharacters()) {
			return this.event.asCharacters().getData();
		} else if (this.event.getEventType() == XMLEvent.COMMENT) {
			return ((Comment) this.event).getText();
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	public int getAttributeCount()
	{Thread.dumpStack();
		if (!this.event.isStartElement()) {
			throw new IllegalStateException();
		}
		Iterator attributes = this.event.asStartElement().getAttributes();
		return countIterator(attributes);
	}

	@Override
	public boolean isAttributeSpecified(int index)
	{Thread.dumpStack();
		return getAttribute(index).isSpecified();
	}

	@Override
	public QName getAttributeName(int index)
	{Thread.dumpStack();
		return getAttribute(index).getName();
	}

	@Override
	public String getAttributeType(int index)
	{Thread.dumpStack();
		return getAttribute(index).getDTDType();
	}

	@Override
	public String getAttributeValue(int index)
	{Thread.dumpStack();
		return getAttribute(index).getValue();
	}

	@SuppressWarnings("rawtypes")
	private Attribute getAttribute(int index)
	{Thread.dumpStack();
		if (!this.event.isStartElement()) {
			throw new IllegalStateException();
		}
		int count = 0;
		Iterator attributes = this.event.asStartElement().getAttributes();
		while (attributes.hasNext()) {
			Attribute attribute = (Attribute) attributes.next();
			if (count == index) {
				return attribute;
			} else {
				count++;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public NamespaceContext getNamespaceContext()
	{Thread.dumpStack();
		if (this.event.isStartElement()) {
			return this.event.asStartElement().getNamespaceContext();
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	public int getNamespaceCount()
	{Thread.dumpStack();
		Iterator namespaces;
		if (this.event.isStartElement()) {
			namespaces = this.event.asStartElement().getNamespaces();
		} else if (this.event.isEndElement()) {
			namespaces = this.event.asEndElement().getNamespaces();
		} else {
			throw new IllegalStateException();
		}
		return countIterator(namespaces);
	}

	@Override
	public String getNamespacePrefix(int index)
	{Thread.dumpStack();
		return getNamespace(index).getPrefix();
	}

	@Override
	public String getNamespaceURI(int index)
	{Thread.dumpStack();
		return getNamespace(index).getNamespaceURI();
	}

	@SuppressWarnings("rawtypes")
	private Namespace getNamespace(int index)
	{Thread.dumpStack();
		Iterator namespaces;
		if (this.event.isStartElement()) {
			namespaces = this.event.asStartElement().getNamespaces();
		} else if (this.event.isEndElement()) {
			namespaces = this.event.asEndElement().getNamespaces();
		} else {
			throw new IllegalStateException();
		}
		int count = 0;
		while (namespaces.hasNext()) {
			Namespace namespace = (Namespace) namespaces.next();
			if (count == index) {
				return namespace;
			} else {
				count++;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public int next() throws XMLStreamException
	{Thread.dumpStack();
		this.event = this.eventReader.nextEvent();
		return this.event.getEventType();
	}

	@Override
	public void close() throws XMLStreamException
	{Thread.dumpStack();
		this.eventReader.close();
	}

	@SuppressWarnings("rawtypes")
	private static int countIterator(Iterator iterator)
	{Thread.dumpStack();
		int count = 0;
		while (iterator.hasNext()) {
			iterator.next();
			count++;
		}
		return count;
	}

}
