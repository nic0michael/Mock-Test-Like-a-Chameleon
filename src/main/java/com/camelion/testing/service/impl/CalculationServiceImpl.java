package com.camelion.testing.service.impl;

import com.camelion.testing.service.CalculationService;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CalculationServiceImpl implements CalculationService {

  @Override
  public int addTwoTo(int value) {
    return value + 2;
  }
}
