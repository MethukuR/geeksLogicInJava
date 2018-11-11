import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.buildingLogic.arraySpecial.SecondMaxInArray;

/**
 * @author Raju
 *
 */
public class SecondMaxInArrayTest {
	//private SecondMaxInArray secondMaxInArrayTest;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//secondMaxInArrayTest=new SecondMaxInArray();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link SecondMaxInArray#findSecondLargestOne(int[])}.
	 */
	@Test
	public void testFindSecondLargestOne() {
		int[] inputArr={6,2,1,3,0,4};
		int result=SecondMaxInArray.findSecondLargestOne(inputArr);
		assertEquals(4, result);
	}

}
