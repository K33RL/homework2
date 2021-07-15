import com.homework.EmptyQueueException;
import com.homework.MyCollection;
import com.homework.MyException;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link com.homework.MyCollection}
 */

@Log4j2
public class MyCollectionTest {

    MyCollection<String> collection = new MyCollection<>();

    @Before
    @Test
    public void pushElements() {
        for (int i = 0; i < 10; i++) {
            collection.push("String:" + i);
        }
    }

    @Test
    public void removeAllTest(){
        collection.removeAll();
    }


    @Test
    public void getElement() {
        Assert.assertNotNull(collection.get(1));
        Assert.assertNotNull(collection.get(7));
        Assert.assertNotNull(collection.get(6));
        Assert.assertNotNull(collection.get(5));
        Assert.assertNotNull(collection.get(4));
        Assert.assertNotNull(collection.get(3));
        Assert.assertNotNull(collection.get(2));
    }

    @Test
    public void pullElements() {
        while (collection.size() > 0) {
            String s = (String) collection.pull();
        }

    }

    @Test(expected = EmptyQueueException.class)
    public void removeExceptionTest(){
        log.error("MyException here : " + Thread.currentThread().getStackTrace()[1].getMethodName(), Level.INFO);
        collection.removeAll();
        collection.removeAll();
    }

    @Test(expected = MyException.class)
    public void MyExceptionTest() {
        log.error("MyException here : " + Thread.currentThread().getStackTrace()[1].getMethodName(), Level.INFO);
        System.out.println(collection.get(12));
    }
}
