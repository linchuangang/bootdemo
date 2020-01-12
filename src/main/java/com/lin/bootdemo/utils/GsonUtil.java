package com.lin.bootdemo.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class GsonUtil {
    private static Gson gson;

    static {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        builder.registerTypeAdapter(String.class, new StringConverter());
        builder.registerTypeAdapter(Integer.class, new IntegerConverter());
        builder.registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory());
        builder.setDateFormat("MM/dd/yyyy HH:mm:ss");
        gson = builder.create();
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }

    public static <T> T toObject(String json,Class<T> clazz)
    {
       return gson.fromJson(json,clazz);
    }
    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringAdapter();
        }
    }

    public static class StringAdapter extends TypeAdapter<String> {
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }

    static class StringConverter implements JsonSerializer<String>,
            JsonDeserializer<String> {
        public JsonElement serialize(String src, Type typeOfSrc,
                                     JsonSerializationContext context) {
            if (src == null) {
                return new JsonPrimitive("");
            } else {
                return new JsonPrimitive(src.toString());
            }
        }

        public String deserialize(JsonElement json, Type typeOfT,
                                  JsonDeserializationContext context)
                throws JsonParseException {
            return json.getAsJsonPrimitive().getAsString();
        }
    }

    static class IntegerConverter implements JsonSerializer<Integer>,
            JsonDeserializer<Integer> {
        public JsonElement serialize(Integer src, Type typeOfSrc,
                                     JsonSerializationContext context) {
            if (src == null) {
                return new JsonPrimitive(0);
            } else {
                return new JsonPrimitive(src);
            }
        }

        public Integer deserialize(JsonElement json, Type typeOfT,
                                   JsonDeserializationContext context)
                throws JsonParseException {
            return json.getAsJsonPrimitive().getAsInt();
        }
    }

    static class SuperclassExclusionStrategy implements ExclusionStrategy
    {
        public boolean shouldSkipClass(Class<?> arg0)
        {
            return false;
        }

        public boolean shouldSkipField(FieldAttributes fieldAttributes)
        {
            String fieldName = fieldAttributes.getName();
            Class<?> theClass = fieldAttributes.getDeclaringClass();

            return isFieldInSuperclass(theClass, fieldName);
        }

        private boolean isFieldInSuperclass(Class<?> subclass, String fieldName)
        {
            Class<?> superclass = subclass.getSuperclass();
            Field field;

            while(superclass != null)
            {
                field = getField(superclass, fieldName);

                if(field != null)
                    return true;

                superclass = superclass.getSuperclass();
            }

            return false;
        }

        private Field getField(Class<?> theClass, String fieldName)
        {
            try
            {
                return theClass.getDeclaredField(fieldName);
            }
            catch(Exception e)
            {
                return null;
            }
        }
    }
}
