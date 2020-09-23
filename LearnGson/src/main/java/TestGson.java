import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @ClassName : TestGson
 * @Description : gson使用
 * @Author : wanzepeng
 * @Date: 2020-09-22 17:02
 */
public class TestGson {
    List<Person> list = new ArrayList<>();

    Person wzp = new Person();
    Person zyp = new Person();

    {
        list.add(wzp);
        list.add(zyp);
        wzp.setAge(25);
        wzp.setMoney(10000000000.0);
        wzp.setName("wzp");
        wzp.setPerson(zyp);

        zyp.setAge(25);
        zyp.setMoney(1.0);
        zyp.setName("zyp");
    }

    String wzpJson = new Gson().toJson(wzp);
    String zypJson = new Gson().toJson(zyp);
    String listJson = new Gson().toJson(list);

    //有实体类的情况
    @Test
    public void convertJsonToDao() {
        Gson gson = new Gson();
        //实体类转json
        String personJson = gson.toJson(wzp);
        System.out.println(personJson);
        //json转实体类
        Person wzp = gson.fromJson(personJson, Person.class);
        System.out.println(wzp);
    }

    //没有实体类的情况
    @Test
    public void convertJsonToParameter() {
        //json转JsonObject/JsonArray，获取每个属性值
        //        JsonObject jsonObject = new JsonParser().parse(wzpJson).getAsJsonObject();
        JsonObject asJsonObject = JsonParser.parseString(wzpJson).getAsJsonObject();
        String name = asJsonObject.get("name").getAsString();
        int age = asJsonObject.get("age").getAsInt();
        double money = asJsonObject.get("money").getAsDouble();
        JsonObject jsonObject = asJsonObject.get("person").getAsJsonObject();

        JsonArray asJsonArray = JsonParser.parseString(listJson).getAsJsonArray();
        for (JsonElement jsonElement : asJsonArray) {
            System.out.println(jsonElement);
        }
    }

    //list转Json
    @Test
    public void convertListToJson() {
        String listJson = new Gson().toJson(list);
    }

    //JSON转list
    @Test
    public void convertParameterToJson() {
        List<Person> personList = new Gson().fromJson(listJson, new TypeToken<List<Person>>() {
        }.getType());
    }

    @Test
    public void convertListToJsonTemp() {
        JsonElement jsonElement = new Gson().toJsonTree(list);
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        for (JsonElement element : asJsonArray) {
            System.out.println(element);
        }
    }

}
