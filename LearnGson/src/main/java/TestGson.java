import com.google.gson.Gson;
import org.junit.Test;

/**
 * @ClassName : TestGson
 * @Description : gson使用
 * @Author : wanzepeng
 * @Date: 2020-09-22 17:02
 */
public class TestGson {
    Person wzp = new Person();
    Person zyp = new Person();

    {
        wzp.setAge(25);
        wzp.setMoney(10000000000.0);
        wzp.setName("wzp");
        wzp.setPerson(zyp);

        zyp.setAge(25);
        zyp.setMoney(1.0);
        zyp.setName("zyp");
    }

    @Test
    public void convertJsonToDao(){
        Gson gson = new Gson();
        //实体类转json
        String personJson = gson.toJson(wzp);
        System.out.println(personJson);
        //json转实体类
        Person wzp = gson.fromJson(personJson,Person.class);
        System.out.println(wzp);
    }


}
