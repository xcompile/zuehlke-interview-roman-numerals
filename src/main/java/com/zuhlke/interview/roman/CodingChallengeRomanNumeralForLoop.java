package com.zuhlke.interview.roman;

import com.zuhlke.interview.roman.exception.IllegalInputException;
import com.zuhlke.interview.roman.exception.UnknownNumeralException;

public class CodingChallengeRomanNumeralForLoop {
	enum RomanSymbol {
		I(1),
		V(5),
		X(10),
		L(50),
		C(100),
		D(500),
		M(1000);

		private final int value;

		RomanSymbol(int j) {
			this.value = j;
		}

		public int getValue() {
			return this.value;
		}

		public static RomanSymbol valueOf(char c) {

			return RomanSymbol.valueOf(Character.toString(c));
		}

	}

	public int romanToInteger(String romanNumerals) {
		validateInput(romanNumerals);

		int number = 0;
		char[] numerals = romanNumerals.toCharArray();
		int length = numerals.length;
		try {
			for (int i =0; i< length;++i) {
				int currValue = RomanSymbol
						.valueOf(romanNumerals.charAt(i))
						.getValue();

				if (i+1==length 
						|| currValue >= RomanSymbol.valueOf(
								romanNumerals.charAt(i+1)
								).getValue()
						) {
					number += currValue;
				} else {
					number -= currValue;
				}

			}
		} catch(IllegalArgumentException ex) {
			throw new UnknownNumeralException(
					ex.getMessage()
			);


		}
		return number;

	}
	
	private void validateInput(String romanNumeral) {
		if (null == romanNumeral) {
			throw new IllegalInputException("illegal input");
		}

	}



}
