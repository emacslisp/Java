package com.dw.lib;

import java.text.MessageFormat;

public class StringManager {
	public StringManager() {
		
	}
	public String getString(String key)
	{
		return key;
	}
	public String getString(final String key, final Object... args)
	{
		String value = getString(key);
		if (value == null) {
			value = key;
		}

		MessageFormat mf = new MessageFormat(value);
		return mf.format(args, new StringBuffer(), null).toString();
	}
}
