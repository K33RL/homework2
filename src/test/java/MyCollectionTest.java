import com.homework.MyCollection;
import org.junit.Test;

/**
 * Test class for {@link com.homework.MyCollection}
 */

public class MyCollectionTest {


    MyCollection<String> collection = new MyCollection<>();

    @Test
    public void addElements() {
        for (int i = 0; i < 10; i++) {
            collection.push("String:" + i);
        }
    }

    @Test
    public void getElement() {
        System.out.println(collection.get(1));
    }

    @Test
    public void pushElements() {
        while (collection.size() > 0) {
            String s = (String) collection.pull();
            System.out.println(s);
            System.out.println("Queue size: " + collection.size());
        }
    }
}
