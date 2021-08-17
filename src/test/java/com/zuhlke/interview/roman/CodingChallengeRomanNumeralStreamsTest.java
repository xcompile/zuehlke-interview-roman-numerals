package com.zuhlke.interview.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.zuhlke.interview.roman.exception.IllegalInputException;
import com.zuhlke.interview.roman.exception.UnknownNumeralException;

public class CodingChallengeRomanNumeralStreamsTest {
 
	private CodingChallengeRomanNumeralStreams challenge;

	@BeforeEach
	public void beforeEach() {
		this.challenge = new CodingChallengeRomanNumeralStreams();
	}
    
    @Test
    public void illegalInputShouldThrowRuntimeException() {
    	Assertions.assertThrows(IllegalInputException.class, () -> challenge.romanToInteger(null));
    }
    
    @Test
    public void illegalNumeralShouldThrowRuntimeException() {
    	Assertions.assertThrows(UnknownNumeralException.class, () -> challenge.romanToInteger("IIjI"));
    }
    
    
    @Test
    public void romanIShouldConvertTo1() {
    	Assertions.assertEquals(1, challenge.romanToInteger("I"));
    }
    
    @Test
    public void ifRomanNumeralWithLowerOrderComesFirstApplySubstraction() {
    	Assertions.assertEquals(4, challenge.romanToInteger("IV"));
    }
    
    @Test
    public void ifRomanNumeralWithHigherOrSameOrderComesFirstApplyAddition() {
    	Assertions.assertAll(
    			"higher or same order numeral applies addition",
    			() -> Assertions.assertEquals(2, challenge.romanToInteger("II")),
    			() -> Assertions.assertEquals(6, challenge.romanToInteger("VI")),
    			() -> Assertions.assertEquals(18, challenge.romanToInteger("XVIII"))
    			
    			
    			);
    }
    

	@Test
	public void verifyLargestRomanNumberCanTransformCorrectly() {
		Assertions.assertEquals(3999, challenge.romanToInteger("MMMCMXCIX"));
	}
    
    
}
