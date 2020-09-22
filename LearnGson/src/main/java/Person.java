import lombok.Data;

/**
 * @ClassName : Person
 * @Description : domain
 * @Author : wanzepeng
 * @Date: 2020-09-22 17:02
 */
@Data
public class Person {
    private int age;
    private String name;
    private double money;
    private Person person;
}
