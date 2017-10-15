import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Filip on 2017-10-15.
 */
public class AccountTest {

    private static final Long ID = 3L;
    private static final double BALANCE = 3500.78;
    private Account testedObject;

    @Before
    public void setUp() throws Exception {
        testedObject = new Account();
        testedObject.setId(ID);
        testedObject.setBalance(BALANCE);
    }

    @Test
    public void shouldCreateObject() throws Exception {
        assertThat(testedObject).isNotNull();
        assertThat(testedObject.getId()).isEqualTo(3L);
        assertThat(testedObject.getBalance()).isEqualTo(3500.78);
    }
}
