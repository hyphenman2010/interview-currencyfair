package org.ivanman.interview.messaging;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class DateDeserializer extends StdDeserializer<Date> {

	public DateDeserializer() {
		super(Date.class);
	}

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException {

		String dtStr = parser.readValueAs(String.class);
		try {
			DateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm:ss", Locale.ENGLISH);
			return df.parse(dtStr);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
}
