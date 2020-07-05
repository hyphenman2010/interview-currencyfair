package org.ivanman.interview.messaging;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class DateSerializer extends StdSerializer<Date> {

	public DateSerializer() {
		super(Date.class);
	}

	@Override
	public void serialize(Date value, JsonGenerator generator, SerializerProvider provider) throws IOException {
		DateFormat df = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");
		generator.writeString(df.format(value));
	}
}
