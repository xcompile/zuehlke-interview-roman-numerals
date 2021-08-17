package com.zuhlke.interview.roman;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import com.zuhlke.interview.roman.exception.IllegalInputException;
import com.zuhlke.interview.roman.exception.UnknownNumeralException;

public class CodingChallengeRomanNumeralStreams {


	private final Map<Character, Integer> mp;

	public CodingChallengeRomanNumeralStreams() {
		super();
		this.mp = new HashMap<Character,Integer>();
		mp.put('I', 1);
		mp.put('V', 5);
		mp.put('X', 10);
		mp.put('L', 50);
		mp.put('C', 100);
		mp.put('D', 500);
		mp.put('M', 1000);
	}

	public int romanToInteger(String romanNumerals) {
		validateInput(romanNumerals);


		int limit = romanNumerals.length();

		return IntStream.iterate(0,i -> i+1 )
				.limit(limit)
				// cut out tuples
				.mapToObj(i -> romanNumerals.substring(
						i,
						Math.min(
								i+2,romanNumerals.length()
								)
						)
						)
				// transform tuples to integer values
				.mapToInt(romanSymbolTuple ->
				{
					Integer currValue = mp.getOrDefault(romanSymbolTuple.charAt(0), -1);
					Integer nextValue = (romanSymbolTuple.length() > 1) ?
							mp.getOrDefault(romanSymbolTuple.charAt(1), -1)
							: 0;

					if (-1 == currValue || -1== nextValue  ) {
						throw new UnknownNumeralException();
					}

					if (currValue >= nextValue){
						return currValue;
					} else {
						return -1 * currValue;
					}
				}
						)
				.sum();

	}

	private void validateInput(String romanNumeral) {
		if (null == romanNumeral) {
			throw new IllegalInputException("illegal input");
		}

	}



}
