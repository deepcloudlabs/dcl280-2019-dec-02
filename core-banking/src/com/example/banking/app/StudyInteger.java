package com.example.banking.app;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("unused")
public class StudyInteger {

	public static void main(String[] args) {
		int i = 42; // 4-byte
		Integer j = 42; // j: 4 + 12 (Object Header) + 4 = 20-byte
		Integer x = Integer.valueOf(108);
		Integer y = 108;
		Integer m = 549;
		Integer n = 549;
		y = m + 2 * n / x;
		y = Integer.valueOf(m.intValue() + 2 * n.intValue() / x.intValue());
		System.out.println("x==y: " + (x == y));
		System.out.println("m==n: " + (m == n));
		m++; // m =Integer.valueOf( m.intValue() + 1 )
		m = 42; // m= Integer.valueOf(42);
	}

}
