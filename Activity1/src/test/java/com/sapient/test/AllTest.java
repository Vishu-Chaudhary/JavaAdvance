package com.sapient.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ArmstrongTest.class, Cel2FerTest.class, DuplicateTest.class, LeapYearTest.class})
public class AllTest {

}
