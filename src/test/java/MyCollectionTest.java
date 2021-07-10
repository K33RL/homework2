import com.homework.MyCollection;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

/**
 * Test class for {@link com.homework.MyCollection}
 */
@Log4j
public class MyCollectionTest {

    private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(MyCollectionTest.class);

    MyCollection<String> collection = new MyCollection<>();

    @Test
    public void addElements() {
        for (int i = 0; i < 10; i++) {
            collection.push("String:" + i);
        }
    }

    @Test
    public void getElement() {
        addElements();
        System.out.println(collection.get(1));
    }

    @Test
    public void pushElements() {
        addElements();
        while (collection.size() > 0) {
            String s = (String) collection.pull();
        }
    }

    @Test(expected = Exception.class)
    public void getEx(){
        addElements();
        System.out.println(collection.get(12));
    }
}
