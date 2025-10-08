package com.camelion.testing.mocking;

import com.camelion.testing.enums.CamelionTestBehavior;
import com.camelion.testing.service.CalculationService;

public class MockCalculationService implements CalculationService {

  private final CamelionTestBehavior behaviour;

  // Private default constructor
  private MockCalculationService() {
    this.behaviour = CamelionTestBehavior.PASSING_TEST;
  }

  // Public constructor with behaviour parameter
  public MockCalculationService(CamelionTestBehavior behaviour) {
    this.behaviour = behaviour;
  }

  @Override
  public int addTwoTo(int value) throws Exception {
    switch (behaviour) {
      case PASSING_TEST:
        return value + 2;
      case FAILING_TEST:
        return -1 * Math.abs(value + 2);
      case THROWS_EXCEPTIONS:
        throw new Exception("Simulated exception for testing");
      default:
        return value;
    }
  }
}

