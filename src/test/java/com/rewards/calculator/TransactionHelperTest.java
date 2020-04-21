package com.rewards.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.rewards.calculator.helper.TransactionHelper;

@RunWith(SpringRunner.class)
public class TransactionHelperTest {
    
    @Test
    public void calculateRewardTest() throws Exception {
	TransactionHelper helper = new TransactionHelper();
	Double reward = helper.calculateRewards(115.0);
	assertEquals(reward, Double.valueOf(80.0));
	
	reward = helper.calculateRewards(25.0);
	assertEquals(reward, Double.valueOf(0.0));
	
	reward = helper.calculateRewards(120.0);
	assertEquals(reward, Double.valueOf(90.0));
	helper.close();
	
    }
}
