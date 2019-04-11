package com.zl.json.gson;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.zl.json.User;

/**
 * @author tzxx
 */
public class GsonTest {
    public void getNull() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        User user = new User("怪盗kidou", 24);
        //{"name":"怪盗kidou","age":24,"email":null}
        System.out.println(gson.toJson(user));
    }

    public void printJson() throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
        //演示null
        writer.beginObject() // throws IOException
                .name("name").value("怪盗kidou").name("age").value(24).name("email").nullValue()
                .endObject(); // throws IOException
        writer.flush(); // throws IOException
        //{"name":"怪盗kidou","age":24,"email":null}
        Gson gson = new Gson();
        User user = new User("怪盗kidou", 24, "ikidou@example.com");
        // 写到控制台
        gson.toJson(user, System.out);
    }

    public void jsonToObject() throws IOException {
        String json = "{\"name\":\"怪盗kidou\",\"age\":\"24\"}";
        User user = new User();
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.beginObject(); // throws IOException
        while (reader.hasNext()) {
            String s = reader.nextName();
            switch (s) {
                case "name":
                    user.name = reader.nextString();
                    break;
                case "age":
                    //自动转换
                    user.age = reader.nextInt();
                    break;
                case "email":
                    user.email = reader.nextString();
                    break;
                default:
            }
        }
        // throws IOException
        reader.endObject();
        // 怪盗kidou
        System.out.println(user.name);
        // 24
        System.out.println(user.age);
        // ikidou@example.com
        System.out.println(user.email);
    }

    public void jsonStringCastListOrArray() {
        Gson gson = new Gson();
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList1 = Arrays.asList(strings);
        for (String string : stringList1) {
            System.out.println(string);
        }
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {
        }.getType());
        for (String string : stringList) {
            System.out.println(string);
        }
    }

    public
 static void main(String[] args) {
        String s = "true";
        boolean aBoolean = new Gson().fromJson(s, Boolean.class);
        System.out.println(aBoolean == true);
    }
}