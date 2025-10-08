package com.camelion.testing.mocking;

import com.camelion.testing.enums.CamelionTestBehavior;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MockCalculationServiceTest {

  @Test
  void testPassingTestBehaviour() throws Exception {
    MockCalculationService service = new MockCalculationService(CamelionTestBehavior.PASSING_TEST);
    int result = service.addTwoTo(3);
    assertEquals(5, result, "PASSING_TEST should return value + 2");
  }

  @Test
  void testFailingTestBehaviour() throws Exception {
    MockCalculationService service = new MockCalculationService(CamelionTestBehavior.FAILING_TEST);
    int result = service.addTwoTo(3);
    assertTrue(result < 0, "FAILING_TEST should return a negative value");
  }

  @Test
  void testThrowsExceptionsBehaviour() {
    MockCalculationService service = new MockCalculationService(CamelionTestBehavior.THROWS_EXCEPTIONS);
    assertThrows(Exception.class, () -> service.addTwoTo(3),
        "THROWS_EXCEPTIONS should throw an Exception");
  }
}

